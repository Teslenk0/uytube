/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Comentario;
import java.util.Date;

/**
 *
 * @author esteban
 */
public class DtRespuestas {
    
    private String nick;
    
    private String respuesta;
    
    private Date fecha;
    
    private Comentario com;

    public DtRespuestas(String nick, String respuesta, Date fecha, Comentario com) {
        this.nick = nick;
        this.respuesta = respuesta;
        this.fecha = fecha;
        this.com = com;
    }

    public String getNick() {
        return nick;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public Date getFecha() {
        return fecha;
    }

    public Comentario getCom() {
        return com;
    }
    
    
    
}
