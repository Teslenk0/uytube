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
public abstract class DtListaReproduccion implements Serializable, Comparable<DtListaReproduccion>{
    
    protected static final long serialVersionUID = 1L;
    
    protected String nombreLista;
    
    protected DtCanal canal;

    public DtListaReproduccion(String nombreLista, DtCanal canal) {
        this.nombreLista = nombreLista;
        this.canal = canal;
    }

    public DtListaReproduccion(String nombreLista) {
        this.nombreLista = nombreLista;
        this.canal = null;
    }
    
    

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public DtCanal getCanal() {
        return canal;
    }

    public void setCanal(DtCanal canal) {
        this.canal = canal;
    }

    @Override
    public String toString() {
        return "DtListaReproduccion{" + "nombreLista=" + nombreLista + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nombreLista);
        hash = 59 * hash + Objects.hashCode(this.canal);
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
        final DtListaReproduccion other = (DtListaReproduccion) obj;
        if (!Objects.equals(this.nombreLista, other.nombreLista)) {
            return false;
        }
        return Objects.equals(this.canal, other.canal);
    }
    
    
    
    @Override
    public int compareTo(DtListaReproduccion other) {
     return this.nombreLista.compareTo(other.nombreLista);
   }
    
}
