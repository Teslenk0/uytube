/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author esteban
 */
@Entity
@Table(name = "comentarios_video")
public class Comentario implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    @Id
    @Column(name = "nickname" )
    private String nick;
    
    @Column(name = "comentario")
    private String comentario;
    
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "Video")
    private Video video;
    
    @Column (name = "padre")
    private String padre;
    
    @Column (name = "Referencia")
    private Integer ref;
    
    @Column (name = "Canal_video")
    private String canal;
    
    public Comentario() {
    }

    public Comentario(String nick, String comentario, Date fecha, Video video, String padre, Integer ref, String canal) {
        this.nick = nick;
        this.comentario = comentario;
        this.fecha = fecha;
        this.video = video;
        this.padre = padre;
        this.ref = ref;
        this.canal = canal;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public Integer getRef() {
        return ref;
    }

    public void setRef(Integer ref) {
        this.ref = ref;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Comentario{" + "nick=" + nick + ", comentario=" + comentario + ", fecha=" + fecha + ", video=" + video + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.nick);
        hash = 73 * hash + Objects.hashCode(this.comentario);
        hash = 73 * hash + Objects.hashCode(this.fecha);
        hash = 73 * hash + Objects.hashCode(this.video);
        hash = 73 * hash + Objects.hashCode(this.padre);
        hash = 73 * hash + Objects.hashCode(this.ref);
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
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.nick, other.nick)) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        if (!Objects.equals(this.padre, other.padre)) {
            return false;
        }
        if (!Objects.equals(this.canal, other.canal)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.video, other.video)) {
            return false;
        }
        if (!Objects.equals(this.ref, other.ref)) {
            return false;
        }
        return true;
    }
    
    

    
}
