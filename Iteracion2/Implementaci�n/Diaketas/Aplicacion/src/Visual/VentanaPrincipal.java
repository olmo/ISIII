package Visual;



import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import GestionActuacion.ControladorActuaciones;
import GestionAyudas.ControladorAyudas;
import GestionDonaciones.ControladorDonaciones;
import GestionPersona.ControladorPersona;




public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ControladorPersona controlador_personas = new ControladorPersona();
	private ControladorAyudas controlador_ayudas = new ControladorAyudas();
	private ControladorDonaciones controlador_donaciones = new ControladorDonaciones();
	private ControladorActuaciones controlador_actuaciones = new ControladorActuaciones();
	private String trabajador;
	private Home home;
	private BarraProgreso bProgreso;
	
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
		
		new Thread(bProgreso = new BarraProgreso()).start();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
		setResizable(false);
		setLocation(50, 0);
		setSize(700,420);

		//setSize(1200, 700);
		setResizable(false);
		setTitle("Gesti\u00F3n Asociaci\u00F3n Diaketas");
		
		home = new Home(this);
		getContentPane().add(home);
		
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Excepcion: "+e.getMessage());
		}
		
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
	
	public ControladorPersona getControladorPersonas(){
		return controlador_personas;
	}
	public ControladorAyudas getControladorAyudas(){
		return controlador_ayudas;
	}
	public ControladorActuaciones getControladorActuaciones(){
		return controlador_actuaciones;
	}
	public ControladorDonaciones getControladorDonaciones(){
		return controlador_donaciones;
	}
	
	public void actualizaProgreso(String progreso){
		bProgreso.actualizaProgreso(progreso);
	}

}
