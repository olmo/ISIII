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
public class VerDetallesDemandas extends javax.swing.JPanel {

	private JTextField textFieldOfertas;
	VentanaPrincipal padre;
	PanelInicio ini;
	private JTable tablaSolicitantes = new JTable();
	private DefaultTableModel tabla_modeloSolicitantes;
	
	public void fillTableSolicitantes(/*****ARRAY SOLICITANTES*******/){ //////////////////////////////////////////////////////////////////
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[4];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("DNI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Estudios");
		
		tabla_modeloSolicitantes = modelo;
		this.tablaSolicitantes.setModel(tabla_modeloSolicitantes);
	}
	public VerDetallesDemandas(VentanaPrincipal p, PanelInicio pIni) {
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
				ini.anadir_demandas.fillTableSolicitantes(/***********/);
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
		
		JButton btnDarBajaSolicitante = new JButton("Dar Baja Solicitante");
		btnDarBajaSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDarBajaSolicitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfirmarModificacion cm= new ConfirmarModificacion();
				cm.setVisible(true);
				cm.setAlwaysOnTop(true);
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane(tablaSolicitantes);
		
		JLabel lblSolicitante = new JLabel("Solicitantes:");
		
		JLabel lblOferta = new JLabel("Oferta:");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(lblOferta, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldOfertas, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(buttonOfertas))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(331)
							.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(78)
							.addComponent(btnDarBajaSolicitante))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblSolicitante))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(200, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonOfertas)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldOfertas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblOferta))))
					.addGap(19)
					.addComponent(lblSolicitante)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 507, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVolver)
						.addComponent(btnDarBajaSolicitante))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		
		tablaSolicitantes = new JTable();
		scrollPane_1.setColumnHeaderView(tablaSolicitantes);
		
		if(textFieldOfertas.getText().isEmpty())
			this.fillTableSolicitantes(/*****/);
		
		setLayout(groupLayout);
		


	}
}
