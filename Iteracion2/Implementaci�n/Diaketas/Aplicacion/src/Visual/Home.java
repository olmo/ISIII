package Visual;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GestionPersona.CodificacionPW;




public class Home extends JPanel {
	
	private VentanaPrincipal padre;

	
	public Home(VentanaPrincipal mipadre) {
		setSize(mipadre.getSize());
		this.padre=mipadre;
		setLayout(null);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField_1.setBounds(1007, 61, 146, 23);
		add(passwordField_1);
		passwordField_1.setColumns(20);
		
		JLabel lblContrasenha = new JLabel("Contraseņa:");
		lblContrasenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasenha.setBounds(911, 61, 96, 23);
		add(lblContrasenha);
		
		JButton Aceptar = new JButton("Aceptar");
		Aceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Aceptar.setLocation(1007, 95);
		add(Aceptar);
		Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().equals("") && passwordField_1.getText().equals(""))
					Mensaje.setText("Usuario/Contraseņa vacios");
				else{
					CodificacionPW c=new CodificacionPW(passwordField_1.getText());
					if(padre.getcontrolador().introduceDatosInicioSesion(textField.getText(),c.getPassword())){
						PanelInicio panIni= new PanelInicio(padre, textField.getText());
						padre.getContentPane().removeAll();
						padre.getContentPane().validate();
						padre.getContentPane().add(panIni);
						padre.getContentPane().repaint();
					
					}else{
						Mensaje.setText("Usuario/Contraseņa incorrectos");
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
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon((this.getClass().getResource("/img/imagen.jpg"))));
		label.setBounds(205, 115, 625, 464);
		add(label);
		
		}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField passwordField_1;
	private final JLabel Mensaje = new JLabel("Entre con su usuario y contraseņa");
	
	
	
	
	public String getusuario(){
		return textField.getText();
	}
	
	public String getcontrasena(){
		return passwordField_1.getText();
	}
}
