/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author esteban
 */
public class AuxiliarValorar implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String dueño;
    
    private String vid;
    
    private String user;
    
    private String val;

    public AuxiliarValorar(String dueño, String vid, String user, String val) {
        this.dueño = dueño;
        this.vid = vid;
        this.user = user;
        this.val = val;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
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
    
    
    
}
