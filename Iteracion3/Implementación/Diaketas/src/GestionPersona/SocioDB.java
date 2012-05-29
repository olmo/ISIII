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
public class SocioDB {
	
	
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	public void introducirDatos(Socio s){
		gestor.conectar();
		gestor.Modificar("INSERT INTO Donantes (id_persona, periocidad) VALUES('"+s.getId()+"','"+s.getPeriocidad()+"')");
		gestor.Modificar("INSERT INTO Socios (id_persona, usuario, contrasena) VALUES('"+s.getId()+"','"+s.getUsuario()+"','"+s.getContrasena()+"')");
		gestor.desconectar();
		}
	
	public Boolean modificarDatos(Socio s){
		gestor.conectar();
		Boolean a=false;
		a= gestor.Modificar("UPDATE Personas SET dni='"+s.getDni()+"',nombre='"+s.getNombre()+"',apellido1='"+s.getApellido1()+"', apellido2='"+s.getApellido2()+"',fnac='"+s.getfNacimiento()+"', telefono="+s.getTelefono()+" ,lugarnac='"+s.getLugarNacimiento()+"',domicilio='"+s.getDomicilio()+"', cp="+s.getCp()+",email='"+s.getemail()+"' WHERE id="+s.getId());
		if(a)
			a= gestor.Modificar("UPDATE Donantes SET periocidad='"+s.getPeriocidad()+"' WHERE id_persona="+s.getId());
		if(a)
			a= gestor.Modificar("UPDATE Socios SET usuario='"+s.getUsuario()+"',contrasena='"+s.getContrasena()+"' WHERE id_persona="+s.getId());
		gestor.desconectar();
		return a;
	}
	
	public Socio getDatos(int id){
		gestor.conectar();
		ResultSet rs=null;
		rs = gestor.RealizarConsulta("select * from Personas,Donantes,Socios where (Personas.id=Socios.id_persona AND Donantes.id_persona=Socios.id_persona AND id='"+id+"')");

		//JOptionPane.showMessageDialog(null, "select * from Personas,Donantes,Socios where (Personas.id=Socios.id_persona AND Donantes.id_persona=Socios.id_persona AND id='"+id+"')");

		Socio p = new Socio();
		
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
			
			p.setPeriocidad(new Integer(rs.getObject("periocidad").toString()));
			p.setUsuario(rs.getObject("usuario").toString());
			p.setContrasena(rs.getObject("contrasena").toString());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error obtener los datos de persona en SocioDB\n"+e.getMessage());
		}
		

		

		gestor.desconectar();
		return p;
	}

	public Boolean borrarDatos(int id){
		gestor.conectar();
		gestor.Modificar("DELETE FROM Socios WHERE id_persona='"+id+"'");
		gestor.Modificar("DELETE FROM Donantes WHERE id_persona='"+id+"'");
		gestor.Modificar("DELETE FROM Personas WHERE id='"+id+"'");
		gestor.desconectar();
		return true;
	}
	
	public Boolean introduceDatosInicioSesion(String user, String pw){	
		gestor.conectar();
		ResultSet rs=null;
		rs=gestor.RealizarConsulta("select usuario,contrasena from Socios where usuario='"+user+"' AND contrasena='"+pw+"'");
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
	
	public Integer introduceDatosInicioSesionID(String user, String pw){
		Integer id=-1;
		gestor.conectar();
		ResultSet rs=null;
		rs=gestor.RealizarConsulta("select usuario,contrasena, id_persona from Socios where usuario='"+user+"' AND contrasena='"+pw+"'");
		Boolean aux=false;
		try {
			if(rs.next()){
				aux=true;
				id=(Integer)rs.getObject("id_persona");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al comprobar usuario y contraseña:\n"+e.getMessage());
		}
		gestor.desconectar();
		
		if (aux)
			return id.intValue(); 
		else
			return -1;

	}
	
}
