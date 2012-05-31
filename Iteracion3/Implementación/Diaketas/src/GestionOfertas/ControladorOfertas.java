package GestionOfertas;

import java.sql.Timestamp;
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

	public Solicitante consultarSolicitante(int id_solicitante) {
		Solicitante unSolicitante = new Solicitante();
		unSolicitante = solicitanteDB.consultarSolicitante(id_solicitante);
		return unSolicitante;
	}

	public ArrayList<Solicitante> listarSolicitantes(String filtro) {
		return solicitanteDB.listarSolicitantes(filtro);
	}
	
	public boolean apuntarOferta(int id_oferta, int id_solicitante) {
		return solicitanteDB.registrarSolicitud(id_oferta, id_solicitante);
	}

	public ArrayList<Oferta> listarOfertasDeSolicitante(int id_solicitante) {
		return solicitanteDB.listarOfertasDeSolicitante(id_solicitante);
	}

	public boolean borrarSolicitanteDeOferta(int id_oferta, int id_solicitante) {
		return solicitanteDB.borrarSolicitanteOferta(id_oferta, id_solicitante);
	}
	
	

	/********************************************************************************************/

	/** Ofertas **/
	
	/********************************************************************************************/
	
	public boolean RegistrarOferta(int id_empresa, String titulo, String descripcion, String puesto, int vacantes, String tipo_contrato, 
			int duracion, Timestamp fechafin, String localidad, String provincia, String horario, String observaciones){
		
		OfertaDB odb = new OfertaDB();
		
		Oferta oferta = new Oferta();
		oferta.setId_empresa(id_empresa);
		oferta.ModificarOferta(titulo, descripcion, puesto, vacantes, tipo_contrato, duracion, fechafin, localidad, provincia, horario, observaciones);
		
		return odb.Anadir(oferta);
	}
	
	public boolean ModificarOferta(int id, int id_empresa, String titulo, String descripcion, String puesto, int vacantes, String tipo_contrato, 
			int duracion, Timestamp fechafin, String localidad, String provincia, String horario, String observaciones){
		
		OfertaDB odb = new OfertaDB();
		
		Oferta oferta = new Oferta();
		oferta.setId(id);
		oferta.setId_empresa(id_empresa);
		oferta.ModificarOferta(titulo, descripcion, puesto, vacantes, tipo_contrato, duracion, fechafin, localidad, provincia, horario, observaciones);
		
		return odb.ModificarOferta(oferta);
	}
	
	public boolean BorrarOferta(Oferta o){
		OfertaDB odb = new OfertaDB();
		
		return odb.BorrarOferta(o);
	}
	
	public ArrayList<Oferta> ListarOfertas(String filtro){
		OfertaDB odb = new OfertaDB();
		
		return odb.getList(filtro);
	}
	
	public Oferta ConsultarOferta(int id_oferta){
		OfertaDB odb = new OfertaDB();
		
		return odb.getOferta(id_oferta);
	}
	
	public ArrayList<Solicitante> listarSolicitantesDeOferta(int idOferta){
		return solicitanteDB.getSolicitantes(idOferta);
	}
	
	
	

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
