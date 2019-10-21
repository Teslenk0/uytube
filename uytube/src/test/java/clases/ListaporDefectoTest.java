package clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaporDefectoTest {

    Canal Ctest = new Canal("nombre_canal", "descripcion", true);
    ListaporDefecto test = new ListaporDefecto("nombreLista", Ctest);

    @Test
    void getId() {
        assertNotNull(test.getId());
    }

    @Test
    void setId() {
        ListaporDefecto aux = new ListaporDefecto("nombre", Ctest);
        aux.setId(test.getId());
        assertEquals(test,aux);
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
    }
}