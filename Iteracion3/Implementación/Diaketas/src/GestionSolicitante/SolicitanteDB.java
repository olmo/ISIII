package GestionSolicitante;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Basedatos.GestorJDBC;
import GestionOfertas.Oferta;
import GestionOfertas.OfertaDB;

/**
 * Hay que probar: add, borrar y modificar. El resto estan sin hacer.
 * 
 * @author Lin
 * 
 */
public class SolicitanteDB {
	private GestorJDBC gestor = GestorJDBC.getInstance();

	public boolean add(Solicitante sol) {
		int insertPersonas = -1;
		int insertSolicitante = -1;
		gestor.conectar();

		insertPersonas = gestor
				.Insertar("INSERT INTO Personas (dni, nombre, apellido1, apellido2, fnac, telefono, lugarnac, domicilio, cp, estado, email) "
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
						+ "','" + "1" // (sol.getEstado() ? "1" : "0")
						+ "','" + sol.getemail() + "')");

		if (insertPersonas > -1) {
			insertSolicitante = gestor
					.Insertar("INSERT INTO Solicitantes (id, estudios, experiencia, curriculum, permiso_conducir, vehiculo_propio, disponibilidad_horaria, tiempo_incorporacion) "
							+ "VALUES('"
							+ insertPersonas
							+ "','"
							+ sol.getEstudios()
							+ "','"
							+ sol.getExperiencia()
							+ "','"
							+ sol.getCurriculum()
							+ "','"
							+ sol.tipoPermisoToString()
							+ "','"
							+ (sol.getVehiculo() ? "1" : "0")
							+ "','"
							+ sol.dispToString()
							+ "','"
							+ sol.getIncorpora()
							+ "')");
		}

		gestor.desconectar();

		if (insertPersonas > -1 && insertSolicitante > -1)
			return true;
		else
			return false;
	}

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
				+ sol.getDomicilio() + "', cp=" + sol.getCp() + ",estado="
				+ (sol.getEstado() ? "1" : "0") + ",email='" + sol.getemail()
				+ "' WHERE id =" + sol.getId());

		if (modificarPersonas) {
			modificarSolicitante = gestor
					.Modificar("UPDATE Solicitantes SET estudios='"
							+ sol.getEstudios() + "',experiencia='"
							+ sol.getExperiencia() + "',curriculum='"
							+ sol.getCurriculum() + "',permiso_conducir='"
							+ sol.tipoPermisoToString() + "',vehiculo_propio='"
							+ (sol.getVehiculo() ? "1" : "0")
							+ "',disponibilidad_horaria='" + sol.dispToString()
							+ "',tiempo_incorporacion='" + sol.getIncorpora()
							+ "' WHERE id =" + sol.getId());

		}

		gestor.desconectar();

		if (modificarPersonas && modificarSolicitante)
			return true;
		else
			return false;
	}

	public Solicitante consultarSolicitante(int id_solicitante) {
		Solicitante unSolicitante = new Solicitante();

		gestor.conectar();
		ResultSet rs = null;
		rs = gestor
				.RealizarConsulta("select * from Personas,Solicitantes where (Personas.id='"
						+ id_solicitante
						+ "' AND Solicitantes.id='"
						+ id_solicitante + "')");

		try {
			rs.next();

			unSolicitante.setId((Integer) rs.getObject("id"));
			unSolicitante.setDni(rs.getObject("dni").toString());
			unSolicitante.setNombre(rs.getObject("nombre").toString());
			unSolicitante.setApellido1(rs.getObject("apellido1").toString());
			unSolicitante.setApellido2(rs.getObject("apellido2").toString());
			unSolicitante.setfNacimiento(rs.getObject("fnac").toString());
			unSolicitante.setTelefono((Integer) rs.getObject("telefono"));
			unSolicitante.setLugarNacimiento(rs.getObject("lugarnac")
					.toString());
			unSolicitante.setDomicilio(rs.getObject("domicilio").toString());
			unSolicitante.setCp((Integer) rs.getObject("cp"));
			unSolicitante.setEstado((Boolean) rs.getObject("estado"));
			unSolicitante.setemail(rs.getObject("email").toString());
			unSolicitante.setEstudios(rs.getObject("estudios").toString());
			unSolicitante
					.setExperiencia(rs.getObject("experiencia").toString());
			unSolicitante.setCurriculum(rs.getObject("curriculum").toString());
			unSolicitante.setPerConducir(unSolicitante
					.StringToTipoPermiso((String) rs
							.getObject("permiso_conducir")));
			unSolicitante
					.setVehiculo((Boolean) rs.getObject("vehiculo_propio"));
			unSolicitante.setDisponibilidad(unSolicitante
					.StringToDisponibilidad((String) rs
							.getObject("disponibilidad_horaria")));
			unSolicitante.setIncorpora((Integer) rs
					.getObject("tiempo_incorporacion"));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"Error obtener los datos del solicitante**\n"
							+ e.getMessage());
			unSolicitante = null;
		}

		gestor.desconectar();
		return unSolicitante;
	}

	public ArrayList<Solicitante> listarSolicitantes(String filtro) {
		ArrayList<Solicitante> lista = new ArrayList<Solicitante>();
		ResultSet rs = null;
		gestor.conectar();

		if (filtro == null || filtro.equals(""))
			rs = gestor
					.RealizarConsulta("select * from Personas,Solicitantes where Personas.id = Solicitantes.id");
		else
			rs = gestor
					.RealizarConsulta("select * from Personas,Solicitantes where Personas.id = Solicitantes.id  AND ( "
							+ "nombre LIKE '%"
							+ filtro
							+ "%' OR apellido1 LIKE '%"
							+ filtro
							+ "%' OR apellido2 LIKE '%"
							+ filtro
							+ "%' OR dni LIKE '%"
							+ filtro
							+ "%' OR estudios LIKE '%"
							+ filtro
							+ "%' OR disponibilidad_horaria LIKE '%"
							+ filtro
							+ "%')");

		try {
			while (rs.next()) {
				Solicitante unSolicitante = new Solicitante();

				unSolicitante.setId((Integer) rs.getObject("id"));
				unSolicitante.setDni(rs.getObject("dni").toString());
				unSolicitante.setNombre(rs.getObject("nombre").toString());
				unSolicitante
						.setApellido1(rs.getObject("apellido1").toString());
				unSolicitante
						.setApellido2(rs.getObject("apellido2").toString());
				unSolicitante.setfNacimiento(rs.getObject("fnac").toString());
				unSolicitante.setTelefono((Integer) rs.getObject("telefono"));
				unSolicitante.setLugarNacimiento(rs.getObject("lugarnac")
						.toString());
				unSolicitante
						.setDomicilio(rs.getObject("domicilio").toString());
				unSolicitante.setCp((Integer) rs.getObject("cp"));
				unSolicitante.setEstado((Boolean) rs.getObject("estado"));
				unSolicitante.setemail(rs.getObject("email").toString());
				unSolicitante.setEstudios(rs.getObject("estudios").toString());
				unSolicitante.setExperiencia(rs.getObject("experiencia")
						.toString());
				unSolicitante.setCurriculum(rs.getObject("curriculum")
						.toString());
				unSolicitante.setPerConducir(unSolicitante
						.StringToTipoPermiso((String) rs
								.getObject("permiso_conducir")));
				unSolicitante.setVehiculo((Boolean) rs
						.getObject("vehiculo_propio"));
				unSolicitante.setDisponibilidad(unSolicitante
						.StringToDisponibilidad((String) rs
								.getObject("disponibilidad_horaria")));
				unSolicitante.setIncorpora((Integer) rs
						.getObject("tiempo_incorporacion"));

				lista.add(unSolicitante);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"Error obtener los datos DEL SOLICITANTE\n"
							+ e.getMessage());
		}

		gestor.desconectar();

		return lista;
	}

	public boolean registrarSolicitud(int id_oferta, int id_solicitante) {
		boolean exito = false;
		gestor.conectar();
		exito = gestor
				.Modificar("INSERT INTO Demandas (id_solicitante, id_oferta) VALUES('"
						+ id_solicitante + "','" + id_oferta + "')");
		gestor.desconectar();
		return exito;
	}

	public ArrayList<Oferta> listarOfertasDeSolicitante(int id_solicitante) {
		ArrayList<Oferta> lista = new ArrayList<Oferta>();
		ResultSet rs = null;

		gestor.conectar();

		rs = gestor
				.RealizarConsulta("SELECT * FROM `demandas` WHERE `id_solicitante` = "
						+ id_solicitante);

		try {
			while (rs.next()) {
				OfertaDB ofertaDB = new OfertaDB();
				lista.add(ofertaDB.getOferta((Integer) rs.getObject("id_oferta")));
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"Error obtener las ofertas del solicitante\n"
							+ e.getMessage());
		}

		gestor.desconectar();

		return lista;
	}

	public boolean borrarSolicitanteOferta(int id_oferta, int id_solicitante) {
		// ToDo
		return false;
	}
}
