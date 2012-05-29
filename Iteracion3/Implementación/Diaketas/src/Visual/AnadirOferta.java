package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import GestionEmpresaOfertadora.Empresa_Ofertadora;
import GestionOfertas.Oferta;

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
	private JTextField txtDuracion;
	private JTextField txtLocalidad;
	private JTextField txtProvincia;
	private JComboBox cbEmpresa;
	private JTextArea textArea;
	private JComboBox cbTipoContrato;
	private JComboBox cbHorario;
	
	Oferta oferta;
	
	public AnadirOferta(VentanaPrincipal p, PanelInicio pIni, Oferta o) {
		this.ini = pIni;
		padre = p;
		oferta = o;
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
		txtTitulo.setBounds(297, 81, 560, 20);
		add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(297, 139, 180, 20);
		add(txtFecha);
		txtFecha.setColumns(10);
		
		cbEmpresa = new JComboBox();
		cbEmpresa.setBounds(297, 196, 180, 20);
		add(cbEmpresa);
		
		txtPuesto = new JTextField();
		txtPuesto.setBounds(297, 250, 180, 20);
		add(txtPuesto);
		txtPuesto.setColumns(10);
		
		txtVacantes = new JTextField();
		txtVacantes.setBounds(297, 308, 180, 20);
		add(txtVacantes);
		txtVacantes.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(297, 366, 180, 20);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		cbTipoContrato = new JComboBox();
		cbTipoContrato.setBounds(677, 139, 180, 20);
		add(cbTipoContrato);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(677, 192, 180, 20);
		add(txtDuracion);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setColumns(10);
		txtLocalidad.setBounds(677, 250, 180, 20);
		add(txtLocalidad);
		
		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBounds(677, 308, 180, 20);
		add(txtProvincia);
		
		cbHorario = new JComboBox();
		cbHorario.setBounds(677, 366, 180, 20);
		add(cbHorario);
		
		textArea = new JTextArea();
		textArea.setBounds(297, 434, 560, 105);
		add(textArea);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setBounds(241, 84, 46, 14);
		add(lblTtulo);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(241, 142, 46, 14);
		add(lblFecha);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(241, 199, 46, 14);
		add(lblEmpresa);
		
		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setBounds(241, 253, 46, 14);
		add(lblPuesto);
		
		JLabel lblVacante = new JLabel("Vacante");
		lblVacante.setBounds(241, 311, 46, 14);
		add(lblVacante);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(241, 369, 46, 14);
		add(lblEmail);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato");
		lblTipoDeContrato.setBounds(578, 142, 89, 14);
		add(lblTipoDeContrato);
		
		JLabel lblNewLabel = new JLabel("Duraci\u00F3n");
		lblNewLabel.setBounds(621, 199, 46, 14);
		add(lblNewLabel);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(621, 253, 46, 14);
		add(lblLocalidad);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(621, 311, 46, 14);
		add(lblProvincia);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(621, 369, 46, 14);
		add(lblHorario);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(226, 439, 61, 14);
		add(lblDescripcin);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(441, 557, 89, 23);
		add(btnVolver);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(578, 557, 89, 23);
		add(btnGuardar);
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(oferta==null)
					padre.getControladorOfertas().RegistrarOferta(((Empresa_Ofertadora)cbEmpresa.getSelectedItem()).getId(), txtTitulo.getText(), textArea.getText(), txtPuesto.getText(), Integer.valueOf(txtVacantes.getText()), (String)cbTipoContrato.getSelectedItem(), Integer.valueOf(txtDuracion.getText()), Timestamp.valueOf(txtFecha.getText()), txtLocalidad.getText(), txtProvincia.getText(), (String)cbHorario.getSelectedItem(), txtEmail.getText());
				else
					padre.getControladorOfertas().ModificarOferta(oferta.getId(), ((Empresa_Ofertadora)cbEmpresa.getSelectedItem()).getId(), txtTitulo.getText(), textArea.getText(), txtPuesto.getText(), Integer.valueOf(txtVacantes.getText()), (String)cbTipoContrato.getSelectedItem(), Integer.valueOf(txtDuracion.getText()), Timestamp.valueOf(txtFecha.getText()), txtLocalidad.getText(), txtProvincia.getText(), (String)cbHorario.getSelectedItem(), txtEmail.getText());
				
				ini.setPanelOnTab(new PanelOfertas(padre,ini), PanelInicio.OFERTAS);
			}
		});
		
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.setPanelOnTab(ini.panel_ofertas, PanelInicio.OFERTAS);
			}
		});
	}
}
