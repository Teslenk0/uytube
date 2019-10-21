package DataTypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DtListaParticularesTest {

    DtListaParticulares test = new DtListaParticulares(true,new DtCategoria("categoria"),"nombreLista");

    @Test
    void getPrivado() {
        assertEquals(true,test.getPrivado());
    }

    @Test
    void getCategoria() {
        assertNotEquals(new DtCategoria("categoria"),test.getCategoria());
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