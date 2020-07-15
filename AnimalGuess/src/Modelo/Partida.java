/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Persistencia.Persistencia;
import java.util.Map;

/**
 *
 * @author Luis A. Sarango-Parrales
 */
public class Partida extends Persistencia {

    private String preguntas[];
    private Map<String, String> animalesRptas;
    private BinaryTree<DecisionContent> arbolDecision;
    private Integer nroPreguntas;

    public String[] getPreguntas() {
        return preguntas;
    }

    public Map<String, String> getAnimalesRptas() {
        return animalesRptas;
    }

    public void setAnimalesRptas(Map<String, String> animalesRptas) {
        this.animalesRptas = animalesRptas;
    }

    public void setAnimalesRptas(String respuestas_path) {
        this.animalesRptas = obtenerAnimalesRptas(respuestas_path);;
    }

    public BinaryTree<DecisionContent> getArbolDecision() {
        return arbolDecision;
    }

    public void setArbolDecision(BinaryTree<DecisionContent> arbolDecision) {
        this.arbolDecision = arbolDecision;
    }

    public Integer getNroPreguntas() {
        return nroPreguntas;
    }

    public void setNroPreguntas(Integer nroPreguntas) {
        this.nroPreguntas = nroPreguntas;
    }

    public void setPreguntas(String[] preguntas) {
        this.preguntas = preguntas;
    }

    public void setPreguntas(String preguntas_path) {
        this.preguntas = obtenerPreguntas(preguntas_path);
    }

}
