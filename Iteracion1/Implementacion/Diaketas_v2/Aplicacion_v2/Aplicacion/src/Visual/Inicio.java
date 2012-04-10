package Visual;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Font;

public class Inicio extends JPanel {
	private JTextField textField;
	private VentanaPrincipal padre;
	private Choice choice_3;

	
	public Inicio(VentanaPrincipal p,String usuario) {
		setSize(1200, 700);
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

		
		choice_3 = new Choice();
		choice_3.setBounds(416, 13, 166, 23);
		add(choice_3);
		choice_3.add("todos");
		choice_3.add("beneficiario");
		choice_3.add("trabajador");
		choice_3.add("donante");	
		
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(315, 10, 95, 25);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BusquedaUsuarios b = new BusquedaUsuarios(padre);
				String aux=choice_3.getSelectedItem();
				if(aux.equals("todos")){
					b.setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),null));
				}else{
					b.setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),aux));
				}
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
		btnCerrar.setBounds(1010, 36, 119, 23);
		add(btnCerrar);

		
		
		btnNuevoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				padre.getContentPane().add(new NuevoUsuario(padre));
			}
		});
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}