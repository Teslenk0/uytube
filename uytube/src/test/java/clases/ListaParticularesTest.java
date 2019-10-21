package clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaParticularesTest {

    ListaParticulares test = new ListaParticulares(true,new Categoria("categoria"),"nombreLista");

    @Test
    void getId() {
        assertEquals(true,test.getPrivado());
    }

    @Test
    void setId() {
        test.setId(8255);
        assertEquals(8255, test.getId());
    }

    @Test
    void getPrivado() {
        assertEquals(true,test.getPrivado());
    }

    @Test
    void setPrivado() {
        ListaParticulares l = new ListaParticulares(null,new Categoria("categoria"),"nombreLista");
        l.setPrivado(test.getPrivado());
        assertEquals(l, test);
    }

    @Test
    void getCategoria() {
        assertEquals(new Categoria("categoria"),test.getCategoria());
    }

    @Test
    void setCategoria() {
        ListaParticulares l = new ListaParticulares(true,null,"nombreLista");
        l.setCategoria(test.getCategoria());
        assertEquals(l, test);
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