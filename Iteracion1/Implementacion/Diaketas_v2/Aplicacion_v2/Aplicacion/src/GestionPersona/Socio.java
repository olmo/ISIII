/**
 * 
 */
package GestionPersona;


/**
 * @author 
 *
 */
public class Socio extends Donante{

	private String usuario;
	private String contrasena;
	
	public Socio(){}
	
	public Socio(int id, int periocidad, String user, String pass) {
		setPeriocidad(periocidad);
		usuario=user;
		contrasena=pass;
		setId(id);
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
	
}
