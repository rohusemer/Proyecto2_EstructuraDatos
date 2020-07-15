/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Luis A. Sarango-Parrales
 */
public abstract class Persistencia {

    private String[] readAllText(String ruta) { // cada linea es una pregunta
        StringBuilder sb = new StringBuilder();
        try {
            Files.lines(Paths.get(ruta)).forEach(linea -> {
                sb.append(linea + "\n");
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return (sb.toString()).split("\n");
    }

    public String[] obtenerPreguntas(String path) {
        return readAllText(path);
    }

    public Map<String, String> obtenerAnimalesRptas(String path) {
        Map<String, String> mapa = new HashMap();
        for (String linea : readAllText(path)) {
            String[] line = linea.split(" ");
            mapa.put(line[0], String.join(" ", Arrays.copyOfRange(line, 1, line.length)));
        }
        return mapa;
    }

    /*protected void writeAllText(String text, String fileout) {
    try {
    pw = new PrintWriter(fileout);
    } catch (FileNotFoundException ex) {
    ex.printStackTrace();
    }
    pw.print(text);
    pw.close();
    }*/
 /* protected boolean isLineContained(String[] lineas, String line) {
    for (String linea : lineas) {
    if (linea.equals(line)) {
    return true;
    }
    }
    return false;
    }*/
    // public abstract void create(E element);
    //public abstract String read(String id);
    //public abstract void update(E element);
    //public abstract void delete(String element);
}
