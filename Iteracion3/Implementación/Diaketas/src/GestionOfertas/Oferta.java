package GestionOfertas;

import java.sql.Timestamp;

public class Oferta {
	private int id;
	private int id_empresa;
	private String titulo;
	private String descripcion;
	private String puesto;
	private int vacantes;
	private String tipo_contrato;
	private int duracion;
	private Timestamp fechafin;
	private String localidad;
	private String provincia;
	private String horario;
	private String observaciones;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getVacantes() {
		return vacantes;
	}

	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}

	public String getTipo_contrato() {
		return tipo_contrato;
	}

	public void setTipo_contrato(String tipo_contrato) {
		this.tipo_contrato = tipo_contrato;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Timestamp getFechafin() {
		return fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public boolean ModificarOferta(String titulo, String descripcion, String puesto, int vacantes, String tipo_contrato, 
			int duracion, Timestamp fechafin, String localidad, String provincia, String horario, String observaciones) {
		
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.puesto = puesto;
		this.vacantes = vacantes;
		this.tipo_contrato = tipo_contrato;
		this.duracion = duracion;
		this.fechafin = fechafin;
		this.localidad = localidad;
		this.provincia = provincia;
		this.horario = horario;
		this.observaciones = observaciones;
		
		return true;
	}
}
