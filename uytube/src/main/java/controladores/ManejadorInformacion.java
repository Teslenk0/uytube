/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import clases.*;
import DataTypes.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author tecnologo
 */
public class ManejadorInformacion {

    private boolean conexionIniciada = false;
    private EntityManager manager;

    private static EntityManagerFactory emf;

    private static ManejadorInformacion instancia;

    public ManejadorInformacion() {
        emf = Persistence.createEntityManagerFactory("uytube-app");
    }

    public static ManejadorInformacion getInstance() {
        if (instancia == null) {
            instancia = new ManejadorInformacion();
        }
        return instancia;
    }

    public void registrarUser(Usuario u) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(u);
        manager.getTransaction().commit();
        manager.close();

    }

    public Usuario buscadorEmail(String email) {
        manager = emf.createEntityManager();
        Usuario user;
        try {
            String query = "select u from Usuario u where u.email='" + email + "'";
            user = (Usuario) manager.createQuery(query).getSingleResult();
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    public List ObtenerUsuarios() {
        manager = emf.createEntityManager();
        List<Usuario> usuarios = manager.createQuery("FROM Usuario u").getResultList();
        if (usuarios != null) {
            return usuarios;
        }
        return null;

    }

    public void crearCanal(Canal c) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();
        manager.close();
    }

    public void iniciarConexionInicial() {
        manager = emf.createEntityManager();
        if (!conexionIniciada) {
            manager.getTransaction().begin();
            manager.getTransaction().rollback();
            manager.close();
            this.conexionIniciada = true;
        }
    }

    public void modificarUsuario(Usuario u, Canal c) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Usuario user = manager.find(Usuario.class, u.getNickname());
        user.setNombre(u.getNombre());
        user.setApellido(u.getApellido());
        user.setContrasenia(u.getContrasenia());
        user.setFechaNac(u.getFechaNac());
        user.setImagen(u.getImagen());
        manager.getTransaction().commit();
        String canalViejo = u.getCanal().getNombre_canal();
        Canal aux = manager.find(Canal.class, u.getCanal().getNombre_canal());
        if (!user.getCanal().getNombre_canal().equals(c.getNombre_canal())) {
            manager.clear();
            manager.getTransaction().begin();
            aux.setNombre_canal(c.getNombre_canal());
            user = manager.find(Usuario.class, u.getNickname());
            user.setCanal(aux);
            manager.getTransaction().commit();
            manager.clear();
            manager.getTransaction().begin();
            Canal aRemover = manager.find(Canal.class, canalViejo);
            manager.remove(aRemover);
            manager.getTransaction().commit();
        }
        manager.getTransaction().begin();
        aux.setDescripcion(c.getDescripcion());
        aux.setPrivado(c.getPrivado());
        manager.getTransaction().commit();
        manager.close();
    }

    public void eliminarCanal(Canal c) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(c);
        manager.getTransaction().commit();
        manager.close();
    }

    public void seguirUsuario(Usuario u, String s) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Seguir seg = new Seguir(u, s);
        manager.persist(seg);
        manager.getTransaction().commit();
        manager.close();
    }

    public void dejarSeguir(Usuario u, String s) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("delete from Seguir s where nickname = '" + u.getNickname() + "' and seguido = '" + s + "'");
        query.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
    }

    public List ObtenerSeguidos(String nickname) {
        manager = emf.createEntityManager();
        String query = "SELECT s.seguidos FROM Seguir s WHERE s.us = '" + nickname + "'";
        return manager.createQuery(query).getResultList();
    }

    public List ObtenerSeguidores(String nick) {
        manager = emf.createEntityManager();
        String query = "SELECT s.us FROM Seguir s WHERE s.seguidos = '" + nick + "'";
        return manager.createQuery(query).getResultList();
    }

    public Usuario buscadorUsuario(String nick) {
        manager = emf.createEntityManager();
        Usuario user = manager.find(Usuario.class, nick);
        return user;
    }

    public void altaVideo(Video video) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(video);
        manager.getTransaction().commit();
        manager.close();
    }

    public void modificarVideo(Video video, String oldV) {
        Integer privado;
        if (video.getPrivado()) {
            privado = 1;
        } else {
            privado = 0;
        }
        Date dt = video.getFechaPublicacion();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dt);
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Query query;
        query = manager.createNativeQuery("update videos_canal set categoria='" + video.getCategoria() + "', descripcion='" + video.getDescripcion() + "', duracion='" + video.getDuracion() + "', isPrivate='" + privado + "', fecha_publicacion='" + date + "', url='" + video.getUrl() + "' where nombre='" + oldV + "' and nombre_canal='" + video.getCanal().getNombre_canal() + "';");
        query.executeUpdate();
        if (!video.getNombre().equals(oldV)) {
            query = manager.createNativeQuery("update videos_canal set nombre='" + video.getNombre() + "' where nombre='" + oldV + "' and nombre_canal='" + video.getCanal().getNombre_canal() + "';");
            query.executeUpdate();
        }
        manager.getTransaction().commit();
        manager.close();
    }

    public List listaVid(Canal c) {
        manager = emf.createEntityManager();
        String query = "SELECT v FROM Video v WHERE v.canal = '" + c.getNombre_canal() + "'";
        return manager.createQuery(query).getResultList();
    }

    public List listaCom(DtVideo v) {
        manager = emf.createEntityManager();
        List<Object[]> comentario = manager.createNativeQuery("SELECT comentario, Referencia, Padre, nickname, fecha FROM comentarios_video where Video='" + v.getNombre() + "';").getResultList();
        List<DtAuxiliar> comentarios = new ArrayList<>();
        comentario.forEach((row) -> {
            comentarios.add(new DtAuxiliar((String) row[0], (Integer) row[1], (String) row[2], (String) row[3], (Date) row[4]));
        });
        return comentarios;
    }

    public DtAuxiliar BuscarComentarioRef(String padre) {
        manager = emf.createEntityManager();
        Object[] comentario = ((List<Object[]>) manager.createNativeQuery("SELECT comentario, Referencia, Padre, nickname, fecha FROM comentarios_video where Referencia='" + padre + "';").getResultList()).get(0);
        if (comentario != null) {
            DtAuxiliar c = new DtAuxiliar((String) comentario[0], (Integer) comentario[1], (String) comentario[2], (String) comentario[3], (Date) comentario[4]);
            return c;
        }
        return null;
    }

    public String comEsp(Integer num) {
        String query = "SELECT c.comentario FROM Comentario c WHERE c.ref ='" + num + "'";
        return (String) manager.createQuery(query).getSingleResult();
    }

    public List listaTotalComentarios() {
        manager = emf.createEntityManager();
        List<Object[]> comentarios = manager.createNativeQuery("SELECT * FROM comentarios_video;").getResultList();
        List<DtauxComentarios> coment = new ArrayList<>();
        comentarios.forEach((row) -> {
            coment.add(new DtauxComentarios((String) row[0], (String) row[1], (Date) row[2], (String) row[3], (String) row[4], (Integer) row[5], (String) row[6]));
        });
        return coment;
    }

    public void addComentario(Comentario c) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();
        manager.close();
    }

    public Video buscadorVideo(String nom, String canal) {
        manager = emf.createEntityManager();
        Video video;
        try {
            video = (Video) manager.createQuery("select v from Video v where v.canal='" + canal + "' and v.nombre='" + nom + "'").getSingleResult();
        } catch (Exception e) {
            video = null;
        }
        return video;
    }

    public Comentario buscadorComentario(String c) {
        manager = emf.createEntityManager();
        return manager.find(Comentario.class, c);
    }

    public void crearLista(ListaReproduccion list) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(list);
        manager.getTransaction().commit();
        manager.close();
    }

    public List obtenerCanales() {
        manager = emf.createEntityManager();
        String query = "FROM Canal";
        List<Canal> canales = manager.createQuery(query).getResultList();
        if (canales != null) {
            return canales;
        }
        return null;
    }

    public Canal buscadorCanal(String v) {
        manager = emf.createEntityManager();
        return manager.find(Canal.class, v);
    }

    public Boolean buscoListaDefecto(String nombre) {
        manager = emf.createEntityManager();
        int resultado = manager.createQuery("FROM ListaporDefecto l WHERE l.nombreLista='" + nombre + "'").getResultList().size(); //busco si ya existe
        return resultado != 0;
    }

    public Boolean buscoListaParticular(String nombreLista, String nombreCanal) {
        manager = emf.createEntityManager();
        int resultado = manager.createQuery("FROM ListaParticulares l WHERE l.nombreLista='" + nombreLista + "' and l.canal='" + nombreCanal + "'").getResultList().size(); //busco si ya existe
        return resultado != 0;
    }

    public List obtenerListasParticulares(String nick) {
        manager = emf.createEntityManager();
        Usuario u = this.buscadorUsuario(nick);
        List aux = manager.createQuery("FROM ListaParticulares l WHERE l.canal='" + u.getCanal().getNombre_canal() + "'").getResultList(); //busco si ya existe
        if (aux != null) {
            return aux;
        }
        return null;

    }

    public void registrarCategoria(Categoria c) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();
        manager.close();
    }

    public List obtenerCategorias() {
        manager = emf.createEntityManager();
        List aux = manager.createQuery("FROM Categoria c").getResultList(); //busco si ya existe
        if (aux != null) {
            return aux;
        }
        return null;
    }

    public void modificarListaParticular(ListaParticulares list) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        ListaParticulares aux = (ListaParticulares) manager.createQuery("FROM ListaParticulares l WHERE l.nombreLista='" + list.getNombreLista() + "' and l.canal='" + list.getCanal().getNombre_canal() + "'").getSingleResult();
        aux.setCategoria(list.getCategoria());
        aux.setPrivado(list.getPrivado());
        manager.getTransaction().commit();
        manager.close();
    }

    public List obtenerListasDefecto(String nick) {
        manager = emf.createEntityManager();
        Usuario u = this.buscadorUsuario(nick);
        List aux = manager.createQuery("FROM ListaporDefecto l WHERE l.canal='" + u.getCanal().getNombre_canal() + "'").getResultList(); //busco si ya existe
        if (aux != null) {
            return aux;
        }
        return null;
    }

    public ListaporDefecto buscadorListaDefecto(String canal, String lista) {
        manager = emf.createEntityManager();
        ListaporDefecto aux = (ListaporDefecto) manager.createQuery("FROM ListaporDefecto l WHERE l.canal='" + canal + "' and l.nombreLista='" + lista + "'").getSingleResult();
        if (aux != null) {
            return aux;
        }
        return null;
    }

    public ListaParticulares buscadorListaParticular(String canal, String lista) {
        manager = emf.createEntityManager();
        try {
            ListaParticulares aux = (ListaParticulares) manager.createQuery("FROM ListaParticulares l WHERE l.canal='" + canal + "' and l.nombreLista='" + lista + "'").getSingleResult();
            return aux;
        } catch (Exception e) {
            return null;
        }
    }

    public void agregarVideoListaDefecto(ListaDefectoVideos l) {
        manager = emf.createEntityManager();
        ListaporDefecto aux = manager.find(ListaporDefecto.class, l.getId().getId());
        l.setId(aux);
        manager.getTransaction().begin();
        manager.persist(l);
        manager.getTransaction().commit();
        manager.close();
    }

    public void agregarVideoListaParticular(ListaParticularVideos l) {
        manager = emf.createEntityManager();
        ListaParticulares aux = manager.find(ListaParticulares.class, l.getId().getId());
        l.setId(aux);
        manager.getTransaction().begin();
        manager.persist(l);
        manager.getTransaction().commit();
        manager.close();
    }

    public boolean buscoVideoEnLista(String nombreVideo, String listaDestino, String usuarioDestino, String usuarioOrigen, Boolean isParticular) {
        manager = emf.createEntityManager();
        Usuario origen = manager.find(Usuario.class, usuarioOrigen);
        Usuario destino = manager.find(Usuario.class, usuarioDestino);
        if (!isParticular) {
            ListaporDefecto l = buscadorListaDefecto(destino.getCanal().getNombre_canal(), listaDestino);
            int resultado = manager.createQuery("FROM ListaDefectoVideos l WHERE l.id='" + l.getId() + "' and l.canal='" + origen.getCanal().getNombre_canal() + "' and l.video='" + nombreVideo + "'").getResultList().size(); //busco si ya existe
            return resultado != 0;
        } else {
            ListaParticulares l = buscadorListaParticular(destino.getCanal().getNombre_canal(), listaDestino);
            int resultado = manager.createQuery("FROM ListaParticularVideos l WHERE l.id='" + l.getId() + "' and l.canal='" + origen.getCanal().getNombre_canal() + "' and l.video='" + nombreVideo + "'").getResultList().size(); //busco si ya existe
            return resultado != 0;
        }
    }

    public List getVideosListaDefecto(int id) {
        manager = emf.createEntityManager();
        String query = "FROM ListaDefectoVideos l WHERE l.id='" + id + "'";
        List aux = manager.createQuery(query).getResultList();
        if (aux != null) {
            return aux;
        }
        return null;
    }

    public List getVideosListaParticular(int id) {
        manager = emf.createEntityManager();
        String query = "FROM ListaParticularVideos l WHERE l.id='" + id + "'";
        List aux = manager.createQuery(query).getResultList();
        if (aux != null) {
            return aux;
        }
        return null;
    }

    public void removerVideoLista(int id, String video, String canalOrigen, Boolean isParticular) {
        manager = emf.createEntityManager();

        if (isParticular) {
            ListaParticularVideos aux = (ListaParticularVideos) manager.createQuery("FROM ListaParticularVideos l WHERE l.id='" + id + "' and l.video='" + video + "' and l.canal='" + canalOrigen + "'").getSingleResult();
            manager.getTransaction().begin();
            manager.remove(aux);
            manager.getTransaction().commit();
        } else {
            ListaDefectoVideos aux = (ListaDefectoVideos) manager.createQuery("FROM ListaDefectoVideos l WHERE l.id='" + id + "' and l.video='" + video + "' and l.canal='" + canalOrigen + "'").getSingleResult();
            manager.getTransaction().begin();
            manager.remove(aux);
            manager.getTransaction().commit();
        }
        manager.close();
    }

    public List obtenerVal(String nick) {
        manager = emf.createEntityManager();
        Usuario u = this.buscadorUsuario(nick);
        List<Object[]> valorar = manager.createNativeQuery("SELECT dueño_Vid, video, usuario, valoracion FROM valorar where dueño_Vid='" + u.getNickname() + "';").getResultList();
        List<AuxiliarValorar> valoraciones = new ArrayList<>();
        valorar.forEach((row) -> {
            valoraciones.add(new AuxiliarValorar((String) row[0], (String) row[1], (String) row[2], (String) row[3]));
        });
        return valoraciones;

    }

    public void valorarVid(Valorar v) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(v);
        manager.getTransaction().commit();
        manager.close();
    }

    public void modificoVal(Valorar v) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createNativeQuery("delete from valorar where dueño_Vid='" + v.getDuenio().getNickname() + "' and video='" + v.getVid() + "' and usuario='" + v.getUser() + "';");
        query.executeUpdate();
        manager.persist(v);
        manager.getTransaction().commit();
        manager.close();
    }

    public List obtenerVideosPorCategoria(String categoria) {
        manager = emf.createEntityManager();

        List<Object[]> videos = manager.createNativeQuery("SELECT * FROM videos_canal as v WHERE v.categoria='" + categoria + "';").getResultList();

        if (!videos.isEmpty()) {

            List<Video> result = new ArrayList<>();
            videos.forEach((row) -> {

                Canal c = manager.find(Canal.class, (String) row[1]);

                result.add(new Video((String) row[0].toString(), c, (Date) row[2], (String) row[3], (String) row[4], (String) row[5], (String) row[6], (Boolean) row[7]));
            });
            return result;
        }
        return null;
    }

    public List obtenerListasParticularesPorCategoria(String categoria) {
        manager = emf.createEntityManager();

        List<Object[]> listas = manager.createNativeQuery("SELECT * FROM lista_particular_canal as l WHERE l.categoria='" + categoria + "';").getResultList();

        if (!listas.isEmpty()) {

            List<ListaParticulares> result = new ArrayList<>();
            listas.forEach((row) -> {
                Canal c = manager.find(Canal.class, (String) row[2]);
                result.add(new ListaParticulares((Boolean) row[3], (String) row[1], new Categoria((String) row[4]), c));
            });
            return result;
        }
        return null;

        /*String query = "FROM ListaParticulares l WHERE l.categoria='" + categoria + "'";
        List aux = manager.createQuery(query).getResultList();
        if (aux != null) {
            return aux;
        }
        return null;*/
    }

    public List busquedaArborescenteCanales(String text) {
        manager = emf.createEntityManager();
        String query = "FROM Canal c WHERE c.nombre_canal LIKE '%" + text + "%'";
        List aux = manager.createQuery(query).getResultList();
        if (aux != null) {
            return aux;
        }
        return null;
    }

    public List busquedaArborescenteVideos(String text) {
        manager = emf.createEntityManager();

        List<Object[]> videos = manager.createNativeQuery("SELECT * FROM videos_canal as v WHERE v.nombre LIKE '%" + text + "%';").getResultList();

        if (!videos.isEmpty()) {

            List<Video> result = new ArrayList<>();
            videos.forEach((row) -> {

                Canal c = manager.find(Canal.class, (String) row[1]);

                result.add(new Video((String) row[0].toString(), c, (Date) row[2], (String) row[3], (String) row[4], (String) row[5], (String) row[6], (Boolean) row[7]));
            });
            return result;
        }
        return null;
    }

    public List busquedaArborescenteListasParticulares(String text) {
        manager = emf.createEntityManager();

        manager = emf.createEntityManager();
        String query = "FROM ListaParticulares c WHERE c.nombreLista LIKE '%" + text + "%'";
        List aux = manager.createQuery(query).getResultList();
        if (aux != null) {
            return aux;
        }
        return null;
    }

    public Usuario buscarUser2(String canal) {
        manager = emf.createEntityManager();
        Usuario user;
        user = (Usuario) manager.createQuery("select u FROM Usuario u WHERE u.canal='" + canal + "'").getSingleResult();
        return user;
    }

    public void borrarValoracion(Valorar v) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createNativeQuery("delete from valorar where dueño_Vid='" + v.getDuenio().getNickname() + "' and video='" + v.getVid() + "' and usuario='" + v.getUser() + "';");
        query.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
    }

    public Video buscoVideoMasRecienteCanal(Canal canal) {
        manager = emf.createEntityManager();
        try {
            Object[] v = (Object[]) manager.createNativeQuery("SELECT DISTINCT * FROM videos_canal AS v WHERE v.fecha_publicacion = (SELECT MAX(fecha_publicacion) FROM videos_canal AS c WHERE c.nombre_canal ='" + canal.getNombre_canal() + "') and v.nombre_canal='" + canal.getNombre_canal() + "';").getSingleResult();
            Video result = new Video((String) v[0].toString(), canal, (Date) v[2], (String) v[3], (String) v[4], (String) v[5], (String) v[6], (Boolean) v[7]);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public List obtenerTodasListasDefecto() {
        manager = emf.createEntityManager();
        String query = "FROM ListaporDefecto l";
        List<ListaporDefecto> aux = manager.createQuery(query).getResultList();
        if (aux != null) {
            return aux;
        }
        return null;

    }

    public void agregarListasDefecto(List listas, String nickname) {
        manager = emf.createEntityManager();
        if (listas != null) {
            Usuario u = manager.find(Usuario.class, nickname);

            ListaporDefecto l;
            for (int i = 0; i < listas.size(); i++) {
                l = (ListaporDefecto) listas.get(i);
                manager.getTransaction().begin();
                ListaporDefecto lista = new ListaporDefecto(l.getNombreLista(), u.getCanal());
                manager.persist(lista);
                manager.getTransaction().commit();
            }
        }
    }

    public void agregarVideoHistorial(Video v, ListaporDefecto l) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        ListaporDefecto nuevaListaDefecto = manager.find(ListaporDefecto.class, l.getId());
        ListaHistorica aux = manager.find(ListaHistorica.class, new DefectoPK(nuevaListaDefecto.getId(), v.getNombre(), v.getCanal().getNombre_canal()));
        if (aux != null) {
            aux.setCantVistas(aux.getCantVistas()+1);
        }else{
            ListaHistorica nueva = new ListaHistorica(nuevaListaDefecto, v.getNombre(), v.getCanal().getNombre_canal(), 1);
            manager.persist(nueva);
        }
        manager.getTransaction().commit();
        manager.close();
    }

}
