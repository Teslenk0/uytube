/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Video;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author esteban
 */
public class DtVideo implements Serializable, Comparable<DtVideo>{
        
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
        this.nombre = v.getNombre();
        this.canal = new DtCanal(v.getCanal().getNombre_canal(), v.getCanal().getDescripcion(), v.getCanal().getPrivado());
        this.fechaPublicacion = v.getFechaPublicacion();
        this.url = v.getUrl();
        this.descripcion = v.getDescripcion();
        this.categoria = v.getCategoria();
        this.duracion = v.getDuracion();
        this.privado = v.getPrivado();
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.canal);
        hash = 59 * hash + Objects.hashCode(this.fechaPublicacion);
        hash = 59 * hash + Objects.hashCode(this.url);
        hash = 59 * hash + Objects.hashCode(this.descripcion);
        hash = 59 * hash + Objects.hashCode(this.categoria);
        hash = 59 * hash + Objects.hashCode(this.duracion);
        hash = 59 * hash + (this.privado ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DtVideo other = (DtVideo) obj;
        if (this.privado != other.privado) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.duracion, other.duracion)) {
            return false;
        }
        if (!Objects.equals(this.canal, other.canal)) {
            return false;
        }
        if (!Objects.equals(this.fechaPublicacion, other.fechaPublicacion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DtVideo{" + "nombre=" + nombre + '}';
    }
    
   @Override
    public int compareTo(DtVideo other) {
     return this.nombre.compareTo(other.nombre);
   }
    
}
