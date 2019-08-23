/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Usuario;
import java.io.Serializable;

/**
 *
 * @author esteban
 */
public class DtCanal implements Serializable {
    
   protected static final long serialVersionUID = 1L;
   
    protected Usuario user;
    
    protected String descripcion;

    public DtCanal(Usuario user, String descripcion) {
        this.user = user;
        this.descripcion = descripcion;
    }

    public Usuario getUser() {
        return user;
    }

    public String getDescripcion() {
        return descripcion;
    }
   
}
    
    