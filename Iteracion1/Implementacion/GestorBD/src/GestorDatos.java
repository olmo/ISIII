import javax.swing.table.TableModel;


public class GestorDatos {

	GestorConexion gc;
	
	public GestorDatos(GestorConexion gestor){
		gc=gestor;
		
	}
	
	
	 public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
	 
	 /**
	   * Devuelve un NIF completo a partir de un DNI. Es decir, añade la letra del NIF
	   * @param dni dni al que se quiere añadir la letra del NIF
	   * @return NIF completo.
	   */
	  public static String letraDNI(int dni) {
	    return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
	  }
	  
	  
	  
	  public boolean insertardatos(String dni, String nombre, String fecha){
		  System.out.println("Se va a insertar "+" "+dni+" "+nombre+" "+fecha);
		  return  gc.InsertarDatos("INSERT INTO prueba (dni,nombre,nacimiento) VALUES('"+dni+"','"+nombre+"','"+fecha+"')");
		  
	  }
	  
	  public TableModel buscardni(String c){
		  return gc.RealizarConsulta("select * from prueba where dni LIKE ('"+c+"%')");
	  }
	  
	  public TableModel consultardatos(){
		  return gc.RealizarConsulta("select * from prueba");
	  }
	  

	  
	  
	  
	  
}
