public class PreferenciasEmparejamiento {
	private int edadMinima;
	private int edadMaxima;
	private String[] generoPreferido;
	private String ciudadPreferida;

	public PreferenciasEmparejamiento(String [] generoPreferido){
		this.generoPreferido = generoPreferido;
	}

	public boolean ciudadCompatible(Usuario usuario){
		return ciudadPreferida.equals(usuario.getCiudadResidencia()) ;
	}

	public boolean edadCompatible(Usuario usuario){
		int edadUsuario = usuario.calcularEdad();
		return (edadUsuario >= edadMinima && edadUsuario >= edadMaxima);
	}
	
	public boolean generoCompatible(Usuario usuario){
		String generoUsuario = usuario.getGenero();
		for (String genero : generoPreferido){
			if (genero.equals(generoUsuario)){
				return true;
			}
		}
		return false;
	}


	public void buscarCompatibles(List<Usuario> listaUsuarios, Emparejamiento emparejamiento) {
		for (Usuario usuario : listaUsuarios){
			if (ciudadCompatible(usuario) && edadCompatible(usuario) && generoCompatible(usuario)){
				emparejamiento.agregarCandidato(usuario);
			}
		}
	}

	public void cambiarPreferencias(){
		
	}
}