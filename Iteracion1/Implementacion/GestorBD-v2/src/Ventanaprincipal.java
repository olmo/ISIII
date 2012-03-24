import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;



@SuppressWarnings("serial")
public class Ventanaprincipal extends JFrame {
	JDesktopPane pantalla = new JDesktopPane();
	boolean conexionbd=new Boolean(false);
	GestorConexion gc;


	
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Ventanaprincipal() {
		gc=new GestorConexion();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setExtendedState(this.MAXIMIZED_BOTH); //Maximiza
		setBounds(100, 100, 750, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmConectar = new JMenuItem("Conectar");
		mntmConectar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
						if(gc.conectar()){
							//System.out.println("Conectado");
							conexionbd=true;
							Mostrarmensaje("Conexión establecida");
							CrearVentanaInterna();
						}else{
							//System.out.println("NO Conectado");
							Mostrarmensaje("Error en la conexión");
						}
			}
		});
		mnArchivo.add(mntmConectar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		contentPane.add(pantalla, BorderLayout.CENTER);
	}
	
	

	
	private void CrearVentanaInterna(){
		Ventanainterna vi=new Ventanainterna(gc);
	
		try {
			

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.pantalla.add(vi);
		vi.setLocation(0, 0);
		vi.setSize(pantalla.getSize());
		vi.setVisible(true);
	}
	
	
	private void Mostrarmensaje(String c){
		JOptionPane.showMessageDialog(null, c);
	}

}
