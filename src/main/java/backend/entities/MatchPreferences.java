package backend.entities;
import jakarta.persistence.*;

@Entity
public class MatchPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age_min", nullable = false)
    private int ageMin;

    @Column(name = "age_max", nullable = false)
    private int ageMax;

    @Column(nullable = false, length = 100)
    private String preferredGender;

    @Column(nullable = false, length = 100)
    private String preferredCity;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Getters y Setters
}