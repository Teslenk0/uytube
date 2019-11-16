/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import clases.ListaParticularesEliminadas;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author isaac
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtListaParticularesEliminadas implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Integer id_user;
    
    private Integer id;
    
    private String nombre_lista;
    
    private String categoria;
    
    private Boolean privado;

    public DtListaParticularesEliminadas() {
    }

    public DtListaParticularesEliminadas(Integer id_user, Integer id, String nombre_lista, String categoria, Boolean privado) {
        this.id_user = id_user;
        this.id = id;
        this.nombre_lista = nombre_lista;
        this.categoria = categoria;
        this.privado = privado;
    }

    public DtListaParticularesEliminadas(ListaParticularesEliminadas li) {
        this.id_user = li.getId_user().getId();
        this.id = li.getId();
        this.nombre_lista = li.getNombre_lista();
        this.categoria = li.getCategoria();
        this.privado = li.getPrivado();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId_user() {
        return id_user;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre_lista() {
        return nombre_lista;
    }

    public String getCategoria() {
        return categoria;
    }

    public Boolean getPrivado() {
        return privado;
    }
    
    
}
