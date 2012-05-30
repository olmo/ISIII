package GestionOfertas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Basedatos.GestorJDBC;

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
		else if(Pattern.matches("^\\d{2}/\\d{2}/\\d{4}$", filtro)){	// Si el filtrado es por fecha
			Pattern pattern = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
			Matcher matcher = pattern.matcher(filtro);
			
			String fecha = matcher.group();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = null;
			try {
				date = sdf.parse(fecha);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Timestamp timestamp = new Timestamp(date.getTime());
			
			rs = gestor.RealizarConsulta("SELECT id, id_empresa, titulo, descripcion, puesto, vacantes, tipo_contrato, duracion, fechafin, localidad, provincia, horario, observaciones FROM Ofertas WHERE fechafin='"+timestamp+"'");
		}
		else
			rs = gestor.RealizarConsulta("SELECT Ofertas.id, id_empresa, titulo, descripcion, puesto, vacantes, tipo_contrato, duracion, fechafin, Ofertas.localidad, Ofertas.provincia, horario, observaciones, nombre FROM Ofertas,Empresas_ofertadoras "
					+"WHERE titulo LIKE '%"+filtro+"%' OR puesto LIKE '%"+filtro+"%' OR nombre LIKE '%"+filtro+"%' OR provincia LIKE '%"+filtro+"%'");
		
		
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
