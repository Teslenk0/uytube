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
 * @author esteban
 */
public class AuxiliarValorar implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String duenio;
    
    private String vid;
    
    private String user;
    
    private String val;

    public AuxiliarValorar(String duenio, String vid, String user, String val) {
        this.duenio = duenio;
        this.vid = vid;
        this.user = user;
        this.val = val;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.duenio);
        hash = 71 * hash + Objects.hashCode(this.vid);
        hash = 71 * hash + Objects.hashCode(this.user);
        hash = 71 * hash + Objects.hashCode(this.val);
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
        final AuxiliarValorar other = (AuxiliarValorar) obj;
        if (!Objects.equals(this.duenio, other.duenio)) {
            return false;
        }
        if (!Objects.equals(this.vid, other.vid)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return Objects.equals(this.val, other.val);
    }
    
    
    
}
