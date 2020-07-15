/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis A. Sarango-Parrales
 */
public class PrincipalController implements Initializable {

    @FXML
    private Button btnSi;
    @FXML
    private Button btnNo;
    @FXML
    private Label lbPregunta;

    private Iterator<String> it;

    public static StringBuilder input;

    private int count;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        input = new StringBuilder();
        count = 0;
        String[] preguntas = InicioController.partida.getPreguntas();
        it = Arrays.stream(preguntas).iterator();
        lbPregunta.setText(it.next());
        count++;

    }

    @FXML
    private void yes(ActionEvent event) {
        input.append("Si ");
        if (it.hasNext() && count != InicioController.partida.getNroPreguntas()) {
            count++;
            lbPregunta.setText(it.next());

        } else {
            try {
                Pane principal = (Pane) new FXMLLoader(getClass().getResource("/Vista/resultado.fxml")).load();
                Stage secondStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                secondStage.setTitle("Animals Founded");
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

    @FXML
    private void no(ActionEvent event) {
        input.append("No ");
        if (it.hasNext() && count != InicioController.partida.getNroPreguntas()) {

            count++;
            lbPregunta.setText(it.next());

        } else {

            try {
                Pane principal = (Pane) new FXMLLoader(getClass().getResource("/Vista/resultado.fxml")).load();
                Stage secondStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                secondStage.setTitle("Animals Founded");
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

}
