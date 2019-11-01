/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author esteban
 */
public class DtauxComentarios implements Serializable{

    private static final long serialVersionUID = 1L; 
    
    private String nick;
    
    private String comentario;
    
    private Date fecha;
    
    private String video;
    
    private String padre;
    
    private Integer ref;
    
    private String canal;

    public DtauxComentarios() {
    }

    public DtauxComentarios(String nick, String comentario, Date fecha, String video, String padre, Integer ref, String canal) {
        this.nick = nick;
        this.comentario = comentario;
        this.fecha = fecha;
        this.video = video;
        this.padre = padre;
        this.ref = ref;
        this.canal = canal;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNick() {
        return nick;
    }

    public String getComentario() {
        return comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getVideo() {
        return video;
    }

    public String getPadre() {
        return padre;
    }

    public Integer getRef() {
        return ref;
    }

    public String getCanal() {
        return canal;
    }


}

