/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author esteban
 */

   public class Video implements Serializable{
        
      private static final long serialVersionUID = 1L; 
     
      private String nombre;
      
      private String descripcion;
      
      private int duracion;
      
      private Date fechaPublicacion;
      
      private String url;
      
      private boolean privado;
      
      private Categoria cat;

    public Video(String nombre, String descripcion, int duracion, Date fechaPublicacion, String url, boolean privado, Categoria cat) {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Video{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", duracion=" + duracion + ", fechaPublicacion=" + fechaPublicacion + ", url=" + url + ", privado=" + privado + ", cat=" + cat + '}';
    }

}

