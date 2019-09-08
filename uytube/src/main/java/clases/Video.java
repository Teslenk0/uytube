/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
}
