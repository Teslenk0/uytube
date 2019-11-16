/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.ListaParticularVideosEliminados;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author isaac
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtListaParticularVideosEliminados implements Serializable {

    protected static final long serialVersionUID = 1L;

    private Integer id;

    private String nombre_video;

    public DtListaParticularVideosEliminados() {
    }

    public DtListaParticularVideosEliminados(Integer id, String nombre_video) {
        this.id = id;
        this.nombre_video = nombre_video;
    }
    
     public DtListaParticularVideosEliminados(ListaParticularVideosEliminados li) {
        this.id = li.getId().getId();
        this.nombre_video = li.getVideo();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre_video() {
        return nombre_video;
    }

}
