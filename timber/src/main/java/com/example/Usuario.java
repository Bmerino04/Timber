package com.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase Usuario representa a un usuario en el sistema, 
 * gestionando su información personal, registro, inicio de sesión,
 * likes recibidos y matches.
 * 
 * @author Benjamin Merino
 */
public class Usuario {

    private Perfil perfil;
    private PreferenciasEmparejamiento preferencias;
    private Emparejamiento emparejamiento;
    private static int contadorUsuarios = 1;
    private int idUsuario;
    private String fechaNacimiento;
    private String email;
    private String contrasennia;
    private List<Integer> likesRecibidos;
    private List<Integer> matchesRecibidos;

    /**
     * Constructor de la clase Usuario.
     * Inicializa un nuevo usuario con un ID único y una lista vacía de likes recibidos.
     */
    public Usuario() {
        this.idUsuario = contadorUsuarios++;
        this.preferencias = new PreferenciasEmparejamiento(); 
        this.emparejamiento = new Emparejamiento();
        this.likesRecibidos = new ArrayList<>();
        this.matchesRecibidos = new ArrayList<>();
    }

    /**
     * Valida las credenciales de inicio de sesión del usuario.
     *
     * @param email el correo electrónico ingresado por el usuario
     * @param contrasennia la contraseña ingresada por el usuario
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public boolean validarInformacion(String email, String contrasennia) {
        return this.email.equals(email) && this.contrasennia.equals(contrasennia);
    }

    /**
     * Inicia sesión solicitando el correo y la contraseña del usuario.
     * Si las credenciales son válidas, llama al método mostrarCandidatos().
     */
    public void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el correo electrónico
        System.out.print("Ingrese su correo electrónico: ");
        String inputEmail = scanner.nextLine();

        // Solicitar la contraseña
        System.out.print("Ingrese su contraseña: ");
        String inputContrasennia = scanner.nextLine();

        // Validar la información
        if (validarInformacion(inputEmail, inputContrasennia)) {
            System.out.println("Inicio de sesión exitoso.");
            emparejamiento.mostrarCandidatos();
        } else {
            System.out.println("Correo electrónico o contraseña incorrectos.");
        }
    }

    /**
     * Registra un nuevo usuario solicitando sus datos personales.
     * Valida la fecha de nacimiento y el correo electrónico antes de almacenar la información.
     */
    public void registrarUsuario() {
        this.fechaNacimiento = FormularioUsuario.solicitarFechaNacimiento();
        this.email = FormularioUsuario.solicitarEmail();
        this.contrasennia = FormularioUsuario.solicitarContrasennia();

        System.out.println("Registro exitoso.");
        System.out.println("ID de usuario: " + this.idUsuario);
        System.out.println("Fecha de nacimiento: " + this.fechaNacimiento);
        System.out.println("Email: " + this.email);
        this.perfil = new Perfil();
        perfil.registrarPerfil();
        perfil.mostrarPerfilPrivado();
    }

    /**
     * Registra las preferencias de emparejamiento del usuario.
     */
    public void registrarPreferencias() {
        this.preferencias.cambiarPreferencias();
    }

    /**
     * Añade un like recibido de otro usuario.
     *
     * @param idUsuario el ID del usuario que ha dado like
     */
    public void anniadirLike(int idUsuario) {
        try {
            if (likesRecibidos.contains(idUsuario)) {
                throw new Exception("El usuario con ID: " + idUsuario + " ya ha dado like anteriormente.");
            }
            this.likesRecibidos.add(idUsuario);
            System.out.println("Like recibido del usuario con ID: " + idUsuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Obtiene la lista de likes recibidos.
     *
     * @return una lista de enteros que representan los IDs de usuarios que han dado like
     */
    public List<Integer> getLikesRecibidos() {
        return this.likesRecibidos;
    }

    /**
     * Obtiene la lista de matches recibidos.
     *
     * @return una lista de enteros que representan los IDs de usuarios con los que se ha hecho match
     */
    public List<Integer> getMatchesRecibidos() {
        return this.matchesRecibidos;
    }

    /**
     * Añade un match con otro usuario.
     *
     * @param idUsuario el ID del usuario con el que se ha hecho el match
     */
    public void anniadirMatch(int idUsuario) {
        try {
            if (getMatchesRecibidos().contains(idUsuario)) {
                throw new Exception("El usuario con ID: " + idUsuario + " ya tiene un match registrado.");
            }
            this.matchesRecibidos.add(idUsuario);
            System.out.println("Match realizado con el usuario con ID: " + idUsuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return el ID del usuario
     */
    public int getIdUsuario() {
        return this.idUsuario;
    }

    /**
     * Obtiene el perfil del usuario.
     *
     * @return el perfil del usuario
     */
    public Perfil getPerfil() {
        return this.perfil;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email el correo electrónico a establecer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasennia la contraseña a establecer
     */
    public void setContrasennia(String contrasennia) {
        this.contrasennia = contrasennia;
    }
}
