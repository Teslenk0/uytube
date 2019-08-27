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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author tecnologo
 */
public class ControladorUsuario implements IControladorUsuario{
    
    
    @Override
    public void registrarUsuario(DtUsuario u, DtCanal canal, BufferedImage imagen) throws UsuarioRepetidoException{
        ManejadorInformacion mu = ManejadorInformacion.getInstance(); //pido una instancia del manejador
        
        Usuario user = mu.obtenerUsuario(u); //busco si esta o no
        if (user != null) {
            throw new UsuarioRepetidoException("El usuario " + user.getNickname() + " ya existe");
        }
        mu.registrarUser(new Usuario(u.getNickname(), u.getContraseña(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFechaNac(), u.getImagen()));

        if(imagen != null){
            //con esto saco el path de donde esta el proyecto
        String path = System.getProperty("user.dir");
        
        //lo concateno
        path = path + "/src/main/resources/imagenesUsuarios/" + u.getNickname() + ".png";
        
        
        File file = new File(path);
        try {
            ImageIO.write(imagen, "png", file);
        } catch (IOException ex) {
            //Logger.getLogger(SeleccionarImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
     /**
     *
     * @return
     */
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
    
   
    
}
