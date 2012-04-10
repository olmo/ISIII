/**
 * 
 */

/**
 * @author 
 *
 */

package Basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

final public class GestorJDBC {

	private static GestorJDBC instance= null;
	
	private Connection conexion;
	private ResultSet rs;
	private Statement st;

	
	private synchronized static void createInstance(){
		if(instance==null){
			instance= new GestorJDBC();
		}
	}
	
	public static GestorJDBC getInstance(){
		if(instance==null)
			createInstance();
		
		return instance;
		
	}
	
	//El método "clone" es sobreescrito por el siguiente que arroja una excepción:
	public Object clone() throws CloneNotSupportedException {
	        throw new CloneNotSupportedException(); 
	}
	
	public boolean conectar(){
		try{ 
			   Class.forName("com.mysql.jdbc.Driver");
			   conexion = DriverManager.getConnection("jdbc:mysql://1984.dyndns.org:3306/isiii", "isiii", "qwerty");
			   return true;
			   }
			catch(Exception e){
				e.printStackTrace(); 
				JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
				return false;
				}
	}
	
	public boolean desconectar(){
		try{ 
			   if(rs!=null){
				   rs.close();
			   }
		}catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al desconectar de la BD");
			return false;
		}
		try{ 
			   if(st!=null){
				   st.close();
			   }
		}catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al desconectar de la BD");
			return false;
		}
		try{ 
			   if(conexion!=null){
				   conexion.close();
			   }
		}catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al desconectar de la BD");
			return false;
		}
		return true;
	}
	
	 public boolean Estado() {
	        try {
	            return this.conexion.isValid(3);
	        } catch (Exception ex) {
	        	JOptionPane.showMessageDialog(null, "Error al acceder a BD");
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
		
		
		
		conectar();

		// Preparamos la consulta 
		
		DefaultTableModel modelo = new DefaultTableModel(); //Creamos la estructura para guardar los datos(UNA TABLA)
		Object [] tupla;

		try{ 
			st = conexion.createStatement();
			 
			rs= st.executeQuery (SQL);
//			while (rs.next()) 
//				{ 
//					System.out.println (rs.getString (1) + " " + rs.getString (2)); 
//				}

		
			//Relleneamos la cabecera de la tabla.
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				modelo.addColumn(rs.getMetaData().getColumnName(i+1));

			}
        			//System.out.println(rs.getRow());	        

			while (rs.next()){//introducimos los datos en la Tabla
				tupla = new Object[rs.getMetaData().getColumnCount()];
				
				for (int i=0; i<rs.getMetaData().getColumnCount();i++)
					tupla[i] = rs.getObject(i+1);

				modelo.addRow(tupla); 
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Error al consultar BD");
			ex.printStackTrace();
			return null;
		}

		
		desconectar();
		return modelo;
	}

	public  boolean Modificar(String SQL){
		conectar();

		// Preparamos la consulta 
		
	
int r=0;
		try{ 
			st = conexion.createStatement();
			System.out.println(SQL);
			r=st.executeUpdate(SQL); //Modifico
		
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Error al escribir en la base de datos");
			ex.printStackTrace();
		}

		desconectar();
		
		if(r>0)
		return true;
		else 
			return false;
	}
	
}