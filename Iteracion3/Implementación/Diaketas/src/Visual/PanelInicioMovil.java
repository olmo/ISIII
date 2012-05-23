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
	
	//PanelDonacionesMovil panel_donaciones_movil;

	final static int DONACIONES = 0;

	
	//Donaciones
	public JPanel panelDonacionesMovil;

	static Dimension tamanoPaneles = new Dimension(600, 350);
	
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public PanelInicioMovil(VentanaPrincipalMovil p, String usuario) {
		
		padre = p;
		//Inicialización paneles pestañas
				

		
		
		
		
		//aniadir_donacion = new AniadirDonacion(p, this);
		//busqueda_familiares = new BusquedaFamiliares(p, id, pIni);
		//datos_familiar = new DatosFamiliar(p, id, this);
		//nuevo_familiar = new NuevoFamiliar(p, id_bene, this);
		//panel_donaciones = new PanelDonaciones(p, this);
				
		//Fin inicialización
		
		
		setSize(p.getSize());
		this.padre = p;
		padre.setusuario(usuario);
		setLayout(null);
		
		padre.actualizaProgreso("Creando Ventana Principal\n");
		

		//panelDonaciones = panel_donaciones;
		
		
		
				
		//setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane, inicio, panel, textField, button, button_1, button_2, scrollPane, button_3, button_4, panel_1, textField_1, button_5, button_6, scrollPane_1, button_7, button_8, panel_2, textField_2, button_9, scrollPane_2, button_10, btnCerrarSesion, label}));
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					HomeMovil h= new HomeMovil(padre);
					padre.getContentPane().removeAll();
					padre.getContentPane().validate();
					padre.getContentPane().add(h);
					padre.getContentPane().repaint();
					
			}
		});
		
		JPanel panelMenuMovil = new JPanel();
		panelMenuMovil.setBounds(0, 0, 478, 508);
		add(panelMenuMovil);
		btnCerrarSesion.setBounds(350, 30, 117, 72);
		add(btnCerrarSesion);
		
		JLabel label = new JLabel("Bienvenido "+padre.getusuario());
		label.setBounds(150, 11, 136, 26);
		add(label);
		
		padre.actualizaProgreso("Terminado\n");
		//bProgreso.terminado();
		add(panelMenuMovil);
		
	}
}
