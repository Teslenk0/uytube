package DataTypes;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DtComentarioTest {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
    Date date, date2;

    {
        try {
            date = sdf.parse("1111/11/11");
            date2 = sdf.parse("1111/11/11");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    DtCanal Ctest = new DtCanal("nombre_canal", "descripcion", true);
    DtVideo Vtest = new DtVideo("nombre", Ctest, date2, "url", "descripcion", "categoria", "duracion", true);
    DtComentario test = new DtComentario("nick", "comentario", date, Vtest, "padre", 1, "nombre_canal");

    @Test
    void getCanal() {
        assertEquals("nombre_canal",test.getCanal());
    }

    @Test
    void getPadre() {
        assertEquals("padre",test.getPadre());
    }

    @Test
    void getRef() {
        assertEquals(1,test.getRef());
    }

    @Test
    void getComentario() {
        assertEquals("comentario",test.getComentario());
    }

    @Test
    void getFecha() {
        assertEquals(date,test.getFecha());
    }

    @Test
    void getNick() {
        assertEquals("nick",test.getNick());
    }

    @Test
    void getVideo() {
        assertEquals(Vtest,test.getVideo());
    }
}