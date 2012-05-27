package GestionSolicitante;

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
	private Integer incorpora;

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

	public Integer getIncorpora() {
		return incorpora;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public void setVehiculo(boolean vehiculo) {
		this.vehiculo = vehiculo;
	}

	public void setIncorpora(int incorpora) {
		this.incorpora = incorpora;
	}

	public void setPerConducir(tipo_permiso per_conducir) {
		this.per_conducir = per_conducir;
	}

	public void setDisponibilidad(tipo_disp disponibilidad) {
		this.disponibilidad = disponibilidad;
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

	public tipo_permiso StringToTipoPermiso(String miString) {
		switch (miString) {
		case "Ninguno":
			return tipo_permiso.Ninguno;
		case "B":
			return tipo_permiso.B;
		case "AM":
			return tipo_permiso.AM;
		case "A":
			return tipo_permiso.A;
		case "A1":
			return tipo_permiso.A1;
		case "A2":
			return tipo_permiso.A2;
		case "B+E":
			return tipo_permiso.BE;
		case "BTP":
			return tipo_permiso.BTP;
		case "C":
			return tipo_permiso.C;
		case "C+E":
			return tipo_permiso.CE;
		case "C1":
			return tipo_permiso.C1;
		case "C1+E":
			return tipo_permiso.C1E;
		case "D":
			return tipo_permiso.D;
		case "D+E":
			return tipo_permiso.DE;
		case "D1":
			return tipo_permiso.D1;
		case "D1+E":
			return tipo_permiso.D1E;
		}
		return tipo_permiso.Ninguno;
	}

	public tipo_disp StringToDisponibilidad(String miDisp) {
		switch (miDisp) {
		case "Mañana":
			return tipo_disp.manana;
		case "Tarde":
			return tipo_disp.tarde;
		case "Jornada Partida":
			return tipo_disp.jornadaPartida;
		}
		return tipo_disp.manana;
	}

}
