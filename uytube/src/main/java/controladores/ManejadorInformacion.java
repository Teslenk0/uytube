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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.TypedQuery;
import org.apache.commons.collections4.ListUtils;

/**
 *
 * @author tecnologo
 */
public class ManejadorInformacion{
    
        
    //private static EntityManager manager; //pido un manager
    private EntityManager manager;

    
    private static EntityManagerFactory emf;  //pido una fabrica
    
    private static ManejadorInformacion instancia;
    
    public ManejadorInformacion() {
        emf = Persistence.createEntityManagerFactory("uytube-app");
    }
    
    public static ManejadorInformacion getInstance() {
        if (instancia == null)
            instancia = new ManejadorInformacion();
        return instancia;
    }
   
    public void registrarUser(Usuario u){
        
        manager = emf.createEntityManager();
        if (u instanceof Administrador){
            Administrador aux = new Administrador(u.getNickname(), u.getContraseña(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFechaNac(), u.getImagen());
            manager.getTransaction().begin();
            manager.persist(aux);
            manager.getTransaction().commit();
            manager.close();
        }else{
            Normal aux = new Normal(u.getNickname(), u.getContraseña(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFechaNac(), u.getImagen());
            manager.getTransaction().begin();
            manager.persist(aux);
            manager.getTransaction().commit();
            manager.close();
        }
    }
    
    
    public Usuario obtenerUsuario(DtUsuario u) {
        manager = emf.createEntityManager();
        if (u instanceof DtAdministrador) {
            if (manager.find(Administrador.class, u.getNickname()) != null) {
                return manager.find(Administrador.class, u.getNickname());
            } else {
                try{
                    String query = "select a from Administrador a where a.email='"+u.getEmail()+"'";
                    TypedQuery<Administrador> consulta = manager.createQuery(query, Administrador.class);
                    return consulta.getSingleResult();
                }catch(NoResultException e){
                    return null;
                }
            }
        }else{
            if(manager.find(Normal.class, u.getNickname()) != null){
                return manager.find(Normal.class, u.getNickname());
            }else{
                try{
                    String query = "select n from Normal n where n.email='"+u.getEmail()+"'";
                    TypedQuery<Normal> consulta = manager.createQuery(query, Normal.class);
                    return consulta.getSingleResult();
                }catch(NoResultException e){
                    return null;
                }
            }
        }
    }
    
    public List ObtenerUsuarios (){
        manager = emf.createEntityManager();
        List<Administrador> usuariosAdm = manager.createQuery("FROM Administrador a").getResultList();
        List<Normal> usuariosNor = manager.createQuery("FROM Normal a").getResultList();
        if(usuariosAdm != null || usuariosNor != null){
             if(usuariosAdm != null && usuariosNor != null){
                 return ListUtils.union(usuariosAdm, usuariosNor);
             }
             else if(usuariosAdm != null ){
                     return usuariosNor;
             }
             else if(usuariosNor != null ){
                     return usuariosAdm;
             }  
         }
         return null;
    }
}
