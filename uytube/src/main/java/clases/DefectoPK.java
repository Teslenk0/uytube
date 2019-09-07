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
  
    private Video video;

    public DefectoPK(int id, Video video) {
        this.id = id;
        this.video = video;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.video);
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
        return true;
    }
    
    
}
