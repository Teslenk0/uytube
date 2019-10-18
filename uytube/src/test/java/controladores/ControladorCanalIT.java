/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DataTypes.DtAuxiliar;
import DataTypes.DtCanal;
import DataTypes.DtCategoria;
import DataTypes.DtComentario;
import DataTypes.DtListaParticulares;
import DataTypes.DtListaReproduccion;
import DataTypes.DtUsuario;
import DataTypes.DtVideo;
import excepciones.VideoRepetidoException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ControladorCanalIT {
    
    public ControladorCanalIT() {
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
     * Test of registrarVideo method, of class ControladorCanal.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistrarVideo() throws Exception {
        System.out.println("registrarVideo");
        DtCanal c = new DtCanal("El Cachila","Para juntar cosas",true);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-01");
        DtVideo v = new DtVideo("Celeste", c, d,"https://youtu.be/PAfbzKcePx0","Tema Oficial","Música","3:0444",true);
        ControladorCanal instance = new ControladorCanal();
        try{
            instance.registrarVideo(v);
            fail("Fallo de try-catch");
        }catch(VideoRepetidoException e){
            System.out.println("Video repetido en Registrar Video correcto");
        }
    }

    /**
     * Test of modificarVideo method, of class ControladorCanal.
     * @throws java.lang.Exception
     */
    @Test
    public void testModificarVideo() throws Exception {
        System.out.println("modificarVideo");
        DtVideo v = null;
        String oldV = "";
        ControladorCanal instance = new ControladorCanal();
        instance.modificarVideo(v, oldV);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCanal method, of class ControladorCanal.
     */
    @Test
    public void testBuscarCanal() {
        System.out.println("buscarCanal");
        String canal = "";
        ControladorCanal instance = new ControladorCanal();
        boolean expResult = false;
        boolean result = instance.buscarCanal(canal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listaVideos method, of class ControladorCanal.
     */
    @Test
    public void testListaVideos() {
        System.out.println("listaVideos");
        DtCanal c = null;
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.listaVideos(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerVideo method, of class ControladorCanal.
     */
    @Test
    public void testObtenerVideo() {
        System.out.println("obtenerVideo");
        String nomV = "";
        String c = "";
        ControladorCanal instance = new ControladorCanal();
        DtVideo expResult = null;
        DtVideo result = instance.obtenerVideo(nomV, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerComentario method, of class ControladorCanal.
     */
    @Test
    public void testObtenerComentario() {
        System.out.println("obtenerComentario");
        String comentario = "";
        ControladorCanal instance = new ControladorCanal();
        DtComentario expResult = null;
        DtComentario result = instance.obtenerComentario(comentario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerComentarioRef method, of class ControladorCanal.
     */
    @Test
    public void testObtenerComentarioRef() {
        System.out.println("obtenerComentarioRef");
        String padre = "";
        ControladorCanal instance = new ControladorCanal();
        DtAuxiliar expResult = null;
        DtAuxiliar result = instance.obtenerComentarioRef(padre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of comentarioEsp method, of class ControladorCanal.
     */
    @Test
    public void testComentarioEsp() {
        System.out.println("comentarioEsp");
        Integer num = null;
        ControladorCanal instance = new ControladorCanal();
        String expResult = "";
        String result = instance.comentarioEsp(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listaComentarios method, of class ControladorCanal.
     */
    @Test
    public void testListaComentarios() {
        System.out.println("listaComentarios");
        DtVideo video = null;
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.listaComentarios(video);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listaComentariosTodos method, of class ControladorCanal.
     */
    @Test
    public void testListaComentariosTodos() {
        System.out.println("listaComentariosTodos");
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.listaComentariosTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of agregarComentario method, of class ControladorCanal.
     */
    @Test
    public void testAgregarComentario() {
        System.out.println("agregarComentario");
        DtComentario c = null;
        ControladorCanal instance = new ControladorCanal();
        instance.agregarComentario(c);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCanales method, of class ControladorCanal.
     */
    @Test
    public void testGetCanales() {
        System.out.println("getCanales");
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.getCanales();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of crearListaDefecto method, of class ControladorCanal.
     * @throws java.lang.Exception
     */
    @Test
    public void testCrearListaDefecto() throws Exception {
        System.out.println("crearListaDefecto");
        DtListaReproduccion lista = null;
        ControladorCanal instance = new ControladorCanal();
        instance.crearListaDefecto(lista);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of crearListaParticular method, of class ControladorCanal.
     * @throws java.lang.Exception
     */
    @Test
    public void testCrearListaParticular() throws Exception {
        System.out.println("crearListaParticular");
        DtListaParticulares lista = null;
        DtUsuario user = null;
        ControladorCanal instance = new ControladorCanal();
        instance.crearListaParticular(lista, user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getListasReproduccion method, of class ControladorCanal.
     */
    @Test
    public void testGetListasReproduccion() {
        System.out.println("getListasReproduccion");
        String nick = "";
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.getListasReproduccion(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of registrarCategoria method, of class ControladorCanal.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistrarCategoria() throws Exception {
        System.out.println("registrarCategoria");
        DtCategoria c = null;
        ControladorCanal instance = new ControladorCanal();
        instance.registrarCategoria(c);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modificarListaParticular method, of class ControladorCanal.
     */
    @Test
    public void testModificarListaParticular() {
        System.out.println("modificarListaParticular");
        DtListaParticulares lista = null;
        DtUsuario user = null;
        ControladorCanal instance = new ControladorCanal();
        instance.modificarListaParticular(lista, user);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCategorias method, of class ControladorCanal.
     */
    @Test
    public void testGetCategorias() {
        System.out.println("getCategorias");
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.getCategorias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getListasDefecto method, of class ControladorCanal.
     */
    @Test
    public void testGetListasDefecto() {
        System.out.println("getListasDefecto");
        String nick = "";
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.getListasDefecto(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of agregarVideoLista method, of class ControladorCanal.
     * @throws java.lang.Exception
     */
    @Test
    public void testAgregarVideoLista() throws Exception {
        System.out.println("agregarVideoLista");
        String nombreVideo = "";
        String listaDestino = "";
        String usuarioDestino = "";
        String usuarioOrigen = "";
        Boolean isParticular = null;
        ControladorCanal instance = new ControladorCanal();
        instance.agregarVideoLista(nombreVideo, listaDestino, usuarioDestino, usuarioOrigen, isParticular);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getVideosListaDefecto method, of class ControladorCanal.
     */
    @Test
    public void testGetVideosListaDefecto() {
        System.out.println("getVideosListaDefecto");
        String nombre = "";
        String nombreLista = "";
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.getVideosListaDefecto(nombre, nombreLista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getVideosListaParticular method, of class ControladorCanal.
     */
    @Test
    public void testGetVideosListaParticular() {
        System.out.println("getVideosListaParticular");
        String nombre = "";
        String nombreLista = "";
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.getVideosListaParticular(nombre, nombreLista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sacarVideoLista method, of class ControladorCanal.
     */
    @Test
    public void testSacarVideoLista() {
        System.out.println("sacarVideoLista");
        String usuario = "";
        String nombreLista = "";
        String video = "";
        String canalOrigen = "";
        Boolean isParticular = null;
        ControladorCanal instance = new ControladorCanal();
        instance.sacarVideoLista(usuario, nombreLista, video, canalOrigen, isParticular);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listaMeGustas method, of class ControladorCanal.
     */
    @Test
    public void testListaMeGustas() {
        System.out.println("listaMeGustas");
        String usuario = "";
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.listaMeGustas(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listarVideosPorCategoria method, of class ControladorCanal.
     */
    @Test
    public void testListarVideosPorCategoria() {
        System.out.println("listarVideosPorCategoria");
        String categoria = "";
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.listarVideosPorCategoria(categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerListasParticularesPorCategoria method, of class ControladorCanal.
     */
    @Test
    public void testObtenerListasParticularesPorCategoria() {
        System.out.println("obtenerListasParticularesPorCategoria");
        String categoria = "";
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.obtenerListasParticularesPorCategoria(categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of busquedaArborescenteCanales method, of class ControladorCanal.
     */
    @Test
    public void testBusquedaArborescenteCanales() {
        System.out.println("busquedaArborescenteCanales");
        String text = "";
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.busquedaArborescenteCanales(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of busquedaArborescenteVideos method, of class ControladorCanal.
     */
    @Test
    public void testBusquedaArborescenteVideos() {
        System.out.println("busquedaArborescenteVideos");
        String text = "";
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.busquedaArborescenteVideos(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of busquedaArborescenteListasParticulares method, of class ControladorCanal.
     */
    @Test
    public void testBusquedaArborescenteListasParticulares() {
        System.out.println("busquedaArborescenteListasParticulares");
        String text = "";
        ControladorCanal instance = new ControladorCanal();
        List expResult = null;
        List result = instance.busquedaArborescenteListasParticulares(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarListaParticular method, of class ControladorCanal.
     */
    @Test
    public void testBuscarListaParticular() {
        System.out.println("buscarListaParticular");
        String nomLista = "";
        DtCanal canal = null;
        ControladorCanal instance = new ControladorCanal();
        DtListaParticulares expResult = null;
        DtListaParticulares result = instance.buscarListaParticular(nomLista, canal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscoVideoMasRecienteCanal method, of class ControladorCanal.
     */
    @Test
    public void testBuscoVideoMasRecienteCanal() {
        System.out.println("buscoVideoMasRecienteCanal");
        String canal = "";
        ControladorCanal instance = new ControladorCanal();
        DtVideo expResult = null;
        DtVideo result = instance.buscoVideoMasRecienteCanal(canal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscoVideoMasRecienteListaParticular method, of class ControladorCanal.
     */
    @Test
    public void testBuscoVideoMasRecienteListaParticular() {
        System.out.println("buscoVideoMasRecienteListaParticular");
        String lista = "";
        String canal = "";
        ControladorCanal instance = new ControladorCanal();
        DtVideo expResult = null;
        DtVideo result = instance.buscoVideoMasRecienteListaParticular(lista, canal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
