package GestionActuacion;


import java.util.ArrayList;



public class ControladorActuaciones {
	
	private ActuacionDB actuacionDB = new ActuacionDB();
	
	
	public ArrayList<Actuacion> listarTodasActuaciones(String filtro){
		return actuacionDB.getList(filtro);
	}
	

}
