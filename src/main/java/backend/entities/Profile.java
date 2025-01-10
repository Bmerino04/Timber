package backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
/**
 * Representa el perfil de un usuario dentro de la aplicación.
 * Contiene información adicional sobre el usuario, como su biografía, género,
 * ciudad, pronombres y la relación con el usuario correspondiente.
 */
@Entity
public class Profile {

    /**
     * Identificador único del perfil.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Biografía del usuario.
     * No puede ser nula y tiene un máximo de 100 caracteres.
     */
    @Column(nullable = false, length = 100)
    private String bio;

    /**
     * Género del usuario.
     * No puede ser nulo y tiene un máximo de 50 caracteres.
     */
    @Column(nullable = false, length = 50)
    private String gender;

    /**
     * Ciudad en la que reside el usuario.
     * No puede ser nula y tiene un máximo de 100 caracteres.
     */
    @Column(nullable = false, length = 100)
    private String city;

    /**
     * Pronombres preferidos del usuario.
     * No puede ser nulo y tiene un máximo de 100 caracteres.
     */
    @Column(nullable = false, length = 100)
    private String pronouns;

    /**
     * Usuario asociado al perfil.
     * Establece una relación de uno a uno con la entidad {@link User}.
     * No puede ser nulo.
     */
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Profile() {}

    /**
     * Constructor con parámetros para inicializar un perfil con biografía, género, ciudad,
     * pronombres y el usuario asociado.
     *
     * @param bio La biografía del usuario.
     * @param gender El género del usuario.
     * @param city La ciudad en la que reside el usuario.
     * @param pronouns Los pronombres preferidos del usuario.
     * @param user El usuario asociado a este perfil.
     */
    public Profile(String bio, String gender, String city, String pronouns, User user) {
        this.bio = bio;
        this.gender = gender;
        this.city = city;
        this.pronouns = pronouns;
        this.user = user;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
