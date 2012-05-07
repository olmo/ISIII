package GestionActuacion;



import java.sql.Date;
import java.util.ArrayList;

import GestionPersona.Trabajador;



public class ControladorActuaciones {
	
	private ActuacionDB actuacionDB = new ActuacionDB();
	
	
	public ArrayList<Actuacion> listarTodasActuaciones(String filtro){
		return actuacionDB.getList(filtro);
	}
	
	public void anotarActuacion(int id_obj, Trabajador trabajador, TipoActuacion tipoAct){
		
		Date dt =new Date(System.currentTimeMillis());
		//La fecha de ahora mismo
		
		Actuacion act = new Actuacion(trabajador, tipoAct, id_obj, dt);
		
		actuacionDB.add(act);
	}
}
