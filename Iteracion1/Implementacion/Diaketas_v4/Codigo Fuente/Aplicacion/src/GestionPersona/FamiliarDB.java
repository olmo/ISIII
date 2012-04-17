package GestionPersona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Basedatos.GestorJDBC;

public class FamiliarDB {

	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	public void introducirDatos(Familiar f){
		gestor.conectar();
		
		gestor.Modificar("INSERT INTO Familiares VALUES('"+f.getId()+"','"+f.getidBeneficiario()+"','"+f.getParentesco()+"','"+f.getOcupacion()+"')");
		gestor.desconectar();
	}
	
	public Boolean modificarDatos(Familiar f){
		gestor.conectar();
		Boolean dev=false;
		Boolean a=false;
		Boolean b=false;
		
		a= gestor.Modificar("UPDATE Personas SET dni='"+f.getDni()+"',nombre='"+f.getNombre()+"',apellido1='"+f.getApellido1()+"', apellido2='"+f.getApellido2()+"' WHERE id='"+f.getId()+"'");
		b= gestor.Modificar("UPDATE Familiares SET parentesco='"+f.getParentesco()+"', ocupacion='"+f.getOcupacion()+"' WHERE id_persona="+f.getId());
		if(a==true||b==true)
			dev=true;
		gestor.desconectar();
		return dev;
		
	}

	public Familiar getDatos(int id){
		gestor.conectar();
		ResultSet rs=null;
		rs = gestor.RealizarConsulta("select * from Personas,Familiares where (Personas.id=Familiares.id_persona AND id='"+id+"')");
		Familiar f = new Familiar();
		
		try {
			rs.next();
			f.setId((Integer)rs.getObject("id"));
			f.setDni(rs.getObject("dni").toString());
			f.setNombre(rs.getObject("nombre").toString());
			f.setApellido1(rs.getObject("apellido1").toString());
			f.setApellido2(rs.getObject("apellido2").toString());
			f.setfNacimiento(rs.getObject("fnac").toString());
			f.setTelefono((Integer)rs.getObject("telefono"));
			f.setLugarNacimiento(rs.getObject("lugarnac").toString());
			f.setDomicilio(rs.getObject("domicilio").toString());
			f.setCp((Integer)rs.getObject("cp"));
			f.setEstado((Boolean)rs.getObject("estado"));
			f.setfBaja(rs.getObject("fbaja").toString());
			f.setemail(rs.getObject("email").toString());
			f.setParentesco(rs.getObject("parentesco").toString());
			f.setOcupacion(rs.getObject("ocupacion").toString());
			f.setidBeneficiario((Integer)rs.getObject("id_beneficiario"));
	} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error obtener los datos de persona en FamiliarDB\n"+e.getMessage());
		}
		
	
		gestor.desconectar();
		return f;

	}

	

	public Boolean borrarDatos(int id){
		try{
			gestor.conectar();
			gestor.Modificar("DELETE FROM Familiares WHERE id_persona='"+id+"'");
			gestor.Modificar("DELETE FROM Personas WHERE id='"+id+"'");
			gestor.desconectar();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al borrar los datos en FamiliarDB\n"+e.getMessage());
			return false;
		}
		return true;
	}
	
	
	

	public ArrayList<Familiar> listarFamiliares(Integer idpersona){
		gestor.conectar();
		ResultSet rs=null;
		
		

	
				rs = gestor.RealizarConsulta("select * from Personas,Familiares where Familiares.id_beneficiario='"+idpersona+"' AND Personas.id=Familiares.id_persona");
			 
		
		ArrayList<Familiar> lista_persona = new ArrayList<Familiar>();
		int i=0;
		

		try {
			while(rs.next()){
				lista_persona.add(new Familiar());
				lista_persona.get(i).setId((Integer)rs.getObject("id"));
				lista_persona.get(i).setDni(rs.getObject("dni").toString());
				lista_persona.get(i).setNombre((String)rs.getObject("nombre"));
				lista_persona.get(i).setApellido1(rs.getObject("apellido1").toString());
				lista_persona.get(i).setApellido2(rs.getObject("apellido2").toString());
				lista_persona.get(i).setfNacimiento(rs.getObject("fnac").toString());
				lista_persona.get(i).setTelefono((Integer)rs.getObject("telefono"));
				lista_persona.get(i).setLugarNacimiento(rs.getObject("lugarnac").toString());
				lista_persona.get(i).setDomicilio(rs.getObject("domicilio").toString());
				lista_persona.get(i).setCp((Integer)rs.getObject("cp"));
				lista_persona.get(i).setEstado((Boolean)rs.getObject("estado"));
				lista_persona.get(i).setfBaja(rs.getObject("fbaja").toString());
				lista_persona.get(i).setemail(rs.getObject("email").toString());
				lista_persona.get(i).setidBeneficiario((Integer)rs.getObject("id_beneficiario"));
				lista_persona.get(i).setParentesco(rs.getObject("parentesco").toString());
				lista_persona.get(i).setOcupacion(rs.getObject("ocupacion").toString());
					i++;
			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Error rellenar datos de persona en FamiliarDB\n"+e.getMessage());
		}
			i++;
		
		gestor.desconectar();
		return lista_persona;
	}

	
	
	
	
	
}
