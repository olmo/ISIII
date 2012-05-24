package Visual;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;



public class PanelInicioMovil extends JPanel {

	private VentanaPrincipalMovil padre;
	private MenuMovil menuMovil;
	
	final static int DONACIONES = 0;

	public JPanel menuMovilPanel;
	
	static Dimension tamanoPaneles = new Dimension(600, 350);
	
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public PanelInicioMovil(VentanaPrincipalMovil p, String usuario) {
		
		padre = p;				
		//Fin inicialización	
		setSize(new Dimension(360, 456));
		this.padre = p;
		padre.setusuario(usuario);
		setLayout(null);
		menuMovil = new MenuMovil(padre);
		menuMovil.setLocation(10, 113);
		menuMovil.setSize(334, 237);
		add(menuMovil);
				
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(217, 11, 117, 44);
		add(btnCerrarSesion);
		
		JLabel label = new JLabel("Bienvenido "+padre.getusuario());
		label.setBounds(10, 20, 136, 26);
		add(label);				
		
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					HomeMovil h= new HomeMovil(padre);
					h.setBounds(0, 0, 383, 489);
					padre.getContentPane().removeAll();
					padre.getContentPane().validate();
					padre.getContentPane().add(h);
					padre.getContentPane().repaint();
			}
		});
		
	}
}
