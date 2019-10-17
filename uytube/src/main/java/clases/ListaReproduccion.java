/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 *
 * @author esteban
 */

@MappedSuperclass
public abstract class ListaReproduccion implements Serializable{
    
    protected static final long serialVersionUID = 1L;
    
    @Column(name = "nombre_lista")
    protected String nombreLista;
    
    @OneToOne
    @JoinColumn(name = "canal")
    protected Canal canal;
    
    public ListaReproduccion() {
    }

    public ListaReproduccion(String nombreLista) {
        this.nombreLista = nombreLista;
    }
    
    public ListaReproduccion(String nombreLista, Canal canal) {
        this.nombreLista = nombreLista;
        this.canal = canal;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nombreLista);
        hash = 31 * hash + Objects.hashCode(this.canal);
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
        final ListaReproduccion other = (ListaReproduccion) obj;
        if (!Objects.equals(this.nombreLista, other.nombreLista)) {
            return false;
        }
        return Objects.equals(this.canal, other.canal);
    }

    


    
    
}
