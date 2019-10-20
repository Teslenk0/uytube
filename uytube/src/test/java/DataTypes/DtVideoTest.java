package DataTypes;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DtVideoTest {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
    Date date;

    DtCanal canal = new DtCanal("nombre_canal", "descripcion", true);
    {
        try{
            date = sdf.parse("1111/11/11");
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
    DtVideo test = new DtVideo("nombre", canal, date, "url", "descripcion", "categoria","duracion", true);


    @Test
    void getNombre() {
        assertEquals("nombre",test.getNombre());
    }

    @Test
    void getCanal() {
        assertEquals(canal,test.getCanal());
    }

    @Test
    void getFechaPublicacion() {
        assertEquals(date,test.getFechaPublicacion());
    }

    @Test
    void getUrl() {
        assertEquals("url",test.getUrl());
    }

    @Test
    void getDescripcion() {
        assertEquals("descripcion",test.getDescripcion());
    }

    @Test
    void getCategoria() {
        assertEquals("categoria",test.getCategoria());
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
    void aString(){
        assertNotNull(test.toString());
    }

    @Test
    void codeHash(){
        assertNotNull(test.hashCode());
    }

    @Test
    void equals(){
        assertTrue(test.equals(test));
    }

    @Test
    void compare(){
        assertNotNull(test.compareTo(test));
    }
}