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
import java.awt.image.BufferedImage;
import java.util.List;


/**
 *
 * @author tesla
 */
public interface IControladorUsuario {
    
    public abstract void registrarUsuario(DtUsuario u, BufferedImage imagen) throws UsuarioRepetidoException, CanalRepetidoException, EmailRepetidoException;
    
    public abstract List listaUsuarios();
    
    public abstract void inicioBase();
    
    public abstract void modificarUsuario(DtUsuario modUser, DtCanal modCanal, BufferedImage imagen, Boolean cambio) throws CanalRepetidoException;
    
    public abstract DtUsuario buscarUsuario(String nick);
    
    public abstract void seguirUsuario(DtUsuario u, String s);
    
    public abstract void DejarSeguir_Usuario(DtUsuario u, String s);
    
    public abstract List listaSeguidos(String nick);
    
    public abstract List listaSeguidores(String nick);

    public void valorarVideo(String u, String video, String user_val, String val);
}
