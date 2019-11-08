 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import javax.swing.SwingUtilities;
import javax.xml.ws.Endpoint;
import interfaces.IControladorCanal;
import interfaces.IControladorUsuario;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author tesla
 */
public class Main {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new Menu().setVisible(true);
            fabrica.Fabrica factory = fabrica.Fabrica.getInstance();
            IControladorCanal controladorCanal = factory.getControladorCanal();
            IControladorUsuario controladorUsuario = factory.getControladorUsuario();
            ExecutorService es = Executors.newFixedThreadPool(5);
            Endpoint.publish("http://0.0.0.0:17184/CanalWs", controladorCanal).setExecutor(es);
            Endpoint.publish("http://0.0.0.0:17183/UsuarioWs", controladorUsuario).setExecutor(es);
        });

    }
}
