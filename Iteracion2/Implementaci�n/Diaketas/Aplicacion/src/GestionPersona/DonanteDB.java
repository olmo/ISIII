package GestionPersona;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Basedatos.GestorJDBC;

public class DonanteDB {
	
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	public ArrayList<Donante> getDonantes(String filtro){
		
		ArrayList<Donante> lista = new ArrayList<Donante>();
		
		try{
			gestor.conectar();
			ResultSet rsE, rsS, rsC;
			if(Pattern.matches("^\\d{0,8}", filtro)){		//Se trata de un DNI, se filtra por DNI
				rsS = gestor.RealizarConsulta("SELECT * from Personas, Socios WHERE Personas.id = Socios.id AND" +
						"Personas.dni LIKE '"+filtro+"%'");
				
				rsE = gestor.RealizarConsulta("SELECT * from Personas, Empresas WHERE Personas.id = Empresas.id AND" +
						"Personas.dni LIKE '"+filtro+"%'");
				
				rsC = gestor.RealizarConsulta("SELECT * from Personas, Colaboradores WHERE Personas.id = Colaboradores.id AND" +
						"Personas.dni LIKE '"+filtro+"%'");
				
			}else{
				rsS = gestor.RealizarConsulta("SELECT * from Personas, Socios WHERE Personas.id = Socios.id AND"+
						"(Personas.nombre LIKE '"+filtro+"%' OR apellido1 LIKE '"+filtro+"%' OR apellido2 LIKE '"+filtro+"%')");
				
				rsE = gestor.RealizarConsulta("SELECT * from Personas, Empresas WHERE Personas.id = Empresas.id AND"+
						"(Personas.nombre LIKE '"+filtro+"%' OR apellido1 LIKE '"+filtro+"%' OR apellido2 LIKE '"+filtro+"%')");
				
				rsC = gestor.RealizarConsulta("SELECT * from Personas, Colaboradores WHERE Personas.id = Colaboradores.id AND"+
						"(Personas.nombre LIKE '"+filtro+"%' OR apellido1 LIKE '"+filtro+"%' OR apellido2 LIKE '"+filtro+"%')");
			}
				
				while (rsS.next()){
					
					Socio p = new Socio();
					
					p.setId((Integer)rsS.getObject("id"));
					p.setDni(rsS.getObject("dni").toString());
					p.setNombre(rsS.getObject("nombre").toString());
					p.setApellido1(rsS.getObject("apellido1").toString());
					p.setApellido2(rsS.getObject("apellido2").toString());
						p.setfNacimiento(rsS.getObject("fnac").toString());
						p.setTelefono((Integer)rsS.getObject("telefono"));
					p.setLugarNacimiento(rsS.getObject("lugarnac").toString());
					p.setDomicilio(rsS.getObject("domicilio").toString());
						p.setCp((Integer)rsS.getObject("cp"));
					p.setEstado((Boolean)rsS.getObject("estado"));
						p.setfBaja(rsS.getObject("fbaja").toString());
					p.setemail(rsS.getObject("email").toString());
					
					p.setPeriocidad((Integer)rsS.getObject("periodicidad"));
					p.setUsuario(rsS.getObject("usuario").toString());
					lista.add(p);
				}
				
				while (rsE.next()){
					
					Empresa p = new Empresa();
					
					p.setId((Integer)rsE.getObject("id"));
					p.setDni(rsE.getObject("dni").toString());
					p.setNombre(rsE.getObject("nombre").toString());
					p.setApellido1(rsE.getObject("apellido1").toString());
					p.setApellido2(rsE.getObject("apellido2").toString());
						p.setfNacimiento(rsE.getObject("fnac").toString());
						p.setTelefono((Integer)rsE.getObject("telefono"));
					p.setLugarNacimiento(rsE.getObject("lugarnac").toString());
					p.setDomicilio(rsE.getObject("domicilio").toString());
						p.setCp((Integer)rsE.getObject("cp"));
					p.setEstado((Boolean)rsE.getObject("estado"));
						p.setfBaja(rsE.getObject("fbaja").toString());
					p.setemail(rsE.getObject("email").toString());
					
					p.setPeriocidad((Integer)rsE.getObject("periodicidad"));
					p.setCif((Integer)rsE.getObject("cif"));
					p.setDireccionEmpresa(rsE.getObject("direccionempresa").toString());
					p.setemailEmpresa(rsE.getObject("emailempresa").toString());
					p.setNombreEmpresa(rsE.getObject("nombreempresa").toString());
					p.setTelefonoEmpresa((Integer)rsE.getObject("telefonoempresa"));
					lista.add(p);
				}

			while (rsC.next()){
				
				Colaborador p = new Colaborador();
				
				p.setId((Integer)rsC.getObject("id"));
				p.setDni(rsC.getObject("dni").toString());
				p.setNombre(rsC.getObject("nombre").toString());
				p.setApellido1(rsC.getObject("apellido1").toString());
				p.setApellido2(rsC.getObject("apellido2").toString());
					p.setfNacimiento(rsC.getObject("fnac").toString());
					p.setTelefono((Integer)rsC.getObject("telefono"));
				p.setLugarNacimiento(rsC.getObject("lugarnac").toString());
				p.setDomicilio(rsC.getObject("domicilio").toString());
					p.setCp((Integer)rsC.getObject("cp"));
				p.setEstado((Boolean)rsC.getObject("estado"));
					p.setfBaja(rsC.getObject("fbaja").toString());
				p.setemail(rsC.getObject("email").toString());
				
				p.setPeriocidad((Integer)rsC.getObject("periodicidad"));
				lista.add(p);
			}
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al listar los beneficiarios BeneficiarioDB: "+e.getMessage());
			return null;
		}
		return lista;
	}

}
