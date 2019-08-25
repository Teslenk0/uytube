/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Normal;
import clases.Usuario;
import controladores.ManejadorInformacion;
import excepciones.UsuarioRepetidoException;
import interfaces.IControladorUsuario;
import java.util.GregorianCalendar;
import DataTypes.DtUsuario;
import DataTypes.DtAdministrador;
import DataTypes.DtNormal;

/**
 *
 * @author tecnologo
 */
public class ControladorUsuario implements IControladorUsuario{
    
    
    
    public void registrarUsuario(DtUsuario u) throws UsuarioRepetidoException{
        ManejadorInformacion mu = ManejadorInformacion.getInstance(); //pido una instancia del manejador
        Usuario user = mu.obtenerUsuario(u.getNickname(),u.getEmail()); //busco si esta o no
        if (user != null)   //si esta tiro exception
            throw new UsuarioRepetidoException("El usuario " + user.getNickname() + " ya esta registrado");
        
       
        //ver como hacer para caster si es admin o usuario normal
        
        //user = new Usuario(n, ap, ci);
        //mu.addUsuario(u);*/
            
        //ManejadorInformacion.registrarUser();
        
    }
    
    
    /**
     * 
     * @param n recibe un usuario normal
     * @param a recibe una tipo Dt Admin
     * @return devuelve true si el parametro "n" es usuario administrador
     */
    public boolean isAdmin(Class<DtUsuario> n,Class<DtAdministrador> a){
        /*if(n instanceof a)
            return true;*/
        return false;
    }
    
}
