package GestionActuacion;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
		Boolean correcto = gestor.Modificar("INSERT INTO Actuaciones (id_tipoactuacion,id_objetomonitorizable,id_trabajador) " +
				"VALUES ('"+tipo+"','"+nuevaActuacion.getIdObjMonitorizado()+"','"+nuevaActuacion.getIdTrabajador()+"')");
		gestor.desconectar();
		return correcto;
	}
	
	
	ArrayList<Actuacion> getList(String filtro){
		ArrayList<Actuacion> lista = new ArrayList<Actuacion>();
		
		try{
			ResultSet rs;
			gestor.conectar();
			if(Pattern.matches("^\\d{2}/\\d{2}/\\d{4}", filtro)){	// Si el filtrado es por fecha
				String fechaConsulta = new String();
				fechaConsulta = fechaConsulta + filtro.substring(6) + "-" + filtro.substring(3, 5) + "-" + filtro.substring(0, 2);
				
				rs = gestor.RealizarConsulta("SELECT * from Actuaciones, ObjetosMonitorizables OM WHERE OM.fecha='"+fechaConsulta+"' AND " +
						"OM.id = Actuaciones.id_objetomonitorizable");
			}else if(Pattern.matches("^[Cc]onceder ayuda", filtro)){		// Si el filtrado es por el tipo de actuacion 'conceder_ayuda'
				rs = gestor.RealizarConsulta("SELECT * from Actuaciones, ObjetosMonitorizables OM WHERE OM.id = Actuaciones.id_objetomonitorizable AND id_tipoactuacion='0'");
			}else if(Pattern.matches("^[Ee]ditar ayuda", filtro)){			// Si el filtrado es por el tipo de actuacion 'editar_ayuda'
				rs = gestor.RealizarConsulta("SELECT * from Actuacione, ObjetosMonitorizables OM WHERE OM.id = Actuaciones.id_objetomonitorizable AND id_tipoactuacion='1'");
			}else if(Pattern.matches("^[Aa]�adir donacion", filtro)){		// Si el filtrado es por el tipo de actuacion 'a�adir_donacion'
				rs = gestor.RealizarConsulta("SELECT * from Actuaciones, ObjetosMonitorizables OM WHERE OM.id = Actuaciones.id_objetomonitorizable AND id_tipoactuacion='2'");
			}else if(Pattern.matches("^[Cc]ancelar donacion", filtro)){		// Si el filtrado es por el tipo de actuacion 'cancelar_donacion'
				rs = gestor.RealizarConsulta("SELECT * from Actuaciones, ObjetosMonitorizables OM WHERE OM.id = Actuaciones.id_objetomonitorizable AND id_tipoactuacion='3'");
			}else if(Pattern.matches("^[Cc]onfirmar donacion", filtro)){	// Si el filtrado es por el tipo de actuacion 'confirmar_donacion'
				rs = gestor.RealizarConsulta("SELECT * from Actuaciones, ObjetosMonitorizables OM WHERE OM.id = Actuaciones.id_objetomonitorizable AND id_tipoactuacion='4'");
			}else if(Pattern.matches("^\\d{0,8}", filtro)){		// Si el filtrado es por el DNI del trabajador
				rs = gestor.RealizarConsulta("SELECT * from Personas, Trabajadores, Actuaciones, ObjetosMonitorizables OM " +
						"WHERE Personas.id=Trabajadores.id_persona AND Personas.id=Actuaciones.id_trabajador AND OM.id = Actuaciones.id_objetomonitorizable AND " +
						"Personas.dni LIKE '"+filtro+"%'");
			}else{		// Si el filtrado es por nombre o apellidos del trabajador
				rs = gestor.RealizarConsulta("SELECT * from Personas, Trabajadores, Actuaciones, ObjetosMonitorizables OM " +
						"WHERE Personas.id=Trabajadores.id_persona AND Personas.id=Actuaciones.id_trabajador AND OM.id = Actuaciones.id_objetomonitorizable AND " +
						"(Personas.nombre LIKE '"+filtro+"%' OR Personas.apellido1 LIKE '"+filtro+"%' OR Personas.apellido2 LIKE '"+filtro+"%')");
			}
			
			
			while(rs.next()){
				Actuacion act = new Actuacion();
				
				act.setFecha((Timestamp)rs.getObject("OM.fecha"));	
				act.setIdObjMonitorizado((Integer)rs.getObject("id_objetomonitorizable"));
				act.setIdTrabajador((Integer)rs.getObject("id_trabajador"));
				act.setTipoActuacion(TipoActuacion.class.getEnumConstants()[(Integer)rs.getObject("id_tipoactuacion")]);
				lista.add(act);
			}
			
			gestor.desconectar();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al listar las actuaciones ActuacionDB: "+e.getMessage());
			return null;
		}
		return lista;
	}
}
