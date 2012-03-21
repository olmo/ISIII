	import java.sql.DriverManager;
	import java.sql.Connection;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.lang.ClassNotFoundException;
	import java.sql.SQLException;

	import com.mysql.jdbc.*;



	public class prueba {
		
			public static void main(String[] args) throws IOException {
			try {

				/**** Cargamos el driver ****/
				Class.forName("com.mysql.jdbc.Driver");

				/**** Realizamos la conexión http://1984.dyndns.org:3306 ****/
				Connection con = DriverManager.getConnection( "jdbc:mysql://1984.dyndns.org:3306/isiii", "isiii", "qwerty" );

				/**** Ok: avisamos ****/
				System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
				System.out.println( "Si no se hubiera producido, se habría disparado SQLException");
				
				/*** Preparamos los esqueletos de las consultas ****/
				
				String insert_socio="INSERT into socio_prueba (nombre, apellido) VALUES (? , ?)";
				String insert_empleado="INSERT into empleado_prueba (nombre, apellido) VALUES (? , ?)";

				
				/*** preparamos el buffer reader de entrada ****/
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				Statement s;

		        try {
		        	while(true) {
		            s =(Statement) con.createStatement();
		            System.out.println( "***********" ); 

		            System.out.println("Seleccione que desea hacer : " );
		            System.out.println("			1.- Nuevo Socio" );
		            System.out.println("			2.- Nuevo Empleado " );
		            System.out.println("			3.- Ver Socios ");
		            System.out.println("			4.- Ver Empleados  ");
		            
		            int opcion =  System.in.read();
		            br.readLine(); // Capturo el enter
		            switch(opcion){

		            case '1':
		            	java.sql.PreparedStatement pstm1 = con.prepareStatement(insert_socio);
		            	
		            	try{
		            		
		            		System.out.println( "-->Introduce el nombre del nuevo usuario :  ");
			            	String nombre1 = br.readLine();
							System.out.println( "-->Introduce el apellido del nuevo usuario :  ");
							String apellido1 = br.readLine();
							pstm1.setString(1, nombre1);
							pstm1.setString(2, apellido1);
							pstm1.execute();
							
		            		} catch (IOException  ioe){
		            		 ioe.printStackTrace();
		            		}
		            	

		            break;

			           case '2':
			        	   java.sql.PreparedStatement pstm3 = con.prepareStatement(insert_empleado);
			            	try{
			            		
			            	System.out.println( "-->Introduce el nombre del nuevo usuario :  ");
							String nombre3 = br.readLine();
							System.out.println( "-->Introduce el apellido del nuevo usuario :  ");
							String apellido3 = br.readLine();
							pstm3.setString(1, nombre3);
							pstm3.setString(2, apellido3);
							pstm3.execute();
							
			            	} catch (IOException  ioe){
			            		 ioe.printStackTrace();
			            		}
		            	
			        break;
		            case '3':
		            	java.sql.ResultSet rs1 = s.executeQuery ("select * from socio_prueba");
			            while (rs1.next())
			            {
			                System.out.println (rs1.getObject("nombre") + " " + rs1.getObject("apellido"));
			            }
			            break;
		            case '4':
		            	java.sql.ResultSet rs2 = s.executeQuery ("select * from empleado_prueba");
			            while (rs2.next())
			            {
			                System.out.println (rs2.getObject("nombre") + " " + rs2.getObject("apellido"));
			            }
		            	
			        break;

		            default: System.out.println("Opción no valida");

		            };
		        }
		            	     
		        } catch (SQLException ex) {
		            System.out.println("Hubo un problema al intentar obetener lo datos");
		        }
				
		

				/**** cerramos la conexión ****/
				con.close();
			}
			
			/**** Excepción que se dispara si falla la carga del driver ****/
			catch( ClassNotFoundException e ) { e.printStackTrace();  }

			/**** Excepción que se dispara si falla la conexión *****/
			catch ( SQLException e) { e.printStackTrace();  }

		}
	}