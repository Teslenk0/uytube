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
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author tesla
 */
public class Main {

    private static final String DEFAULT_USER_WS = "http://0.0.0.0:17183/UsuarioWs";

    private static final String DEFAULT_CANAL_WS = "http://0.0.0.0:17184/CanalWs";

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new Menu().setVisible(true);

            fabrica.Fabrica factory = fabrica.Fabrica.getInstance();
            IControladorCanal controladorCanal = factory.getControladorCanal();
            IControladorUsuario controladorUsuario = factory.getControladorUsuario();

            ExecutorService es = Executors.newFixedThreadPool(5);

            String user = System.getProperty("user.name");

            String urlUserWs = Main.DEFAULT_USER_WS;
            String urlCanalWs = Main.DEFAULT_CANAL_WS;

            //Obtengo el archivo
            File properties = new File("/home/" + user + "/.UyTube/properties.xml");

            /**
             * Si existe leo el archivo, sino creo uno nuevo y le seteo los
             * parametros por defecto.
             */
            if (properties.exists()) {

                //LEO EL ARCHIVO UTILIZANDO ESTO
                try {
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

                    //LO PARSEO
                    Document document = documentBuilder.parse(properties);

                    //OBTENGO EL TEXTO DE ADENTRO DE LOS TAGs
                    urlCanalWs = document.getElementsByTagName("canalws").item(0).getTextContent();
                    urlUserWs = document.getElementsByTagName("usuariows").item(0).getTextContent();

                } catch (SAXException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                //Busco la carpeta
                File directorio = new File("/home/" + user + "/.UyTube");

                //Si no existe, la creo
                if (!directorio.exists()) {
                    directorio.mkdir();
                }

                /**
                 * EN CASO DE QUE NO EXISTA EL ARCHIVO,
                 * TOMA LOS DATOS DE LAS CONSTANTES DEFINIDAS ARRIBA
                 * COMO POR DEFECTO.
                 */
                try {
                    properties.createNewFile();
                    propertiesCreator(user);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TransformerException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            Endpoint.publish(urlCanalWs, controladorCanal).setExecutor(es);
            Endpoint.publish(urlUserWs, controladorUsuario).setExecutor(es);
        });

    }

    public static void propertiesCreator(String user) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        //Creo la etiqueta raiz
        Element rootElement = doc.createElement("host");
        doc.appendChild(rootElement);

        //Voy creando las otras etiquetas
        Element canalWs = doc.createElement("canalws");
        canalWs.appendChild(doc.createTextNode(Main.DEFAULT_CANAL_WS));
        rootElement.appendChild(canalWs);

        Element userWs = doc.createElement("usuariows");
        userWs.appendChild(doc.createTextNode(Main.DEFAULT_USER_WS));
        rootElement.appendChild(userWs);

        //Transformo el archivo a xml y lo creo
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("/home/" + user + "/.UyTube/properties.xml"));
        transformer.transform(source, result);

    }
}
