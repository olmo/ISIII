package Visual;


import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import GestionPersona.CodificacionPW;
import javax.swing.JProgressBar;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;




public class Home extends JPanel {
	
	private VentanaPrincipal padre;

	
	public Home(VentanaPrincipal mipadre) {
		setSize(679,400);
		this.padre=mipadre;
		setLayout(null);
		
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField_1.setBounds(523, 88, 146, 23);
		add(passwordField_1);
		passwordField_1.setColumns(20);
		
		JLabel lblContrasenha = new JLabel("Contraseña:");
		lblContrasenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasenha.setBounds(427, 88, 96, 23);
		add(lblContrasenha);
		
		JButton Aceptar = new JButton("Aceptar");
		Aceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Aceptar.setLocation(523, 122);
		add(Aceptar);
		Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().equals("") && passwordField_1.getText().equals(""))
					Mensaje.setText("Usuario/Contraseña vacios");
				else{
					CodificacionPW c=new CodificacionPW(passwordField_1.getText());
					if(padre.getControladorPersonas().introduceDatosInicioSesion(textField.getText(),c.getPassword())){
						
						PanelInicio panIni= new PanelInicio(padre, textField.getText());
						
						padre.getContentPane().removeAll();
						padre.getContentPane().validate();
						padre.getContentPane().add(panIni);
						padre.setExtendedState(Frame.MAXIMIZED_BOTH);
						padre.getContentPane().repaint();
						
					
					}else{
						Mensaje.setText("Usuario/Contraseña incorrectos");
					}
				}
			}
		});
		Aceptar.setSize(102, 23);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(452, 59, 71, 14);
		add(lblUsuario);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(523, 54, 146, 23);
		add(textField);
		textField.setColumns(20);
		Mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		Mensaje.setBounds(141, 351, 361, 23);
		add(Mensaje);
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon((this.getClass().getResource("/img/diaketas.JPG"))));
		label.setBounds(24, 11, 558, 378);
		add(label);
		
		}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField passwordField_1;
	private final JLabel Mensaje = new JLabel("Entre con su usuario y contraseña");
	
	
	
	
	public String getusuario(){
		return textField.getText();
	}
	
	public String getcontrasena(){
		return passwordField_1.getText();
	}
}
