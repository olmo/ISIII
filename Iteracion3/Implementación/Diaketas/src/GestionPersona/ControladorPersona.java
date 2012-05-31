package GestionPersona;


import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;





public class ControladorPersona {
	
	
	private PersonaDB personaDB=new PersonaDB();
	private SocioDB socioDB= new SocioDB();
	private TrabajadorDB trabajadorDB = new TrabajadorDB();
	private BeneficiarioDB beneficiarioDB =new BeneficiarioDB();
	private ColaboradorDB colaboradorDB= new ColaboradorDB();
	private EmpresaDB empresaDB=new EmpresaDB();
	private FamiliarDB familiarDB=new FamiliarDB();
	

	public Boolean consultarPersona(String dni){
		return personaDB.consultarPersona(dni);	
	}
	
	

	
	
	//Introducir Datos
	public void introducirDatosSocio(int id, int periocidad,String usuario,String pass){
		CodificacionPW c=new CodificacionPW(pass);
		Socio s=new Socio(id, periocidad, usuario, c.getPassword());
		socioDB.introducirDatos(s);
	}
	
	public void introducirDatosColaborador(int id, int periocidad){
		Colaborador c=new Colaborador(id, periocidad);
		colaboradorDB.introducirDatos(c);
	}

	
	public void introducirDatosEmpresa(int id, int periocidad,int CIF,String nombreEmpresa, int telefonoEmpresa, String dirEmpresa, String emailEmpresa){
		Empresa e = new Empresa(id, periocidad, CIF, nombreEmpresa, telefonoEmpresa, dirEmpresa, emailEmpresa);
		empresaDB.introducirDatos(e);
	}
	
	public void introducirDatosTrabajador(int id,String usuario, String password){
		CodificacionPW c=new CodificacionPW(password);
		Trabajador t=new Trabajador(id, usuario, c.getPassword());
		trabajadorDB.introducirDatos(t);
	}
	
	public void introducirDatosBeneficiario(int id, String localidad, String eCivil, String nEstudios, String nacionalidad, String sEconomica,String observacionesPersonales, String observacionesVivienda,String observacionesFamiliares){
		Beneficiario b= new Beneficiario(id,localidad,eCivil,nEstudios,nacionalidad,sEconomica,observacionesPersonales,observacionesVivienda,observacionesFamiliares);
		beneficiarioDB.introducirDatos(b);
	}
	
	
	
	
	
	//Baja	
	public void darBaja(Integer id){
		personaDB.darBajaPersona(id);
	}
	
	public ArrayList<ArrayList<Object>> listarSolicitudesBajas(String filtro) {
		return trabajadorDB.listarSolicitudesBajas(filtro);
	}
	
	//Modificar
	public Boolean modificarDatosBeneficiario(int id,String dni, String nombre, String apellido1, String apellido2, String fNacimiento, int telefono, String lugarNacimiento, String domicilio, int cp,String email,String localidad, String eCivil, String nEstudios, String nacionalidad, String sEconomica,String observacionesPersonales, String observacionesVivienda,String observacionesFamiliares){
		Beneficiario t=new Beneficiario(id, dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp, email,localidad,eCivil,nEstudios,nacionalidad,sEconomica,observacionesPersonales,observacionesVivienda,observacionesFamiliares);
		return beneficiarioDB.modificarDatos(t);
	}
	
	public Boolean modificarDatosColaborador(int id, String dni, String nombre, String apellido1, String apellido2, String fNacimiento, int telefono, String lugarNacimiento, String domicilio, int cp,String email,int periocidad){
		Colaborador c=new Colaborador(id, dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp, email, periocidad);
		return colaboradorDB.modificarDatos(c);
	}
	

	public void modificarDatosEmpresa(int id, String dni, String nombre, String apellido1, String apellido2, String fNacimiento, int telefono, String lugarNacimiento, String domicilio, int cp, String email, int periocidad, int CIF, String nombreEmpresa,int telefonoEmpresa, String dirEmpresa, String emailEmpresa){
		Empresa emp=new Empresa(id, dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp, email, periocidad, CIF, nombreEmpresa, telefonoEmpresa, dirEmpresa, emailEmpresa);
		empresaDB.modificarDatos(emp);
	}
	
	
	public Boolean modificarDatosSocio(int id, String dni, String nombre, String apellido1, String apellido2, String fNacimiento,int telefono, String lugarNacimiento, String domicilio, Integer cp, String email, Integer periocidad, String usuario, String contrasena){
		Socio s=new Socio(id, dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp, email, periocidad,usuario,contrasena);
		return socioDB.modificarDatos(s);
	}
	
	
	public Boolean modificarDatosTrabajador(int id, String dni,String nombre, String apellido1, String apellido2, String fNacimiento,int telefono, String lugarNacimiento, String domicilio, Integer cp, String email){

		
		Trabajador t=new Trabajador(id, dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp, email);
		return trabajadorDB.modificarDatos(t);
		
	}
	
	
	
