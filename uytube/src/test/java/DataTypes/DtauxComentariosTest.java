package DataTypes;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.*;

class DtauxComentariosTest {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
    Date date;

    {
        try {
            date = sdf.parse("1111/11/11");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    DtauxComentarios test = new DtauxComentarios("Nick","Comentario",date,"Video","Padre",1,"Canal");



    @Test
    void getNick() {
        assertEquals("Nick",test.getNick());
    }

    @Test
    void getComentario() {
        assertEquals("Comentario",test.getComentario());
    }

    @Test
    void getFecha() throws ParseException {
        Date dateR = sdf.parse("1111/11/11");
        assertEquals(dateR,test.getFecha());
    }

    @Test
    void getVideo() {
        assertEquals("Video",test.getVideo());
    }

    @Test
    void getPadre() {
        assertEquals("Padre",test.getPadre());
    }

    @Test
    void getRef() {
        assertEquals(1,test.getRef().intValue());
    }

    @Test
    void getCanal() {
        assertEquals("Canal",test.getCanal());
    }
}