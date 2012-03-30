/**
 * 
 */
package GestionPersona;

import java.sql.Date;

import javax.swing.table.TableModel;

import Basedatos.GestorJDBC;

/**
 * @author 
 *
 */
public class PersonaBD {
	GestorJDBC gestor=new GestorJDBC();

	
	public boolean conectar(){
		return gestor.conectar();
	}
	
	public boolean desconectar(){
		return gestor.desconectar();
	}
	
	public TableModel consulta(String s){
		return gestor.RealizarConsulta(s);
	}

	public boolean estado(){
		return gestor.Estado();
	}
	
	public boolean introduceDatosInicioSesion(String usuario, String password){
		TableModel tb=gestor.RealizarConsulta("select usuario,contrasena from Trabajadores where usuario='"+usuario+"' AND contrasena='"+password+"'");
		Boolean aux=false;
		if(tb.getRowCount()==1)
			aux=true;
		return aux;
		}
	
	
	public TableModel buscaPersonas(String nombre,String Filtro){
		if(Filtro==null)
			return gestor.RealizarConsulta("select dni,nombre,apellido1,apellido2,rol from Personas where nombre LIKE ('"+nombre+"%') OR apellido1 LIKE ('"+nombre+"%') OR dni LIKE ('%"+nombre+"%')");
		return gestor.RealizarConsulta("select dni,nombre,apellido1,apellido2,rol from Personas p where ((nombre LIKE ('"+nombre+"%') OR apellido1 LIKE ('"+nombre+"%') OR dni LIKE ('%"+nombre+"%')) AND rol='"+Filtro+"')");
	}
	
	public boolean existePersona (String dni){
		TableModel tb=gestor.RealizarConsulta("select * from Personas where dni='"+dni+"'");
		if(tb.getRowCount()>0)
			return true;
		else 
			return false;
	}
	
	public Persona getPersona(String dni){
		TableModel tb = gestor.RealizarConsulta("select * from Personas where dni='"+dni+"'");
		Persona p = new Persona();
		p.introducirDatos((String)tb.getValueAt(0, 0), (String)tb.getValueAt(0, 1), (String)tb.getValueAt(0, 2), (String)tb.getValueAt(0, 3), (Date)tb.getValueAt(0, 4), (Long)tb.getValueAt(0, 5), (String)tb.getValueAt(0, 6), (String)tb.getValueAt(0, 7), (Integer)tb.getValueAt(0, 8), (Boolean)tb.getValueAt(0, 9), (Date)tb.getValueAt(0, 10));
		return p;
	}

	public TableModel getDatosPersona(String dni) {
		return gestor.RealizarConsulta("select * from Personas where dni='"+dni+"'");
	}
	
	

	

}
