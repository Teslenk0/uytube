/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DataTypes.DtCanal;
import DataTypes.DtCategoria;
import DataTypes.DtComentario;
import DataTypes.DtListaParticulares;
import DataTypes.DtListaReproduccion;
import DataTypes.DtListaporDefecto;
import DataTypes.DtUsuario;
import DataTypes.DtVideo;
import clases.Canal;
import clases.Categoria;
import clases.Comentario;
import clases.ListaParticulares;
import clases.ListaReproduccion;
import clases.ListaporDefecto;
import clases.Usuario;
import clases.Video;
import excepciones.ListaRepetidaException;
import excepciones.VideoRepetidoException;
import interfaces.IControladorCanal;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tecnologo
 */
public class ControladorCanal implements IControladorCanal {

    @Override
    public void registrarVideo(DtVideo v) throws VideoRepetidoException {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Canal canal = new Canal(v.getCanal().getNombre_canal(), v.getCanal().getDescripcion(), v.getCanal().getPrivado());
        Video video = new Video(v.getNombre(), canal, v.getFechaPublicacion(), v.getUrl(), v.getDescripcion(), v.getCategoria(), v.getDuracion(), v.getPrivado());
        try {
            mu.altaVideo(video);
        } catch (Exception c) {
            throw new VideoRepetidoException("El video ya existe");
        }
    }

    @Override
    public void modificarVideo(DtVideo v, String oldV) throws VideoRepetidoException {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Canal canal = new Canal(v.getCanal().getNombre_canal(), v.getCanal().getDescripcion(), v.getCanal().getPrivado());
        Video video = new Video(v.getNombre(), canal, v.getFechaPublicacion(), v.getUrl(), v.getDescripcion(), v.getCategoria(), v.getDuracion(), v.getPrivado());
        try {
            mu.modificarVideo(video, oldV);
        } catch (Exception c) {
            throw new VideoRepetidoException("El video ya existe");
        }
    }

