package Visual;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		textField.setToolTipText("B�squeda por nombre o identificador");
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
				ini.panelUsuarios.removeAll();
				ini.panelUsuarios.validate();
				BusquedaUsuarios busU = new BusquedaUsuarios(padre,ini);
				String aux=choice_busqueda.getSelectedItem();
				if(aux.equals("todos")){
					busU.setbusqueda(textField.getText(),null);
					busU.setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),null));
				}else{
					busU.setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),aux));
					busU.setbusqueda(textField.getText(),aux);
				}
				
				ini.panelUsuarios.add(busU);
				ini.panelUsuarios.repaint();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		
		
		btnNuevoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
//				padre.panelDonaciones.removeAll();
//				//padre.panelDonaciones.validate();
//				padre.panelDonaciones.add(new AniadirDonacion(padre));
//				padre.panelDonaciones.validate();
//				padre.panelDonaciones.repaint();
				
				ini.panelUsuarios.removeAll();
				NuevoUsuario nU = new NuevoUsuario(padre,ini);
				nU.modotrabajador();
				ini.panelUsuarios.add(nU);
				ini.panelUsuarios.validate();
				ini.panelUsuarios.repaint();
			}
		});
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}