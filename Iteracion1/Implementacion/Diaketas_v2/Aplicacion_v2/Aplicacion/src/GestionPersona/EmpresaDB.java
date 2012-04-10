package GestionPersona;

import Basedatos.GestorJDBC;

public class EmpresaDB {

	private GestorJDBC gestor=GestorJDBC.getInstance();
	
	public void introducirDatos(Empresa e){
		gestor.conectar();
		
		gestor.Modificar("INSERT INTO Donantes (id_persona, periocidad) VALUES('"+e.getId()+"','"+e.getPeriocidad()+"')");
		gestor.Modificar("INSERT INTO Empresas (id_persona) VALUES('"+e.getId()+"', '"+e.getNombreEmpresa()+"', '"+e.getTelefonoEmpresa()+"', '"+e.getDireccionEmpresa()+"')");
		gestor.desconectar();
		}

	public Boolean modificarDatos(Empresa e){
		gestor.conectar();
		gestor.desconectar();
		return false;
	}

	public Empresa getDatos(int id){
		gestor.conectar();
		
		Empresa e=new Empresa();
		
		gestor.desconectar();
		return e;	
	}

	public Boolean borrarDatos(int id){
		gestor.conectar();
		gestor.desconectar();
		return true;
	}
}
