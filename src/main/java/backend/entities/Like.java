package backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Representa un "like" realizado por un usuario hacia otro.
 * Esta clase mantiene una relación de muchos a uno entre el usuario que originó el "like"
 * y el usuario al que se le dio el "like".
 */
@Entity
public class Like {

    /**
     * Identificador único del "like".
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * El usuario que originó el "like".
     * Relación de muchos a uno con la entidad {@link User}.
     */
    @ManyToOne
    @JoinColumn(name = "user_id_origin", nullable = false)
    private User userOrigin;

    /**
     * El usuario al que se le dio el "like".
     * Relación de muchos a uno con la entidad {@link User}.
     */
    @ManyToOne
    @JoinColumn(name = "user_id_target", nullable = false)
    private User userTarget;

    // Getters y Setters

    /**
     * Obtiene el identificador del "like".
     *
     * @return El identificador único del "like".
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del "like".
     *
     * @param id El identificador único del "like".
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el usuario que originó el "like".
     *
     * @return El usuario que dio el "like".
     */
    public User getUserOrigin() {
        return userOrigin;
    }

    /**
     * Establece el usuario que originó el "like".
     *
     * @param userOrigin El usuario que dio el "like".
     */
    public void setUserOrigin(User userOrigin) {
        this.userOrigin = userOrigin;
    }

    /**
     * Obtiene el usuario al que se le dio el "like".
     *
     * @return El usuario al que se le dio el "like".
     */
    public User getUserTarget() {
        return userTarget;
    }

    /**
     * Establece el usuario al que se le dio el "like".
     *
     * @param userTarget El usuario al que se le dio el "like".
     */
    public void setUserTarget(User userTarget) {
        this.userTarget = userTarget;
    }
}
