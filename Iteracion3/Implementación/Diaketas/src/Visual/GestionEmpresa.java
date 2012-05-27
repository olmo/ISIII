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
import GestionAyudas.TipoAyuda;
import GestionEmpresaOfertadora.Empresa_Ofertadora;
import GestionPersona.Beneficiario;

import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class GestionEmpresa extends JPanel {

	private JTextField txtBuscar;
	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane scrollPane;
	private JTable tablaEmpresas = new JTable();
	private DefaultTableModel tabla_modelo;
	
	ArrayList<Empresa_Ofertadora> lista_empresas = new ArrayList<Empresa_Ofertadora>();
	
	public void fillTable(ArrayList<Empresa_Ofertadora> lista) {// Integer->Donaciones
		scrollPane.setVisible(true);
		lista_empresas = lista;

		DefaultTableModel modelo = new DefaultTableModel();
		Object[] tupla = new Object[4];
		// Relleneamos la cabecera de la tabla.
		modelo.addColumn("Nombre");
		modelo.addColumn("Sector");
		modelo.addColumn("Localidad");
		modelo.addColumn("Teléfono");
		
		for(int i=0;i<lista_empresas.size();i++){
			tupla[0]= lista_empresas.get(i).getNombre();
			tupla[1]= lista_empresas.get(i).getSector();
			tupla[2]= lista_empresas.get(i).getLocalidad();
			tupla[3]= lista_empresas.get(i).getTelefono();

			modelo.addRow(tupla);
		}

		tabla_modelo = modelo;
		this.tablaEmpresas.setModel(tabla_modelo);
	}

	public GestionEmpresa(VentanaPrincipal p, PanelInicio pIni) {

		// setSize(1100, 500);
		ini = pIni;
		padre = p;
		setSize(PanelInicio.tamanoPaneles);
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBuscar.setColumns(15);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista_empresas = padre.getControladorOfertas().ListarEmpresaOfertadora(txtBuscar.getText());
				fillTable(lista_empresas);
				ini.setPanelOnTab(ini.gestion_empresa, PanelInicio.OFERTAS);
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		
		JButton btnAddEmpresa = new JButton("A\u00F1adir Empresa");
		btnAddEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(new AnadirEditarEmpresa(padre, ini, null), PanelInicio.OFERTAS);
			}
		});

		JButton btnEditarEmpresa = new JButton("Editar Empresa");
		btnEditarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(new AnadirEditarEmpresa(padre, ini, lista_empresas.get(tablaEmpresas.getSelectedRow())), PanelInicio.OFERTAS);
			}
		});

		JButton btnEliminarEmpresa = new JButton("Eliminar Empresa");
		btnEliminarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "¿Esta seguro de que quiere borrar la empresa?", "Confirmacion de seguridad", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
					padre.getControladorOfertas().BorrarEmpresaOfertadora(lista_empresas.get(tablaEmpresas.getSelectedRow()));
					fillTable(padre.getControladorOfertas().ListarEmpresaOfertadora(""));
				}
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(ini.panel_ofertas, PanelInicio.OFERTAS);
			}
		});

		scrollPane = new JScrollPane(tablaEmpresas);
		scrollPane.setVisible(false);
		
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(btnBuscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(34)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnEditarEmpresa, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addComponent(btnEliminarEmpresa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnAddEmpresa, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
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
							.addComponent(btnBuscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(201)
					.addComponent(btnAddEmpresa)
					.addGap(19)
					.addComponent(btnEditarEmpresa)
					.addGap(18)
					.addComponent(btnEliminarEmpresa)
					.addGap(18)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(294, Short.MAX_VALUE))
		);

		if (txtBuscar.getText().isEmpty())
			this.fillTable(padre.getControladorOfertas().ListarEmpresaOfertadora(""));

		setLayout(groupLayout);

	}
}
