/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import clases.Usuario;
import excepciones.UsuarioRepetidoException;
import interfaces.IControladorUsuario;
import DataTypes.DtUsuario;
import DataTypes.DtCanal;
import clases.Canal;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author tecnologo
 */
public class ControladorUsuario implements IControladorUsuario{
    
    
    @Override
    public void registrarUsuario(DtUsuario u, BufferedImage imagen) throws UsuarioRepetidoException{
        ManejadorInformacion mu = ManejadorInformacion.getInstance(); //pido una instancia del manejador
        
        Usuario user = mu.obtenerUsuario(u); //busco si esta o no
        if (user != null) {
            throw new UsuarioRepetidoException("El usuario " + user.getNickname() + " ya existe");
        }
       
        Canal canal = new Canal(u.getCanal().getNombre_canal(),u.getCanal().getDescripcion(),u.getCanal().getPrivado());
        mu.crearCanal(canal);
        
        user = new Usuario(u.getNickname(), u.getContraseña(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFechaNac(), u.getImagen(),canal);
              
        mu.registrarUser(user);
            
        if(imagen != null){
            String path = System.getProperty("user.dir");
            path = path + "/src/main/resources/imagenesUsuarios/" + u.getNickname() + ".png";
            File file = new File(path);
            try {
                ImageIO.write(imagen, "png", file);
            } catch (IOException ex) {
                Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
     /**
     *
     * @return
     */
    @Override
    public List listaUsuarios() {
        ManejadorInformacion mu = ManejadorInformacion.getInstance(); //pido una instancia del manejador
        List lista = mu.ObtenerUsuarios();
        if (lista != null) {
            List aux = new LinkedList();
            DtUsuario dtaux;
            for (int x = 0; x < lista.size(); x++) {
                dtaux = new DtUsuario((Usuario) lista.get(x));
                aux.add(dtaux);
            }
            return aux;
        }
        return null;
    }
    
   
    public void inicioBase(){
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        mu.iniciarConexionInicial();
    }
}
