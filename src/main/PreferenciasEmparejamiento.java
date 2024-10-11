public class PreferenciasEmparejamiento {
	private int edadMinima;
	private int edadMaxima;
	private String[] generoPreferido;
	private String ciudadPreferida;


	public boolean ciudadCompatible(Usuario usuario){
		return ciudadPreferida.equals(usuario.getCiudadResidencia()) ;
	}

	public boolean edadCompatible(Usuario usuario){
		int edadUsuario = usuario.calcularEdad();
		return (edadUsuario >= edadMinima && edadUsuario >= edadMaxima);
	}
}