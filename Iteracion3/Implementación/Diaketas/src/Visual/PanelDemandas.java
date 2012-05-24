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
public class PanelDemandas extends JPanel {

	private JTextField textField_1;
	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane scrollPane;
	private JTable tablaAyudas = new JTable();
	private DefaultTableModel tabla_modelo;
	AyudaDB adb = new AyudaDB();
	BeneficiarioDB bdb = new BeneficiarioDB();
	TipoAyudaDB tabd = new TipoAyudaDB();
	ArrayList<Ayuda> listaAyudas = new ArrayList<Ayuda>();
	/**
	 * Create the panel.
	 */
	
	Hashtable<Integer, TipoAyuda> tiposAyudas = new Hashtable<Integer, TipoAyuda>();
	Hashtable<Integer, Beneficiario> beneficiarios = new Hashtable<Integer, Beneficiario>();
	
	public void fillTable(ArrayList<Ayuda> lista_ayudas){//Integer->Donaciones
		scrollPane.setVisible(true);
		listaAyudas = lista_ayudas;
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[5];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("Fecha");
		modelo.addColumn("Tipo de Ayuda");
		modelo.addColumn("Beneficiario");
		modelo.addColumn("Cantidad económica");
		modelo.addColumn("Observaciones");
		
		tiposAyudas.clear();
		beneficiarios.clear();
		
		ArrayList<TipoAyuda> tiposAyudas2 = tabd.getList();
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
		}
		tabla_modelo = modelo;
		this.tablaAyudas.setModel(tabla_modelo);
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
				
				//Obtenemos lista de ayudas
				listaAyudas = padre.getControladorAyudas().listarAyudasConcedidas(textField_1.getText());//textField_1.getText());
				//

				ini.panel_ayudas.fillTable(listaAyudas);
				ini.setPanelOnTab(ini.panel_ayudas, PanelInicio.AYUDAS);
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JButton btnAadirDemanda = new JButton("A\u00F1adir Demanda");
		btnAadirDemanda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAadirDemanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.configurar_tipo_ayuda.fillTable(tabd.getList());
				ini.setPanelOnTab(ini.configurar_tipo_ayuda, PanelInicio.AYUDAS);
	
			}
		});
		
		JButton btnGestinD = new JButton("Gesti\u00F3n Solicitante");
		btnGestinD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestinD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				ini.editar_ayuda.setParametros(listaAyudas.get(tablaAyudas.getSelectedRow()), beneficiarios.get(listaAyudas.get(tablaAyudas.getSelectedRow()).getIdBeneficiario()));
				ini.setPanelOnTab(ini.editar_ayuda, PanelInicio.AYUDAS);
				
			}
		});
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				ini.conceder_ayuda.fillTable(bdb.getBeneficiarios(""));
				ini.setPanelOnTab(ini.conceder_ayuda, PanelInicio.AYUDAS);
				
			}
		});
		
		scrollPane = new JScrollPane(tablaAyudas);
		scrollPane.setVisible(false);
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
			this.fillTable(padre.getControladorAyudas().listarAyudasConcedidas(""));
		
		setLayout(groupLayout);
		


	}
}
