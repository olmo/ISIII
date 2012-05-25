package GestionSolicitante;

import java.util.ArrayList;

import Basedatos.GestorJDBC;
import GestionOfertas.Oferta;

/**
 * Hay que probar: add, borrar y modificar. El resto estan sin hacer.
 * 
 * @author Lin
 * 
 */
public class SolicitanteDB {
	private GestorJDBC gestor = GestorJDBC.getInstance();

	// ToDo: Probarla
	public boolean add(Solicitante sol) {
		boolean insertPersonas = false;
		boolean insertSolicitante = false;

		gestor.conectar();

		insertPersonas = gestor
				.Modificar("INSERT INTO Personas (dni, nombre, apellido1, apellido2, fnac, telefono, lugarnac, domicilio, cp, email, fbaja) "
						+ "VALUES('"
						+ sol.getDni()
						+ "','"
						+ sol.getNombre()
						+ "','"
						+ sol.getApellido1()
						+ "','"
						+ sol.getApellido2()
						+ "','"
						+ sol.getfNacimiento()
						+ "','"
						+ sol.getTelefono()
						+ "','"
						+ sol.getLugarNacimiento()
						+ "','"
						+ sol.getDomicilio()
						+ "','"
						+ sol.getCp()
						+ "','"
						+ sol.getEstado()
						+ "','"
						+ sol.getfBaja()
						+ "','" + sol.getemail() + "')");

		insertSolicitante = gestor
				.Modificar("INSERT INTO Solicitantes (id, estudios, experiencia, curriculum, permiso_conducir, vehiculo_propio, disponibilidad_horaria, tiempo_incorporacion) "
						+ "VALUES('"
						+ sol.getId()
						+ "','"
						+ sol.getEstudios()
						+ "','"
						+ sol.getExperiencia()
						+ sol.getCurriculum()
						+ "','"
						+ sol.getPer_conducir()
						+ "','"
						+ sol.getVehiculo()
						+ "','"
						+ sol.getDisponibilidad()
						+ "','" + sol.getIncorpora() + "')");

		gestor.desconectar();

		if (insertPersonas && insertSolicitante)
			return true;
		else
			return false;
	}

	// ToDo probarla
	public boolean borrar(Solicitante sol) {
		boolean deletePersonas = false;
		boolean deleteSolicitante = false;

		gestor.conectar();
		deleteSolicitante = gestor
				.Modificar("DELETE FROM Solicitantes WHERE id='" + sol.getId()
						+ "'");
		deletePersonas = gestor.Modificar("DELETE FROM Personas WHERE id='"
				+ sol.getId() + "'");
		gestor.desconectar();

		if (deleteSolicitante && deletePersonas)
			return true;
		else
			return false;
	}

	// ToDo probarla
	public boolean modificar(Solicitante sol) {
		boolean modificarPersonas = false;
		boolean modificarSolicitante = false;

		gestor.conectar();

		modificarPersonas = gestor.Modificar("UPDATE Personas SET dni='"
				+ sol.getDni() + "',nombre='" + sol.getNombre()
				+ "',apellido1='" + sol.getApellido1() + "', apellido2='"
				+ sol.getApellido2() + "',fnac='" + sol.getfNacimiento()
				+ "', telefono=" + sol.getTelefono() + " ,lugarnac='"
				+ sol.getLugarNacimiento() + "',domicilio='"
				+ sol.getDomicilio() + "', cp=" + sol.getCp() + ",email='"
				+ sol.getemail() + "' WHERE id=" + sol.getId());

		if (modificarPersonas)
			modificarSolicitante = gestor
					.Modificar("UPDATE Solicitantes SET estudios='"
							+ sol.getEstudios() + "',experiencia='"
							+ sol.getExperiencia() + "',curriculum='"
							+ sol.getCurriculum() + "',permiso_conducir='"
							+ sol.getPer_conducir() + "',vehiculo_propio='"
							+ sol.getVehiculo() + "',disponibilidad_horaria='"
							+ sol.getDisponibilidad()
							+ "'tiempo_incorporacion,='" + sol.getIncorpora()
							+ "' WHERE id =" + sol.getId());

		gestor.desconectar();

		if (modificarPersonas && modificarSolicitante)
			return true;
		else
			return false;
	}

	public ArrayList<Solicitante> listarSolicitantes(Solicitante sol) {
		ArrayList<Solicitante> lista = new ArrayList<Solicitante>();
		// ToDo
		return lista;
	}

	public Solicitante consultarSolicitante(int id_solicitante) {
		Solicitante unSolicitante = new Solicitante();
		// ToDo
		return unSolicitante;
	}

	public boolean registrarSolicitud(int id_oferta, int id_solicitante) {
		// ToDo
		return false;
	}

	public ArrayList<Oferta> listarOfertasDeSolicitante(int id_solicitante) {
		ArrayList<Oferta> lista = new ArrayList<Oferta>();
		// ToDo
		return lista;
	}

	public boolean borrarSolicitanteOferta(int id_oferta, int id_solicitante) {
		// ToDo
		return false;
	}
}