    @Override
    public List listaVideos(DtCanal c) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Canal canal = new Canal(c.getNombre_canal(), c.getDescripcion(), c.getPrivado());
        List lista = mu.listaVid(canal);
        if (lista != null) {
            List aux = new LinkedList();
            DtVideo dtaux;
            for (int x = 0; x < lista.size(); x++) {
                dtaux = new DtVideo( (Video) lista.get(x));
                aux.add(dtaux);
            }
            return aux;
        }
        return null;
    }

    @Override
    public DtVideo obtenerVideo(String v) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Video video = mu.buscadorVideo(v);

        DtCanal canal = new DtCanal(video.getCanal().getNombre_canal(), video.getCanal().getDescripcion(), video.getCanal().getPrivado());
        DtVideo vid = new DtVideo(video.getNombre(), canal, video.getFechaPublicacion(), video.getUrl(), video.getDescripcion(), video.getCategoria(), video.getDuracion(), video.getPrivado());
        if (vid != null) {
            return vid;
        }
        return null;

    }
    
    @Override
    public DtComentario obtenerComentario(String comentario) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Comentario c = mu.buscadorComentario(comentario);
        
        DtComentario com = new DtComentario(c);
        if (com != null) {
            return com;
        }
        return null;

    }

    @Override
    public List listaComentarios(String video) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        List lista = mu.listaCom(video);
        if (lista != null) {
            List aux = new LinkedList();
            DtComentario dtaux;
            for (int x = 0; x < lista.size(); x++) {
                dtaux = new DtComentario((Comentario) lista.get(x));
                aux.add(dtaux);
            }
            return aux;
        }
        return null;
    }

    @Override
    public void agregarComentario(DtComentario c) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Canal canal = new Canal(c.getVideo().getCanal().getNombre_canal(), c.getVideo().getCanal().getDescripcion(), c.getVideo().getCanal().getPrivado());
        Video vid = new Video(c.getVideo().getNombre(), canal, c.getVideo().getFechaPublicacion(), c.getVideo().getUrl(), c.getVideo().getDescripcion(), c.getVideo().getCategoria(), c.getVideo().getDuracion(), c.getVideo().getPrivado());
        Comentario com = new Comentario(c.getNick(), c.getComentario(), c.getFecha(), vid, c.getPadre(), c.getRef());
        mu.addComentario(com);
    }
    
    @Override
    public List getCanales() {
        List canales = new LinkedList();
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        List<DtCanal> aux = new LinkedList<>();
        Canal tmp;
        DtCanal temp;
        canales = mu.obtenerCanales();
        for (int x = 0; x < canales.size(); x++) {
            if (canales.get(x) != null) {
                tmp = (Canal) canales.get(x);
                temp = new DtCanal(tmp.getNombre_canal(), tmp.getDescripcion(), tmp.getPrivado());
                aux.add(temp);
            }
        }
        return aux;
    }

    @Override
    public void crearListaDefecto(DtListaReproduccion lista) throws ListaRepetidaException {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        List canales = mu.obtenerCanales();
        ListaReproduccion list;
        Canal aux;
        if (mu.buscoListaDefecto(lista.getNombreLista())) {
            throw new ListaRepetidaException("La lista por defecto ya existe");
        }

        for (int x = 0; x < canales.size(); x++) {
            if (canales.get(x) != null) {
                aux = (Canal) canales.get(x);
                System.out.println(aux.getNombre_canal());
                list = new ListaporDefecto(lista.getNombreLista());
                list.setCanal(aux);
                mu.crearLista(list);
            }
        }

    }

    @Override
    public void crearListaParticular(DtListaParticulares lista, DtUsuario user) throws ListaRepetidaException {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();

        if (mu.buscoListaParticular(lista.getNombreLista(), user.getCanal().getNombre_canal())) {
            throw new ListaRepetidaException("La lista por defecto ya existe");
        }
        //para que no rompa con las referencias cruzadas
        //*******************************************************************
        Canal aux = new Canal(user.getCanal().getNombre_canal(), user.getCanal().getDescripcion(), user.getCanal().getPrivado());
        Usuario u = new Usuario(user.getNickname(), user.getContraseña(), user.getNombre(), user.getApellido(), user.getEmail(), user.getFechaNac(), user.getImagen());
        u.setCanal(aux);
        aux.setUsuario(u);
        Categoria cat = new Categoria(lista.getCategoria().getnombreCategoria());
        //***************************************************
        ListaReproduccion list = new ListaParticulares(lista.getPrivado(), lista.getNombreLista(), cat, aux);

        mu.crearLista(list);
    }

    @Override
    public List getListasReproduccion(String nick) {
        List listasParticulares;
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        List<DtListaParticulares> aux = new LinkedList<>();
        ListaParticulares tmp;
        DtListaParticulares temp;
        listasParticulares = mu.obtenerListasParticulares(nick);
        for (int x = 0; x < listasParticulares.size(); x++) {
            if (listasParticulares.get(x) != null) {
                tmp = (ListaParticulares) listasParticulares.get(x);

                if (tmp.getCategoria() != null) {
                    temp = new DtListaParticulares(tmp.getPrivado(), new DtCategoria(tmp.getCategoria().getNombreCategoria()), tmp.getNombreLista());
                } else {
                    temp = new DtListaParticulares(tmp.getPrivado(), null, tmp.getNombreLista());
                }
                aux.add(temp);
            }
        }
        return aux;
    }

    @Override
    public void registrarCategoria(DtCategoria c) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Categoria cat = new Categoria(c.getnombreCategoria());
        mu.registrarCategoria(cat);
    }

    @Override
    public void modificarListaParticular(DtListaParticulares lista, DtUsuario user) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Canal aux = new Canal(user.getCanal().getNombre_canal(), user.getCanal().getDescripcion(), user.getCanal().getPrivado());
        Usuario u = new Usuario(user.getNickname(), user.getContraseña(), user.getNombre(), user.getApellido(), user.getEmail(), user.getFechaNac(), user.getImagen());
        u.setCanal(aux);
        aux.setUsuario(u);
        ListaReproduccion list;
        System.out.println(lista.getCategoria().getnombreCategoria());
        if (lista.getCategoria() == null) {
            list = new ListaParticulares(lista.getPrivado(), lista.getNombreLista(), null, aux);
        } else {
            list = new ListaParticulares(lista.getPrivado(), lista.getNombreLista(), new Categoria(lista.getCategoria().getnombreCategoria()), aux);
        }
        mu.modificarListaParticular((ListaParticulares) list);

    }

    @Override
    public List getCategorias() {
        List categorias;
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        List<DtCategoria> aux = new LinkedList<>();
        Categoria tmp;
        DtCategoria temp;
        categorias = mu.obtenerCategorias();
        for (int x = 0; x < categorias.size(); x++) {
            if (categorias.get(x) != null) {
                tmp = (Categoria) categorias.get(x);
                temp = new DtCategoria(tmp.getNombreCategoria());
                aux.add(temp);
            }
        }
        return aux;
    }
}
