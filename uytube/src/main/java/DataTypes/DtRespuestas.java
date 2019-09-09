/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Comentario;
import clases.Respuestas;
import java.util.Date;

/**
 *
 * @author esteban
 */
public class DtRespuestas {
    
    private String nick;
    
    private String respuesta;
    
    private Date fecha;
    
    private DtComentario com;

    public DtRespuestas(String nick, String respuesta, Date fecha, DtComentario com) {
        this.nick = nick;
        this.respuesta = respuesta;
        this.fecha = fecha;
        this.com = com;
    }
    
    public DtRespuestas(Respuestas r){
        this(r.getNick(), r.getRespuesta(), r.getFecha(), new DtComentario(r.getCom()));
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

    public DtComentario getCom() {
        return com;
    }
    
    
    
}
