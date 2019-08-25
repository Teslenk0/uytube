/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.util.Date;

/**
 *
 * @author esteban
 */
public class DtNormal extends DtUsuario {

    public DtNormal(String nickname, String contraseña, String nombre, String apellido, String email, Date fechaNac, String imagen) {
        super(nickname, contraseña, nombre, apellido, email, fechaNac, imagen);
    }
    
}
