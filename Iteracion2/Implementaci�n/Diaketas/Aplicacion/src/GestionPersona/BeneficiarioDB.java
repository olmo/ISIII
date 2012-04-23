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
public class BeneficiarioDB {
	
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	public void introducirDatos(Beneficiario b){
		gestor.conectar();
		gestor.Modificar("INSERT INTO Beneficiarios (id_persona,localidad,ecivil,nestudios,nacionalidad,seconomica,obspersonales,obsvivienda,obsfamiliares) VALUES('"+b.getId()+"','"+b.getLocalidad()+"','"+b.geteCivil()+"','"+b.getnEstudios()+"','"+b.getNacionalidad()+"','"+b.getsEconomica()+"','"+b.getObservacionesPersonales()+"','"+b.getObservacionesVivienda()+"','"+b.getObservacionesFamiliares()+"')");
		gestor.desconectar();
	}
	
	public boolean modificarDatos(Beneficiario t){
		gestor.conectar();
		Boolean a=false;
		a= gestor.Modificar("UPDATE Personas SET dni='"+t.getDni()+"',nombre='"+t.getNombre()+"',apellido1='"+t.getApellido1()+"', apellido2='"+t.getApellido2()+"',fnac='"+t.getfNacimiento()+"', telefono="+t.getTelefono()+" ,lugarnac='"+t.getLugarNacimiento()+"',domicilio='"+t.getDomicilio()+"', cp="+t.getCp()+",email='"+t.getemail()+"' WHERE id="+t.getId());
		if(a==true)
			a= gestor.Modificar("UPDATE Beneficiarios SET localidad='"+t.getLocalidad()+"',ecivil='"+t.geteCivil()+"',nestudios='"+t.getnEstudios()+"', nacionalidad='"+t.getNacionalidad()+"',seconomica='"+t.getsEconomica()+"', obspersonales='"+t.getObservacionesPersonales()+"' ,obsfamiliares='"+t.getObservacionesFamiliares()+"',obsvivienda='"+t.getObservacionesVivienda()+"' WHERE id_persona="+t.getId());

		gestor.desconectar();
		return a;
	}
	
	public Beneficiario getDatos(Integer id){
		gestor.conectar();
		ResultSet rs=null;
		rs = gestor.RealizarConsulta("select * from Personas,Beneficiarios where (Personas.id=Beneficiarios.id_persona AND id='"+id+"')");

		Beneficiario p = new Beneficiario();
		
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
		
		p.setLocalidad(rs.getObject("localidad").toString());
		p.seteCivil(rs.getObject("ecivil").toString());
		p.setnEstudios(rs.getObject("nestudios").toString());
		p.setNacionalidad(rs.getObject("nacionalidad").toString());
		p.setsEconomica(rs.getObject("seconomica").toString());
		p.setObservacionesPersonales(rs.getObject("obspersonales").toString());
		p.setObservacionesFamiliares(rs.getObject("obsfamiliares").toString());
		p.setObservacionesVivienda(rs.getObject("obsvivienda").toString());
	} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error obtener los datos de persona en BeneficiarioDB\n"+e.getMessage());
		}
		

		

		gestor.desconectar();
		return p;
	}
	
	public boolean borrarDatos(Integer id){
		try{
			gestor.conectar();
			gestor.Modificar("DELETE FROM Beneficiarios WHERE id_persona='"+id+"'");
			gestor.Modificar("DELETE FROM Personas WHERE id='"+id+"'");
			gestor.desconectar();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al borrar los datos BeneficiarioDB\n"+e.getMessage());
			return false;
		}
		return true;
	}


	

}
