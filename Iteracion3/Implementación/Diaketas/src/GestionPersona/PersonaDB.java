/**
 * 
 */
package GestionPersona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import Basedatos.GestorJDBC;

/**
 * @author
 * 
 */
public class PersonaDB {

	private static GestorJDBC gestor = GestorJDBC.getInstance();

	public Boolean consultarPersona(String dni) {
		gestor.conectar();
		ResultSet rs = gestor
				.RealizarConsulta("select * from Personas where dni='" + dni
						+ "'");

		try {
			if (rs.first()) {
				gestor.desconectar();
				return true;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar persona\n"
					+ e.getMessage());

		}

		gestor.desconectar();
		return false;

	}

	public Boolean darBajaPersona(Integer id) {
		GregorianCalendar fecha = new GregorianCalendar();
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int mes = fecha.get(Calendar.MONTH) + 1;
		int ano = fecha.get(Calendar.YEAR);

		String f = new String(ano + "-" + mes + "-" + dia);
		gestor.conectar();
		boolean valido = gestor
				.Modificar("UPDATE Personas SET estado='0',fbaja='" + f
						+ "' WHERE id='" + id + "'");
		gestor.desconectar();
		return valido;
	}
	
	public void cancelarBajaPersona(Integer id){
		gestor.conectar();
		boolean valido = gestor.Modificar("DELETE FROM Solicitudes_bajas WHERE id_socio='" + id + "'");
		gestor.desconectar();
	}

	public int introducirDatos(Persona p) {
		gestor.conectar();
		boolean valido = gestor
				.Modificar("INSERT INTO Personas (dni,nombre, apellido1, apellido2,fnac, telefono,lugarnac,domicilio,cp,email,fbaja) VALUES ('"
						+ p.getDni()
						+ "','"
						+ p.getNombre()
						+ "','"
						+ p.getApellido1()
						+ "','"
						+ p.getApellido2()
						+ "','"
						+ p.getfNacimiento()
						+ "','"
						+ p.getTelefono()
						+ "','"
						+ p.getLugarNacimiento()
						+ "','"
						+ p.getDomicilio()
						+ "','"
						+ p.getCp()
						+ "','"
						+ p.getemail()
						+ "','1900-01-01')");

		int id = -1;
		if (valido) {
			ResultSet rs = gestor
					.RealizarConsulta("select id from Personas where dni='"
							+ p.getDni() + "'");
			try {
				rs.next();
				id = (Integer) rs.getObject("id");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(
						null,
						"Error obtener el id de la persona insertada\n"
								+ e.getMessage());
			}
		}
		gestor.desconectar();
		return id;
	}

	static public Persona getDatos(int id) {
		gestor.conectar();
		ResultSet rs = gestor
				.RealizarConsulta("select * from Personas where id='" + id
						+ "'");
		Persona p = new Persona();

		try {
			rs.next();
			p.setId((Integer) rs.getObject("id"));

			p.setDni(rs.getObject("dni").toString());
			p.setNombre(rs.getObject("nombre").toString());
			p.setApellido1(rs.getObject("apellido1").toString());
			p.setApellido2(rs.getObject("apellido2").toString());
			p.setfNacimiento(rs.getObject("fnac").toString());
			p.setTelefono((Integer) rs.getObject("telefono"));
			p.setLugarNacimiento(rs.getObject("lugarnac").toString());
			p.setDomicilio(rs.getObject("domicilio").toString());
			p.setCp((Integer) rs.getObject("cp"));
			p.setEstado((Boolean) rs.getObject("estado"));
			p.setfBaja(rs.getObject("fbaja").toString());
			p.setemail(rs.getObject("email").toString());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Error obtener la persona en PersonaDB\n" + e.getMessage());
		}
		gestor.desconectar();
		return p;
	}

	static public Persona getDatos(String dni) {
		gestor.conectar();
		ResultSet rs = gestor
				.RealizarConsulta("select * from Personas where dni='" + dni
						+ "'");
		Persona p = new Persona();

		try {
			rs.next();
			p.setId((Integer) rs.getObject("id"));

			p.setDni(rs.getObject("dni").toString());
			p.setNombre(rs.getObject("nombre").toString());
			p.setApellido1(rs.getObject("apellido1").toString());
			p.setApellido2(rs.getObject("apellido2").toString());
			p.setfNacimiento(rs.getObject("fnac").toString());
			p.setTelefono((Integer) rs.getObject("telefono"));
			p.setLugarNacimiento(rs.getObject("lugarnac").toString());
			p.setDomicilio(rs.getObject("domicilio").toString());
			p.setCp((Integer) rs.getObject("cp"));
			p.setEstado((Boolean) rs.getObject("estado"));
			if( rs.getObject("fbaja") == null)
				p.setfBaja("Null");
			else
				p.setfBaja(rs.getObject("fbaja").toString());
			p.setemail(rs.getObject("email").toString());
		} catch (SQLException e) {
			p = null;
		}
		gestor.desconectar();
		return p;
	}

