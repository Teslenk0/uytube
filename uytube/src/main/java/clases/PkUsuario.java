/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author tesla
 */
public class PkUsuario implements Serializable{
    private String nickname;
    private String email;

    public PkUsuario(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }
}
