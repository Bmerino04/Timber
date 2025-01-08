package backend.entities;

import jakarta.persistence.*;

@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id_origin", nullable = false)
    private User userOrigin;

    @ManyToOne
    @JoinColumn(name = "user_id_target", nullable = false)
    private User userTarget;

    // Getters y Setters
}
