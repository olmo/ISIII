package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ConcederAyuda extends JPanel {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal padre;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	
	public ConcederAyuda(VentanaPrincipal p) {
		this.padre = p;
		setSize(padre.panelAyudas.getSize());
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Desea cancelar la modificacion?", "Confirmacion", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
					//Codigo para rellenar la tabla con los tipos de ayuda
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Desea cancelar la modificacion?", "Confirmacion", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
					padre.panelAyudas.removeAll();
					
					padre.panelAyudas.add(new PanelAyudas(padre, padre.getusuario()));
					padre.panelAyudas.validate();
					
					padre.panelAyudas.repaint();
				}
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Desea modificar el tipo de ayuda?", "Confirmacion", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
					padre.panelAyudas.removeAll();
					
					padre.panelAyudas.add(new PanelAyudas(padre, padre.getusuario()));
					padre.panelAyudas.validate();
					//Codigo de modificacion del tipo de ayuda
					padre.panelAyudas.repaint();
				}
			}
		});
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnAadirTipoDe = new JButton("A\u00F1adir Tipo de Ayuda");
		btnAadirTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.panelAyudas.removeAll();
				
				padre.panelAyudas.add(new AnadirTipoAyuda(padre));
				padre.panelAyudas.validate();
				
				padre.panelAyudas.repaint();
			}
		});
		
		JLabel lblCantidadEconomica = new JLabel("Cantidad economica");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		
		JTextArea textArea = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(226)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnGuardar)
									.addGap(97))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAadirTipoDe)
									.addContainerGap())))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCantidadEconomica)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label))
						.addComponent(lblObservaciones)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAadirTipoDe))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCantidadEconomica)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
							.addGap(62)
							.addComponent(lblObservaciones)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textArea)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnGuardar))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		

	}
}
