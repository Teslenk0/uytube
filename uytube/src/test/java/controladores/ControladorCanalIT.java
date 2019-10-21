
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DataTypes.*;
import clases.*;
import excepciones.CategoriaRepetidaException;
import fabrica.Fabrica;
import interfaces.IControladorCanal;
import interfaces.IControladorUsuario;
import org.junit.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author isaac
 */
public class ControladorCanalIT {
    private Fabrica fab = Fabrica.getInstance();
    private IControladorCanal c = fab.getControladorCanal();
    private IControladorUsuario controladorUsuario = fab.getControladorUsuario();

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
     */
    @Test
    public void testRegistrarVideo() throws Exception {
        System.out.println("registrarVideo");
        DtCanal ca = new DtCanal("El Cachila", "Para juntar cosas", true);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-01");
        DtVideo v = new DtVideo("Celeste", ca, d, "https://youtu.be/PAfbzKcePx0", "Tema Oficial", "Música", "3:04", true);
        try {
            c.registrarVideo(v);
        }catch (Exception e){

        }
        DtVideo vi = c.obtenerVideo(v.getNombre(), v.getCanal().getNombre_canal());
        assertNotNull(vi);
        //delete from videos_canal where nombre='Celeste' and nombre_canal='El Cachila';
    }

    /**
     * Test of modificarVideo method, of class ControladorCanal.
     */
    @Test
    public void testModificarVideo() throws Exception {
        System.out.println("modificarVideo");
        DtCanal ca = new DtCanal("El Cachila", "Para juntar cosas", true);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-01");
        DtVideo v = new DtVideo("Cambio", ca, d, "https://youtu.be/PAfbzKcePx0", "Prueba", "Música", "3:04", true);
        String oldV = "Celeste";
        try {
            c.modificarVideo(v, oldV);
        }catch (Exception e){

        }
        DtVideo vi = c.obtenerVideo(v.getNombre(), v.getCanal().getNombre_canal());
        assertEquals("Cambio", vi.getNombre());
        //delete from videos_canal where nombre='Cambio' and nombre_canal='El Cachila';
    }

    /**
     * Test of buscarCanal method, of class ControladorCanal.
     */
    @Test
    public void testBuscarCanal() {
        System.out.println("buscarCanal");
        String canal = "El Cachila";
        assertTrue(c.buscarCanal(canal));
        assertFalse(c.buscarCanal("No existe este canal"));
    }

    /**
     * Test of listaVideos method, of class ControladorCanal.
     */
    @Test
    public void testListaVideos() {
        System.out.println("listaVideos");
        DtCanal ca = new DtCanal("El Cachila", "Para juntar cosas", true);
        List listaB = c.listaVideos(ca);
        assertNotNull(listaB);
        ca = new DtCanal("robinh", "Henderson", false);
        List listaM = c.listaVideos(ca);
        assertNotNull(listaM);
    }

    /**
     * Test of obtenerVideo method, of class ControladorCanal.
     */
    @Test
    public void testObtenerVideo() {
        System.out.println("obtenerVideo");
        DtVideo vidB = c.obtenerVideo("100 años de FING", "hectorg");
        assertNotNull(vidB);
        DtVideo vidM = c.obtenerVideo("NoExiste", "hectorg");
        assertNull(vidM);
    }

    /**
     * Test of obtenerComentarioRef method, of class ControladorCanal.
     */
    @Test
    public void testObtenerComentarioRef() {
        System.out.println("obtenerComentarioRef");
        String padre = "2";
        DtAuxiliar a = c.obtenerComentarioRef(padre);
        assertNotNull(a);
    }

    /**
     * Test of comentarioEsp method, of class ControladorCanal.
     */
    @Test
    public void testComentarioEsp() {
        System.out.println("comentarioEsp");
        Integer num = 20;
        String com = c.comentarioEsp(num);
        //NO SUPE NULL POINTER MANEJADO
    }

