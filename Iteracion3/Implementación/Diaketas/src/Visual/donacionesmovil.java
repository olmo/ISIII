package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class donacionesmovil extends JFrame {

	private JPanel contentPane;
	private JTable donacionesTable;

	/**
	 * Create the frame.
	 */
	public donacionesmovil() {
		setTitle("Asociaci\u00F3n Diaketas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Bienvenid@");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(48, 41, 116, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("<<usuario>>");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(156, 41, 116, 40);
		contentPane.add(label_1);
		
		JButton button = new JButton("Cerrar sesi\u00F3n");
		button.setBounds(335, 31, 127, 66);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 137, 403, 430);
		contentPane.add(scrollPane);
		
		donacionesTable = new JTable();
		scrollPane.setViewportView(donacionesTable);
		donacionesTable.setModel(new DefaultTableModel(
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
		
		JButton volverBoton = new JButton("Volver");
		volverBoton.setBounds(171, 598, 136, 67);
		contentPane.add(volverBoton);
	}
}
