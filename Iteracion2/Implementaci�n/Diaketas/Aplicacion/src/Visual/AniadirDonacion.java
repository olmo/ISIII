package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import GestionDonaciones.Estado;
import GestionPersona.Donante;


public class AniadirDonacion extends JPanel{
	private JTextField textField;
	static private JTextField textField_1;
	private VentanaPrincipal padre;
	private static final long serialVersionUID = 1L;
	PanelInicio ini;
	private JTable tablaDonantes = new JTable();
	private DefaultTableModel tabla_modelo;
	JScrollPane scrollPane;
	ArrayList<Donante> lista_donantes;
	private Estado estado;
	
	
	public void fillTable(ArrayList<Donante> lista_donantes){//Integer->Donaciones
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[3];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("id");
		modelo.addColumn("DNI");
		modelo.addColumn("Nombre");
		for(int i=0;i<lista_donantes.size();i++){
			tupla[0]=lista_donantes.get(i).getId();
			tupla[1]=lista_donantes.get(i).getDni();
			tupla[2]=lista_donantes.get(i).getNombre()+" "
					+lista_donantes.get(i).getApellido1()+" "
					+lista_donantes.get(i).getApellido2();
			modelo.addRow(tupla);
		}
		tabla_modelo = modelo;
		this.lista_donantes = lista_donantes;
		this.tablaDonantes.setModel(tabla_modelo);
	}
	/**
	 * Create the panel.
	 */
	public AniadirDonacion(VentanaPrincipal p,PanelInicio pIni) {
		setBackground(UIManager.getColor("Button.background"));
		ini=pIni;
		padre=p;
		setSize(1100,650);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(15);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		scrollPane = new JScrollPane(tablaDonantes);
		
		JButton button_1 = new JButton("Volver");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ini.setPanelOnTab(ini.panel_donaciones,PanelInicio.DONACIONES);
				//ini.tabbedPane.addTab("Donaciones", null, ini.panel_donaciones, "Gesti�n de donaciones");
				//ini.tabbedPane.addTab("Donaciones", null, ini.panel_donaciones, "Gesti�n de donaciones");

//				ini.panelDonaciones.removeAll();
//				ini.panelDonaciones.add(new PanelDonaciones(padre, ini));
//				ini.panelDonaciones.validate();
//				ini.panelDonaciones.repaint();
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_3 = new JButton("Realizar Donaci�n");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "�Confirma la Donacion?", "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
					padre.getControladorDonaciones().aniadirDonacion(lista_donantes.get(tablaDonantes.getSelectedRow()), Float.valueOf(AniadirDonacion.textField_1.getText().trim()).floatValue(), estado.Pagado );
					
//					ini.panelDonaciones.removeAll();
//					ini.panelDonaciones.add(new PanelDonaciones(padre, ini));
//					ini.panelDonaciones.validate();					
//					ini.panelDonaciones.repaint();
					ini.setPanelOnTab(ini.panel_donaciones, PanelInicio.DONACIONES);
				}else{
					
					ini.panelDonaciones.validate();					
					ini.panelDonaciones.repaint();
					
				}
				
			
			}
		});
		
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Cantidad ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(15);
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(281)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 641, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addGap(179))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(51)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(40))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(301)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(375, Short.MAX_VALUE))
		);
		setLayout(gl_panel);
	}
}
