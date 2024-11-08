package com.example;
import java.util.ArrayList;
import java.util.Collection;

/**
 * La clase Emparejamiento maneja la lógica de emparejamiento entre usuarios
 * en una aplicación de citas. Permite verificar matches, mostrar candidatos
 * y gestionar likes entre usuarios.
 * @author Valentina Cifuentes
 */
public class Emparejamiento {
    /** Colección de todos los usuarios compatibles para un posible match. */
    Collection<Usuario> candidatos;

    public Emparejamiento() {
        this.candidatos = new ArrayList<>();
    }

    /**
     * Verifica si hay un match entre dos usuarios.
     * Un match ocurre si ambos usuarios se han dado "like" mutuamente.
     *
     * @param usuario1 El primer usuario a comparar.
     * @param usuario2 El segundo usuario a comparar.
     * @return true si hay un match, false en caso contrario.
     */
    public boolean verificarMatch(Usuario usuario1, Usuario usuario2){
        return usuario1.getLikesRecibidos().contains(usuario2.getIdUsuario()) &&
        usuario2.getLikesRecibidos().contains(usuario1.getIdUsuario());
    }

    /**Muestra los perfiles públicos de los candidatos.*/
    public void mostrarCandidatos() {
        for (Usuario candidato : candidatos) {
            candidato.getPerfil().mostrarPerfilPublico();
        }
    }

    /**
     * Permite al usuario actual dar "like" a un candidato. 
     * Si se produce un match, se actualizan las listas de matches de ambos usuarios.
     *
     * @param usuarioActual El usuario que está dando el "like".
     * @param candidato El usuario que recibe el "like".
     */
    public void darLike(Usuario usuarioActual, Usuario candidato) {
        candidato.anniadirLike(usuarioActual.getIdUsuario());
        if (verificarMatch(usuarioActual, candidato)){
            anniadirMatches(usuarioActual, candidato);
        }
    }
    
    public void anniadirMatches(Usuario usuarioActual,Usuario candidato){
        candidato.anniadirMatch(usuarioActual.getIdUsuario());
        usuarioActual.anniadirMatch(candidato.getIdUsuario());
    }
    
    /**
     * Agrega un candidato a la colección de candidatos.
     *
     * @param compatible El usuario que se añadirá como candidato.
     */
    public void agregarCandidato(Usuario compatible) {
        candidatos.add(compatible);
    }

}