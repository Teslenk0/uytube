/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author esteban
 */
public class DtCanal implements Serializable, Comparable<DtCanal>{
    
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

    @Override
    public String toString() {
        return "DtCanal{" + "nombre_canal=" + nombre_canal + '}';
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre_canal);
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + Objects.hashCode(this.privado);
        hash = 97 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DtCanal other = (DtCanal) obj;
        if (!Objects.equals(this.nombre_canal, other.nombre_canal)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.privado, other.privado)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }
    
    @Override
    public int compareTo(DtCanal other) {
     return this.nombre_canal.compareTo(other.nombre_canal);
   }
}
    
    