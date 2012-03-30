package Visual;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JPanel {
	
	private VentanaPrincipal padre;

	
	public Home(VentanaPrincipal mipadre) {
		this.padre=mipadre;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.EAST);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel_6.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		passwordField_1 = new JPasswordField();
		panel_5.add(passwordField_1, BorderLayout.EAST);
		passwordField_1.setColumns(20);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		panel_5.add(lblContraseña, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_5.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton Aceptar = new JButton("Aceptar");
		Aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().equals("") && passwordField_1.getText().equals(""))
					Mensaje.setText("Usuario/Contraseña vacios");
				else{
					if(padre.getcontrolador().introducirDatosInicioSesion(textField.getText(),passwordField_1.getText())){
						setVisible(false);
						padre.getContentPane().add(new Inicio(padre,textField.getText()));
					}else{
						Mensaje.setText("Usuario/Contraseña incorrectos");
					}
				}
			}
		});
		panel_4.add(Aceptar);
		Aceptar.setSize(30, 20);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		panel_7.add(lblUsuario, BorderLayout.CENTER);
		
		textField = new JTextField();
		panel_7.add(textField, BorderLayout.EAST);
		textField.setColumns(20);
		panel.add(Mensaje, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.CENTER);
		
		panel_3.setSize(566,473);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField passwordField_1;
	private final JLabel Mensaje = new JLabel("");
	
	
	
	
	public String getusuario(){
		return textField.getText();
	}
	
	public String getcontrasena(){
		return passwordField_1.getText();
	}

}
