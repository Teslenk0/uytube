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
@Table(name = "lista_historica")
@IdClass(DefectoPK.class)
public class ListaHistorica implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @ManyToOne(targetEntity = ListaporDefecto.class)
    @JoinColumn(name = "id_lista")
    private ListaporDefecto id;
    
    @Id
    @Column(name = "video")
    private String video;
    
    @Id
    @Column(name = "dueno_video")
    private String canal;
    
    @Column(name = "visitas")
    private int cantVistas;
    
    public ListaHistorica(){
        
    }

    public ListaHistorica(ListaporDefecto id, String video, String canal, int cantVistas) {
        this.id = id;
        this.video = video;
        this.canal = canal;
        this.cantVistas = cantVistas;
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

    public int getCantVistas() {
        return cantVistas;
    }

    public void setCantVistas(int cantVistas) {
        this.cantVistas = cantVistas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.video);
        hash = 53 * hash + Objects.hashCode(this.canal);
        hash = 53 * hash + this.cantVistas;
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
        final ListaHistorica other = (ListaHistorica) obj;
        if (this.cantVistas != other.cantVistas) {
            return false;
        }
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

    @Override
    public String toString() {
        return "ListaHistorica{" + "id=" + id + ", video=" + video + ", canal=" + canal + ", cantVistas=" + cantVistas + '}';
    }
    
    
    
}
