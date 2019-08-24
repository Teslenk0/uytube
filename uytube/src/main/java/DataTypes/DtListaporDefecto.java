/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Categoria;
import clases.Video;
import java.util.List;

/**
 *
 * @author esteban
 */
public class DtListaporDefecto extends DtListaReproduccion {

    public DtListaporDefecto(String nombreLista, List<Video> videosLista, Categoria categoria) {
        super(nombreLista, videosLista, categoria);
    }
    
}
