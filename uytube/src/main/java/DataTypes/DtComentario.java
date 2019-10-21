/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Comentario;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author esteban
 */
public class DtComentario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private final String nick;
    
    private final String comentario;
    
    private final Date fecha;
    
    private final DtVideo video;
    
    private final String padre;

    private final Integer ref;
    
    private final String canal;
    
    public DtComentario(String nick, String comentario, Date fecha, DtVideo video, String padre, Integer ref, String canal) {
        this.nick = nick;
        this.comentario = comentario;
        this.fecha = fecha;
        this.video = video;
        this.padre = padre;
        this.ref = ref;
        this.canal = canal;
    }
    
    public DtComentario(Comentario c){
        this(c.getNick(), c.getComentario(), c.getFecha(), new DtVideo(c.getVideo()), c.getPadre(), c.getRef(), c.getCanal());
    }

    public String getPadre() {
        return padre;
    }

    public Integer getRef() {
        return ref;
    }
    
    public String getComentario() {
        return comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNick() {
        return nick;
    }

    public DtVideo getVideo() {
        return video;
    }

    public String getCanal() {
        return canal;
    }
}
