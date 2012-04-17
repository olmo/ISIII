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
 *
 */
public class ColaboradorDB {
	
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	public void introducirDatos(Colaborador b){
		gestor.conectar();
		gestor.Modificar("INSERT INTO Donantes (id_persona, periocidad) VALUES('"+b.getId()+"','"+b.getPeriocidad()+"')");
		gestor.Modificar("INSERT INTO Colaboradores (id_persona) VALUES('"+b.getId()+"')");
		gestor.desconectar();
	}
	
	public boolean modificarDatos(Colaborador c){
		gestor.conectar();
		Boolean a=false;
		a= gestor.Modificar("UPDATE Personas SET dni='"+c.getDni()+"',nombre='"+c.getNombre()+"',apellido1='"+c.getApellido1()+"', apellido2='"+c.getApellido2()+"',fnac='"+c.getfNacimiento()+"', telefono="+c.getTelefono()+" ,lugarnac='"+c.getLugarNacimiento()+"',domicilio='"+c.getDomicilio()+"', cp="+c.getCp()+",email='"+c.getemail()+"' WHERE id="+c.getId());
		if(a)
			a= gestor.Modificar("UPDATE Donantes SET periocidad='"+c.getPeriocidad()+"' WHERE id_persona="+c.getId());
		gestor.desconectar();
		return a;
	}
	
	public Colaborador getDatos(Integer id){
		gestor.conectar();
		ResultSet rs=null;
		rs = gestor.RealizarConsulta("select * from Personas,Donantes,Colaboradores where (Personas.id=Colaboradores.id_persona AND Donantes.id_persona=Colaboradores.id_persona AND id='"+id+"')");
		Colaborador p = new Colaborador();
		
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
			p.setPeriocidad((Integer)rs.getObject("periocidad"));
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error obtener los datos en ColaboradoDB\n"+e.getMessage());
		}
		
		gestor.desconectar();
		return p;
	}
	
	public boolean borrarDatos(Integer id){
		gestor.conectar();
		gestor.Modificar("DELETE FROM Colaboradores WHERE id_persona='"+id+"'");
		gestor.Modificar("DELETE FROM Donantes WHERE id_persona='"+id+"'");
		gestor.Modificar("DELETE FROM Personas WHERE id='"+id+"'");
		gestor.desconectar();
		return false;
	}

}
