package GestionActuacion;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import Basedatos.GestorJDBC;


public class ActuacionDB {
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	
	Boolean add(Actuacion nuevaActuacion){
		int tipo=0;
		switch(nuevaActuacion.getTipoActuacion()){
		case conceder_ayuda:
			tipo = 0;
			break;
		case editar_ayuda:
			tipo = 1;
			break;
		case anadir_donacion:
			tipo = 2;
			break;
		case cancelar_donacion:
			tipo = 3;
			break;
		case confirmar_donacion:
			tipo = 4;
			break;
		}
		gestor.conectar();
		Boolean correcto = gestor.Modificar("INSERT INTO Actuaciones (id_tipoactuacion,id_objetomonitorizable,id_trabajador,fecha) " +
				"VALUES ('"+tipo+"','"+nuevaActuacion.getIdObjMonitorizado()+"','"+nuevaActuacion.getIdTrabajador()+"','"+nuevaActuacion.getFecha().toString()+"')");
		gestor.desconectar();
		return correcto;
	}
	
	
	ArrayList<Actuacion> getList(String filtro){
		ArrayList<Actuacion> lista = new ArrayList<Actuacion>();
		
		try{
			ResultSet rs;
			gestor.conectar();
			if(Pattern.matches("^d{2}/d{2}/d{4}", filtro)){	// Si el filtrado es por fecha
				java.text.DateFormat formato = new java.text.SimpleDateFormat("dd/MM/aaaa");
				java.util.Date parsedUtilDate = formato.parse(filtro);
				Date fecha= new Date(parsedUtilDate.getTime());
				rs = gestor.RealizarConsulta("SELECT * from Actuaciones WHERE fecha='"+fecha.toString()+"'");
			}else if(Pattern.matches("^[Cc]onceder ayuda", filtro)){		// Si el filtrado es por el tipo de actuacion 'conceder_ayuda'
				rs = gestor.RealizarConsulta("SELECT * from Actuaciones WHERE id_tipoactuacion='0'");
			}else if(Pattern.matches("^[Ee]ditar ayuda", filtro)){			// Si el filtrado es por el tipo de actuacion 'editar_ayuda'
				rs = gestor.RealizarConsulta("SELECT * from Actuaciones WHERE id_tipoactuacion='1'");
			}else if(Pattern.matches("^[Aa]ñadir donacion", filtro)){		// Si el filtrado es por el tipo de actuacion 'añadir_donacion'
				rs = gestor.RealizarConsulta("SELECT * from Actuaciones WHERE id_tipoactuacion='2'");
			}else if(Pattern.matches("^[Cc]ancelar donacion", filtro)){		// Si el filtrado es por el tipo de actuacion 'cancelar_donacion'
				rs = gestor.RealizarConsulta("SELECT * from Actuaciones WHERE id_tipoactuacion='3'");
			}else if(Pattern.matches("^[Cc]onfirmar donacion", filtro)){	// Si el filtrado es por el tipo de actuacion 'confirmar_donacion'
				rs = gestor.RealizarConsulta("SELECT * from Actuaciones WHERE id_tipoactuacion='4'");
			}else if(Pattern.matches("^\\d{0,8}", filtro)){		// Si el filtrado es por el DNI del trabajador
				rs = gestor.RealizarConsulta("SELECT * from Personas, Trabajadores, Actuaciones" +
						"WHERE Personas.id=Trabajadores.id_persona AND Personas.id=Actuaciones.id_trabajador AND" +
						"Personas.dni LIKE '"+filtro+"%'");
			}else{		// Si el filtrado es por nombre o apellidos del trabajador
				rs = gestor.RealizarConsulta("SELECT * from Personas, Trabajadores, Actuaciones" +
						"WHERE Personas.id=Trabajadores.id_persona AND Personas.id=Actuaciones.id_trabajador AND" +
						"(Personas.nombre LIKE '"+filtro+"%' OR Personas.apellido1 LIKE '"+filtro+"%' OR Personas.apellido2 LIKE '"+filtro+"%')");
			}
			gestor.desconectar();
			
			while(rs.next()){
				Actuacion act = new Actuacion();
				
				act.setFecha((Date)rs.getObject("fecha"));	
				act.setIdObjMonitorizado((Integer)rs.getObject("id_objetomonitorizable"));
				act.setIdTrabajador((Integer)rs.getObject("id_trabajador"));
				act.setTipoActuacion(TipoActuacion.class.getEnumConstants()[(Integer)rs.getObject("id_tipoactuacion")]);
				lista.add(act);
			}
			
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al listar las actuaciones ActuacionDB: "+e.getMessage());
			return null;
		}
		return lista;
	}
}
