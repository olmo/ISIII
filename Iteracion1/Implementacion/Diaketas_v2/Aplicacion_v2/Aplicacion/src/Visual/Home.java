package Visual;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Home extends JPanel {
	
	private VentanaPrincipal padre;

	
	public Home(VentanaPrincipal mipadre) {
		setSize(1200, 700);
		this.padre=mipadre;
		setLayout(null);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField_1.setBounds(1007, 61, 146, 23);
		add(passwordField_1);
		passwordField_1.setColumns(20);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContraseña.setBounds(911, 61, 96, 23);
		add(lblContraseña);
		
		JButton Aceptar = new JButton("Aceptar");
		Aceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Aceptar.setLocation(1007, 95);
		add(Aceptar);
		Aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().equals("") && passwordField_1.getText().equals(""))
					Mensaje.setText("Usuario/Contraseña vacios");
				else{
					if(padre.getcontrolador().introduceDatosInicioSesion(textField.getText(),passwordField_1.getText())){
						setVisible(false);
						padre.getContentPane().add(new Inicio(padre,textField.getText()));
					}else{
						Mensaje.setText("Usuario/Contraseña incorrectos");
					}
				}
			}
		});
		Aceptar.setSize(102, 23);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(936, 32, 71, 14);
		add(lblUsuario);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(1007, 27, 146, 23);
		add(textField);
		textField.setColumns(20);
		Mensaje.setBounds(414, 61, 361, 23);
		add(Mensaje);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(182, 145, 619, 464);
		add(panel);
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
