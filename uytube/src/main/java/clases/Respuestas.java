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
@Table( name = "respuestas_comentarios")
public class Respuestas implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column (name = "nickname")
    private String nick;
    
    @Column (name = "respuesta")
    private String respuesta;
    
    @Column (name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn (name = "comentario")
    private Comentario com;

    public Respuestas() {
    }

    public Respuestas(String nick, String respuesta, Date fecha, Comentario com) {
        this.nick = nick;
        this.respuesta = respuesta;
        this.fecha = fecha;
        this.com = com;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Comentario getCom() {
        return com;
    }

    public void setCom(Comentario com) {
        this.com = com;
    }
    
}
