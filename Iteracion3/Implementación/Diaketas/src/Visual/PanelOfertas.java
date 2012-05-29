package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import GestionEmpresaOfertadora.Empresa_OfertadoraDB;
import GestionOfertas.Oferta;

@SuppressWarnings("serial")
public class PanelOfertas extends JPanel {

	private JTextField busqueda_txt;
	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane scrollPane;
	
	private JTable tablaOfertas = new JTable();
	private DefaultTableModel tabla_modelo;
	
	ArrayList<Oferta> listaOfertas = new ArrayList<Oferta>();
	
	public void fillTable(ArrayList<Oferta> lista_ofertas){//Integer->Donaciones
		scrollPane.setVisible(true);
		listaOfertas = lista_ofertas;
		
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[4];
		
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("Título");
		modelo.addColumn("Empresa");
		modelo.addColumn("Puesto");
		modelo.addColumn("Fecha fin");
		
		Empresa_OfertadoraDB eodb = new Empresa_OfertadoraDB();
		
		for(int i=0;i<listaOfertas.size();i++){
			tupla[0]= listaOfertas.get(i).getTitulo();
			tupla[1]= eodb.getEmpresaOfertadora(listaOfertas.get(i).getId_empresa()).toString();
			tupla[2]= listaOfertas.get(i).getPuesto();
			tupla[3]= listaOfertas.get(i).getFechafin().toLocaleString();

			modelo.addRow(tupla);
		}

		tabla_modelo = modelo;
		this.tablaOfertas.setModel(tabla_modelo);
	}
	public PanelOfertas(VentanaPrincipal p, PanelInicio pIni) {
		ini=pIni;
		padre = p;
		setSize(PanelInicio.tamanoPaneles);
		busqueda_txt = new JTextField();
		busqueda_txt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		busqueda_txt.setColumns(15);
		
		JButton button_buscar = new JButton("Buscar");
		button_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaOfertas = padre.getControladorOfertas().ListarOfertas(busqueda_txt.getText());
				fillTable(listaOfertas);
				ini.setPanelOnTab(ini.panel_ofertas, PanelInicio.OFERTAS);
			}
		});
		button_buscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_ver = new JButton("Ver Detalles");
		button_ver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_ver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(new AnadirEditarOferta(padre,ini,listaOfertas.get(tablaOfertas.getSelectedRow())), PanelInicio.OFERTAS);
				
			}
		});
		
		JButton button_add = new JButton("A\u00F1adir Oferta");
		button_add.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(new AnadirEditarOferta(padre,ini,null), PanelInicio.OFERTAS);
			}
		});
		
		scrollPane = new JScrollPane(tablaOfertas);
		scrollPane.setVisible(false);
		
		JButton button_empresa = new JButton("Gesti\u00F3n empresa");
		button_empresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_empresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(ini.gestion_empresa, PanelInicio.OFERTAS);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(busqueda_txt, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(button_buscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(button_empresa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_ver, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_add, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(button_buscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(busqueda_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(199)
					.addComponent(button_add)
					.addGap(51)
					.addComponent(button_ver)
					.addGap(50)
					.addComponent(button_empresa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(275, Short.MAX_VALUE))
		);
		
		if(busqueda_txt.getText().isEmpty())
			this.fillTable(padre.getControladorOfertas().ListarOfertas(""));
		
		setLayout(groupLayout);
		


	}
}
