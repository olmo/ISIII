package Visual;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;


import GestionPersona.Beneficiario;
import GestionPersona.CodificacionPW;
import GestionPersona.Colaborador;
import GestionPersona.Empresa;
import GestionPersona.Socio;
import GestionPersona.Trabajador;



import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;



public class DatosUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_domicilio;
	private JTextField textField_dni;
	private JTextField textField_email;
	private JTextField textField_busqueda;
	private VentanaPrincipal padre;
	private JTextField textField_nombre;
	private JTextField textField_cp;
	private JTextField textField_localidad;
	private JTextField textField_apellido1;
	private JTextField textField_estado;
	private JTextField textField_fnacdia;
	private JTextField textField_fnacmes;
	private JTextField textField_fnacano;
	private JTextField textField_nacionalidad;
	private JTextField textField_lugarnac;
	private JTextField textField_tlf;
	private JTextField textField_opersonales;
	private JTextField textField_ofamiliares;
	private JTextField textField_seconomica;
	private JTextField textField_ecivil;
	private JTextField textField_ovivienda;
	private JTextField textField_estudios;
	private JTextField textField_apellido2;
	private Choice choice_busqueda;
	private JLabel lblFrecuencia;

	private Integer id;
	private String rol;
	
	
	private String busquedaanterior;
	private String rolanterior;
	
	//Beneficiario
	private JLabel lblNewLabel;
	private JLabel lblNacionalidad;
	private JLabel lblEstadoCivil;
	private JLabel lblEstudios;
	private JLabel lblSituacionEconomica;
	private JLabel lblObsPersonales;
	private JLabel lblObsvivienda;
	private JLabel lblObsFamiliares;
	private JButton button_anadirfamiliar;
	private JButton button_listargfamiliares;
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
	private JTextField passwordField_1;
	
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
	private JTextField textField_fbaja;
	private JButton btnDarAlta;
	private JButton btn_datbaja;
	
	
	
/**
 * Create the panel.
 */
