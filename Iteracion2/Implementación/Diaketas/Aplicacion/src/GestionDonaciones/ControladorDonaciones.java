package GestionDonaciones;

import java.util.ArrayList;

import GestionPersona.Donante;
import GestionPersona.DonanteDB;




public class ControladorDonaciones {
	private DonanteDB donanteDB = new DonanteDB(); 
	private DonacionDB donacionDB = new DonacionDB();
	
	
	public int aniadirDonacion(Donante donante, float cantidad, Estado estado){
		Donacion donacion = new Donacion(donante, cantidad, estado);
		if(donacionDB.add(donacion))
			return donacion.getIdObjMon();
		else return -1;
	
	}
	
	
	public Boolean confirmarDonacion(Donacion donacion){
		donacion.setEstado(Estado.Pagado);
		return donacionDB.set(donacion);
	}
	
	
	public Boolean cancelarDonacion(Donacion donacion){
		donacion.setEstado(Estado.Cancelado);
		return donacionDB.set(donacion);
	}
	
	
	public ArrayList<Donacion> listarDonaciones(String filtro){
		return donacionDB.getList(filtro);
	}
	
	
	public ArrayList<Donante> buscarDonantes(String filtro){
		return donanteDB.getDonantes(filtro);
	}


	
}
