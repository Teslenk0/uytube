/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;
/**
 *
 * @author esteban
 */
public class DtListaParticulares extends DtListaReproduccion{
    
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
}
