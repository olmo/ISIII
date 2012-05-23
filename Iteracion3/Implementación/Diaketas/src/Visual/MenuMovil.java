package Visual;

import javax.swing.JPanel;
import javax.swing.JButton;

public class MenuMovil extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuMovil() {
		setLayout(null);
		
		JButton consultarDatosBoton = new JButton("Consultar datos");
		consultarDatosBoton.setBounds(46, 140, 241, 41);
		add(consultarDatosBoton);
		
		JButton bajaBoton = new JButton("Solicitar baja");
		bajaBoton.setBounds(46, 240, 241, 41);
		add(bajaBoton);
		
		JButton donacionesBoton = new JButton("Ver donaciones");
		donacionesBoton.setBounds(46, 340, 241, 41);
		add(donacionesBoton);

	}
}
