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
   
    protected String usuario;
    
    protected String descripcion;
    
    protected Boolean privado;

    public DtCanal(String usuario, String descripcion, Boolean privado) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.privado = privado;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Boolean getPrivado() {
        return privado;
    }
}
    
    