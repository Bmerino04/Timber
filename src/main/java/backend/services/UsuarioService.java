package backend.services;

import backend.entities.User;
import backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class UsuarioService {
    @Autowired
    private UserRepository userRepository;

    private PerfilService perfil;
    private PreferenciasEmparejamientoService preferencias;
    private EmparejamientoService emparejamiento;
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
    public UsuarioService() {
        this.idUsuario = contadorUsuarios++;
        this.preferencias = new PreferenciasEmparejamientoService();
        this.emparejamiento = new EmparejamientoService();
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
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return BCrypt.checkpw(contrasennia, user.getPassword());
        }
        return false;
    }

    /**
     * Inicia sesión solicitando el correo y la contraseña del usuario.
     * Si las credenciales son válidas, llama al método mostrarCandidatos().
     */
    public void iniciarSesion(String email, String contrasennia) {
        if (validarInformacion(email, contrasennia)) {
            System.out.println("Inicio de sesión exitoso.");
            //siguiente paso
        } else {
            System.out.println("Correo electrónico o contraseña incorrectos.");
        }
    }


    /**
     * Registra un nuevo usuario solicitando sus datos personales.
     * Valida la fecha de nacimiento y el correo electrónico antes de almacenar la información.
     */
    public void registrarUsuario() {
        try {
            User user = new User();
            user.setEmail(this.email);
            user.setPassword(encriptarContrasennia(this.contrasennia));

            // Validar y formatear la fecha
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(fechaNacimiento, formatter);
            user.setBirthDate(fecha);

            // Guarda el usuario en la base de datos
            userRepository.save(user);

            this.idUsuario = user.getId().intValue(); // Obtener el ID asignado
            System.out.println("Registro exitoso.");
        } catch (DateTimeParseException e) {
            System.out.println("Error: El formato de la fecha es inválido. Use 'dd/MM/yyyy'.");
        } catch (Exception e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
        }
    }

    /**
     * Método para registrar las preferencias del usuario.
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

    public List<Integer> getMatchesRecibidos() { return this.matchesRecibidos; }

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
    public PerfilService getPerfil() {
        return this.perfil;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setContrasennia(String contrasennia) {
        this.contrasennia = encriptarContrasennia(contrasennia);
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<User> obtenerUsuarios() {
        return userRepository.findAll();
    }

    // Método para obtener un usuario por su ID
    public User obtenerUsuarioPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    private String encriptarContrasennia(String contrasennia) {
        return BCrypt.hashpw(contrasennia, BCrypt.gensalt());
    }
}
