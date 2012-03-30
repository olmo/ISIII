package Visual;



import javax.swing.JFrame;
import javax.swing.JPanel;

import GestionPersona.ControladorPersona;




public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private	JPanel panelcontenido;
	
	private ControladorPersona cp=new ControladorPersona();
	private String trabajador;
	
	public VentanaPrincipal() {
		
		cp.getpBD().conectar();
		
		setSize(800, 600);
		setTitle("Gesti\u00F3n Asociaci\u00F3n Diaketas");

		
		panelcontenido= new Home(this);
		
		getContentPane().add(panelcontenido);
		
	}
	
	
	public JPanel getpanelcontenido(){
		return panelcontenido;
	}
	
	public ControladorPersona getcontrolador(){
		return cp;
	}
	
	
	public void setusuario(String s){
		trabajador=s;
	}
	
	public String getusuario(){
		return trabajador;
	}
	

}
