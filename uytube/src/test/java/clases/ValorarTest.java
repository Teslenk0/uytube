package clases;

import DataTypes.DtCanal;
import DataTypes.DtUsuario;
import DataTypes.DtValorar;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ValorarTest {

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
    Usuario user = new Usuario("nickname", "contraseña","nombre","apellido","email",date,"imagen",  canal);

    Valorar test = new Valorar(user,"vid", "user","val");

    @Test
    void constructorUser(){
        DtUsuario aux = new DtUsuario(user);
        Usuario u = new Usuario(aux);
        Valorar v = new Valorar(u,"vid", "user","val");
    }

    @Test
    void getDuenio() {
        assertEquals(user,test.getDuenio());
    }

    @Test
    void setDuenio() {
        Valorar aux = new Valorar(null,"vid", "user","val");
        aux.setDuenio(test.getDuenio());
        assertEquals(aux,test);
    }

    @Test
    void getVid() {
        assertEquals("vid",test.getVid());
    }

    @Test
    void setVid() {
        Valorar aux = new Valorar(user,null, "user","val");
        aux.setVid(test.getVid());
        assertEquals(aux,test);
    }

    @Test
    void getUser() {
        assertEquals("user",test.getUser());
    }

    @Test
    void setUser() {
        Valorar aux = new Valorar(user,"vid", null,"val");
        aux.setUser(test.getUser());
        assertEquals(aux,test);
    }

    @Test
    void getVal() {
        assertEquals("val",test.getVal());
    }

    @Test
    void setVal() {
        Valorar aux = new Valorar(user,"vid", "user",null);
        aux.setVal(test.getVal());
        assertEquals(aux,test);
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
}