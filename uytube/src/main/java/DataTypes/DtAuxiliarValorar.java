/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.AuxiliarValorar;
import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author esteban
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtAuxiliarValorar implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String duenio;
    
    private String vid;
     
    private String user;
    
    private String val;

    public DtAuxiliarValorar() {
    }

    public DtAuxiliarValorar(AuxiliarValorar v) {
        this.duenio = v.getDuenio();
        this.vid = v.getVid();
        this.user = v.getUser();
        this.val = v.getVal();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public DtAuxiliarValorar(String duenio, String vid, String user, String val) {
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
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.duenio);
        hash = 67 * hash + Objects.hashCode(this.vid);
        hash = 67 * hash + Objects.hashCode(this.user);
        hash = 67 * hash + Objects.hashCode(this.val);
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
        final DtAuxiliarValorar other = (DtAuxiliarValorar) obj;
        if (!Objects.equals(this.duenio, other.duenio)) {
            return false;
        }
        if (!Objects.equals(this.vid, other.vid)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.val, other.val)) {
            return false;
        }
        return true;
    }
 
}
