package com.example;

/**
 * La clase Perfil representa la información personal de un usuario en la
 * aplicación. Incluye atributos como el nombre de usuario, edad, género, ciudad
 * de residencia, biografía y pronombres preferidos. Proporciona métodos para
 * mostrar el perfil público y privado del usuario.
 */
public class Perfil {

    private String nombreUsuario;
    private int edad;
    private String genero;
    private String ciudadResidencia;
    private String biografia;
    private String[] pronombres;

    /**
     * Constructor para crear un perfil de usuario con todos los detalles.
     *
     * @param nombreUsuario El nombre del usuario en la aplicación.
     * @param edad La edad del usuario.
     * @param genero El género del usuario.
     * @param ciudadResidencia La ciudad donde reside el usuario.
     * @param biografia Una breve biografía del usuario.
     * @param pronombres Los pronombres preferidos del usuario (ej. "él",
     * "ella", "elle").
     */
    public Perfil(String nombreUsuario, int edad, String genero, String ciudadResidencia, String biografia, String[] pronombres) {
        this.nombreUsuario = nombreUsuario;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.biografia = biografia;
        this.pronombres = pronombres;
    }

    // Getters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public String getBiografia() {
        return biografia;
    }

    public String[] getPronombres() {
        return pronombres;
    }

    /**
     * Muestra la información pública del perfil del usuario. Esto incluye el
     * nombre de usuario, edad, género y ciudad de residencia.
     */
    public void mostrarPerfilPublico() {
        System.out.println("Nombre de usuario: " + nombreUsuario);
        System.out.println("Edad: " + edad);
        System.out.println("Género: " + genero);
        System.out.println("Ciudad de residencia: " + ciudadResidencia);
    }

    /**
     * Muestra la información privada del perfil del usuario. Incluye toda la
     * información del perfil público, además de la biografía y los pronombres.
     */
    public void mostrarPerfilPrivado() {
        mostrarPerfilPublico();
        System.out.println("Biografía: " + biografia);
        System.out.print("Pronombres: ");
        for (int i = 0; i < pronombres.length; i++) {
            if (i == 0) {
                System.out.print(pronombres[i]);
            } else {
                System.out.print("/" + pronombres[i]);
            }
        }
    }
}
