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
@Table(name = "lista_particular_video_eliminada")
public class ListaParticularVideosEliminados implements Serializable {

    protected static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(targetEntity = ListaParticularesEliminadas.class)
    @JoinColumn(name = "id")
    private ListaParticularesEliminadas id;

    @Id
    @Column(name = "nombre_video")
    private String video;

    public ListaParticularVideosEliminados() {
    }

    public ListaParticularVideosEliminados(ListaParticularesEliminadas id, String video) {
        this.id = id;
        this.video = video;
    }

    public ListaParticularesEliminadas getId() {
        return id;
    }

    public void setId(ListaParticularesEliminadas id) {
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
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.video);
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
        final ListaParticularVideosEliminados other = (ListaParticularVideosEliminados) obj;
        if (!Objects.equals(this.video, other.video)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    
}
