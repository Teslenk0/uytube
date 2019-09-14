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
        user.setContraseña(u.getContraseña());
        user.setFechaNac(u.getFechaNac());
        user.setImagen(u.getImagen());
        user.setCanal(c);
        Canal aux = manager.find(Canal.class, u.getCanal().getNombre_canal());
        manager.remove(aux);
        
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
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("delete from Video v where v.canal='" + video.getCanal().getNombre_canal() + "' and v.nombre='" + oldV + "'");
        query.executeUpdate();
        manager.persist(video);
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
         List<Object[]> comentario = manager.createNativeQuery("SELECT comentario, Referencia, Padre, nickname FROM comentarios_video where Video='" + v.getNombre() +"';").getResultList();
         List<DtAuxiliar> comentarios = new ArrayList<>();
         comentario.forEach((row) -> {
             comentarios.add(new DtAuxiliar((String)row[0], (Integer)row[1], (String) row[2], (String) row[3]));
        });
         return comentarios;
    }

    public DtAuxiliar BuscarComentarioRef(String padre) {
        manager = emf.createEntityManager();
        Object[] comentario = ((List<Object[]>)manager.createNativeQuery("SELECT comentario, Referencia, Padre, nickname FROM comentarios_video where Referencia='" + padre +"';").getResultList()).get(0);
        if (comentario != null){
            DtAuxiliar c = new DtAuxiliar( (String)comentario[0], (Integer) comentario[1] , (String)comentario[2], (String)comentario[3]);
            return c;
        }
        return null;
    }

    public String comEsp(Integer num) {
        String query = "SELECT c.comentario FROM Comentario c WHERE c.ref ='" + num + "'";
        return (String) manager.createQuery(query).getSingleResult();
    }

    public List listaTotalComentarios(){
        manager = emf.createEntityManager();
        List<Comentario> comentarios = manager.createQuery("FROM Comentario c").getResultList();
        return comentarios;
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
        ListaParticulares aux = (ListaParticulares) manager.createQuery("FROM ListaParticulares l WHERE l.canal='" + canal + "' and l.nombreLista='" + lista + "'").getSingleResult();
        if (aux != null) {
            return aux;
        }
        return null;
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
    
    public void removerVideoLista(int id, String video, String canalOrigen,Boolean isParticular){
        manager = emf.createEntityManager();
        
        if(isParticular){
            ListaParticularVideos aux =(ListaParticularVideos) manager.createQuery("FROM ListaParticularVideos l WHERE l.id='" + id + "' and l.video='"+video+"' and l.canal='"+canalOrigen+"'").getSingleResult(); 
            manager.getTransaction().begin();
            manager.remove(aux);
            manager.getTransaction().commit();
        }else{
            ListaDefectoVideos aux = (ListaDefectoVideos) manager.createQuery("FROM ListaDefectoVideos l WHERE l.id='" + id + "' and l.video='"+video+"' and l.canal='"+canalOrigen+"'").getSingleResult(); 
            manager.getTransaction().begin();
            manager.remove(aux);
            manager.getTransaction().commit();
        }
        manager.close();
    }
    
    public List obtenerVal(String nick) {
        manager = emf.createEntityManager();
        Usuario u = this.buscadorUsuario(nick);
        List<Object[]> valorar = manager.createNativeQuery("SELECT dueño_Vid, video, usuario, valoracion FROM valorar where dueño_Vid='" + u.getNickname() +"';").getResultList();
        List<AuxiliarValorar> valoraciones = new ArrayList<>();
         valorar.forEach((row) -> {
             valoraciones.add(new AuxiliarValorar((String)row[0], (String)row[1], (String) row[2], (String) row[3]));
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
        Query query = manager.createQuery("delete from Valorar val where val.dueño='" + v.getDueño().getNickname() + "' and val.vid='" + v.getVid() + "' and val.user='" + v.getUser() + "'");
        query.executeUpdate();
        manager.persist(v);
        manager.getTransaction().commit();
        manager.close();
    }
    
}
