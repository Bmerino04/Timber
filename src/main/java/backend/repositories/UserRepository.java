package backend.repositories;
import backend.entities.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaz que proporciona métodos para interactuar con la base de datos relacionados con los usuarios.
 * Extiende de JpaRepository para aprovechar las operaciones CRUD básicas.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca un usuario por su dirección de correo electrónico.
     *
     * @param email Dirección de correo electrónico del usuario.
     * @return El objeto {@link User} correspondiente al correo electrónico proporcionado.
     */
    User findByEmail(String email);

    /**
     * Encuentra una lista de usuarios que coinciden con los criterios de preferencia de edad,
     * género y ciudad proporcionados. Los usuarios deben tener preferencias de coincidencia que
     * estén dentro del rango de edad especificado.
     *
     * @param edadMinima La edad mínima de los usuarios a considerar.
     * @param edadMaxima La edad máxima de los usuarios a considerar.
     * @param genero     El género de los usuarios a considerar (puede ser "Masculino", "Femenino", etc.).
     * @param ciudad     La ciudad en la que los usuarios residen.
     * @return Una lista de objetos {@link User} que cumplen con los criterios de búsqueda.
     */
    @Query("SELECT u FROM User u WHERE u.matchPreferences.ageMin >= :edadMinima AND u.matchPreferences.ageMax <= :edadMaxima")
    List<User> findCandidatosPorPreferencias(
            @Param("edadMinima") int edadMinima,
            @Param("edadMaxima") int edadMaxima,
            @Param("genero") String genero,
            @Param("ciudad") String ciudad
    );
}