package DataTypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DtAuxiliarValorarTest {

    DtAuxiliarValorar test = new DtAuxiliarValorar("duenio", "vid", "user", "val");

    @Test
    void getSerialVersionUID() {
        assertEquals(1L,test.getSerialVersionUID());
    }

    @Test
    void getDueño() {
        assertEquals("duenio",test.getDuenio());
    }

    @Test
    void getVid() {
        assertEquals("vid",test.getVid());
    }

    @Test
    void getUser() {
        assertEquals("user",test.getUser());
    }

    @Test
    void getVal() {
        assertEquals("val",test.getVal());
    }
}