    /**
     * Test of listaComentarios method, of class ControladorCanal.
     */
    @Test
    public void testListaComentarios() {
        System.out.println("listaComentarios");

        //PARAMETROS NULL
        DtVideo video = null;
        List result = c.listaComentarios(video);
        assertNull(result);


        //PARAMETROS NO EXISTENTE
        DtUsuario user = controladorUsuario.buscarUsuario("hectorg");
        result = c.listaComentarios(new DtVideo("nombre", user.getCanal(), new Date(10,12,15), "url","descripcion","categoria", "duracion", false));
        assertNotNull(result);

        //PARAMETROS EXISTENTES
        video = c.obtenerVideo("Locura Celeste","Tabaré");
        result = c.listaComentarios(video);
        assertNotNull(result);
    }

    /**
     * Test of listaComentariosTodos method, of class ControladorCanal.
     */
    @Test
    public void testListaComentariosTodos() {
        System.out.println("listaComentariosTodos");
        List result = c.listaComentariosTodos();
        assertNotNull(result);
    }

    /**
     * Test of agregarComentario method, of class ControladorCanal.
     */
    @Test
    public void testAgregarComentario() {
        System.out.println("agregarComentario");
        //PARAMETROS NULL
        DtComentario coment = null;
        try{
            c.agregarComentario(coment);
        }catch(Exception e){
            e.printStackTrace();
        }

        //PARAMETROS MAL
        DtVideo video = c.obtenerVideo("Show de goles","juliob");
        coment = new DtComentario("hectorg","comentario", new Date(10,12,12), video, "asd", 15, "canal");
        try{
            c.agregarComentario(coment);
        }catch(Exception e){
            e.printStackTrace();
        }

        //PARAMETROS BIEN
        video = c.obtenerVideo("Show de goles","juliob");
        coment = new DtComentario("hectorg","esto es un comentario", new Date(10,12,12), video, "12", 15, "juliob");
        try{
            c.agregarComentario(coment);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test of getCanales method, of class ControladorCanal.
     */
    @Test
    public void testGetCanales() {
        System.out.println("getCanales");
        List result = c.getCanales();
        assertNotNull(result);
    }

    /**
     * Test of crearListaDefecto method, of class ControladorCanal.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCrearListaDefecto() throws Exception {
        System.out.println("crearListaDefecto");

        //PARAMETROS VACIOS
        DtListaporDefecto lista = null;
        DtUsuario user = null;
        try {
            c.crearListaDefecto(lista);
        }catch (Exception e){
            e.printStackTrace();
        }


        //LISTA DUPLICADA
        lista = new DtListaporDefecto("Ver mas tarde");
        try {
            c.crearListaDefecto(lista);
        }catch (Exception e){
            e.printStackTrace();
        }

        //CASO OK
        lista = new DtListaporDefecto("Invierno del 91");
        try {
            c.crearListaDefecto(lista);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test of crearListaParticular method, of class ControladorCanal.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCrearListaParticular() throws Exception {
        System.out.println("crearListaParticular");

        //PARAMETROS VACIOS
        DtListaParticulares lista = null;
        DtUsuario user = null;
        try {
            c.crearListaParticular(lista, user);
        }catch (Exception e){
            e.printStackTrace();
        }

        //PARAMETROS MALOS
        lista = null;
        user = controladorUsuario.buscarUsuario("kairoh");
        try {
            c.crearListaParticular(lista, user);
        }catch (Exception e){
            e.printStackTrace();
        }

        //LISTA DUPLICADA
        lista = c.buscarListaParticular("Nostalgia",user.getCanal());
        try {
            c.crearListaParticular(lista, user);
        }catch (Exception e){
            e.printStackTrace();
        }

        //CASO OK
        lista = new DtListaParticulares(false,"Carnavalito", new DtCategoria("Carnaval"), new DtCanal(user.getCanal().getNombre_canal(),user.getCanal().getDescripcion(),user.getCanal().getPrivado(), user));
        try {
            c.crearListaParticular(lista, user);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Test of getListasReproduccion method, of class ControladorCanal.
     */
    @Test
    public void testGetListasReproduccion() {
        System.out.println("getListasReproduccion");

        //PARAMETROS VACIOS
        String nick = null;
        List result = c.getListasReproduccion(nick);
        assertEquals(null, result);

        //PARAMETROS NO EXISTENTES
        nick = "asdasd";
        result = c.getListasReproduccion(nick);
        assertEquals(null, result);

        //PARAMETROS EXISTENTES
        nick = "hectorg";
        result = c.getListasReproduccion(nick);
        assertNotNull(result);
    }

    /**
     * Test of registrarCategoria method, of class ControladorCanal.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistrarCategoria() throws Exception {
        System.out.println("registrarCategoria");

        //PARAMETROS VACIOS
        DtCategoria categoria = null;
        try {
            c.registrarCategoria(categoria);
        }catch (CategoriaRepetidaException e){
        }

        //PARAMETROS REPETIDOS
        categoria = new DtCategoria("Carnaval");
        try {
            c.registrarCategoria(categoria);
        }catch (CategoriaRepetidaException e){
        }

        //PARAMETROS NUEVOS
        categoria = new DtCategoria("asdasdasd");
        try {
            c.registrarCategoria(categoria);
        }catch (CategoriaRepetidaException e){
        }

    }

    /**
     * Test of modificarListaParticular method, of class ControladorCanal.
     */
    @Test
    public void testModificarListaParticular() {
        System.out.println("modificarListaParticular");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
        Date date;
        {
            try{
                date = sdf.parse("1111/11/11");
            }catch (ParseException e){
                e.printStackTrace();
            }
        }

        //PARAMETROS EN NULL
        DtListaParticulares lista = null;
        DtUsuario user = null;
        c.modificarListaParticular(lista, user);

        try {
            c.modificarListaParticular(lista, user);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        //PARAMETROS MALOS
        lista = new DtListaParticulares( false, new DtCategoria("categoria"),"nombreLista");
        DtCanal canal = new DtCanal("nombre_canal", "descripcion", false);
        user = new DtUsuario("nickname", "contraseña", "nombre", "apellido", "email", new Date(2312,10,25), "imagen",canal);
        c.modificarListaParticular(lista, user);
        try {
            c.modificarListaParticular(lista, user);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        //PARAMETROS BUENOS - LISTA NO EXISTENTE
        lista = new DtListaParticulares( false, new DtCategoria("Carnaval"),"Carnavalitos del amor");
        user = controladorUsuario.buscarUsuario("hectorg");
        c.modificarListaParticular(lista, user);
        try {
            c.modificarListaParticular(lista, user);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        //PARAMETROS BUENOS - LISTA EXISTENTE
        user = controladorUsuario.buscarUsuario("kairoh");
        lista = c.buscarListaParticular("Nostalgia",user.getCanal());
        c.modificarListaParticular(lista, user);
        try {
            c.modificarListaParticular(lista, user);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }

    /**
     * Test of getCategorias method, of class ControladorCanal.
     */
    @Test
    public void testGetCategorias() {
        System.out.println("getCategorias");

        List result = c.getCategorias();
        assertNotNull(result);

    }

    /**
     * Test of getListasDefecto method, of class ControladorCanal.
     */
    @Test
    public void testGetListasDefecto() {
        System.out.println("getListasDefecto");

        //PARAMETROS VACIOS
        String nick = null;
        List result = c.getListasDefecto(nick);
        assertNull(result);

        //PARAMETROS NO EXISTENTES
        nick = "asdasd";
        result = c.getListasDefecto(nick);
        assertNull(result);

        //PARAMETROS EXISTENTES
        nick = "hectorg";
        result = c.getListasDefecto(nick);
        assertNotNull(result);

    }

    /**
     * Test of agregarVideoLista method, of class ControladorCanal.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAgregarVideoLista() throws Exception {
        System.out.println("agregarVideoLista");

        String nombreVideo = "";
        String listaDestino = "";
        String usuarioDestino = "";
        String usuarioOrigen = "";
        Boolean isParticular = true;
        try {
            c.agregarVideoLista(nombreVideo, listaDestino, usuarioDestino, usuarioOrigen, isParticular);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        nombreVideo = "asdasd";
        listaDestino = "asdsd";
        usuarioDestino = "hectorg";
        usuarioOrigen = "kairoh";
        isParticular = false;
        try {
            c.agregarVideoLista(nombreVideo, listaDestino, usuarioDestino, usuarioOrigen, isParticular);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        nombreVideo = "Dancing in the Dark";
        listaDestino = "Nostalgia";
        usuarioDestino = "kairoh";
        usuarioOrigen = "hectorg";
        isParticular = true;
        try {
            c.agregarVideoLista(nombreVideo, listaDestino, usuarioDestino, usuarioOrigen, isParticular);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Test of getVideosListaDefecto method, of class ControladorCanal.
     */
    @Test
    public void testGetVideosListaDefecto() {
        System.out.println("getVideosListaDefecto");

        //PARAMETROS VACIOS
        String nombre = null;
        String nombreLista = null;
        List result = c.getVideosListaDefecto(nombre, nombreLista);
        assertNull(result);

        //PARAMETROS NO EXISTENTES
        nombre = "asdasdc";
        nombreLista = "f54552";
        result = c.getVideosListaDefecto(nombre, nombreLista);
        assertNull(result);

        //USUARIO EXISTENTE PERO NO LISTA
        nombre = "hectorg";
        nombreLista = "f54552";
        result = c.getVideosListaDefecto(nombre, nombreLista);
        assertNull(result);

        //USUARIO NO EXISTENTE PERO SI LISTA
        nombre = "asdasd";
        nombreLista = "Escuchar más tarde";
        result = c.getVideosListaDefecto(nombre, nombreLista);
        assertNull(result);

        //DATOS POSTA
        nombre = "kairoh";
        nombreLista = "Escuchar más tarde";
        result = c.getVideosListaDefecto(nombre, nombreLista);
        assertNotNull(result);
    }

    /**
     * Test of getVideosListaParticular method, of class ControladorCanal.
     */
    @Test
    public void testGetVideosListaParticular() {
        System.out.println("getVideosListaParticular");

        //PARAMETROS VACIOS
        String nombre = "";
        String nombreLista = "";
        List result = c.getVideosListaParticular(nombre, nombreLista);
        assertNull(result);


        //PARAMETROS NO EXISTENTES
        nombre = "asdasdc";
        nombreLista = "f54552";
        result = c.getVideosListaParticular(nombre, nombreLista);
        assertNull(result);

        //USUARIO EXISTENTE PERO NO LISTA
        nombre = "hectorg";
        nombreLista = "f54552";
        result = c.getVideosListaParticular(nombre, nombreLista);
        assertNull(result);

        //USUARIO NO EXISTENTE PERO SI LISTA
        nombre = "asdasd";
        nombreLista = "Nostalgia";
        result = c.getVideosListaParticular(nombre, nombreLista);
        assertNull(result);

        //USUARIO NO EXISTENTE PERO SI LISTA
        nombre = "kairoh";
        nombreLista = "Nostalgia";
        result = c.getVideosListaParticular(nombre, nombreLista);
        assertNotNull(result);
    }

    /**
     * Test of sacarVideoLista method, of class ControladorCanal.
     */
    @Test
    public void testSacarVideoLista() {
        System.out.println("sacarVideoLista");

        //PARAMETROS EN NULL
        String usuario = "";
        String nombreLista = "";
        String video = "";
        String canalOrigen = "";
        Boolean isParticular = null;
        try {
            c.sacarVideoLista(usuario, nombreLista, video, canalOrigen, isParticular);
        } catch (Exception e) {
            fail("TIRA NULL POINTER");
        }


        //PARAMETROS INCORRECTOS
        usuario = "hectorg";
        nombreLista = "a";
        video = "ds";
        canalOrigen = "sdsd";
        isParticular = false;
        try {
            c.sacarVideoLista(usuario, nombreLista, video, canalOrigen, isParticular);
        } catch (Exception e) {
            fail(e.getStackTrace().toString());
        }

        //PARAMETROS CORRECTOS
        usuario = "hectorg";
        nombreLista = "Nostalgia";
        video = "ds";
        canalOrigen = "sdsd";
        isParticular = false;
        try {
            c.sacarVideoLista(usuario, nombreLista, video, canalOrigen, isParticular);
        } catch (Exception e) {
            fail(e.getStackTrace().toString());
        }

        //PARAMETROS CORRECTOS
        usuario = "kairoh";
        nombreLista = "Nostalgia";
        video = "Sweet Child o Mine";
        canalOrigen = "kairoh";
        isParticular = true;
        try {
            c.sacarVideoLista(usuario, nombreLista, video, canalOrigen, isParticular);
        } catch (Exception e) {
            fail(e.getStackTrace().toString());
        }
    }

    /**
     * Test of listaMeGustas method, of class ControladorCanal.
     */
    @Test
    public void testListaMeGustas() {
        System.out.println("listaMeGustas");

        //PARAMETROS VACIOS
        String usuario = null;
        List result = c.listaMeGustas(usuario);
        assertNull(result);

        //PARAMETROS NO EXISTENTES
        usuario = "njkfvhbudhuir5";
        result = c.listaMeGustas(usuario);
        assertNull(result);

        //PARAMETROS EXISTENTES
        usuario = "hectorg";
        result = c.listaMeGustas(usuario);
        assertNotNull(result);

    }

    /**
     * Test of listarVideosPorCategoria method, of class ControladorCanal.
     */
    @Test
    public void testListarVideosPorCategoria() {
        System.out.println("listarVideosPorCategoria");

        //PARAMETROS VACIOS
        String categoria = "";
        List expResult = null;
        List result = c.listarVideosPorCategoria(categoria);
        assertNull(result);

        //CATEGORIA NO EXISTENTE
        categoria = "llll";
        result = c.listarVideosPorCategoria(categoria);
        assertNull(result);

        //CATEGORIA EXISTENTE
        categoria = "Carnaval";
        result = c.listarVideosPorCategoria(categoria);
        assertNotNull(result);

    }

    /**
     * Test of obtenerListasParticularesPorCategoria method, of class ControladorCanal.
     */
    @Test
    public void testObtenerListasParticularesPorCategoria() {
        System.out.println("obtenerListasParticularesPorCategoria");


        //PARAMETROS VACIOS
        String categoria = "";
        List expResult = null;
        List result = c.obtenerListasParticularesPorCategoria(categoria);
        assertNull(result);

        //CATEGORIA NO EXISTENTE
        categoria = "llll";
        result = c.obtenerListasParticularesPorCategoria(categoria);
        assertNull(result);

        //CATEGORIA EXISTENTE
        categoria = "Carnaval";
        result = c.obtenerListasParticularesPorCategoria(categoria);
        assertNotNull(result);

    }

    /**
     * Test of busquedaArborescenteCanales method, of class ControladorCanal.
     */
    @Test
    public void testBusquedaArborescenteCanales() {
        System.out.println("busquedaArborescenteCanales");

        //PARAMETROS VACIOS
        String text = "";
        List result = c.busquedaArborescenteCanales(text);
        assertNotNull(result);

        //PARAMETROS NO EXISTENTES
        text = "asdsd1548d";
        result = c.busquedaArborescenteCanales(text);
        assertNull(result);

        //PARAMETROS BIEN
        text = "a";
        result = c.busquedaArborescenteCanales(text);
        assertNotNull(result);
    }

    /**
     * Test of busquedaArborescenteVideos method, of class ControladorCanal.
     */
    @Test
    public void testBusquedaArborescenteVideos() {
        System.out.println("busquedaArborescenteVideos");


        //PARAMETROS VACIOS
        String text = "";
        List result = c.busquedaArborescenteVideos(text);
        assertNotNull(result);

        //BUSQUEDA POSTA
        text = "a";
        result = c.busquedaArborescenteVideos(text);
        assertNotNull(result);

        //PARAMETROS NO EXISTENTES
        text = "dsfsdfsw9";
        result = c.busquedaArborescenteVideos(text);
        assertNull(result);

    }

    /**
     * Test of busquedaArborescenteListasParticulares method, of class ControladorCanal.
     */
    @Test
    public void testBusquedaArborescenteListasParticulares() {
        System.out.println("busquedaArborescenteListasParticulares");

        //PARAMETOS VACIOS
        String text = "";
        List result = c.busquedaArborescenteListasParticulares(text);
        assertNotNull(result);

        //PARAMETOS
        text = "a";
        result = c.busquedaArborescenteListasParticulares(text);
        assertNotNull(result);
    }

    /**
     * Test of buscarListaParticular method, of class ControladorCanal.
     */
    @Test
    public void testBuscarListaParticular() {
        System.out.println("buscarListaParticular");

        //PARAMETROS VACIOS
        DtListaParticulares expResult = null;
        DtListaParticulares result = c.buscarListaParticular(null, null);
        assertEquals(expResult, result);

        //CANAL SIN LISTA PARTICULAR
        DtUsuario user = controladorUsuario.buscarUsuario("hrubino");
        result = c.buscarListaParticular("asdasd", user.getCanal());
        assertEquals(null, result);

        //LISTA PARTICULAR EN OTRO CANAL
        user = controladorUsuario.buscarUsuario("hectorg");
        result = c.buscarListaParticular("Nostalgia", user.getCanal());
        assertEquals(null, result);

        //CASO OK
        user = controladorUsuario.buscarUsuario("kairoh");
        result = c.buscarListaParticular("Nostalgia", user.getCanal());
        assertEquals("Nostalgia", result.getNombreLista());
    }


    /**
     * Test of buscoVideoMasRecienteCanal method, of class ControladorCanal.
     */
    @Test
    public void testBuscoVideoMasRecienteCanal() {
        System.out.println("buscoVideoMasRecienteCanal");


        //CANAL VACIO
        String canal = "";
        DtVideo result = c.buscoVideoMasRecienteCanal(canal);
        assertEquals(null, result);


        //CANAL SIN VIDEOS
        canal = "Canal Horacio";
        result = c.buscoVideoMasRecienteCanal(canal);
        assertEquals(null, result);


        //CANAL NO EXISTENTE
        canal = "holabb";
        result = c.buscoVideoMasRecienteCanal(canal);
        assertEquals(null, result);


        //CANAL CON VIDEOS
        canal = "Kairo música";
        result = c.buscoVideoMasRecienteCanal(canal);
        DtVideo resultado = c.obtenerVideo("Sweet child o mine", canal);
        assertEquals(resultado.getNombre(), result.getNombre());

    }

    /**
     * Test of buscoVideoMasRecienteListaParticular method, of class ControladorCanal.
     */
    @Test
    public void testBuscoVideoMasRecienteListaParticular() {
        System.out.println("buscoVideoMasRecienteListaParticular");

        //PARAMETOS VACIOS
        String lista = "";
        String canal = "";
        DtVideo result = c.buscoVideoMasRecienteListaParticular(lista, canal);
        assertEquals(null, result);


        //NO EXISTENTES
        lista = "s";
        canal = "  asdasd.";
        result = c.buscoVideoMasRecienteListaParticular(lista, canal);
        assertEquals(null, result);

        //CANAL EXISTE PERO LISTA NO
        lista = "a";
        canal = "Kairo música";
        result = c.buscoVideoMasRecienteListaParticular(lista, canal);
        assertEquals(null, result);

        //LISTA EXISTE PERO CANAL NO
        lista = "Nostalgia";
        canal = "a";
        result = c.buscoVideoMasRecienteListaParticular(lista, canal);
        assertEquals(null, result);


        //CASO BUENO
        result = c.buscoVideoMasRecienteListaParticular("Nostalgia", "Kairo música");
        DtVideo resultado = c.obtenerVideo("Sweet child o mine", "Kairo música");
        assertEquals(resultado, result);

    }

}
