package Visual;



import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import GestionPersona.ControladorMovil;




public class VentanaPrincipalMovil extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ControladorMovil controlador_movil = new ControladorMovil();
	private String socio;
	private HomeMovil homeMovil;
	private Integer idSesion;

	//private DonacionesMovil donacionesmovil;
	
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
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
		setResizable(false);
		setLocation(50, 0);
		setSize(372,565);

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
	
	public ControladorMovil getControladorMovil(){
		return controlador_movil;
	}
	
	public JPanel getpanelcontenido(){
		return (JPanel) getContentPane();
	}
	
	
	public void setusuario(String s){
		socio=s;
	}
	
	public String getusuario(){
		return socio;
	}
	
	public Integer getIDsesion(){
		return idSesion;
	}
	
	public void setIDsesion(Integer id){
		idSesion = id;
	}
}
