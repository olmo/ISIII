package GestionSolicitante;

import java.sql.Timestamp;

public class Solicitante {
	public static enum tipo_permiso {
		Ninguno, B, AM, A , A1, A2, BE, BTP, C, CE, C1, C1E, D, DE, D1 ,D1E;
	}
	
	public static enum tipo_disp {
		manana, tarde, jornadaPartida
	}
	
	private String estudios;
	private String experiencia;
	private String curriculum;
	private tipo_permiso per_conducir;
	private boolean vehiculo;
	private tipo_disp disponibilidad;
	private int incorpora;
	
	public boolean setDatos(int dni, String nombre, String apellido1, String apellido2, Timestamp fnac, int telefono, String lugarNac, String domicilio, int cp, String estudios, String experiencia, String curriculum, int per_conducir, boolean vehiculo, String disponibilidad, int incorpora){
		
		
		
		return true;
	}
	
	
	



}
