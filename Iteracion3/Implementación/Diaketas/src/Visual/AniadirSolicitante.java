package Visual;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import GestionOfertas.ControladorOfertas;
import GestionPersona.Persona;
import GestionPersona.PersonaDB;
import GestionSolicitante.Solicitante.tipo_permiso;
import GestionSolicitante.Solicitante.tipo_disp;

public class AniadirSolicitante extends JPanel {
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal padre;
	private PanelInicio ini;
	private JTextField txtDNI;
	private JTextField txtnombre;
	private JTextField txtfechanac;
	private JTextField txtcodpostal;
	private JTextField txtemail;
	private JTextField txtapellidos;
	private JTextField txtlugarnac;
	private JTextField txtdireccion;
	private JTextField txttelefono;
	private JTextField txtestudios;
	private JTextField txtexperiencia;
	private JTextField txttiempoincor;
	private JTextArea txtcurriculum;
	private JTextField txtapellidos2;
	private Choice textpermisoconduc;
	private JCheckBox checkVehiculo;
	private Choice txtDisponibilidad;

	private ControladorOfertas controladorOfertas = new ControladorOfertas();
	private Persona unaPersonaSolicitante;

	public AniadirSolicitante(VentanaPrincipal p, PanelInicio pIni) {
		this.ini = pIni;
		padre = p;
		setSize(PanelInicio.tamanoPaneles);
		setLayout(null);

		txtDNI = new JTextField();
		txtDNI.setBounds(296, 82, 180, 20);
		add(txtDNI);
		txtDNI.setColumns(10);

		FocusListener listenerDNI = new FocusListener() {
			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent e) {
				unaPersonaSolicitante =	new Persona();
				unaPersonaSolicitante=	PersonaDB.getDatos(txtDNI.getText());
				if(unaPersonaSolicitante != null)
					cargarInfoPersona();
				else
					cargarInfo(false);	//no carga el dni			
			}
		};
		
		txtDNI.addFocusListener(listenerDNI);

		txtnombre = new JTextField();
		txtnombre.setBounds(296, 113, 180, 20);
		add(txtnombre);
		txtnombre.setColumns(10);

		textpermisoconduc = new Choice();
		textpermisoconduc.setBounds(296, 370, 180, 20);
		for (int i = 0; i < tipo_permiso.values().length; i++)
			textpermisoconduc.add(tipo_permiso.values()[i].toString());
		add(textpermisoconduc);

		txtfechanac = new JTextField();
		txtfechanac.setBounds(296, 144, 180, 20);
		add(txtfechanac);
		txtfechanac.setColumns(10);

		txtcodpostal = new JTextField();
		txtcodpostal.setBounds(296, 216, 180, 20);
		add(txtcodpostal);
		txtcodpostal.setColumns(10);

		txtemail = new JTextField();
		txtemail.setBounds(690, 216, 180, 20);
		add(txtemail);
		txtemail.setColumns(10);

		txtapellidos = new JTextField();
		txtapellidos.setColumns(10);
		txtapellidos.setBounds(690, 82, 180, 20);
		add(txtapellidos);

		txtlugarnac = new JTextField();
		txtlugarnac.setColumns(10);
		txtlugarnac.setBounds(690, 148, 180, 20);
		add(txtlugarnac);

		txtdireccion = new JTextField();
		txtdireccion.setColumns(10);
		txtdireccion.setBounds(690, 185, 180, 20);
		add(txtdireccion);

		txtcurriculum = new JTextArea();
		txtcurriculum.setBounds(690, 278, 372, 162);
		add(txtcurriculum);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(181, 85, 46, 14);
		add(lblDNI);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(181, 116, 46, 14);
		add(lblNombre);

		JLabel lblFecha = new JLabel("Fecha nacimiento");
		lblFecha.setBounds(181, 140, 89, 28);
		add(lblFecha);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(181, 179, 46, 14);
		add(lblTelefono);

		JLabel lblcodpostal = new JLabel("C\u00F3digo postal");
		lblcodpostal.setBounds(181, 219, 75, 14);
		add(lblcodpostal);

		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(577, 219, 46, 14);
		add(lblemail);

		JLabel lblapellidos = new JLabel("Apellido 1");
		lblapellidos.setBounds(577, 85, 46, 14);
		add(lblapellidos);

		JLabel lbllugarnac = new JLabel("Lugar nacimiento");
		lbllugarnac.setBounds(577, 151, 89, 14);
		add(lbllugarnac);

		JLabel lbldir = new JLabel("Direcci\u00F3n");
		lbldir.setBounds(577, 188, 46, 14);
		add(lbldir);

		JLabel lbltiempoincor = new JLabel("Tiempo Incorporaci\u00F3n");
		lbltiempoincor.setBounds(577, 248, 103, 14);
		add(lbltiempoincor);

