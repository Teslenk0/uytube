/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author esteban
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtUsuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nickname;
    
    private String contrasenia;
    
    private String nombre;
    
    private String apellido;
    
    private String email;
    
    private Date fechaNac;
    
    private String imagen;
    
    private DtCanal canal;

    public DtUsuario(String nickname, String contraseña, String nombre, String apellido, String email, Date fechaNac, String imagen, DtCanal canal) {
        this.nickname = nickname;
        this.contrasenia = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
        this.canal = canal;
    }
    
    public DtUsuario(Usuario u){
        this.nickname = u.getNickname();
        this.contrasenia = u.getContrasenia();
        this.nombre = u.getNombre();
        this.apellido = u.getApellido();
        this.email = u.getEmail();
        this.fechaNac = u.getFechaNac();
        this.imagen = u.getImagen();
        this.canal = new DtCanal(u.getCanal().getNombre_canal(),u.getCanal().getDescripcion(),u.getCanal().getPrivado());
    }
    
    public DtUsuario() {
    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNickname() {
        return nickname;
    }

    public String getContrasenia() {
        return contrasenia;
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

    public DtCanal getCanal() {
        return canal;
    }
    
    
    
}
