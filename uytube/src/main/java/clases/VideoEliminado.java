/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author isaac
 */
@Entity
@Table(name = "videos_eliminado")
public class VideoEliminado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(targetEntity = UsuarioEliminado.class)
    @JoinColumn(name = "id")
    private UsuarioEliminado id;
    
    @Id
    @Column(name = "nombre")
    private String nombre;

    @Id
    @Column(name = "fecha_publicacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPublicacion;
    
    @Id
    @Column(name = "url")
    private String url;
    
    @Id
    @Column(name = "descripcion")
    private String descripcion;

    @Id
    @Column(name = "categoria")
    private String categoria;
    
    @Id
    @Column(name = "duracion")
    private String duracion;

    @Id
    @Column(name = "isPrivate")
    private Boolean privado;
    
    public VideoEliminado(){
    }

    public VideoEliminado(UsuarioEliminado id, String nombre, Date fechaPublicacion, String url, String descripcion, String categoria, String duracion, Boolean privado) {
        this.id = id;
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
        this.url = url;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.duracion = duracion;
        this.privado = privado;
    }

    public UsuarioEliminado getId() {
        return id;
    }

    public void setId(UsuarioEliminado id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.nombre);
        hash = 19 * hash + Objects.hashCode(this.fechaPublicacion);
        hash = 19 * hash + Objects.hashCode(this.url);
        hash = 19 * hash + Objects.hashCode(this.descripcion);
        hash = 19 * hash + Objects.hashCode(this.categoria);
        hash = 19 * hash + Objects.hashCode(this.duracion);
        hash = 19 * hash + Objects.hashCode(this.privado);
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
        final VideoEliminado other = (VideoEliminado) obj;
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fechaPublicacion, other.fechaPublicacion)) {
            return false;
        }
        return Objects.equals(this.privado, other.privado);
    }

    @Override
    public String toString() {
        return "VideoEliminado{" + "id=" + id + ", nombre=" + nombre + ", fechaPublicacion=" + fechaPublicacion + ", url=" + url + ", descripcion=" + descripcion + ", categoria=" + categoria + ", duracion=" + duracion + ", privado=" + privado + '}';
    }

}
