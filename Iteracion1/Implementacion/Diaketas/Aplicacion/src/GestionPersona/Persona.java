package GestionPersona;



import java.util.Date;


/**
 * @author
 *
 */



public class Persona{
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fNacimiento;
	private Long telefono;
	private String lugarNacimiento;
	private String domicilio;
	private Integer cp;
	private Boolean estado;
	private Date fBaja;
	private Long id;
	
	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
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


	public Date getfNacimiento() {
		return fNacimiento;
	}


	public void setfNacimiento(Date fNacimiento) {
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


	public Date getfBaja() {
		return fBaja;
	}


	public void setfBaja(Date fBaja) {
		this.fBaja = fBaja;
	}


	
	
/*
	public ArrayList<Persona> buscaPersonas(String dni, String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean existePersona(String dni) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Persona getPersona(String dni) {
		// TODO Auto-generated method stub
		return null;
	}*/
	public void introducirDatos(String dni, String nombre, String apellido1, String apellido2, Date fNacimiento, long telefono, String lugarNacimiento, String domicilio, int cp,boolean estado, Date fBaja) {
		// TODO Auto-generated method stub
		this.dni=dni;
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.fNacimiento=fNacimiento;
		this.setTelefono(telefono);
		this.lugarNacimiento=lugarNacimiento;
		this.domicilio=domicilio;
		this.cp=cp;
		this.estado=estado;
		this.fBaja=fBaja;
		
		
	}
	/*
	@Override
	public void modificarDatos() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void borrarDatos() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void darBajaPersona() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getDatosPersona() {
		// TODO Auto-generated method stub
		
	}*/


	public Long getTelefono() {
		return telefono;
	}


	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	

}
