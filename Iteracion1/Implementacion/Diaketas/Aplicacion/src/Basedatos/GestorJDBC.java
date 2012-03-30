/**
 * 
 */

/**
 * @author Javi
 *
 */

package Basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GestorJDBC {


	private Connection conexion;
	//private ResultSet rs;
	private Statement st;
	
	
	public GestorJDBC(){

	}
	
	public boolean conectar(){
		try{ 
			   Class.forName("com.mysql.jdbc.Driver");
			   conexion = DriverManager.getConnection("jdbc:mysql://1984.dyndns.org:3306/isiii", "isiii", "qwerty");
			   return true;
			   }
			catch(Exception e){ e.printStackTrace(); return false;}
	}
	
	public boolean desconectar(){
	/*	try{ 
			   if(rs!=null){
				   rs.close();
			   }
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}*/
		try{ 
			   if(st!=null){
				   st.close();
			   }
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		try{ 
			   if(conexion!=null){
				   conexion.close();
			   }
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	 public boolean Estado() {
	        try {
	            return this.conexion.isValid(3);
	        } catch (Exception ex) {
	            return false;
	        }
	    }

	
//	public boolean InsertarDatos(String SQL){
//		try{
//			if(st.executeUpdate(SQL)==1){
//				return true;
//			}
//			
//			
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}
//		return false;
//	}
	
	public TableModel RealizarConsulta(String SQL){

		// Preparamos la consulta 
		
		DefaultTableModel modelo = new DefaultTableModel(); //Creamos la estructura para guardar los datos(UNA TABLA)
		Object [] tupla;

		try{ 
			st = conexion.createStatement();
			 
			ResultSet rs= st.executeQuery (SQL);


		
			//Relleneamos la cabecera de la tabla.
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				modelo.addColumn(rs.getMetaData().getColumnName(i+1));

			}
        				        

			while (rs.next()){//introducimos los datos en la Tabla
				tupla = new Object[rs.getMetaData().getColumnCount()];

				for (int i=0; i<rs.getMetaData().getColumnCount();i++)
					tupla[i] = rs.getObject(i+1);
           	  
				modelo.addRow(tupla); 
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}

		return modelo;
	}
}
