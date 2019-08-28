/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Categoria;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author esteban
 */
public class DtVideo implements Serializable{
        
      private static final long serialVersionUID = 1L; 
     
      private final  String nombre;
      
      private final String descripcion;
      
      private final int duracion;
      
      private final Date fechaPublicacion;
      
      private final String url;
      
      private final boolean privado;
      
      private final Categoria cat;

    public DtVideo(String nombre, String descripcion, int duracion, Date fechaPublicacion, String url, boolean privado, Categoria cat) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaPublicacion = fechaPublicacion;
        this.url = url;
        this.privado = privado;
        this.cat = cat;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getUrl() {
        return url;
    }

    public boolean isPrivado() {
        return privado;
    }

    public Categoria getCat() {
        return cat;
    }
      
      
}
