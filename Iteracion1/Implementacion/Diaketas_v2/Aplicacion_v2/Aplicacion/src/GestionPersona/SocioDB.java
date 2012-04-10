/**
 * 
 */
package GestionPersona;

import Basedatos.GestorJDBC;



/**
 * @author 
 *
 */
public class SocioDB {
	
	
	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	public void introducirDatos(Socio s){
		gestor.conectar();
		
		gestor.Modificar("INSERT INTO Donantes (id_persona, periocidad) VALUES('"+s.getId()+"','"+s.getPeriocidad()+"')");
		gestor.Modificar("INSERT INTO Socios (id_persona, usuario, contrasena) VALUES('"+s.getId()+"','"+s.getUsuario()+"','"+s.getContrasena()+"')");
		gestor.desconectar();
		}
	
	public Boolean modificarDatos(Socio s){
		gestor.conectar();
		gestor.desconectar();
		return false;
	}
	
	public Socio getDatos(int id){
		gestor.conectar();
		
		Socio s=new Socio();
		gestor.desconectar();
		return s;	
	}

	public Boolean borrarDatos(int id){
		gestor.conectar();
		gestor.desconectar();
		return true;
	}

}
