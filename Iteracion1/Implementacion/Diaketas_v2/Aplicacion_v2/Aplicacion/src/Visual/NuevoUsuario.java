package Visual;


import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GestionPersona.Beneficiario;
import GestionPersona.Trabajador;



public class NuevoUsuario extends JPanel {
	private static final long serialVersionUID = 1L;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private VentanaPrincipal padre;
		private JTextField textField_8;
		private JTextField textField_11;
		private JTextField textField_12;
		private JTextField textField_4;
		private JTextField textField_9;
		private JTextField textField_5;
		private JTextField textField_6;
		private JTextField textField_7;
		private JTextField textField_10;
		private JTextField textField_13;
		private JTextField textField_14;
		private JTextField textField_15;
		private JTextField textField_16;
		private JTextField textField_17;
		private JTextField textField_18;
		private JTextField textField_19;
		private Choice choice_3;
		
		private JLabel lblFrecuencia;
		private Choice choice_2;
		private final Choice choice;
		
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
		private JTextField textField_20;
		private JTextField textField_21;

	/**
	 * Create the panel.
	 */
	public NuevoUsuario(VentanaPrincipal p) {

		setSize(1200, 700);
			padre=p;
			setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(696, 189, 246, 23);
			add(textField);
			textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField.setColumns(20);
			
			choice_3 = new Choice();
			choice_3.setBounds(416, 13, 166, 23);
			add(choice_3);
			choice_3.add("todos");
			choice_3.add("trabajador");
			choice_3.add("beneficiario");
			choice_3.add("donante");
			
			JButton btnNewButton = new JButton("Buscar");
			btnNewButton.setBounds(315, 10, 95, 25);
			add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					BusquedaUsuarios b = new BusquedaUsuarios(padre);
					String aux=choice_3.getSelectedItem();
					if(aux.equals("todos"))
						b.setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),null));
					else
						b.setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),aux));
					padre.getContentPane().add(b);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			
			
			JLabel lblNewLabel_4 = new JLabel("Bienvenido "+padre.getusuario());
			lblNewLabel_4.setBounds(1022, 9, 110, 14);
			add(lblNewLabel_4);
			
			JButton btnCerrar = new JButton("Cerrar Sesion");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Home h= new Home(padre);
					setVisible(false);
					padre.getContentPane().add(h);
				}
			});
			btnCerrar.setBounds(1032, 36, 119, 23);
			add(btnCerrar);
			
			JButton button = new JButton("Volver");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BusquedaUsuarios b = new BusquedaUsuarios(padre);
					setVisible(false);
					padre.getContentPane().add(b);
				}
			});
			button.setBounds(479, 565, 156, 28);
			add(button);
			button.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JButton button_1 = new JButton("Guardar");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int id=-1;
					if(textField_1.getText().equals("") || textField_8.getText().equals("")|| textField_4.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Faltan datos");
					}else{
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
			
							dni=textField_1.getText();
							nombre=textField_8.getText();
							apellido1=textField_4.getText();
							String rol=choice.getSelectedItem();
						
							
							if(!(textField_5.getText().equals("") &&textField_20.getText().equals("") && textField_21.getText().equals("")))
							fnac =textField_21.getText()+"-"+textField_20.getText()+"-"+textField_5.getText();
							if(!textField_19.getText().equals(""))
								apellido2=textField_19.getText();
							if(!textField_10.getText().equals(""))
								telefono=new Integer(textField_10.getText());
							if(!textField_7.getText().equals(""))
								lugarnac=textField_7.getText();
							if(!textField.getText().equals(""))
								domicilio=textField.getText();
							if(!textField_9.getText().equals(""))
								cp=new Integer(textField_9.getText());
							if(!textField_2.getText().equals(""))
								email=textField_2.getText();
														
							id=padre.getcontrolador().altaPersona(dni,nombre,apellido1,apellido2,fnac,telefono,lugarnac,domicilio,cp,rol,email);
							
						if(id!=-1){	
							
							DatosUsuario d=new DatosUsuario(padre);
							
							
							if(choice.getSelectedItem().equals("trabajador")){
								padre.getcontrolador().introducirDatosTrabajador(id);
								Trabajador t=padre.getcontrolador().consultarTrabajador(id);
								d.rellenar(t);
								d.modotrabajador();
								
							}else if(choice.getSelectedItem().equals("donante")){
							//	padre.getcontrolador().iniciarAltaDonante(rol) //Se mete el tipo de donante
								//se introducen los datos
							}else if(choice.getSelectedItem().equals("beneficiario")){
								padre.getcontrolador().introducirDatosBeneficiario(id, textField_12.getText(), textField_16.getText(), textField_18.getText(), textField_6.getText(),textField_15.getText(), textField_13.getText(), textField_17.getText(), textField_14.getText());
								Beneficiario t=padre.getcontrolador().consultarBeneficiario(id);
								d.rellenar(t);
								d.modobeneficiario();
							}
							
							setVisible(false);
							padre.getContentPane().add(d);
							
						}
					}
					
				}
			});
			button_1.setBounds(648, 565, 137, 28);
			add(button_1);
			button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JLabel lblDni = new JLabel("DNI:");
			lblDni.setBounds(329, 100, 28, 17);
			add(lblDni);
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_1 = new JTextField();
			textField_1.setBounds(367, 97, 110, 23);
			add(textField_1);
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_1.setColumns(10);
			
			JLabel label_12 = new JLabel("Rol :");
			label_12.setBounds(664, 97, 28, 17);
			add(label_12);
			label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			choice = new Choice();
			choice.setBounds(698, 94, 131, 23);
			add(choice);
			choice.add("trabajador");
			choice.add("beneficiario");
			choice.add("donante");
			
			choice.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(choice.getSelectedItem().equals("donante")){
						lblNewLabel.setVisible(false);
						textField_11.setVisible(false);
						textField_12.setVisible(false);	
						lblNacionalidad.setVisible(false);
						lblEstadoCivil.setVisible(false);
						textField_13.setVisible(false);
						lblEstudios.setVisible(false);
						textField_14.setVisible(false);
						lblSituacionEconomica.setVisible(false);
						textField_15.setVisible(false);
						lblObsPersonales.setVisible(false);
						textField_16.setVisible(false);
						lblObsvivienda.setVisible(false);
						textField_17.setVisible(false);
						lblObsFamiliares.setVisible(false);
						textField_18.setVisible(false);
						button_2.setVisible(false);
						button_3.setVisible(false);
						textField_6.setVisible(false);
						lblFrecuencia.setVisible(true);
						choice_2.setVisible(true);
					}else
						if(choice.getSelectedItem().equals("beneficiario")){
							lblNewLabel.setVisible(true);
							textField_11.setVisible(true);
							textField_12.setVisible(true);	
							lblNacionalidad.setVisible(true);
							lblEstadoCivil.setVisible(true);
							textField_13.setVisible(true);
							lblEstudios.setVisible(true);
							textField_14.setVisible(true);
							lblSituacionEconomica.setVisible(true);
							textField_15.setVisible(true);
							lblObsPersonales.setVisible(true);
							textField_16.setVisible(true);
							lblObsvivienda.setVisible(true);
							textField_17.setVisible(true);
							lblObsFamiliares.setVisible(true);
							textField_18.setVisible(true);
							button_2.setVisible(true);
							button_3.setVisible(true);
							textField_6.setVisible(true);
							lblFrecuencia.setVisible(false);
							choice_2.setVisible(false);
						}else{
							lblNewLabel.setVisible(false);
							textField_11.setVisible(false);
							textField_12.setVisible(false);	
							lblNacionalidad.setVisible(false);
							lblEstadoCivil.setVisible(false);
							textField_13.setVisible(false);
							lblEstudios.setVisible(false);
							textField_14.setVisible(false);
							lblSituacionEconomica.setVisible(false);
							textField_15.setVisible(false);
							lblObsPersonales.setVisible(false);
							textField_16.setVisible(false);
							lblObsvivienda.setVisible(false);
							textField_17.setVisible(false);
							lblObsFamiliares.setVisible(false);
							textField_18.setVisible(false);
							button_2.setVisible(false);
							button_3.setVisible(false);
							lblFrecuencia.setVisible(false);
							choice_2.setVisible(false);
						}
				}
			});
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(303, 128, 54, 17);
			add(lblNombre);
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_2 = new JTextField();
			textField_2.setBounds(367, 269, 150, 23);
			add(textField_2);
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_2.setColumns(50);
			
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(636, 128, 56, 17);
			add(lblApellidos);
			lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_3 = new JTextField();
			textField_3.setBounds(10, 11, 295, 23);
			add(textField_3);
			textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_3.setColumns(15);
			
			JLabel label_1 = new JLabel("Lugar nacimiento:");
			label_1.setBounds(580, 158, 110, 17);
			add(label_1);
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_4 = new JTextField();
			textField_4.setBounds(698, 125, 97, 23);
			add(textField_4);
			textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_4.setColumns(15);
			
			JLabel label_2 = new JLabel("Fecha Nacimiento:");
			label_2.setBounds(250, 161, 112, 17);
			add(label_2);
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_9 = new JTextField();
			textField_9.setBounds(367, 235, 66, 23);
			add(textField_9);
			textField_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_9.setColumns(5);
			
			JLabel label = new JLabel("Telefono:");
			label.setBounds(303, 202, 57, 17);
			add(label);
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_5 = new JTextField();
			textField_5.setBounds(367, 163, 22, 23);
			add(textField_5);
			textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_5.setColumns(2);
			
			JLabel label_3 = new JLabel("Direccion:");
			label_3.setBounds(629, 192, 61, 17);
			add(label_3);
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
						
			JLabel lblNewLabel_3 = new JLabel("Código postal:");
			lblNewLabel_3.setBounds(273, 238, 88, 17);
			add(lblNewLabel_3);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_8 = new JTextField();
			textField_8.setBounds(367, 128, 110, 23);
			add(textField_8);
			textField_8.setColumns(10);
			
			JLabel label_4 = new JLabel("Estado:");
			label_4.setBounds(643, 223, 47, 17);
			add(label_4);
			label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_7 = new JTextField();
			textField_7.setBounds(696, 155, 126, 23);
			add(textField_7);
			textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_7.setColumns(10);
			
			JLabel label_5 = new JLabel("email:");
			label_5.setBounds(327, 269, 35, 17);
			add(label_5);
			label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			textField_10 = new JTextField();
			textField_10.setBounds(367, 201, 110, 23);
			add(textField_10);
			textField_10.setColumns(11);
			
			//Es donante
			lblFrecuencia = new JLabel("Frecuencia:");
			lblFrecuencia.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblFrecuencia.setBounds(178, 362, 64, 20);
			add(lblFrecuencia);
			
			choice_2 = new Choice();
			choice_2.setBounds(248, 362, 109, 20);
			add(choice_2);
			lblFrecuencia.setVisible(false);
			choice_2.setVisible(false);
			
		if(choice.getSelectedItem().equals("donante")){
			lblFrecuencia.setVisible(true);
			choice_2.setVisible(true);
		}

			
				
		//esBeneficiario	
		lblNewLabel = new JLabel("Localidad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(658, 341, 86, 14);
		add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		textField_11 = new JTextField();
		textField_11.setBounds(696, 223, 86, 23);
		add(textField_11);
		textField_11.setColumns(10);
		textField_11.setVisible(false);
				
		lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNacionalidad.setBounds(921, 335, 66, 23);
		add(lblNacionalidad);
		lblNacionalidad.setVisible(false);
				
		textField_12 = new JTextField();
		textField_12.setBounds(716, 338, 136, 20);
		add(textField_12);
		textField_12.setColumns(10);
		textField_12.setVisible(false);
		
		
		textField_6 = new JTextField();
		textField_6.setBounds(988, 341, 126, 20);
		add(textField_6);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setColumns(10);
		textField_6.setVisible(false);
				
		lblEstadoCivil = new JLabel("Estado civil:");
		lblEstadoCivil.setBounds(648, 378, 58, 14);
		add(lblEstadoCivil);
		lblEstadoCivil.setVisible(false);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(988, 402, 181, 20);
		add(textField_13);
		textField_13.setVisible(false);
		
		lblEstudios = new JLabel("Estudios:");
		lblEstudios.setBounds(940, 368, 47, 14);
		add(lblEstudios);
		lblEstudios.setVisible(false);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(988, 433, 181, 20);
		add(textField_14);
		textField_14.setVisible(false);
				
		lblSituacionEconomica = new JLabel("Situacion economica:");
		lblSituacionEconomica.setBounds(606, 405, 109, 14);
		add(lblSituacionEconomica);
		lblSituacionEconomica.setVisible(false);			
		
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(716, 402, 136, 20);
		add(textField_15);
		textField_15.setVisible(false);
		
		lblObsPersonales = new JLabel("Obs. Personales:");
		lblObsPersonales.setBounds(902, 405, 85, 14);
		add(lblObsPersonales);
		lblObsPersonales.setVisible(false);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(716, 371, 136, 20);
		add(textField_16);
		textField_16.setVisible(false);
				
		lblObsvivienda = new JLabel("Obs.Vivienda:");
		lblObsvivienda.setBounds(648, 436, 69, 14);
		add(lblObsvivienda);
		lblObsvivienda.setVisible(false);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(716, 433, 136, 20);
		add(textField_17);
		textField_17.setVisible(false);
		
		lblObsFamiliares = new JLabel("Obs. Familiares:");
		lblObsFamiliares.setBounds(907, 436, 80, 14);
		add(lblObsFamiliares);
		lblObsFamiliares.setVisible(false);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(988, 370, 181, 20);
		add(textField_18);
		textField_18.setVisible(false);
		
		button_2 = new JButton("A\u00F1adir Familiar");
		button_2.setBounds(805, 464, 103, 23);
		add(button_2);
		button_2.setVisible(false);
		
		button_3 = new JButton("Listar Familiares");
		button_3.setBounds(934, 462, 109, 23);
		add(button_3);
		button_3.setVisible(false);
		
	if(choice.getSelectedItem().equals("beneficiario")){
		lblNewLabel.setVisible(true);
		textField_11.setVisible(true);
		textField_12.setVisible(true);	
		lblNacionalidad.setVisible(true);
		lblEstadoCivil.setVisible(true);
		textField_13.setVisible(true);
		lblEstudios.setVisible(true);
		textField_14.setVisible(true);
		lblSituacionEconomica.setVisible(true);
		textField_15.setVisible(true);
		lblObsPersonales.setVisible(true);
		textField_16.setVisible(true);
		lblObsvivienda.setVisible(true);
		textField_17.setVisible(true);
		lblObsFamiliares.setVisible(true);
		textField_18.setVisible(true);
		button_2.setVisible(true);
		button_3.setVisible(true);
		textField_6.setVisible(true);
	}
			
			textField_19 = new JTextField();
			textField_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_19.setColumns(15);
			textField_19.setBounds(805, 125, 97, 23);
			add(textField_19);
			
			textField_20 = new JTextField();
			textField_20.setBounds(399, 163, 22, 23);
			add(textField_20);
			textField_20.setColumns(2);
			
			textField_21 = new JTextField();
			textField_21.setBounds(431, 163, 44, 23);
			add(textField_21);
			textField_21.setColumns(4);


		}
}
