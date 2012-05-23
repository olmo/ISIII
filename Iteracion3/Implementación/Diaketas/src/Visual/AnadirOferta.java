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

public class AnadirOferta extends JPanel{
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal padre;
	private PanelInicio ini;
	private JTextField txtBuscar;
	private JTextField txtTitulo;
	private JTextField txtFecha;
	private JTextField txtPuesto;
	private JTextField txtVacantes;
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private JTextField txtLocalidad;
	private JTextField txtProvincia;
	
	public AnadirOferta(VentanaPrincipal p, PanelInicio pIni) {
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
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(296, 140, 560, 20);
		add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(296, 198, 180, 20);
		add(txtFecha);
		txtFecha.setColumns(10);
		
		JComboBox cbEmpresa = new JComboBox();
		cbEmpresa.setBounds(296, 255, 180, 20);
		add(cbEmpresa);
		
		txtPuesto = new JTextField();
		txtPuesto.setBounds(296, 309, 180, 20);
		add(txtPuesto);
		txtPuesto.setColumns(10);
		
		txtVacantes = new JTextField();
		txtVacantes.setBounds(296, 367, 180, 20);
		add(txtVacantes);
		txtVacantes.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(296, 425, 180, 20);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		JComboBox cbTipoContrato = new JComboBox();
		cbTipoContrato.setBounds(676, 198, 180, 20);
		add(cbTipoContrato);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(676, 251, 180, 20);
		add(txtDireccion);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setColumns(10);
		txtLocalidad.setBounds(676, 309, 180, 20);
		add(txtLocalidad);
		
		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBounds(676, 367, 180, 20);
		add(txtProvincia);
		
		JComboBox cbHorario = new JComboBox();
		cbHorario.setBounds(676, 425, 180, 20);
		add(cbHorario);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(296, 493, 560, 105);
		add(textArea);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setBounds(240, 143, 46, 14);
		add(lblTtulo);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(240, 201, 46, 14);
		add(lblFecha);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(240, 258, 46, 14);
		add(lblEmpresa);
		
		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setBounds(240, 312, 46, 14);
		add(lblPuesto);
		
		JLabel lblVacante = new JLabel("Vacante");
		lblVacante.setBounds(240, 370, 46, 14);
		add(lblVacante);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(240, 428, 46, 14);
		add(lblEmail);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato");
		lblTipoDeContrato.setBounds(577, 201, 89, 14);
		add(lblTipoDeContrato);
		
		JLabel lblNewLabel = new JLabel("Duraci\u00F3n");
		lblNewLabel.setBounds(620, 258, 46, 14);
		add(lblNewLabel);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(620, 312, 46, 14);
		add(lblLocalidad);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(620, 370, 46, 14);
		add(lblProvincia);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(620, 428, 46, 14);
		add(lblHorario);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(225, 498, 61, 14);
		add(lblDescripcin);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(440, 616, 89, 23);
		add(btnVolver);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(577, 616, 89, 23);
		add(btnGuardar);
		
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.setPanelOnTab(ini.panelOfertas, PanelInicio.OFERTAS);
			}
		});
	}
}
