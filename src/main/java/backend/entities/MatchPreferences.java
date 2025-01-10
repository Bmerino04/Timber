package backend.entities;
import jakarta.persistence.*;

/**
 * Representa las preferencias de emparejamiento de un usuario.
 * Esta clase contiene la información sobre las preferencias de edad, género y ciudad
 * para emparejarse con otros usuarios.
 */
@Entity
public class MatchPreferences {

    /**
     * Identificador único de las preferencias de emparejamiento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Edad mínima preferida para el emparejamiento.
     * No puede ser nula.
     */
    @Column(name = "age_min", nullable = false)
    private int ageMin;

    /**
     * Edad máxima preferida para el emparejamiento.
     * No puede ser nula.
     */
    @Column(name = "age_max", nullable = false)
    private int ageMax;

    /**
     * Género preferido para el emparejamiento.
     * No puede ser nulo y tiene un máximo de 100 caracteres.
     */
    @Column(nullable = false, length = 100)
    private String preferredGender;

    /**
     * Ciudad preferida para el emparejamiento.
     * No puede ser nula y tiene un máximo de 100 caracteres.
     */
    @Column(nullable = false, length = 100)
    private String preferredCity;

    /**
     * Usuario asociado a estas preferencias de emparejamiento.
     * Establece una relación de uno a uno con la entidad {@link User}.
     * No puede ser nulo.
     */
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Constructor vacío requerido por JPA.
     */
    public MatchPreferences() {}

    /**
     * Constructor con parámetros para inicializar las preferencias de emparejamiento
     * con edad mínima, edad máxima, género preferido, ciudad preferida y el usuario asociado.
     *
     * @param ageMin La edad mínima preferida para el emparejamiento.
     * @param ageMax La edad máxima preferida para el emparejamiento.
     * @param preferredGender El género preferido para el emparejamiento.
     * @param preferredCity La ciudad preferida para el emparejamiento.
     * @param user El usuario asociado a estas preferencias de emparejamiento.
     */
    public MatchPreferences(int ageMin, int ageMax, String preferredGender, String preferredCity, User user) {
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.preferredGender = preferredGender;
        this.preferredCity = preferredCity;
        this.user = user;
    }

    // Getters y Setters

    /**
     * Obtiene el identificador de las preferencias de emparejamiento.
     *
     * @return El identificador único de las preferencias de emparejamiento.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de las preferencias de emparejamiento.
     *
     * @param id El identificador único de las preferencias de emparejamiento.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la edad mínima preferida para el emparejamiento.
     *
     * @return La edad mínima preferida.
     */
    public int getAgeMin() {
        return ageMin;
    }

    /**
     * Establece la edad mínima preferida para el emparejamiento.
     *
     * @param ageMin La edad mínima preferida.
     */
    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    /**
     * Obtiene la edad máxima preferida para el emparejamiento.
     *
     * @return La edad máxima preferida.
     */
    public int getAgeMax() {
        return ageMax;
    }

    /**
     * Establece la edad máxima preferida para el emparejamiento.
     *
     * @param ageMax La edad máxima preferida.
     */
    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    /**
     * Obtiene el género preferido para el emparejamiento.
     *
     * @return El género preferido para el emparejamiento.
     */
    public String getPreferredGender() {
        return preferredGender;
    }

    /**
     * Establece el género preferido para el emparejamiento.
     *
     * @param preferredGender El género preferido para el emparejamiento.
     */
    public void setPreferredGender(String preferredGender) {
        this.preferredGender = preferredGender;
    }

    /**
     * Obtiene la ciudad preferida para el emparejamiento.
     *
     * @return La ciudad preferida para el emparejamiento.
     */
    public String getPreferredCity() {
        return preferredCity;
    }

    /**
     * Establece la ciudad preferida para el emparejamiento.
     *
     * @param preferredCity La ciudad preferida para el emparejamiento.
     */
    public void setPreferredCity(String preferredCity) {
        this.preferredCity = preferredCity;
    }

    /**
     * Obtiene el usuario asociado a estas preferencias de emparejamiento.
     *
     * @return El usuario asociado a estas preferencias.
     */
    public User getUser() {
        return user;
    }

    /**
     * Establece el usuario asociado a estas preferencias de emparejamiento.
     *
     * @param user El usuario asociado a estas preferencias.
     */
    public void setUser(User user) {
        this.user = user;
    }
}