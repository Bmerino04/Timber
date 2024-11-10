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
        
        this.nombreUsuario = solicitarEntrada("Ingrese el nombre de usuario: ", scanner);
        this.edad = solicitarEdad(scanner);
        this.genero = solicitarEntrada("Ingrese el género: ", scanner);
        this.ciudadResidencia = solicitarEntrada("Ingrese la ciudad de residencia: ", scanner);
        this.biografia = solicitarEntrada("Ingrese la biografía: ", scanner);
        this.pronombres = solicitarPronombres(scanner);
        System.out.println("Perfil registrado con éxito.");

    }

   /**
     * Solicita una entrada de texto desde la consola.
     *
     * @param mensaje El mensaje que se muestra al usuario para solicitar la entrada.
     * @param scanner El objeto Scanner que se utiliza para capturar la entrada.
     * @return La entrada de texto proporcionada por el usuario.
     */
    private String solicitarEntrada(String mensaje, Scanner scanner) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    /**
     * Solicita la edad del usuario y valida que sea un número entero positivo menor a 120.
     *
     * @param scanner El objeto Scanner que se utiliza para capturar la entrada.
     * @return La edad válida ingresada por el usuario.
     */
    private int solicitarEdad(Scanner scanner) {
        while (true) {
            String input = solicitarEntrada("Ingrese la edad: ", scanner);
            if (esEdadValida(input)) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Edad inválida. Por favor, ingrese un número entero positivo.");
            }
        }
    }

     /**
     * Solicita los pronombres del usuario como una lista de cadenas separadas por comas.
     * Valida que los pronombres no estén vacíos y contengan al menos un pronombre.
     *
     * @param scanner El objeto Scanner que se utiliza para capturar la entrada.
     * @return Una lista de pronombres válidos ingresados por el usuario.
     */
    private List<String> solicitarPronombres(Scanner scanner) {
        while (true) {
            String input = solicitarEntrada("Ingrese los pronombres (separados por comas): ", scanner);
            if (esPronombresValidos(input)) {
                return new ArrayList<>(List.of(input.split(",")));
            } else {
                System.out.println("Pronombres inválidos. Asegúrese de separarlos con comas.");
            }
        }
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
            int edadVariable = Integer.parseInt(input);
            return edadVariable > 0 && edadVariable < 120; // La edad debe ser positiva y menor a 120
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
