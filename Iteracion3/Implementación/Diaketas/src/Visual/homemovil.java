package Visual;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

public class HomeMovil extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private VentanaPrincipalMovil padre;
	PanelInicio ini;
	/**
	 * Create the panel.
	 */
	public HomeMovil(VentanaPrincipalMovil mipadre) {
		setLayout(null);
		this.padre = mipadre;
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(HomeMovil.class.getResource("/img/imagen.jpg")));
		logoLabel.setBounds(100, 92, 184, 165);
		add(logoLabel);
		
		JLabel usuarioLabel = new JLabel("Usuario:");
		usuarioLabel.setBounds(44, 306, 58, 14);
		add(usuarioLabel);
		
		JLabel passLabel = new JLabel("Contrase\u00F1a:");
		passLabel.setBounds(44, 345, 69, 14);
		add(passLabel);
		
		textField = new JTextField();
		textField.setBounds(123, 303, 136, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 342, 136, 20);
		add(passwordField);
		
		JButton entrarBoton = new JButton("Entrar");
		entrarBoton.setBounds(134, 391, 113, 66);
		add(entrarBoton);
		
		JLabel lblAsociacinDiaketas = new JLabel("Asociaci\u00F3n Diaketas");
		lblAsociacinDiaketas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAsociacinDiaketas.setBounds(100, 48, 195, 33);
		add(lblAsociacinDiaketas);

	}
}
