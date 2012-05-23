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




public class VentanaPrincipalMovil extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ControladorDonaciones controlador_donaciones = new ControladorDonaciones();
	private String trabajador;
	private HomeMovil homeMovil;
	private BarraProgreso bProgreso;
	
	public VentanaPrincipalMovil() {
		
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
		setSize(450,572);

		//setSize(1200, 700);
		setResizable(false);
		setTitle("Asociaci\u00F3n Diaketas M\u00F3vil");
		
		homeMovil = new HomeMovil(this);
		getContentPane().add(homeMovil);
		
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
	
	public ControladorDonaciones getControladorDonaciones(){
		return controlador_donaciones;
	}
	
	public void actualizaProgreso(String progreso){
		bProgreso.actualizaProgreso(progreso);
	}

}
