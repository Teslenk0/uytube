/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import javax.swing.SwingUtilities;

/**
 *
 * @author tesla
 */
public class Main {
    
    public static void main(String args[]){
        SwingUtilities.invokeLater(() -> {
            new Menu().setVisible(true);
        });
        
    }
}
