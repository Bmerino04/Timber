package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase Perfil representa la información personal
 * de un usuario en la aplicación. Incluye atributos como el nombre de usuario,
 * edad, género, ciudad de residencia, biografía y pronombres preferidos.
 * Proporciona métodos para mostrar el perfil público y privado del usuario.
 * @author Carlos Cienfuegos 
 */
public class Perfil {

    private String nombreUsuario;
    private int edad;
    private String genero;
    private String ciudadResidencia;
    private String biografia;
    private List<String> pronombres;

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
    public Perfil(String nombreUsuario, int edad, String genero, String ciudadResidencia, String biografia, List<String> pronombres) {
        this.nombreUsuario = nombreUsuario;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.biografia = biografia;
        this.pronombres = new ArrayList<>();
    }

    /**
     * Constructor por defecto que inicializa una nueva instancia de Perfil con
     * una lista vacía de pronombres. Este constructor es útil para crear un
     * perfil antes de registrar datos mediante el método
     * {@link #registrarPerfil()}.
     */
    public Perfil() {
        this.pronombres = new ArrayList<>();

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

    public List<String> getPronombres() {
        return pronombres;
    }

    /**
     * Permite registrar un perfil de usuario solicitando los datos mediante
     * consola. Utiliza un objeto Scanner para recibir los datos del perfil
     * (nombre de usuario, edad, género, ciudad de residencia, biografía y
     * pronombres).
     */
    public void registrarPerfil() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de usuario: ");
        this.nombreUsuario = scanner.nextLine();

        // Validar y registrar edad
        while (true) {
            System.out.print("Ingrese la edad: ");
            String input = scanner.nextLine();
            if (esEdadValida(input)) {
                this.edad = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Edad inválida. Por favor, ingrese un número entero positivo.");
            }
        }

        System.out.print("Ingrese el género: ");
        this.genero = scanner.nextLine();

        System.out.print("Ingrese la ciudad de residencia: ");
        this.ciudadResidencia = scanner.nextLine();

        System.out.print("Ingrese la biografía: ");
        this.biografia = scanner.nextLine();

        // Validar y registrar pronombres
        while (true) {
            System.out.print("Ingrese los pronombres (separados por comas): ");
            String input = scanner.nextLine();
            if (esPronombresValidos(input)) {
                this.pronombres = new ArrayList<>(List.of(input.split(",")));
                break;
            } else {
                System.out.println("Pronombres inválidos. Asegúrese de separarlos con comas.");
            }
        }

        System.out.println("Perfil registrado con éxito.");
    }

    /**
     * Valida si la entrada de edad es un número entero positivo y menor a 120.
     *
     * @param input La entrada del usuario.
     * @return true si la entrada es un número entero positivo menor a 120,
     * false en caso contrario.
     */
    private boolean esEdadValida(String input) {
        try {
            int edad = Integer.parseInt(input);
            return edad > 0 && edad < 120; // La edad debe ser positiva y menor a 120
        } catch (NumberFormatException e) {
            return false; // No es un número válido
        }
    }

    /**
     * Valida si los pronombres ingresados son válidos (no están vacíos).
     *
     * @param input La entrada del usuario.
     * @return true si los pronombres son válidos, false en caso contrario.
     */
    private boolean esPronombresValidos(String input) {
        // Comprobar que no esté vacío y que contenga al menos un pronombre
        return !input.trim().isEmpty() && input.contains(",");
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

        for (int i = 0; i < pronombres.size(); i++) {
            if (i == 0) {
                System.out.print(pronombres.getFirst());
            } else {
                System.out.print("/" + pronombres.get(i));
            }
        }
    }
}