public DatosUsuario(VentanaPrincipal p) {

	setSize(800, 500);
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
			public void actionPerformed(ActionEvent e) {
			
				BusquedaUsuarios b = new BusquedaUsuarios(padre);
				String aux=choice_busqueda.getSelectedItem();
				if(aux.equals("todos")){
					b.setTabla(padre.getcontrolador().BuscarPersonas(textField_busqueda.getText(),null));
					b.setbusqueda(textField_busqueda.getText(),null);
				}else{
					b.setTabla(padre.getcontrolador().BuscarPersonas(textField_busqueda.getText(),aux));
					b.setbusqueda(textField_busqueda.getText(),aux);
				}
				padre.panelUsuarios.removeAll();
				padre.panelUsuarios.validate();
				padre.panelUsuarios.add(b);
				padre.panelUsuarios.repaint();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Bienvenido "+padre.getusuario());
		lblNewLabel_4.setBounds(1022, 9, 110, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_4);
		
		JButton btnCerrar = new JButton("Cerrar Sesion");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home h= new Home(padre);
				padre.panelUsuarios.removeAll();
				padre.panelUsuarios.validate();
				padre.panelUsuarios.add(h);
				padre.panelUsuarios.repaint();
			}
		});
		btnCerrar.setBounds(1032, 36, 119, 23);
		add(btnCerrar);
		
		JButton button_volver = new JButton("Volver");
		button_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BusquedaUsuarios b = new BusquedaUsuarios(padre);
				b.setTabla(padre.getcontrolador().BuscarPersonas(busquedaanterior, rolanterior));
				
				padre.panelUsuarios.removeAll();
				padre.panelUsuarios.validate();
				padre.panelUsuarios.add(b);
				padre.panelUsuarios.repaint();
				
			}
		});
		button_volver.setBounds(426, 566, 156, 28);
		add(button_volver);
		button_volver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		choice_Rol = new Choice();
		choice_Rol.setBounds(696, 97, 156, 28);
		add(choice_Rol);
		choice_Rol.add("trabajador");
		choice_Rol.add("beneficiario");
		choice_Rol.add("donante-Socio");
		choice_Rol.add("donante-Colaborador");
		choice_Rol.add("donante-Empresa");
		
		JButton button_guardar = new JButton("Guardar");
		button_guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boolean b=true,correcto=false;
				
				if(textField_dni.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Falta DNI");
					b=false;
				}else
				if(textField_nombre.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Falta nombre");
					b=false;
				}else
				if(textField_apellido1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Falta Apellido");
					b=false;
				}else{
					String rol=choice_Rol.getSelectedItem();
					if(rol=="donante-Socio"){
						if(usuario.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Falta usuario");
							b=false;
						}else
						if(passwordField_1.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Falta contraseña");
							b=false;
						}else
							if(text_Periocidad.getText().equals("")){
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
					}else
						if(rol=="donante-Colaborador"){
							if(text_Periocidad.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Falta periocidad");
								b=false;
							}
						}
				}
				if(b){	
				ConfirmarModificacion cm= new ConfirmarModificacion();
				cm.setVisible(true);
				cm.setAlwaysOnTop(true);
				if(cm.getConfirmacionModificacion()){
					
					try{
							int telefono=0,cp=0;
								String fnac="1990-01-01";
								
								if(!textField_tlf.getText().equals(""))
									telefono=new Integer(textField_tlf.getText());
								if(!textField_cp.getText().equals(""))
									cp=new Integer(textField_cp.getText());
								if(!textField_fnacdia.getText().equals("") && !textField_fnacmes.getText().equals("") && !textField_fnacano.getText().equals(""))
									fnac=textField_fnacano.getText()+"-"+textField_fnacmes.getText()+"-"+textField_fnacdia.getText();
								if(rol.equals("trabajador")){
										padre.getcontrolador().modificarDatosTrabajador(id, textField_dni.getText(), textField_nombre.getText(), textField_apellido1.getText(), textField_apellido2.getText(), fnac, telefono, textField_lugarnac.getText(), textField_domicilio.getText(), cp, textField_email.getText());
										correcto=true;
								}else if(rol.equals("beneficiario")){
										padre.getcontrolador().modificarDatosBeneficiario(id, textField_dni.getText(), textField_nombre.getText(), textField_apellido1.getText(), textField_apellido2.getText(), fnac, telefono, textField_lugarnac.getText(), textField_domicilio.getText(), cp, textField_email.getText(),textField_localidad.getText(),textField_ecivil.getText(),textField_estudios.getText(),textField_nacionalidad.getText(),textField_seconomica.getText(),textField_opersonales.getText(),textField_ovivienda.getText(),textField_ofamiliares.getText());
										correcto=true;
								}else if(rol.equals("donante-Socio")) {
									CodificacionPW c=new CodificacionPW(passwordField_1.getText());
									padre.getcontrolador().modificarDatosSocio(id, textField_dni.getText(), textField_nombre.getText(), textField_apellido1.getText(), textField_apellido2.getText(), fnac, telefono, textField_lugarnac.getText(), textField_domicilio.getText(), cp, textField_email.getText(),new Integer(text_Periocidad.getText()),usuario.getText(),c.getPassword());	
								}else if(rol.equals("donante-Empresa")) {
									if(textTelEmp.getText().equals(""))
										textTelEmp.setText("0");
									padre.getcontrolador().modificarDatosEmpresa(id, textField_dni.getText(), textField_nombre.getText(), textField_apellido1.getText(), textField_apellido2.getText(), fnac, telefono, textField_lugarnac.getText(), textField_domicilio.getText(), cp, textField_email.getText(),new Integer(text_Periocidad.getText()),new Integer(textCIF.getText()),textN_Empresa.getText(),new Integer(textTelEmp.getText()),textDirEmp.getText(),textEmail_Emp.getText());	
									correcto=true;
								}else if(rol.equals("donante-Colaborador")) {
									padre.getcontrolador().modificarDatosColaborador(id, textField_dni.getText(), textField_nombre.getText(), textField_apellido1.getText(), textField_apellido2.getText(), fnac, telefono, textField_lugarnac.getText(), textField_domicilio.getText(), cp, textField_email.getText(),new Integer(text_Periocidad.getText()));	
									correcto=true;
								}
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Error al modificar\n"+e1.getMessage());
					}
					
					if(correcto)
						JOptionPane.showMessageDialog(null, "Se ha modificado el usuario correctamente");
					else
						JOptionPane.showMessageDialog(null, "NO se ha modificado el usuario correctamente");

				}

			}
			}
		});
		button_guardar.setBounds(735, 565, 137, 28);
		add(button_guardar);
		button_guardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		btn_datbaja = new JButton("Dar Baja");
		btn_datbaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConfirmarBorradoUsuario cbu= new ConfirmarBorradoUsuario(padre);
				cbu.setVisible(true);
				cbu.setAlwaysOnTop(true);

				
				if(cbu.getConfirmacionBaja()){
			
					try{
						if(cbu.getConfirmacionBorrado()){
							if(rol.equals("trabajador"))
								padre.getcontrolador().borrarDatosTrabajador(id);
							else if(rol.equals("beneficiario"))
								padre.getcontrolador().borrarDatosBeneficiario(id);
							else if(rol.equals("donante-Socio")) {
								padre.getcontrolador().borrarDatosSocio(id);	
							}else if(rol.equals("donante-Empresa")) {
								if(textTelEmp.getText().equals(""))
									textTelEmp.setText("0");
								padre.getcontrolador().borrarDatosEmpresa(id);	
							}else if(rol.equals("donante-Colaborador"))
								padre.getcontrolador().borrarDatosColaborador(id);								
						}else
							padre.getcontrolador().darBaja(id);
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Error al dar de baja\n"+e1.getMessage());
					}
					
					
					
				}
				
				padre.panelUsuarios.removeAll();
				padre.panelUsuarios.validate();
				padre.panelUsuarios.add(new Inicio(padre, padre.getusuario()));
				padre.panelUsuarios.repaint();

			}
		});
		btn_datbaja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_datbaja.setBounds(603, 565, 119, 28);
		add(btn_datbaja);
		
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
			
		textField_domicilio = new JTextField();
		textField_domicilio.setBounds(696, 189, 246, 23);
		add(textField_domicilio);
		textField_domicilio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_domicilio.setColumns(20);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(303, 128, 54, 17);
		add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_email = new JTextField();
		textField_email.setBounds(367, 269, 150, 23);
		add(textField_email);
		textField_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_email.setColumns(50);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(636, 128, 56, 17);
		add(lblApellidos);
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_busqueda = new JTextField();
		textField_busqueda.setBounds(10, 11, 295, 23);
		add(textField_busqueda);
		textField_busqueda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_busqueda.setColumns(15);
		
		JLabel label_1 = new JLabel("Lugar nacimiento:");
		label_1.setBounds(580, 158, 110, 17);
		add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_apellido1 = new JTextField();
		textField_apellido1.setBounds(698, 125, 97, 23);
		add(textField_apellido1);
		textField_apellido1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_apellido1.setColumns(15);
		
		JLabel label_2 = new JLabel("Fecha Nacimiento:");
		label_2.setBounds(250, 161, 112, 17);
		add(label_2);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_cp = new JTextField();
		textField_cp.setBounds(367, 235, 61, 23);
		add(textField_cp);
		textField_cp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_cp.setColumns(5);
		
		JLabel label = new JLabel("Telefono:");
		label.setBounds(303, 202, 57, 17);
		add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_fnacdia = new JTextField();
		textField_fnacdia.setBounds(367, 163, 22, 23);
		add(textField_fnacdia );
		textField_fnacdia .setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_fnacdia .setColumns(2);
		
		JLabel label_3 = new JLabel("Direccion:");
		label_3.setBounds(629, 192, 61, 17);
		add(label_3);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
					
		JLabel lblNewLabel_3 = new JLabel("Código postal:");
		lblNewLabel_3.setBounds(273, 238, 88, 17);
		add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(367, 128, 110, 23);
		add(textField_nombre);
		textField_nombre.setColumns(10);
		textField_nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("Estado:");
		label_4.setBounds(643, 223, 47, 17);
		add(label_4);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_lugarnac = new JTextField();
		textField_lugarnac.setBounds(696, 155, 126, 23);
		add(textField_lugarnac);
		textField_lugarnac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_lugarnac.setColumns(10);
		
		JLabel label_5 = new JLabel("email:");
		label_5.setBounds(327, 269, 35, 17);
		add(label_5);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_tlf = new JTextField();
		textField_tlf.setBounds(367, 201, 110, 23);
		add(textField_tlf);
		textField_tlf.setColumns(11);
		textField_tlf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_estado = new JTextField();
		textField_estado.setBounds(696, 220, 66, 23);
		add(textField_estado);
		textField_estado.setColumns(10);
		textField_estado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//Es donante
		lblFrecuencia = new JLabel("Frecuencia:");
		lblFrecuencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFrecuencia.setBounds(77, 362, 95, 20);
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
		textField_ecivil.setBounds(716, 367, 137, 20);
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
		textField_estudios.setBounds(988, 370, 136, 20);
		add(textField_estudios);
		textField_estudios.setVisible(false);
		
		button_anadirfamiliar = new JButton("A\u00F1adir Familiar");
		button_anadirfamiliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevoFamiliar nf= new NuevoFamiliar(padre,id);
				padre.panelUsuarios.removeAll();
				padre.panelUsuarios.validate();
				padre.panelUsuarios.add(nf);
				padre.panelUsuarios.repaint();
			}
		});
		button_anadirfamiliar.setBounds(752, 464, 156, 23);
		add(button_anadirfamiliar);
		button_anadirfamiliar.setVisible(false);
		
		button_listargfamiliares = new JButton("Listar Familiares");
		button_listargfamiliares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				BusquedaFamiliares bf = new BusquedaFamiliares(padre,id);
				padre.panelUsuarios.removeAll();
				padre.panelUsuarios.validate();
				padre.panelUsuarios.add(bf);
				padre.panelUsuarios.repaint();
			}
		});
		button_listargfamiliares.setBounds(934, 464, 150, 23);
		add(button_listargfamiliares);
		button_listargfamiliares.setVisible(false);
		
			
		textField_apellido2 = new JTextField();
		textField_apellido2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_apellido2.setColumns(15);
		textField_apellido2.setBounds(805, 125, 97, 23);
		add(textField_apellido2);
		
		textField_fnacmes = new JTextField();
		textField_fnacmes.setBounds(399, 163, 22, 23);
		add(textField_fnacmes);
		textField_fnacmes.setColumns(2);
		
		textField_fnacano = new JTextField();
		textField_fnacano.setBounds(431, 163, 44, 23);
		add(textField_fnacano);
		textField_fnacano.setColumns(4);
		
		
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
		
		JLabel lblFechaBaja = new JLabel("Fecha baja:");
		lblFechaBaja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaBaja.setBounds(603, 272, 89, 17);
		add(lblFechaBaja);
		
		textField_fbaja = new JTextField();
		textField_fbaja.setColumns(10);
		textField_fbaja.setBounds(699, 269, 86, 23);
		add(textField_fbaja);
		
		btnDarAlta = new JButton("Dar Alta");
		btnDarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(rol.equals("trabajador"))
						padre.getcontrolador().darAlta(id);
					else if(rol.equals("beneficiario"))
						padre.getcontrolador().darAlta(id);
					else if(rol.equals("donante-Socio"))
						padre.getcontrolador().darAlta(id);
					else if(rol.equals("donante-Empresa"))
						padre.getcontrolador().darAlta(id);
					else if(rol.equals("donante-Colaborador"))
						padre.getcontrolador().darAlta(id);
				
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Error al dar de baja\n"+e1.getMessage());
				}
			}
		});
		btnDarAlta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDarAlta.setBounds(882, 566, 119, 28);
		add(btnDarAlta);
		
		lblParaDonacin = new JLabel("('0' para donaci\u00F3n puntual)");
		lblParaDonacin.setBounds(168, 380, 137, 14);
		add(lblParaDonacin);
			
		btn_datbaja.setVisible(true);
		btn_datbaja.setEnabled(true);	
		
		modotrabajador();

		

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
						modobeneficiario();
					}else
						if(choice_Rol.getSelectedItem().equals("")||choice_Rol.getSelectedItem().equals("trabajador")){
						modoempresa();
					}
			}
		});
	}
	

	//RELLEnar
	public void rellenar(Trabajador t){
		textField_dni.setText(t.getDni());
		textField_nombre.setText(t.getNombre());
		textField_apellido1.setText(t.getApellido1());
		textField_apellido2.setText(t.getApellido2());
		textField_domicilio.setText(t.getDomicilio());
		if(!t.getCp().equals(0))
		textField_cp.setText(t.getCp().toString());
		textField_email.setText(t.getemail());
		if(!t.getfNacimiento().equals("1900-01-01")){
			textField_fnacdia.setText(t.getfNacimiento().substring(8, 10));
			textField_fnacmes.setText(t.getfNacimiento().substring(5, 7));
			textField_fnacano.setText(t.getfNacimiento().substring(0, 4));
		}
		
		if(!t.getfBaja().equals("1900-01-01")){
			textField_fbaja.setText(t.getfBaja());
		}
		
		if(!t.getTelefono().equals(0))
			textField_tlf.setText(t.getTelefono().toString());
		textField_lugarnac.setText(t.getLugarNacimiento());
		textField_estado.setText(t.getEstado().toString());
		if(t.getEstado().equals(true)){
			btnDarAlta.setVisible(false);
			btnDarAlta.setEnabled(false);
		}else{
			btnDarAlta.setVisible(true);
			btnDarAlta.setEnabled(true);
		}
			
		
		choice_Rol.select("trabajador");
		id=t.getId();
		rol="trabajador";
	}
	
	public void rellenar(Beneficiario b){
		textField_dni.setText(b.getDni());
		textField_nombre.setText(b.getNombre());
		textField_apellido1.setText(b.getApellido1());
		textField_apellido2.setText(b.getApellido2());
		textField_domicilio.setText(b.getDomicilio());
		if(!b.getCp().equals(0))
		textField_cp.setText(b.getCp().toString());
		textField_email.setText(b.getemail());
		if(!b.getfNacimiento().equals("1900-01-01")){
			textField_fnacdia.setText(b.getfNacimiento().substring(8, 10));
			textField_fnacmes.setText(b.getfNacimiento().substring(5, 7));
			textField_fnacano.setText(b.getfNacimiento().substring(0, 4));
		}
		
		if(!b.getfBaja().equals("1900-01-01")){
			textField_fbaja.setText(b.getfBaja());
		}
		
		if(!b.getTelefono().equals(0))
			textField_tlf.setText(b.getTelefono().toString());
		
		textField_lugarnac.setText(b.getLugarNacimiento());
		textField_estado.setText(b.getEstado().toString());
		if(b.getEstado().equals(true)){
			btnDarAlta.setVisible(false);
			btnDarAlta.setEnabled(false);
		}else{
			btnDarAlta.setVisible(true);
			btnDarAlta.setEnabled(true);
		}
		
		
		choice_Rol.select("beneficiario");
		
		textField_localidad.setText(b.getLocalidad());
		textField_ecivil.setText(b.geteCivil());
		textField_seconomica.setText(b.getsEconomica());
		textField_ovivienda.setText(b.getObservacionesVivienda());
		textField_ofamiliares.setText(b.getObservacionesFamiliares());
		textField_opersonales.setText(b.getObservacionesPersonales());
		textField_nacionalidad.setText(b.getNacionalidad());
		textField_estudios.setText(b.getnEstudios());
		id=b.getId();
		rol="beneficiario";
	}
	
	public void rellenar(Socio d){
		
		textField_dni.setText(d.getDni());
		textField_nombre.setText(d.getNombre());
		textField_apellido1.setText(d.getApellido1());
		textField_apellido2.setText(d.getApellido2());
		textField_domicilio.setText(d.getDomicilio());
		if(!d.getCp().equals(0))
		textField_cp.setText(d.getCp().toString());
		textField_email.setText(d.getemail());
		if(!d.getfNacimiento().equals("1900-01-01")){
			textField_fnacdia.setText(d.getfNacimiento().substring(8, 10));
			textField_fnacmes.setText(d.getfNacimiento().substring(5, 7));
			textField_fnacano.setText(d.getfNacimiento().substring(0, 4));
		}
		
		if(!d.getfBaja().equals("1900-01-01")){
			textField_fbaja.setText(d.getfBaja());
		}
		
		if(!d.getTelefono().equals(0))
			textField_tlf.setText(d.getTelefono().toString());
		
		textField_lugarnac.setText(d.getLugarNacimiento());
		textField_estado.setText(d.getEstado().toString());
		text_Periocidad.setText(d.getPeriocidad().toString());
		if(d.getEstado().equals(true)){
			btnDarAlta.setVisible(false);
			btnDarAlta.setEnabled(false);
		}else{
			btnDarAlta.setVisible(true);
			btnDarAlta.setEnabled(true);
		}
		
		usuario.setText(d.getUsuario());
		
		choice_Rol.select("donante-Socio");
		id=d.getId();
		rol="donante-Socio";
	}
	
	public void rellenar(Colaborador d){
		
		textField_dni.setText(d.getDni());
		textField_nombre.setText(d.getNombre());
		textField_apellido1.setText(d.getApellido1());
		textField_apellido2.setText(d.getApellido2());
		textField_domicilio.setText(d.getDomicilio());
		if(!d.getCp().equals(0))
		textField_cp.setText(d.getCp().toString());
		textField_email.setText(d.getemail());
		if(!d.getfNacimiento().equals("1900-01-01")){
			textField_fnacdia.setText(d.getfNacimiento().substring(8, 10));
			textField_fnacmes.setText(d.getfNacimiento().substring(5, 7));
			textField_fnacano.setText(d.getfNacimiento().substring(0, 4));
		}
		
		if(!d.getfBaja().equals("1900-01-01")){
			textField_fbaja.setText(d.getfBaja());
		}
		
		if(!d.getTelefono().equals(0))
			textField_tlf.setText(d.getTelefono().toString());
		
		textField_lugarnac.setText(d.getLugarNacimiento());
		textField_estado.setText(d.getEstado().toString());
		text_Periocidad.setText(d.getPeriocidad().toString());
		if(d.getEstado().equals(true)){
			btnDarAlta.setVisible(false);
			btnDarAlta.setEnabled(false);
		}else{
			btnDarAlta.setVisible(true);
			btnDarAlta.setEnabled(true);
		}
		choice_Rol.select("donante-Colaborador");
		id=d.getId();
		rol="donante-Colaborador";
	}
	
	public void rellenar(Empresa d){
		
		textField_dni.setText(d.getDni());
		textField_nombre.setText(d.getNombre());
		textField_apellido1.setText(d.getApellido1());
		textField_apellido2.setText(d.getApellido2());
		textField_domicilio.setText(d.getDomicilio());
		if(!d.getCp().equals(0))
		textField_cp.setText(d.getCp().toString());
		textField_email.setText(d.getemail());
		text_Periocidad.setText(d.getPeriocidad().toString());
		if(!d.getTelefonoEmpresa().equals(null))
			textTelEmp.setText(d.getTelefonoEmpresa().toString());
		if(!d.getfNacimiento().equals("1900-01-01")){
			textField_fnacdia.setText(d.getfNacimiento().substring(8, 10));
			textField_fnacmes.setText(d.getfNacimiento().substring(5, 7));
			textField_fnacano.setText(d.getfNacimiento().substring(0, 4));
		}
		
		if(!d.getfBaja().equals("1900-01-01")){
			textField_fbaja.setText(d.getfBaja());
		}
		
		if(!d.getTelefono().equals(0))
			textField_tlf.setText(d.getTelefono().toString());
		
		textField_lugarnac.setText(d.getLugarNacimiento());
		textField_estado.setText(d.getEstado().toString());
		if(d.getEstado().equals(true)){
			btnDarAlta.setVisible(false);
			btnDarAlta.setEnabled(false);
		}else{
			btnDarAlta.setVisible(true);
			btnDarAlta.setEnabled(true);
		}
	
	
		
		textCIF.setText(d.getCif().toString());	
		textN_Empresa.setText(d.getNombreEmpresa());
		textDirEmp.setText(d.getDireccionEmpresa());
		textEmail_Emp.setText(d.getemailEmpresa());
		
		
		choice_Rol.select("donante-Empresa");
		id=d.getId();
		rol="donante-Empresa";
	}


	public void setbusquedaanterior(String b,String r){
		busquedaanterior=b;
		rolanterior=r;
	}
	
	
	//MODOS
	
	
	public void modobeneficiario(){
		lblNewLabel.setVisible(true);
		//textField_11.setVisible(true);
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
		button_anadirfamiliar.setVisible(true);
		button_listargfamiliares.setVisible(true);
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
		button_anadirfamiliar.setVisible(false);
		button_listargfamiliares.setVisible(false);
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
		lblContrasea.setVisible(false);
		passwordField_1.setVisible(false);
		label_9.setVisible(false);
		label_10.setVisible(false);
		label_11.setVisible(false);
		label_13.setVisible(false);
		label_12.setVisible(false);
		lblParaDonacin.setVisible(false);
	}
	
	public void modoempresa(){
		lblNewLabel.setVisible(false);
		//textField_11.setVisible(false);
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
		button_anadirfamiliar.setVisible(false);
		button_listargfamiliares.setVisible(false);
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
		label_9.setVisible(true);
		label_10.setVisible(false);
		label_11.setVisible(false);
		label_13.setVisible(true);
		label_12.setVisible(true);
		lblParaDonacin.setVisible(true);
	}
	
	public void modosocio(){
		lblNewLabel.setVisible(false);
		//textField_11.setVisible(false);
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
		button_anadirfamiliar.setVisible(false);
		button_listargfamiliares.setVisible(false);
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
		//textField_11.setVisible(false);
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
		button_anadirfamiliar.setVisible(false);
		button_listargfamiliares.setVisible(false);
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
		label_9.setVisible(false);
		label_10.setVisible(false);
		label_11.setVisible(false);
		label_13.setVisible(false);
		label_12.setVisible(true);
		lblParaDonacin.setVisible(true);
	}
	
	
}


