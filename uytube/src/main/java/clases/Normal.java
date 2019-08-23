/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author tesla
 */

@Entity
@Table(name = "usuario_normal")
public class Normal extends Usuario{

    public Normal(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen) {
        super(nickname, nombre, apellido, email, fechaNac, imagen);
    }
   
}
