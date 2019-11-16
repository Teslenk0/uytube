/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DataTypes.*;
import excepciones.CategoriaRepetidaException;
import excepciones.ListaRepetidaException;
import excepciones.VideoRepetidoException;
import excepciones.VideoYaExisteEnListaException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;



/**
 *
 * @author esteban
 */
@WebService
public interface IControladorCanal {
    
    @WebMethod
    public abstract void registrarVideo(DtVideo video) throws VideoRepetidoException;
    
    @WebMethod
    public abstract void modificarVideo(DtVideo video, String oldV) throws VideoRepetidoException;
    
    @WebMethod
    public abstract List listaVideos(DtCanal canal);
    
    @WebMethod
    public List listaVideosUserEliminado(Integer id);
    
    @WebMethod
    public abstract boolean buscarCanal(String canal);
    
    @WebMethod
    public abstract DtVideo obtenerVideo(String nomV, String canal);
    
    @WebMethod
    public abstract DtVideoEliminado obtenerVideoEliminado(Integer id, String nomV);
    
    @WebMethod
    public abstract List listaComentarios(DtVideo video);
    
    @WebMethod
    public abstract void agregarComentario(DtComentario c);
    
    @WebMethod
    public abstract DtComentario obtenerComentario(String comentario);
    
    @WebMethod
    public abstract DtAuxiliar obtenerComentarioRef(String padre);
    
    @WebMethod
    public abstract String comentarioEsp(Integer num);
    
    @WebMethod
    public abstract List listaComentariosTodos();
    
    @WebMethod
    public abstract List getCanales();
    
    @WebMethod
    public abstract List getListasReproduccion(String nick);
    
    @WebMethod
    public List getListasParticularesEliminadas(Integer id);
    
    @WebMethod
    public List getListasDefectoEliminadas(Integer id);
    
    @WebMethod
    public abstract void crearListaDefecto(DtListaReproduccion lista) throws ListaRepetidaException;

    @WebMethod
    public abstract void crearListaParticular(DtListaParticulares lista, DtUsuario user) throws ListaRepetidaException;
    
    @WebMethod
    public abstract void modificarListaParticular(DtListaParticulares lista, DtUsuario user);
    
    @WebMethod
    public abstract void registrarCategoria(DtCategoria c) throws CategoriaRepetidaException;
    
    @WebMethod
    public abstract List getCategorias();
    
    @WebMethod
    public abstract List getListasDefecto(String canal);
    
    @WebMethod
    public abstract void agregarVideoLista(String nombreVideo, String listaDestino, String usuarioDestino, String usuarioOrigen, Boolean isParticular) throws VideoYaExisteEnListaException;

    @WebMethod
    public abstract List getVideosListaDefecto(String nombre,String nombreLista);
    
    @WebMethod
    public abstract List getVideosListaParticular(String nombre,String nombreLista);
    
    @WebMethod
    public List getVideosListaParticularEliminadas(Integer id);
    
    @WebMethod
    public List getVideosListaDefectoEliminadas(Integer id);
    
    @WebMethod
    public abstract void sacarVideoLista(String usuario,String nombreLista, String video,String canalOrigen, Boolean isParticular);
    
    @WebMethod
    public abstract List listaMeGustas(String usuario);
    
    @WebMethod
    public abstract List obtenerListasParticularesPorCategoria(String categoria);
    
    @WebMethod
    public abstract List listarVideosPorCategoria(String categoria);
    
    @WebMethod
    public abstract List busquedaArborescenteCanales(String text);
    
    @WebMethod
    public abstract List busquedaArborescenteVideos(String text);
    
    @WebMethod
    public abstract List busquedaArborescenteListasParticulares(String text);
    
    @WebMethod
    public abstract DtListaParticulares buscarListaParticular(String nomLista, DtCanal canal);
    
    @WebMethod
    public abstract DtVideo buscoVideoMasRecienteCanal(String canal);
    
    @WebMethod
    public abstract DtVideo buscoVideoMasRecienteListaParticular(String lista, String canal);
    
    @WebMethod
    public abstract List funcionAuxiliarAccesoDt(DtAuxiliarValorar a, DtListaporDefecto b, DtListaDefectoVideos c, DtListaParticularVideos d, DtValorar e, DtauxComentarios f);

    @WebMethod
    public abstract void agregarVideoHistorial(DtVideo video, DtCanal canal);
    
    @WebMethod
    public abstract List obtenerVideosHistoricos(DtCanal duenoCanal);

    @WebMethod
    public abstract DtauxComentarios buscarRespuestas(DtComentario com);
}
