/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author tesla
 */

public class DefectoPK implements Serializable{
   
    private int id;
  
    private String video;
    
    private String canal;

    public DefectoPK() {
    }

    public DefectoPK(int id, String video, String canal) {
        this.id = id;
        this.video = video;
        this.canal = canal;
    }
    
    public DefectoPK(int id, String video) {
        this.id = id;
        this.video = video;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.video);
        hash = 73 * hash + Objects.hashCode(this.canal);
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
        final DefectoPK other = (DefectoPK) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.video, other.video)) {
            return false;
        }
        if (!Objects.equals(this.canal, other.canal)) {
            return false;
        }
        return true;
    }

    
    
}
