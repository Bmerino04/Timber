package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidadorTest {

    @Test
    void testEsEmailValido() {
        assertTrue(Validador.esEmailValido("test@example.com"));

        assertFalse(Validador.esEmailValido("test@.com"));
        assertFalse(Validador.esEmailValido("test@com"));
        assertFalse(Validador.esEmailValido("testexample.com"));
    }

    @Test
    void testEsFechaValida() {
        assertTrue(Validador.esFechaValida("15/01/2020"));

        assertFalse(Validador.esFechaValida("05-02-2004"));
        assertFalse(Validador.esFechaValida("2022/12/03"));
        assertFalse(Validador.esFechaValida("50/02/2004"));
        assertFalse(Validador.esFechaValida("05/25/2000"));
        assertFalse(Validador.esFechaValida("01/02/2200"));
    }
}
