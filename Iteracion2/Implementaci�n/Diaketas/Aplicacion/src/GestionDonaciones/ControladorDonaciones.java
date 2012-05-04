package GestionDonaciones;

import java.util.ArrayList;
import GestionPersona.Donante;
import GestionPersona.DonanteDB;
import GestionDonaciones.Donacion;
import GestionDonaciones.DonacionDB;

enum Estado {Pagado, Pendiente, Cancelado};


public class ControladorDonaciones {
	private DonanteDB donanteDB = new DonanteDB(); 
	private DonacionDB donacionDB = new DonacionDB();
	
	
	private Boolean aniadirDonacion(Donante donante, float cantidad, Estado estado){
		Donacion donacion = new Donacion(donante, cantidad, estado);
		return donacionDB.add(donacion);
	}
	
	
	private Boolean confirmarDonacion(Donacion donacion){
		donacion.setEstado(Estado.Pagado);
		return donacionDB.set(donacion);
	}
	
	
	private Boolean cancelarDonacion(Donacion donacion){
		donacion.setEstado(Estado.Cancelado);
		return donacionDB.set(donacion);
	}
	
	
	private ArrayList<Donacion> listarDonaciones(String filtro){
		return donacionDB.getList(filtro);
	}
	
	
	private ArrayList<Donante> buscarDonantes(String filtro){
		return donanteDB.getDonantes(filtro);
	}
}
