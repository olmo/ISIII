package Visual;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DatosDonacionesMovil extends JPanel {
	private JTable table;
	VentanaPrincipalMovil padre;

	/**
	 * Create the panel.
	 */
	public DatosDonacionesMovil(VentanaPrincipalMovil mipadre) {
		setLayout(null);
		padre = mipadre;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 95, 257, 351);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Fecha", "Cantidad", "Estado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton volverBoton = new JButton("Volver");
		volverBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelInicioMovil panIni = new PanelInicioMovil(padre,padre.getusuario());
				padre.getContentPane().removeAll();
				padre.getContentPane().validate();
				padre.getContentPane().add(panIni);
				padre.getContentPane().repaint();
			}
		});
		volverBoton.setBounds(98, 469, 112, 43);
		add(volverBoton);

	}
}
