/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.io.Serializable;

/**
 *
 * @author Tesla
 */
public class DtListaporDefecto extends DtListaReproduccion implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public DtListaporDefecto(String nombreLista, DtCanal canal) {
        super(nombreLista, canal);
    }

    public DtListaporDefecto(String nombreLista) {
        super(nombreLista);
    }
    
}

