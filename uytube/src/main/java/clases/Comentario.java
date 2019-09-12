/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Date;
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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "Video")
    private Video video;
    
    @Column (name = "padre")
    private String padre;
    
    @Column (name = "Referencia")
    private Integer ref;
    
    @Column (name = "Canal_video")
    private Canal canal;
    
    public Comentario() {
    }

    public Comentario(String nick, String comentario, Date fecha, Video video, String padre, Integer ref, Canal canal) {
        this.nick = nick;
        this.comentario = comentario;
        this.fecha = fecha;
        this.video = video;
        this.padre = padre;
        this.ref = ref;
        this.canal = canal;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
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

    
}
