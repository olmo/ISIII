package Visual;

import java.awt.Component;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class PanelAyudas extends JPanel {

	private JTextField textField_1;
	VentanaPrincipal padre;
	/**
	 * Create the panel.
	 */
	public PanelAyudas(VentanaPrincipal p, String nombre) {
		setSize(1100, 500);

		padre = p;
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(15);
		
		JButton button_5 = new JButton("Buscar");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_6 = new JButton("Configurar Tipos de Ayuda");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		
		JButton button_7 = new JButton("Editar Ayuda");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_8 = new JButton("Conceder Ayuda");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(this);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1173, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(235)
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 976, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(button_8, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 607, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(2)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(1)
									.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(184)
							.addComponent(button_8)
							.addGap(18)
							.addComponent(button_7))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(51)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		padre.panelAyudas.setLayout(gl_panel_1);
		


	}

}
