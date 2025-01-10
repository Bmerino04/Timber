package backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Representa una coincidencia entre dos usuarios en el sistema.
 * Esta clase mantiene una relación de muchos a uno entre dos usuarios que han hecho match.
 */
@Entity
public class Match {

    /**
     * Identificador único de la coincidencia.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * El primer usuario en la coincidencia.
     * Relación de muchos a uno con la entidad {@link User}.
     */
    @ManyToOne
    @JoinColumn(name = "user1_id", nullable = false)
    private User user1;

    /**
     * El segundo usuario en la coincidencia.
     * Relación de muchos a uno con la entidad {@link User}.
     */
    @ManyToOne
    @JoinColumn(name = "user2_id", nullable = false)
    private User user2;

    // Getters y Setters

    /**
     * Obtiene el identificador de la coincidencia.
     *
     * @return El identificador único de la coincidencia.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la coincidencia.
     *
     * @param id El identificador único de la coincidencia.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el primer usuario de la coincidencia.
     *
     * @return El primer usuario en la coincidencia.
     */
    public User getUser1() {
        return user1;
    }

    /**
     * Establece el primer usuario de la coincidencia.
     *
     * @param user1 El primer usuario en la coincidencia.
     */
    public void setUser1(User user1) {
        this.user1 = user1;
    }

    /**
     * Obtiene el segundo usuario de la coincidencia.
     *
     * @return El segundo usuario en la coincidencia.
     */
    public User getUser2() {
        return user2;
    }

    /**
     * Establece el segundo usuario de la coincidencia.
     *
     * @param user2 El segundo usuario en la coincidencia.
     */
    public void setUser2(User user2) {
        this.user2 = user2;
    }
}

