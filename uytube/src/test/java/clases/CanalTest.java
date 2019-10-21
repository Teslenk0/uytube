package clases;

import DataTypes.DtCanal;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CanalTest {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
    Date date;
    {
        try{
            date = sdf.parse("1111/11/11");
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    Canal aux = new Canal("nombre_canal", "descripcion", true);
    Usuario u = new Usuario("nickname", "contraseña", "nombre", "apellido","email", date,"imagen", aux);
    Canal test = new Canal("nombre_canal", "descripcion", true, u);


    @Test
    void getNombre_canal() {
        assertNotNull(test.getNombre_canal());
    }

    @Test
    void setNombre_canal() {
        Canal c = new Canal(null, "descripcion", true, u);
        c.setNombre_canal(test.getNombre_canal());
        assertEquals(c, test);
    }

    @Test
    void getDescripcion() {
        assertNotNull(test.getDescripcion());
    }

    @Test
    void setDescripcion() {
        Canal c = new Canal("nombre_canal", null, true, u);
        c.setDescripcion(test.getDescripcion());
        assertEquals(c, test);
    }

    @Test
    void getPrivado() {
        assertNotNull(test.getPrivado());
    }

    @Test
    void setPrivado() {
        Canal c = new Canal("nombre_canal", "descripcion", null, u);
        c.setPrivado(test.getPrivado());
        assertEquals(c, test);
    }

    @Test
    void getUsuario() {
        assertNotNull(test.getUsuario().getNickname());
    }

    @Test
    void setUsuario() {
        Canal c = new Canal("nombre_canal", "descripcion", true, null);
        c.setUsuario(test.getUsuario());
        assertEquals(c, test);
    }

    @Test
    void testToString() {
        assertNotNull(test.toString());
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
    void compareTo() {
        assertNotNull(test.compareTo(test));
    }
}