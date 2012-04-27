package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class PanelDonaciones extends JPanel {
	JTextField textField;
	VentanaPrincipal padre;
	PanelInicio ini;

	/**
	 * Create the panel.
	 */
	public PanelDonaciones(VentanaPrincipal p,PanelInicio pIni) {

		ini=pIni;
		padre=p;
		setSize(PanelInicio.tamanoPaneles);
		textField = new JTextField();
		textField.setToolTipText("Búsqueda por fecha, tipo de donante, nombre de donante y estado de donación");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(15);
		
		JButton button = new JButton("Buscar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_1 = new JButton("A\u00F1adir Donaci\u00F3n");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ini.panelDonaciones.removeAll();
				//ini.validate();
				ini.panelDonaciones.add(new AniadirDonacion(padre,ini));
				ini.panelDonaciones.validate();
				ini.panelDonaciones.repaint();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_2 = new JButton("A\u00F1adir Donante");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.panelUsuarios.removeAll();
				
				
				ini.panelUsuarios = new NuevoUsuario(padre,ini);
				((NuevoUsuario) ini.panelUsuarios).modotrabajador();
				ini.validate();
				ini.repaint();
				PanelInicio.verPestana(0);
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton button_3 = new JButton("Cancelar Donaci\u00F3n");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cancelar donación
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_4 = new JButton("Confirmar Donaci\u00F3n");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ConfirmarDonacion cDon = new ConfirmarDonacion();
//				
//				cDon.setVisible(true);
//				cDon.setAlwaysOnTop(true);
//				if(cDon.getConfirmacionModificacion())
//					;//Hacer  algo ...
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1173, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(149)
							.addComponent(button_1)
							.addGap(18)
							.addComponent(button_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 976, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(button_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 607, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(2)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(184)
							.addComponent(button_4)
							.addGap(18)
							.addComponent(button_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(51)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		setLayout(gl_panel);


	}

}
