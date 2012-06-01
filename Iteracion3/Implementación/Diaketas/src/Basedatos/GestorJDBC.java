/**
 * 
 */

/**
 * @author 
 *
 */

package Basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

final public class GestorJDBC {

	private static GestorJDBC instance = null;

	private Connection conexion;
	private ResultSet rs;
	private PreparedStatement st;

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new GestorJDBC();
		}
	}

	public static GestorJDBC getInstance() {
		if (instance == null)
			createInstance();

		return instance;

	}

	// El método "clone" es sobreescrito por el siguiente que arroja una
	// excepción:
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public boolean conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conexion = DriverManager.getConnection("jdbc:mysql://1984.dyndns.org:3306/isiii", "isiii","qwerty");

			// conexion = DriverManager.getConnection("jdbc:mysql://"+direccionDB+"/"+DB, usuario, contrasena);
			
		
			//Servidor local Lin
			//conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/isiii", "root", "mysqlstart");
			
			
			//Servidor Olmo
			//conexion = DriverManager.getConnection("jdbc:mysql://1984.dyndns.org:3306/isiii", "isiii","qwerty");

			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					null,
					"Error al conectar con la base de datos:\n"
							+ e.getMessage());
			return false;
		}
	}

	public boolean desconectar() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					"Error al desconectar de la BD:\n" + ex.getMessage());
			return false;
		}
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					"Error al desconectar de la BD:\n" + ex.getMessage());
			return false;
		}
		try {
			if (conexion != null) {
				conexion.close();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					"Error al desconectar de la BD:\n" + ex.getMessage());
			return false;
		}
		return true;
	}

	public boolean Estado() {
		try {
			return this.conexion.isValid(3);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					"Error al acceder a BD:\n" + ex.getMessage());
			return false;
		}
	}

	public ResultSet RealizarConsulta(String SQL) {

		try {
			st = conexion.prepareStatement(SQL);
			return st.executeQuery(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al hacer la consulta:\n"
					+ e.getMessage());

		}
		return null;

	}

	public boolean Modificar(String SQL) {

		// Preparamos la consulta

		int r = 0;
		try {
			st = conexion.prepareStatement(SQL);
			r = st.executeUpdate(SQL); // Modifico

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(
					null,
					"Error al escribir en la base de datos:\n"
							+ ex.getMessage());
			ex.printStackTrace();
		}

		if (r > 0)
			return true;
		else
			return false;
	}

	public int Insertar(String SQL) {

		// Preparamos la consulta
		int id = -1;

		try {
			st = conexion.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			st.executeUpdate(SQL); // inserto
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(
					null,
					"Error al escribir en la base de datos:\n"
							+ ex.getMessage());
			ex.printStackTrace();
		}

		return id;
	}

}