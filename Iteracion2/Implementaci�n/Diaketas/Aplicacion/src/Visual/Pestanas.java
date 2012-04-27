package Visual;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Pestanas extends JPanel {

	private VentanaPrincipal padre;
	private static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public Pestanas(VentanaPrincipal p, String usuario) {
		setSize(1200, 700);
		this.padre = p;
		padre.setusuario(usuario);
		setLayout(null);
		
		//tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 64, 1180, 636);
		

		padre.panelUsuarios = new Inicio(p, usuario);

		padre.panelDonaciones = new PanelDonaciones(p, usuario);
		
		padre.panelActuaciones = new PanelActuaciones(p, usuario);
		
		padre.panelAyudas = new PanelAyudas(p, usuario);
		
				
		//setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane, inicio, panel, textField, button, button_1, button_2, scrollPane, button_3, button_4, panel_1, textField_1, button_5, button_6, scrollPane_1, button_7, button_8, panel_2, textField_2, button_9, scrollPane_2, button_10, btnCerrarSesion, label}));
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(1064, 30, 126, 23);
		add(btnCerrarSesion);
		
		JLabel label = new JLabel("Bienvenido "+padre.getusuario());
		label.setBounds(1080, 11, 110, 14);
		add(label);
		
		tabbedPane.addTab("Personas", null, padre.panelUsuarios, null);
		tabbedPane.addTab("Donaciones", null, padre.panelDonaciones, null);

		tabbedPane.addTab("Ayudas", null, padre.panelAyudas, null);
		tabbedPane.addTab("Actuaciones", null, padre.panelActuaciones, null);
		
		add(tabbedPane);
		
	}
	
	public static void verPestana(Integer pestana){
		tabbedPane.setSelectedIndex(pestana);
			
	}
}
