/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DataTypes.DtCanal;
import excepciones.UsuarioRepetidoException;
import DataTypes.DtUsuario;
import excepciones.CanalRepetidoException;
import excepciones.EmailRepetidoException;
import excepciones.ValoracionException;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;


/**
 *
 * @author tesla
 */
@WebService
public interface IControladorUsuario {
    
    @WebMethod
    public abstract void registrarUsuario(DtUsuario u, BufferedImage imagen) throws UsuarioRepetidoException, CanalRepetidoException, EmailRepetidoException;
    
    @WebMethod
    public abstract List listaUsuarios();
    
    @WebMethod
    public abstract void inicioBase();
    
    @WebMethod
    public abstract void modificarUsuario(DtUsuario modUser, DtCanal modCanal, BufferedImage imagen, Boolean cambio) throws CanalRepetidoException;
    
    @WebMethod
    public abstract DtUsuario buscarUsuario(String nick);
    
    @WebMethod
    public abstract boolean buscarEmail(String Email);
    
    @WebMethod
    public abstract void seguirUsuario(DtUsuario u, String s);
    
    @WebMethod
    public abstract void DejarSeguir_Usuario(DtUsuario u, String s);
    
    @WebMethod
    public abstract List listaSeguidos(String nick);
    
    @WebMethod
    public abstract List listaSeguidores(String nick);
    
    @WebMethod
    public abstract void valorarVideo(String u, String video, String user_val, String val) throws ValoracionException;
    
    @WebMethod
    public abstract DtUsuario buscarUsuarioCanal(String c);
    
    @WebMethod
    public abstract void valorarVideoEliminar(String u, String video, String user_val, String val);
    
    @WebMethod
    public abstract void eliminarUsuario(String nickname);
    
    @WebMethod
    public abstract void uploadImage(String fileName, byte[] imageBytes);
     
    @WebMethod
    public abstract byte[] downloadImage(String fileName);    
}
