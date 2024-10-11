public class PreferenciasEmparejamiento {
	private int edadMinima;
	private int edadMaxima;
	private String[] generoPreferido;
	private String ciudadPreferida;

	public boolean ciudadCompatible(Usuario usuario){
		return ciudadPreferida.equals(usuario.getCiudadResidencia()) ;
	}
}