package backend.entities;
import jakarta.persistence.*;

@Entity
public class Profile{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String bio;

    @Column(nullable = false, length = 50)
    private String gender;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 100)
    private String pronouns;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Getters y Setters
}