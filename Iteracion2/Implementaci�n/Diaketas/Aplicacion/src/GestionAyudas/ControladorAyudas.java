package GestionAyudas;

import java.util.ArrayList;

import GestionPersona.Beneficiario;
import GestionPersona.BeneficiarioDB;



public class ControladorAyudas {
	
	private TipoAyudaDB tipoAyudaDB= new TipoAyudaDB();
	private AyudaDB ayudaDB = new AyudaDB();
	private BeneficiarioDB beneficiarioDB = new BeneficiarioDB();
	
	
	public boolean anadirTipoAyuda(String nombre, String observaciones){
		TipoAyuda ta = new TipoAyuda(nombre, observaciones);
		return tipoAyudaDB.add(ta);
	}
	
	public ArrayList<TipoAyuda> listarTiposAyuda(){
		return tipoAyudaDB.getList();
	}
	
	public void modificarTipoAyuda(TipoAyuda tipoAyuda){
		tipoAyudaDB.set(tipoAyuda);
	}
	
	public void borrarTipoAyuda(TipoAyuda tipoAyuda){
		tipoAyudaDB.del(tipoAyuda);
	}
	
	public void concederAyuda(Beneficiario beneficiario, String observacionesAyuda, TipoAyuda tipoAyuda, float cantidad){
		Ayuda ayuda = new Ayuda(beneficiario, observacionesAyuda, tipoAyuda, cantidad);
		ayudaDB.add(ayuda);
	}
	
	public void modificarAyuda(Ayuda ayuda){
		ayudaDB.set(ayuda);
	}

	public ArrayList<Ayuda> listarAyudasConcedidas(String filtro){
		return ayudaDB.getList(filtro);
	}
	
	public ArrayList<Ayuda> listarAyudasBeneficiario(Beneficiario beneficiario, String filtro){
		return ayudaDB.getAyudasBeneficiario(beneficiario, filtro);
	}
	
	public ArrayList<Beneficiario> buscarBeneficiarios(String filtro){
		return beneficiarioDB.getBeneficiarios(filtro);
	}
}
