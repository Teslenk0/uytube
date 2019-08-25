/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Normal;
import clases.Usuario;
import excepciones.UsuarioRepetidoException;
import interfaces.IControladorUsuario;
import DataTypes.DtUsuario;
import DataTypes.DtAdministrador;
import clases.Administrador;

/**
 *
 * @author tecnologo
 */
public class ControladorUsuario implements IControladorUsuario{
    
    
    @Override
    public void registrarUsuario(DtUsuario u) throws UsuarioRepetidoException{
        ManejadorInformacion mu = ManejadorInformacion.getInstance(); //pido una instancia del manejador
        Usuario user = mu.obtenerUsuario(u.getNickname(),u.getEmail()); //busco si esta o no
        if (user != null)   //si esta tiro exception
            throw new UsuarioRepetidoException("El usuario " + user.getNickname() + " ya existe");
        
        if(isAdmin(u)){
            mu.registrarUser(new Administrador(u.getNickname(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFechaNac(), u.getImagen()));
        }else{
            mu.registrarUser(new Normal(u.getNickname(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFechaNac(), u.getImagen()));
        }   
    }
    
    
    /**
     * 
     * @param u recibe un datatype usuario
     * @return devuelve true si el parametro "n" es usuario administrador
     */
    public boolean isAdmin(DtUsuario u){
        if(u instanceof DtAdministrador) //pregunto si es admin o no
            return true;
        return false;
    }
    
}