	//Consultas
	
	public Beneficiario consultarBeneficiario(Integer id){
		return beneficiarioDB.getDatos(id);
	}
	
	public Colaborador consultarColaborador(Integer id){
		return colaboradorDB.getDatos(id);
	}
	
	public Empresa consultarEmpresa(Integer id){
		return empresaDB.getDatos(id);
	}
	
	public Socio consultarSocio(Integer id){
		return socioDB.getDatos(id);
	}
	
	public Trabajador consultarTrabajador(Integer id){
		return trabajadorDB.getDatos(id);
	}
	
	
	
	
	public boolean introduceDatosInicioSesion(String usuario, String password){
		return trabajadorDB.introduceDatosInicioSesion(usuario, password);
	}
	
	public TableModel BuscarPersonas(String persona, String rol){
		ArrayList<Persona> aux=new ArrayList<Persona>();
		
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla;
		//Relleneamos la cabecera de la tabla.
			modelo.addColumn("id");
			modelo.addColumn("DNI");
			modelo.addColumn("Nombre");
			modelo.addColumn("Apellido 1");
			modelo.addColumn("Apellido 2");
			modelo.addColumn("Rol");
		
		if(rol!=null){
			aux=personaDB.buscaPersonas(persona, rol);
			for(int i=0;i<aux.size();i++){
				tupla = new Object[6];
				tupla[0] = aux.get(i).getId();
				tupla[1] = aux.get(i).getDni();
				tupla[2] = aux.get(i).getNombre();
				tupla[3] = aux.get(i).getApellido1();
				tupla[4] = aux.get(i).getApellido2();
				tupla[5] = rol;
					
				modelo.addRow(tupla); 
			}
		}else{
			aux=personaDB.buscaPersonas(persona, "trabajador");
			//introducimos los datos en la Tabla
			for(int i=0;i<aux.size();i++){
				tupla = new Object[6];
				tupla[0] = aux.get(i).getId();
				tupla[1] = aux.get(i).getDni();
				tupla[2] = aux.get(i).getNombre();
				tupla[3] = aux.get(i).getApellido1();
				tupla[4] = aux.get(i).getApellido2();
				tupla[5] = "trabajador";
				modelo.addRow(tupla); 
			}
			
			aux=personaDB.buscaPersonas(persona, "beneficiario");
			//introducimos los datos en la Tabla
			for(int i=0;i<aux.size();i++){
				tupla = new Object[6];
				tupla[0] = aux.get(i).getId();
				tupla[1] = aux.get(i).getDni();
				tupla[2] = aux.get(i).getNombre();
				tupla[3] = aux.get(i).getApellido1();
				tupla[4] = aux.get(i).getApellido2();
				tupla[5] = "beneficiario";
				modelo.addRow(tupla); 
			}
			
			aux=personaDB.buscaPersonas(persona, "donante-Socio");
			//introducimos los datos en la Tabla
			for(int i=0;i<aux.size();i++){
				tupla = new Object[6];
				tupla[0] = aux.get(i).getId();
				tupla[1] = aux.get(i).getDni();
				tupla[2] = aux.get(i).getNombre();
				tupla[3] = aux.get(i).getApellido1();
				tupla[4] = aux.get(i).getApellido2();
				tupla[5] = "donante-Socio";
				modelo.addRow(tupla); 
			}
			
			aux=personaDB.buscaPersonas(persona, "donante-Empresa");
			//introducimos los datos en la Tabla
			for(int i=0;i<aux.size();i++){
				tupla = new Object[6];
				tupla[0] = aux.get(i).getId();
				tupla[1] = aux.get(i).getDni();
				tupla[2] = aux.get(i).getNombre();
				tupla[3] = aux.get(i).getApellido1();
				tupla[4] = aux.get(i).getApellido2();
				tupla[5] = "donante-Empresa";
				modelo.addRow(tupla); 
			}
			
			aux=personaDB.buscaPersonas(persona, "donante-Colaborador");
			//introducimos los datos en la Tabla
			for(int i=0;i<aux.size();i++){
				tupla = new Object[6];
				tupla[0] = aux.get(i).getId();
				tupla[1] = aux.get(i).getDni();
				tupla[2] = aux.get(i).getNombre();
				tupla[3] = aux.get(i).getApellido1();
				tupla[4] = aux.get(i).getApellido2();
				tupla[5] = "donante-Colaborador";
				modelo.addRow(tupla); 
			}
		}
		
		
		return modelo;
	}
	
	
	
	
	
