package com.example;

public class Perfil {

    private String nombreUsuario;
    private int edad;
    private String genero;
    private String ciudadResidencia;
    private String biografia;
    private String[] pronombres;

    public Perfil(String nombreUsuario, int edad, String genero, String ciudadResidencia, String biografia, String[] pronombres) {
        this.nombreUsuario = nombreUsuario;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.biografia = biografia;
        this.pronombres = pronombres;
    }

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

    public void mostrarPerfilPublico() {
        System.out.println("Nombre de usuario: " + nombreUsuario);
        System.out.println("Edad: " + edad);
        System.out.println("Género: " + genero);
        System.out.println("Ciudad de residencia: " + ciudadResidencia);
    }

    public void mostrarPerfilPrivado() {
        mostrarPerfilPublico();
        System.out.println("Biografía: " + biografia);
        System.out.println("Pronombres: ");
        for (int i = 0; i < pronombres.length; i++) {
            if (i == 0) {
                System.out.print(pronombres[i]);
            } else {
                System.out.print("/" + pronombres[i]);
            }
        }
    }
