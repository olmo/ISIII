package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditarSolicitante extends JPanel{
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
	private JTextField txtvehiculopropio;
	private JTextField txtestado;
	private JTextField txtdisponibilidad;
	private JTextField txttiempoincor;
	
	public EditarSolicitante(VentanaPrincipal p, PanelInicio pIni) {
		this.ini = pIni;
		padre = p;
		setSize(PanelInicio.tamanoPaneles);
		setLayout(null);
		
		txtBuscar = new JTextField();
		txtBuscar.setToolTipText("T\u00EDtulo, Puesto, Empresa, Fecha Fin, Provincia");
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
		
		JComboBox textpermisoconduc = new JComboBox();
		textpermisoconduc.setBounds(296, 370, 180, 20);
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
		
		JComboBox txtrol = new JComboBox();
		txtrol.setBounds(690, 82, 180, 20);
		add(txtrol);
		
		txtapellidos = new JTextField();
		txtapellidos.setColumns(10);
		txtapellidos.setBounds(690, 113, 180, 20);
		add(txtapellidos);
		
		txtlugarnac = new JTextField();
		txtlugarnac.setColumns(10);
		txtlugarnac.setBounds(690, 144, 180, 20);
		add(txtlugarnac);
		
		txtdireccion = new JTextField();
		txtdireccion.setColumns(10);
		txtdireccion.setBounds(690, 175, 180, 20);
		add(txtdireccion);
		
		JTextArea txtcurriculum = new JTextArea();
		txtcurriculum.setBounds(690, 323, 372, 105);
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
		
		JLabel lblapellidos = new JLabel("Apellidos");
		lblapellidos.setBounds(577, 116, 46, 14);
		add(lblapellidos);
		
		JLabel lbllugarnac = new JLabel("Lugar nacimiento");
		lbllugarnac.setBounds(577, 147, 89, 14);
		add(lbllugarnac);
		
		JLabel lbldir = new JLabel("Direcci\u00F3n");
		lbldir.setBounds(577, 179, 46, 14);
		add(lbldir);
		
		JLabel lbltiempoincor = new JLabel("Tiempo Incorporaci\u00F3n");
		lbltiempoincor.setBounds(577, 293, 103, 14);
		add(lbltiempoincor);
		
		JLabel lblcurriculum = new JLabel("Curriculum");
		lblcurriculum.setBounds(577, 328, 61, 14);
		add(lblcurriculum);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(359, 482, 89, 23);
		add(btnVolver);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(620, 482, 89, 23);
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
		
		JLabel lblvehiculo = new JLabel("Veh\u00EDculo Propio");
		lblvehiculo.setBounds(181, 414, 73, 14);
		add(lblvehiculo);
		
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
		
		txtvehiculopropio = new JTextField();
		txtvehiculopropio.setColumns(10);
		txtvehiculopropio.setBounds(296, 411, 180, 20);
		add(txtvehiculopropio);
		
		JLabel lblestado = new JLabel("Estado");
		lblestado.setBounds(577, 219, 75, 14);
		add(lblestado);
		
		JLabel lbldisponibilidad = new JLabel("Disponibilidad");
		lbldisponibilidad.setBounds(577, 254, 89, 14);
		add(lbldisponibilidad);
		
		txtestado = new JTextField();
		txtestado.setColumns(10);
		txtestado.setBounds(690, 216, 180, 20);
		add(txtestado);
		
		txtdisponibilidad = new JTextField();
		txtdisponibilidad.setColumns(10);
		txtdisponibilidad.setBounds(690, 251, 180, 20);
		add(txtdisponibilidad);
		
		txttiempoincor = new JTextField();
		txttiempoincor.setColumns(10);
		txttiempoincor.setBounds(690, 290, 180, 20);
		add(txttiempoincor);
		
		JButton btnDarBaja = new JButton("Dar Baja");
		btnDarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarSolicitante es= new EliminarSolicitante(padre);
				es.setVisible(true);
				es.setAlwaysOnTop(true);

				if(es.getConfirmacionBorrado()==true){
					try{
						//padre.getControladorPersonas().borrarDatosFamiliar(getId());
						JOptionPane.showMessageDialog(null, "Se ha borrado el solicitante\n");
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Error al borrar solicitante\n"+e1.getMessage());
					}
				}
				
				ini.setPanelOnTab(ini.gestion_solicitante, PanelInicio.DEMANDAS);
			}
		});
		btnDarBaja.setBounds(490, 482, 89, 23);
		add(btnDarBaja);
		
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.setPanelOnTab(ini.gestion_solicitante, PanelInicio.DEMANDAS);
			}
		});
	}
}
