package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import GestionOfertas.Oferta;
import GestionSolicitante.Solicitante;

@SuppressWarnings("serial")
public class AniadirDemandas extends javax.swing.JPanel {

	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane scrollPaneOfertas;

	private JTable tablaOfertas = new JTable();
	private DefaultTableModel tabla_modeloOfertas;
	private JTextField textFieldOfertas;
	private ArrayList<Oferta> lista_ofertas = new ArrayList<Oferta>();

	private JTable tableSolicitante;
	private DefaultTableModel tabla_modeloSolicitantes;
	private JTextField textFieldSolicitantes;
	private ArrayList<Solicitante> lista_solicitantes = new ArrayList<Solicitante>();

	public void fillTableOfertas(ArrayList<Oferta> lista) {
		scrollPaneOfertas.setVisible(true);
		lista_ofertas = lista;

		DefaultTableModel modelo = new DefaultTableModel();
		Object[] tupla = new Object[4];
		// Relleneamos la cabecera de la tabla.
		modelo.addColumn("Título");
		modelo.addColumn("Empresa");
		modelo.addColumn("Puesto");
		modelo.addColumn("Fecha Fin");

		for (int i = 0; i < lista_ofertas.size(); i++) {
			tupla[0] = lista_ofertas.get(i).getTitulo();
			tupla[1] = lista_ofertas.get(i).getId_empresa(); // ****
			tupla[2] = lista_ofertas.get(i).getPuesto();
			tupla[3] = lista_ofertas.get(i).getFechafin();
			modelo.addRow(tupla);
		}

		tabla_modeloOfertas = modelo;
		this.tablaOfertas.setModel(tabla_modeloOfertas);
	}

	public void fillTableSolicitantes(ArrayList<Solicitante> lista) {
		lista_solicitantes = lista;

		DefaultTableModel modelo = new DefaultTableModel();
		Object[] tupla = new Object[4];
		// Relleneamos la cabecera de la tabla.
		modelo.addColumn("DNI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Estudios");

		for (int i = 0; i < lista_solicitantes.size(); i++) {
			tupla[0] = lista_solicitantes.get(i).getDni();
			tupla[1] = lista_solicitantes.get(i).getNombre();
			tupla[2] = lista_solicitantes.get(i).getApellido1() + " "
					+ lista_solicitantes.get(i).getApellido2();
			tupla[3] = lista_solicitantes.get(i).getEstudios();

			modelo.addRow(tupla);
		}

		tabla_modeloSolicitantes = modelo;
		this.tableSolicitante.setModel(tabla_modeloSolicitantes);
	}

	public AniadirDemandas(VentanaPrincipal p, PanelInicio pIni) {

		// setSize(1100, 500);
		ini = pIni;
		padre = p;
		setSize(new Dimension(1100, 703));
		textFieldOfertas = new JTextField();
		textFieldOfertas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldOfertas.setColumns(15);

		JButton buttonOfertas = new JButton("Buscar");
		buttonOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista_ofertas = padre.getControladorOfertas().ListarOfertas(
						textFieldOfertas.getText());
				fillTableOfertas(lista_ofertas);
				ini.setPanelOnTab(ini.anadir_demandas, PanelInicio.DEMANDAS);
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
				int idSolicitante = -1;
				int idOferta = -1;
				
				idSolicitante = lista_solicitantes.get(tableSolicitante.getSelectedRow()).getId();
				idOferta = lista_ofertas.get(tablaOfertas.getSelectedRow()).getId();
				
				if(idSolicitante > -1 && idOferta > -1)
					padre.getControladorOfertas().apuntarOferta(idOferta, idSolicitante);
				
				ini.panel_demandas.refrescar();
				ini.verDetallesDemandas.setIdOferta(idOferta);
				ini.verDetallesDemandas.refrescar();
				ini.setPanelOnTab(ini.verDetallesDemandas, PanelInicio.DEMANDAS);
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
				lista_solicitantes = padre.getControladorOfertas()
						.listarSolicitantes(textFieldSolicitantes.getText());
				fillTableSolicitantes(lista_solicitantes);
				ini.setPanelOnTab(ini.anadir_demandas, PanelInicio.DEMANDAS);
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(49)
																		.addComponent(
																				textFieldOfertas,
																				GroupLayout.PREFERRED_SIZE,
																				362,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(5)
																		.addComponent(
																				buttonOfertas))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(25)
																		.addComponent(
																				lblOferta,
																				GroupLayout.PREFERRED_SIZE,
																				40,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(14)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(18)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblSolicitante)
																														.addGroup(
																																groupLayout
																																		.createSequentialGroup()
																																		.addGap(25)
																																		.addComponent(
																																				textFieldSolicitantes,
																																				GroupLayout.PREFERRED_SIZE,
																																				362,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addGap(5)
																																		.addComponent(
																																				buttonBuscarSolicitantes,
																																				GroupLayout.PREFERRED_SIZE,
																																				73,
																																				GroupLayout.PREFERRED_SIZE))))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(314)
																										.addComponent(
																												btnVolver,
																												GroupLayout.PREFERRED_SIZE,
																												81,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(78)
																										.addComponent(
																												btnGuardar))
																						.addComponent(
																								scrollPaneSolicitantes,
																								GroupLayout.PREFERRED_SIZE,
																								886,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								scrollPaneOfertas,
																								GroupLayout.PREFERRED_SIZE,
																								886,
																								GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(200, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(18)
										.addComponent(lblOferta)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																buttonOfertas)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(1)
																		.addComponent(
																				textFieldOfertas,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(scrollPaneOfertas,
												GroupLayout.PREFERRED_SIZE,
												182, GroupLayout.PREFERRED_SIZE)
										.addGap(26)
										.addComponent(lblSolicitante)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(1)
																		.addComponent(
																				textFieldSolicitantes,
																				GroupLayout.PREFERRED_SIZE,
																				23,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																buttonBuscarSolicitantes,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(scrollPaneSolicitantes,
												GroupLayout.PREFERRED_SIZE,
												200, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(btnVolver)
														.addComponent(
																btnGuardar))
										.addContainerGap(134, Short.MAX_VALUE)));

		tableSolicitante = new JTable();
		scrollPaneSolicitantes.setColumnHeaderView(tableSolicitante);

		if (textFieldOfertas.getText().isEmpty())
			this.fillTableOfertas(padre.getControladorOfertas().ListarOfertas(
					""));
		if (textFieldSolicitantes.getText().isEmpty())
			this.fillTableSolicitantes(padre.getControladorOfertas()
					.listarSolicitantes(""));

		setLayout(groupLayout);

	}

	public void refrescar() {
		lista_ofertas = padre.getControladorOfertas().ListarOfertas("");
		fillTableOfertas(lista_ofertas);
		lista_solicitantes = padre.getControladorOfertas().listarSolicitantes(
				"");
		fillTableSolicitantes(lista_solicitantes);
	}
}
