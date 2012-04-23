/**
 * 
 */
package GestionPersona;




/**
 * @author
 *
 */
public abstract class Donante extends Persona{

	
	public Donante(){
		
	}
	private Integer periocidad;

	public void introducirDonacion(String concepto, Float cantidad) {
		
	}
	public Integer getPeriocidad() {
		return periocidad;
	}
	public void setPeriocidad(int periocidad) {
		this.periocidad = periocidad;
	}
	
}
