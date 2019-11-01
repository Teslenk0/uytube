package clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuxiliarValorarTest {

    AuxiliarValorar auxVal = new AuxiliarValorar("dueñoVid", "vid", "userVal", "valoracion");

    @Test
    void getDueño() {
        assertNotNull(auxVal.getDueño());
    }

    @Test
    void setDueño() {
        AuxiliarValorar aux = new AuxiliarValorar(null,"vid", "userVal", "valoracion");
        aux.setDueño(auxVal.getDueño());
        assertEquals(auxVal,aux);
    }

    @Test
    void getVid() {
        assertNotNull(auxVal.getVid());
    }

    @Test
    void setVid() {
        AuxiliarValorar aux = new AuxiliarValorar("dueñoVid",null, "userVal", "valoracion");
        aux.setVid(auxVal.getVid());
        assertEquals(auxVal,aux);
    }

    @Test
    void getUser() {
        assertNotNull(auxVal.getUser());
    }

    @Test
    void setUser() {
        AuxiliarValorar aux = new AuxiliarValorar("dueñoVid","vid", null, "valoracion");
        aux.setUser(auxVal.getUser());
        assertEquals(auxVal,aux);
    }

    @Test
    void getVal() {
        assertNotNull(auxVal.getVal());
    }

    @Test
    void setVal() {
        AuxiliarValorar aux = new AuxiliarValorar("dueñoVid","vid", "userVal", null);
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