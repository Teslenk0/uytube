/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 *
 * @author esteban
 */
@Entity
@Table(name = "canal_usuario")
public class Canal implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    @Id
    @Column(name = "nickname")
    private String nickname;
    
    @Column(name = "nombre_canal")
    private String nombre_canal;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "isPrivate")
    private Boolean privado;
    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "nickname")
    private Usuario usuario;
    
    //private Set<Video> videos;
    
    //private Set<ListaReproduccion> listas;
    
    public Canal() {
    }
    

    public Canal(String user, String nombre_canal, String descripcion, Boolean privado) {
        this.nickname = user;
        this.nombre_canal = nombre_canal;
        this.descripcion = descripcion;
        this.privado = privado;
    }

    /*public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }*/

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    @Override
    public String toString() {
        return "Canal{" + "username=" + nickname + ", descripcion=" + descripcion + ", privado=" + privado + '}';
    }

    
}
