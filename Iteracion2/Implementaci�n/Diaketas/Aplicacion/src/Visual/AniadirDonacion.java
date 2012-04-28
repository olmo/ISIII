package Visual;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class AniadirDonacion extends JPanel{
	private JTextField textField;
	static private JTextField textField_1;
	private VentanaPrincipal padre;
	private static final long serialVersionUID = 1L;
	PanelInicio ini;
	/**
	 * Create the panel.
	 */
	public AniadirDonacion(VentanaPrincipal p,PanelInicio pIni) {
		ini=pIni;
		padre=p;
		setSize(PanelInicio.tamanoPaneles);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(15);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		
		JButton button_1 = new JButton("Volver");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.panelDonaciones.removeAll();
				
				ini.panelDonaciones.add(new PanelDonaciones(padre, ini));
				ini.panelDonaciones.validate();
				
				ini.panelDonaciones.repaint();
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_3 = new JButton("Realizar Donación");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "¿Confirma la Donacion?", "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
					//padre.getControladorDonacion().anadirDonacion(donante, AniadirDonacion.textField_1.getText()  , "pagada" );
					
					ini.panelDonaciones.removeAll();
					ini.panelDonaciones.add(new PanelDonaciones(padre, ini));
					ini.panelDonaciones.validate();					
					ini.panelDonaciones.repaint();
				}else{
					
					ini.panelDonaciones.validate();					
					ini.panelDonaciones.repaint();
					
				}
				
			
			}
		});
		
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Cantidad ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(15);
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(281)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 641, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addGap(179))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(51)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(40))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(301)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(375, Short.MAX_VALUE))
		);
		setLayout(gl_panel);
	}
}
