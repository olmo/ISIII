package GestionAyudas;


import GestionPersona.Donante;

public class TipoAyuda {
	
	private String observaciones;
	private String nombre;
	int idTipo;
	
	public TipoAyuda(String observaciones, String nombre){
		this.observaciones = observaciones;
		this.nombre = nombre;
	}
	
	public void set(String observaciones, String nombre){
		this.observaciones = observaciones;
		this.nombre = nombre;
	}
	
	public int getId() {
		return this.idTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getObservaciones() {
		return observaciones;
	}


}
