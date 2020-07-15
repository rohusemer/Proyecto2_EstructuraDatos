/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.BinaryTree;
import Modelo.DecisionContent;
import Modelo.Extra.Extra;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis A. Sarango-Parrales
 */
public class ResutadosController implements Initializable {

    @FXML
    private Label lblPreg;
    @FXML
    private Button btnTryAgain;
    @FXML
    private ListView<String> resultsListView;

    private ObservableList<String> items;

    private BinaryTree<DecisionContent> decisionTree;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        items = FXCollections.observableArrayList();
        decisionTree = InicioController.partida.getArbolDecision();
        System.out.println(PrincipalController.input.toString().trim());
        List<String> resultados = decisionTree.getResults(PrincipalController.input.toString().trim());
        items.setAll(resultados);
        resultsListView.getItems().setAll(items);
        Extra.generarFlashLabel(lblPreg, Integer.MAX_VALUE);

    }

    @FXML
    private void VolverInicio(ActionEvent event) {
        try {
            Pane principal = (Pane) new FXMLLoader(getClass().getResource("/Vista/inicio.fxml")).load();
            Stage secondStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            secondStage.setTitle("Guess Game");
            Scene scene = new Scene(principal);
            scene.getStylesheets().add("/Vista/css/style.css");
            secondStage.setScene(scene);
            secondStage.setResizable(false);
            secondStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
