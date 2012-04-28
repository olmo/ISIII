package Visual;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;



public class PanelInicio extends JPanel {

	private VentanaPrincipal padre;
	public JPanel panelUsuarios;
	public JPanel panelDonaciones;
	public JPanel panelAyudas;
	public JPanel panelActuaciones;
	static Dimension tamanoPaneles;
	private static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public PanelInicio(VentanaPrincipal p, String usuario) {
		
		//Inicialización paneles pestañas
		tamanoPaneles = new Dimension(1100, 650);
		panelUsuarios = new JPanel();
		panelUsuarios.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelUsuarios.setSize(tamanoPaneles);
		
		panelDonaciones = new JPanel();
		panelDonaciones.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDonaciones.setSize(tamanoPaneles);
		
		panelAyudas = new JPanel();
		panelAyudas.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelAyudas.setSize(tamanoPaneles);
		
		panelActuaciones = new JPanel();
		panelActuaciones.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelActuaciones.setSize(tamanoPaneles);
		//Fin inicialización
		
		
		setSize(p.getSize());
		this.padre = p;
		padre.setusuario(usuario);
		setLayout(null);
		
		//tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 64, 1180, 636);
		

		panelUsuarios = new PanelPersonas(p, this);

		panelDonaciones = new PanelDonaciones(p, this);
		
		panelActuaciones = new PanelActuaciones(p, this);
		
		panelAyudas = new PanelAyudas(p, this);
		
				
		//setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane, inicio, panel, textField, button, button_1, button_2, scrollPane, button_3, button_4, panel_1, textField_1, button_5, button_6, scrollPane_1, button_7, button_8, panel_2, textField_2, button_9, scrollPane_2, button_10, btnCerrarSesion, label}));
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Home h= new Home(padre);
					padre.getContentPane().removeAll();
					padre.getContentPane().validate();
					padre.getContentPane().add(h);
					padre.getContentPane().repaint();
			}
		});
		btnCerrarSesion.setBounds(1064, 30, 126, 23);
		add(btnCerrarSesion);
		
		JLabel label = new JLabel("Bienvenido "+padre.getusuario());
		label.setBounds(1080, 11, 110, 14);
		add(label);
		
		tabbedPane.addTab("Personas", null, panelUsuarios, "Gestión de personas");
		tabbedPane.addTab("Donaciones", null, panelDonaciones, "Gestión de donaciones");

		tabbedPane.addTab("Ayudas", null, panelAyudas, "Gestión de ayudas");
		tabbedPane.addTab("Actuaciones", null, panelActuaciones, "Gestión de actuaciones");
		
		add(tabbedPane);
		
	}
	
	public static void verPestana(Integer pestana){
		tabbedPane.setSelectedIndex(pestana);
			
	}
}
