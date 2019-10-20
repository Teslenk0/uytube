package DataTypes;

import clases.Usuario;
import clases.Valorar;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DtValorarTest {

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
    DtUsuario user = new DtUsuario("nickname", "contraseña","nombre","apellido","email",date,"imagen",  canal);

    DtValorar test = new DtValorar(user,"vid", "user","val");

    @Test
    void constructorUser(){
        Usuario u = new Usuario(user);
        Valorar v = new Valorar(u,"vid", "user","val");
        DtValorar testAux = new DtValorar(v);
    }

    @Test
    void getDuenio() {
        assertEquals(user,test.getDuenio());
    }

    @Test
    void getVid() {
        assertEquals("vid",test.getVid());
    }

    @Test
    void getUser() {
        assertEquals("user",test.getUser());
    }

    @Test
    void getVal() {
        assertEquals("val",test.getVal());
    }
}