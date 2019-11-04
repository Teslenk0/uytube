/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author esteban
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtListaParticulares extends DtListaReproduccion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private final Boolean privado;
    
    private final DtCategoria categoria;

    public DtListaParticulares(Boolean privado, String nombreLista, DtCategoria categoria, DtCanal canal) {
        super(nombreLista, canal);
        this.privado = privado;
        this.categoria = categoria;
    }

    public DtListaParticulares(Boolean privado, DtCategoria categoria,String nombreLista) {
        super(nombreLista);
        this.privado = privado;
        this.categoria = categoria;
    }

    public Boolean getPrivado() {
        return privado;
    }

    public DtCategoria getCategoria() {
        return categoria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.privado);
        hash = 23 * hash + Objects.hashCode(this.categoria);
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
        final DtListaParticulares other = (DtListaParticulares) obj;
        if (!Objects.equals(this.privado, other.privado)) {
            return false;
        }
        return Objects.equals(this.categoria, other.categoria);
    }
    
    
}
