package GestionPersona;

import java.sql.Date;

import javax.swing.table.TableModel;

public class ControladorPersona {

	Persona p=new Persona();
	
	PersonaBD pBD=new PersonaBD();
	
	public PersonaBD getpBD() {
		return pBD;
	}

	public void setpBD(PersonaBD pBD) {
		this.pBD = pBD;
	}

	public TableModel buscaPersonas(String nombre, String filtro){
		return pBD.buscaPersonas(nombre, filtro);
		
	}
	
	public Boolean existePersona(String dni){
		return pBD.existePersona(dni);
	}
	
	public Persona getPersona(String dni){
		return pBD.getPersona(dni);
	}
	
	public void introducirDatos(String dni, String nombre, String apellido1, String apellido2, Date fNacimiento, long telefono, String lugarNacimiento, String domicilio, int cp,boolean estado, Date fBaja){
		p.introducirDatos(dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp, estado, fBaja);
	}
	
	public void iniciarModificarPersona(String dni){
		
	}
	
	public void borrarDatosPersona(String dni){
		
	}
	
	public void darBajaPersona(String dni){
		
	}
	
	public TableModel iniciarConsultarPersona(String dni){
		return pBD.getDatosPersona(dni);
	}
	
	public Boolean introducirDatosInicioSesion(String user, String pw){
		return pBD.introduceDatosInicioSesion(user,pw);		
	}

}
