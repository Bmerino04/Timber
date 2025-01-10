package backend.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un usuario dentro de la aplicación.
 * Contiene la información básica del usuario, como nombre, correo electrónico, contraseña,
 * fecha de nacimiento, preferencias de coincidencia y relaciones con otros usuarios.
 */
@Entity
public class User {

    /**
     * Identificador único del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del usuario.
     * No puede ser nulo y tiene un máximo de 100 caracteres.
     */
    @Column(nullable = false, length = 100)
    private String name;

    /**
     * Dirección de correo electrónico del usuario.
     * Debe ser único, no puede ser nulo y tiene un máximo de 150 caracteres.
     */
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    /**
     * Contraseña del usuario.
     * No puede ser nula.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Fecha de nacimiento del usuario.
     * No puede ser nula.
     */
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    /**
     * Perfil del usuario, relacionado de manera uno a uno con esta entidad.
     * Las modificaciones en el perfil se realizan en cascada, y se eliminan si el usuario es eliminado.
     */
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

    /**
     * Preferencias de coincidencia del usuario, relacionadas de manera uno a uno con esta entidad.
     * Las modificaciones en las preferencias se realizan en cascada, y se eliminan si el usuario es eliminado.
     */
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private MatchPreferences matchPreferences;

    /**
     * Lista de identificadores de usuarios que han dado "like" al usuario.
     * Esta relación no es una entidad, sino una colección de identificadores.
     */
    @ElementCollection
    @CollectionTable(name = "user_likes", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "liked_user_id")
    private List<Long> likesReceived = new ArrayList<>();

    /**
     * Lista de identificadores de usuarios con los que el usuario ha hecho "match".
     * Esta relación no es una entidad, sino una colección de identificadores.
     */
    @ElementCollection
    @CollectionTable(name = "user_matches", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "matched_user_id")
    private List<Long> matches = new ArrayList<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public User() {}

    /**
     * Constructor con parámetros para inicializar un usuario con nombre, correo electrónico,
     * contraseña y fecha de nacimiento.
     *
     * @param name El nombre del usuario.
     * @param email El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @param birthDate La fecha de nacimiento del usuario.
     */
    public User(String name, String email, String password, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public MatchPreferences getMatchPreferences() {
        return matchPreferences;
    }

    public void setMatchPreferences(MatchPreferences matchPreferences) {
        this.matchPreferences = matchPreferences;
    }

    public List<Long> getLikesReceived() {
        return likesReceived;
    }

    public void setLikesReceived(List<Long> likesReceived) {
        this.likesReceived = likesReceived;
    }

    public List<Long> getMatches() {
        return matches;
    }

    public void setMatches(List<Long> matches) {
        this.matches = matches;
    }
}
