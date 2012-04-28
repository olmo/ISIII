package Visual;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BuscarAyuda extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BuscarAyuda() {
		setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 178, 0, 0);
		add(scrollPane_1);
		
		
		table = new JTable();
		table.setBounds(48, 105, 80, 103);
		add(table);

	}
}
