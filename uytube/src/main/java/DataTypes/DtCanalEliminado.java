/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author isaac
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtCanalEliminado implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private DtUsuarioEliminado id;
       
    private String nombre_canal;
    
    private String descripcion;
    
    private Boolean privado;

    public DtCanalEliminado() {
    }

    public DtCanalEliminado(DtUsuarioEliminado id, String nombre_canal, String descripcion, Boolean privado) {
        this.id = id;
        this.nombre_canal = nombre_canal;
        this.descripcion = descripcion;
        this.privado = privado;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public DtUsuarioEliminado getId() {
        return id;
    }

    public String getNombre_canal() {
        return nombre_canal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Boolean getPrivado() {
        return privado;
    }

   
}
    
    