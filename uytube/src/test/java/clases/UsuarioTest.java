package clases;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

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
    Usuario test = new Usuario("nickname","contraseña","nombre","apellido","email",date,"imagen", tCanal);

    @Test
    void getContrasenia() {
        assertNotNull(test.getContrasenia());
    }

    @Test
    void setContrasenia() {
        Usuario aux = new Usuario("nickname",null,"nombre","apellido","email",date,"imagen", tCanal);
        aux.setContrasenia(test.getContrasenia());
        assertEquals(aux,test);
    }

    @Test
    void getNickname() {
        assertNotNull(test.getNickname());
    }

    @Test
    void setNickname() {
        Usuario aux = new Usuario(null,"contraseña","nombre","apellido","email",date,"imagen", tCanal);
        aux.setNickname(test.getNickname());
        assertEquals(aux,test);
    }

    @Test
    void getNombre() {
        assertNotNull(test.getNombre());
    }

    @Test
    void setNombre() {
        Usuario aux = new Usuario("nickname","contraseña",null,"apellido","email",date,"imagen", tCanal);
        aux.setNombre(test.getNombre());
        assertEquals(aux,test);
    }

    @Test
    void getApellido() {
        assertNotNull(test.getApellido());
    }

    @Test
    void setApellido() {
        Usuario aux = new Usuario("nickname","contraseña","nombre",null,"email",date,"imagen", tCanal);
        aux.setApellido(test.getApellido());
        assertEquals(aux,test);
    }

    @Test
    void getEmail() {
        assertNotNull(test.getEmail());
    }

    @Test
    void setEmail() {
        Usuario aux = new Usuario("nickname","contraseña","nombre","apellido",null,date,"imagen", tCanal);
        aux.setEmail(test.getEmail());
        assertEquals(aux,test);
    }

    @Test
    void getFechaNac() {
        assertNotNull(test.getFechaNac());
    }

    @Test
    void setFechaNac() {
        Usuario aux = new Usuario("nickname","contraseña","nombre","apellido","email",null,"imagen", tCanal);
        aux.setFechaNac(test.getFechaNac());
        assertEquals(aux,test);
    }

    @Test
    void getImagen() {
        assertNotNull(test.getImagen());
    }

    @Test
    void setImagen() {
        Usuario aux = new Usuario("nickname","contraseña","nombre","apellido","email",date,null, tCanal);
        aux.setImagen(test.getImagen());
        assertEquals(aux,test);
    }

    @Test
    void getCanal() {
        assertNotNull(test.getCanal());
    }

    @Test
    void setCanal() {
        Usuario aux = new Usuario("nickname","contraseña","nombre","apellido","email",date,"imagen", null);
        aux.setCanal(test.getCanal());
        assertEquals(aux,test);
    }

    @Test
    void testHashCode() {
        assertNotNull(test.hashCode());
    }

    @Test
    void testEquals() {
        assertNotNull(test.equals(test));
    }

    @Test
    void testToString() {
        assertNotNull(test.toString());
    }
}