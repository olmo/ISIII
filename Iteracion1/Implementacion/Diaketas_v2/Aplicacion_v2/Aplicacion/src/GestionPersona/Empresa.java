/**
 * 
 */
package GestionPersona;

/**
 * @author 
 *
 */
public class Empresa extends Donante{
	private int cif;
	private String nombreEmpresa;
	private int telefonoEmpresa;
	private String direccionEmpresa;
	private String emailEmpresa;
	
	public Empresa(){}

	public Empresa(int id, int periocidad,int CIF,String nombreEmpresa, int telefonoEmpresa, String dirEmpresa, String emailEmpresa) {
		setId(id);
		setPeriocidad(periocidad);
		this.cif = CIF;
		this.nombreEmpresa = nombreEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.direccionEmpresa = dirEmpresa;
		this.emailEmpresa = emailEmpresa;
	}
	
	public int getCif() {
		return cif;
	}
	public void setCif(int cif) {
		this.cif = cif;
	}
	public int getTelefonoEmpresa() {
		return telefonoEmpresa;
	}
	public void setTelefonoEmpresa(int telefonoEmpresa) {
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
