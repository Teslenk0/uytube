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
@Table(name = "lista_particular_canal_eliminada")
public class ListaParticularesEliminadas implements Serializable{
    
    @ManyToOne(targetEntity = UsuarioEliminado.class)
    @JoinColumn(name = "id_user")
    private UsuarioEliminado id_user;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre_lista")
    private String nombre_lista;
   
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "privada")
    private Boolean privado;
    
    public ListaParticularesEliminadas() {
    }

    public ListaParticularesEliminadas(UsuarioEliminado id_user, String nombre_lista, String categoria, Boolean privado) {
        this.id_user = id_user;
        this.nombre_lista = nombre_lista;
        this.categoria = categoria;
        this.privado = privado;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id_user);
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nombre_lista);
        hash = 97 * hash + Objects.hashCode(this.categoria);
        hash = 97 * hash + Objects.hashCode(this.privado);
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
        final ListaParticularesEliminadas other = (ListaParticularesEliminadas) obj;
        if (!Objects.equals(this.nombre_lista, other.nombre_lista)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.id_user, other.id_user)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.privado, other.privado);
    }

    
}
