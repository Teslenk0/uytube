package clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuxiliarValorarTest {

    AuxiliarValorar auxVal = new AuxiliarValorar("duenioVid", "vid", "userVal", "valoracion");

    @Test
    void getDuenio() {
        assertNotNull(auxVal.getDuenio());
    }

    @Test
    void setDuenio() {
        AuxiliarValorar aux = new AuxiliarValorar(null,"vid", "userVal", "valoracion");
        aux.setDuenio(auxVal.getDuenio());
        assertEquals(auxVal,aux);
    }

    @Test
    void getVid() {
        assertNotNull(auxVal.getVid());
    }

    @Test
    void setVid() {
        AuxiliarValorar aux = new AuxiliarValorar("duenioVid",null, "userVal", "valoracion");
        aux.setVid(auxVal.getVid());
        assertEquals(auxVal,aux);
    }

    @Test
    void getUser() {
        assertNotNull(auxVal.getUser());
    }

    @Test
    void setUser() {
        AuxiliarValorar aux = new AuxiliarValorar("duenioVid","vid", null, "valoracion");
        aux.setUser(auxVal.getUser());
        assertEquals(auxVal,aux);
    }

    @Test
    void getVal() {
        assertNotNull(auxVal.getVal());
    }

    @Test
    void setVal() {
        AuxiliarValorar aux = new AuxiliarValorar("duenioVid","vid", "userVal", null);
        aux.setVal(auxVal.getVal());
        assertEquals(auxVal,aux);
    }

    @Test
    void testHashCode() {
        assertNotNull(auxVal.hashCode());
    }

    @Test
    void testEquals() {
        assertTrue(auxVal.equals(auxVal));
    }
}