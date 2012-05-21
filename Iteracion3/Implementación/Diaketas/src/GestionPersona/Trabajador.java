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
	
	public Trabajador(int id, String dni, String nombre, String apellido1, String apellido2, String fNacimiento,int telefono, String lugarNacimiento, String domicilio, Integer cp, String email){
		setId(id);
		setDni(dni);
		setNombre(nombre);
		setApellido1(apellido1);
		setApellido2(apellido2);
		setfNacimiento(fNacimiento);
		setTelefono(telefono);
		setLugarNacimiento(lugarNacimiento);
		setDomicilio(domicilio);
		setCp(cp);
		setemail(email);
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
