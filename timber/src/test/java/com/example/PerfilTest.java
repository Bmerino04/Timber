package com.example;
import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PerfilTest {

    private Perfil perfil;

    @BeforeEach
    public void setUp() {
        perfil = new Perfil();
    }

    //PU de chatgpt
    @Test
    public void testRegistrarPerfil() {
        // Entrada simulada para cada valor que solicita el método
        String input = "Juan\n" +          // nombreUsuario
                       "25\n" +            // edad válida
                       "Masculino\n" +     // género
                       "Santiago\n" +      // ciudadResidencia
                       "Desarrollador.\n" +// biografía
                       "él,lo\n";          // pronombres válidos
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        // Verificamos cada atributo establecido en el perfil
        assertEquals("Juan", perfil.getNombreUsuario());
        assertEquals(25, perfil.getEdad());
        assertEquals("Masculino", perfil.getGenero());
        assertEquals("Santiago", perfil.getCiudadResidencia());
        assertEquals("Desarrollador.", perfil.getBiografia());
        assertEquals(List.of("él", "lo"), perfil.getPronombres());
    }
 
    @Test
    public void testEdadGPT() {
        // Simulamos entradas de edad inválida y luego una válida
        String input = "Juan\n" +
                       "-5\n" +       // edad inválida
                       "abc\n" +      // edad inválida
                       "10\n" +       // edad válida
                       "Masculino\n" +
                       "Santiago\n" +
                       "Desarrollador.\n" +
                       "él,lo\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals(10, perfil.getEdad());  // Edad se establece como 10 después de entradas inválidas
    }

    
    @Test
    public void testPronombresGPT() {
        // Simulamos entradas de pronombres inválidos y luego una válida
        String input = "Juan\n" +
                       "25\n" +
                       "Masculino\n" +
                       "Santiago\n" +
                       "Desarrollador.\n" +
                       "él-lo\n" +       // pronombres inválidos (falta coma)
                       "ella,lo\n";      // pronombres válidos
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals(List.of("ella", "lo"), perfil.getPronombres());  // Pronombres se establecen correctamente
    }

    //PU edad modificadas
    @Test
    public void testEdadValida() {
        String input = "Juan\n" +
                    "10\n" +  
                    "Masculino\n" +
                    "Santiago\n" +
                    "Desarrollador.\n" +
                    "él,lo\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals(10, perfil.getEdad()); 
    }
    @Test
    public void testEdadInvalidaMenor() {
        String input = "Juan\n" +
                       "0\n" +       // edad inválida
                       "Masculino\n" +
                       "Santiago\n" +
                       "Desarrollador.\n" +
                       "él,lo\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals(0, perfil.getEdad()); 
    }

    @Test
    public void testEdadInvalidaMayor() {
        String input = "Juan\n" +
                       "135\n" +       // edad inválida
                       "Masculino\n" +
                       "Santiago\n" +
                       "Desarrollador.\n" +
                       "él,lo\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals(135, perfil.getEdad());  
    }

    
    @Test
    public void testEdadInvalidaDecimal() {
        String input = "Juan\n" +
                       "13.5\n" +       // edad inválida
                       "Masculino\n" +
                       "Santiago\n" +
                       "Desarrollador.\n" +
                       "él,lo\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals(13.5, perfil.getEdad()); 
    }

    
    @Test
    public void testEdadInvalidaNegativa() { 
        String input = "Juan\n" +
                       "-13\n" +       // edad inválida
                       "Masculino\n" +
                       "Santiago\n" +
                       "Desarrollador.\n" +
                       "él,lo\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals(-13, perfil.getEdad()); 
    }

    @Test
    public void testEdadInvalidaLetras() { 
        String input = "Juan\n" +
                       "abc\n" +       // edad inválida
                       "Masculino\n" +
                       "Santiago\n" +
                       "Desarrollador.\n" +
                       "él,lo\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals("abc", perfil.getEdad());
    }

    //PU pronombres modificados
    @Test
    public void testPronombresValidos() {
        String input = "Juan\n" +
                       "25\n" +
                       "Masculino\n" +
                       "Santiago\n" +
                       "Desarrollador.\n" +
                       "ella,lo\n";      // pronombres válidos
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals(List.of("ella", "lo"), perfil.getPronombres());  // Pronombres se establecen correctamente
    }

    @Test
    public void testPronombresInvalidosGuion() {
        String input = "Juan\n" +
                       "25\n" +
                       "Masculino\n" +
                       "Santiago\n" +
                       "Desarrollador.\n" +
                       "ella-lo\n";    
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals(List.of("ella-lo"), perfil.getPronombres()); 
    }

    
    @Test
    public void testPronombresInvalidosVacio() {
        String input = "Juan\n" +
                       "25\n" +
                       "Masculino\n" +
                       "Santiago\n" +
                       "Desarrollador.\n" +
                       " ";      
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals(List.of(" "), perfil.getPronombres()); 
    }

    @Test
    public void testPronombresInvalidosNumeros() {
        String input = "Juan\n" +
                       "25\n" +
                       "Masculino\n" +
                       "Santiago\n" +
                       "Desarrollador.\n" +
                       "1,2";     
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals(List.of("1", "2"), perfil.getPronombres());
    }
    
    @Test
    public void testPronombresInvalidosEspacio() {
        String input = "Juan\n" +
                       "25\n" +
                       "Masculino\n" +
                       "Santiago\n" +
                       "Desarrollador.\n" +
                       "Ella la";     
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        perfil.registrarPerfil();

        assertEquals(List.of("Ella la"), perfil.getPronombres());
    }
}
