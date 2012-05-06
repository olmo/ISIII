package GestionActuacion;

import java.sql.Date;

public abstract class ObjetoMonitorizable {
	private int id;
	private Date fecha;
	

	public void ObjetoMonitorizable(){
		this.id = 0;
	}
	
	public void setIdObjMon(int id){
		this.id = id;
	}
	
	public void setDate(Date fecha){
		this.fecha = fecha;
	}
	
	public Date getDate(){
		return this.fecha;
	}
	
	public int getIdObjMon(){
		return this.id;
	}
}
