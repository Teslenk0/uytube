/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "valorar")

public class Valorar implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "dueño_Vid")
    private Usuario dueño;
    
    @Column(name = "video")
    private String vid;
    
    @Column(name = "usuario")
    private String user;
    
    @Column(name = "valoracion")
    private String val;

    public Valorar() {
    }

    public Valorar(Usuario dueño, String vid, String user, String val) {
        this.dueño = dueño;
        this.vid = vid;
        this.user = user;
        this.val = val;
    }

    public Usuario getDueño() {
        return dueño;
    }

    public void setDueño(Usuario dueño) {
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

    @Override
    public String toString() {
        return "Valorar{" + "due\u00f1o=" + dueño + ", vid=" + vid + ", user=" + user + ", val=" + val + '}';
    }
    
}
