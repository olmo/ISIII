package GestionAyudas;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Basedatos.GestorJDBC;
import GestionPersona.Beneficiario;


public class AyudaDB {
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	
	public Boolean add(Ayuda ayuda){
		ResultSet rs;
		Boolean correcto = true;
		gestor.conectar();

		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = 
		new java.text.SimpleDateFormat("yyyy-MM-dd");
		String currentTime = sdf.format(dt);
		
			boolean valido=gestor.Modificar("INSERT INTO ObjetosMonitorizables (id,fecha) VALUES (0,'"+currentTime+"')");
		
			int id=1;
			rs = gestor.RealizarConsulta("select id from ObjetosMonitorizables ORDER BY id DESC");
			
				try {
					rs.next();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					id=(Integer)rs.getObject("id");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		ayuda.setIdObjMon(id);
		
		correcto = gestor.Modificar("INSERT INTO Ayudas (id_objetomonitorizable,id_tipoayuda,id_beneficiario,observaciones, cantidadMonetaria) VALUES ('"+ayuda.getIdObjMon()+"','"+ayuda.getIdTipoAyuda()+"','"+ayuda.getIdBeneficiario()+"','"+ayuda.getObservaciones()+"','"+ayuda.getCantidadMonetaria()+"')");
		
		
			
		gestor.desconectar();
		return valido;
	}
	
	
	public ArrayList<Ayuda> getList(String filtro){
		ArrayList<Ayuda> lista = new ArrayList<Ayuda>();
		
		try{
			ResultSet rs;
			gestor.conectar();
			if(Pattern.matches("^d{2}/d{2}/d{4} d{2}/d{2}/d{4}", filtro)){	// Si el filtrado es por intervalo de fechas
				String [] fechas = filtro.split("\\ ");
				java.text.DateFormat formato = new java.text.SimpleDateFormat("dd/MM/aaaa");
				java.util.Date parsedUtilDate0 = formato.parse(fechas[0]);
				java.util.Date parsedUtilDate1 = formato.parse(fechas[1]);
				Date fechaIni = new Date(parsedUtilDate0.getTime());
				Date fechaFin = new Date(parsedUtilDate1.getTime());
				rs = gestor.RealizarConsulta("SELECT * from Ayudas,ObjetosMonitorizables " +
						"WHERE (Ayudas.id_objetomonitorizable=ObjetosMonitorizables.id) AND " +
						"(ObjetosMonitorizables.fecha>='"+fechaIni.toString()+"' AND ObjetosMonitorizables.fecha<='"+fechaFin.toString()+"')");
			}else if(Pattern.matches("^\\d{0,8}", filtro)){		// Si el filtrado es por el DNI del beneficiario
				rs = gestor.RealizarConsulta("SELECT * from Personas, Beneficiarios, Ayudas, ObjetosMonitorizables " +
						"WHERE Personas.id=Beneficiarios.id_persona AND Personas.id=Ayudas.id_beneficiario AND ObjetosMonitorizables.id = Ayudas.id_objetomonitorizable AND " +
						"Personas.dni LIKE '"+filtro+"%'");
			}else{
				// CONSULTA SEGUN NOMBRE Y APELLIDOS DEL BENEFICIARIO Y POR TIPO DE AYUDAS... :S
				rs = gestor.RealizarConsulta("SELECT * from Personas,Beneficiario,Ayudas, ObjetosMonitorizables " +
						"WHERE (Personas.id=Beneficiarios.id_persona AND Personas.id=Ayudas.id_beneficiario AND Personas.nombre LIKE '"+filtro+"%' OR Personas.apellido1 LIKE '"+filtro+"%' OR Personas.apellido2 LIKE '"+filtro+"%') OR " +
						"(Ayudas.id_tipoayuda=TiposAyuda.id AND ObjetosMonitorizables.id = Ayudas.id_objetomonitorizable AND TiposAyuda.nombre LIKE '%"+filtro+"%')");
			}
			
			
			while(rs.next()){
				Ayuda ayuda = new Ayuda();
				
				ayuda.setIdObjMon((Integer)rs.getObject("id_objetomonitorizable"));
				ayuda.setIdTipoAyuda((Integer)rs.getObject("id_tipoayuda"));
				ayuda.setIdBeneficiario((Integer)rs.getObject("id_beneficiario"));
				ayuda.setObservaciones(rs.getObject("observaciones").toString());
				ayuda.setCantidadMonetaria((Float)rs.getObject("cantidadMonetaria"));
				ayuda.setDate((Date)rs.getObject("fecha"));
				lista.add(ayuda);
			}
			gestor.desconectar();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al listar las ayudas AyudaDB: "+e.getMessage());
			return null;
		}
		return lista;
	}
	
	
	public ArrayList<Ayuda> getAyudasBeneficiario(Beneficiario beneficiario, String filtro){
		ArrayList<Ayuda> lista = new ArrayList<Ayuda>();
		
		try{
			ResultSet rs;
			gestor.conectar();
			if(Pattern.matches("^d{2}/d{2}/d{4} d{2}/d{2}/d{4}", filtro)){	// Si el filtrado es por intervalo de fechas
				String [] fechas = filtro.split("\\ ");
				java.text.DateFormat formato = new java.text.SimpleDateFormat("dd/MM/aaaa");
				java.util.Date parsedUtilDate0 = formato.parse(fechas[0]);
				java.util.Date parsedUtilDate1 = formato.parse(fechas[1]);
				Date fechaIni = new Date(parsedUtilDate0.getTime());
				Date fechaFin = new Date(parsedUtilDate1.getTime());
				rs = gestor.RealizarConsulta("SELECT * from Ayudas, ObjetosMonitorizables " +
						"WHERE (Ayudas.id_objetomonitorizable=ObjetosMonitorizables.id AND Ayudas.id_beneficiario='"+beneficiario.getId()+"') AND " +
						"(ObjetosMonitorizables.fecha>='"+fechaIni.toString()+"' AND ObjetosMonitorizables.fecha<='"+fechaFin.toString()+"')");
			}else{	// Si el filtrado es por tipo de ayuda
				rs = gestor.RealizarConsulta("SELECT * from Ayudas, TiposAyuda WHERE Ayudas.id_beneficiario='"+beneficiario.getId()+"' AND " +
						"(Ayudas.id_tipoayuda=TiposAyuda.id AND TiposAyuda.nombre LIKE '%"+filtro+"%')");
			}
			
			
			while(rs.next()){
				Ayuda ayuda = new Ayuda();
				
				ayuda.setIdObjMon((Integer)rs.getObject("id_objetomonitorizable"));
				ayuda.setIdTipoAyuda((Integer)rs.getObject("id_tipoayuda"));
				ayuda.setIdBeneficiario((Integer)rs.getObject("id_beneficiario"));
				ayuda.setObservaciones(rs.getObject("observaciones").toString());
				ayuda.setCantidadMonetaria((Float)rs.getObject("cantidadMonetaria"));
				lista.add(ayuda);
			}
			gestor.desconectar();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al listar las ayudas de un beneficiario AyudaDB: "+e.getMessage());
			return null;
		}
		return lista;
	}
	
	
	public Boolean set(Ayuda ayuda){
		gestor.conectar();
		Boolean correcto = gestor.Modificar("UPDATE Ayudas SET id_tipoayuda='"+ayuda.getIdTipoAyuda()+"',id_beneficiario='"+ayuda.getIdBeneficiario()+"',observaciones='"+ayuda.getObservaciones()+"',cantidadMonetaria='"+ayuda.getCantidadMonetaria()+"' WHERE id_objetomonitorizable='"+ayuda.getIdObjMon()+"'");
		gestor.desconectar();
		return correcto;
	}
}
