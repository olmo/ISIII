package Visual;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import GestionOfertas.ControladorOfertas;
import GestionSolicitante.Solicitante;
import GestionSolicitante.SolicitanteDB;
import GestionSolicitante.Solicitante.tipo_permiso;
import GestionSolicitante.Solicitante.tipo_disp;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;

public class AniadirSolicitante extends JPanel {
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal padre;
	private PanelInicio ini;
	private JTextField txtBuscar;
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
	private JTextField txtestado;
	private JTextField txttiempoincor;
	private JTextArea txtcurriculum;
	private JTextField txtapellidos2;
	private Choice textpermisoconduc;
	private JCheckBox checkVehiculo;
	private Choice txtDisponibilidad;
	private Choice txtrol;

	private ControladorOfertas controladorOfertas = new ControladorOfertas();

	public AniadirSolicitante(VentanaPrincipal p, PanelInicio pIni) {
		this.ini = pIni;
		padre = p;
		setSize(PanelInicio.tamanoPaneles);
		setLayout(null);

		txtBuscar = new JTextField();
		txtBuscar
				.setToolTipText("T\u00EDtulo, Puesto, Empresa, Fecha Fin, Provincia");
		txtBuscar.setBounds(39, 36, 560, 20);
		add(txtBuscar);
		txtBuscar.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(620, 35, 89, 23);
		add(btnBuscar);

		txtDNI = new JTextField();
		txtDNI.setBounds(296, 82, 180, 20);
		add(txtDNI);
		txtDNI.setColumns(10);

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
		txtemail.setBounds(296, 251, 180, 20);
		add(txtemail);
		txtemail.setColumns(10);

		txtrol = new Choice();
		txtrol.setBounds(690, 82, 180, 20);
		txtrol.add("trabajador");
		txtrol.add("beneficiario");
		txtrol.add("donante-Socio");
		txtrol.add("donante-Colaborador");
		txtrol.add("donante-Empresa");
		add(txtrol);

		txtapellidos = new JTextField();
		txtapellidos.setColumns(10);
		txtapellidos.setBounds(690, 113, 180, 20);
		add(txtapellidos);

		txtlugarnac = new JTextField();
		txtlugarnac.setColumns(10);
		txtlugarnac.setBounds(690, 179, 180, 20);
		add(txtlugarnac);

		txtdireccion = new JTextField();
		txtdireccion.setColumns(10);
		txtdireccion.setBounds(690, 216, 180, 20);
		add(txtdireccion);

		txtcurriculum = new JTextArea();
		txtcurriculum.setBounds(689, 352, 372, 105);
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
		lblemail.setBounds(181, 254, 46, 14);
		add(lblemail);

		JLabel lblrol = new JLabel("Rol");
		lblrol.setBounds(577, 85, 89, 14);
		add(lblrol);

		JLabel lblapellidos = new JLabel("Apellido 1");
		lblapellidos.setBounds(577, 116, 46, 14);
		add(lblapellidos);

		JLabel lbllugarnac = new JLabel("Lugar nacimiento");
		lbllugarnac.setBounds(577, 182, 89, 14);
		add(lbllugarnac);

		JLabel lbldir = new JLabel("Direcci\u00F3n");
		lbldir.setBounds(577, 219, 46, 14);
		add(lbldir);

		JLabel lbltiempoincor = new JLabel("Tiempo Incorporaci\u00F3n");
		lbltiempoincor.setBounds(576, 322, 103, 14);
		add(lbltiempoincor);

		JLabel lblcurriculum = new JLabel("Curriculum");
		lblcurriculum.setBounds(576, 357, 61, 14);
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

		JLabel lblestado = new JLabel("Estado");
		lblestado.setBounds(577, 254, 75, 14);
		add(lblestado);

		JLabel lbldisponibilidad = new JLabel("Disponibilidad");
		lbldisponibilidad.setBounds(577, 293, 89, 14);
		add(lbldisponibilidad);

		txtestado = new JTextField();
		txtestado.setColumns(10);
		txtestado.setBounds(690, 251, 180, 20);
		add(txtestado);

		txttiempoincor = new JTextField();
		txttiempoincor.setColumns(10);
		txttiempoincor.setBounds(690, 321, 180, 20);
		add(txttiempoincor);

		JLabel lblapellidos2 = new JLabel("Apellido 2");
		lblapellidos2.setBounds(577, 147, 46, 14);
		add(lblapellidos2);

		txtapellidos2 = new JTextField();
		txtapellidos2.setColumns(10);
		txtapellidos2.setBounds(690, 144, 180, 20);
		add(txtapellidos2);

		txtDisponibilidad = new Choice();
		txtDisponibilidad.setBounds(690, 290, 180, 20);
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
				ini.setPanelOnTab(ini.gestion_solicitante, PanelInicio.DEMANDAS);

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
						false,
						txtemail.getText(),
						txtestudios.getText(),
						txtexperiencia.getText(),
						txtcurriculum.getText(),
						tipo_permiso.values()[textpermisoconduc
								.getSelectedIndex()],
						checkVehiculo.isSelected(),
						tipo_disp.values()[txtDisponibilidad.getSelectedIndex()],
						Integer.parseInt(txttiempoincor.getText()));

			}
		});
	}
}
