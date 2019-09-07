/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Categoria;
import clases.Video;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author esteban
 */
public abstract class DtListaReproduccion implements Serializable{
    
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
        return "DtListaReproduccion{" + "nombreLista=" + nombreLista + ", canal=" + canal + '}';
    }
    
    
}
