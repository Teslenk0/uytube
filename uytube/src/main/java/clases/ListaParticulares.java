/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author esteban
 */
@Entity
@Table(name = "lista_particular_canal")
public class ListaParticulares extends ListaReproduccion {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "privada")
    private Boolean privado;
    
    
    
    //private Categoria categoria;

    public ListaParticulares() {
    }

    public ListaParticulares(Boolean privado) {
        this.privado = privado;
    }

    public ListaParticulares(Boolean privado, String nombreLista) {
        super(nombreLista);
        this.privado = privado;
    }

    public ListaParticulares(Boolean privado, String nombreLista, Canal canal) {
        super(nombreLista, canal);
        this.privado = privado;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.privado);
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
        final ListaParticulares other = (ListaParticulares) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.privado, other.privado)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
