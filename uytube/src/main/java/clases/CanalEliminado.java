/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author isaac
 */
@Entity
@Table(name = "canal_eliminado")
public class CanalEliminado implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @OneToOne(targetEntity = UsuarioEliminado.class)
    @JoinColumn(name = "id")
    private UsuarioEliminado id;
    
    @Column(name = "nombre_canal")
    private String nombre_canal;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "isPrivate")
    private Boolean privado;

    public CanalEliminado() {
    }

    public CanalEliminado(UsuarioEliminado id, String nombre_canal, String descripcion, Boolean privado) {
        this.id = id;
        this.nombre_canal = nombre_canal;
        this.descripcion = descripcion;
        this.privado = privado;
    }

    public UsuarioEliminado getId() {
        return id;
    }

    public void setId(UsuarioEliminado id) {
        this.id = id;
    }

    public String getNombre_canal() {
        return nombre_canal;
    }

    public void setNombre_canal(String nombre_canal) {
        this.nombre_canal = nombre_canal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.nombre_canal);
        hash = 47 * hash + Objects.hashCode(this.descripcion);
        hash = 47 * hash + Objects.hashCode(this.privado);
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
        final CanalEliminado other = (CanalEliminado) obj;
        if (!Objects.equals(this.nombre_canal, other.nombre_canal)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.privado, other.privado);
    }

   
}
