package GestionDonaciones;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Basedatos.GestorJDBC;
import GestionPersona.Donante;
import GestionPersona.DonanteDB;

public class DonacionDB {
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	public boolean add(Donacion donacion){
		ResultSet rs;
		Boolean correcto = true;
		gestor.conectar();

		
		
			boolean valido=gestor.Modificar("INSERT INTO ObjetosMonitorizables (id) VALUES (0)");
		
			int id=1;
			rs = gestor.RealizarConsulta("select id from ObjetosMonitorizables ORDER BY id DESC");
			
				try {
					rs.next();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					id=(Integer)rs.getObject("id");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		donacion.setIdObjMon(id);
		
		correcto = gestor.Modificar("INSERT INTO Donaciones (id_objetomonitorizable,id_donante,cantidad,estado) VALUES ('"+donacion.getIdObjMon()+"','"+donacion.getIdDonante()+"','"+donacion.getCantidad()+"','"+donacion.getEstado().toString()+"')");
		
		
			
		gestor.desconectar();
		return valido;
	}
	
	public ArrayList<Donacion> getListPorSocio(Integer id){
		ArrayList<Donacion> lista = new ArrayList<Donacion>();
		ResultSet rs;
	//	JOptionPane.showMessageDialog(null,"SELECT * from ObjetosMonitorizables, Donantes, Donaciones " +
	//			"WHERE ObjetosMonitorizables.id=Donaciones.id_objetomonitorizable AND Donantes.id_persona=Donaciones.id_donante AND Donantes.id_persona="+id);
		Estado miestado = null;
		
		try{
			gestor.conectar();
			rs = gestor.RealizarConsulta("SELECT fecha,cantidad,estado from ObjetosMonitorizables, Donantes, Donaciones " +
					"WHERE ObjetosMonitorizables.id=Donaciones.id_objetomonitorizable AND Donantes.id_persona=Donaciones.id_donante AND Donantes.id_persona="+id);
			String auxestado="";
			while(rs.next()){
				Donacion donacion = new Donacion();
				
				donacion.setDate(rs.getTimestamp("fecha"));
				auxestado = rs.getObject("estado").toString();
				donacion.setCantidad((Float)rs.getObject("cantidad"));
				if(auxestado.equals("Pagado"))
					miestado = Estado.Pagado;
				if (auxestado.equals("Pendiente"))
					miestado = Estado.Pendiente;
				if (auxestado.equals("Cancelado"))
					miestado = Estado.Cancelado;
				donacion.setEstado(miestado);		
				lista.add(donacion);
			}	
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error al listar las donaciones donacionDB: "+e.getMessage());
			return null;
		}
		
		
		return lista;
	}
	
	ArrayList<Donacion> getList(String filtro){
		ArrayList<Donacion> lista = new ArrayList<Donacion>();
		
		
		try{
			ResultSet rs;
			gestor.conectar();
			if(Pattern.matches("^\\d{2}/\\d{2}/\\d{4}\\s\\d{2}/\\d{2}/\\d{4}", filtro)){	// Si el filtrado es por intervalo de fechas
				String [] fechas = filtro.split("\\s");
				String fechaIni = "";
				String fechaFin = "";
				fechas[0] = fechas[0].replace("/", "-");
				fechas[1] = fechas[1].replace("/", "-");
				fechaIni = fechaIni + fechas[0].substring(6, 10);
				fechaIni = fechaIni + "-";
				fechaIni = fechaIni + fechas[0].substring(3, 5);
				fechaIni = fechaIni + "-";
				fechaIni = fechaIni + fechas[0].substring(0, 2);
				
				fechaFin = fechaFin + fechas[1].substring(6, 10);
				fechaFin = fechaFin + "-";
				fechaFin = fechaFin + fechas[1].substring(3, 5);
				fechaFin = fechaFin + "-";
				fechaFin = fechaFin + fechas[1].substring(0, 2);
				
				rs = gestor.RealizarConsulta("SELECT * from Donaciones,ObjetosMonitorizables " +
						"WHERE (Donaciones.id_objetomonitorizable=ObjetosMonitorizables.id) AND " +
						"(ObjetosMonitorizables.fecha BETWEEN '"+fechaIni+"' AND '"+fechaFin+"')");
			}else if(Pattern.matches("^\\d{2}/\\d{2}/\\d{4}$", filtro)){	// Si el filtrado es por fecha
				String fechaConsulta = new String();
				fechaConsulta = fechaConsulta + filtro.substring(6) + "-" + filtro.substring(3, 5) + "-" + filtro.substring(0, 2);
				
				rs = gestor.RealizarConsulta("SELECT * from Donaciones, ObjetosMonitorizables OM WHERE OM.fecha='"+fechaConsulta+"' AND " +
						"OM.id = Donaciones.id_objetomonitorizable");
			}else if(Pattern.matches("^\\d{0,8}", filtro)){		// Si el filtrado es por el DNI del donante
				rs = gestor.RealizarConsulta("SELECT * from Personas, Donantes, Donaciones " +
						"WHERE Personas.id=Donantes.id_persona AND Donantes.id_persona=Donaciones.id_donante AND" +
						" Personas.dni LIKE '"+filtro+"%'");
			}else if(filtro==null){
				rs = gestor.RealizarConsulta("SELECT * from Personas, Donantes, Donaciones WHERE Personas.id=Donantes.id_persona AND Donantes.id_persona=Donaciones.id_donante");				
			}else{
				// CONSULTA SEGUN NOMBRE Y APELLIDOS DEL DONANTE
				rs = gestor.RealizarConsulta("SELECT * from Personas, Donantes, Donaciones " +
						"WHERE Personas.id=Donantes.id_persona AND Donantes.id_persona=Donaciones.id_donante AND (Personas.nombre LIKE '"+filtro+"%' OR Personas.apellido1 LIKE '"+filtro+"%' OR Personas.apellido2 LIKE '"+filtro+"%')");
			}
			
			Estado miestado = null;
			String sestado = "";
			while(rs.next()){
				Donacion donacion = new Donacion();
				
				donacion.setIdObjMon((Integer)rs.getObject("id_objetomonitorizable"));
				donacion.setIdDonante((Integer)rs.getObject("id_donante"));								
				donacion.setCantidad((Float)rs.getObject("cantidad"));				
				lista.add(donacion);
			}
			
		
			
			
			rs = gestor.RealizarConsulta("SELECT * from ObjetosMonitorizables, Donaciones WHERE ObjetosMonitorizables.id = Donaciones.id_objetomonitorizable");
			while(rs.next()){
				
				for(int i=0; i<lista.size(); i++){					
				
				if(lista.get(i).getIdObjMon() == (Integer)rs.getObject("id")){
					sestado = rs.getObject("estado").toString();	
					
					if(sestado.equals("Pagado"))
						miestado = Estado.Pagado;
					if (sestado.equals("Pendiente"))
						miestado = Estado.Pendiente;
					if (sestado.equals("Cancelado"))
						miestado = Estado.Cancelado;
	
					lista.get(i).setEstado(miestado);	
					lista.get(i).setDate(rs.getTimestamp("fecha"));
					
					
					
					}
				}
				
				
			}
			
			gestor.desconectar();
			
			
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
