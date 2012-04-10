package GestionPersona;

import java.util.Date;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;





public class ControladorPersona {
	
	
	public enum donante_t{
		Socio,
		Colaborador,
		Empresa	
	}
	
	
	
	

	private PersonaDB personaDB=new PersonaDB();
	private SocioDB socioDB= new SocioDB();
	private TrabajadorDB trabajadorDB = new TrabajadorDB();
	private BeneficiarioDB beneficiarioDB =new BeneficiarioDB();
	private ColaboradorDB colaboradorDB= new ColaboradorDB();
	private EmpresaDB empresaDB=new EmpresaDB();
	
	//Version 3 diagrama clases
	


	public Boolean consultarPersona(String dni){
		return personaDB.consultarPersona(dni);	
	}
	
	
	private String getCadenaAlfanumAleatoria (int longitud){
		String cadenaAleatoria = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while ( i < longitud){
			char c = (char)r.nextInt(255);
			if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
				cadenaAleatoria += c;
				i ++;
			}
		}
		return cadenaAleatoria;
		}
	
	private String[] generaClave(){
		String[] datos= new String[2];
		datos[0]=getCadenaAlfanumAleatoria(10);
		datos[1]=getCadenaAlfanumAleatoria(8);
		return datos;
	}
	
	public void introducirDatosBeneficiario(int id, String localidad, String eCivil, String nEstudios, String nacionalidad, String sEconomica,String observacionesPersonales, String observacionesVivienda,String observacionesFamiliares){
		Beneficiario b= new Beneficiario(id,localidad,eCivil,nEstudios,nacionalidad,sEconomica,observacionesPersonales,observacionesVivienda,observacionesFamiliares);
		beneficiarioDB.introducirDatos(b);
	}
	
	public void iniciarAltaDonante(donante_t rol){
		//donanteDB.creaDonante(id);
	}
	

	public void introducirDatosSocio(int id, int periocidad){
		String datos[] = generaClave();
		Socio s=new Socio(id, periocidad, datos[0], datos[1]);
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
	
	public int darAltaPersona(String dni, String nombre, String apellido1, String apellido2, String fNacimiento, int telefono, String lugarNacimiento, String domicilio, int cp,String rol,String email){
		return personaDB.introducirDatos(new Persona(dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp,rol, email));
	}
	
	public void introducirDatosTrabajador(int id){
		String datos[] = generaClave();
		Trabajador t=new Trabajador(id, datos[0], datos[1]);
		trabajadorDB.introducirDatos(t);
	}
	
	public void darBaja(Integer id){
	}
	
	public void confirmaBaja(Integer id){
		personaDB.darBajaPersona(id);
	}
	
	public void modificarDatosBeneficiario(String dni, String nombre, String apellido1, String apellido2, Date fNacimiento, int telefono, String lugarNacimiento, String domicilio, int cp,String email,String localidad, String eCivil, String nEstudios, String nacionalidad, String sEconomica,String observacionesPersonales, String observacionesVivienda,String observacionesFamiliares){
		
	}
	
	public void modificarDatosColaborador(String dni, String nombre, String apellido1, String apellido2, Date fNacimiento, int telefono, String lugarNacimiento, String domicilio, int cp,String email,int periocidad){
		
	}
	

	public void modificarDatosEmpresa(String dni, String nombre, String apellido1, String apellido2, Date fNacimiento, int telefono, String lugarNacimiento, String domicilio, int cp,String email,int periocidad,int CIF,String nombreEmpresa, int telefonoEmpresa, String dirEmpresa, String emailEmpresa){
		
	}
	
	
	public void modificarDatosSocio(int dni,String nombre, String apellido1, String apellido2, Date fNacimiento,int telefono, String lugarNacimiento, String domicilio, Integer cp, String email,Integer perdiocidad){

	}
	
	
	public void modificarDatosTrabajador(int dni,String nombre, String apellido1, String apellido2, Date fNacimiento,int telefono, String lugarNacimiento, String domicilio, Integer cp, String email){

	}
	
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
			
			aux=personaDB.buscaPersonas(persona, "donante");
			//introducimos los datos en la Tabla
			for(int i=0;i<aux.size();i++){
				tupla = new Object[6];
				tupla[0] = aux.get(i).getId();
				tupla[1] = aux.get(i).getDni();
				tupla[2] = aux.get(i).getNombre();
				tupla[3] = aux.get(i).getApellido1();
				tupla[4] = aux.get(i).getApellido2();
				tupla[5] = "donante";
				modelo.addRow(tupla); 
			}
		}
		
		
		return modelo;
	}
	
	public boolean borrarDatosBeneficiario(Integer id){
		try{
			beneficiarioDB.borrarDatos(id);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean borrarDatosSocio(Integer id){
		return false;
	}
	
	public boolean borrarDatosTrabajador(Integer id){
		try{
			trabajadorDB.borrarDatos(id);
		}catch (Exception e) {
			return false;
		}
		return true;
		
	}
	
	public boolean borrarDatosEmpresa(Integer id){
		try{
			empresaDB.borrarDatos(id);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean borrarDatosColaborador(Integer id){
		try{
			colaboradorDB.borrarDatos(id);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	

	public int altaPersona(String dni, String nombre, String apellido1, String apellido2, String fNacimiento, int telefono, String lugarNacimiento, String domicilio, int cp,String rol,String email){
		if(consultarPersona(dni)==false){
			return darAltaPersona(dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp,rol, email);
		}
		return -1;
	}
	
	
	
	//Fin version 3 diagrama de clases
	
	
/*	
	public PersonaDB getpBD() {
		return pBD;
	}

	public void setpBD(PersonaDB pBD) {
		this.pBD = pBD;
	}

	public TableModel buscaPersonas(String nombre, String filtro){
		return pBD.buscaPersonas(nombre, filtro);
		
	}
	
	public Boolean existePersona(String dni){
		return pBD.existePersona(dni);
	}
	
	public Persona getPersona(String dni){
		return pBD.getPersona(dni);
	}
	
	public void introducirDatos(String dni, String nombre, String apellido1, String apellido2, Date fNacimiento, int telefono, String lugarNacimiento, String domicilio, int cp,boolean estado, Date fBaja){
		p.introducirDatos(dni, nombre, apellido1, apellido2, fNacimiento, telefono, lugarNacimiento, domicilio, cp, estado, fBaja);
	}
	
	public void iniciarModificarPersona(String dni){
		
	}
	
	public void borrarDatosPersona(String dni){
		
	}
	
	public void darBajaPersona(String dni){
		
	}
	
	public TableModel iniciarConsultarPersona(String dni){
		return pBD.getDatosPersona(dni);
	}
	
	public Boolean introducirDatosInicioSesion(String user, String pw){
		return pBD.introduceDatosInicioSesion(user,pw);		
	}*/

}
