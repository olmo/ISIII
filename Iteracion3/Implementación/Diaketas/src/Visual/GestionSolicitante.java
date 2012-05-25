package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import GestionAyudas.Ayuda;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class GestionSolicitante extends JPanel {

	private JTextField textField_1;
	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane scrollPane;
	private JTable tablaAyudas = new JTable();
	private DefaultTableModel tabla_modelo;

	/**
	 * Create the panel.
	 */
	public void fillTable(ArrayList<Ayuda> lista_ayudas) {// Integer->Donaciones
		scrollPane.setVisible(true);

		DefaultTableModel modelo = new DefaultTableModel();
		Object[] tupla = new Object[5];
		// Relleneamos la cabecera de la tabla.
		modelo.addColumn("DNI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Estudios");

		tabla_modelo = modelo;
		this.tablaAyudas.setModel(tabla_modelo);
	}

	public GestionSolicitante(VentanaPrincipal p, PanelInicio pIni) {

		// setSize(1100, 500);
		ini = pIni;
		padre = p;
		setSize(PanelInicio.tamanoPaneles);
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(15);

		JButton button_5 = new JButton("Buscar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//ini.panel_ayudas.fillTable(listaAyudas);
				ini.setPanelOnTab(ini.panel_demandas, PanelInicio.DEMANDAS);
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));

		
		JButton btnAadirDemanda = new JButton("Aniadir Solicitante");
		btnAadirDemanda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAadirDemanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(ini.aniadir_solicitante, PanelInicio.DEMANDAS);
			}
		});

		JButton btnGestinD = new JButton("Editar Solicitante");
		btnGestinD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestinD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(ini.editar_solicitante, PanelInicio.DEMANDAS);
			}
		});

		JButton btnVerDetalles = new JButton("Eliminar Solicitante");
		btnVerDetalles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EliminarSolicitante es= new EliminarSolicitante(padre);
				es.setVisible(true);
				es.setAlwaysOnTop(true);

				if(es.getConfirmacionBorrado()==true){
					try{
						//padre.getControladorPersonas().borrarDatosFamiliar(getId());
						JOptionPane.showMessageDialog(null, "Se ha borrado el solicitante\n");
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Error al borrar solicitante\n"+e1.getMessage());
					}
				}
				
				ini.setPanelOnTab(ini.gestion_solicitante, PanelInicio.DEMANDAS);
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(ini.panel_demandas, PanelInicio.DEMANDAS);
			}
		});

		scrollPane = new JScrollPane(tablaAyudas);
		scrollPane.setVisible(false);
		
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(button_5))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(34)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnGestinD, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addComponent(btnVerDetalles, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnAadirDemanda, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
									.addGap(16)))))
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(button_5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(201)
					.addComponent(btnAadirDemanda)
					.addGap(19)
					.addComponent(btnGestinD)
					.addGap(18)
					.addComponent(btnVerDetalles)
					.addGap(18)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(294, Short.MAX_VALUE))
		);

		if (textField_1.getText().isEmpty())
			this.fillTable(padre.getControladorAyudas().listarAyudasConcedidas(
					""));

		setLayout(groupLayout);

	}
}
