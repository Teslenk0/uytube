/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
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
public class DtListaParticularVideos implements Serializable {

    protected static final long serialVersionUID = 1L;

    private DtListaParticulares id;

    private String video;

    private String canal;

    public DtListaParticularVideos() {
    }

    public DtListaParticularVideos(DtListaParticulares id, String video) {
        this.id = id;
        this.video = video;
    }

    public DtListaParticularVideos(DtListaParticulares id, String video, String canal) {
        this.id = id;
        this.video = video;
        this.canal = canal;
    }

    public DtListaParticulares getId() {
        return id;
    }

    public void setId(DtListaParticulares id) {
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
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.video);
        hash = 47 * hash + Objects.hashCode(this.canal);
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
        final DtListaParticularVideos other = (DtListaParticularVideos) obj;
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
