package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import GestionAyudas.TipoAyudaDB;

public class AnadirTipoAyuda extends JPanel {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal padre;
	private JTextField textField;
	private JTextArea textArea;
	TipoAyudaDB tabd = new TipoAyudaDB();
	
	PanelInicio ini;
	public AnadirTipoAyuda( VentanaPrincipal p, PanelInicio pIni) {
		ini=pIni;
		this.padre = p;
		setSize(PanelInicio.tamanoPaneles);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textArea = new JTextArea();
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Desea cancelar la modificacion?", "Confirmacion", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){

					ini.setPanelOnTab(ini.configurar_tipo_ayuda, PanelInicio.AYUDAS);
				}
			}
		});
		
		JButton button_1 = new JButton("Guardar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Desea modificar el tipo de ayuda?", "Confirmacion", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){

					padre.getControladorAyudas().anadirTipoAyuda(textArea.getText(), textField.getText(), 0);
					ini.configurar_tipo_ayuda.fillTable(tabd.getList());
					ini.setPanelOnTab(ini.configurar_tipo_ayuda, PanelInicio.AYUDAS);

				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(220)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(156)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(148)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblObservaciones)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(548, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(53)
					.addComponent(lblObservaciones)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(260, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
