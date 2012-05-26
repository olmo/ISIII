package GestionOfertas;

import java.util.ArrayList;

import GestionSolicitante.Solicitante;
import GestionSolicitante.Solicitante.tipo_disp;
import GestionSolicitante.Solicitante.tipo_permiso;
import GestionSolicitante.SolicitanteDB;

public class ControladorOfertas {
	private SolicitanteDB solicitanteDB = new SolicitanteDB(); 

	/** Solicitante **/
	public Solicitante registrarSolicitante(String dni, String nombre,
			String apellido1, String apellido2, String fnac, int telefono,
			String lugarNac, String domicilio, int cp, String estudios,
			String experiencia, String curriculum, tipo_permiso per_conducir,
			boolean vehiculo, tipo_disp disponibilidad, int incorpora) {

		Solicitante unSolicitante = new Solicitante();


		return unSolicitante;
	}

	public boolean borrarSolicitante(Solicitante sol) {
		// ToDo
		return true;
	}

	public Solicitante modificarSolicitante(Solicitante sol) {
		Solicitante unSolicitante = new Solicitante();
		// ToDo
		return unSolicitante;
	}

	public Solicitante consultarSolicitante(int id_solicitante) {
		Solicitante unSolicitante = new Solicitante();
		// ToDo
		return unSolicitante;
	}

	public ArrayList<Solicitante> listarSolicitantes() {
		ArrayList<Solicitante> lista = new ArrayList<Solicitante>();
		// ToDo
		return lista;
	}

	public boolean apuntarOferta(int id_oferta, int id_solicitante) {
		// ToDo
		return true;
	}

	public ArrayList<Oferta> listarOfertasDeSolicitante(int id_solicitante){
		ArrayList<Oferta> lista = new ArrayList<Oferta>();
		// ToDo
		return lista;
	}

	public boolean borrarSolicitanteDeOferta(int id_oferta, int id_solicitante) {
		return true;
	}

	public Solicitante modificarSolicitante(String dni, String nombre,
			String apellido1, String apellido2, String fnac, int telefono,
			String lugarNac, String domicilio, int cp, String estudios,
			String experiencia, String curriculum, tipo_permiso per_conducir,
			boolean vehiculo, tipo_disp disponibilidad, int incorpora) {

		Solicitante unSolicitante = new Solicitante();

		
		//ToDo

		return unSolicitante;
	}

	/********************************************************************************************/

	/** Ofertas **/

	/********************************************************************************************/

	/** Empresas ofertadoras **/

	/********************************************************************************************/
}
