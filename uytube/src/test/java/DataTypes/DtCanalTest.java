package DataTypes;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DtCanalTest {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
    Date date;
    {
        try{
            date = sdf.parse("1111/11/11");
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    DtCanal aux = new DtCanal("nombre_canal", "descripcion", true);
    DtUsuario u = new DtUsuario("nickname", "contraseña", "nombre", "apellido","email", date,"imagen", aux);
    DtCanal test = new DtCanal("nombre_canal", "descripcion", true, u);
    @Test
    void getNombre_canal() {
        assertEquals("nombre_canal",test.getNombre_canal());
    }

    @Test
    void getDescripcion() {
        assertEquals("descripcion",test.getDescripcion());
    }

    @Test
    void getPrivado() {
        assertEquals(true,test.getPrivado());
    }

    @Test
    void getUsuario() {
        assertEquals(u,test.getUsuario());
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