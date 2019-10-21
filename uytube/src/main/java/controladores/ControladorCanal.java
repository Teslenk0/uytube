/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DataTypes.DtAuxiliar;
import DataTypes.DtAuxiliarValorar;
import DataTypes.DtCanal;
import DataTypes.DtCategoria;
import DataTypes.DtComentario;
import DataTypes.DtListaDefectoVideos;
import DataTypes.DtListaParticularVideos;
import DataTypes.DtListaParticulares;
import DataTypes.DtListaReproduccion;
import DataTypes.DtListaporDefecto;
import DataTypes.DtUsuario;
import DataTypes.DtVideo;
import clases.AuxiliarValorar;
import clases.Canal;
import clases.Categoria;
import clases.Comentario;
import clases.ListaDefectoVideos;
import clases.ListaParticularVideos;
import clases.ListaParticulares;
import clases.ListaReproduccion;
import clases.ListaporDefecto;
import clases.Usuario;
import clases.Video;
import excepciones.CategoriaRepetidaException;
import excepciones.ListaRepetidaException;
import excepciones.VideoRepetidoException;
import excepciones.VideoYaExisteEnListaException;
import interfaces.IControladorCanal;
import java.util.Collections;
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
        if (!video.getNombre().equals(oldV)) {
            if (obtenerVideo(v.getNombre(), v.getCanal().getNombre_canal()) != null) {
                throw new VideoRepetidoException("El video ya existe");
            }
        }

        try {
            mu.modificarVideo(video, oldV);
        } catch (Exception c) {
            throw new VideoRepetidoException("El video ya existe");
        }
    }

    @Override
    public boolean buscarCanal(String canal) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Canal c = mu.buscadorCanal(canal);
        return c != null;
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
                dtaux = new DtVideo((Video) lista.get(x));
                aux.add(dtaux);
            }
            return aux;
        }
        return null;
    }

    @Override
    public DtVideo obtenerVideo(String nomV, String c) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Video video = mu.buscadorVideo(nomV, c);
        if (video != null) {
            DtCanal canal = new DtCanal(video.getCanal().getNombre_canal(), video.getCanal().getDescripcion(), video.getCanal().getPrivado());
            DtVideo vid = new DtVideo(video.getNombre(), canal, video.getFechaPublicacion(), video.getUrl(), video.getDescripcion(), video.getCategoria(), video.getDuracion(), video.getPrivado());
            return vid;
        } else {
            return null;
        }
    }

    @Override
    public DtComentario obtenerComentario(String comentario) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Comentario c = mu.buscadorComentario(comentario);
        DtComentario com = new DtComentario(c);
        return com;
    }

    @Override
    public DtAuxiliar obtenerComentarioRef(String padre) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        DtAuxiliar aux = mu.BuscarComentarioRef(padre);
        if (aux != null) {
            return aux;
        }
        return null;
    }

    @Override
    public String comentarioEsp(Integer num) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        String com = mu.comEsp(num);

        if (com != null) {
            return com;
        }
        return null;
    }

    @Override
    public List listaComentarios(DtVideo video) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        if(video != null) {
            List lista = mu.listaCom(video);
            if (lista != null) {
                return lista;
            }
            return null;
        }
        return null;
    }

    @Override
    public List listaComentariosTodos() {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        List lista = mu.listaTotalComentarios();
        if (lista != null) {
            return lista;
        }
        return null;
    }

    @Override
    public void agregarComentario(DtComentario c) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Canal canal = new Canal(c.getVideo().getCanal().getNombre_canal(), c.getVideo().getCanal().getDescripcion(), c.getVideo().getCanal().getPrivado());
        Video vid = new Video(c.getVideo().getNombre(), canal, c.getVideo().getFechaPublicacion(), c.getVideo().getUrl(), c.getVideo().getDescripcion(), c.getVideo().getCategoria(), c.getVideo().getDuracion(), c.getVideo().getPrivado());
        Comentario com = new Comentario(c.getNick(), c.getComentario(), c.getFecha(), vid, c.getPadre(), c.getRef(), vid.getCanal().getNombre_canal());
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
        if(lista != null) {
            if (mu.buscoListaDefecto(lista.getNombreLista())) {
                throw new ListaRepetidaException("La lista por defecto ya existe");
            }

            for (int x = 0; x < canales.size(); x++) {
                if (canales.get(x) != null) {
                    aux = (Canal) canales.get(x);
                    list = new ListaporDefecto(lista.getNombreLista());
                    list.setCanal(aux);
                    mu.crearLista(list);
                }
            }
        }
    }

    @Override
    public void crearListaParticular(DtListaParticulares lista, DtUsuario user) throws ListaRepetidaException {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();

        if (mu.buscoListaParticular(lista.getNombreLista(), user.getCanal().getNombre_canal())) {
            throw new ListaRepetidaException("La lista por defecto ya existe");
        }
        Canal aux = new Canal(user.getCanal().getNombre_canal(), user.getCanal().getDescripcion(), user.getCanal().getPrivado());
        Usuario u = new Usuario(user.getNickname(), user.getContrasenia(), user.getNombre(), user.getApellido(), user.getEmail(), user.getFechaNac(), user.getImagen());
        u.setCanal(aux);
        aux.setUsuario(u);
        Categoria cat = new Categoria(lista.getCategoria().getnombreCategoria());

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
        if(nick != null) {
            if(mu.buscadorUsuario(nick) != null) {
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
            return null;
        }
        return null;
    }

    @Override
    public void registrarCategoria(DtCategoria c) throws CategoriaRepetidaException {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        if(c != null) {
            Categoria cat = new Categoria(c.getnombreCategoria());
            try {
                mu.registrarCategoria(cat);
            } catch (Exception e) {
                throw new CategoriaRepetidaException("Categoria repetida");
            }
        }
    }

    @Override
    public void modificarListaParticular(DtListaParticulares lista, DtUsuario user) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        if(user != null && lista != null) {
            Canal aux = new Canal(user.getCanal().getNombre_canal(), user.getCanal().getDescripcion(), user.getCanal().getPrivado());
            Usuario u = new Usuario(user.getNickname(), user.getContrasenia(), user.getNombre(), user.getApellido(), user.getEmail(), user.getFechaNac(), user.getImagen());
            u.setCanal(aux);
            aux.setUsuario(u);
            ListaReproduccion list;
            if (lista.getCategoria() == null) {
                list = new ListaParticulares(lista.getPrivado(), lista.getNombreLista(), null, aux);
            } else {
                list = new ListaParticulares(lista.getPrivado(), lista.getNombreLista(), new Categoria(lista.getCategoria().getnombreCategoria()), aux);
            }
            mu.modificarListaParticular((ListaParticulares) list);
        }
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

    @Override
    public List getListasDefecto(String nick) {
        if(nick != null) {

            ManejadorInformacion mu = ManejadorInformacion.getInstance();
            List<DtListaporDefecto> aux = new LinkedList<>();
            ListaporDefecto tmp;
            DtListaporDefecto temp;
            if(!nick.isEmpty()) {
                List listas = mu.obtenerListasDefecto(nick);
                if(listas != null) {
                    for (int x = 0; x < listas.size(); x++) {
                        if (listas.get(x) != null) {
                            tmp = (ListaporDefecto) listas.get(x);
                            temp = new DtListaporDefecto(tmp.getNombreLista());
                            aux.add(temp);
                        }
                    }
                    return aux;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override
    public void agregarVideoLista(String nombreVideo, String listaDestino, String usuarioDestino, String usuarioOrigen, Boolean isParticular) throws VideoYaExisteEnListaException {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Usuario userDestino = mu.buscadorUsuario(usuarioDestino);
        Usuario userOrigen = mu.buscadorUsuario(usuarioOrigen);
        if (mu.buscoVideoEnLista(nombreVideo, listaDestino, usuarioDestino, usuarioOrigen, isParticular)) {
            throw new VideoYaExisteEnListaException("El video ya existe en la lista");
        }
        if (!isParticular) {
            ListaporDefecto list = mu.buscadorListaDefecto(userDestino.getCanal().getNombre_canal(), listaDestino);
            ListaDefectoVideos l = new ListaDefectoVideos(list, nombreVideo, userOrigen.getCanal().getNombre_canal());
            mu.agregarVideoListaDefecto(l);
        } else {
            ListaParticulares list = mu.buscadorListaParticular(userDestino.getCanal().getNombre_canal(), listaDestino);
            ListaParticularVideos l = new ListaParticularVideos(list, nombreVideo, userOrigen.getCanal().getNombre_canal());
            mu.agregarVideoListaParticular(l);
        }
    }

    @Override
    public List getVideosListaDefecto(String nombre, String nombreLista) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        if(nombre != null && nombreLista != null) {
            Usuario user = mu.buscadorUsuario(nombre);
            ListaporDefecto list = mu.buscadorListaDefecto(user.getCanal().getNombre_canal(), nombreLista);
            List listaxvideos = mu.getVideosListaDefecto(list.getId());
            System.out.println("LLEGA ACA PARIENTE");
            if (listaxvideos != null) {
                List aux = new LinkedList();
                ListaDefectoVideos tmp;
                DtListaDefectoVideos temp;
                for (int x = 0; x < listaxvideos.size(); x++) {
                    if (listaxvideos.get(x) != null) {
                        tmp = (ListaDefectoVideos) listaxvideos.get(x);
                        temp = new DtListaDefectoVideos(new DtListaporDefecto(nombreLista), tmp.getVideo(), tmp.getCanal());
                        aux.add(temp);
                    }
                }
                System.out.println("ACA NO LLEGA");
                return aux;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public List getVideosListaParticular(String nombre, String nombreLista) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        if(nombre != null && nombreLista!=null) {
            Usuario user = mu.buscadorUsuario(nombre);
            ListaParticulares list = mu.buscadorListaParticular(user.getCanal().getNombre_canal(), nombreLista);
            List listaxvideos = mu.getVideosListaParticular(list.getId());
            if (listaxvideos != null) {
                List aux = new LinkedList();
                ListaParticularVideos tmp;
                DtListaParticulares listaParticular;
                DtListaParticularVideos temp;
                for (int x = 0; x < listaxvideos.size(); x++) {
                    if (listaxvideos.get(x) != null) {
                        tmp = (ListaParticularVideos) listaxvideos.get(x);
                        if (list.getCategoria() != null) {
                            listaParticular = new DtListaParticulares(list.getPrivado(), new DtCategoria(list.getCategoria().getNombreCategoria()), nombreLista);
                        } else {
                            listaParticular = new DtListaParticulares(list.getPrivado(), null, nombreLista);
                        }
                        temp = new DtListaParticularVideos(listaParticular, tmp.getVideo(), tmp.getCanal());
                        aux.add(temp);
                    }
                }
                return aux;

            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public void sacarVideoLista(String usuario, String nombreLista, String video, String canalOrigen, Boolean isParticular) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Usuario user = mu.buscadorUsuario(usuario);
        if (isParticular) {
            ListaParticulares list = mu.buscadorListaParticular(user.getCanal().getNombre_canal(), nombreLista);
            mu.removerVideoLista(list.getId(), video, canalOrigen, isParticular);
        } else {
            ListaporDefecto list = mu.buscadorListaDefecto(user.getCanal().getNombre_canal(), nombreLista);
            mu.removerVideoLista(list.getId(), video, canalOrigen, isParticular);
        }
    }

    @Override
    public List listaMeGustas(String usuario) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        if(usuario != null) {
            if(mu.buscadorUsuario(usuario) != null) {
                List lista = mu.obtenerVal(usuario);
                if (lista != null) {
                    List aux = new LinkedList();
                    DtAuxiliarValorar dtaux;
                    for (int x = 0; x < lista.size(); x++) {
                        dtaux = new DtAuxiliarValorar((AuxiliarValorar) lista.get(x));
                        aux.add(dtaux);
                    }
                    return aux;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override
    public List listarVideosPorCategoria(String categoria) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        List lista = mu.obtenerVideosPorCategoria(categoria);
        if (lista != null) {
            List aux = new LinkedList();
            DtVideo dtaux;
            for (int x = 0; x < lista.size(); x++) {
                dtaux = new DtVideo((Video) lista.get(x));
                aux.add(dtaux);
            }
            return aux;
        }
        return null;
    }

    @Override
    public List obtenerListasParticularesPorCategoria(String categoria) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        List lista = mu.obtenerListasParticularesPorCategoria(categoria);
        if (lista != null) {
            List auxReturn = new LinkedList();
            ListaParticulares aux;
            DtListaParticulares dtaux;
            for (int x = 0; x < lista.size(); x++) {
                if (lista.get(x) != null) {
                    aux = (ListaParticulares) lista.get(x);
                    dtaux = new DtListaParticulares(aux.getPrivado(), aux.getNombreLista(), new DtCategoria(categoria), new DtCanal(aux.getCanal().getNombre_canal(), aux.getCanal().getDescripcion(), aux.getCanal().getPrivado()));
                    auxReturn.add(dtaux);
                }
            }
            return auxReturn;
        }
        return null;
    }

    @Override
    public List busquedaArborescenteCanales(String text) {

        ManejadorInformacion mu = ManejadorInformacion.getInstance();

        List results = mu.busquedaArborescenteCanales(text);

        DtCanal tmp;
        Canal aux;
        if (!results.isEmpty()) {
            List<DtCanal> resultados = new LinkedList<>();
            for (int i = 0; i < results.size(); i++) {
                aux = (Canal) results.get(i);
                aux.setNombre_canal(aux.getNombre_canal());
                tmp = new DtCanal(aux.getNombre_canal(), aux.getDescripcion(), aux.getPrivado(), new DtUsuario(aux.getUsuario()));
                resultados.add(tmp);
            }
            Collections.sort(resultados);
            return resultados;
        }
        return null;
    }

    @Override
    public List busquedaArborescenteVideos(String text) {

        ManejadorInformacion mu = ManejadorInformacion.getInstance();

        List results = mu.busquedaArborescenteVideos(text);

        DtVideo tmp;
        Video aux;
        if (results != null) {
            List<DtVideo> resultados = new LinkedList<>();
            for (int i = 0; i < results.size(); i++) {
                aux = (Video) results.get(i);
                aux.setNombre(aux.getNombre());
                tmp = new DtVideo(aux);
                resultados.add(tmp);
            }
            Collections.sort(resultados);
            return resultados;
        }
        return null;
    }

    @Override
    public List busquedaArborescenteListasParticulares(String text) {

        ManejadorInformacion mu = ManejadorInformacion.getInstance();

        List results = mu.busquedaArborescenteListasParticulares(text);

        DtListaParticulares tmp;
        ListaParticulares aux;
        if (!results.isEmpty()) {
            List<DtListaParticulares> resultados = new LinkedList<>();
            for (int i = 0; i < results.size(); i++) {
                aux = (ListaParticulares) results.get(i);
                aux.setNombreLista(aux.getNombreLista());
                tmp = new DtListaParticulares(aux.getPrivado(), aux.getNombreLista(), new DtCategoria(aux.getCategoria().getNombreCategoria()),
                        new DtCanal(aux.getCanal().getNombre_canal(),
                                aux.getCanal().getDescripcion(), aux.getCanal().getPrivado(), new DtUsuario(aux.getCanal().getUsuario())));
                resultados.add(tmp);
            }
            Collections.sort(resultados);
            return resultados;
        }
        return null;
    }

    @Override
    public DtListaParticulares buscarListaParticular(String nomLista, DtCanal canal) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();

        if(nomLista != null && canal != null) {
            ListaParticulares lista = mu.buscadorListaParticular(canal.getNombre_canal(), nomLista);
            if (lista != null) {
                DtCanal c = new DtCanal(lista.getCanal().getNombre_canal(), lista.getCanal().getDescripcion(), lista.getCanal().getPrivado());
                DtCategoria cat = new DtCategoria(lista.getCategoria().getNombreCategoria());
                DtListaParticulares aux = new DtListaParticulares(lista.getPrivado(), lista.getNombreLista(), cat, c);
                return aux;
            }

            return null;
        }
        return null;
    }

    @Override
    public DtVideo buscoVideoMasRecienteCanal(String canal) {
        
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        if(canal != null) {
            Canal c = mu.buscadorCanal(canal);
            if (c != null) {
                Video v = mu.buscoVideoMasRecienteCanal(c);
                if (v != null) {
                    DtVideo video = new DtVideo(v.getNombre(), new DtCanal(v.getCanal().getNombre_canal(), v.getCanal().getDescripcion(), v.getCanal().getPrivado(), new DtUsuario(v.getCanal().getUsuario())),
                            v.getFechaPublicacion(),
                            v.getUrl(),
                            v.getDescripcion(),
                            v.getCategoria(),
                            v.getDuracion(),
                            v.getPrivado());
                    return video;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override
    public DtVideo buscoVideoMasRecienteListaParticular(String lista, String canal) {
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        if (lista != null && canal != null) {
            ListaParticulares l = mu.buscadorListaParticular(canal, lista);
            if (l != null) {

                List<ListaParticularVideos> videos = mu.getVideosListaParticular(l.getId());
                if (videos != null) {
                    Video ultimo = null;
                    Video tmp = null;
                    ListaParticularVideos aux = null;
                    for (int i = 0; i < videos.size(); i++) {
                        aux = (ListaParticularVideos) videos.get(i);
                        if (i == 0) {
                            ultimo = mu.buscadorVideo(aux.getVideo(), aux.getCanal());
                        } else {
                            tmp = mu.buscadorVideo(aux.getVideo(), aux.getCanal());
                            if (tmp != null && ultimo != null) {
                                if (ultimo.getFechaPublicacion().before(tmp.getFechaPublicacion())) {
                                    ultimo = tmp;
                                }
                            } else {
                                return null;
                            }
                        }
                    }
                    if (ultimo != null) {
                        return new DtVideo(ultimo);
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
