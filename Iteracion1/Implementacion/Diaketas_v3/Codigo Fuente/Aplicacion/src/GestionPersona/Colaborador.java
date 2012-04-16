/**
 * 
 */
package GestionPersona;

/**
 * @author 
 *
 */
public class Colaborador extends Donante{

	public Colaborador(){}
	
	public Colaborador(int id, int periocidad) {
		setId(id);
		setPeriocidad(periocidad);
	}

	public Colaborador(int id, String dni, String nombre, String apellido1,
			String apellido2, String fNacimiento, int telefono,
			String lugarNacimiento, String domicilio, int cp, String email,
			int periocidad) {
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
	}

}
