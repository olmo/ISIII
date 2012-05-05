package GestionDonaciones;

import java.sql.Date;


import GestionPersona.Donante;
import GestionPersona.DonanteDB;
import GestionPersona.Persona;
import GestionActuacion.ObjetoMonitorizable;;
enum Estado {Pagado, Pendiente, Cancelado};

public class Donacion extends ObjetoMonitorizable{
	private float cantidad;
	private Estado estado;
	private int idDonante;

	public Donacion(){
			
		}

	public Donacion(Donante donante, float cantidad, Estado estado){
		this.cantidad = cantidad;
		this.estado = estado;
		this.idDonante = donante.getId();
	}
	
	public void setIdObjMon(int id){
		this.id = id;
	}
	
	
	public int getIdObjMon(){
		return this.id;
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
