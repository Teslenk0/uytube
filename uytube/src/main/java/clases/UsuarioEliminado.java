/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author isaac
 */
@Entity
@Table(name = "usuario_eliminado")
public class UsuarioEliminado implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "canal")
    private String canal;

    public UsuarioEliminado() {
    }

    public UsuarioEliminado(Integer id, String nickname, String email, String canal) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.canal = canal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.nickname);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.canal);
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
        final UsuarioEliminado other = (UsuarioEliminado) obj;
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.canal, other.canal)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    
}
