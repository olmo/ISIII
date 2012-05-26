package GestionSolicitante;

import GestionPersona.Persona;

public class Solicitante extends Persona {
	public static enum tipo_permiso {
		Ninguno, B, AM, A, A1, A2, BE, BTP, C, CE, C1, C1E, D, DE, D1, D1E;
	}

	public static enum tipo_disp {
		manana, tarde, jornadaPartida
	}

	public String tipoPermisoToString() {
		switch (per_conducir) {
			case Ninguno:
				return "Ninguno";
			case B:
				return "B";
			case AM:
				return "AM";
			case A:
				return "A";
			case A1:
				return "A1";
			case A2:
				return "A2";
			case BE:
				return "B+E";
			case BTP:
				return "BTP";
			case C:
				return "C";
			case CE:
				return "C+E";
			case C1:
				return "C1";
			case C1E:
				return "C1+E";
			case D:
				return "D";
			case DE:
				return "D+E";
			case D1:
				return "D1";
			case D1E:
				return "D1+E";
		}
		return "";
	}
	
	public String dispToString() {
		switch (disponibilidad) {
			case manana:
				return "Mañana";
			case tarde:
				return "Tarde";
			case jornadaPartida:
				return "Jornada Partida";
		}
		return "";
	}

	private String estudios;
	private String experiencia;
	private String curriculum;
	private tipo_permiso per_conducir;
	private boolean vehiculo;
	private tipo_disp disponibilidad;
	private int incorpora;

	public String getEstudios() {
		return estudios;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public tipo_permiso getPer_conducir() {
		return per_conducir;
	}

	public boolean getVehiculo() {
		return vehiculo;
	}

	public tipo_disp getDisponibilidad() {
		return disponibilidad;
	}

	public int getIncorpora() {
		return incorpora;
	}

	public boolean setDatos(String dni, String nombre, String apellido1,
			String apellido2, String fNacimiento, int telefono,
			String lugarNacimiento, String domicilio, int cp, boolean estado,
			String email, String estudios, String experiencia,
			String curriculum, tipo_permiso per_conducir, boolean vehiculo,
			tipo_disp disponibilidad, int incorpora) {

		setDni(dni);
		setNombre(nombre);
		setApellido1(apellido1);
		setApellido2(apellido2);
		setfNacimiento(fNacimiento);
		setTelefono(telefono);
		setLugarNacimiento(lugarNacimiento);
		setDomicilio(domicilio);
		setCp(cp);
		setEstado(estado);
		setemail(email);

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
