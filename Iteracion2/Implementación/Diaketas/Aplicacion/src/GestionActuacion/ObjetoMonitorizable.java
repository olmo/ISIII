package GestionActuacion;

import java.sql.Timestamp;

public abstract class ObjetoMonitorizable {
	private int id;
	private Timestamp fecha;
	

	public ObjetoMonitorizable(){
		this.id = 0;
	}
	
	public void setIdObjMon(int id){
		this.id = id;
	}
	
	public void setDate(Timestamp fecha){
		this.fecha = fecha;
	}
	
	public Timestamp getDate(){
		return this.fecha;
	}
	
	public int getIdObjMon(){
		return this.id;
	}
}
