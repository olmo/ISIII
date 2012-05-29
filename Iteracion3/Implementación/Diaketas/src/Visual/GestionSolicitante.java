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
import GestionEmpresaOfertadora.Empresa_Ofertadora;
import GestionOfertas.ControladorOfertas;
import GestionSolicitante.Solicitante;

import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class GestionSolicitante extends JPanel {

	private JTextField campoBusqueda;
	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane panelResultBusqueda;
	private JTable tablaSolicitantes = new JTable();
	private DefaultTableModel tabla_modelo;

	ArrayList<Solicitante> lista_solicitantes = new ArrayList<Solicitante>();

	/**
	 * Create the panel.
	 */
	public void fillTable(ArrayList<Solicitante> lista) {
		panelResultBusqueda.setVisible(true);
		lista_solicitantes = lista;

		DefaultTableModel modelo = new DefaultTableModel();
		Object[] tupla = new Object[4];

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

		tabla_modelo = modelo;
		this.tablaSolicitantes.setModel(tabla_modelo);
	}

	public GestionSolicitante(VentanaPrincipal p, PanelInicio pIni) {

		ini = pIni;
		padre = p;
		setSize(PanelInicio.tamanoPaneles);
		campoBusqueda = new JTextField();
		campoBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoBusqueda.setColumns(15);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista_solicitantes = padre.getControladorOfertas().listarSolicitantes(campoBusqueda.getText());
				fillTable(lista_solicitantes);
				ini.setPanelOnTab(ini.gestion_solicitante, PanelInicio.DEMANDAS);
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnAddSolicitante = new JButton("A\u00F1adir Solicitante");
		btnAddSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddSolicitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.aniadir_solicitante.cargarInfo();
				ini.setPanelOnTab(ini.aniadir_solicitante, PanelInicio.DEMANDAS);
			}
		});

		JButton btnEdtiSolicitante = new JButton("Editar Solicitante");
		btnEdtiSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdtiSolicitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tablaSolicitantes.getSelectedRow() != -1){
					ini.editar_solicitante.setSolicitanteFromTable(lista_solicitantes.get(tablaSolicitantes.getSelectedRow()));
					ini.setPanelOnTab(ini.editar_solicitante, PanelInicio.DEMANDAS);
				}
			}
		});

		JButton btnElimSolicitante = new JButton("Eliminar Solicitante");
		btnElimSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnElimSolicitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( tablaSolicitantes.getSelectedRow() != -1){
					EliminarSolicitante es = new EliminarSolicitante(padre);
					es.setVisible(true);
					es.setAlwaysOnTop(true);
	
					if (es.getConfirmacionBorrado() == true) {
						try {
	
							padre.getControladorOfertas().borrarSolicitante(lista_solicitantes.get(tablaSolicitantes.getSelectedRow()));
							JOptionPane.showMessageDialog(null,
									"Se ha borrado el solicitante\n");
	
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(
									null,
									"Error al borrar solicitante\n"
											+ e1.getMessage());
						}
					}
					refrescar();
					ini.setPanelOnTab(ini.gestion_solicitante, PanelInicio.DEMANDAS);
				}
			}
		});

		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(ini.panel_demandas, PanelInicio.DEMANDAS);
			}
		});

		panelResultBusqueda = new JScrollPane(tablaSolicitantes);
		panelResultBusqueda.setVisible(false);

		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(campoBusqueda, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(btnBuscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelResultBusqueda, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEdtiSolicitante, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
								.addComponent(btnElimSolicitante, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAddSolicitante, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))))
					.addGap(23))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(393)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(601, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(btnBuscar))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(campoBusqueda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(43)
							.addComponent(panelResultBusqueda, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(201)
							.addComponent(btnAddSolicitante)
							.addGap(19)
							.addComponent(btnEdtiSolicitante)
							.addGap(18)
							.addComponent(btnElimSolicitante)))
					.addGap(18)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);

		if (campoBusqueda.getText().isEmpty()){
			this.fillTable(padre.getControladorOfertas().listarSolicitantes(""));
		}

		setLayout(groupLayout);

	}
	
	public void refrescar(){
		lista_solicitantes = padre.getControladorOfertas().listarSolicitantes("");
		fillTable(lista_solicitantes);
	}
}
