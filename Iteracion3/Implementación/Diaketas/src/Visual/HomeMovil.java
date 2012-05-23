package Visual;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;

public class HomeMovil extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4832911424114165246L;
	private JTextField textField;
	private JPasswordField passwordField;
	private MenuMovil menuMovil;
	private VentanaPrincipalMovil padre;
	PanelInicioMovil ini;
	/**
	 * Create the panel.
	 */
	public HomeMovil(final VentanaPrincipalMovil mipadre) {
		padre = mipadre;
		setLayout(null);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(HomeMovil.class.getResource("/img/imagen.jpg")));
		logoLabel.setBounds(92, 92, 184, 165);
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
		entrarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelInicioMovil panIni = new PanelInicioMovil(padre,textField.getText());
				//menuMovil = new MenuMovil(padre);
				//menuMovil.setBounds(20, 159, 309, 243);
				
				
				padre.getContentPane().removeAll();
				padre.getContentPane().validate();
				padre.getContentPane().add(panIni);
				//padre.setExtendedState(Frame.MAXIMIZED_BOTH);
				padre.getContentPane().repaint();
			}
		});
		entrarBoton.setBounds(134, 391, 113, 66);
		add(entrarBoton);
		
		JLabel lblAsociacinDiaketas = new JLabel("Asociaci\u00F3n Diaketas");
		lblAsociacinDiaketas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAsociacinDiaketas.setBounds(100, 48, 195, 33);
		add(lblAsociacinDiaketas);

	}
}