		JLabel lblcurriculum = new JLabel("Curriculum");
		lblcurriculum.setBounds(577, 283, 61, 14);
		add(lblcurriculum);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(427, 482, 89, 23);
		add(btnVolver);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(562, 482, 89, 23);
		add(btnGuardar);

		txttelefono = new JTextField();
		txttelefono.setColumns(10);
		txttelefono.setBounds(296, 175, 180, 20);
		add(txttelefono);

		JLabel lblpermisocond = new JLabel("Permiso Conducir");
		lblpermisocond.setBounds(181, 373, 89, 14);
		add(lblpermisocond);

		JLabel lblestudios = new JLabel("Estudios");
		lblestudios.setBounds(181, 293, 60, 14);
		add(lblestudios);

		JLabel lblexperiencia = new JLabel("Experiencia");
		lblexperiencia.setBounds(181, 324, 73, 14);
		add(lblexperiencia);

		txtestudios = new JTextField();
		txtestudios.setColumns(10);
		txtestudios.setBounds(296, 290, 180, 20);
		add(txtestudios);

		txtexperiencia = new JTextField();
		txtexperiencia.setColumns(10);
		txtexperiencia.setBounds(296, 321, 180, 20);
		add(txtexperiencia);

		JLabel lbldisponibilidad = new JLabel("Disponibilidad");
		lbldisponibilidad.setBounds(181, 254, 89, 14);
		add(lbldisponibilidad);

		txttiempoincor = new JTextField();
		txttiempoincor.setColumns(10);
		txttiempoincor.setBounds(691, 247, 180, 20);
		add(txttiempoincor);

		JLabel lblapellidos2 = new JLabel("Apellido 2");
		lblapellidos2.setBounds(577, 116, 46, 14);
		add(lblapellidos2);

		txtapellidos2 = new JTextField();
		txtapellidos2.setColumns(10);
		txtapellidos2.setBounds(690, 113, 180, 20);
		add(txtapellidos2);

		txtDisponibilidad = new Choice();
		txtDisponibilidad.setBounds(296, 248, 180, 20);
		for (int i = 0; i < tipo_disp.values().length; i++)
			txtDisponibilidad.add(tipo_disp.values()[i].toString());
		add(txtDisponibilidad);

		checkVehiculo = new JCheckBox("Veh\u00EDculo propio");
		checkVehiculo.setBounds(181, 417, 103, 23);
		add(checkVehiculo);

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.setPanelOnTab(ini.gestion_solicitante, PanelInicio.DEMANDAS);
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controladorOfertas.registrarSolicitante(
						txtDNI.getText(),
						txtnombre.getText(),
						txtapellidos.getText(),
						txtapellidos2.getText(),
						txtfechanac.getText(),
						Integer.parseInt(txttelefono.getText()),
						txtlugarnac.getText(),
						txtdireccion.getText(),
						Integer.parseInt(txtcodpostal.getText()),
						true,
						txtemail.getText(),
						txtestudios.getText(),
						txtexperiencia.getText(),
						txtcurriculum.getText(),
						tipo_permiso.values()[textpermisoconduc
								.getSelectedIndex()],
						checkVehiculo.isSelected(),
						tipo_disp.values()[txtDisponibilidad.getSelectedIndex()],
						Integer.parseInt(txttiempoincor.getText()));

				ini.gestion_solicitante.refrescar();
				ini.setPanelOnTab(ini.gestion_solicitante, PanelInicio.DEMANDAS);

			}

		});

	}

	public void cargarInfo(boolean dni) {
		if(dni)
			txtDNI.setText("");
		txtnombre.setText("");
		// textpermisoconduc.select();
		txtfechanac.setText("");
		txtcodpostal.setText("");
		txtemail.setText("");
		txtapellidos.setText("");
		txtlugarnac.setText("");
		txtdireccion.setText("");
		txtcurriculum.setText("");
		txttelefono.setText("");
		txtestudios.setText("");
		txtexperiencia.setText("");
		txttiempoincor.setText("");
		txtapellidos2.setText("");
		// txtDisponibilidad.select();
		checkVehiculo.setSelected(false);
	}
	
	public void cargarInfoPersona(){
		txtnombre.setText(unaPersonaSolicitante.getNombre());
		txtfechanac.setText(unaPersonaSolicitante.getfNacimiento());
		txtcodpostal.setText(unaPersonaSolicitante.getCp().toString());
		txtemail.setText(unaPersonaSolicitante.getemail());
		txtapellidos.setText(unaPersonaSolicitante.getApellido1());
		txtlugarnac.setText(unaPersonaSolicitante.getLugarNacimiento());
		txtdireccion.setText(unaPersonaSolicitante.getDomicilio());
		txttelefono.setText(unaPersonaSolicitante.getTelefono().toString());
		txtapellidos2.setText(unaPersonaSolicitante.getApellido2());

	}
}
