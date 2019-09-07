/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author tesla
 */
@Entity
@Table(name = "lista_defecto_video")
@IdClass(DefectoPK.class)
public class ListaDefectoVideos implements Serializable{

    protected static final long serialVersionUID = 1L;
    
    @Id
    @ManyToOne(targetEntity = ListaporDefecto.class)
    @JoinColumn(name = "id")
    private int id;
    
    @Id
    @OneToOne
    @JoinColumn(name = "nombre_video")
    private Video video;

    public ListaDefectoVideos() {
    }

    public ListaDefectoVideos(int id, Video video) {
        this.id = id;
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "ListaDefectoVideos{" + "id=" + id + ", video=" + video + '}';
    }
    
    
    
}
