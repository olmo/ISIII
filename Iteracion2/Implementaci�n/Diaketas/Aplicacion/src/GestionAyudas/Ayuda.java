package GestionAyudas;

import GestionActuacion.ObjetoMonitorizable;
import GestionAyudas.TipoAyuda;
import GestionPersona.Beneficiario;
enum Estado {Pagado, Pendiente, Cancelado};

public class Ayuda extends ObjetoMonitorizable{
	
	private int idTipo;
	private String observaciones;
	private int idBeneficario;
	private float cantidadMonetaria;
	

	public Ayuda(){
			
		}
	
	public Ayuda(Beneficiario beneficiario, String observaciones_ayuda, TipoAyuda tipoAyuda, float cantidadMonetaria){
		this.observaciones = observaciones_ayuda;
		this.cantidadMonetaria = cantidadMonetaria;
		this.idBeneficario = beneficiario.getId();
		this.idTipo = tipoAyuda.getId();
	}
	
	public void set(Beneficiario beneficiario, String observaciones_ayuda, TipoAyuda tipoAyuda, float cantidadMonetaria){
		this.observaciones = observaciones_ayuda;
		this.cantidadMonetaria = cantidadMonetaria;
		this.idBeneficario = beneficiario.getId();
		this.idTipo = tipoAyuda.getId();
	}
	
	public void setIdObjMon(int id){
		this.id = id;
	}
	
	public void setIdTipoAyuda(int idTipo){
		this.idTipo = idTipo;
	}
	
	public void setIdBeneficiario(int idBene){
		
		this.idBeneficario = idBene;
	}
	
	public void setObservaciones(String obs){
		this.observaciones = obs;
	}
	
	public void setCantidadMonetaria(float cantidadMonetaria){
		this.cantidadMonetaria = cantidadMonetaria;
	}

	public int getIdObjMon() {
		return this.id;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public float getCantidadMonetaria() {
		return this.cantidadMonetaria;
	}

	public int getIdBeneficiario() {
		return this.idBeneficario;
	}

	public int getIdTipoAyuda() {
		return idTipo;
	}
	
	
	
}
