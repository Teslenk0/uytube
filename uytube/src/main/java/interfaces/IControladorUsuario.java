/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import excepciones.UsuarioRepetidoException;
import DataTypes.DtUsuario;


/**
 *
 * @author tesla
 */
public interface IControladorUsuario {
    
    public abstract void registrarUsuario(DtUsuario u) throws UsuarioRepetidoException;
    
    public abstract boolean isAdmin(DtUsuario u);
}
