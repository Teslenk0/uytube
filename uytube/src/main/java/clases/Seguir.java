package clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seguir")

public class Seguir implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "nickname")
    private Usuario usuario;
    
    @Column(name = "seguido")
    private String seguidos;

    public Seguir() {
    
    }

    public Seguir(Usuario usuario, String seguidos) {
        this.usuario = usuario;
        this.seguidos = seguidos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSeguidos() {
        return seguidos;
    }

    public void setSeguidos(String seguidos) {
        this.seguidos = seguidos;
    }

    @Override
    public String toString() {
        return "Seguir{" + "usuario=" + usuario + ", seguidos=" + seguidos + '}';
    }
    
}
