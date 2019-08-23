/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author esteban
 */
public class ListaReproduccion implements Serializable{
    
    protected static final long serialVersionUID = 1L;
    
    protected String nombreLista;
    
    protected Set<Video> videosLista;
    
    protected Categoria categoria;

    public ListaReproduccion(String nombreLista, Set<Video> videosLista, Categoria categoria) {
        this.nombreLista = nombreLista;
        this.videosLista = videosLista;
        this.categoria = categoria;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public Set<Video> getVideosLista() {
        return videosLista;
    }

    public void setVideosLista(Set<Video> videosLista) {
        this.videosLista = videosLista;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ListaReproduccion{" + "nombreLista=" + nombreLista + ", videosLista=" + videosLista + ", categoria=" + categoria + '}';
    }
    
    
}
