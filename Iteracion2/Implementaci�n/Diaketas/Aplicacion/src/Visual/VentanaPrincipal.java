package Visual;



import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionAyudas.ControladorAyudas;
import GestionPersona.ControladorPersona;




public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel panelUsuarios;
	public JPanel panelDonaciones;
	public JPanel panelAyudas;
	public JPanel panelActuaciones;
	private ControladorPersona cp = new ControladorPersona();
	private ControladorAyudas ca = new ControladorAyudas();
	//private ControladorDonacion cd = new ControladorDonacion();
	private String trabajador;
	
	public VentanaPrincipal() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int op=JOptionPane.showConfirmDialog(getContentPane(),"¿Quieres Salir?","¿Quieres Salir?",JOptionPane.YES_NO_OPTION);
				if(op==0){
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}				
			}
		});
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
		setLocation(50, 0);
		setSize(1200, 700);
		setResizable(true);
		setTitle("Gesti\u00F3n Asociaci\u00F3n Diaketas");
		
		Dimension tamanoPaneles = new Dimension(1100, 650);
		panelUsuarios = new JPanel();
		panelUsuarios.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelUsuarios.setSize(tamanoPaneles);
		
		panelDonaciones = new JPanel();
		panelDonaciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDonaciones.setSize(tamanoPaneles);
		
		panelAyudas = new JPanel();
		panelAyudas.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelAyudas.setSize(tamanoPaneles);
		
		panelActuaciones = new JPanel();
		panelActuaciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelActuaciones.setSize(tamanoPaneles);
		
		getContentPane().add(new Home(this));
		setExtendedState(MAXIMIZED_BOTH);

		
		
	}
	
	
	public JPanel getpanelcontenido(){
		return (JPanel) getContentPane();
	}
	
	
	public void setusuario(String s){
		trabajador=s;
	}
	
	public String getusuario(){
		return trabajador;
	}
	
	public ControladorPersona getcontrolador(){
		return cp;
	}
	
	public ControladorAyudas getControladorAyudas(){
		return ca;
	}
	
//	public ControladorDonacion getControladorDonacion(){
//		return cd;
//	}

}
