package GestionDonaciones;

import GestionActuacion.ObjetoMonitorizable;
import GestionPersona.Donante;
//enum Estado {Pagado, Pendiente, Cancelado};

public class Donacion extends ObjetoMonitorizable{
	private float cantidad;
	private Estado estado;
	private int idDonante;


	public Donacion(){
		this.setIdObjMon(0);
			
		}
	//Donacion
	public Donacion(Donante donante, float cantidad, Estado estado){
		this.cantidad = cantidad;
		this.estado = estado;
		this.idDonante = donante.getId();
	}
	
		
	public void setEstado(Estado estado){
		
		this.estado = estado;
	}
	
	public void setCantidad(float cantidad){
		this.cantidad = cantidad;
	}
	
	public void setIdDonante(int idDonante){
		this.idDonante = idDonante;
	}
	
	public int getIdDonante(){
		return this.idDonante;
	}
	public float getCantidad(){
		return this.cantidad;
	}
	public Estado getEstado(){
		return this.estado;
	}
	
}
