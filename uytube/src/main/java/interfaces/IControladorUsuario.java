/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DataTypes.DtCanal;
import excepciones.UsuarioRepetidoException;
import DataTypes.DtUsuario;
import java.awt.image.BufferedImage;
import java.util.List;


/**
 *
 * @author tesla
 */
public interface IControladorUsuario {
    
    public abstract void registrarUsuario(DtUsuario u, DtCanal c, BufferedImage imagen) throws UsuarioRepetidoException;
    
    public abstract boolean isAdmin(DtUsuario u);
    
    public abstract List listaUsuarios();
}
