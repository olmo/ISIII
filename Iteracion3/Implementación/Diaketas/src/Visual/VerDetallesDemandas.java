package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import javax.swing.JLabel;

import GestionOfertas.Oferta;
import GestionSolicitante.Solicitante;

@SuppressWarnings("serial")
public class VerDetallesDemandas extends javax.swing.JPanel {

	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane scrollPane_1;
	
	private JTable tablaSolicitantes = new JTable();
	private DefaultTableModel tabla_modeloSolicitantes;
	private JTextField textFieldOfertas;
	private ArrayList<Solicitante> lista_solicitantes = new ArrayList<Solicitante>();

	private int idOferta = -1;

	public void fillTableSolicitantes(ArrayList<Solicitante> lista) {
		scrollPane_1.setVisible(true);
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
		this.tablaSolicitantes.setModel(tabla_modeloSolicitantes);
	}

	public VerDetallesDemandas(VentanaPrincipal p, PanelInicio pIni) {
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
				//Obtenemos todas las ofertas segun el filtro
				ArrayList<Oferta> lista_ofertas = padre.getControladorOfertas().ListarOfertas(textFieldOfertas.getText());
				
				lista_solicitantes.clear();
				
				//Para cada oferta...
				for(int i=0; i<lista_ofertas.size(); i++){
					//Obtenemos los solicitantes de esa oferta
					int idUnaOferta = lista_ofertas.get(i).getId();
					ArrayList<Solicitante> unosSolicitantes = padre.getControladorOfertas().listarSolicitantesDeOferta(idUnaOferta);
					
					//A�adimos a la lista de solicitantes los solicitantes de la oferta i
					for(int j=0; j<unosSolicitantes.size(); j++){
						lista_solicitantes.add(unosSolicitantes.get(j));
					}
				}
				fillTableSolicitantes(lista_solicitantes);
				ini.setPanelOnTab(ini.verDetallesDemandas, PanelInicio.DEMANDAS);
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

		JButton btnDarBajaSolicitante = new JButton("Borrar Solicitud");
		btnDarBajaSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDarBajaSolicitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( tablaSolicitantes.getSelectedRow() != -1){
					EliminarSolicitante es = new EliminarSolicitante(padre);
					es.setVisible(true);
					es.setAlwaysOnTop(true);
	
					if (es.getConfirmacionBorrado() == true) {
						try {
							
							
							int idSolicitante = lista_solicitantes.get(tablaSolicitantes.getSelectedRow()).getId();
							padre.getControladorOfertas().borrarSolicitanteDeOferta(idOferta, idSolicitante);
							JOptionPane.showMessageDialog(null,
									"Se ha borrado la demanda del solicitante\n");
							refrescar();
							ini.panel_demandas.refrescar();
						
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(
									null,
									"Error al borrar la demanda del solicitante\n"
											+ e1.getMessage());
						}
					}
	
					ini.setPanelOnTab(ini.verDetallesDemandas, PanelInicio.DEMANDAS);
				}
			}
		});

		scrollPane_1 = new JScrollPane(tablaSolicitantes);

		JLabel lblSolicitante = new JLabel("Solicitantes:");

		JLabel lblOferta = new JLabel("Oferta:");

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
																		.addGap(23)
																		.addComponent(
																				lblOferta,
																				GroupLayout.PREFERRED_SIZE,
																				40,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
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
																		.addGap(22)
																		.addComponent(
																				lblSolicitante))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(14)
																		.addComponent(
																				scrollPane_1,
																				GroupLayout.PREFERRED_SIZE,
																				886,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(329)
																		.addComponent(
																				btnVolver,
																				GroupLayout.PREFERRED_SIZE,
																				81,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(78)
																		.addComponent(
																				btnDarBajaSolicitante)))
										.addContainerGap(200, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(38)
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
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								textFieldOfertas,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblOferta))))
										.addGap(19)
										.addComponent(lblSolicitante)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(scrollPane_1,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(btnVolver)
														.addComponent(
																btnDarBajaSolicitante))
										.addContainerGap(163, Short.MAX_VALUE)));

		//scrollPane_1.setColumnHeaderView(tablaSolicitantes);

		if (textFieldOfertas.getText().isEmpty())
			this.fillTableSolicitantes(padre.getControladorOfertas()
					.listarSolicitantes(""));

		setLayout(groupLayout);
	}

	public void setIdOferta(int id) {
		idOferta = id;
		textFieldOfertas.setText(padre.getControladorOfertas().ConsultarOferta(idOferta).getTitulo());
	}
	
	public void refrescar() {
		lista_solicitantes = padre.getControladorOfertas().listarSolicitantesDeOferta(idOferta);
		fillTableSolicitantes(lista_solicitantes);
	}
}
