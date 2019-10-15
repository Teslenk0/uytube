/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import DataTypes.DtListaporDefecto;
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
@Table(name = "lista_defecto_canal")
public class ListaporDefecto extends ListaReproduccion{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    public ListaporDefecto() {
    }

    public ListaporDefecto(String nombreLista) {
        super(nombreLista,null);
    }

    public ListaporDefecto(String nombreLista, Canal canal) {
        super(nombreLista, canal);
    }
    
    public ListaporDefecto(DtListaporDefecto lista){
        this.nombreLista = lista.getNombreLista();
        this.canal = new Canal(lista.getCanal());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
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
        final ListaporDefecto other = (ListaporDefecto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "ListaporDefecto{" + "id=" + id + '}';
    }
    
    
    
}
