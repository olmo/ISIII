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
public class BeneficiarioDB {
	
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	public void introducirDatos(Beneficiario b){
		gestor.conectar();
		gestor.Modificar("INSERT INTO Beneficiarios (id_persona,localidad,ecivil,nestudios,nacionalidad,seconomica,obspersonales,obsvivienda,obsfamiliares) VALUES('"+b.getId()+"','"+b.getLocalidad()+"','"+b.geteCivil()+"','"+b.getnEstudios()+"','"+b.getNacionalidad()+"','"+b.getsEconomica()+"','"+b.getObservacionesPersonales()+"','"+b.getObservacionesVivienda()+"','"+b.getObservacionesFamiliares()+"')");
		gestor.desconectar();
	}
	
	public boolean modificarDatos(Beneficiario b){
		
		return false;
	}
	
	public Beneficiario getDatos(Integer id){
		gestor.conectar();
		
		TableModel tb = gestor.RealizarConsulta("select * from Personas where id='"+id+"'");
		Beneficiario p = new Beneficiario();
		
		p.setId(new Integer (tb.getValueAt(0, 0).toString()));
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
		
		tb=gestor.RealizarConsulta("select * from Beneficiarios where id_persona='"+id+"'");
		
		p.setLocalidad(tb.getValueAt(0, 1).toString());
		p.seteCivil(tb.getValueAt(0, 2).toString());
		p.setnEstudios(tb.getValueAt(0, 3).toString());
		p.setNacionalidad(tb.getValueAt(0, 4).toString());
		p.setsEconomica(tb.getValueAt(0, 5).toString());
		p.setObservacionesPersonales(tb.getValueAt(0, 6).toString());
		p.setObservacionesFamiliares(tb.getValueAt(0, 7).toString());
		p.setObservacionesVivienda(tb.getValueAt(0, 8).toString());
		
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
			return false;
		}
		return true;
	}


	

}
