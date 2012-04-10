/**
 * 
 */
package GestionPersona;


/**
 * @author
 *
 */
public class Trabajador extends Persona{
	
	public Trabajador(){
		
	}
	
	public Trabajador(int id, String user, String password){
		setId(id);
		this.usuario=user;
		this.contrasena=password;
	}
	
	
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
