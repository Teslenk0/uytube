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
public class PkVideo implements Serializable{
    
    private String nombreVideo;
    
    private String nombreCanal;

    public PkVideo(String nombreVideo, String nombreCanal) {
        this.nombreVideo = nombreVideo;
        this.nombreCanal = nombreCanal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nombreVideo);
        hash = 23 * hash + Objects.hashCode(this.nombreCanal);
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
        final PkVideo other = (PkVideo) obj;
        if (!Objects.equals(this.nombreVideo, other.nombreVideo)) {
            return false;
        }
        if (!Objects.equals(this.nombreCanal, other.nombreCanal)) {
            return false;
        }
        return true;
    }
    
    
}
