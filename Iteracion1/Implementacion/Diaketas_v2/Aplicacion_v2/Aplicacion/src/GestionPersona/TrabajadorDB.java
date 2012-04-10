/**
 * 
 */
package GestionPersona;

import javax.swing.table.TableModel;

import Basedatos.GestorJDBC;





/**
 * @author 
 *
 */
public class TrabajadorDB {
	
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	public void introducirDatos(Trabajador t){
		gestor.conectar();
		
		gestor.Modificar("INSERT INTO Trabajadores (id_persona,usuario,contrasena) VALUES('"+t.getId()+"','"+t.getUsuario()+"','"+t.getContrasena()+"')");
		gestor.desconectar();
	}
	
	public Boolean modificarDatos(Trabajador t){
		gestor.conectar();
		gestor.desconectar();
		return null;
		
	}

	public Trabajador getDatos(int id){
		gestor.conectar();
		
		TableModel tb = gestor.RealizarConsulta("select * from Personas where id='"+id+"'");
		Trabajador p = new Trabajador();
		
		p.setId(new Integer(tb.getValueAt(0, 0).toString()));
		p.setDni((String)tb.getValueAt(0, 1));
		p.setNombre((String)tb.getValueAt(0, 2));
		p.setApellido1((String)tb.getValueAt(0,3));
		p.setApellido2((String)tb.getValueAt(0, 4));
		p.setfNacimiento(tb.getValueAt(0, 5).toString());
		p.setTelefono(new Integer(tb.getValueAt(0, 6).toString()));
		p.setLugarNacimiento((String)tb.getValueAt(0, 7));
		p.setDomicilio((String)tb.getValueAt(0, 8));
		p.setCp(new Integer(tb.getValueAt(0, 9).toString()));
		p.setEstado((Boolean)tb.getValueAt(0, 10));
		p.setfBaja((String)tb.getValueAt(0, 11));
		p.setemail((String)tb.getValueAt(0, 12));
		
		
		tb=gestor.RealizarConsulta("select * from Trabajadores where id_persona='"+id+"'");
		
		p.setUsuario(tb.getValueAt(0, 1).toString());
		p.setContrasena(tb.getValueAt(0, 2).toString());
		
		gestor.desconectar();
		return p;

	}

	public Boolean introduceDatosInicioSesion(String user, String pw){	
		gestor.conectar();
		TableModel tb=gestor.RealizarConsulta("select usuario,contrasena from Trabajadores where usuario='"+user+"' AND contrasena='"+pw+"'");
		Boolean aux=false;
		if(tb.getRowCount()==1)
			aux=true;
		gestor.desconectar();
		return aux;
	}

	public Boolean borrarDatos(int id){
		try{
			gestor.conectar();
			gestor.Modificar("DELETE FROM Trabajadores WHERE id_persona='"+id+"'");
			gestor.Modificar("DELETE FROM Personas WHERE id='"+id+"'");
			gestor.desconectar();
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
