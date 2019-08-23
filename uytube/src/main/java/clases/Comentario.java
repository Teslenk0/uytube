/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author esteban
 */
public class Comentario implements Serializable{
    
    protected static final long serialVersionUID = 1L; 
    
    protected String comentario;
    
    protected Set<Comentario> comentarios;
    
    protected Date fecha;

    public Comentario(String comentario, Set<Comentario> comentarios, Date fecha) {
        this.comentario = comentario;
        this.comentarios = comentarios;
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Comentario{" + "comentario=" + comentario + ", comentarios=" + comentarios + ", fecha=" + fecha + '}';
    }
    
}
