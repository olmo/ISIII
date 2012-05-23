package Visual;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DonacionesMovil extends JPanel {
	private JTable tablaDonaciones;
	private PanelInicio ini;


	/**
	 * Create the panel.
	 */
	public DonacionesMovil() {
		setLayout(null);
		
		JButton logOutBoton = new JButton("Cerrar sesi\u00F3n");
		logOutBoton.setBounds(301, 30, 118, 65);
		add(logOutBoton);
		
		JButton volverBoton = new JButton("Volver");
		volverBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.setPanelOnTab(ini.home_Movil,PanelInicio.AYUDAS);
			}
		});
		volverBoton.setBounds(170, 559, 118, 65);
		add(volverBoton);
		
		JScrollPane donacionesScrollPane = new JScrollPane((Component) null);
		donacionesScrollPane.setBounds(24, 159, 398, 360);
		add(donacionesScrollPane);
		
		tablaDonaciones = new JTable();
		donacionesScrollPane.setViewportView(tablaDonaciones);

	}
}
