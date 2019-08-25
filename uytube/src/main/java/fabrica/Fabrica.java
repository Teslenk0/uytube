/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica;

import controladores.ControladorCanal;
import controladores.ControladorUsuario;
import interfaces.IControladorCanal;
import interfaces.IControladorUsuario;

/**
 *
 * @author tecnologo
 */
public class Fabrica {

   private static Fabrica instancia;
    
   private Fabrica(){
       
   }
   
   public static Fabrica getInstance(){
       if(instancia == null)
           instancia = new Fabrica();
       return instancia;
   }
   
   public IControladorUsuario getControladorUsuario(){
       return new ControladorUsuario();
   }
   
   public IControladorCanal getControladorCanal(){
       return new ControladorCanal();
   }
}