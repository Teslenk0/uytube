/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import DataTypes.DtUsuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 
 * @author tesla
 */

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "nickname")
    private String nickname;
    
    @Column(name = "contraseña")
    private String contrasenia;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "email",unique = true)
    private String email;
    
    @Column(name = "fechaNac")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;
    
    @Column(name = "imagen")
    private String imagen;
    
    @OneToOne(cascade = {CascadeType.ALL},targetEntity = Canal.class)
    @JoinColumn(name = "canal")
    private Canal canal;     
    
    public Usuario(){
    }

    public Usuario(String nickname, String contraseña, String nombre, String apellido, String email, Date fechaNac, String imagen) {
        this.nickname = nickname;
        this.contrasenia = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
    }

    public Usuario(String nickname, String contraseña, String nombre, String apellido, String email, Date fechaNac, String imagen, Canal canal) {
        this.nickname = nickname;
        this.contrasenia = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
        this.canal = canal;
    }
    
    public Usuario(DtUsuario usuario){
        this.nickname = usuario.getNickname();
        this.email = usuario.getEmail();
        this.contrasenia = usuario.getContrasenia();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.fechaNac = usuario.getFechaNac();
        this.imagen = usuario.getImagen();
        this.canal = new Canal(usuario.getCanal());
    }


    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contraseña) {
        this.contrasenia = contraseña;
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

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

}
