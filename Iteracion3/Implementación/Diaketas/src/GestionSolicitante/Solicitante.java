package GestionSolicitante;

import java.sql.Timestamp;

import GestionPersona.Donante;
import GestionPersona.Persona;

public class Solicitante extends Persona {
	public static enum tipo_permiso {
		Ninguno, B, AM, A, A1, A2, BE, BTP, C, CE, C1, C1E, D, DE, D1, D1E;
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

	public boolean setDatos(String dni, String nombre, String apellido1,
			String apellido2, String fnac, int telefono, String lugarNac,
			String domicilio, int cp, String estudios, String experiencia,
			String curriculum, tipo_permiso per_conducir, boolean vehiculo,
			tipo_disp disponibilidad, int incorpora) {

		setDni(dni);
		setNombre(nombre);
		setApellido1(apellido1);
		setApellido2(apellido2);
		setfNacimiento(fnac);
		setTelefono(telefono);
		setLugarNacimiento(lugarNac);
		setDomicilio(domicilio);
		setCp(cp);

		this.estudios = estudios;
		this.experiencia = experiencia;
		this.curriculum = curriculum;
		this.per_conducir = per_conducir;
		this.vehiculo = vehiculo;
		this.disponibilidad = disponibilidad;
		this.incorpora = incorpora;

		return true;
	}

}
