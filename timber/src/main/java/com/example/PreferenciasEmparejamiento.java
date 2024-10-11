package com.example;

import java.util.List;
import java.util.ArrayList;
/**
 * Esta clase maneja las preferencias de emparejamiento de un usuario.
 * Filtra candidatos basados en el rango de edad, ciudad de preferencia, y género preferido del usuario.
 * 
 * Métodos como {@code buscarCompatibles} ayudan a encontrar candidatos que cumplan con los criterios definidos por el usuario.
 */
public class PreferenciasEmparejamiento {


    /**
     * La edad mínima preferida para el emparejamiento.
     */
	private int edadMinima;
	/**
     * La edad máxima preferida para el emparejamiento.
     */
	private int edadMaxima;
	/**
     * Los géneros preferidos para el emparejamiento.
     */
	private List<String> generoPreferido;
	/**
     * La ciudad preferida para el emparejamiento.
     */
	private String ciudadPreferida;


	public PreferenciasEmparejamiento(){
		this.generoPreferido = new ArrayList<>();
	}

	/**
     * Verifica si la ciudad de un usuario es compatible con las preferencias del usuario actual.
     * 
     * @param usuario El usuario con el que se está comparando.
     * @return true si la ciudad del usuario coincide con la ciudad de preferencia, 
     *         false en caso contrario.
     */
	public boolean ciudadCompatible(Usuario usuario){
		return ciudadPreferida.equals(usuario.getPerfil().getCiudadResidencia()) ;
	}

	/**
     * Verifica si la edad de un usuario está dentro del rango de edad preferido del usuario actual.
     * 
     * @param usuario El usuario con el que se está comparando.
     * @return true si la edad del usuario está dentro del rango preferido,
     *         false en caso contrario.
     */
	public boolean edadCompatible(Usuario usuario){
		int edadUsuario = usuario.getPerfil().getEdad();
		return (edadUsuario >= edadMinima && edadUsuario >= edadMaxima);
	}
	
	/**
     * Verifica si el género de un usuario es compatible con las preferencias del usuario actual.
     * 
     * @param usuario El usuario con el que se está comparando.
     * @return true si el género del usuario está en la lista de géneros preferidos,
     *         false en caso contrario.
     */
	public boolean generoCompatible(Usuario usuario){
		String generoUsuario = usuario.getPerfil().getGenero();
		for (String genero : generoPreferido){
			if (genero.equals(generoUsuario)){
				return true;
			}
		}
		return false;
	}

    /**
     * Busca usuarios compatibles basados en las preferencias del usuario actual.
     * Recorre una lista de usuarios (la futura base de datos) y, si cumplen con las preferencias de género, edad y ciudad, los agrega a una lista de candidatos.
     * 
     * @param usuarios La lista de usuarios a comparar.
     * @param emparejamiento El objeto que maneja el emparejamiento y los candidatos.
     */
	public void buscarCompatibles(List<Usuario> listaUsuarios, Emparejamiento emparejamiento) {
		for (Usuario usuario : listaUsuarios){
			if (ciudadCompatible(usuario) && edadCompatible(usuario) && generoCompatible(usuario)){
				emparejamiento.agregarCandidato(usuario);
			}
		}
	}

	/**
     * Cambia las preferencias de emparejamiento del usuario actual.
     * 
     * Este método permite modificar el rango de edad, los géneros preferidos, y la ciudad de preferencia.
     * 
     * @param edadMinima La nueva edad mínima preferida.
     * @param edadMaxima La nueva edad máxima preferida.
     * @param generoPreferido Los nuevos géneros preferidos.
     * @param ciudadPreferida La nueva ciudad de preferencia.
     */
	public void cambiarPreferencias(int nuevaEdadMinima, int nuevaEdadMaxima, List<String> nuevoGeneroPreferido, String nuevaCiudadPreferida){
          this.edadMinima = 0;
          this.edadMaxima = 0;
          this.generoPreferido = null;
          this.ciudadPreferida = null;          
	}
}