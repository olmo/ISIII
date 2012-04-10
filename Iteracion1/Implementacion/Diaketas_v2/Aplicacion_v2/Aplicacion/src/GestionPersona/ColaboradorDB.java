/**
 * 
 */
package GestionPersona;

import Basedatos.GestorJDBC;

/**
 * @author 
 *
 *
 */
public class ColaboradorDB {
	
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	public void introducirDatos(Colaborador b){
		gestor.conectar();
		gestor.Modificar("INSERT INTO Donantes (id_persona, periocidad) VALUES('"+b.getId()+"','"+b.getPeriocidad()+"')");
		gestor.Modificar("INSERT INTO Colaboradores (id_persona) VALUES('"+b.getId()+"')");
		gestor.desconectar();
	}
	
	public boolean modificarDatos(Colaborador b){
		gestor.conectar();
		gestor.desconectar();
		return false;
	}
	
	public Colaborador getDatos(Integer id){
		gestor.conectar();
		gestor.desconectar();
		return null;
	}
	
	public boolean borrarDatos(Integer id){
		gestor.conectar();
		gestor.desconectar();
		return false;
	}

}
