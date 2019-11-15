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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author isaac
 */
@Entity
@Table(name = "lista_defecto_video_eliminada")
public class ListaDefectoVideosEliminados implements Serializable {

    protected static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(targetEntity = ListaporDefectoEliminadas.class)
    @JoinColumn(name = "id")
    private ListaporDefectoEliminadas id;

    @Id
    @Column(name = "nombre_video")
    private String video;

    public ListaDefectoVideosEliminados() {
    }

    public ListaDefectoVideosEliminados(ListaporDefectoEliminadas id, String video) {
        this.id = id;
        this.video = video;
    }

    public ListaporDefectoEliminadas getId() {
        return id;
    }

    public void setId(ListaporDefectoEliminadas id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.video);
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
        final ListaDefectoVideosEliminados other = (ListaDefectoVideosEliminados) obj;
        if (!Objects.equals(this.video, other.video)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    
}
