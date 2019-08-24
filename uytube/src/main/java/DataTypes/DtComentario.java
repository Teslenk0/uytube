/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Comentario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author esteban
 */
public class DtComentario implements Serializable {
    
    protected static final long serialVersionUID = 1L;
    
    protected String comentario;
    
    protected List<Comentario> comentarios;
    
    protected Date fecha;

    public DtComentario(String comentario, List<Comentario> comentarios, Date fecha) {
        this.comentario = comentario;
        this.comentarios = comentarios;
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public Date getFecha() {
        return fecha;
    }
    
}
