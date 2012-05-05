package Visual;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.PanelUI;

public class PanelPersonas extends JPanel {
	

	private JTextField textField;
	private VentanaPrincipal padre;
	private Choice choice_busqueda;
	private PanelInicio ini;

	
	public PanelPersonas(VentanaPrincipal p,PanelInicio pIni) {
		padre=p;
		ini=pIni;
		
		setSize(PanelInicio.tamanoPaneles);

		setLayout(null);
		
		JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNuevoUsuario.setBounds(693, 13, 145, 23);
		add(btnNuevoUsuario);
		
		textField = new JTextField();
		textField.setToolTipText("Búsqueda por nombre o identificador");
		textField.setBounds(10, 11, 295, 23);
		add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(15);

		
		choice_busqueda = new Choice();
		choice_busqueda.setBounds(416, 13, 166, 23);
		add(choice_busqueda);
		choice_busqueda.add("todos");
		choice_busqueda.add("beneficiario");
		choice_busqueda.add("trabajador");
		choice_busqueda.add("donante-Socio");
		choice_busqueda.add("donante-Empresa");
		choice_busqueda.add("donante-Colaborador");
		
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(315, 10, 95, 25);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//BusquedaUsuarios busU = ini.busqueda_usuarios;
				String aux=choice_busqueda.getSelectedItem();
				if(aux.equals("todos")){
					ini.busqueda_usuarios.setbusqueda(textField.getText(),null);
					ini.busqueda_usuarios.setTabla(padre.getControladorPersonas().BuscarPersonas(textField.getText(),null));
				}else{
					ini.busqueda_usuarios.setTabla(padre.getControladorPersonas().BuscarPersonas(textField.getText(),aux));
					ini.busqueda_usuarios.setbusqueda(textField.getText(),aux);
				}
				
				ini.setPanelOnTab(ini.busqueda_usuarios, PanelInicio.PERSONAS);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		
		
		btnNuevoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				NuevoUsuario nu = ini.nuevo_usuario;
				nu.modotrabajador();
				ini.setPanelOnTab(nu, PanelInicio.PERSONAS);
				//addTab("ini.nuevo_usuario", null, ini.nuevo_usuario, "Gestión de personas");
//
//				ini.panelUsuarios = ini.nuevo_usuario;
//				ini.panelUsuarios.validate();
//				ini.panelUsuarios.repaint();
//				ini.tabbedPane.repaint();
//				ini.repaint();
//				removeAll();
//				NuevoUsuario nU = new NuevoUsuario(padre,ini);
//				nU.modotrabajador();
//				add(nU);
//				validate();
//				repaint();
			}
		});
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}