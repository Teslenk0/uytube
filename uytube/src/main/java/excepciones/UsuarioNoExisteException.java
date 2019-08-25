/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author tesla
 */
public class UsuarioNoExisteException extends Exception {

    public UsuarioNoExisteException(String message) {
        super(message);
    }
    
}
