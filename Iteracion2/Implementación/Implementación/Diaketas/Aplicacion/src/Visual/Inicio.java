package Visual;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Inicio extends JPanel {
	

	private JTextField textField;
	private VentanaPrincipal padre;
	private Choice choice_busqueda;

	
	public Inicio(VentanaPrincipal p,String usuario) {
		setSize(1100,800);
		padre=p;
		padre.setusuario(usuario);
		setLayout(null);
		
		JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNuevoUsuario.setBounds(693, 13, 145, 23);
		add(btnNuevoUsuario);
		
		textField = new JTextField();
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
				padre.panelUsuarios.removeAll();
				padre.panelUsuarios.validate();
				
				padre.panelUsuarios = new BusquedaUsuarios(padre);
				String aux=choice_busqueda.getSelectedItem();
				if(aux.equals("todos")){
					((BusquedaUsuarios) padre.panelUsuarios).setbusqueda(textField.getText(),null);
					((BusquedaUsuarios) padre.panelUsuarios).setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),null));
				}else{
					((BusquedaUsuarios) padre.panelUsuarios).setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),aux));
					((BusquedaUsuarios) padre.panelUsuarios).setbusqueda(textField.getText(),aux);
				}

				padre.panelUsuarios.repaint();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		
		
		btnNuevoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				padre.panelUsuarios.removeAll();
				padre.panelUsuarios.validate();
				
				padre.panelUsuarios = new NuevoUsuario(padre);
				((NuevoUsuario) padre.panelUsuarios).modotrabajador();

				padre.panelUsuarios.repaint();
			}
		});
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}