/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tesla
 */
@Entity
@Table(name = "lista_defecto_video")
@IdClass(DefectoPK.class)
public class ListaDefectoVideos implements Serializable {

    protected static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(targetEntity = ListaporDefecto.class)
    @JoinColumn(name = "id")
    private ListaporDefecto id;

    @Id
    @Column(name = "nombre_video")
    private String video;

    @Id
    @Column(name = "nombre_canal_video_origen")
    private String canal;

    public ListaDefectoVideos() {
    }

    public ListaDefectoVideos(ListaporDefecto id, String video) {
        this.id = id;
        this.video = video;
    }

    public ListaDefectoVideos(ListaporDefecto id, String video, String canal) {
        this.id = id;
        this.video = video;
        this.canal = canal;
    }

    public ListaporDefecto getId() {
        return id;
    }

    public void setId(ListaporDefecto id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.video);
        hash = 17 * hash + Objects.hashCode(this.canal);
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
        final ListaDefectoVideos other = (ListaDefectoVideos) obj;
        if (!Objects.equals(this.video, other.video)) {
            return false;
        }
        if (!Objects.equals(this.canal, other.canal)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

}
