package Visual;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GestionPersona.ControladorPersona;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private	JPanel panelcontenido;
	

	private ControladorPersona cp = new ControladorPersona();
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
		setResizable(false);
		setTitle("Gesti\u00F3n Asociaci\u00F3n Diaketas");

		panelcontenido= new Home(this);
		getContentPane().add(panelcontenido);
		
	}
	
	
	public JPanel getpanelcontenido(){
		return panelcontenido;
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
	

}
