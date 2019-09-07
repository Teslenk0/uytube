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
        user = new Usuario(u.getNickname(), u.getContraseña(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFechaNac(), u.getImagen(),c);
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
        manager=emf.createEntityManager();
        return manager.createQuery("SELECT s.seguidos FROM Seguir s WHERE s.us = '" + nickname + "'")
                .getResultList();
    }
    
    public List ObtenerSeguidores(String nick) {
        manager=emf.createEntityManager();
        return manager.createQuery("SELECT s.us FROM Seguir s WHERE s.seguidos = '" + nick + "'")
                .getResultList();
    }
    
    public Usuario buscadorUsuario(String nick) {
        manager = emf.createEntityManager();
        Usuario user = manager.find(Usuario.class, nick);
        return user;
    }
    
    public void altaVideo(Video video){
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(video);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List listaVid(Canal c){
        manager = emf.createEntityManager();
        return manager.createQuery("SELECT v.nombre FROM Video v WHERE v.canal = '" + c.getNombre_canal() + "'")
                .getResultList();
    }
    
    public List listaCom(String v){
        manager = emf.createEntityManager();
        return manager.createQuery("SELECT c.comentario FROM Comentario c WHERE c.video = '" + v + "'")
                .getResultList();
    }
    
    public void crearListaDefecto(ListaReproduccion list){
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(list);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List obtenerCanales(){
        manager = emf.createEntityManager();
        List <Canal> canales = manager.createQuery("FROM Canal").getResultList();
        if(canales != null){
            return canales;
        }
        return null;
    }
}
