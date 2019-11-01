package DataTypes;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DtListaReproduccionTest {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
    Date date;
    {
        try{
            date = sdf.parse("1111/11/11");
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
    DtCanal canal = new DtCanal("nombre_canal", "descripcion", true);

    DtListaReproduccion test = new DtListaReproduccion("nombreLista", canal) {
        @Override
        public String getNombreLista() {
            return super.getNombreLista();
        }

        @Override
        public void setNombreLista(String nombreLista) {
            super.setNombreLista(nombreLista);
        }

        @Override
        public DtCanal getCanal() {
            return super.getCanal();
        }

        @Override
        public void setCanal(DtCanal canal) {
            super.setCanal(canal);
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int compareTo(DtListaReproduccion other) {
            return super.compareTo(other);
        }
    };

    @Test
    void getNombreLista() {
        assertEquals("nombreLista",test.getNombreLista());
    }

    @Test
    void setNombreLista() {
        test.setNombreLista("pepito");
        assertEquals("pepito",test.getNombreLista());
    }

    @Test
    void getCanal() {
        assertEquals(canal,test.getCanal());
    }

    @Test
    void setCanal() {
        DtCanal futuro = new DtCanal("nombre_canal", "description", false);
        test.setCanal(futuro);
        assertEquals(futuro,test.getCanal());
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