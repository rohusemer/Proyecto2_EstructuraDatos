/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Luis A. Sarango-Parrales
 */
public class DecisionContent {

    private String content;
    private String code;
    private boolean isAnimal;

    public DecisionContent(DecisionContent dc) {
        this.content = dc.content;
        this.isAnimal = dc.isAnimal;

    }

    public DecisionContent(String content, boolean isAnimal) {

        this.content = content;
        this.isAnimal = isAnimal;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isIsAnimal() {
        return isAnimal;
    }

    public void setIsAnimal(boolean isAnimal) {
        this.isAnimal = isAnimal;
    }

    @Override
    public String toString() {
        return "DecisionContent{" + "content=" + content + ", code=" + code + ", isAnimal=" + isAnimal + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.code);
        hash = 53 * hash + (this.isAnimal ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DecisionContent other = (DecisionContent) obj;
        if (this.isAnimal != other.isAnimal) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

}
