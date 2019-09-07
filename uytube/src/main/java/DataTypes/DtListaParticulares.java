/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.Categoria;
import clases.Video;
import java.util.List;

/**
 *
 * @author esteban
 */
public class DtListaParticulares extends DtListaReproduccion{
    
    private final Boolean privado;

    public DtListaParticulares(Boolean privado, String nombreLista, DtCanal canal) {
        super(nombreLista, canal);
        this.privado = privado;
    }

    public DtListaParticulares(Boolean privado, String nombreLista) {
        super(nombreLista);
        this.privado = privado;
    }

    public Boolean getPrivado() {
        return privado;
    }
    
}
