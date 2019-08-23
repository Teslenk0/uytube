/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author esteban
 */
public class DtUsuario implements Serializable {
    
    protected static final long serialVersionUID = 1L;
    
    protected String nickname;
    
    protected String nombre;
    
    protected String apellido;
    
    protected String email;
    
    protected Date fechaNac;
    
    protected String imagen;

    public DtUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public String getImagen() {
        return imagen;
    }
    
}
