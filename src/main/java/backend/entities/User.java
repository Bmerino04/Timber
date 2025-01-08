package backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private MatchPreferences matchPreferences;

    @ElementCollection
    @CollectionTable(name = "user_likes", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "liked_user_id")
    private List<Long> likesReceived = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "user_matches", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "matched_user_id")
    private List<Long> matches = new ArrayList<>();

}