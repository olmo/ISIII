/**
 * 
 */
package GestionPersona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Basedatos.GestorJDBC;
import GestionSolicitante.Solicitante;





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
	
	public Trabajador getTrabajador(String nombre){
		Trabajador p = new Trabajador();
		ResultSet rs=null;
		try{
			gestor.conectar();
			rs = gestor.RealizarConsulta("select * from Trabajadores, Personas where Personas.nombre='"+nombre+"' AND Personas.id = Trabajadores.id_persona");
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
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al obtener los datos del trabajador "+nombre);
			JOptionPane.showMessageDialog(null, "Error al obtener los datos del trabajador:\n"+e.getMessage());
			return null;
		}
		return p;
	}
	
	public ArrayList<ArrayList<Object>> listarSolicitudesBajas(String filtro) {
		ArrayList<ArrayList<Object>> listaSolicitudes = new ArrayList<ArrayList<Object>>();

		ResultSet rs = null;
		gestor.conectar();

		if (filtro == null || filtro.equals(""))
			rs = gestor
					.RealizarConsulta("select * from Personas,Donantes,Socios,Solicitudes_bajas where (Personas.id=Socios.id_persona AND Donantes.id_persona=Socios.id_persona AND Socios.id_persona = Solicitudes_bajas.id_socio)");
		else
			rs = gestor
					.RealizarConsulta("select * from Personas,Donantes,Socios,Solicitudes_bajas where (Personas.id=Socios.id_persona AND Donantes.id_persona=Socios.id_persona AND Socios.id_persona = Solicitudes_bajas.id_socio) AND ( "
							+ "nombre LIKE '%"
							+ filtro
							+ "%' OR apellido1 LIKE '%"
							+ filtro
							+ "%' OR apellido2 LIKE '%"
							+ filtro
							+ "%' OR dni LIKE '%"
							+ filtro
							+ "%' OR fecha LIKE '%"
							+ filtro
							+ "%')");

		try {
			while(rs.next()) {
				Socio socio = new Socio();
				ArrayList<Object> solicitud = new ArrayList<Object>();
				
				//socio = socioDB.getDatos((Integer)rs.getObject("id"));

				socio.setId((Integer)rs.getObject("id"));
				
				socio.setDni(rs.getObject("dni").toString());
				socio.setNombre(rs.getObject("nombre").toString());
				socio.setApellido1(rs.getObject("apellido1").toString());
				socio.setApellido2(rs.getObject("apellido2").toString());
			
				socio.setfNacimiento(rs.getObject("fnac").toString());
		
				socio.setTelefono((Integer)rs.getObject("telefono"));
				socio.setLugarNacimiento(rs.getObject("lugarnac").toString());
				socio.setDomicilio(rs.getObject("domicilio").toString());
		
				socio.setCp((Integer)rs.getObject("cp"));
				socio.setEstado((Boolean)rs.getObject("estado"));
		
				socio.setfBaja(rs.getObject("fbaja").toString());
				socio.setemail(rs.getObject("email").toString());
				
				socio.setPeriocidad(new Integer(rs.getObject("periocidad").toString()));
				socio.setUsuario(rs.getObject("usuario").toString());
				socio.setContrasena(rs.getObject("contrasena").toString());

				solicitud.add(socio);
				solicitud.add(rs.getObject("fecha").toString());
				solicitud.add((Boolean)rs.getObject("borrado"));
				
				listaSolicitudes.add(solicitud);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"Error al obtener los datos de las solicitudes de baja\n"
							+ e.getMessage());
		}

		gestor.desconectar();

		return listaSolicitudes;
	}
	
}
