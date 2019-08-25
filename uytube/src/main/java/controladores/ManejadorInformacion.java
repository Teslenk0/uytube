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
        manager.getTransaction().begin();
        manager.persist(u);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public Usuario obtenerUsuario(String nickname, String email) {
        return manager.find(Usuario.class, new PkUsuario(nickname,email));
    }
    
    
    
    
}
