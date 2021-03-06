package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import GestionOfertas.Oferta;
import GestionSolicitante.Solicitante;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class PanelDemandas extends javax.swing.JPanel {

	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane scrollPane;

	private JTextField textField_1;
	private JTable tablaDemandas = new JTable();
	private DefaultTableModel tabla_modelo;
	private ArrayList<Solicitante> lista_solicitantes = new ArrayList<Solicitante>();
	private ArrayList<Oferta> lista_ofertas = new ArrayList<Oferta>();
	private HashMap<Integer, Integer> hashFilaOferta = new HashMap<Integer, Integer>();

	/**
	 * Create the panel.
	 */
	public void fillTable(ArrayList<Solicitante> lista) {
		scrollPane.setVisible(true);
		lista_solicitantes = lista;

		DefaultTableModel modelo = new DefaultTableModel();
		Object[] tupla = new Object[3];
		modelo.addColumn("Oferta");
		modelo.addColumn("Solicitante");

		
		int fila = 0;
		for (int i = 0; i < lista_solicitantes.size(); i++) {
			tupla[1] = lista_solicitantes.get(i).getNombre()+" "+lista_solicitantes.get(i).getApellido1()+" "+lista_solicitantes.get(i).getApellido2();
			
			lista_ofertas = padre.getControladorOfertas().listarOfertasDeSolicitante(lista_solicitantes.get(i).getId());
			
			for (int j = 0; j < lista_ofertas.size(); j++) {
				tupla[0] = lista_ofertas.get(j).getTitulo();
				modelo.addRow(tupla);
				hashFilaOferta.put(fila, lista_ofertas.get(j).getId());
				fila++;
			}
		}

		tabla_modelo = modelo;
		this.tablaDemandas.setModel(tabla_modelo);
	}

	public PanelDemandas(VentanaPrincipal p, PanelInicio pIni) {
		ini = pIni;
		padre = p;
		setSize(PanelInicio.tamanoPaneles);
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(15);

		JButton button_5 = new JButton("Buscar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Solo busca por solicitante, como busco por ofertas?
				lista_solicitantes = padre.getControladorOfertas().listarSolicitantes(textField_1.getText());
				fillTable(lista_solicitantes);
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

		JButton btnVerDetalles = new JButton("Ver Solicitantes de Ofertas");
		btnVerDetalles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idOferta;
				if( tablaDemandas.getSelectedRow() != -1 ){
					idOferta = hashFilaOferta.get(tablaDemandas.getSelectedRow());
					ini.verDetallesDemandas.setIdOferta(idOferta);
					ini.verDetallesDemandas.refrescar();
					ini.setPanelOnTab(ini.verDetallesDemandas, PanelInicio.DEMANDAS);
				}
			}
		});

		scrollPane = new JScrollPane(tablaDemandas);
		
		JLabel lblSolicitante = new JLabel("Solicitante:");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnVerDetalles, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAadirDemanda, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnGestinD, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(lblSolicitante)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(button_5)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_5)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSolicitante))))
					.addGap(48)
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

		if (textField_1.getText().isEmpty())
			this.fillTable(padre.getControladorOfertas().listarSolicitantes(""));

		setLayout(groupLayout);

	}
	
	public void refrescar(){
		lista_solicitantes = padre.getControladorOfertas().listarSolicitantes("");
		fillTable(lista_solicitantes);
	}
}
