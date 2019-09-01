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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author esteban
 */
@Entity
@Table(name = "videos_canal")
@IdClass(PkVideo.class)
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "nombre")
    private String nombreVideo;

    @Id
    @OneToOne
    @JoinColumn(name = "nombre_canal")
    private Canal nombreCanal;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "fecha_publicacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPublicacion;

    @Column(name = "url")
    private String url;

    /*@Enumerated(EnumType.STRING)
    private Categoria cat;*/
    public Video() {
    }

    public Video(String nombreVideo, Canal nombreCanal, String descripcion, int duracion, Date fechaPublicacion, String url, Categoria cat) {
        this.nombreVideo = nombreVideo;
        this.nombreCanal = nombreCanal;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaPublicacion = fechaPublicacion;
        this.url = url;
        //this.cat = cat;
    }

    public String getNombreVideo() {
        return nombreVideo;
    }

    public void setNombreVideo(String nombreVideo) {
        this.nombreVideo = nombreVideo;
    }

    public Canal getNombreCanal() {
        return nombreCanal;
    }

    public void setNombreCanal(Canal nombreCanal) {
        this.nombreCanal = nombreCanal;
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

    /*public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }*/
    @Override
    public String toString() {
        return "Video{" + "nombreVideo=" + nombreVideo + ", nombreCanal=" + nombreCanal + ", descripcion=" + descripcion + ", duracion=" + duracion + ", fechaPublicacion=" + fechaPublicacion + ", url=" + url + '}';
    }
}