	public ArrayList<Persona> buscaPersonas(String persona, String Filtro) {
		gestor.conectar();
		ResultSet rs = null;

		if (Filtro == null)
			rs = gestor
					.RealizarConsulta("select * from Personas where nombre LIKE ('"
							+ persona
							+ "%') OR apellido1 LIKE ('"
							+ persona
							+ "%') OR dni LIKE ('%" + persona + "%')");
		else {
			if (Filtro.equals("trabajador"))
				rs = gestor
						.RealizarConsulta("select * from Personas where ((nombre LIKE ('"
								+ persona
								+ "%') OR apellido1 LIKE ('"
								+ persona
								+ "%') OR dni LIKE ('%"
								+ persona
								+ "%')) AND id IN (select id_persona from Trabajadores))");
			else if (Filtro.equals("beneficiario"))
				rs = gestor
						.RealizarConsulta("select * from Personas where ((nombre LIKE ('"
								+ persona
								+ "%') OR apellido1 LIKE ('"
								+ persona
								+ "%') OR dni LIKE ('%"
								+ persona
								+ "%')) AND id IN (select id_persona from Beneficiarios))");
			else if (Filtro.equals("donante-Socio"))
				rs = gestor
						.RealizarConsulta("select * from Personas where ((nombre LIKE ('"
								+ persona
								+ "%') OR apellido1 LIKE ('"
								+ persona
								+ "%') OR dni LIKE ('%"
								+ persona
								+ "%')) AND id IN (select id_persona from Donantes) AND id IN (select id_persona from Socios))");
			else if (Filtro.equals("donante-Empresa"))
				rs = gestor
						.RealizarConsulta("select * from Personas where ((nombre LIKE ('"
								+ persona
								+ "%') OR apellido1 LIKE ('"
								+ persona
								+ "%') OR dni LIKE ('%"
								+ persona
								+ "%')) AND id IN (select id_persona from Donantes) AND id IN (select id_persona from Empresas))");
			else if (Filtro.equals("donante-Colaborador"))
				rs = gestor
						.RealizarConsulta("select * from Personas where ((nombre LIKE ('"
								+ persona
								+ "%') OR apellido1 LIKE ('"
								+ persona
								+ "%') OR dni LIKE ('%"
								+ persona
								+ "%')) AND id IN (select id_persona from Donantes) AND id IN (select id_persona from Colaboradores))");

		}
		ArrayList<Persona> lista_persona = new ArrayList<Persona>();
		int i = 0;

		try {
			while (rs.next()) {
				lista_persona.add(new Persona());
				lista_persona.get(i).setId((Integer) rs.getObject("id"));
				lista_persona.get(i).setDni(rs.getObject("dni").toString());
				lista_persona.get(i).setNombre((String) rs.getObject("nombre"));
				lista_persona.get(i).setApellido1(
						rs.getObject("apellido1").toString());
				lista_persona.get(i).setApellido2(
						rs.getObject("apellido2").toString());
				lista_persona.get(i).setfNacimiento(
						rs.getObject("fnac").toString());
				lista_persona.get(i).setTelefono(
						(Integer) rs.getObject("telefono"));
				lista_persona.get(i).setLugarNacimiento(
						rs.getObject("lugarnac").toString());
				lista_persona.get(i).setDomicilio(
						rs.getObject("domicilio").toString());
				lista_persona.get(i).setCp((Integer) rs.getObject("cp"));
				lista_persona.get(i)
						.setEstado((Boolean) rs.getObject("estado"));
				lista_persona.get(i).setfBaja(rs.getObject("fbaja").toString());
				lista_persona.get(i).setemail(rs.getObject("email").toString());
				i++;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"Error rellenar datos de persona en PersonaDB\n"
							+ e.getMessage());
		}
		i++;

		gestor.desconectar();
		return lista_persona;
	}

	public boolean darAltaPersona(Integer id) {
		gestor.conectar();
		boolean valido = gestor
				.Modificar("UPDATE Personas SET estado='1', fbaja='1900-01-01' WHERE id='"
						+ id + "'");
		gestor.desconectar();
		return valido;

	}

}
