package backend.repositories;
import backend.entities.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.matchPreferences.rangoEdadMin >= :edadMinima AND u.matchPreferences.rangoEdadMax <= :edadMaxima")
    List<User> findCandidatosPorPreferencias(
            @Param("edadMinima") int edadMinima,
            @Param("edadMaxima") int edadMaxima,
            @Param("genero") String genero,
            @Param("ciudad") String ciudad
    );
}
