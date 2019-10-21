package clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaParticularVideosTest {

    ListaParticulares lista = new ListaParticulares(true,new Categoria("categoria"),"nombreLista");

    ListaParticularVideos test = new ListaParticularVideos(lista, "video", "canal");

    @Test
    void getId() {
        assertNotNull(test.getId());
    }

    @Test
    void setId() {
        ListaParticulares aux = new ListaParticulares(true,new Categoria("categoria"),"nombreLista");
        aux.setId(lista.getId());
        assertEquals(aux,lista);
    }

    @Test
    void getVideo() {
        assertNotNull(test.getVideo());
    }

    @Test
    void setVideo() {
        ListaParticularVideos aux = new ListaParticularVideos(lista, null, "canal");
        aux.setVideo(test.getVideo());
        assertEquals(aux,test);
    }

    @Test
    void getCanal() {
        assertNotNull(test.getCanal());
    }

    @Test
    void setCanal() {
        ListaParticularVideos aux = new ListaParticularVideos(lista, "video", null);
        aux.setCanal(test.getCanal());
        assertEquals(aux,test);
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