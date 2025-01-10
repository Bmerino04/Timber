package backend.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que gestiona las preferencias de emparejamiento de un usuario.
 * Permite establecer y evaluar criterios de compatibilidad con otros usuarios
 * basados en rango de edad, ciudad y género preferido.
 *
 * Este servicio incluye métodos para:
 * - Cambiar las preferencias del usuario.
 * - Evaluar compatibilidad de edad, ciudad y género con otros usuarios.
 * - Buscar candidatos compatibles dentro de una lista de usuarios.
 *
 * @author Viviana Castro
 */
@Service
public class PreferenciasEmparejamientoService {

    /**
     * Edad mínima preferida para el emparejamiento.
     */
    private int edadMinima;

    /**
     * Edad máxima preferida para el emparejamiento.
     */
    private int edadMaxima;

    /**
     * Lista de géneros preferidos para el emparejamiento.
     */
    private List<String> generoPreferido;

    /**
     * Ciudad preferida para el emparejamiento.
     */
    private String ciudadPreferida;

    /**
     * Constructor que inicializa la lista de géneros preferidos.
     */
    public PreferenciasEmparejamientoService() {
        this.generoPreferido = new ArrayList<>();
    }

    /**
     * Resetea las preferencias de emparejamiento del usuario actual.
     * Establece los valores predeterminados para rango de edad, géneros preferidos y ciudad de preferencia.
     */
    public void cambiarPreferencias() {
        this.edadMinima = 0;
        this.edadMaxima = 0;
        this.generoPreferido = null;
        this.ciudadPreferida = null;
    }

    /**
     * Evalúa si la ciudad de residencia de un usuario es compatible con la ciudad de preferencia.
     *
     * @param usuario El usuario cuya ciudad se está evaluando.
     * @return {@code true} si la ciudad coincide con la preferencia, {@code false} en caso contrario.
     */
    public boolean ciudadCompatible(UsuarioService usuario) {
        return ciudadPreferida != null && ciudadPreferida.equals(usuario.getPerfil().getCiudadResidencia());
    }

    /**
     * Verifica si la edad de un usuario está dentro del rango de edad preferido.
     *
     * @param usuario El usuario cuya edad se está evaluando.
     * @return {@code true} si la edad está dentro del rango, {@code false} en caso contrario.
     */
    public boolean edadCompatible(UsuarioService usuario) {
        int edadUsuario = usuario.getPerfil().getEdad();
        return (edadUsuario >= edadMinima && edadUsuario <= edadMaxima);
    }

    /**
     * Evalúa si el género de un usuario es compatible con los géneros preferidos.
     *
     * @param usuario El usuario cuyo género se está evaluando.
     * @return {@code true} si el género está en la lista de géneros preferidos, {@code false} en caso contrario.
     */
    public boolean generoCompatible(UsuarioService usuario) {
        if (generoPreferido == null || generoPreferido.isEmpty()) {
            return false;
        }
        String generoUsuario = usuario.getPerfil().getGenero();
        return generoPreferido.contains(generoUsuario);
    }

    /**
     * Busca usuarios compatibles en base a las preferencias del usuario actual.
     *
     * Recorre una lista de usuarios y agrega aquellos que cumplen con los criterios de
     * compatibilidad (edad, ciudad y género) a un objeto de emparejamiento.
     *
     * @param listaUsuarios Lista de usuarios a evaluar.
     * @param emparejamiento Objeto encargado de manejar los candidatos compatibles.
     */
    public void buscarCompatibles(List<UsuarioService> listaUsuarios, EmparejamientoService emparejamiento) {
        for (UsuarioService usuario : listaUsuarios) {
            if (ciudadCompatible(usuario) && edadCompatible(usuario) && generoCompatible(usuario)) {
                emparejamiento.agregarCandidato(usuario);
            }
        }
    }
}


