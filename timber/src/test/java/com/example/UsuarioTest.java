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
    void testAnniadirLike() {
        usuario.anniadirLike(2);
        List<Integer> likes = usuario.getLikesRecibidos();
        assertTrue(likes.contains(2));
        assertEquals(1, likes.size());
    }
    
    @Test
    void testAnniadirLikeDuplicado() {
        usuario.anniadirLike(2);
        usuario.anniadirLike(2);
        List<Integer> likes = usuario.getLikesRecibidos();
        assertEquals(1, likes.size());
    }

    @Test
    void testAnniadirMatch() {
        usuario.anniadirMatch(3);
        List<Integer> matches = usuario.getMatchesRecibidos();
        assertTrue(matches.contains(3));
        assertEquals(1, matches.size());
    }

    @Test
    void testAnniadirMatch_MatchDuplicado() {
        usuario.anniadirMatch(3);
        usuario.anniadirMatch(3);
        List<Integer> matches = usuario.getMatchesRecibidos();
        assertEquals(1, matches.size());
    }

}