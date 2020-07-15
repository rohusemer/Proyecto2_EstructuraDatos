/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguess;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Luis A. Sarango-Parrales
 */
public class AnimalGuess extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/inicio.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/Vista/css/style.css");

        primaryStage.setTitle("Adivinador");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

        /*  
        System.out.println("Avance 1");
        System.out.println("Preguntas");
        for (String pregunta : p.getPreguntas()) {
        System.out.println(pregunta);
        
        }
        System.out.println();*/

 /* List<BinaryTree<DecisionContent>> results = arbolDecision.getResults("Si");
        System.out.println("Results of: Si");
        for (BinaryTree<DecisionContent> node : results) {
        System.out.println("animal: " + node);
        }
        System.out.println("Mapa de Animales-Respuestas");
        for (String animal : p.getAnimalesRptas().keySet()) {
            System.out.println("ANIMAL: " + animal + "  RESPUESTAS: " + p.getAnimalesRptas().get(animal));
        }
         */
 /*
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Piensa en un animal!!!");
        System.out.println("");
        int nroPreguntas = 0;

        boolean condicion = true;

        do {
            System.out.println("Ingrese la cantidad de preguntas (1-3): ");
            String input = sc.next();
            if (Extra.isNumeric(input)) {
                int n = Integer.parseInt(input);

                if (n >= 1 && n <= 3) {
                    nroPreguntas = Integer.parseInt(input);
                    condicion = false;
                }
            }

        } while (condicion);
        System.out.println("");

        boolean condicion2 = true;

        Partida p = new Partida(nroPreguntas, "", "");
        String[] preguntas = p.getPreguntas();

        for (int i = 0; i < nroPreguntas; i++) {
            condicion2 = true;
            String rpta = "";

            do {
                System.out.println(preguntas[i] + " (Si/No)");
                rpta = sc.next();
                System.out.println("");

                if (Extra.isBooleanAnswer(rpta)) {
                    condicion2 = false;
                }

            } while (condicion2);

            sb.append(rpta + " ");
        }

        BinaryTree<DecisionContent> arbolDecision = p.getArbolDecision();
        List<String> results = arbolDecision.getResults(sb.toString().trim());
        System.out.println("Resultados:");
        System.out.println("");
        for (String animal : results) {
            System.out.println("animal: " + animal);

        }

        if (results.isEmpty()) {
            System.out.println("Sin resultados");
        }
         */
    }

}
