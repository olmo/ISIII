package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ConfigurarTipoAyuda extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal padre;
	private JTable table;
	PanelInicio ini;
	public ConfigurarTipoAyuda(VentanaPrincipal p,PanelInicio pIni) {
		ini=pIni;
		this.padre = p;
		setSize(PanelInicio.tamanoPaneles);
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAadirTipoDe = new JButton("A\u00F1adir Tipo de Ayuda");
		btnAadirTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.panelAyudas.removeAll();
				
				ini.panelAyudas.add(new AnadirTipoAyuda(padre,ini));
				ini.panelAyudas.validate();
				
				ini.panelAyudas.repaint();
			}
		});
		
		JButton btnEditarTipoDe = new JButton("Editar Tipo de Ayuda");
		btnEditarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.panelAyudas.removeAll();
				
				ini.panelAyudas.add(new EditarTipoAyuda(padre,ini));
				ini.panelAyudas.validate();
				
				ini.panelAyudas.repaint();
			}
		});
		
		JButton btnBorrarTipoDe = new JButton("Borrar Tipo de Ayuda");
		btnBorrarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Seguro que quiere eliminar?", "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
					//Acciones de borrar tipo de ayuda
					JOptionPane.showMessageDialog(null, "Tipo de ayuda borrada");
				}else{
					//Continuar en la misma ventana
				}
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.panelAyudas.removeAll();
				
				ini.panelAyudas.add(new PanelAyudas(padre, ini));
				ini.panelAyudas.validate();
				
				ini.panelAyudas.repaint();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 554, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAadirTipoDe)
								.addComponent(btnEditarTipoDe)
								.addComponent(btnBorrarTipoDe)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(319)
							.addComponent(btnVolver)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(btnAadirTipoDe)
							.addGap(28)
							.addComponent(btnEditarTipoDe)
							.addGap(33)
							.addComponent(btnBorrarTipoDe)))
					.addGap(18)
					.addComponent(btnVolver)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
	}

}