	//Borrar Datos
	public boolean borrarDatosBeneficiario(Integer id){
		try{
			beneficiarioDB.borrarDatos(id);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al borrar los datos del beneficiario:\n"+e.getMessage());

			return false;
		}
		return true;
	}
	
	public boolean borrarDatosSocio(Integer id){
		try{
			socioDB.borrarDatos(id);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al borrar los datos del socio:\n"+e.getMessage());

			return false;
		}
		return true;
	}
	
	public boolean borrarDatosTrabajador(Integer id){
		try{
			trabajadorDB.borrarDatos(id);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al borrar los datos del trabajador:\n"+e.getMessage());
			return false;
		}
		return true;
		
	}
	
	public boolean borrarDatosEmpresa(Integer id){
		try{
			empresaDB.borrarDatos(id);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al borrar los datos de la empresa:\n"+e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean borrarDatosColaborador(Integer id){
		try{
			colaboradorDB.borrarDatos(id);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al borrar los datos del colaborador:\n"+e.getMessage());

			return false;
		}
		return true;
	}
	

	
	//Alta Persona
	
	public int darAltaPersona(String dni, String nombre, String apellido1, String apellido2, String fNacimiento, int telefono, String lugarNacimiento, String domicilio, int cp,String email){
		if(consultarPersona(dni)==false){
			return personaDB.introducirDatos(new Persona(dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp, email));
		}
		return -1;
	}
	
	
	
	//Fin version 3 diagrama de clases
	

	//FAMILIARES

		public TableModel listarFamiliares(Integer idPersona){
	ArrayList<Familiar> aux=new ArrayList<Familiar>();
			
			DefaultTableModel modelo = new DefaultTableModel();
			Object [] tupla;
			//Relleneamos la cabecera de la tabla.
				modelo.addColumn("id");
				modelo.addColumn("DNI");
				modelo.addColumn("Nombre");
				modelo.addColumn("Apellido 1");
				modelo.addColumn("Apellido 2");
				modelo.addColumn("Parentesco");
			
			
				aux=familiarDB.listarFamiliares(idPersona);
				for(int i=0;i<aux.size();i++){
					tupla = new Object[6];
					tupla[0] = aux.get(i).getId();
					tupla[1] = aux.get(i).getDni();
					tupla[2] = aux.get(i).getNombre();
					tupla[3] = aux.get(i).getApellido1();
					tupla[4] = aux.get(i).getApellido2();
					tupla[5] = aux.get(i).getParentesco();
						
					modelo.addRow(tupla); 
				}
			
			
			
			return modelo;
		}
		
		
		public Familiar consultarFamiliar(Integer id){
			return familiarDB.getDatos(id);
		}
		
		public void iniciarAltaFamiliar(int idBeneficiario){
			
		}
		
		
		public void introducirDatosFamiliar(Integer idPersona,Integer idBeneficiario, String parentesco, String ocupacion){
			
			Familiar f=new Familiar(idPersona, idBeneficiario, parentesco,ocupacion);
			familiarDB.introducirDatos(f);
		}
		
		
	public void modificarDatosFamiliar(int id, String dni,String nombre, String apellido1, String apellido2, String fNacimiento,int telefono, String lugarNacimiento, String domicilio, Integer cp, String email,int id_beneficiario,String parentesco, String ocupacion){

			
			Familiar f=new Familiar(id, dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp, email,id_beneficiario,parentesco, ocupacion);
			familiarDB.modificarDatos(f);
			
		}

	public boolean borrarDatosFamiliar(Integer id){
		try{
			familiarDB.borrarDatos(id);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al borrar los datos del familiar:\n"+e.getMessage());

			return false;
		}
		return true;
		
	}



	public void darAlta(Integer id) {
		personaDB.darAltaPersona(id);
	}

}
