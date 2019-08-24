/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import clases.*;
import net.bytebuddy.asm.Advice;

/**
 *
 * @author tecnologo
 */
public class ManejadorInformacion{
    
    private static EntityManager manager; //pido un manager
    
    private static EntityManagerFactory emf;  //pido una fabrica

    public ManejadorInformacion() {
        
    }
    
    public static EntityManager getManager(){
        emf = Persistence.createEntityManagerFactory("uytube-app");
        manager = emf.createEntityManager();
        return manager;
    }
    
    public static void registrarUser(Usuario u){
        
        manager = getManager();
        manager.getTransaction().begin();
        manager.persist(u);
        manager.getTransaction().commit();
        manager.close();
    }
    
    
}
