/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import fabrica.ManejadorInformacion;
import interfaces.IControladorUsuario;
import java.util.GregorianCalendar;

/**
 *
 * @author tecnologo
 */
public class ControladorUsuario implements IControladorUsuario{
    
    
    
    public void registrarUsuario(){
        Usuario u = new Normal("gabriel6211", "gabriel", "castellano", "ese@sapbe", new GregorianCalendar(12,11,12).getTime(), "ninguna");
        ManejadorInformacion.registrarUser(u);
    }
    
}
