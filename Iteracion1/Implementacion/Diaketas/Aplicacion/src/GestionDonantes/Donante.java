/**
 * 
 */
package GestionDonantes;

import GestionPersona.Persona;



/**
 * @author
 *
 */
public abstract class Donante extends Persona{

	private Long periocidad;

	public void introducirDonacion(String concepto, Float cantidad) {
		// TODO Auto-generated method stub
	}
	public Long getPeriocidad() {
		return periocidad;
	}
	public void setPeriocidad(Long periocidad) {
		this.periocidad = periocidad;
	}
	
}
