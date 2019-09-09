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
import excepciones.VideoRepetidoException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author tecnologo
 */
public class ManejadorInformacion {

    private boolean conexionIniciada = false;
    //private static EntityManager manager; //pido un manager
    private EntityManager manager;

    private static EntityManagerFactory emf;  //pido una fabrica

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

    public Usuario obtenerUsuario(DtUsuario u) {
        manager = emf.createEntityManager();
        if (manager.find(Usuario.class, u.getNickname()) != null) {
            return manager.find(Usuario.class, u.getNickname());
        } else {
            try {
                String query = "select u from Usuario u where u.email='" + u.getEmail() + "'";
                TypedQuery<Usuario> consulta = manager.createQuery(query, Usuario.class);
                return consulta.getSingleResult();
            } catch (NoResultException e) {
                return null;
            }
        }

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
        manager.remove(user);
        user = new Usuario(u.getNickname(), u.getContraseña(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFechaNac(), u.getImagen(), c);
        manager.persist(user);
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
        return manager.createQuery("SELECT s.seguidos FROM Seguir s WHERE s.us = '" + nickname + "'")
                .getResultList();
    }

    public List ObtenerSeguidores(String nick) {
        manager = emf.createEntityManager();
        return manager.createQuery("SELECT s.us FROM Seguir s WHERE s.seguidos = '" + nick + "'")
                .getResultList();
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
        Video vid = manager.find(Video.class, oldV);
        manager.remove(vid);
        manager.merge(video);
        manager.getTransaction().commit();
        manager.close();
    }

    public List listaVid(Canal c){
        manager = emf.createEntityManager();
        return manager.createQuery("SELECT v FROM Video v WHERE v.canal = '" + c.getNombre_canal() + "'")
                .getResultList();
    }

    public List listaCom(String v) {
        manager = emf.createEntityManager();
        return manager.createQuery("SELECT c FROM Comentario c WHERE c.video = '" + v + "'")
                .getResultList();
    }

    public List listaResp(String com) {
        manager = emf.createEntityManager();
        return manager.createQuery("SELECT r FROM Respuestas r WHERE r.comentario = '" + com + "'")
                .getResultList();
    }

    public void addComentario(Comentario c) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void addRespuesta(Respuestas r) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(r);
        manager.getTransaction().commit();
        manager.close();
    }

    public Video buscadorVideo(String v) {
        manager = emf.createEntityManager();
        return manager.find(Video.class, v);
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
        List<Canal> canales = manager.createQuery("FROM Canal").getResultList();
        if (canales != null) {
            return canales;
        }
        return null;
    }

    public Boolean buscoListaDefecto(String nombre) {
        manager = emf.createEntityManager();
        int resultado = manager.createQuery("FROM ListaporDefecto l WHERE l.nombreLista='" + nombre + "'").getResultList().size(); //busco si ya existe
        if (resultado != 0) {
            return true;
        }
        return false;
    }

    public Boolean buscoListaParticular(String nombreLista, String nombreCanal) {
        manager = emf.createEntityManager();
        int resultado = manager.createQuery("FROM ListaParticulares l WHERE l.nombreLista='" + nombreLista + "' and l.canal='" + nombreCanal + "'").getResultList().size(); //busco si ya existe
        if (resultado != 0) {
            return true;
        }
        return false;
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
        //System.out.println(list.getCategoria().getNombreCategoria());
        aux.setPrivado(list.getPrivado());
        manager.getTransaction().commit();
        manager.close();
    }
}
