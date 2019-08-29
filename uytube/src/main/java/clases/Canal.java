/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 *
 * @author esteban
 */
@Entity
@Table(name = "canal_usuario")
public class Canal implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @OneToOne
    @JoinColumn(name = "nickname")
    private Usuario usuario;
    
    @Id
    @Column(name = "nombre_canal")
    private String nombre_canal;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "isPrivate")
    private Boolean privado;
    
    public Canal() {
    }

    public Canal(Usuario usuario, String nombre_canal, String descripcion, Boolean privado) {
        this.usuario = usuario;
        this.nombre_canal = nombre_canal;
        this.descripcion = descripcion;
        this.privado = privado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    public String toString() {
        return "Canal{" + "usuario=" + usuario + ", nombre_canal=" + nombre_canal + ", descripcion=" + descripcion + ", privado=" + privado + '}';
    }
}
