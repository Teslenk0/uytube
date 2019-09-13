/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DataTypes.DtAuxiliar;
import DataTypes.DtCanal;
import DataTypes.DtCategoria;
import DataTypes.DtComentario;
import DataTypes.DtListaParticulares;
import DataTypes.DtListaReproduccion;
import DataTypes.DtUsuario;
import DataTypes.DtVideo;
import excepciones.CategoriaRepetidaException;
import excepciones.ListaRepetidaException;
import excepciones.VideoRepetidoException;
import excepciones.VideoYaExisteEnListaException;
import java.util.List;

/**
 *
 * @author esteban
 */
public interface IControladorCanal {
    
    public abstract void registrarVideo(DtVideo video) throws VideoRepetidoException;
    
    public abstract void modificarVideo(DtVideo video, String oldV) throws VideoRepetidoException;
    
    public abstract List listaVideos(DtCanal canal);
    
    public abstract DtVideo obtenerVideo(String nomV, String canal);
    
    public abstract List listaComentarios(DtVideo video);
    
    public abstract void agregarComentario(DtComentario c);
    
    public abstract DtComentario obtenerComentario(String comentario);
    
    public abstract DtAuxiliar obtenerComentarioRef(String padre);
    
    public abstract String comentarioEsp(Integer num);
    
    public abstract List listaComentariosTodos();
    
    public abstract List getCanales();
    
    public abstract List getListasReproduccion(String nick);
    
    public abstract void crearListaDefecto(DtListaReproduccion lista) throws ListaRepetidaException;

    public abstract void crearListaParticular(DtListaParticulares lista, DtUsuario user) throws ListaRepetidaException;
    
    public abstract void modificarListaParticular(DtListaParticulares lista, DtUsuario user);
    
    public abstract void registrarCategoria(DtCategoria c) throws CategoriaRepetidaException;
    
    public abstract List getCategorias();
    
    public abstract List getListasDefecto(String canal);
    
    public abstract void agregarVideoLista(String nombreVideo, String listaDestino, String usuarioDestino, String usuarioOrigen, Boolean isParticular) throws VideoYaExisteEnListaException;

    public abstract List getVideosListaDefecto(String nombre,String nombreLista);
    
    public abstract List getVideosListaParticular(String nombre,String nombreLista);
    
    public abstract void sacarVideoLista(String usuario,String nombreLista, String video,String canalOrigen, Boolean isParticular);
}
