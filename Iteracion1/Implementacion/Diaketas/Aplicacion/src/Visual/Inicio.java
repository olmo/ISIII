package Visual;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Choice;

public class Inicio extends JPanel {
	
	private VentanaPrincipal padre;


	
	public Inicio(VentanaPrincipal p,String usuario) {
		padre=p;
		padre.setusuario(usuario);
		
		textField = new JTextField();
		textField.setColumns(10);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		JPanel panel_3 = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		
		JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
		panel_2.add(btnNuevoUsuario);
		btnNuevoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				padre.getContentPane().add(new NuevoUsuario(padre));
			}
		});
		panel.add(panel_3, BorderLayout.WEST);
		panel_3.add(textField, BorderLayout.WEST);
		final Choice choice = new Choice();
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Busqueda b = new Busqueda(padre);
				String aux=choice.getSelectedItem();
				if(aux.equals("todos"))
					b.setTabla(padre.getcontrolador().buscaPersonas(textField.getText(),null));
				else
					b.setTabla(padre.getcontrolador().buscaPersonas(textField.getText(),aux));
				padre.getContentPane().add(b);
			}
		});
		panel_3.add(btnNewButton, BorderLayout.CENTER);
		
		panel_3.add(choice);
		choice.add("todos");
		choice.add("trabajador");
		choice.add("beneficiario");
		choice.add("donante");
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Bienvenido "+padre.getusuario());
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		JButton btnCerrar = new JButton("Cerrar Sesion");
		panel_1.add(btnCerrar);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

}