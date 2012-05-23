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
	public DonacionesMovil(VentanaPrincipalMovil mipadre) {
		setLayout(null);
		
		JButton volverBoton = new JButton("Volver");
		volverBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.setPanelOnTab(ini.home_Movil,PanelInicio.AYUDAS);
			}
		});
		volverBoton.setBounds(122, 468, 111, 48);
		add(volverBoton);
		
		JScrollPane donacionesScrollPane = new JScrollPane((Component) null);
		donacionesScrollPane.setBounds(10, 87, 336, 370);
		add(donacionesScrollPane);
		
		tablaDonaciones = new JTable();
		donacionesScrollPane.setViewportView(tablaDonaciones);

	}
}
