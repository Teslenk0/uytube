/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DataTypes.DtCanal;
import DataTypes.DtListaReproduccion;
import DataTypes.DtListaporDefecto;
import DataTypes.DtVideo;
import excepciones.ListaRepetidaException;
import excepciones.VideoRepetidoException;
import java.util.List;

/**
 *
 * @author esteban
 */
public interface IControladorCanal {
    
    public abstract void registrarVideo(DtVideo video) throws VideoRepetidoException;
    
    public abstract List listaVideos(DtCanal canal);
    
    public abstract List listaComentarios(String video);
    
    public abstract List getCanales();
    
    public abstract void crearListaDefecto(DtListaReproduccion lista)throws ListaRepetidaException;

}
