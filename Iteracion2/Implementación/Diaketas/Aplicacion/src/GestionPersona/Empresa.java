/**
 * 
 */
package GestionPersona;


/**
 * @author 
 *
 */
public class Empresa extends Donante{
	private Integer cif;
	private String nombreEmpresa;
	private Integer telefonoEmpresa;
	private String direccionEmpresa;
	private String emailEmpresa;
	
	public Empresa(){}

	public Empresa(Integer id, Integer periocidad,Integer CIF,String nombreEmpresa, Integer telefonoEmpresa, String dirEmpresa, String emailEmpresa) {
		setId(id);
		setPeriocidad(periocidad);
		this.cif = CIF;
		this.nombreEmpresa = nombreEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.direccionEmpresa = dirEmpresa;
		this.emailEmpresa = emailEmpresa;
	}
	
	public Empresa(Integer id, String dni, String nombre, String apellido1,
			String apellido2, String fNacimiento, Integer telefono,
			String lugarNacimiento, String domicilio, Integer cp, String email,
			Integer periocidad, Integer CIF, String nombreEmpresa,
			Integer telefonoEmpresa, String dirEmpresa, String emailEmpresa) {
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
		this.cif = CIF;
		this.nombreEmpresa = nombreEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.direccionEmpresa = dirEmpresa;
		this.emailEmpresa = emailEmpresa;
	}

	public Integer getCif() {
		return cif;
	}
	public void setCif(Integer cif) {
		this.cif = cif;
	}
	public Integer getTelefonoEmpresa() {
		return telefonoEmpresa;
	}
	public void setTelefonoEmpresa(Integer telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}
	public String getDireccionEmpresa() {
		return direccionEmpresa;
	}
	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	public String getemailEmpresa() {
		return emailEmpresa;
	}
	public void setemailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}
}
