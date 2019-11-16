/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.VideoEliminado;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author isaac
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtVideoEliminado implements Serializable{
        
    private static final long serialVersionUID = 1L; 

    private Integer id;

    private String nombre;

    private Date fechaPublicacion;

    private String url;

    private String descripcion;

    private String categoria;

    private String duracion;

    private boolean privado;

    public DtVideoEliminado() {
    }

    public DtVideoEliminado(Integer id, String nombre, Date fechaPublicacion, String url, String descripcion, String categoria, String duracion, boolean privado) {
        this.id = id;
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
        this.url = url;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.duracion = duracion;
        this.privado = privado;
    }
    
    public DtVideoEliminado(VideoEliminado vi) {
        this.id = vi.getId().getId();
        this.nombre = vi.getNombre();
        this.fechaPublicacion = vi.getFechaPublicacion();
        this.url = vi.getUrl();
        this.descripcion = vi.getDescripcion();
        this.categoria = vi.getCategoria();
        this.duracion = vi.getDuracion();
        this.privado = vi.getPrivado();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getUrl() {
        return url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDuracion() {
        return duracion;
    }

    public boolean isPrivado() {
        return privado;
    }

   
}
