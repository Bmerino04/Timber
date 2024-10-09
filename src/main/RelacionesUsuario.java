public class relacionesUsuario {

    private int idUsuario;
    private int likesRecibidos;
    private int matchsHechos; //cambiar por List<Usuario> ?

    public relacionesUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        this.likesRecibidos = 0;  
        this.matchsHechos = 0;    
    }

    public void añadirLike(Usuario otroUsuario) {
        if (otroUsuario != null) {
            otroUsuario.likesRecibidos++;
            System.out.println("Te ha dado like el usuario " + otroUsuario.idUsuario +); //cambiar id por nombre
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    public void mostrarLike() {
        System.out.println("Haz recibido " + likesRecibidos + " likes.");
    }

    public void añadirMatch(Usuario otroUsuario) { //no se si al final esta clase trabajara con Usuario o con perfil
        if (otroUsuario != null) {
            this.matchsHechos++;
            otroUsuario.matchsHechos++;
            System.out.println("Match hecho con el usuario " + otroUsuario.idUsuario + ". Total de matchs hechos: ");
        } else {
            System.out.println("El usuario no existe.");
        }

        //en la main Emparejamiento verifica si se hizo match y despues se usa añadirMatch de aca
    }

    public void mostrarMatch() { //cambiar por List<Usuario> ?
        System.out.println("Tienes " + matchsHechos + " matchs.");
    }

    public int getLikesRecibidos() {
        return likesRecibidos;
    }

    public int getMatchsHechos() {
        return matchsHechos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
}
