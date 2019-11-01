package DataTypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DtListaDefectoVideosTest {

    DtCanal Ctest = new DtCanal("nombre_canal", "descripcion", true);
    DtListaporDefecto Ltest = new DtListaporDefecto("nombreLista", Ctest);
    DtListaporDefecto Ltest2 = new DtListaporDefecto("nombreLista", Ctest);
    DtListaDefectoVideos test = new DtListaDefectoVideos(Ltest, "video", "canal");

    @Test
    void getId() {
        assertEquals("nombreLista",Ltest.getNombreLista());
    }

    @Test
    void setId() {
        test.setId(Ltest2);
        assertEquals(Ltest2,test.getId());
    }

    @Test
    void getVideo() {
        assertEquals("video",test.getVideo());
    }

    @Test
    void setVideo() {
        test.setVideo("video2");
        assertEquals("video2",test.getVideo());
    }

    @Test
    void getCanal() {
        assertEquals("canal",test.getCanal());
    }

    @Test
    void setCanal() {
        test.setCanal("canal2");
        assertEquals("canal2",test.getCanal());
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