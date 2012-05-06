package Visual;


import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GestionPersona.Beneficiario;
import GestionPersona.Colaborador;
import GestionPersona.Empresa;
import GestionPersona.Socio;
import GestionPersona.Trabajador;



public class NuevoUsuario extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField textField_dni;
	private JTextField textField_email;
	private JTextField textField_busqueda;
	private VentanaPrincipal padre;
	private JTextField textField_nombre;
	private JTextField textField_localidad;
	private JTextField textField_apellido1;
	private JTextField textField_cp;
	private JTextField textField_fnacdia;
	private JTextField textField_fnacmes;
	private JTextField textField_fnacano;
	private JTextField textField_nacionalidad;
	private JTextField textField_lugarnac;
	private JTextField textField_tlf;
	private JTextField textField_domicilio;
	private JTextField textField_opersonales;
	private JTextField textField_ofamiliares;
	private JTextField textField_seconomica;
	private JTextField textField_ecivil;
	private JTextField textField_ovivienda;
	private JTextField textField_estudios;
	private JTextField textField_apellido2;
	private Choice choice_busqueda;
	private JLabel lblFrecuencia;


	
	JLabel lblRepiteContrasea;
	JLabel label_14;
	//Beneficiario
	private JLabel lblNewLabel;
	private JLabel lblNacionalidad;
	private JLabel lblEstadoCivil;
	private JLabel lblEstudios;
	private JLabel lblSituacionEconomica;
	private JLabel lblObsPersonales;
	private JLabel lblObsvivienda;
	private JLabel lblObsFamiliares;
	private JButton button_2;
	private JButton button_3;
	final Choice choice_Rol;
	
	
	private JTextField text_Periocidad;
	//Empresa
	private JLabel lblNewLabel_1;
	private JLabel lblNombreEmpresa;
	private JLabel lblTelfonoEmpresa;
	private JLabel lblDireccinEmpresa;
	private JLabel lblEmailEmpresa;
	private JTextField textCIF;
	private JTextField textN_Empresa;
	private JTextField textTelEmp;
	private JTextField textDirEmp;
	private JTextField textEmail_Emp;
	
	//Socio
	private JLabel lblUsuario;
	private JTextField usuario;
	private JLabel lblContrasea;
	private JPasswordField passwordField_1;
	
	//Asteriscos
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	
	private JLabel lblParaDonacin;
	private JPasswordField passwordField;
	PanelInicio ini;

		

	/**
	 * Create the panel.
	 */
	public NuevoUsuario(VentanaPrincipal p, PanelInicio pini) {
		
			ini=pini;

			setSize(1100, 650);
			padre=p;
			setLayout(null);
			
			
			
			choice_busqueda=new Choice();
			choice_busqueda.setBounds(416, 13, 166, 23);
			add(choice_busqueda);
			choice_busqueda.add("todos");
			choice_busqueda.add("trabajador");
			choice_busqueda.add("beneficiario");
			choice_busqueda.add("donante-Socio");
			choice_busqueda.add("donante-Empresa");
			choice_busqueda.add("donante-Colaborador");
			
			JButton btnNewButton = new JButton("Buscar");
			btnNewButton.setBounds(315, 10, 95, 25);
			add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					//BusquedaUsuarios b = ini.busqueda_usuarios;
					String aux=choice_busqueda.getSelectedItem();
					if(aux.equals("todos")){
						ini.busqueda_usuarios.setTabla(padre.getControladorPersonas().BuscarPersonas(textField_busqueda.getText(),null));
						ini.busqueda_usuarios.setbusqueda(textField_busqueda.getText(),null);
					}else{
						ini.busqueda_usuarios.setTabla(padre.getControladorPersonas().BuscarPersonas(textField_busqueda.getText(),aux));
						ini.busqueda_usuarios.setbusqueda(textField_busqueda.getText(),aux);
					}
					
					

					ini.setPanelOnTab(ini.busqueda_usuarios, PanelInicio.PERSONAS);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			
			
			JButton button = new JButton("Volver");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ini.setPanelOnTab(ini.panel_personas, PanelInicio.PERSONAS);
					
				}
			});
			button.setBounds(479, 565, 156, 28);
			add(button);
			button.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			choice_Rol = new Choice();
			choice_Rol.setBounds(698, 94, 131, 23);
			add(choice_Rol);
			choice_Rol.add("trabajador");
			choice_Rol.add("beneficiario");
			choice_Rol.add("donante-Socio");
			choice_Rol.add("donante-Colaborador");
			choice_Rol.add("donante-Empresa");
			
			JButton button_1 = new JButton("Guardar");
			button_1.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent arg0) {
					int id=-1;
					Boolean b=true;
					
					if(textField_dni.getText().equals("") || textField_dni.getText().length()>11){
						JOptionPane.showMessageDialog(null, "Dni no valido");
						b=false;
					}else
				
					if(textField_nombre.getText().equals("") || textField_nombre.getText().length()>20){
						JOptionPane.showMessageDialog(null, "nombre no no valido");
						b=false;
					}else
					if(textField_apellido1.getText().equals("")|| textField_apellido1.getText().length()>35 || textField_apellido2.getText().length()>35){
						JOptionPane.showMessageDialog(null, "Apellidos no no validos");
						b=false;
					}else{
						String rol=choice_Rol.getSelectedItem();
						if(rol=="donante-Socio"){
							if(usuario.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Falta usuario");
								b=false;
							}else
							if(passwordField_1.getText().equals("") || (passwordField.getText().equals(passwordField_1.getText())==false)){
								JOptionPane.showMessageDialog(null, "Contraseña no valida");
								b=false;
							}else if(text_Periocidad.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Falta periocidad");
								b=false;
							}
						}else if(rol=="donante-Empresa"){
							if(textCIF.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Falta cif");
								b=false;
							}else
							if(textN_Empresa.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Falta nombre de empresa");
								b=false;
							}else
								if(text_Periocidad.getText().equals("")){
									JOptionPane.showMessageDialog(null, "Falta periocidad");
									b=false;
								}
						}else if(rol=="donante-Colaborador"){
							if(text_Periocidad.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Falta periocidad");
								b=false;
							}
						}else
							if(rol=="trabajador"){
								if(usuario.getText().equals("")){
									JOptionPane.showMessageDialog(null, "Falta usuario");
									b=false;
								}else
								if(passwordField_1.getText().equals("") || (passwordField.getText().equals(passwordField_1.getText())==false)){
									JOptionPane.showMessageDialog(null, "Contraseña no valida");
									b=false;
								}
							}
					}
					
					if(b){
						String dni="";
						String nombre="";
						String apellido1="";
						String apellido2="";
						String lugarnac="";
						String domicilio="";
						String email="";
						int telefono=0;
						int cp=0;
						String fnac="1900-01-01";
			
						dni=textField_dni.getText();
						nombre=textField_nombre.getText();
						apellido1=textField_apellido1.getText();
												
						if(!textField_fnacdia.getText().equals("") && !textField_fnacmes.getText().equals("") && !textField_fnacano.getText().equals(""))
							fnac=textField_fnacano.getText()+"-"+textField_fnacmes.getText()+"-"+textField_fnacdia.getText();
							apellido2=textField_apellido2.getText();
						if(!textField_tlf.getText().equals(""))
							telefono=new Integer(textField_tlf.getText());
							lugarnac=textField_lugarnac.getText();
							domicilio=textField_domicilio.getText();
						if(!textField_cp.getText().equals(""))
							cp=new Integer(textField_cp.getText());
							email=textField_email.getText();
				
						id=padre.getControladorPersonas().darAltaPersona(dni,nombre,apellido1,apellido2,fnac,telefono,lugarnac,domicilio,cp,email);
							
						if(id!=-1){	
							
							DatosUsuario d=ini.datos_usuario;
							
							if(choice_Rol.getSelectedItem().equals("trabajador")){
								padre.getControladorPersonas().introducirDatosTrabajador(id,usuario.getText(),passwordField_1.getText());
								Trabajador t=padre.getControladorPersonas().consultarTrabajador(id);
								d.rellenar(t);
								d.modotrabajador();
								
							}else if(choice_Rol.getSelectedItem().equals("donante-Socio")){
								try{
									
									padre.getControladorPersonas().introducirDatosSocio(id,new Integer(text_Periocidad.getText()),usuario.getText(),passwordField_1.getText());
									Socio s=padre.getControladorPersonas().consultarSocio(id);
									d.rellenar(s);
									d.modosocio();
								}catch (Exception e) {
									JOptionPane.showMessageDialog(null, "Error al introducir el socio a la base de datos\n"+e.getMessage());
								}
							}else if(choice_Rol.getSelectedItem().equals("donante-Colaborador")){
								try{
									
									padre.getControladorPersonas().introducirDatosColaborador(id,new Integer(text_Periocidad.getText()));
									Colaborador c=padre.getControladorPersonas().consultarColaborador(id);
									d.rellenar(c);
									d.modocolaborador();
								}catch (Exception e) {
									JOptionPane.showMessageDialog(null, "Error al introducir el colaborador a la base de datos\n"+e.getMessage());
								}								
							}else if(choice_Rol.getSelectedItem().equals("donante-Empresa")){
								try{
									
									if(textTelEmp.getText().equals(""))
										textTelEmp.setText("0");
									String dirEmp=""+textDirEmp.getText(), emaEmp=""+textEmail_Emp.getText();
									padre.getControladorPersonas().introducirDatosEmpresa(id,new Integer(text_Periocidad.getText()), new Integer(textCIF.getText()), textN_Empresa.getText(), new Integer(textTelEmp.getText()), dirEmp, emaEmp);
									Empresa emp=padre.getControladorPersonas().consultarEmpresa(id);
									d.rellenar(emp);
									d.modoempresa();
								}catch (Exception e) {
									JOptionPane.showMessageDialog(null, "Error al introducir la empresa a la base de datos\n"+e.getMessage());
								}							
							}else if(choice_Rol.getSelectedItem().equals("beneficiario")){
								padre.getControladorPersonas().introducirDatosBeneficiario(id, textField_localidad.getText(), textField_ecivil.getText(), textField_estudios.getText(), textField_nacionalidad.getText(),textField_seconomica.getText(), textField_opersonales.getText(), textField_ovivienda.getText(), textField_ofamiliares.getText());
								Beneficiario t=padre.getControladorPersonas().consultarBeneficiario(id);
								d.rellenar(t);
								d.modobeneficiario();
							}
							
							ini.setPanelOnTab(d, PanelInicio.PERSONAS);

							JOptionPane.showMessageDialog(null, "Se ha introducido correctamente el "+choice_Rol.getSelectedItem());
							
						}
					}
					
				}
			});
			
			textField_busqueda = new JTextField();
			textField_busqueda.setBounds(10, 11, 295, 23);
			add(textField_busqueda);
			textField_busqueda.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_busqueda.setColumns(15);
			
			button_1.setBounds(648, 565, 137, 28);
			add(button_1);
			button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JLabel lblDni = new JLabel("DNI:");
			lblDni.setBounds(329, 100, 28, 17);
			add(lblDni);
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_dni = new JTextField();
			textField_dni.setBounds(367, 97, 110, 23);
			add(textField_dni);
			textField_dni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_dni.setColumns(10);
			
			JLabel label_rol = new JLabel("Rol :");
			label_rol.setBounds(664, 97, 28, 17);
			add(label_rol);
			label_rol.setFont(new Font("Tahoma", Font.PLAIN, 14));
						
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(303, 128, 54, 17);
			add(lblNombre);
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_nombre = new JTextField();
			textField_nombre.setBounds(367, 128, 110, 23);
			add(textField_nombre);
			textField_nombre.setColumns(10);
			
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(636, 128, 56, 17);
			add(lblApellidos);
			lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_apellido1 = new JTextField();
			textField_apellido1.setBounds(698, 125, 97, 23);
			add(textField_apellido1);
			textField_apellido1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_apellido1.setColumns(15);
			
			textField_apellido2 = new JTextField();
			textField_apellido2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_apellido2.setColumns(15);
			textField_apellido2.setBounds(805, 125, 97, 23);
			add(textField_apellido2);
			
			JLabel label_1 = new JLabel("Lugar nacimiento:");
			label_1.setBounds(580, 158, 110, 17);
			add(label_1);
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_lugarnac = new JTextField();
			textField_lugarnac.setBounds(696, 155, 126, 23);
			add(textField_lugarnac);
			textField_lugarnac.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_lugarnac.setColumns(10);
			
			JLabel label_2 = new JLabel("Fecha Nacimiento:");
			label_2.setBounds(250, 161, 112, 17);
			add(label_2);
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
				textField_fnacdia = new JTextField();
			textField_fnacdia.setBounds(367, 163, 22, 23);
			add(textField_fnacdia );
			textField_fnacdia .setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_fnacdia .setColumns(2);
			
			textField_fnacmes = new JTextField();
			textField_fnacmes.setBounds(399, 163, 22, 23);
			add(textField_fnacmes);
			textField_fnacmes.setColumns(2);
			
			textField_fnacano = new JTextField();
			textField_fnacano.setBounds(431, 163, 44, 23);
			add(textField_fnacano);
			textField_fnacano.setColumns(4);
			
			JLabel label = new JLabel("Telefono:");
			label.setBounds(303, 202, 57, 17);
			add(label);
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		
			textField_tlf = new JTextField();
			textField_tlf.setBounds(367, 201, 110, 23);
			add(textField_tlf);
			textField_tlf.setColumns(11);
								
			JLabel lblNewLabel_3 = new JLabel("Código postal:");
			lblNewLabel_3.setBounds(273, 238, 88, 17);
			add(lblNewLabel_3);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_cp = new JTextField();
			textField_cp.setBounds(367, 235, 66, 23);
			add(textField_cp);
			textField_cp.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_cp.setColumns(5);
			
			
			
			
			
			
			JLabel label_3 = new JLabel("Direccion:");
			label_3.setBounds(629, 201, 61, 17);
			add(label_3);
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_domicilio = new JTextField();
			textField_domicilio.setBounds(698, 201, 294, 23);
			add(textField_domicilio);
			textField_domicilio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_domicilio.setColumns(20);
			
			JLabel label_5 = new JLabel("email:");
			label_5.setBounds(327, 269, 35, 17);
			add(label_5);
			label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_email = new JTextField();
			textField_email.setBounds(367, 269, 150, 23);
			add(textField_email);
			textField_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_email.setColumns(50);
			
			//Es donante
			lblFrecuencia = new JLabel("Frecuencia:");
			lblFrecuencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFrecuencia.setBounds(72, 360, 97, 20);
			add(lblFrecuencia);
			
			text_Periocidad = new JTextField();
			text_Periocidad.setBounds(169, 362, 109, 20);
			add(text_Periocidad);
			lblFrecuencia.setVisible(false);
			text_Periocidad.setVisible(false);

			
				
		//esBeneficiario	
			
			lblNewLabel = new JLabel("Localidad:");
			lblNewLabel.setBounds(633, 339, 86, 14);
			add(lblNewLabel);
			lblNewLabel.setVisible(false);
			
			
					
			lblNacionalidad = new JLabel("Nacionalidad:");
			lblNacionalidad.setBounds(882, 335, 96, 23);
			add(lblNacionalidad);
			lblNacionalidad.setVisible(false);
			
			textField_localidad = new JTextField();
			textField_localidad.setBounds(716, 338, 136, 20);
			add(textField_localidad);
			textField_localidad.setColumns(10);
			textField_localidad.setVisible(false);
			
			
			textField_nacionalidad = new JTextField();
			textField_nacionalidad.setBounds(988, 341, 126, 20);
			add(textField_nacionalidad);
			textField_nacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_nacionalidad.setColumns(10);
			textField_nacionalidad.setVisible(false);
			
			
		textField_opersonales = new JTextField();
		textField_opersonales.setColumns(10);
		textField_opersonales.setBounds(988, 402, 181, 20);
		add(textField_opersonales);
		textField_opersonales.setVisible(false);
				
		lblEstadoCivil = new JLabel("Estado civil:");
		lblEstadoCivil.setBounds(627, 370, 92, 14);
		add(lblEstadoCivil);
		lblEstadoCivil.setVisible(false);
		
		textField_opersonales = new JTextField();
		textField_opersonales.setColumns(10);
		textField_opersonales.setBounds(988, 402, 181, 20);
		add(textField_opersonales);
		textField_opersonales.setVisible(false);
		
		lblEstudios = new JLabel("Estudios:");
		lblEstudios.setBounds(907, 370, 71, 14);
		add(lblEstudios);
		lblEstudios.setVisible(false);
		
		textField_ofamiliares = new JTextField();
		textField_ofamiliares.setColumns(10);
		textField_ofamiliares.setBounds(988, 433, 181, 20);
		add(textField_ofamiliares);
		textField_ofamiliares.setVisible(false);
				
		lblSituacionEconomica = new JLabel("Situacion economica:");
		lblSituacionEconomica.setBounds(583, 405, 136, 14);
		add(lblSituacionEconomica);
		lblSituacionEconomica.setVisible(false);			
		
		
		textField_seconomica = new JTextField();
		textField_seconomica.setColumns(10);
		textField_seconomica.setBounds(716, 402, 136, 20);
		add(textField_seconomica);
		textField_seconomica.setVisible(false);
		
		lblObsPersonales = new JLabel("Obs. Personales:");
		lblObsPersonales.setBounds(877, 405, 115, 14);
		add(lblObsPersonales);
		lblObsPersonales.setVisible(false);
		
		textField_ecivil = new JTextField();
		textField_ecivil.setColumns(10);
		textField_ecivil.setBounds(716, 367, 136, 20);
		add(textField_ecivil);
		textField_ecivil.setVisible(false);
		
		lblObsvivienda = new JLabel("Obs.Vivienda:");
		lblObsvivienda.setBounds(616, 436, 103, 14);
		add(lblObsvivienda);
		lblObsvivienda.setVisible(false);
		
		textField_ovivienda = new JTextField();
		textField_ovivienda.setColumns(10);
		textField_ovivienda.setBounds(716, 433, 136, 20);
		add(textField_ovivienda);
		textField_ovivienda.setVisible(false);
		
		lblObsFamiliares = new JLabel("Obs. Familiares:");
		lblObsFamiliares.setBounds(882, 436, 110, 14);
		add(lblObsFamiliares);
		lblObsFamiliares.setVisible(false);
		
		textField_estudios = new JTextField();
		textField_estudios.setColumns(10);
		textField_estudios.setBounds(988, 370, 126, 20);
		add(textField_estudios);
		textField_estudios.setVisible(false);
		
		button_2 = new JButton("A\u00F1adir Familiar");
		button_2.setBounds(789, 464, 119, 23);
		add(button_2);
		button_2.setVisible(false);
		
		button_3 = new JButton("Listar Familiares");
		
		button_3.setBounds(934, 462, 131, 23);
		add(button_3);
		button_3.setVisible(false);
		
			
		
		
		
		
		
		//empresa
		
		lblNewLabel_1 = new JLabel("CIF");
		lblNewLabel_1.setBounds(383, 339, 22, 14);
		add(lblNewLabel_1);
		
		textCIF = new JTextField();
		textCIF.setBounds(416, 336, 86, 20);
		add(textCIF);
		textCIF.setColumns(10);
		
		lblNombreEmpresa = new JLabel("Nombre Empresa");
		lblNombreEmpresa.setBounds(300, 365, 110, 14);
		add(lblNombreEmpresa);
		
		textN_Empresa = new JTextField();
		textN_Empresa.setBounds(416, 362, 86, 20);
		add(textN_Empresa);
		textN_Empresa.setColumns(10);
		
		lblTelfonoEmpresa = new JLabel("Tel\u00E9fono Empresa");
		lblTelfonoEmpresa.setBounds(303, 394, 107, 14);
		add(lblTelfonoEmpresa);
		
		textTelEmp = new JTextField();
		textTelEmp.setBounds(416, 391, 86, 20);
		add(textTelEmp);
		textTelEmp.setColumns(10);
		
		lblDireccinEmpresa = new JLabel("Direcci\u00F3n Empresa");
		lblDireccinEmpresa.setBounds(504, 339, 119, 14);
		add(lblDireccinEmpresa);
		
		textDirEmp = new JTextField();
		textDirEmp.setBounds(636, 336, 86, 20);
		add(textDirEmp);
		textDirEmp.setColumns(10);
		
		lblEmailEmpresa = new JLabel("e-mail Empresa");
		lblEmailEmpresa.setBounds(512, 365, 111, 14);
		add(lblEmailEmpresa);
		
		textEmail_Emp = new JTextField();
		textEmail_Emp.setBounds(636, 362, 86, 20);
		add(textEmail_Emp);
		textEmail_Emp.setColumns(10);
		
		
		//Socio
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(431, 346, 46, 14);
		add(lblUsuario);
		
		usuario = new JTextField();
		usuario.setBounds(496, 343, 86, 20);
		add(usuario);
		usuario.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(416, 380, 84, 14);
		add(lblContrasea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(496, 377, 86, 20);
		add(passwordField_1);
		passwordField_1.setColumns(10);
		
		
		
		//obligatorios
		label_6 = new JLabel("(*)");
		label_6.setForeground(Color.RED);
		label_6.setBounds(284, 131, 46, 14);
		add(label_6);
		
		label_7 = new JLabel("(*)");
		label_7.setForeground(Color.RED);
		label_7.setBounds(284, 97, 46, 20);
		add(label_7);
		
		label_8 = new JLabel("(*)");
		label_8.setForeground(Color.RED);
		label_8.setBounds(616, 126, 46, 24);
		add(label_8);
		
		label_9 = new JLabel("(*)");
		label_9.setForeground(Color.RED);
		label_9.setBounds(284, 358, 46, 28);
		add(label_9);
		
		label_10 = new JLabel("(*)");
		label_10.setForeground(Color.RED);
		label_10.setBounds(399, 332, 46, 28);
		add(label_10);
		
		label_11 = new JLabel("(*)");
		label_11.setForeground(Color.RED);
		label_11.setBounds(399, 373, 46, 28);
		add(label_11);
		
		label_13 = new JLabel("(*)");
		label_13.setForeground(Color.RED);
		label_13.setBounds(367, 332, 46, 28);
		add(label_13);
			
		label_12 = new JLabel("(*)");
		label_12.setForeground(Color.RED);
		label_12.setBounds(58, 367, 46, 14);
		add(label_12);	
			
		lblParaDonacin = new JLabel("('0' para donaci\u00F3n puntual)");
		lblParaDonacin.setBounds(100, 391, 166, 14);
		add(lblParaDonacin);	
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(496, 414, 86, 20);
		add(passwordField);
		
		lblRepiteContrasea = new JLabel("Repite Contrase\u00F1a");
		lblRepiteContrasea.setBounds(382, 417, 135, 14);
		add(lblRepiteContrasea);
		
		label_14 = new JLabel("(*)");
		label_14.setForeground(Color.RED);
		label_14.setBounds(364, 410, 46, 28);
		add(label_14);

			

			choice_Rol.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(choice_Rol.getSelectedItem().equals("donante-Colaborador")){
						modocolaborador();
					}else
						if(choice_Rol.getSelectedItem().equals("donante-Socio")){
							modosocio();
						}else
							if(choice_Rol.getSelectedItem().equals("donante-Empresa")){
								modoempresa();
							}else
						if(choice_Rol.getSelectedItem().equals("beneficiario")){
							modobeficiario();
						}else
							if(choice_Rol.getSelectedItem().equals("trabajador")){
							modotrabajador();
						}
				}
			});
		}
	
	public void modobeficiario(){
		lblNewLabel.setVisible(true);
		textField_localidad.setVisible(true);	
		lblNacionalidad.setVisible(true);
		lblEstadoCivil.setVisible(true);
		textField_opersonales.setVisible(true);
		lblEstudios.setVisible(true);
		textField_ofamiliares.setVisible(true);
		lblSituacionEconomica.setVisible(true);
		textField_seconomica.setVisible(true);
		lblObsPersonales.setVisible(true);
		textField_ecivil.setVisible(true);
		lblObsvivienda.setVisible(true);
		textField_ovivienda.setVisible(true);
		lblObsFamiliares.setVisible(true);
		textField_estudios.setVisible(true);
		button_2.setVisible(true);
		button_3.setVisible(true);
		textField_nacionalidad.setVisible(true);
		lblFrecuencia.setVisible(false);
		text_Periocidad.setVisible(false);
		lblNewLabel_1.setVisible(false);
		textCIF.setVisible(false);
		lblNombreEmpresa.setVisible(false);
		textN_Empresa.setVisible(false);
		lblTelfonoEmpresa.setVisible(false);
		textTelEmp.setVisible(false);
		lblDireccinEmpresa.setVisible(false);
		textDirEmp.setVisible(false);
		lblEmailEmpresa.setVisible(false);
		textEmail_Emp.setVisible(false);
		lblUsuario.setVisible(false);
		usuario.setVisible(false);
		lblRepiteContrasea.setVisible(false);
		label_14.setVisible(false);
		passwordField.setVisible(false);
		lblContrasea.setVisible(false);
		passwordField_1.setVisible(false);
		label_9.setVisible(false);
		label_10.setVisible(false);
		label_11.setVisible(false);
		label_13.setVisible(false);
		label_12.setVisible(false);
		lblParaDonacin.setVisible(false);
	}

	public void modotrabajador(){
		lblNewLabel.setVisible(false);
		textField_localidad.setVisible(false);	
		textField_nacionalidad.setVisible(false);
		lblNacionalidad.setVisible(false);
		lblEstadoCivil.setVisible(false);
		textField_opersonales.setVisible(false);
		lblEstudios.setVisible(false);
		textField_ofamiliares.setVisible(false);
		lblSituacionEconomica.setVisible(false);
		textField_seconomica.setVisible(false);
		lblObsPersonales.setVisible(false);
		textField_ecivil.setVisible(false);
		lblObsvivienda.setVisible(false);
		textField_ovivienda.setVisible(false);
		lblObsFamiliares.setVisible(false);
		textField_estudios.setVisible(false);
		button_2.setVisible(false);
		button_3.setVisible(false);
		lblFrecuencia.setVisible(false);
		text_Periocidad.setVisible(false);
		lblNewLabel_1.setVisible(false);
		textCIF.setVisible(false);
		lblNombreEmpresa.setVisible(false);
		textN_Empresa.setVisible(false);
		lblTelfonoEmpresa.setVisible(false);
		textTelEmp.setVisible(false);
		lblDireccinEmpresa.setVisible(false);
		textDirEmp.setVisible(false);
		lblEmailEmpresa.setVisible(false);
		textEmail_Emp.setVisible(false);
		lblUsuario.setVisible(true);
		usuario.setVisible(true);
		lblContrasea.setVisible(true);
		passwordField_1.setVisible(true);
		lblRepiteContrasea.setVisible(true);
		label_14.setVisible(true);
		passwordField.setVisible(true);
		label_9.setVisible(false);
		label_10.setVisible(true);
		label_11.setVisible(true);
		label_13.setVisible(false);
		label_12.setVisible(false);
		lblParaDonacin.setVisible(false);
	}

	public void modoempresa(){
		lblNewLabel.setVisible(false);
		textField_localidad.setVisible(false);	
		lblNacionalidad.setVisible(false);
		lblEstadoCivil.setVisible(false);
		textField_opersonales.setVisible(false);
		lblEstudios.setVisible(false);
		textField_ofamiliares.setVisible(false);
		lblSituacionEconomica.setVisible(false);
		textField_seconomica.setVisible(false);
		lblObsPersonales.setVisible(false);
		textField_ecivil.setVisible(false);
		lblObsvivienda.setVisible(false);
		textField_ovivienda.setVisible(false);
		lblObsFamiliares.setVisible(false);
		textField_estudios.setVisible(false);
		button_2.setVisible(false);
		button_3.setVisible(false);
		textField_nacionalidad.setVisible(false);
		lblFrecuencia.setVisible(true);
		text_Periocidad.setVisible(true);
		lblNewLabel_1.setVisible(true);
		textCIF.setVisible(true);
		lblNombreEmpresa.setVisible(true);
		textN_Empresa.setVisible(true);
		lblTelfonoEmpresa.setVisible(true);
		textTelEmp.setVisible(true);
		lblDireccinEmpresa.setVisible(true);
		textDirEmp.setVisible(true);
		lblEmailEmpresa.setVisible(true);
		textEmail_Emp.setVisible(true);
		lblUsuario.setVisible(false);
		usuario.setVisible(false);
		lblContrasea.setVisible(false);
		passwordField_1.setVisible(false);
		lblRepiteContrasea.setVisible(false);
		label_14.setVisible(false);
		passwordField.setVisible(false);
		label_9.setVisible(true);
		label_10.setVisible(false);
		label_11.setVisible(false);
		label_13.setVisible(true);
		label_12.setVisible(true);
		lblParaDonacin.setVisible(true);
	}

	public void modosocio(){
		lblNewLabel.setVisible(false);
		textField_localidad.setVisible(false);	
		lblNacionalidad.setVisible(false);
		lblEstadoCivil.setVisible(false);
		textField_opersonales.setVisible(false);
		lblEstudios.setVisible(false);
		textField_ofamiliares.setVisible(false);
		lblSituacionEconomica.setVisible(false);
		textField_seconomica.setVisible(false);
		lblObsPersonales.setVisible(false);
		textField_ecivil.setVisible(false);
		lblObsvivienda.setVisible(false);
		textField_ovivienda.setVisible(false);
		lblObsFamiliares.setVisible(false);
		textField_estudios.setVisible(false);
		button_2.setVisible(false);
		button_3.setVisible(false);
		textField_nacionalidad.setVisible(false);
		lblFrecuencia.setVisible(true);
		text_Periocidad.setVisible(true);
		lblNewLabel_1.setVisible(false);
		textCIF.setVisible(false);
		lblNombreEmpresa.setVisible(false);
		textN_Empresa.setVisible(false);
		lblTelfonoEmpresa.setVisible(false);
		textTelEmp.setVisible(false);
		lblDireccinEmpresa.setVisible(false);
		textDirEmp.setVisible(false);
		lblEmailEmpresa.setVisible(false);
		textEmail_Emp.setVisible(false);
		lblUsuario.setVisible(true);
		usuario.setVisible(true);
		lblContrasea.setVisible(true);
		passwordField_1.setVisible(true);
		lblRepiteContrasea.setVisible(true);
		label_14.setVisible(true);
		passwordField.setVisible(true);
		label_9.setVisible(false);
		label_10.setVisible(true);
		label_11.setVisible(true);
		label_12.setVisible(true);
		lblParaDonacin.setVisible(true);
		label_13.setVisible(false);
	}

	public void modocolaborador(){
		lblNewLabel.setVisible(false);
		textField_opersonales.setVisible(false);
		textField_localidad.setVisible(false);	
		lblNacionalidad.setVisible(false);
		lblEstadoCivil.setVisible(false);
		lblEstudios.setVisible(false);
		textField_ofamiliares.setVisible(false);
		lblSituacionEconomica.setVisible(false);
		textField_seconomica.setVisible(false);
		lblObsPersonales.setVisible(false);
		textField_ecivil.setVisible(false);
		lblObsvivienda.setVisible(false);
		textField_ovivienda.setVisible(false);
		lblObsFamiliares.setVisible(false);
		textField_estudios.setVisible(false);
		button_2.setVisible(false);
		button_3.setVisible(false);
		textField_nacionalidad.setVisible(false);
		lblFrecuencia.setVisible(true);
		text_Periocidad.setVisible(true);
		lblNewLabel_1.setVisible(false);
		textCIF.setVisible(false);
		lblNombreEmpresa.setVisible(false);
		textN_Empresa.setVisible(false);
		lblTelfonoEmpresa.setVisible(false);
		textTelEmp.setVisible(false);
		lblDireccinEmpresa.setVisible(false);
		textDirEmp.setVisible(false);
		lblEmailEmpresa.setVisible(false);
		textEmail_Emp.setVisible(false);
		lblUsuario.setVisible(false);
		usuario.setVisible(false);
		lblContrasea.setVisible(false);
		passwordField_1.setVisible(false);
		lblRepiteContrasea.setVisible(false);
		label_14.setVisible(false);
		passwordField.setVisible(false);
		label_9.setVisible(false);
		label_10.setVisible(false);
		label_11.setVisible(false);
		label_13.setVisible(false);
		label_12.setVisible(true);
		lblParaDonacin.setVisible(true);
	}
}
