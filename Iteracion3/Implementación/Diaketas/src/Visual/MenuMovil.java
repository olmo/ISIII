package Visual;

import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.JButton;

import GestionPersona.Socio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;

public class MenuMovil extends JPanel {
	private VentanaPrincipalMovil padre;
	private Socio s;
	DatosUsuarioMovil datosUsuarioMovil;
	DatosDonacionesMovil donacionesMovil;
	PanelInicioMovil panelInicio;

	/**
	 * Create the panel.
	 */
	public MenuMovil(VentanaPrincipalMovil mipadre) {
		padre = mipadre;
		setLayout(null);
				
		JButton consultarDatosBoton = new JButton("Consultar datos");
		consultarDatosBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer id = padre.getIDsesion();
				Socio s=padre.getControladorMovil().consultarSocio(id);
				
				padre.getContentPane().removeAll();
				padre.getContentPane().validate();
				datosUsuarioMovil = new DatosUsuarioMovil(padre);
				panelInicio = new PanelInicioMovil(padre,padre.getusuario());
				panelInicio.setBounds(0,0,534,100);
				datosUsuarioMovil.setBounds(10, 10, 370, 514);
				padre.getContentPane().add(panelInicio);
				padre.getContentPane().add(datosUsuarioMovil);
				
				datosUsuarioMovil.rellenaVista(s);
				
				padre.getContentPane().repaint();
			}
		});
		consultarDatosBoton.setBounds(46, 11, 241, 41);
		add(consultarDatosBoton);
		
		JButton bajaBoton = new JButton("Solicitar baja");
		bajaBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaSocioMovil dialogobaja;
				dialogobaja = new BajaSocioMovil();
				dialogobaja.setVisible(true);
			}
		});
		bajaBoton.setBounds(46, 88, 241, 41);
		add(bajaBoton);
		
		JButton donacionesBoton = new JButton("Ver donaciones");
		donacionesBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.getContentPane().removeAll();
				padre.getContentPane().validate();
				donacionesMovil = new DatosDonacionesMovil(padre);
				panelInicio = new PanelInicioMovil(padre,padre.getusuario());
				panelInicio.setBounds(0,0,534,100);
				donacionesMovil.setBounds(10, 10, 370, 514);
				padre.getContentPane().add(panelInicio);
				padre.getContentPane().add(donacionesMovil);
				padre.getContentPane().repaint();
			}
		});
		donacionesBoton.setBounds(46, 161, 241, 41);
		add(donacionesBoton);

	}
}
