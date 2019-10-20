package DataTypes;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DtAuxiliarTest {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
    Date date;

    {
        try {
            date = sdf.parse("1111/11/11");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    DtAuxiliar test = new DtAuxiliar("comentario",1,"padre", "nick", date);

    @Test
    void getFecha() throws ParseException {
        Date dateR = sdf.parse("1111/11/11");
        assertEquals(date,dateR);
    }

    @Test
    void getNick() {
        assertEquals("nick",test.getNick());
    }

    @Test
    void getPadre() {
        assertEquals("padre",test.getPadre());
    }

    @Test
    void getComentario() {
        assertEquals("comentario",test.getComentario());
    }

    @Test
    void getReferencia() {
        assertEquals(1,test.getReferencia());
    }
}