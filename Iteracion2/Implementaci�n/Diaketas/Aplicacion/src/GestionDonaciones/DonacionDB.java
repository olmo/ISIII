package GestionDonaciones;


import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Basedatos.GestorJDBC;
import GestionPersona.Donante;
import GestionPersona.DonanteDB;


public class DonacionDB {
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	Boolean add(Donacion donacion){
		gestor.conectar();
		Boolean correcto = gestor.Modificar("INSERT INTO Donacion (id_objetomonitorizable,id_donante,cantidad,estado) VALUES ('"+donacion.getIdObjMon()+"','"+donacion.getIdDonante()+"','"+donacion.getCantidad()+"','"+donacion.getEstado()+"')");
		gestor.desconectar();
		return correcto;
	}
	
	
	ArrayList<Donacion> getList(String filtro){
		ArrayList<Donacion> lista = new ArrayList<Donacion>();
		
		try{
			ResultSet rs;
			gestor.conectar();
			if(Pattern.matches("^d{2}/d{2}/d{4} d{2}/d{2}/d{4}", filtro)){	// Si el filtrado es por intervalo de fechas
				String [] fechas = filtro.split("\\ ");
				java.text.DateFormat formato = new java.text.SimpleDateFormat("dd/MM/aaaa");
				java.util.Date parsedUtilDate0 = formato.parse(fechas[0]);
				java.util.Date parsedUtilDate1 = formato.parse(fechas[1]);
				Date fechaIni = new Date(parsedUtilDate0.getTime());
				Date fechaFin = new Date(parsedUtilDate1.getTime());
				rs = gestor.RealizarConsulta("SELECT * from Donaciones,ObjetosMonitorizables " +
						"WHERE (Donaciones.id_objetomonitorizable=ObjetosMonitorizables.id) AND " +
						"(ObjetosMonitorizables.fecha>='"+fechaIni.toString()+"' AND ObjetosMonitorizables.fecha<='"+fechaFin.toString()+"')");
			}else if(Pattern.matches("^\\d{0,8}", filtro)){		// Si el filtrado es por el DNI del donante
				rs = gestor.RealizarConsulta("SELECT * from Personas, Donantes, Donaciones " +
						"WHERE Personas.id=Donantes.id_persona AND Donantes.id_persona=Donaciones.id_donante AND " +
						"Personas.dni LIKE '"+filtro+"%'");
			}else if(filtro==null){
				rs = gestor.RealizarConsulta("SELECT * from Personas, Donantes, Donaciones WHERE Personas.id=Donantes.id_persona AND Donantes.id_persona=Donaciones.id_donante");				
			}else{
				// CONSULTA SEGUN NOMBRE Y APELLIDOS DEL DONANTE
				rs = gestor.RealizarConsulta("SELECT * from Personas,Donantes, Donaciones " +
						"WHERE (Personas.id=Donantes.id_persona AND Donantes.id_persona=Donaciones.id_donante AND Personas.nombre LIKE '"+filtro+"%' OR Personas.apellido1 LIKE '"+filtro+"%' OR Personas.apellido2 LIKE '"+filtro+"%'");
			}
			gestor.desconectar();
			Estado miestado = null;
			String sestado;
			while(rs.next()){
				Donacion donacion = new Donacion();
				
				donacion.setIdObjMon((Integer)rs.getObject("id_objetomonitorizable"));
				donacion.setIdDonante((Integer)rs.getObject("id_donante"));
				sestado = rs.getObject("estado").toString();				
				if(sestado.contains("Pagado"))
					miestado = Estado.Pagado;
				else if (sestado.contains("Pendiente"))
					miestado = Estado.Pendiente;
				else
					miestado = Estado.Cancelado;
					
				donacion.setEstado(miestado);
				donacion.setCantidad((Float)rs.getObject("cantidad"));
				lista.add(donacion);
			}
			
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al listar las donaciones donacionDB: "+e.getMessage());
			return null;
		}
		return lista;
	}
	
	
	ArrayList<Donante> getDonantes(String filtro){
		
		DonanteDB donantes = new DonanteDB(); 
		return donantes.getDonantes(filtro);		
		
	}
	
	
	Boolean set(Donacion donacion){
		//PAra actualizar una donacion
		gestor.conectar();
		Boolean correcto = gestor.Modificar("UPDATE Donaciones SET cantidad='"+donacion.getCantidad()+"',estado='"+donacion.getEstado()+"' WHERE id_objetomonitorizable='"+donacion.getIdObjMon()+"'");
		gestor.desconectar();
		return correcto;
	}
}
