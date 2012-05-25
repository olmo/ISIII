package GestionSolicitante;

import java.util.ArrayList;

import Basedatos.GestorJDBC;
import GestionOfertas.Oferta;

public class SolicitanteDB {
	private GestorJDBC gestor = GestorJDBC.getInstance();
	
	public boolean add(Solicitante sol){
		// ToDo
		return false;
	}
	
	public boolean borrar(Solicitante sol){
		// ToDo
		return false;
	}
	
	public boolean modificar(Solicitante sol){
		// ToDo
		return false;
	}

	public ArrayList<Solicitante> listarSolicitantes(Solicitante sol){
		ArrayList<Solicitante> lista = new ArrayList<Solicitante>();
		// ToDo
		return lista;
	}
	
	public Solicitante consultarSolicitante(int id_solicitante){
		Solicitante unSolicitante = new Solicitante();
		// ToDo
		return unSolicitante;
	}
	
	public boolean registrarSolicitud(int id_oferta, int id_solicitante){
		// ToDo
		return false;
	}
	
	public ArrayList<Oferta> listarOfertasDeSolicitante(int id_solicitante){
		ArrayList<Oferta> lista = new ArrayList<Oferta>();
		// ToDo
		return lista;
	}
	
	public boolean borrarSolicitanteOferta(int id_oferta, int id_solicitante){
		// ToDo
		return false;
	}
}
