/**
 * 
 */
package GestionPersona;

import java.util.ArrayList;


import javax.swing.table.TableModel;



import Basedatos.GestorJDBC;

/**
 * @author 
 *
 */
public class PersonaDB {
	
	private GestorJDBC gestor=GestorJDBC.getInstance();

	
	
	public Boolean consultarPersona(String dni){
		gestor.conectar();
		TableModel tb=gestor.RealizarConsulta("select * from Personas where dni='"+dni+"'");
		gestor.desconectar();
		if(tb.getRowCount()>0)
			return true;
		else 
			return false;	
	}
	
	public Boolean darBajaPersona(Integer id){
		gestor.conectar();
		boolean valido=gestor.Modificar("UPDATE Personas SET estado='0' WHERE id='"+id+"'");
		gestor.desconectar();
		return valido;
	}
	
	public int introducirDatos(Persona p){
		gestor.conectar();
		boolean valido=gestor.Modificar("INSERT INTO Personas (dni,nombre, apellido1, apellido2,fnac, telefono,lugarnac,domicilio,cp,email) VALUES ('"+p.getDni()+"','"+p.getNombre()+"','"+p.getApellido1()+"','"+p.getApellido2()+"','"+p.getfNacimiento()+"','"+p.getTelefono()+"','"+p.getLugarNacimiento()+"','"+p.getDomicilio()+"','"+p.getCp()+"','"+p.getemail()+"')");


		if(valido){
			TableModel tb = gestor.RealizarConsulta("select id from Personas where dni='"+p.getDni()+"'");
			gestor.desconectar();
			return (Integer)tb.getValueAt(0, 0);
		}
		gestor.desconectar();
		return -1;
	}
	
	public Boolean modificarDatosPersona(int id, String dni, String nombre, String apellido1,String apellido2, String fNacimiento, String telefono, String lugarNacimiento,String domicilio, String CP, String email){
		gestor.conectar();
		gestor.desconectar();
		return null;
	}
	
	public Persona getDatos(int id){
		gestor.conectar();
		TableModel tb = gestor.RealizarConsulta("select * from Personas where id='"+id+"'");
		Persona p = new Persona();
		p.setId(new Integer (tb.getValueAt(0, 0).toString()));
		p.setDni(tb.getValueAt(0, 1).toString());
		p.setNombre(tb.getValueAt(0, 2).toString());
		p.setApellido1(tb.getValueAt(0,3).toString());
		p.setApellido2(tb.getValueAt(0, 4).toString());
		p.setfNacimiento(tb.getValueAt(0, 5).toString());
		p.setTelefono(new Integer(tb.getValueAt(0, 6).toString()));
		p.setLugarNacimiento(tb.getValueAt(0, 7).toString());
		p.setDomicilio(tb.getValueAt(0, 8).toString());
		p.setCp(new Integer(tb.getValueAt(0, 9).toString()));
		p.setEstado((Boolean)tb.getValueAt(0, 10));
		p.setfBaja(tb.getValueAt(0, 11).toString());
		p.setemail(tb.getValueAt(0, 12).toString());
		
		gestor.desconectar();
		return p;
	}

	

	
	
	public ArrayList<Persona> buscaPersonas(String persona, String Filtro){
		gestor.conectar();
		TableModel tb=null;
		if(Filtro==null)
			tb = gestor.RealizarConsulta("select * from Personas where nombre LIKE ('"+persona+"%') OR apellido1 LIKE ('"+persona+"%') OR dni LIKE ('%"+persona+"%')");
		else{
			if(Filtro.equals("trabajador"))
				tb = gestor.RealizarConsulta("select * from Personas where ((nombre LIKE ('"+persona+"%') OR apellido1 LIKE ('"+persona+"%') OR dni LIKE ('%"+persona+"%')) AND id IN (select id_persona from Trabajadores))");
			else if(Filtro.equals("beneficiario"))
				tb = gestor.RealizarConsulta("select * from Personas where ((nombre LIKE ('"+persona+"%') OR apellido1 LIKE ('"+persona+"%') OR dni LIKE ('%"+persona+"%')) AND id IN (select id_persona from Beneficiarios))");
			else if(Filtro.equals("donante"))
				tb = gestor.RealizarConsulta("select * from Personas where ((nombre LIKE ('"+persona+"%') OR apellido1 LIKE ('"+persona+"%') OR dni LIKE ('%"+persona+"%')) AND id IN (select id_persona from Donantes))");
			 
		}
		ArrayList<Persona> lista_persona = new ArrayList<Persona>();
		int i=0;
		while(i<tb.getRowCount()){
			lista_persona.add(new Persona());
			lista_persona.get(i).setId((Integer)tb.getValueAt(i, 0));
			lista_persona.get(i).setDni((String)tb.getValueAt(i, 1));
			lista_persona.get(i).setNombre((String)tb.getValueAt(i, 2));
			lista_persona.get(i).setApellido1((String)tb.getValueAt(i, 3));
			lista_persona.get(i).setApellido2((String)tb.getValueAt(i, 4));
			lista_persona.get(i).setfNacimiento(tb.getValueAt(i, 5).toString());
			lista_persona.get(i).setTelefono((Integer)tb.getValueAt(i, 6));
			lista_persona.get(i).setLugarNacimiento((String)tb.getValueAt(i, 7));
			lista_persona.get(i).setDomicilio((String)tb.getValueAt(i, 8));
			lista_persona.get(i).setCp((Integer)tb.getValueAt(i, 9));
			lista_persona.get(i).setEstado((Boolean)tb.getValueAt(i, 10));
			lista_persona.get(i).setfBaja((String)tb.getValueAt(i, 11));
			i++;
		}
		gestor.desconectar();
		return lista_persona;
	}


}
