package clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author diego
 */

@Entity
@Table(name = "categoria_video")

public class Categoria implements Serializable{

    @Id
    @Column(name = "categoria")
    private String nombreCategoria;


    public Categoria(){
    }
    
    public Categoria(String categoria){
        this.nombreCategoria = categoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "nombreCategoria=" + nombreCategoria + '}';
    }
}

