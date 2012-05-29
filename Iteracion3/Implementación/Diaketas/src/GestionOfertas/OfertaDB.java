package GestionOfertas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Basedatos.GestorJDBC;
import GestionEmpresaOfertadora.Empresa_Ofertadora;

public class OfertaDB {
	private GestorJDBC gestor = GestorJDBC.getInstance();
	
	public boolean Anadir(Oferta o){
		int id = -1;
		
		gestor.conectar();
		id = gestor.Insertar("INSERT INTO Ofertas (id_empresa, titulo, descripcion, puesto, vacantes, tipo_contrato, duracion, fechafin, localidad, provincia, horario, observaciones) "
						+ "VALUES('"+o.getId_empresa()+"','"+o.getTitulo()+"','"+o.getDescripcion()+ "','"+o.getPuesto()
						+ "','"+o.getVacantes()+ "','"+o.getTipo_contrato()+ "','"+o.getDuracion()+ "','"+o.getFechafin()+ "','"+o.getLocalidad()+
						 "','"+o.getProvincia()+ "','"+o.getHorario()+ "','"+o.getObservaciones()+"')");

		gestor.desconectar();
		
		if (id > -1) {
			o.setId(id);
			return true;
		}
		else
			return false;
	}
	
	public boolean ModificarOferta(Oferta o){
		boolean exito = false;
		gestor.conectar();

		exito = gestor.Modificar("UPDATE Ofertas SET "
				+"id_empresa='"+ o.getId_empresa()+"'"
				+ ",titulo='" + o.getTitulo()+"'"
				+ ",descripcion='" + o.getDescripcion()+"'"
				+ ",puesto='"+ o.getPuesto()+"'"
				+ ",vacantes='" + o.getVacantes()+"'"
				+ ",tipo_contrato='" + o.getTipo_contrato()+"'"
				+ ",duracion='" + o.getDuracion()+"'"
				+ ",fechafin='" + o.getFechafin()+"'"
				+ ",localidad='" + o.getLocalidad()+"'"
				+ ",provincia='" + o.getProvincia()+"'"
				+ ",horario='" + o.getHorario()+"'"
				+ ",observaciones='" + o.getObservaciones()+"'"
				+ " WHERE id=" + o.getId());
		
		return exito;
	}
	
	public boolean BorrarOferta(Oferta o){
		boolean exito = false;

		gestor.conectar();
		exito = gestor.Modificar("DELETE FROM Ofertas WHERE id='"+o.getId()+"'");
		gestor.desconectar();

		return exito;
	}
	
	public ArrayList<Oferta> getList(String filtro){
		ArrayList<Oferta> lista = new ArrayList<Oferta>();
		
		ResultSet rs = null;
		gestor.conectar();
		
		if(filtro==null || filtro.equals(""))
			rs = gestor.RealizarConsulta("SELECT id, id_empresa, titulo, descripcion, puesto, vacantes, tipo_contrato, duracion, fechafin, localidad, provincia, horario, observaciones FROM Ofertas");
		else
			rs = gestor.RealizarConsulta("SELECT id, id_empresa, titulo, descripcion, puesto, vacantes, tipo_contrato, duracion, fechafin, localidad, provincia, horario, observaciones FROM Ofertas");
		
		
		try {
			while(rs.next()){
				Oferta oferta = new Oferta();
				oferta.setId(rs.getInt(1));
				oferta.setId_empresa(rs.getInt(2));
				oferta.setTitulo(rs.getString(3));
				oferta.setDescripcion(rs.getString(4));
				oferta.setPuesto(rs.getString(5));
				oferta.setVacantes(rs.getInt(6));
				oferta.setTipo_contrato(rs.getString(7));
				oferta.setDuracion(rs.getInt(8));
				oferta.setFechafin(rs.getTimestamp(9));
				oferta.setLocalidad(rs.getString(10));
				oferta.setProvincia(rs.getString(11));
				oferta.setHorario(rs.getString(12));
				oferta.setObservaciones(rs.getString(13));
				lista.add(oferta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		gestor.desconectar();
		
		return lista;
	}
	
	public Oferta getOferta(int id_oferta){
		gestor.conectar();
		ResultSet rs = gestor.RealizarConsulta("SELECT id, id_empresa, titulo, descripcion, puesto, vacantes, tipo_contrato, duracion, fechafin, localidad, provincia, horario, observaciones FROM Ofertas WHERE id="+id_oferta);
		
		Oferta oferta = new Oferta();
		try {
			rs.next();
			oferta.setId(rs.getInt(1));
			oferta.setId_empresa(rs.getInt(2));
			oferta.setTitulo(rs.getString(3));
			oferta.setDescripcion(rs.getString(4));
			oferta.setPuesto(rs.getString(5));
			oferta.setVacantes(rs.getInt(6));
			oferta.setTipo_contrato(rs.getString(7));
			oferta.setDuracion(rs.getInt(8));
			oferta.setFechafin(rs.getTimestamp(9));
			oferta.setLocalidad(rs.getString(10));
			oferta.setProvincia(rs.getString(11));
			oferta.setHorario(rs.getString(12));
			oferta.setObservaciones(rs.getString(13));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		gestor.desconectar();
		
		return oferta;
	}
	
}
