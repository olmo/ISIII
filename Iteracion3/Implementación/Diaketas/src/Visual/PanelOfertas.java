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

import GestionAyudas.Ayuda;
import GestionAyudas.AyudaDB;
import GestionAyudas.TipoAyuda;
import GestionAyudas.TipoAyudaDB;
import GestionPersona.Beneficiario;
import GestionPersona.BeneficiarioDB;

@SuppressWarnings("serial")
public class PanelOfertas extends JPanel {

	private JTextField busqueda_txt;
	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane scrollPane;
	
	private JTable tablaOfertas = new JTable();
	//private DefaultTableModel tabla_modelo;
	
	AyudaDB adb = new AyudaDB();
	BeneficiarioDB bdb = new BeneficiarioDB();
	TipoAyudaDB tabd = new TipoAyudaDB();
	
	ArrayList<Ayuda> listaAyudas = new ArrayList<Ayuda>();
	
	Hashtable<Integer, TipoAyuda> tiposAyudas = new Hashtable<Integer, TipoAyuda>();
	Hashtable<Integer, Beneficiario> beneficiarios = new Hashtable<Integer, Beneficiario>();
	
	public void fillTable(ArrayList<Ayuda> lista_ayudas){//Integer->Donaciones
		scrollPane.setVisible(true);
		//listaAyudas = lista_ayudas;
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[4];
		
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("Título");
		modelo.addColumn("Empresa");
		modelo.addColumn("Puesto");
		modelo.addColumn("Fecha fin");
		
		tiposAyudas.clear();
		beneficiarios.clear();
		
		/*ArrayList<TipoAyuda> tiposAyudas2 = tabd.getList();
		ArrayList<Beneficiario> beneficiarios2 = bdb.getBeneficiarios("");
		
		//ordenamos los tipos de ayudas por su id para poder hacer la operacion de tupla[1]
		for (int i=0; i<tiposAyudas2.size(); i++){
			tiposAyudas.put(tiposAyudas2.get(i).getId(), tiposAyudas2.get(i));
		}
		//Ordenamos los beneficiarios por su id para tupla[2]
		for (int i=0; i<beneficiarios2.size(); i++){
			beneficiarios.put(beneficiarios2.get(i).getId(), beneficiarios2.get(i));
		}
		
		for(int i=0;i<lista_ayudas.size();i++){
			tupla[0]= lista_ayudas.get(i).getDate().toString();//.get(i).getfecha
			tupla[1]= ((TipoAyuda) tiposAyudas.get(lista_ayudas.get(i).getIdTipoAyuda())).getNombre();//.get(i).getcantidad
			tupla[2]= ((Beneficiario) beneficiarios.get(lista_ayudas.get(i).getIdBeneficiario())).getNombre();//.get(i).getDonante
			tupla[3]= lista_ayudas.get(i).getCantidadMonetaria();//.get(i).getEstado
			tupla[4]= lista_ayudas.get(i).getObservaciones();//.get(i).getEstado

			modelo.addRow(tupla);
		}*/
		
		this.tablaOfertas.setModel(modelo);
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
				
				//Obtenemos lista de ayudas
				/*listaAyudas = padre.getControladorAyudas().listarAyudasConcedidas(busqueda_txt.getText());

				ini.panel_ayudas.fillTable(listaAyudas);
				ini.setPanelOnTab(ini.panel_ayudas, PanelInicio.AYUDAS);*/
			}
		});
		button_buscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_ver = new JButton("Ver Detalles");
		button_ver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_ver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				ini.editar_ayuda.setParametros(listaAyudas.get(tablaOfertas.getSelectedRow()), beneficiarios.get(listaAyudas.get(tablaOfertas.getSelectedRow()).getIdBeneficiario()));
				ini.setPanelOnTab(ini.editar_ayuda, PanelInicio.AYUDAS);
				
			}
		});
		
		JButton button_add = new JButton("A\u00F1adir Oferta");
		button_add.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ini.setPanelOnTab(ini.anadir_oferta, PanelInicio.OFERTAS);
				/*ini.conceder_ayuda.fillTable(bdb.getBeneficiarios(""));
				ini.setPanelOnTab(ini.conceder_ayuda, PanelInicio.AYUDAS);*/
				
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
			this.fillTable(padre.getControladorAyudas().listarAyudasConcedidas(""));
		
		setLayout(groupLayout);
		


	}
}
