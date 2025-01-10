package backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.entities.Profile;
import backend.entities.User;
import backend.repositories.ProfileRepository;


/**
 * La clase Perfil representa la información personal
 * de un usuario en la aplicación. Incluye atributos como el nombre de usuario,
 * edad, género, ciudad de residencia, biografía y pronombres preferidos.
 * Proporciona métodos para mostrar el perfil público y privado del usuario.
 * 
 * @author Carlos Cienfuegos
 */

@Service
public class PerfilService {

    private String nombreUsuario;
    private int edad;
    private String genero;
    private String ciudadResidencia;
    private String biografia;
    private List<String> pronombres;

    @Autowired
    private ProfileRepository profileRepository;

    /**
     * Constructor para crear un perfil de usuario con todos los detalles.
     *
     * @param nombreUsuario    El nombre del usuario en la aplicación.
     * @param edad             La edad del usuario.
     * @param genero           El género del usuario.
     * @param ciudadResidencia La ciudad donde reside el usuario.
     * @param biografia        Una breve biografía del usuario.
     * @param pronombres       Los pronombres preferidos del usuario (ej. "él",
     *                         "ella", "elle").
     */
    public PerfilService(String nombreUsuario, int edad, String genero, String ciudadResidencia, String biografia, 
            List<String> pronombres) {
        this.nombreUsuario = nombreUsuario;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.biografia = biografia;
        this.pronombres = new ArrayList<>();
    }

    /**
     * Crear un nuevo perfil en la base de datos.
     * @param userId ID del usuario asociado al perfil.
     * @param nombreUsuario Nombre del usuario.
     * @param genero Género del usuario.
     * @param ciudad Ciudad de residencia del usuario.
     * @param biografia Biografía del usuario.
     * @param pronombres Pronombres preferidos del usuario.
     * @return El perfil creado.
     */

    public Profile crearPerfil(User user, String genero, String ciudad, String biografia, String pronombres) {
        Profile profile = new Profile();
        profile.setUser(user);
        profile.setGender(genero);
        profile.setCity(ciudad);
        profile.setBio(biografia);
        profile.setPronouns(pronombres);

        return profileRepository.save(profile);
    }

    /**
     * Obtener un perfil por ID de usuario.
     * @param userId ID del usuario.
     * @return El perfil asociado o null si no existe.
     */
    public Profile obtenerPerfilPorUserId(Long userId) {
        return profileRepository.findByUserId(userId);
    }

    /**
     * Obtener todos los perfiles de la base de datos.
     * @return Lista de perfiles.
     */
    public List<Profile> obtenerTodosLosPerfiles() {
        return profileRepository.findAll();
    }

    /**
     * Actualizar un perfil existente.
     * @param userId ID del usuario asociado al perfil.
     * @param nombreUsuario Nuevo nombre de usuario.
     * @param genero Nuevo género.
     * @param ciudad Nueva ciudad de residencia.
     * @param biografia Nueva biografía.
     * @param pronombres Nuevos pronombres preferidos.
     * @return El perfil actualizado o null si no se encontró.
     */
    public Profile actualizarPerfil(Long userId, String nombreUsuario, String genero, String ciudad, String biografia, String pronombres) {
        Profile profile = profileRepository.findByUserId(userId);
        if (profile != null) {
            profile.setGender(genero);
            profile.setCity(ciudad);
            profile.setBio(biografia);
            profile.setPronouns(pronombres);
            return profileRepository.save(profile);
        }
        return null;
    }

    /**
     * Eliminar un perfil por ID de usuario.
     * @param userId ID del usuario.
     * @return true si el perfil fue eliminado, false si no se encontró.
     */
    public boolean eliminarPerfil(Long userId) {
        Profile profile = profileRepository.findByUserId(userId);
        if (profile != null) {
            profileRepository.delete(profile);
            return true;
        }
        return false;
    }


    // Getters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public String getBiografia() {
        return biografia;
    }

    public List<String> getPronombres() {
        return pronombres;
    }

    // Setters
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setPronombres(List<String> pronombres) {
        this.pronombres = pronombres != null ? new ArrayList<>(pronombres) : new ArrayList<>();
    }
}
