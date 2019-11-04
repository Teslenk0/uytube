/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author diego
 */
@XmlAccessorType(XmlAccessType.FIELD)
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
