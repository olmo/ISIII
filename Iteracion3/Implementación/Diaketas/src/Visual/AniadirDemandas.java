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

import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AniadirDemandas extends javax.swing.JPanel {

	private JTextField textFieldOfertas;
	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane scrollPaneOfertas;
	private JTable tablaOfertas = new JTable();
	private DefaultTableModel tabla_modeloOfertas;
	private DefaultTableModel tabla_modeloSolicitantes;
	/**
	 * Create the panel.
	 */
	private JTextField textFieldSolicitantes;
	private JTable tableSolicitante;
	
	public void fillTableOfertas(/*****ARRAY OFERTAS*******/){ //////////////////////////////////////////////////////////////////
		scrollPaneOfertas.setVisible(true);
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[4];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("Título");
		modelo.addColumn("Empresa");
		modelo.addColumn("Puesto");
		modelo.addColumn("Fecha Fin");
		
		tabla_modeloOfertas = modelo;
		this.tablaOfertas.setModel(tabla_modeloOfertas);
	}
	public void fillTableSolicitantes(/*****ARRAY SOLICITANTES*******/){ //////////////////////////////////////////////////////////////////
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[4];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("DNI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Estudios");
		
		tabla_modeloSolicitantes = modelo;
		this.tableSolicitante.setModel(tabla_modeloSolicitantes);
	}
	public AniadirDemandas(VentanaPrincipal p, PanelInicio pIni) {

//		setSize(1100, 500);
		ini=pIni;
		padre = p;
		setSize(new Dimension(1100, 703));
		textFieldOfertas = new JTextField();
		textFieldOfertas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldOfertas.setColumns(15);
		
		JButton buttonOfertas = new JButton("Buscar");
		buttonOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obtenemos lista de ofertas
				/////////////////////////listaAyudas = padre.getControladorAyudas().listarAyudasConcedidas(textFieldOfertas.getText());
				//
				ini.anadir_demandas.fillTableOfertas(/***********/);
			}
		});
		buttonOfertas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(ini.panel_demandas, PanelInicio.DEMANDAS);
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//ini.conceder_ayuda.fillTable(bdb.getBeneficiarios(""));
				//ini.setPanelOnTab(ini.gestion_solicitante, PanelInicio.DEMANDAS);
				
			}
		});
		
		scrollPaneOfertas = new JScrollPane(tablaOfertas);
		
		JScrollPane scrollPaneSolicitantes = new JScrollPane();
		
		JLabel lblOferta = new JLabel("Oferta:");
		
		JLabel lblSolicitante = new JLabel("Solicitante:");
		
		textFieldSolicitantes = new JTextField();
		textFieldSolicitantes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSolicitantes.setColumns(15);
		
		JButton buttonBuscarSolicitantes = new JButton("Buscar");
		buttonBuscarSolicitantes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonBuscarSolicitantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ini.setPanelOnTab(ini.gestion_solicitante, PanelInicio.DEMANDAS);

				ini.anadir_demandas.fillTableSolicitantes(/***********/);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(textFieldOfertas, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(buttonOfertas))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(lblOferta, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSolicitante)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(25)
											.addComponent(textFieldSolicitantes, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
											.addGap(5)
											.addComponent(buttonBuscarSolicitantes, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(314)
									.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(78)
									.addComponent(btnGuardar))
								.addComponent(scrollPaneSolicitantes, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPaneOfertas, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(200, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblOferta)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonOfertas)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(textFieldOfertas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPaneOfertas, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(lblSolicitante)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(textFieldSolicitantes, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(buttonBuscarSolicitantes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneSolicitantes, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVolver)
						.addComponent(btnGuardar))
					.addContainerGap(134, Short.MAX_VALUE))
		);
		
		tableSolicitante = new JTable();
		scrollPaneSolicitantes.setColumnHeaderView(tableSolicitante);
		
		if(textFieldOfertas.getText().isEmpty())
			this.fillTableOfertas(/*****/);
		if(textFieldSolicitantes.getText().isEmpty())
			this.fillTableSolicitantes(/*****/);
		
		setLayout(groupLayout);
		


	}
}
