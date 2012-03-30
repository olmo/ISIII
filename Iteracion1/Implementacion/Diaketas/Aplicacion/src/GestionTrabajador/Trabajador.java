/**
 * 
 */
package GestionTrabajador;

import GestionPersona.Persona;

/**
 * @author
 *
 */
public class Trabajador extends Persona{
	private String usuario;
	private String contrasena;
	
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
