package GestionPersona;






/**
 * @author
 *
 */



public class Persona{
	private Integer id;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String fNacimiento;
	private Integer telefono;
	private String lugarNacimiento;
	private String domicilio;
	private Integer cp;
	private Boolean estado;
	private String fBaja;
	private String email;

	
	
	public String getDni() {
		return dni;
	}


	public void setDni(String string) {
		this.dni = string;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public String getfNacimiento() {
		return fNacimiento;
	}


	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}


	public String getLugarNacimiento() {
		return lugarNacimiento;
	}


	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public Integer getCp() {
		return cp;
	}


	public void setCp(Integer cp) {
		this.cp = cp;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public String getfBaja() {
		return fBaja;
	}


	public void setfBaja(String fBaja) {
		this.fBaja = fBaja;
	}
	
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public Integer getTelefono() {
		return telefono;
	}


	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	public Persona(){
		
	}

	public Persona(String dni, String nombre, String apellido1, String apellido2, String fNacimiento, int telefono, String lugarNacimiento, String domicilio, int cp , String email) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.fNacimiento=fNacimiento;
		this.telefono=telefono;
		this.lugarNacimiento=lugarNacimiento;
		this.domicilio=domicilio;
		this.cp=cp;
		this.email=email;
	}



	

}
