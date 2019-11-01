package DataTypes;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DtUsuarioTest {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
    Date date;

    {
        try {
            date = sdf.parse("1111/11/11");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    DtCanal aux = new DtCanal("nombre_canal", "descripcion", true);
    DtUsuario test = new DtUsuario("nickname", "contraseña", "nombre", "apellido","email", date,"imagen", aux);

    @Test
    void getSerialVersionUID() {
        assertEquals(1L,test.getSerialVersionUID());
    }

    @Test
    void getNickname() {
        assertEquals("nickname",test.getNickname());
    }

    @Test
    void getContrasenia() {
        assertEquals("contraseña",test.getContrasenia());
    }

    @Test
    void getNombre() {
        assertEquals("nombre",test.getNombre());
    }

    @Test
    void getApellido() {
        assertEquals("apellido",test.getApellido());
    }

    @Test
    void getEmail() {
        assertEquals("email",test.getEmail());
    }

    @Test
    void getFechaNac() throws ParseException {
        Date date2 = sdf.parse("1111/11/11");
        assertEquals(date2,test.getFechaNac());
    }

    @Test
    void getImagen() {
        assertEquals("imagen",test.getImagen());
    }

    @Test
    void getCanal() {
        assertEquals("nombre_canal",aux.getNombre_canal());
    }
}