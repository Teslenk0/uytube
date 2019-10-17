/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import DataTypes.DtVideo;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author esteban
 */
@Entity
@Table(name = "videos_canal")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "nombre")
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "nombre_canal")
    private Canal canal;

    @Column(name = "fecha_publicacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPublicacion;
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "duracion")
    private String duracion;

    @Column(name = "isPrivate")
    private Boolean privado;
    
    public Video(){
    }

    public Video(String nombre, Canal canal, Date fechaPublicacion, String url, String descripcion, String categoria, String duracion, Boolean privado) {
        this.nombre = nombre;
        this.canal = canal;
        this.fechaPublicacion = fechaPublicacion;
        this.url = url;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.duracion = duracion;
        this.privado = privado;
    }
    
    public Video(DtVideo v){
        this.nombre = v.getNombre();
        this.canal = new Canal (v.getCanal());
        this.fechaPublicacion = v.getFechaPublicacion();
        this.url = v.getUrl();
        this.descripcion = v.getDescripcion();
        this.categoria = v.getCategoria();
        this.duracion = v.getDuracion();
        this.privado = v.getPrivado();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDuracion() {
        return duracion;
    }
    
    public Boolean getPrivado() {
        return privado;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.canal);
        hash = 53 * hash + Objects.hashCode(this.fechaPublicacion);
        hash = 53 * hash + Objects.hashCode(this.url);
        hash = 53 * hash + Objects.hashCode(this.descripcion);
        hash = 53 * hash + Objects.hashCode(this.categoria);
        hash = 53 * hash + Objects.hashCode(this.duracion);
        hash = 53 * hash + Objects.hashCode(this.privado);
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
        final Video other = (Video) obj;
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
        return Objects.equals(this.privado, other.privado);
    }

    @Override
    public String toString() {
        return "Video{" + "nombre=" + nombre + ", canal=" + canal.getNombre_canal() + '}';
    }
}
