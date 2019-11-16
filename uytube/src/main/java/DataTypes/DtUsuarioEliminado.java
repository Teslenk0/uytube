/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.UsuarioEliminado;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author isaac
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtUsuarioEliminado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String nickname;
    
    private String nombre;
    
    private String apellido;
    
    private String email;
    
    private Date fechaNac;
    
    private String canal;

    public DtUsuarioEliminado() {
    }

    public DtUsuarioEliminado(Integer id, String nickname, String nombre, String apellido, String email, Date fechaNac, String canal) {
        this.id = id;
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.canal = canal;
    }
    
    public DtUsuarioEliminado(UsuarioEliminado us) {
        this.id = us.getId();
        this.nickname = us.getNickname();
        this.nombre = us.getNombre();
        this.apellido = us.getApellido();
        this.email = us.getEmail();
        this.fechaNac = us.getFechaNac();
        this.canal = us.getCanal();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
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

    public String getCanal() {
        return canal;
    }

    
}
