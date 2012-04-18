/**
 * 
 */
package GestionPersona;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
		Boolean a=false;
		a= gestor.Modificar("UPDATE Personas SET dni='"+t.getDni()+"',nombre='"+t.getNombre()+"',apellido1='"+t.getApellido1()+"', apellido2='"+t.getApellido2()+"',fnac='"+t.getfNacimiento()+"', telefono="+t.getTelefono()+" ,lugarnac='"+t.getLugarNacimiento()+"',domicilio='"+t.getDomicilio()+"', cp="+t.getCp()+",email='"+t.getemail()+"' WHERE id="+t.getId());
		
		gestor.desconectar();
		return a;
		
	}

	public Trabajador getDatos(int id){
		gestor.conectar();
		ResultSet rs=null;
		rs = gestor.RealizarConsulta("select * from Personas,Trabajadores where (Personas.id=Trabajadores.id_persona AND id='"+id+"')");
		Trabajador p = new Trabajador();
		
		try {
			rs.next();
			p.setId((Integer)rs.getObject("id"));
			p.setDni(rs.getObject("dni").toString());
			p.setNombre(rs.getObject("nombre").toString());
			p.setApellido1(rs.getObject("apellido1").toString());
			p.setApellido2(rs.getObject("apellido2").toString());
				p.setfNacimiento(rs.getObject("fnac").toString());
				p.setTelefono((Integer)rs.getObject("telefono"));
			p.setLugarNacimiento(rs.getObject("lugarnac").toString());
			p.setDomicilio(rs.getObject("domicilio").toString());
				p.setCp((Integer)rs.getObject("cp"));
			p.setEstado((Boolean)rs.getObject("estado"));
				p.setfBaja(rs.getObject("fbaja").toString());
			p.setemail(rs.getObject("email").toString());
			p.setUsuario((String)rs.getObject("usuario"));
			p.setContrasena(rs.getObject("contrasena").toString());
	} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error obtener los datos de persona en TrabajadorDB:\n"+e.getMessage());
		}
		
	
		gestor.desconectar();
		return p;

	}

	public Boolean introduceDatosInicioSesion(String user, String pw){	
		gestor.conectar();
		ResultSet rs=null;
		rs=gestor.RealizarConsulta("select usuario,contrasena from Trabajadores where usuario='"+user+"' AND contrasena='"+pw+"'");
		Boolean aux=false;
		try {
			if(rs.next())
				aux=true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al comprobar usuario y contraseña:\n"+e.getMessage());
		}
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
			JOptionPane.showMessageDialog(null, "Error al borrar los datos:\n"+e.getMessage());
			return false;
		}
		return true;
	}
	
}
