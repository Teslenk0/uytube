/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Valorar;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author caste
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtValorar implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private final DtUsuario duenio;
    
    private final String vid;
     
    private final String user;
    
    private final String val;

    public DtValorar(DtUsuario dueño, String vid, String user, String val) {
        this.duenio = dueño;
        this.vid = vid;
        this.user = user;
        this.val = val;
    }
    
    public DtValorar(Valorar v) {
        this.duenio = new DtUsuario (v.getDuenio());
        this.vid = v.getVid();
        this.user = v.getUser();
        this.val = v.getVal();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public DtUsuario getDuenio() {
        return duenio;
    }

    public String getVid() {
        return vid;
    }

    public String getUser() {
        return user;
    }

    public String getVal() {
        return val;
    }    
    
}
