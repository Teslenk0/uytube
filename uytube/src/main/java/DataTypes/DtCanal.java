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
   
    private final String nickname;
    
    private final String nombre_canal;
    
    private final String descripcion;
    
    private final Boolean privado;

    public DtCanal(String nickname, String nombre_canal, String descripcion, Boolean privado) {
        this.nickname = nickname;
        this.nombre_canal = nombre_canal;
        this.descripcion = descripcion;
        this.privado = privado;
    }

    public String getNickname() {
        return nickname;
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
    
    