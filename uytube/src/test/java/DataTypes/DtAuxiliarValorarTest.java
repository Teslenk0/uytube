package DataTypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DtAuxiliarValorarTest {

    DtAuxiliarValorar test = new DtAuxiliarValorar("dueño", "vid", "user", "val");

    @Test
    void getDueño() {
        assertEquals("dueño",test.getDueño());
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