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
