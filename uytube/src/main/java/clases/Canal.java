/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;



/**
 *
 * @author esteban
 */
public class Canal implements Serializable {
    
   protected static final long serialVersionUID = 1L;
   
    protected Usuario user;
    
    protected String descripcion;
    
    protected Set<Video> videos;
    

    public Canal(Usuario user, String descripcion, Set<Video> videos) {
        this.user = user;
        this.descripcion = descripcion;
        this.videos = videos;
    }

    public Canal(Usuario user, String descripcion) {
        this.user = user;
        this.descripcion = descripcion;
        this.videos = new TreeSet<Video>();
    }

    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Canal{" + "user=" + user + ", descripcion=" + descripcion + '}';
    }  
    
}
