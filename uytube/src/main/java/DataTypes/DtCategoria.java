/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.io.Serializable;

/**
 *
 * @author diego
 */
public class DtCategoria implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String nombreCategoria;

    public DtCategoria(String s) {
        this.nombreCategoria = s;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getnombreCategoria() {
        return this.nombreCategoria;
    }

}
