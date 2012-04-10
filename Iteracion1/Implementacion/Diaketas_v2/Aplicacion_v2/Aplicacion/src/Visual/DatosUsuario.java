package Visual;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import GestionPersona.Beneficiario;
import GestionPersona.Donante;
import GestionPersona.Trabajador;

import java.awt.Choice;
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
	private JTextField textField_3;
	private VentanaPrincipal padre;
	private JTextField textField_nombre;
	private JTextField textField_estado;
	private JTextField textField_localidad;
	private JTextField textField_apellido1;
	private JTextField textField_cp;
	private JTextField textField_fnac;
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
	private Choice choice_3;
	private JLabel lblFrecuencia;
	private Choice choice_frecuencia;
	private Integer id;
	private String rol;
	
	
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
	final Choice choice_rol;

/**
 * Create the panel.
 */
public DatosUsuario(VentanaPrincipal p) {

	setSize(1200, 700);
		padre=p;
		setLayout(null);
		
		choice_3=new Choice();
		choice_3.setBounds(416, 13, 166, 23);
		add(choice_3);
		choice_3.add("todos");
		choice_3.add("trabajador");
		choice_3.add("beneficiario");
		choice_3.add("donante");
		
		textField_domicilio = new JTextField();
		textField_domicilio.setBounds(696, 189, 246, 23);
		add(textField_domicilio);
		textField_domicilio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_domicilio.setColumns(20);
		
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
					b.setTabla(padre.getcontrolador().BuscarPersonas(textField_domicilio.getText(),null));
				else
					b.setTabla(padre.getcontrolador().BuscarPersonas(textField_domicilio.getText(),aux));
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
			public void actionPerformed(ActionEvent arg0) {
				BusquedaUsuarios b = new BusquedaUsuarios(padre);
				setVisible(false);
				padre.getContentPane().add(b);
				
			}
		});
		button.setBounds(431, 565, 156, 28);
		add(button);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_1 = new JButton("Guardar");
		button_1.setBounds(735, 565, 137, 28);
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
		
		JLabel label_12 = new JLabel("Rol :");
		label_12.setBounds(664, 97, 28, 17);
		add(label_12);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		choice_rol = new Choice();
		choice_rol.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(choice_rol.getSelectedItem().equals("donante")){
					mododonante();
				}else
					if(choice_rol.getSelectedItem().equals("beneficiario")){
						modobeneficiario();
					}else{
						modotrabajador();
					}
			}
		});
		
		choice_rol.setBounds(698, 94, 131, 23);
		add(choice_rol);
		choice_rol.add("trabajador");
		choice_rol.add("beneficiario");
		choice_rol.add("donante");
		
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
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 11, 295, 23);
		add(textField_3);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(15);
		
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
		textField_cp.setBounds(367, 235, 66, 23);
		add(textField_cp);
		textField_cp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_cp.setColumns(5);
		
		JLabel label = new JLabel("Telefono:");
		label.setBounds(303, 202, 57, 17);
		add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_fnac = new JTextField();
		textField_fnac.setBounds(367, 163, 110, 23);
		add(textField_fnac);
		textField_fnac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_fnac.setColumns(10);
		
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
		
		JLabel label_4 = new JLabel("Estado:");
		label_4.setBounds(643, 223, 47, 17);
		add(label_4);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_estado = new JTextField();
		textField_estado.setBounds(696, 223, 86, 23);
		add(textField_estado);
		textField_estado.setColumns(10);
		
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
		
		
		
		//Es donante
		
			lblFrecuencia = new JLabel("Frecuencia:");
			lblFrecuencia.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblFrecuencia.setBounds(178, 362, 64, 20);
			add(lblFrecuencia);
			
			choice_frecuencia = new Choice();
			choice_frecuencia.setBounds(248, 362, 109, 20);
			add(choice_frecuencia);
			lblFrecuencia.setVisible(false);
			choice_frecuencia.setVisible(false);
			
		if(choice_rol.getSelectedItem().equals("donante")){
			mododonante();
		}
			
		//esBeneficiario
		
			lblNewLabel = new JLabel("Localidad:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel.setBounds(658, 341, 86, 14);
			add(lblNewLabel);
			lblNewLabel.setVisible(false);
						
			lblNacionalidad = new JLabel("Nacionalidad:");
			lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNacionalidad.setBounds(921, 335, 66, 23);
			add(lblNacionalidad);
			lblNacionalidad.setVisible(false);
			
			textField_nacionalidad = new JTextField();
			textField_nacionalidad.setBounds(988, 341, 126, 20);
			add(textField_nacionalidad);
			textField_nacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_nacionalidad.setColumns(10);
			textField_nacionalidad.setVisible(false);
			
			textField_localidad = new JTextField();
			textField_localidad.setBounds(716, 338, 136, 20);
			add(textField_localidad);
			textField_localidad.setColumns(10);
			textField_localidad.setVisible(false);
			
			lblEstadoCivil = new JLabel("Estado civil:");
			lblEstadoCivil.setBounds(648, 378, 58, 14);
			add(lblEstadoCivil);
			lblEstadoCivil.setVisible(false);
			
			textField_opersonales = new JTextField();
			textField_opersonales.setColumns(10);
			textField_opersonales.setBounds(988, 402, 181, 20);
			add(textField_opersonales);
			textField_opersonales.setVisible(false);
			
			lblEstudios = new JLabel("Estudios:");
			lblEstudios.setBounds(940, 368, 47, 14);
			add(lblEstudios);
			lblEstudios.setVisible(false);
			
			textField_ofamiliares = new JTextField();
			textField_ofamiliares.setColumns(10);
			textField_ofamiliares.setBounds(988, 433, 181, 20);
			add(textField_ofamiliares);
			textField_ofamiliares.setVisible(false);
			
			lblSituacionEconomica = new JLabel("Situacion economica:");
			lblSituacionEconomica.setBounds(606, 405, 109, 14);
			add(lblSituacionEconomica);
			lblSituacionEconomica.setVisible(false);			
			
			
			textField_seconomica = new JTextField();
			textField_seconomica.setColumns(10);
			textField_seconomica.setBounds(716, 402, 136, 20);
			add(textField_seconomica);
			textField_seconomica.setVisible(false);
			
			lblObsPersonales = new JLabel("Obs. Personales:");
			lblObsPersonales.setBounds(902, 405, 85, 14);
			add(lblObsPersonales);
			lblObsPersonales.setVisible(false);
			
			textField_ecivil = new JTextField();
			textField_ecivil.setColumns(10);
			textField_ecivil.setBounds(716, 371, 136, 20);
			add(textField_ecivil);
			textField_ecivil.setVisible(false);
			
			lblObsvivienda = new JLabel("Obs.Vivienda:");
			lblObsvivienda.setBounds(648, 436, 69, 14);
			add(lblObsvivienda);
			lblObsvivienda.setVisible(false);
			
			textField_ovivienda = new JTextField();
			textField_ovivienda.setColumns(10);
			textField_ovivienda.setBounds(716, 433, 136, 20);
			add(textField_ovivienda);
			textField_ovivienda.setVisible(false);
			
			lblObsFamiliares = new JLabel("Obs. Familiares:");
			lblObsFamiliares.setBounds(907, 436, 80, 14);
			add(lblObsFamiliares);
			lblObsFamiliares.setVisible(false);
			
			textField_estudios = new JTextField();
			textField_estudios.setColumns(10);
			textField_estudios.setBounds(988, 370, 181, 20);
			add(textField_estudios);
			textField_estudios.setVisible(false);
			
			button_2 = new JButton("A\u00F1adir Familiar");
			button_2.setBounds(805, 464, 119, 23);
			add(button_2);
			button_2.setVisible(false);
			
			button_3 = new JButton("Listar Familiares");
			button_3.setBounds(934, 464, 109, 23);
			add(button_3);
			button_3.setVisible(false);
			
		if(choice_rol.getSelectedItem().equals("beneficiario")){
			modobeneficiario();
		}
			
		
		textField_apellido2 = new JTextField();
		textField_apellido2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_apellido2.setColumns(15);
		textField_apellido2.setBounds(805, 125, 97, 23);
		add(textField_apellido2);
		
		JButton btnNewButton_1 = new JButton("Dar Baja");
		btnNewButton_1.addActionListener(new ActionListener() {
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
							//else if(rol.equals("donante"))
								//padre.getcontrolador().borrarDatosColaborador(id);
							
						}else
							padre.getcontrolador().darBaja(id);
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Error al dar de baja");
					}
					
					
					
				}
				padre.getContentPane().add(new Inicio(padre, padre.getusuario()));
					setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(602, 566, 119, 28);
		add(btnNewButton_1);
	

	}

	public void mododonante() {
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
		choice_frecuencia.setVisible(true);
	}

	public void rellenar(Trabajador t){
		textField_dni.setText(t.getDni());
		textField_nombre.setText(t.getNombre());
		textField_apellido1.setText(t.getApellido1());
		textField_apellido2.setText(t.getApellido2());
		textField_domicilio.setText(t.getDomicilio());
		if(!t.getTelefono().equals(0))
		textField_cp.setText(t.getCp().toString());
		textField_email.setText(t.getemail());
		if(!t.getfNacimiento().equals("1900-01-01"))
		textField_fnac.setText(t.getfNacimiento());
		
		if(!t.getCp().equals(0))
			textField_tlf.setText(t.getTelefono().toString());
		textField_lugarnac.setText(t.getLugarNacimiento());
		textField_estado.setText(t.getEstado().toString());
		choice_rol.select("trabajador");
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
		if(!b.getfNacimiento().equals("1900-01-01"))
			textField_fnac.setText(b.getfNacimiento());
		
		if(!b.getTelefono().equals(0))
			textField_tlf.setText(b.getTelefono().toString());
		
		textField_lugarnac.setText(b.getLugarNacimiento());
		textField_estado.setText(b.getEstado().toString());
		choice_rol.select("beneficiario");
		
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
	
	public void rellenar(Donante d){
		
		textField_dni.setText(d.getDni());
		textField_nombre.setText(d.getNombre());
		textField_apellido1.setText(d.getApellido1());
		textField_apellido2.setText(d.getApellido2());
		textField_domicilio.setText(d.getDomicilio());
		if(!d.getCp().equals(0))
		textField_cp.setText(d.getCp().toString());
		textField_email.setText(d.getemail());
		if(!d.getfNacimiento().equals("1900-01-01"))
			textField_fnac.setText(d.getfNacimiento());
		
		if(!d.getTelefono().equals(0))
			textField_tlf.setText(d.getTelefono().toString());
		
		textField_lugarnac.setText(d.getLugarNacimiento());
		textField_estado.setText(d.getEstado().toString());
		choice_rol.select("donante");
		id=d.getId();
		rol="donante";
	}
	
	public void modobeneficiario(){
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
		choice_frecuencia.setVisible(false);
	}
	
	public void modotrabajador() {
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
		lblFrecuencia.setVisible(false);
		choice_frecuencia.setVisible(false);
		
	}
	

}
