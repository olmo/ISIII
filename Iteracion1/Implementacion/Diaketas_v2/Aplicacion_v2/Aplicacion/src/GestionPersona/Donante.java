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
	private int periocidad;

	public void introducirDonacion(String concepto, Float cantidad) {
		
	}
	public int getPeriocidad() {
		return periocidad;
	}
	public void setPeriocidad(int periocidad) {
		this.periocidad = periocidad;
	}
	
}
