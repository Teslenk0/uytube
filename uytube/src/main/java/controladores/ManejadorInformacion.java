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

/**
 *
 * @author tecnologo
 */
public class ManejadorInformacion{
    
    private static EntityManager manager; //pido un manager
    
    private static EntityManagerFactory emf;  //pido una fabrica

    private static ManejadorInformacion instancia;
    
    public ManejadorInformacion() {
        emf = Persistence.createEntityManagerFactory("uytube-app");
        manager = emf.createEntityManager();
    }
    
    public static ManejadorInformacion getInstance() {
        if (instancia == null)
            instancia = new ManejadorInformacion();
        return instancia;
    }
   
    public void registrarUser(Usuario u){
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
        if(u instanceof DtAdministrador){
            return manager.find(Administrador.class, new PkUsuario(u.getNickname(),u.getEmail()));
        }else{
            return manager.find(Normal.class, new PkUsuario(u.getNickname(),u.getEmail()));
        }
    }
   
    
    
    
}
