package clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaDefectoVideosTest {

    Canal Ctest = new Canal("nombre_canal", "descripcion", true);
    ListaporDefecto Ltest = new ListaporDefecto("nombreLista", Ctest);
    ListaDefectoVideos test = new ListaDefectoVideos(Ltest, "video", "canal");

    @Test
    void getId() {
        assertNotNull(test.getId());
    }

    @Test
    void setId() {
            ListaDefectoVideos aux = new ListaDefectoVideos(Ltest, "video", "canal");
            aux.setId(test.getId());
            assertEquals(test,aux);
    }

    @Test
    void getVideo() {
        assertNotNull(test.getVideo());
    }

    @Test
    void setVideo() {
        ListaDefectoVideos aux = new ListaDefectoVideos(Ltest, null, "canal");
        aux.setVideo(test.getVideo());
        assertEquals(test,aux);
    }

    @Test
    void getCanal() {
        assertNotNull(test.getCanal());
    }

    @Test
    void setCanal() {
        ListaDefectoVideos aux = new ListaDefectoVideos(Ltest, "video", null);
        aux.setCanal(test.getCanal());
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
}