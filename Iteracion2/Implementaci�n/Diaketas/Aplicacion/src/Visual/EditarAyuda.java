package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class EditarAyuda extends JPanel {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal padre;
	private JTextField textField;
	PanelInicio ini;
	public EditarAyuda(VentanaPrincipal p,PanelInicio pIni) {
		ini=pIni;

		this.padre = p;
		setSize(PanelInicio.tamanoPaneles);
		JComboBox comboBox = new JComboBox();
		
		JButton btnAadirTipoDe = new JButton("A\u00F1adir Tipo de Ayuda");
		btnAadirTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.panelAyudas.removeAll();
				
				ini.panelAyudas.add(new AnadirTipoAyuda(padre,ini));
				ini.panelAyudas.validate();
				
				ini.panelAyudas.repaint();
			}
		});
		
		JLabel lblCantidadEconomica = new JLabel("Cantidad economica");
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		
		JEditorPane textArea = new JEditorPane();
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "�Desea cancelar la modificacion?", "Confirmacion", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
					ini.panelAyudas.removeAll();
					
					ini.panelAyudas.add(new ConfigurarTipoAyuda(padre,ini));
					ini.panelAyudas.validate();
					
					ini.panelAyudas.repaint();
				}
				
			}
		});
		
		JButton button_1 = new JButton("Guardar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "�Desea modificar el tipo de ayuda?", "Confirmacion", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
					ini.panelAyudas.removeAll();
					
					ini.panelAyudas.add(new ConfigurarTipoAyuda(padre,ini));
					ini.panelAyudas.validate();
					//Codigo de modificacion del tipo de ayuda
					ini.panelAyudas.repaint();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(220)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(115)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(183, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 625, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblObservaciones)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAadirTipoDe))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblCantidadEconomica)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label)))
							.addGap(129)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAadirTipoDe))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidadEconomica)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(36)
					.addComponent(lblObservaciones)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(45))
		);
		setLayout(groupLayout);
	}

}
