package DataTypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DtListaParticularVideosTest {


    DtListaParticulares lista = new DtListaParticulares(true,new DtCategoria("categoria"),"nombreLista");

    DtListaParticularVideos test = new DtListaParticularVideos(lista, "video", "canal");

    @Test
    void getId() {
        assertNotNull(test.getId());
    }

    @Test
    void setId() {
        DtListaParticulares t = new DtListaParticulares(false,new DtCategoria("cat"),"nombreLista");
        test.setId(t);
        assertEquals(t,test.getId());
    }

    @Test
    void getVideo() {
        assertEquals("video",test.getVideo());
    }

    @Test
    void setVideo() {
        test.setVideo("vid");
        assertEquals("vid",test.getVideo());
    }

    @Test
    void getCanal() {
        assertEquals("canal",test.getCanal());
    }

    @Test
    void setCanal() {
        test.setCanal("channel");
        assertEquals("channel",test.getCanal());
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