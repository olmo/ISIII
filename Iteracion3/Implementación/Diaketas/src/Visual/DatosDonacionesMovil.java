package Visual;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

	}
}
