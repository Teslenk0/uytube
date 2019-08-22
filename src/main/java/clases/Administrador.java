/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;
//import javax.persistence.Entity;

/**
 *
 * @author tesla
 */

public class Administrador extends Usuario{

    public Administrador(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen) {
        super(nickname, nombre, apellido, email, fechaNac, imagen);
    }

   
}
