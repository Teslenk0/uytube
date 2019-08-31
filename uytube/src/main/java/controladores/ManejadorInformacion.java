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
        
        
        //esto cambia solo el canal, hay que hacer que cambie todos los datos ingresadis
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Usuario user = manager.find(Usuario.class, u.getNickname());
        manager.remove(user.getCanal());
        user.setCanal(c);
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
}
