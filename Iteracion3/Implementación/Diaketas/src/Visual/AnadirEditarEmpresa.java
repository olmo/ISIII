package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import GestionEmpresaOfertadora.Empresa_Ofertadora;

public class AnadirEditarEmpresa extends JPanel {
	VentanaPrincipal padre;
	PanelInicio ini;
	private JTextField textField;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtLocalidad;
	private JTextField txtEmail;
	private JTextField txtSector;
	private JTextField txtTelefono;
	Empresa_Ofertadora empresa;
	
	public AnadirEditarEmpresa(VentanaPrincipal p, PanelInicio pIni, Empresa_Ofertadora e) {
		ini = pIni;
		padre = p;
		this.empresa = e;
		setSize(PanelInicio.tamanoPaneles);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		
		txtLocalidad = new JTextField();
		txtLocalidad.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		JLabel lblSector = new JLabel("Sector:");
		
		txtSector = new JTextField();
		txtSector.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		
		if(empresa!=null){
			txtNombre.setText(empresa.getNombre());
			txtDireccion.setText(empresa.getDireccion());
			txtLocalidad.setText(empresa.getLocalidad());
			txtEmail.setText(empresa.getEmail());
			txtSector.setText(empresa.getSector());
			txtTelefono.setText(Integer.toString(empresa.getTelefono()));
		}
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(ini.gestion_empresa, PanelInicio.OFERTAS);
			}
		});
		
		JButton btnBaja = new JButton("Dar Baja");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(empresa==null)
					padre.getControladorOfertas().AñadirEmpresaOfertadora(txtNombre.getText(), txtDireccion.getText(), txtEmail.getText(), Integer.valueOf(txtTelefono.getText()), txtLocalidad.getText(), txtSector.getText());
				else
					padre.getControladorOfertas().ModificarEmpresaOfertadora(empresa.getId(), txtNombre.getText(), txtDireccion.getText(), txtEmail.getText(), Integer.valueOf(txtTelefono.getText()), txtLocalidad.getText(), txtSector.getText());
				
				ini.setPanelOnTab(new GestionEmpresa(padre,ini), PanelInicio.OFERTAS);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBuscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(125)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDireccin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblLocalidad, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtLocalidad, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnVolver))
							.addGap(18)
							.addComponent(btnBaja)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(82)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSector, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(txtSector, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblTelfono)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnGuardar)))
					.addContainerGap(343, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblEmail))
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblSector))
								.addComponent(txtSector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblTelfono))
								.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(22)
									.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(25)
									.addComponent(lblDireccin)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblLocalidad))
								.addComponent(txtLocalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(115)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVolver)
						.addComponent(btnBaja)
						.addComponent(btnGuardar))
					.addContainerGap(309, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
