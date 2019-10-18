/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DataTypes.DtCanal;
import DataTypes.DtUsuario;
import java.awt.image.BufferedImage;
import java.util.List;
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

    /**
     * Test of registrarUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testRegistrarUsuario() throws Exception {
        System.out.println("registrarUsuario");
        DtUsuario u = null;
        BufferedImage imagen = null;
        ControladorUsuario instance = new ControladorUsuario();
        instance.registrarUsuario(u, imagen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaUsuarios method, of class ControladorUsuario.
     */
    @Test
    public void testListaUsuarios() {
        System.out.println("listaUsuarios");
        ControladorUsuario instance = new ControladorUsuario();
        List expResult = null;
        List result = instance.listaUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testModificarUsuario() throws Exception {
        System.out.println("modificarUsuario");
        DtUsuario u = null;
        DtCanal c = null;
        BufferedImage imagen = null;
        Boolean cambio = null;
        ControladorUsuario instance = new ControladorUsuario();
        instance.modificarUsuario(u, c, imagen, cambio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inicioBase method, of class ControladorUsuario.
     */
    @Test
    public void testInicioBase() {
        System.out.println("inicioBase");
        ControladorUsuario instance = new ControladorUsuario();
        instance.inicioBase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testBuscarUsuario() {
        System.out.println("buscarUsuario");
        String nick = "";
        ControladorUsuario instance = new ControladorUsuario();
        DtUsuario expResult = null;
        DtUsuario result = instance.buscarUsuario(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarEmail method, of class ControladorUsuario.
     */
    @Test
    public void testBuscarEmail() {
        System.out.println("buscarEmail");
        String email = "";
        ControladorUsuario instance = new ControladorUsuario();
        boolean expResult = false;
        boolean result = instance.buscarEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seguirUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testSeguirUsuario() {
        System.out.println("seguirUsuario");
        DtUsuario u = null;
        String s = "";
        ControladorUsuario instance = new ControladorUsuario();
        instance.seguirUsuario(u, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DejarSeguir_Usuario method, of class ControladorUsuario.
     */
    @Test
    public void testDejarSeguir_Usuario() {
        System.out.println("DejarSeguir_Usuario");
        DtUsuario u = null;
        String s = "";
        ControladorUsuario instance = new ControladorUsuario();
        instance.DejarSeguir_Usuario(u, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaSeguidos method, of class ControladorUsuario.
     */
    @Test
    public void testListaSeguidos() {
        System.out.println("listaSeguidos");
        String nick = "";
        ControladorUsuario instance = new ControladorUsuario();
        List expResult = null;
        List result = instance.listaSeguidos(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaSeguidores method, of class ControladorUsuario.
     */
    @Test
    public void testListaSeguidores() {
        System.out.println("listaSeguidores");
        String nick = "";
        ControladorUsuario instance = new ControladorUsuario();
        List expResult = null;
        List result = instance.listaSeguidores(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valorarVideo method, of class ControladorUsuario.
     */
    @Test
    public void testValorarVideo() throws Exception {
        System.out.println("valorarVideo");
        String u = "";
        String video = "";
        String user_val = "";
        String val = "";
        ControladorUsuario instance = new ControladorUsuario();
        instance.valorarVideo(u, video, user_val, val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarUsuarioCanal method, of class ControladorUsuario.
     */
    @Test
    public void testBuscarUsuarioCanal() {
        System.out.println("buscarUsuarioCanal");
        String c = "";
        ControladorUsuario instance = new ControladorUsuario();
        DtUsuario expResult = null;
        DtUsuario result = instance.buscarUsuarioCanal(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valorarVideoEliminar method, of class ControladorUsuario.
     */
    @Test
    public void testValorarVideoEliminar() {
        System.out.println("valorarVideoEliminar");
        String u = "";
        String video = "";
        String user_val = "";
        String val = "";
        ControladorUsuario instance = new ControladorUsuario();
        instance.valorarVideoEliminar(u, video, user_val, val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
