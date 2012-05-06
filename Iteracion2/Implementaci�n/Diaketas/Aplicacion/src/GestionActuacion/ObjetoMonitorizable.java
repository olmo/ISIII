package GestionActuacion;

import java.sql.Date;

public abstract class ObjetoMonitorizable {
	int id;
	Date fecha;
	
	public void setIdObjMon(int id){
		this.id = id;
	}
	
	
	public int getIdObjMon(){
		return this.id;
	}
}
