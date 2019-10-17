/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author tesla
 */
public class DtListaDefectoVideos implements Serializable {

    protected static final long serialVersionUID = 1L;

    private DtListaporDefecto id;

    private String video;

    private String canal;

    public DtListaDefectoVideos() {
    }

    public DtListaDefectoVideos(DtListaporDefecto id, String video) {
        this.id = id;
        this.video = video;
    }

    public DtListaDefectoVideos(DtListaporDefecto id, String video, String canal) {
        this.id = id;
        this.video = video;
        this.canal = canal;
    }

    public DtListaporDefecto getId() {
        return id;
    }

    public void setId(DtListaporDefecto id) {
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
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.video);
        hash = 89 * hash + Objects.hashCode(this.canal);
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
        final DtListaDefectoVideos other = (DtListaDefectoVideos) obj;
        if (!Objects.equals(this.video, other.video)) {
            return false;
        }
        if (!Objects.equals(this.canal, other.canal)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    

}
