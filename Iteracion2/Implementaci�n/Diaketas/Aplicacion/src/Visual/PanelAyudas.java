package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class PanelAyudas extends JPanel {

	private JTextField textField_1;
	VentanaPrincipal padre;
	private JTable table;
	PanelInicio ini;
	/**
	 * Create the panel.
	 */
	public PanelAyudas(VentanaPrincipal p, PanelInicio pIni) {
//		setSize(1100, 500);
		ini=pIni;

		padre = p;
		setSize(PanelInicio.tamanoPaneles);
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(15);
		
		JButton button_5 = new JButton("Buscar");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JButton button_6 = new JButton("Configurar Tipos de Ayuda");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((PanelInicio)padre.getContentPane()).panelAyudas.removeAll();
				((PanelInicio)padre.getContentPane()).panelAyudas.add(new ConfigurarTipoAyuda(padre,ini));
				((PanelInicio)padre.getContentPane()).panelAyudas.validate();
				((PanelInicio)padre.getContentPane()).panelAyudas.repaint();
				
			}
		});
		
		JButton button_7 = new JButton("Editar Ayuda");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((PanelInicio)padre.getContentPane()).panelAyudas.removeAll();
				
				((PanelInicio)padre.getContentPane()).panelAyudas.add(new EditarAyuda(padre));
				((PanelInicio)padre.getContentPane()).panelAyudas.validate();
				
				((PanelInicio)padre.getContentPane()).panelAyudas.repaint();
				
			}
		});
		
		JButton button_8 = new JButton("Conceder Ayuda");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((PanelInicio)padre.getContentPane()).panelAyudas.removeAll();
				
				((PanelInicio)padre.getContentPane()).panelAyudas.add(new ConcederAyuda(padre));
				((PanelInicio)padre.getContentPane()).panelAyudas.validate();
				
				((PanelInicio)padre.getContentPane()).panelAyudas.repaint();
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(190)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(button_5)
							.addGap(5)
							.addComponent(button_6))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(button_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(button_5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(button_6)))
					.addGap(43)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(110)
					.addComponent(button_8)
					.addGap(51)
					.addComponent(button_7)
					.addContainerGap(289, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		


	}
}
