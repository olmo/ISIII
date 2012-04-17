package GestionPersona;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Basedatos.GestorJDBC;

public class EmpresaDB {

	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	public void introducirDatos(Empresa e){
		gestor.conectar();
		gestor.Modificar("INSERT INTO Donantes (id_persona, periocidad) VALUES('"+e.getId()+"','"+e.getPeriocidad()+"')");
		gestor.Modificar("INSERT INTO Empresas VALUES('"+e.getId()+"', '"+e.getCif()+"', '"+e.getNombreEmpresa()+"', '"+e.getTelefonoEmpresa()+"', '"+e.getDireccionEmpresa()+"','"+e.getemailEmpresa()+"')");
		gestor.desconectar();
		}

	public Boolean modificarDatos(Empresa emp){
		gestor.conectar();
		Boolean a=false;
		a= gestor.Modificar("UPDATE Personas SET dni='"+emp.getDni()+"',nombre='"+emp.getNombre()+"',apellido1='"+emp.getApellido1()+"', apellido2='"+emp.getApellido2()+"',fnac='"+emp.getfNacimiento()+"', telefono="+emp.getTelefono()+" ,lugarnac='"+emp.getLugarNacimiento()+"',domicilio='"+emp.getDomicilio()+"', cp="+emp.getCp()+",email='"+emp.getemail()+"' WHERE id="+emp.getId());
		if(a)
			a= gestor.Modificar("UPDATE Donantes SET periocidad='"+emp.getPeriocidad()+"' WHERE id_persona="+emp.getId());
		if(a)
			a= gestor.Modificar("UPDATE Empresas SET cif='"+emp.getCif()+"',nombreempresa='"+emp.getNombreEmpresa()+"',telefonoempresa='"+emp.getTelefonoEmpresa()+"',direccionempresa='"+emp.getDireccionEmpresa()+"',emailempresa='"+emp.getemailEmpresa()+"' WHERE id_persona="+emp.getId());
		gestor.desconectar();
		return a;
	}

	public Empresa getDatos(int id){
		gestor.conectar();
		ResultSet rs=null;
		rs = gestor.RealizarConsulta("select * from Personas,Donantes,Empresas where (Personas.id=Empresas.id_persona AND Donantes.id_persona=Empresas.id_persona AND id='"+id+"')");

		Empresa p = new Empresa();
		
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
			p.setCif((Integer)rs.getObject("cif"));
			p.setNombreEmpresa(rs.getObject("nombreempresa").toString());
			p.setDireccionEmpresa(rs.getObject("direccionempresa").toString());
			p.setTelefonoEmpresa((Integer)rs.getObject("telefonoempresa"));
			p.setemailEmpresa(rs.getObject("emailempresa").toString());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error obtener los datos de persona en EmpresaDB\n"+e.getMessage());
		}
		

		

		gestor.desconectar();
		return p;
	}

	public Boolean borrarDatos(int id){
		gestor.conectar();
		gestor.Modificar("DELETE FROM Empresas WHERE id_persona='"+id+"'");
		gestor.Modificar("DELETE FROM Donantes WHERE id_persona='"+id+"'");
		gestor.Modificar("DELETE FROM Personas WHERE id='"+id+"'");
		gestor.desconectar();
		return true;
	}
}
