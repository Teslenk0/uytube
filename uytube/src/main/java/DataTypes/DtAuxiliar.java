/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.util.Date;

/**
 *
 * @author esteban
 */
public class DtAuxiliar {
    
    private final String comentario;
    
    private final Integer referencia;
    
    private final String padre;
    
    private final String nick;
    
    private final Date fecha;

    public DtAuxiliar(String comentario, Integer referencia, String padre, String nick, Date fecha) {
        this.comentario = comentario;
        this.referencia = referencia;
        this.padre = padre;
        this.nick = nick;
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNick() {
        return nick;
    }


    public String getPadre() {
        return padre;
    }
    
    public String getComentario() {
        return comentario;
    }

    public Integer getReferencia() {
        return referencia;
    }
}
