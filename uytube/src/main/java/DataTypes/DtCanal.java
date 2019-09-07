/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.io.Serializable;

/**
 *
 * @author esteban
 */
public class DtCanal implements Serializable {
    
    private static final long serialVersionUID = 1L;
       
    private final String nombre_canal;
    
    private final String descripcion;
    
    private final Boolean privado;
    
    private final DtUsuario usuario;


    public DtCanal(String nombre_canal, String descripcion, Boolean privado) {
        
        this.nombre_canal = nombre_canal;
        this.descripcion = descripcion;
        this.privado = privado;
        this.usuario = null;
    }
    
    public DtCanal(String nombre_canal, String descripcion, Boolean privado, DtUsuario usuario) {
        this.nombre_canal = nombre_canal;
        this.descripcion = descripcion;
        this.privado = privado;
        this.usuario = usuario;
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
    
    public DtUsuario getUsuario() {
        return usuario;
    }
}
    
    