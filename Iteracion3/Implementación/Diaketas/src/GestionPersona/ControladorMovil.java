package GestionPersona;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import GestionDonaciones.Donacion;
import GestionDonaciones.DonacionDB;
import GestionPersona.CodificacionPW;


public class ControladorMovil {
	
	private PersonaDB personaDB=new PersonaDB();
	private SocioDB socioDB = new SocioDB();
	private DonacionDB donacionDB = new DonacionDB();
	
	public int introduceDatosInicioSesion(String usuario, String password){
		CodificacionPW c=new CodificacionPW(password);
		//return socioDB.introduceDatosInicioSesionID(usuario, password);
		return socioDB.introduceDatosInicioSesionID(usuario, c.getPassword());
	}

	public Socio consultarSocio(Integer id){
		return socioDB.getDatos(id);
	}
	
	public Boolean modificarDatosSocio(int id, String dni, String nombre, String apellido1, String apellido2, String fNacimiento,int telefono, String lugarNacimiento, String domicilio, Integer cp, String email, Integer periocidad, String usuario, String contrasena){
		CodificacionPW c=new CodificacionPW(contrasena);
		Socio s=new Socio(id, dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp, email, periocidad,usuario,c.getPassword());
		return socioDB.modificarDatos(s);
	}
	
	public ArrayList<Donacion> listarDonaciones(Integer id){
		return donacionDB.getListPorSocio(id);
	}
	
	public void solicitarBaja(Integer id, int borrado) {
		// TODO Auto-generated method stub
		socioDB.solicitarBaja(id, borrado);
	}
	
	/*public Boolean modificarDatosSocio(int id, String dni, String nombre, String apellido1, String apellido2, String fNacimiento,int telefono, String lugarNacimiento, String domicilio, Integer cp, String email, Integer periocidad, String usuario){
		Socio s=new Socio(id, dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp, email, periocidad,usuario,contrasena);
		return socioDB.modificarDatos(s);
	}*/
	/*public int getIDsocio(String socio) {
		return socioDB.getID(socio);
	}*/
}
