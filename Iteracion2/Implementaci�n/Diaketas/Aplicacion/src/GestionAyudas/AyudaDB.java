package GestionAyudas;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import Basedatos.GestorJDBC;
import GestionActuacion.Actuacion;
import GestionPersona.Beneficiario;


public class AyudaDB {
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	
	Boolean add(Ayuda ayuda){
		gestor.conectar();
		Boolean correcto = gestor.Modificar("INSERT INTO Ayudas (id_objetomonitorizable,id_tipoayuda,id_beneficiario,observaciones,cantidadMonetaria) VALUES ('"+ayuda.getIdObjMon()+"','"+ayuda.getIdTipoAyuda()+"','"+ayuda.getIdBeneficiario()+"','"+ayuda.getObservaciones()+"','"+ayuda.getCantidadMonetaria()+"')");
		gestor.desconectar();
		return correcto;
	}
	
	
	ArrayList<Ayuda> getList(String filtro){
		ArrayList<Ayuda> lista = new ArrayList<Ayuda>();
		
		try{
			ResultSet rs;
			gestor.conectar();
			if(Pattern.matches("^d{2}/d{2}/d{2} d{2}/d{2}/d{2}", filtro)){	// Si el filtrado es por intervalo de fechas
				// ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡ HACER LA CONSULTA POR FECHA !!!!!!!!!!!!!!!!!!!
			}else if(Pattern.matches("^\\d{0,8}", filtro)){		// Si el filtrado es por el DNI del beneficiario
				rs = gestor.RealizarConsulta("SELECT * from Personas, Beneficiarios, Ayudas" +
						"WHERE Personas.id=Beneficiarios.id_persona AND Personas.id=Ayudas.id_beneficiario AND" +
						"Personas.dni LIKE '"+filtro+"%'");
			}else{
				// CONSULTA SEGUN NOMBRE Y APELLIDOS DEL BENEFICIARIO Y POR TIPO DE AYUDAS... :S
			}
			gestor.desconectar();
			
			while(rs.next()){
				Ayuda ayuda = new Ayuda();
				
				ayuda.setIdObjMon((Integer)rs.getObject("id_objetomonitorizable"));
				ayuda.setIdTipoAyuda((Integer)rs.getObject("id_tipoayuda"));
				ayuda.setIdBeneficiario((Integer)rs.getObject("id_beneficiario"));
				ayuda.setObservaciones(rs.getObject("observaciones").toString());
				ayuda.setCantidadMonetaria((Float)rs.getObject("cantidadMonetaria"));
				lista.add(ayuda);
			}
			
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al listar las ayudas AyudaDB: "+e.getMessage());
			return null;
		}
		return lista;
	}
	
	
	ArrayList<Ayuda> getAyudasBeneficiario(Beneficiario beneficiario, String filtro){
		ArrayList<Ayuda> lista = new ArrayList<Ayuda>();
		
		try{
			ResultSet rs;
			gestor.conectar();
			if(Pattern.matches("^d{2}/d{2}/d{2} d{2}/d{2}/d{2}", filtro)){	// Si el filtrado es por intervalo de fechas
				// ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡ HACER LA CONSULTA POR FECHA !!!!!!!!!!!!!!!!!!!
			}else{	// Si el filtrado es por tipo de ayuda
				rs = gestor.RealizarConsulta("SELECT * from Ayudas, TiposAyuda WHERE Ayudas.id_beneficiario='"+beneficiario.getId()+"' AND" +
						"(Ayudas.id_tipoayuda=TiposAyuda.id AND TiposAyuda.nombre LIKE '%"+filtro+"%')");
			}
			gestor.desconectar();
			
			while(rs.next()){
				Ayuda ayuda = new Ayuda();
				
				ayuda.setIdObjMon((Integer)rs.getObject("id_objetomonitorizable"));
				ayuda.setIdTipoAyuda((Integer)rs.getObject("id_tipoayuda"));
				ayuda.setIdBeneficiario((Integer)rs.getObject("id_beneficiario"));
				ayuda.setObservaciones(rs.getObject("observaciones").toString());
				ayuda.setCantidadMonetaria((Float)rs.getObject("cantidadMonetaria"));
				lista.add(ayuda);
			}
			
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al listar las ayudas de un beneficiario AyudaDB: "+e.getMessage());
			return null;
		}
		return lista;
	}
	
	
	Boolean set(Ayuda ayuda){
		gestor.conectar();
		Boolean correcto = gestor.Modificar("UPDATE Ayudas SET id_tipoayuda='"+ayuda.getIdTipoAyuda()+"',id_beneficiario='"+ayuda.getIdBeneficiario()+"',observaciones='"+ayuda.getObservaciones()+"',cantidadMonetaria='"+ayuda.getCantidadMonetaria()+"' WHERE id='"+ayuda.getIdObjMon()+"'");
		gestor.desconectar();
		return correcto;
	}
}
