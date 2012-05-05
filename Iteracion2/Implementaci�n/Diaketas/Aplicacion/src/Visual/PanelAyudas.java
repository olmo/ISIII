package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class PanelAyudas extends JPanel {

	private JTextField textField_1;
	VentanaPrincipal padre;
	private JTable table;
	PanelInicio ini;
	JScrollPane scrollPane;
	private JTable tablaAyudas = new JTable();
	private DefaultTableModel tabla_modelo;
	/**
	 * Create the panel.
	 */
	public void fillTable(ArrayList<Integer> lista_ayudas){//Integer->Donaciones
		scrollPane.setVisible(true);
		
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[5];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("Fecha");
		modelo.addColumn("Tipo de Ayuda");
		modelo.addColumn("Beneficiario");
		modelo.addColumn("Cantidad económica");
		modelo.addColumn("Observaciones");

		for(int i=0;i<lista_ayudas.size();i++){
			tupla[0]=lista_ayudas.get(i).intValue();//.get(i).getfecha
			tupla[1]=lista_ayudas.get(i).intValue();//.get(i).getcantidad
			tupla[2]=lista_ayudas.get(i).intValue();//.get(i).getDonante
			tupla[3]=lista_ayudas.get(i).intValue();//.get(i).getEstado
			tupla[4]=lista_ayudas.get(i).intValue();//.get(i).getEstado

			modelo.addRow(tupla);
		}
		tabla_modelo = modelo;
		this.tablaAyudas.setModel(tabla_modelo);
	}
	public PanelAyudas(VentanaPrincipal p, PanelInicio pIni) {

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
				System.out.println("Buscar Ayudas");
				//Obtenemos lista de ayudas
				ArrayList<Integer> listaBuscar = new ArrayList<Integer>();
				listaBuscar.add(3);
				//

				ini.panel_ayudas.fillTable(listaBuscar);
				ini.setPanelOnTab(ini.panel_ayudas, PanelInicio.AYUDAS);
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JButton button_6 = new JButton("Configurar Tipos de Ayuda");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(ini.configurar_tipo_ayuda, PanelInicio.AYUDAS);
	
			}
		});
		
		JButton button_7 = new JButton("Editar Ayuda");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(ini.editar_ayuda, PanelInicio.AYUDAS);
				
			}
		});
		
		JButton button_8 = new JButton("Conceder Ayuda");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
							.addComponent(button_5)
							.addGap(5)
							.addComponent(button_6))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(button_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(button_5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(button_6))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(110)
					.addComponent(button_8)
					.addGap(51)
					.addComponent(button_7)
					.addContainerGap(439, Short.MAX_VALUE))
		);
		
		//table = new JTable();
		//scrollPane.setViewportView(table);
		setLayout(groupLayout);
		


	}
}
