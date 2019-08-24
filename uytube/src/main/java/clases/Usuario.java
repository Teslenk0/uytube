/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import interfaces.IControladorUsuario;

/**
 * 
 * @author tesla
 */

@MappedSuperclass
@IdClass(PkUsuario.class)
public abstract class Usuario implements Serializable{
    
    protected static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "nickname")
    protected String nickname;
    
    @Column(name = "nombre")
    protected String nombre;
    
    @Column(name = "apellido")
    protected String apellido;
    
    @Id
    @Column(name = "email")
    protected String email;
    
    @Column(name = "fechaNac")
    protected Date fechaNac;
    
    @Column(name = "imagen")
    protected String imagen;

    public Usuario(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
    }
    
 

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nickname=" + nickname + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", fechaNac=" + fechaNac + ", imagen=" + imagen + '}';
    }
    
 
    
}
