/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Usuario;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author esteban
 */
public class DtUsuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private final String nickname;
    
    private final String contraseña;
    
    private final String nombre;
    
    private final String apellido;
    
    private final String email;
    
    private final Date fechaNac;
    
    private final String imagen;

    public DtUsuario(String nickname, String contraseña, String nombre, String apellido, String email, Date fechaNac, String imagen) {
        this.nickname = nickname;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
    }
    
    public DtUsuario(Usuario u){
        this.nickname = u.getNickname();
        this.contraseña = u.getContraseña();
        this.nombre = u.getNombre();
        this.apellido = u.getApellido();
        this.email = u.getEmail();
        this.fechaNac = u.getFechaNac();
        this.imagen = u.getImagen();
    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNickname() {
        return nickname;
    }

    public String getContraseña() {
        return contraseña;
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
