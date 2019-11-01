package clases;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VideoTest {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
    Date date;

    Canal canal = new Canal("nombre_canal", "descripcion", true);
    {
        try{
            date = sdf.parse("1111/11/11");
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
    Video test = new Video("nombre", canal, date, "url", "descripcion", "categoria","duracion", true);


    @Test
    void getNombre() {
        assertEquals("nombre",test.getNombre());
    }

    @Test
    void setNombre() {
        Video aux = new Video (null, canal, date, "url", "descripcion", "categoria","duracion", true);
        aux.setNombre(test.getNombre());
        assertEquals(aux,test);
    }

    @Test
    void getCanal() {
        assertEquals(canal,test.getCanal());
    }

    @Test
    void setCanal() {
        Video aux = new Video ("nombre", null, date, "url", "descripcion", "categoria","duracion", true);
        aux.setCanal(test.getCanal());
        assertEquals(aux,test);
    }

    @Test
    void getFechaPublicacion() {
        assertEquals(date,test.getFechaPublicacion());
    }

    @Test
    void setFechaPublicacion() {
        Video aux = new Video ("nombre", canal, null, "url", "descripcion", "categoria","duracion", true);
        aux.setFechaPublicacion(test.getFechaPublicacion());
        assertEquals(aux,test);
    }

    @Test
    void getUrl() {
        assertEquals("url",test.getUrl());
    }

    @Test
    void setUrl() {
        Video aux = new Video ("nombre", canal, date, null, "descripcion", "categoria","duracion", true);
        aux.setUrl(test.getUrl());
        assertEquals(aux,test);
    }

    @Test
    void getDescripcion() {
        assertEquals("descripcion",test.getDescripcion());
    }

    @Test
    void setDescripcion() {
        Video aux = new Video ("nombre", canal, date, "url", null, "categoria","duracion", true);
        aux.setDescripcion(test.getDescripcion());
        assertEquals(aux,test);
    }

    @Test
    void getCategoria() {
        assertEquals("categoria",test.getCategoria());
    }

    @Test
    void setCategoria() {
        Video aux = new Video ("nombre", canal, date, "url", "descripcion", null,"duracion", true);
        aux.setCategoria(test.getCategoria());
        assertEquals(aux,test);
    }

    @Test
    void getDuracion() {
        assertEquals("duracion",test.getDuracion());
    }

    @Test
    void getPrivado() {
        assertEquals(true,test.getPrivado());
    }

    @Test
    void setDuracion() {
        Video aux = new Video ("nombre", canal, date, "url", "descripcion", "categoria",null, true);
        aux.setDuracion(test.getDuracion());
        assertEquals(aux,test);
    }

    @Test
    void setPrivado() {
        Video aux = new Video ("nombre", canal, date, "url", "descripcion", "categoria","duracion", null);
        aux.setPrivado(test.getPrivado());
        assertEquals(aux,test);
    }

    @Test
    void testHashCode() {
        assertNotNull(test.hashCode());
    }

    @Test
    void testEquals() {
        assertTrue(test.equals(test));
    }

    @Test
    void testToString() {
        assertNotNull(test.toString());
    }
}