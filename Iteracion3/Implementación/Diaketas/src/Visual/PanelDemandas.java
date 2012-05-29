package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class PanelDemandas extends javax.swing.JPanel {

	private JTextField textField_1;
	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane scrollPane;
	private JTable tablaDemandas = new JTable();
	private DefaultTableModel tabla_modelo;
	/**
	 * Create the panel.
	 */
	public void fillTable(/*ARRAY DE SOLICITANTES*/){ /////////////////////////////////////////////
		scrollPane.setVisible(true);
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[3];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("Identificador");
		modelo.addColumn("Oferta");
		modelo.addColumn("Solicitante");
		
		//RELLENAR lA TABLA
		
		tabla_modelo = modelo;
		this.tablaDemandas.setModel(tabla_modelo);
	}
	public PanelDemandas(VentanaPrincipal p, PanelInicio pIni) {

//		setSize(1100, 500);
		ini=pIni;
		padre = p;
		setSize(PanelInicio.tamanoPaneles);
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(15);
		
		JButton button_5 = new JButton("Buscar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.panel_demandas.fillTable();
				ini.setPanelOnTab(ini.panel_demandas, PanelInicio.DEMANDAS);
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JButton btnAadirDemanda = new JButton("A\u00F1adir Demanda");
		btnAadirDemanda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAadirDemanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.anadir_demandas.refrescar();
				ini.setPanelOnTab(ini.anadir_demandas, PanelInicio.DEMANDAS);
	
			}
		});
		
		JButton btnGestinD = new JButton("Gesti\u00F3n Solicitante");
		btnGestinD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestinD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(ini.gestion_solicitante, PanelInicio.DEMANDAS);
				
			}
		});
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ini.verDetallesDemandas.setIdOferta(id);
				//lista_ofertas.get(tablaDemandas.getSelectedRow()).getId();
				ini.setPanelOnTab(ini.verDetallesDemandas, PanelInicio.DEMANDAS);
			}
		});
		
		scrollPane = new JScrollPane(tablaDemandas);
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
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnVerDetalles, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAadirDemanda, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnGestinD))))
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
					.addGap(28)
					.addComponent(btnVerDetalles)
					.addGap(34)
					.addComponent(btnGestinD)
					.addContainerGap(312, Short.MAX_VALUE))
		);
		
		if(textField_1.getText().isEmpty())
			this.fillTable(/*********/); ///////////////////////////////////////////////////////////////
		
		setLayout(groupLayout);
		


	}
}
