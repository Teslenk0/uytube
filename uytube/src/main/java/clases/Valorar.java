/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Objects;
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
    private Usuario duenio;
    
    @Column(name = "video")
    private String vid;
    
    @Column(name = "usuario")
    private String user;
    
    @Column(name = "valoracion")
    private String val;

    public Valorar() {
    }

    public Valorar(Usuario dueño, String vid, String user, String val) {
        this.duenio = dueño;
        this.vid = vid;
        this.user = user;
        this.val = val;
    }

    public Usuario getDuenio() {
        return duenio;
    }

    public void setDuenio(Usuario duenio) {
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
    public String toString() {
        return "Valorar{" + "due\u00f1o=" + duenio + ", vid=" + vid + ", user=" + user + ", val=" + val + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.duenio);
        hash = 23 * hash + Objects.hashCode(this.vid);
        hash = 23 * hash + Objects.hashCode(this.user);
        hash = 23 * hash + Objects.hashCode(this.val);
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
        final Valorar other = (Valorar) obj;
        if (!Objects.equals(this.vid, other.vid)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.val, other.val)) {
            return false;
        }
        if (!Objects.equals(this.duenio, other.duenio)) {
            return false;
        }
        return true;
    }
    
    
    
}
