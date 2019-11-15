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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author isaac
 */
@Entity
@Table(name = "lista_defecto_canal_eliminada")
public class ListaporDefectoEliminadas implements Serializable{
    
    @ManyToOne(targetEntity = UsuarioEliminado.class)
    @JoinColumn(name = "id_user")
    private UsuarioEliminado id_user;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre_lista")
    private String nombre_lista;
   
    
    public ListaporDefectoEliminadas() {
    }

    public ListaporDefectoEliminadas(UsuarioEliminado id_user, String nombre_lista) {
        this.id_user = id_user;
        this.nombre_lista = nombre_lista;
    }

    public UsuarioEliminado getId_user() {
        return id_user;
    }

    public void setId_user(UsuarioEliminado id_user) {
        this.id_user = id_user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_lista() {
        return nombre_lista;
    }

    public void setNombre_lista(String nombre_lista) {
        this.nombre_lista = nombre_lista;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id_user);
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.nombre_lista);
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
        final ListaporDefectoEliminadas other = (ListaporDefectoEliminadas) obj;
        if (!Objects.equals(this.nombre_lista, other.nombre_lista)) {
            return false;
        }
        if (!Objects.equals(this.id_user, other.id_user)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
}
