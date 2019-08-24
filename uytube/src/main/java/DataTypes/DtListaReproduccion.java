/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Categoria;
import clases.Video;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author esteban
 */
public class DtListaReproduccion implements Serializable{
    
    protected static final long serialVersionUID = 1L;
    
    protected String nombreLista;
    
    protected List<Video> videosLista;
    
    protected Categoria categoria;

    public DtListaReproduccion(String nombreLista, List<Video> videosLista, Categoria categoria) {
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
    
}
