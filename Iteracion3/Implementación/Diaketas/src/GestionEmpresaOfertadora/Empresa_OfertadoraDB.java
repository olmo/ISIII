package GestionEmpresaOfertadora;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Basedatos.GestorJDBC;

public class Empresa_OfertadoraDB {
	private GestorJDBC gestor = GestorJDBC.getInstance();
	
	public boolean AnadirEmpresaOfertadora(Empresa_Ofertadora empresa){
		int id = -1;
		
		gestor.conectar();
		id = gestor.Insertar("INSERT INTO Empresas_ofertadoras (nombre, direccion, email, telefono, localidad, sector) "
						+ "VALUES('"+empresa.getNombre()+"','"+empresa.getDireccion()+"','"+empresa.getEmail()+ "','"+empresa.getTelefono()
						+ "','"+empresa.getLocalidad()+ "','"+empresa.getSector()+"')");

		gestor.desconectar();
		
		if (id > -1) {
			empresa.setId(id);
			return true;
		}
		else
			return false;
	}
	
	public boolean BorrarEmpresaOfertadora(Empresa_Ofertadora o){
		boolean exito = false;

		gestor.conectar();
		exito = gestor.Modificar("DELETE FROM Empresas_ofertadoras WHERE id='"+o.getId()+"'");
		gestor.desconectar();

		return exito;
	}
	
	public boolean ModificarEmpresaOfertadora(Empresa_Ofertadora o){
		boolean exito = false;
		gestor.conectar();

		exito = gestor.Modificar("UPDATE Empresas_ofertadoras SET "
				+"nombre='"+ o.getNombre()+"'"
				+ ",direccion='" + o.getDireccion()+"'"
				+ ",email='" + o.getEmail()+"'"
				+ ",telefono="+ o.getTelefono()
				+ ",localidad='" + o.getLocalidad()+"'"
				+ ",sector='" + o.getSector()+"'"
				+ " WHERE id=" + o.getId());
		
		return exito;
	}
	
	public Empresa_Ofertadora getEmpresaOfertadora(int id_empresaofertadora){
		gestor.conectar();
		ResultSet rs = gestor.RealizarConsulta("SELECT id, nombre, direccion, email, telefono, localidad, sector FROM Empresas_ofertadoras WHERE id="+id_empresaofertadora);
		
		Empresa_Ofertadora empresa = new Empresa_Ofertadora();
		try {
			empresa.setId(rs.getInt(1));
			empresa.setNombre(rs.getString(2));
			empresa.setDireccion(rs.getString(3));
			empresa.setEmail(rs.getString(4));
			empresa.setTelefono(rs.getInt(5));
			empresa.setLocalidad(rs.getString(6));
			empresa.setSector(rs.getString(7));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error obtener los datos de Empresa_Ofertadora\n"+e.getMessage());
		}
		
		gestor.desconectar();
		
		return new Empresa_Ofertadora();
	}
	
	public ArrayList<Empresa_Ofertadora> getListEmpresaOfertadora(String filtro){
		ArrayList<Empresa_Ofertadora> lista = new ArrayList<Empresa_Ofertadora>();
		
		gestor.conectar();
		ResultSet rs = gestor.RealizarConsulta("SELECT id, nombre, direccion, email, telefono, localidad, sector FROM Empresas_ofertadoras");
		
		try {
			while(rs.next()){
				Empresa_Ofertadora empresa = new Empresa_Ofertadora();
				empresa.setId(rs.getInt(1));
				empresa.setNombre(rs.getString(2));
				empresa.setDireccion(rs.getString(3));
				empresa.setEmail(rs.getString(4));
				empresa.setTelefono(rs.getInt(5));
				empresa.setLocalidad(rs.getString(6));
				empresa.setSector(rs.getString(7));
				lista.add(empresa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		gestor.desconectar();
		
		return lista;
	}
	
}
