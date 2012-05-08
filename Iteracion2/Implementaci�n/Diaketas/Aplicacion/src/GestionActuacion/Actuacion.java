package GestionActuacion;

import java.sql.Date;
import java.sql.Timestamp;

import GestionPersona.Trabajador;




public class Actuacion {
	private Timestamp fecha;
	private TipoActuacion tipoActuacion;
	private int idObjMonitorizado;
	private int idTrabajador;
	
	
	public Actuacion(){
		
	}
	
	
	public Actuacion(Trabajador trabajador, TipoActuacion tipoAct, int idObjMon, Timestamp fecha){
		this.fecha = fecha;
		this.tipoActuacion = tipoAct;
		this.idObjMonitorizado = idObjMon;
		this.idTrabajador = trabajador.getId();
	}
	
	
	public void setFecha(Timestamp fecha){
		this.fecha = fecha;
	}
	
	
	public Timestamp getFecha(){
		return this.fecha;
	}
	
	
	public void setTipoActuacion(TipoActuacion actuacion){
		this.tipoActuacion = actuacion;
	}
	
	
	public TipoActuacion getTipoActuacion(){
		return this.tipoActuacion;
	}
	
	
	public void setIdObjMonitorizado(int id){
		this.idObjMonitorizado = id;
	}
	
	
	public int getIdObjMonitorizado(){
		return this.idObjMonitorizado;
	}
	
	
	public void setIdTrabajador(int id){
		idTrabajador = id;
	}
	
	
	public int getIdTrabajador(){
		return idTrabajador;
	}
}
