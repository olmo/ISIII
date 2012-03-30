/**
 * 
 */
package GestionDonantes;

/**
 * @author 
 *
 */
public class Empresa extends Donante{
	private Long cif;
	private String nombreEmpresa;
	private Long telefonoEmpresa;
	private String direccionEmpresa;
	public Long getCif() {
		return cif;
	}
	public void setCif(Long cif) {
		this.cif = cif;
	}
	public Long getTelefonoEmpresa() {
		return telefonoEmpresa;
	}
	public void setTelefonoEmpresa(Long telefonoEmpresa) {
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
}
