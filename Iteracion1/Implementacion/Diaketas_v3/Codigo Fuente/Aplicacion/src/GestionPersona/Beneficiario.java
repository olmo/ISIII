/**
 * 
 */
package GestionPersona;


/**
 * @author
 *
 */
public class Beneficiario extends Persona{
	private String localidad;
	private String eCivil;
	private String nEstudios;
	private String nacionalidad;
	private String sEconomica;
	private String observacionesPersonales;
	private String observacionesVivienda;
	private String observacionesFamiliares;
	
	
	public Beneficiario(){
		
	}
	
	public Beneficiario(int id,String localidad,String eCivil,String nEstudios,String nacionalidad,String sEconomica,String observacionesPersonales,String observacionesVivienda,String observacionesFamiliares){
		setId(id);
		this.localidad=localidad;
		this.eCivil=eCivil;
		this.nEstudios=nEstudios;
		this.nacionalidad=nacionalidad;
		this.sEconomica=sEconomica;
		this.observacionesPersonales=observacionesPersonales;
		this.observacionesVivienda=observacionesVivienda;
		this.observacionesFamiliares=observacionesFamiliares;
	}

	
	public Beneficiario(int id,String dni, String nombre, String apellido1, String apellido2, String fNacimiento, int telefono, String lugarNacimiento, String domicilio, int cp,String email, String localidad, String eCivil, String nEstudios, String nacionalidad, String sEconomica, String observacionesPersonales, String observacionesVivienda, String observacionesFamiliares){
		setId(id);
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
		this.localidad=localidad;
		this.eCivil=eCivil;
		this.nEstudios=nEstudios;
		this.nacionalidad=nacionalidad;
		this.sEconomica=sEconomica;
		this.observacionesPersonales=observacionesPersonales;
		this.observacionesVivienda=observacionesVivienda;
		this.observacionesFamiliares=observacionesFamiliares;		
	}
	
	public String geteCivil() {
		return eCivil;
	}
	public void seteCivil(String eCivil) {
		this.eCivil = eCivil;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getnEstudios() {
		return nEstudios;
	}
	public void setnEstudios(String nEstudios) {
		this.nEstudios = nEstudios;
	}
	public String getsEconomica() {
		return sEconomica;
	}
	public void setsEconomica(String sEconomica) {
		this.sEconomica = sEconomica;
	}
	public String getObservacionesPersonales() {
		return observacionesPersonales;
	}
	public void setObservacionesPersonales(String observacionesPersonales) {
		this.observacionesPersonales = observacionesPersonales;
	}
	public String getObservacionesVivienda() {
		return observacionesVivienda;
	}
	public void setObservacionesVivienda(String observacionesVivienda) {
		this.observacionesVivienda = observacionesVivienda;
	}
	public String getObservacionesFamiliares() {
		return observacionesFamiliares;
	}
	public void setObservacionesFamiliares(String observacionesFamiliares) {
		this.observacionesFamiliares = observacionesFamiliares;
	}
}
