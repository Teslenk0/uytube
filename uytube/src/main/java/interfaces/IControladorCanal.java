/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DataTypes.DtCanal;
import DataTypes.DtCategoria;
import DataTypes.DtComentario;
import DataTypes.DtListaParticulares;
import DataTypes.DtListaReproduccion;
import DataTypes.DtListaporDefecto;
import DataTypes.DtUsuario;
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
    
    public abstract void modificarVideo(DtVideo video, String oldV) throws VideoRepetidoException;
    
    public abstract List listaVideos(DtCanal canal);
    
    public abstract DtVideo obtenerVideo(String v);
    
    public abstract List listaComentarios(String video);
    
    public abstract List listaRespuestas(String comentario);
    
    public abstract void agregarComentario(DtComentario c);
    
    public abstract List getCanales();
    
    public abstract List getListasReproduccion(String nick);
    
    public abstract void crearListaDefecto(DtListaReproduccion lista)throws ListaRepetidaException;

    public abstract void crearListaParticular(DtListaParticulares lista, DtUsuario user) throws ListaRepetidaException;
    
    public abstract void modificarListaParticular(DtListaParticulares lista, DtUsuario user);
    
    public abstract void registrarCategoria(DtCategoria c);
    
    public abstract List getCategorias();
}
