package GestionAyudas;

import java.util.ArrayList;

import GestionPersona.Beneficiario;
import GestionPersona.BeneficiarioDB;


public class ControladorAyudas {
	
//	private TipoAyudaDB tipoAyudaDB= new TipoAyudaDB();
//	private AyudaDB ayudaDB = new AyudaDB();
//	private BeneficiarioDB beneficiarioDB = new BeneficiarioDB();
//	
//	boolean anadirTipoAyuda(String nombre, String observaciones){
//		TipoAyuda ta = new TipoAyuda(nombre, observaciones);
//		return tipoAyudaDB.add(ta);
//	}
//	
//	ArrayList<TipoAyuda> listarTiposAyuda(){
//		return tipoAyudaDB.getList();
//	}
//	
//	void modificarTipoAyuda(TipoAyuda tipoAyuda){
//		tipoAyudaDB.set(tipoAyuda);
//	}
//	
//	void borrarTipoAyuda(TipoAyuda tipoAyuda){
//		tipoAyudaDB.del(tipoAyuda);
//	}
//	
//	void concederAyuda(Beneficiario beneficiario, String observacionesAyuda, TipoAyuda tipoAyuda, float cantidad){
//		Ayuda ayuda = new Ayuda(beneficiario, observacionesAyuda, tipoAyuda, cantidad);
//		ayudaDB.add(ayuda);
//	}
//	
//	void modificarAyuda(Ayuda ayuda){
//		ayudaDB.set(ayuda);
//	}
//
//	ArrayList<Ayuda> listarAyudasConcedidas(String filtro){
//		ayudaDB.getListAyudas(filtro);
//	}
//	
//	ArrayList<Ayuda> listarAyudasBeneficiario(Beneficiario beneficiario, String filtro){
//		return ayudaDB.getAyudasBeneficiario(beneficiario, filtro);
//	}
//	
//	ArrayList<Beneficiario> buscarBeneficiarios(String filtro){
//		return beneficiarioDB.getBeneficiarios(filtro);
//	}
}
