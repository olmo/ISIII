package GestionPersona;
import GestionPersona.CodificacionPW;


public class ControladorMovil {
	
	private SocioDB socioDB = new SocioDB();
	
	public int introduceDatosInicioSesion(String usuario, String password){
		CodificacionPW c=new CodificacionPW(password);
		return socioDB.introduceDatosInicioSesionID(usuario, c.getPassword());
	}

	public Socio consultarSocio(Integer id){
		return socioDB.getDatos(id);
	}

	/*public int getIDsocio(String socio) {
		return socioDB.getID(socio);
	}*/
}
