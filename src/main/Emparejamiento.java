import java.util.*;

public class Emparejamiento {

    Collection<Usuario> candidatos;

    public Emparejamiento() {
        this.candidatos = new ArrayList<>();
    }

    public boolean verificarMatch(Usuario usuario1, Usuario usuario2){
        return usuario1.getLikesRecibidos().contains(usuario2.getIdUsuario()) &&
        usuario2.getLikesRecibidos().contains(usuario1.getIdUsuario());
    }

    public void mostrarCadidatos() {
        for (Usuario candidato : candidatos) {
            candidato.getPerfil().mostrarPerfilPublico();
        }
    }

    public void darLike(Usuario usuarioActual, Usuario candidato) {
        candidato.anniadirLike(usuarioActual.getIdUsuario());
        if (verificarMatch(usuarioActual, candidato)){
            candidato.anniadirMatch(usuarioActual.getIdUsuario());
            usuarioActual.anniadirMatch(candidato.getIdUsuario());
        }
    }

    public void agregarCandidato(Usuario compatible) {
        candidatos.add(compatible);
    }

}