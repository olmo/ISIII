package GestionOfertas;

import java.util.ArrayList;

import GestionEmpresaOfertadora.Empresa_Ofertadora;
import GestionEmpresaOfertadora.Empresa_OfertadoraDB;
import GestionSolicitante.Solicitante;
import GestionSolicitante.Solicitante.tipo_disp;
import GestionSolicitante.Solicitante.tipo_permiso;
import GestionSolicitante.SolicitanteDB;

public class ControladorOfertas {
	private SolicitanteDB solicitanteDB = new SolicitanteDB();

	/** Solicitante **/
	public Solicitante registrarSolicitante(String dni, String nombre,
			String apellido1, String apellido2, String fNacimiento,
			int telefono, String lugarNacimiento, String domicilio, int cp,
			boolean estado, String email, String estudios, String experiencia,
			String curriculum, tipo_permiso per_conducir, boolean vehiculo,
			tipo_disp disponibilidad, int incorpora) {

		Solicitante unSolicitante = new Solicitante();

		unSolicitante.setDatos(dni, nombre, apellido1, apellido2, fNacimiento,
				telefono, lugarNacimiento, domicilio, cp, estado, email,
				estudios, experiencia, curriculum, per_conducir, vehiculo,
				disponibilidad, incorpora);
		
		solicitanteDB.add(unSolicitante);
		
		return unSolicitante;
	}

	public boolean borrarSolicitante(Solicitante sol) {
		return solicitanteDB.borrar(sol);
	}

	public void modificarSolicitante(Solicitante sol) {
		solicitanteDB.modificar(sol);
	}

	public Solicitante consultarSolicitante(int id_solicitante) {
		Solicitante unSolicitante = new Solicitante();
		unSolicitante = solicitanteDB.consultarSolicitante(id_solicitante);
		return unSolicitante;
	}

	public ArrayList<Solicitante> listarSolicitantes() {
		return solicitanteDB.listarSolicitantes();
	}

	public boolean apuntarOferta(int id_oferta, int id_solicitante) {
		// ToDo
		return true;
	}

	public ArrayList<Oferta> listarOfertasDeSolicitante(int id_solicitante) {
		ArrayList<Oferta> lista = new ArrayList<Oferta>();
		// ToDo
		return lista;
	}

	public boolean borrarSolicitanteDeOferta(int id_oferta, int id_solicitante) {
		return true;
	}

	public Solicitante modificarSolicitante(int id, String dni, String nombre,
			String apellido1, String apellido2, String fNacimiento,
			int telefono, String lugarNacimiento, String domicilio, int cp,
			boolean estado, String email, String estudios, String experiencia,
			String curriculum, tipo_permiso per_conducir, boolean vehiculo,
			tipo_disp disponibilidad, int incorpora) {

		Solicitante unSolicitante = new Solicitante();

		unSolicitante.setDatos(dni, nombre, apellido1, apellido2, fNacimiento,
				telefono, lugarNacimiento, domicilio, cp, estado, email,
				estudios, experiencia, curriculum, per_conducir, vehiculo,
				disponibilidad, incorpora);
		
		unSolicitante.setId(id);
		
		solicitanteDB.modificar(unSolicitante);
		
		return unSolicitante;
	}

	/********************************************************************************************/

	/** Ofertas **/

	/********************************************************************************************/

	/** Empresas ofertadoras **/

	/********************************************************************************************/

	public boolean AñadirEmpresaOfertadora(String nombre, String direccion, String email, int telefono, String localidad, String sector){
		Empresa_OfertadoraDB eodb = new Empresa_OfertadoraDB();
		
		Empresa_Ofertadora empresa = new Empresa_Ofertadora();
		empresa.ModificarEmpresaOfertadora(nombre, direccion, email, telefono, localidad, sector);
		
		return eodb.AnadirEmpresaOfertadora(empresa);
	}
	
	public boolean BorrarEmpresaOfertadora(Empresa_Ofertadora o){
		Empresa_OfertadoraDB eodb = new Empresa_OfertadoraDB();
		
		return eodb.BorrarEmpresaOfertadora(o);
	}
	
	public boolean ModificarEmpresaOfertadora(int id, String nombre, String direccion, String email, int telefono, String localidad, String sector){
		Empresa_OfertadoraDB eodb = new Empresa_OfertadoraDB();
		Empresa_Ofertadora empresa = new Empresa_Ofertadora();
		empresa.setId(id);
		empresa.ModificarEmpresaOfertadora(nombre, direccion, email, telefono, localidad, sector);
		
		return eodb.ModificarEmpresaOfertadora(empresa);
	}
	
	public Empresa_Ofertadora ConsultarEmpresaOfertadora(int id_empresaofertadora){
		Empresa_OfertadoraDB eodb = new Empresa_OfertadoraDB();
		
		return eodb.getEmpresaOfertadora(id_empresaofertadora);
	}
	
	public ArrayList<Empresa_Ofertadora> ListarEmpresaOfertadora(String filtro){
		Empresa_OfertadoraDB eodb = new Empresa_OfertadoraDB();
		
		return eodb.getListEmpresaOfertadora(filtro);
	}
}
