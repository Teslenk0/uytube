/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author esteban
 */
public abstract class ListaReproduccion implements Serializable{
    
    protected static final long serialVersionUID = 1L;
    
    protected String nombreLista;
    
    protected List<Video> videosLista;
    
    protected Categoria categoria;

    public ListaReproduccion(String nombreLista, List<Video> videosLista, Categoria categoria) {
        this.nombreLista = nombreLista;
        this.videosLista = videosLista;
        this.categoria = categoria;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public List<Video> getVideosLista() {
        return videosLista;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public void setVideosLista(List<Video> videosLista) {
        this.videosLista = videosLista;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString() {
        return "ListaReproduccion{" + "nombreLista=" + nombreLista + ", videosLista=" + videosLista + ", categoria=" + categoria + '}';
    }
    
    
}