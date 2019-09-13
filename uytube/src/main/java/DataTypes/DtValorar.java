/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.io.Serializable;

/**
 *
 * @author caste
 */
public class DtValorar implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private final DtUsuario dueño;
    
    private final String vid;
     
    private final String user;
    
    private final String val;

    public DtValorar(DtUsuario dueño, String vid, String user, String val) {
        this.dueño = dueño;
        this.vid = vid;
        this.user = user;
        this.val = val;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public DtUsuario getDueño() {
        return dueño;
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
