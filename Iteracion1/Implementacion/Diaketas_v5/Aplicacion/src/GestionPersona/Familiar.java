/**
 * 
 */
package GestionPersona;

/**
 * @author
 *
 */
public class Familiar extends Persona{
	
	private int id_beneficiario;
	private String parentesco;
	private String ocupacion;
	
	public Familiar(){
		
		
	}
	public Familiar(int id_persona ,int id_beneficiario,String parentesco, String ocupacion){
		setId(id_persona);
		this.id_beneficiario=id_beneficiario;
		this.parentesco=parentesco;
		this.ocupacion=ocupacion;
	}
	
	
	public Familiar(int id, String dni,String nombre, String apellido1, String apellido2, String fNacimiento,int telefono, String lugarNacimiento, String domicilio, Integer cp, String email,int id_beneficiario,String parentesco, String ocupacion){
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
		this.id_beneficiario=id_beneficiario;
		this.parentesco=parentesco;
		this.ocupacion=ocupacion;
	}
	
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	
	public int getidBeneficiario() {
		return id_beneficiario;
	}
	public void setidBeneficiario(int id_beneficiario) {
		this.id_beneficiario=id_beneficiario;
	}
	

}
