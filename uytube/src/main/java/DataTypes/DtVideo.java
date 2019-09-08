/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Video;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author esteban
 */
public class DtVideo implements Serializable{
        
      private static final long serialVersionUID = 1L; 
     
      private final  String nombre;
      
      private final DtCanal canal;
      
      private final Date fechaPublicacion;
      
      private final String url;
      
      private final String descripcion;
      
      private final String categoria;
      
      private final String duracion;
      
      private final boolean privado;

    public DtVideo(String nombre, DtCanal canal, Date fechaPublicacion, String url, String descripcion, String categoria, String duracion, boolean privado) {
        this.nombre = nombre;
        this.canal = canal;
        this.fechaPublicacion = fechaPublicacion;
        this.url = url;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.duracion = duracion;
        this.privado = privado;
    }

    public DtVideo(Video v) {
        this(v.getNombre(), new DtCanal(v.getCanal().getNombre_canal(), v.getCanal().getDescripcion(), v.getCanal().getPrivado()), v.getFechaPublicacion(), v.getUrl(), v.getDescripcion(), v.getCategoria(), v.getDuracion(), v.getPrivado());
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNombre() {
        return nombre;
    }

    public DtCanal getCanal() {
        return canal;
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

    public boolean getPrivado() {
        return privado;
    }
    
}
