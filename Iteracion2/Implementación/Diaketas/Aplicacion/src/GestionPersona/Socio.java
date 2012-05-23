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
	
	
	
	public Socio(int id, String dni, String nombre, String apellido1,
			String apellido2, String fNacimiento, int telefono,
			String lugarNacimiento, String domicilio, Integer cp, String email,
			Integer periocidad, String usuario, String contrasena) {
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
		setPeriocidad(periocidad);
		this.usuario=usuario;
		this.contrasena=contrasena;
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
