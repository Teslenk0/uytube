package clases;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ComentarioTest {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
    Date date;
    {
        try{
            date = sdf.parse("1111/11/11");
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    Canal canal = new Canal("nombre_canal", "descripcion", true);
    Video vid = new Video("nombre", canal, date, "url", "descripcion", "categoria","duracion", true);

    Comentario test = new Comentario("nickname", "comentario", date, vid, "padre", 1, "canal");

    @Test
    void getCanal() {
        assertNotNull(test.getCanal());
    }

    @Test
    void setCanal() {
        Comentario aux = new Comentario("nickname", "comentario", date, vid, "padre", 1,null);
        aux.setCanal(test.getCanal());
        assertEquals(test,aux);
    }

    @Test
    void getPadre() {
        assertNotNull(test.getPadre());
    }

    @Test
    void setPadre() {
        Comentario aux = new Comentario("nickname", "comentario", date, vid, null, 1,"canal");
        aux.setPadre(test.getPadre());
        assertEquals(test,aux);
    }

    @Test
    void getRef() {
        assertNotNull(test.getRef());
    }

    @Test
    void setRef() {
        Comentario aux = new Comentario("nickname", "comentario", date, vid, "padre", null,"canal");
        aux.setRef(test.getRef());
        assertEquals(test,aux);
    }

    @Test
    void getComentario() {
        assertNotNull(test.getComentario());
    }

    @Test
    void setComentario() {
        Comentario aux = new Comentario("nickname", null, date, vid, "padre", 1,"canal");
        aux.setComentario(test.getComentario());
        assertEquals(test,aux);
    }

    @Test
    void getFecha() {
        assertNotNull(test.getFecha());
    }

    @Test
    void setFecha() {
        Comentario aux = new Comentario("nickname", "comentario", null, vid, "padre", 1,"canal");
        aux.setFecha(test.getFecha());
        assertEquals(test,aux);
    }

    @Test
    void getNick() {
        assertNotNull(test.getNick());
    }

    @Test
    void setNick() {
        Comentario aux = new Comentario(null, "comentario", date, vid, "padre", 1,"canal");
        aux.setNick(test.getNick());
        assertEquals(test,aux);
    }

    @Test
    void getVideo() {
        assertNotNull(test.getVideo());
    }

    @Test
    void setVideo() {
        Comentario aux = new Comentario("nickname", "comentario", date, null, "padre", 1,"canal");
        aux.setVideo(test.getVideo());
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