package clases;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SeguirTest {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
    Date date;

    {
        try {
            date = sdf.parse("1111/11/11");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    Canal tCanal = new Canal("nombre_canal", "descripcion", true);
    Usuario tUser = new Usuario("nickname","contraseña","nombre","apellido","email",date,"imagen", tCanal);
    Seguir test = new Seguir(tUser,"seguidos");

    @Test
    void getUsuario() {
        assertNotNull(test.getUsuario());
    }

    @Test
    void setUsuario() {
        Seguir aux = new Seguir(tUser,"seguidos");
        aux.setUsuario(test.getUsuario());
        assertEquals(test,aux);
    }

    @Test
    void getSeguidos() {
        assertNotNull(test.getSeguidos());
    }

    @Test
    void setSeguidos() {
        Seguir aux = new Seguir(tUser,null);
        aux.setSeguidos(test.getSeguidos());
        assertEquals(test,aux);
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
        assertNotNull(test.equals(test));
    }
}