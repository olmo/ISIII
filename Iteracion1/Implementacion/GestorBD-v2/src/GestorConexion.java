
import java.sql.*;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class GestorConexion {
	private Connection conexion;
	private ResultSet rs;
	private Statement st;
	
	public GestorConexion(){

	}
	
	public boolean conectar(){
		try{ 
			   Class.forName("com.mysql.jdbc.Driver");
			   conexion = DriverManager.getConnection("jdbc:mysql://1984.dyndns.org:3306/isiii", "isiii", "qwerty");//"jdbc:mysql://1984.dyndns.org", "isiii", "qwerty");
			   return true;
			   }
			catch(Exception e){ e.printStackTrace(); return false;}
	}
	
	public void desconectar(){
		try{ 
			   if(rs!=null){
				   rs.close();
			   }
		}catch(Exception ex){
			ex.printStackTrace();
		}
		try{ 
			   if(st!=null){
				   st.close();
			   }
		}catch(Exception ex){
			ex.printStackTrace();
		}
		try{ 
			   if(conexion!=null){
				   conexion.close();
			   }
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public boolean InsertarDatos(String SQL){
		try{
			if(st.executeUpdate(SQL)==1){
				return true;
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public TableModel RealizarConsulta(String SQL){
		
		
		//System.out.println("Realizando consulta");
		// Preparamos la consulta 
		
		 DefaultTableModel modelo = new DefaultTableModel(); //Creamos la estructura para guardar los datos(UNA TABLA)
		 Object [] tupla;
		 ButtonGroup grupo = new ButtonGroup();
					try{ 
						 st = conexion.createStatement(); 
						rs = st.executeQuery (SQL);
						
						// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla. 
//						while (rs.next()) 
//						{ 
//							
//						    System.out.println (rs.getString (1) + " " + rs.getString (2)+ " " + rs.getDate(3)); 
//						}
						 
					        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {//Relleneamos la cabecera de la tabla.
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
					}
//					System.out.println(modelo.getRowCount());
			        return modelo;

					
					
			        
			        
	}
	
	

}



