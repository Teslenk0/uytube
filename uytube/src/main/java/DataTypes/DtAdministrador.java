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
public class DtAdministrador extends DtUsuario {

    public DtAdministrador(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen) {
        super(nickname, nombre, apellido, email, fechaNac, imagen);
    }
    
}
