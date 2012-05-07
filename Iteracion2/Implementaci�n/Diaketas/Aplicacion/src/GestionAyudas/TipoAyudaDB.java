package GestionAyudas;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Basedatos.GestorJDBC;


public class TipoAyudaDB {
	private GestorJDBC gestor=GestorJDBC.getInstance();

	
	
	public Boolean add(TipoAyuda tipoAyuda){
		gestor.conectar();
		Boolean correcto = gestor.Modificar("INSERT INTO TiposAyuda (nombre,observaciones) VALUES ('"+tipoAyuda.getNombre()+"','"+tipoAyuda.getObservaciones()+"')");
		gestor.desconectar();
		return correcto;
	}
	
	
	public ArrayList<TipoAyuda> getList(){
		ArrayList<TipoAyuda> lista = new ArrayList<TipoAyuda>();
		
		try{
			ResultSet rs;
			gestor.conectar();
			rs = gestor.RealizarConsulta("SELECT * from TiposAyuda");
			
			
			while(rs.next()){
				TipoAyuda tipo = new TipoAyuda(rs.getObject("observaciones").toString(),rs.getObject("nombre").toString(), Integer.parseInt(rs.getObject("id").toString()));
				lista.add(tipo);
			}
			gestor.desconectar();
			
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al listar los tipos de ayudas TipoAyudaDB: "+e.getMessage());
			return null;
		}
		return lista;
	}
	
	
	public Boolean set(TipoAyuda tipoAyuda){
		gestor.conectar();
		Boolean correcto = gestor.Modificar("UPDATE TiposAyuda SET nombre='"+tipoAyuda.getNombre()+"',observaciones='"+tipoAyuda.getObservaciones()+"' WHERE id='"+tipoAyuda.getId()+"'");
		gestor.desconectar();
		return correcto;
	}
	
	
	public Boolean del(TipoAyuda tipoAyuda){
		gestor.conectar();
		Boolean correcto = gestor.Modificar("DELETE FROM TiposAyuda WHERE id='"+tipoAyuda.getId()+"'");
		gestor.desconectar();
		return correcto;
	}
}
