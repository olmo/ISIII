package GestionAyudas;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Basedatos.GestorJDBC;


public class TipoAyudaDB {
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	
	Boolean add(TipoAyuda tipoAyuda){
		gestor.conectar();
		Boolean correcto = gestor.Modificar("INSERT INTO TiposAyuda (nombre,observaciones) VALUES ('"+tipoAyuda.getNombre()+"','"+tipoAyuda.getObservaciones()+"')");
		gestor.desconectar();
		return correcto;
	}
	
	
	ArrayList<TipoAyuda> getList(){
		ArrayList<TipoAyuda> lista = new ArrayList<TipoAyuda>();
		
		try{
			ResultSet rs;
			gestor.conectar();
			rs = gestor.RealizarConsulta("SELECT * from TiposAyuda");
			gestor.desconectar();
			
			while(rs.next()){
				TipoAyuda tipo = new TipoAyuda();
				
				tipo.setNombre(rs.getObject("nombre").toString());
				tipo.setObservaciones(rs.getObject("observaciones").toString());
				lista.add(tipo);
			}
			
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al listar los tipos de ayudas TipoAyudaDB: "+e.getMessage());
			return null;
		}
		return lista;
	}
	
	
	Boolean set(TipoAyuda tipoAyuda){
		gestor.conectar();
		Boolean correcto = gestor.Modificar("UPDATE TiposAyuda SET nombre='"+tipoAyuda.getNombre()+"',observaciones='"+tipoAyuda.getObservaciones()+"' WHERE id='"+tipoAyuda.getId()+"'");
		gestor.desconectar();
		return correcto;
	}
	
	
	Boolean del(TipoAyuda tipoAyuda){
		gestor.conectar();
		Boolean correcto = gestor.Modificar("DELETE * FORM TiposAyuda WHERE id='"+tipoAyuda.getId()+"'");
		gestor.desconectar();
		return correcto;
	}
}
