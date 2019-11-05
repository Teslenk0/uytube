/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author esteban
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtAuxiliar implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String comentario;
    
    private Integer referencia;
    
    private String padre;
    
    private String nick;
    
    private Date fecha;

    public DtAuxiliar() {
    }

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
