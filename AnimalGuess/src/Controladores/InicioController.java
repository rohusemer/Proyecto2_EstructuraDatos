/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.BinaryTree;
import Modelo.DecisionContent;
import Modelo.Extra.Extra;
import Modelo.Partida;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis A. Sarango-Parrales
 */
public class InicioController implements Initializable {

    @FXML
    private Spinner<Integer> nbsQuestionsSpinner;
    @FXML
    private Button btnStartGame;
    @FXML
    private Button btnQuestionsFile;
    @FXML
    private Button btnAnswersFile;
    @FXML
    private Label lblValidate;

    private String qsts_path;

    private String anws_path;

    public static Partida partida;

    private BinaryTree<DecisionContent> decisionTree;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nbsQuestionsSpinner.setVisible(false);
        lblValidate.setVisible(false);
        partida = new Partida();
    }

    @FXML
    private void playPrincipal(ActionEvent event) {

        if (Extra.areFilesChoosed(qsts_path, anws_path)) {
            partida.setNroPreguntas(nbsQuestionsSpinner.getValue());
            decisionTree = new BinaryTree();

            partida.setArbolDecision(decisionTree.buildGameTree(partida.getPreguntas(), partida.getAnimalesRptas()));
            partida.getArbolDecision().inOrderIterative();

            try {
                Pane principal = (Pane) new FXMLLoader(getClass().getResource("/Vista/principal.fxml")).load();
                Stage secondStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                secondStage.setTitle("Guess Game");
                Scene scene = new Scene(principal, 950, 388);
                scene.getStylesheets().add("/Vista/css/style.css");
                secondStage.setScene(scene);
                secondStage.setResizable(false);
                secondStage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            Extra.generarFlashLabel(lblValidate, 3);
            lblValidate.setVisible(true);

        }

    }

    @FXML
    private void selectQuestionsFile(ActionEvent event) {
        if (!Extra.areFilesChoosed(qsts_path, anws_path)) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select questions file");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(null);
            qsts_path = file.getAbsolutePath();
            partida.setPreguntas(qsts_path);
            if (Extra.areFilesChoosed(qsts_path, anws_path)) {
                setSpinner(partida.getPreguntas().length);
            }
        }

    }

    @FXML
    private void selectAnwersFile(ActionEvent event) {
        if (!Extra.areFilesChoosed(qsts_path, anws_path)) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select anwsers file");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(null);
            anws_path = file.getAbsolutePath();
            partida.setAnimalesRptas(anws_path);
            if (Extra.areFilesChoosed(qsts_path, anws_path)) {
                setSpinner(partida.getPreguntas().length);
            }

        }

    }

    private void setSpinner(int n) {

        SpinnerValueFactory<Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, n);
        nbsQuestionsSpinner.setValueFactory(factory);
        // need this code because it would not editable 
        TextFormatter<Integer> formatter = new TextFormatter<>(factory.getConverter(), factory.getValue());
        nbsQuestionsSpinner.getEditor().setTextFormatter(formatter);
        nbsQuestionsSpinner.setVisible(true);
    }

}
