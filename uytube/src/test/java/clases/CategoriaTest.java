package clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {

    Categoria test = new Categoria("cat");

    @Test
    void getNombreCategoria() {
        assertNotNull(test.getNombreCategoria());
    }

    @Test
    void setNombreCategoria() {
        Categoria aux = new Categoria(null);
        aux.setNombreCategoria(test.getNombreCategoria());
        assertEquals(test,aux);
    }

    @Test
    void testToString() {
        assertNotNull(test.hashCode());
    }

    @Test
    void testHashCode() {
        assertTrue(test.equals(test));
    }

    @Test
    void testEquals() {
    }
}