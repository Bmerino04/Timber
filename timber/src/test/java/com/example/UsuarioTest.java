package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    private Usuario usuario;
    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setEmail("test@example.com");
        usuario.setContrasennia("password123");
    }
    @Test
    void testValidarInformacion() {
        assertTrue(usuario.validarInformacion("test@example.com", "password123"));

        assertFalse(usuario.validarInformacion("wrong@example.com", "password123"));
        assertFalse(usuario.validarInformacion("test@example.com", "wrongpassword"));
    }
    @Test
    void testEsEmailValido() {
        assertTrue(usuario.esEmailValido("test@example.com"));

        assertFalse(usuario.esEmailValido("test@.com"));
        assertFalse(usuario.esEmailValido("test@com"));
        assertFalse(usuario.esEmailValido("testexample.com"));
    }
    @Test
    void testEsFechaValida() {
        assertTrue(usuario.esFechaValida("15/01/2020"));

        assertFalse(usuario.esFechaValida("05-02-2004"));
        assertFalse(usuario.esFechaValida("2022/12/03"));
        assertFalse(usuario.esFechaValida("50/02/2004"));
        assertFalse(usuario.esFechaValida("05/25/2000"));
        assertFalse(usuario.esFechaValida("01/02/2200"));
    }
    }

}