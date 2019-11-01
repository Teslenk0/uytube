/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DataTypes.DtAuxiliarValorar;
import DataTypes.DtCanal;
import DataTypes.DtUsuario;
import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import fabrica.Fabrica;
import interfaces.IControladorCanal;
import interfaces.IControladorUsuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author isaac
 */
public class ControladorUsuarioIT {

    Fabrica f = Fabrica.getInstance();
    IControladorUsuario controladorUsuario = f.getControladorUsuario();
    IControladorCanal controladorCanal = f.getControladorCanal();
    DtCanal c = new DtCanal("Caste", "Videos de musica", false);

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    Date date = parseDate("1999-11-11");

    DtUsuario u = new DtUsuario("Caste", "123", "Gabriel", "Castellano", "gabrielcastellano263@gmail.com", date, "/imagenesUsuarios/Defecto.png", c);

    public ControladorUsuarioIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testRegistrarUsuario() throws Exception {
        System.out.println("registrarUsuario");
        BufferedImage imagen = null;
        controladorUsuario.registrarUsuario(u, imagen);
        DtUsuario userCreado = controladorUsuario.buscarUsuario(u.getNickname());
        assertNotNull(userCreado);
        //delete from usuario where nickname="Caste";
        //delete from canal_usuario where nombre_canal="Caste";
    }


    @Test
    public void testListaUsuarios() {
        List result = controladorUsuario.listaUsuarios();
        assertNotNull(result);
    }


    @Test
    public void testModificarUsuario() throws Exception {
        DtUsuario user = controladorUsuario.buscarUsuario("cachilas");
        DtUsuario modificado = new DtUsuario(user.getNickname(), "123p", user.getNombre(),user.getApellido(),user.getEmail(),user.getFechaNac(),user.getImagen(),user.getCanal());
        controladorUsuario.modificarUsuario(modificado,modificado.getCanal(),null,false);
        assertNotEquals(user.getContrasenia(),modificado.getContrasenia());
    }//update usuario set contraseña="Sancho456" where nickname="cachilas";


    @Test
    public void testInicioBase() {
        ControladorUsuario instance = new ControladorUsuario();
        try{
            instance.inicioBase();
        }catch (Exception e){
            fail(e.getMessage());
        }
    }


    @Test
    public void testBuscarUsuario() {
        DtUsuario u = controladorUsuario.buscarUsuario("cachilas");
        assertNotNull(u);
        u = controladorUsuario.buscarUsuario("Axel");
        assertNull(u);
    }


    @Test
    public void testBuscarEmail() {
        // email que existe
        String email = "Cachila.sil@c1080.org.uy";
        boolean existe = controladorUsuario.buscarEmail(email);
        assertTrue(existe);
        // email que no existe
        email = "taquejuan@gmail.com";
        existe = controladorUsuario.buscarEmail(email);
        assertFalse(existe);
    }


    @Test
    public void testSeguirUsuario() {
        // caso que existe
        DtUsuario u = controladorUsuario.buscarUsuario("cachilas");
        String seguido = "chino";
        controladorUsuario.seguirUsuario(u,seguido);
        String nomSeguido;
        Boolean esta = false;
        List seguidos =controladorUsuario.listaSeguidos(u.getNickname());
        for(int x = 0; x<seguidos.size(); x++){
            nomSeguido = (String) seguidos.get(x);
            if(nomSeguido.equals(seguido)){
                esta = true;
            }
        }
        assertTrue(esta);
    } // delete from seguir where nickname="cachilas" and seguido="chino";


    @Test
    public void testDejarSeguir_Usuario() {
        // caso que existe
        DtUsuario u = controladorUsuario.buscarUsuario("hrubino");
        String dejarseguido = "hectorg";
        controladorUsuario.DejarSeguir_Usuario(u,dejarseguido);
        String nomSeguido;
        Boolean sigue = false;
        List seguidos =controladorUsuario.listaSeguidos(u.getNickname());
        for(int x = 0; x<seguidos.size(); x++){
            nomSeguido = (String) seguidos.get(x);
            if(!nomSeguido.equals(dejarseguido)){
                sigue = true;
            }
        }
        assertTrue(sigue);
    } //insert into seguir values("hrubino", "hectorg");


    @Test
    public void testListaSeguidos() {
        // caso que sigue usuarios
        DtUsuario user = controladorUsuario.buscarUsuario("juliob");
        List result = controladorUsuario.listaSeguidos(user.getNickname());
        assertNotNull(result);
        // caso que no existe el usuario
        user = controladorUsuario.buscarUsuario("taque");
        if(user!=null) {
            result = controladorUsuario.listaSeguidos(user.getNickname());
            assertNull(result);
        }
    }


    @Test
    public void testListaSeguidores() {
        // caso que sigue usuarios
        DtUsuario user = controladorUsuario.buscarUsuario("tabarec");
        List result = controladorUsuario.listaSeguidores(user.getNickname());
        assertNotNull(result);
    }


    @Test
    public void testValorarVideo() throws Exception {
        DtUsuario user = controladorUsuario.buscarUsuario("hectorg");
        DtUsuario userVal = controladorUsuario.buscarUsuario("marcelot");
        String video = "50 años del InCo";
        String val = "Me gusta";
        controladorUsuario.valorarVideo(user.getNickname(),video,userVal.getNickname(),val);
        DtAuxiliarValorar valoracion;
        Boolean esta = false;
        List valoraciones = controladorCanal.listaMeGustas(user.getNickname());
        for(int x = 0; x<valoraciones.size(); x++){
            valoracion = (DtAuxiliarValorar) valoraciones.get(x);
            if(valoracion.getVid().equals(video) && valoracion.getVal().equals(val) && valoracion.getUser().equals(userVal.getNickname())){
                esta = true;
            }
        }
        assertTrue(esta);

    }


    @Test
    public void testBuscarUsuarioCanal() {
        String canal = "El Cachila";
        DtUsuario user = controladorUsuario.buscarUsuarioCanal(canal);
        assertNotNull(user);
    }

    @Test
    public void testValorarVideoEliminar() {
        DtUsuario user = controladorUsuario.buscarUsuario("hectorg");
        DtUsuario userVal = controladorUsuario.buscarUsuario("kairoh");
        String video = "50 años del InCo";
        String val = "Me gusta";
        controladorUsuario.valorarVideoEliminar(user.getNickname(),video,userVal.getNickname(),val);
        DtAuxiliarValorar valoracion;
        Boolean esta = false;
        List valoraciones = controladorCanal.listaMeGustas(user.getNickname());
        for(int x = 0; x<valoraciones.size(); x++){
            valoracion = (DtAuxiliarValorar) valoraciones.get(x);
            if(valoracion.getVid().equals(video) && valoracion.getVal().equals(val) && valoracion.getUser().equals(userVal.getNickname())){
                esta = true;
            }
        }
        assertFalse(esta);
    }
    
}
/*
    delete from usuario where nickname="Caste";
    delete from canal_usuario where nombre_canal="Caste";
    update usuario set contraseña="Sancho456" where nickname="cachilas";
    delete from seguir where nickname="cachilas" and seguido="chino";
    insert into seguir values("hrubino", "hectorg");
    delete from valorar where dueño_Vid="hectorg" and usuario="marcelot";
    insert into valorar values("hectorg", "50 años del InCo", "kairoh", "Me gusta");
 */