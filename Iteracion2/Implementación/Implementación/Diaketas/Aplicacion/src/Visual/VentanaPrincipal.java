package Visual;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	public JPanel panelUsuarios;
	public JPanel panelDonaciones;
	public JPanel panelAyudas;
	public JPanel panelActuaciones;
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
		this.
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
		setLocation(50, 0);
		setSize(1200, 700);
		setResizable(true);
		setTitle("Gesti\u00F3n Asociaci\u00F3n Diaketas");
		
		
		panelUsuarios = new JPanel();
		panelUsuarios.setSize(1000, 500);
		panelUsuarios.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panelDonaciones = new JPanel();
		panelDonaciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panelAyudas = new JPanel();
		panelAyudas.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panelActuaciones = new JPanel();
		panelActuaciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
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
