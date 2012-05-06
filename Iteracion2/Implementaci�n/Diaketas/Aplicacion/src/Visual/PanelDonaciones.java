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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import GestionDonaciones.Donacion;
import GestionPersona.DonanteDB;
import GestionPersona.Persona;
import GestionPersona.PersonaDB;

@SuppressWarnings("serial")
public class PanelDonaciones extends JPanel {
	JTextField textField;
	VentanaPrincipal padre;
	PanelInicio ini;
	TableModel tabla_modelo;
	JTable tablaDonaciones = new JTable();
	JScrollPane scrollPane;
	PersonaDB pbd = new PersonaDB();
	DonanteDB ddb = new DonanteDB();
	ArrayList<Donacion> listaBuscar;
	
	public void fillTable(ArrayList<Donacion> lista_donaciones){//Integer->Donaciones
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[4];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("Fecha");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Donante");
		modelo.addColumn("Estado");
		Persona p;
		for(int i=0;i<lista_donaciones.size();i++){
			tupla[0]=lista_donaciones.get(i).getDate();
			tupla[1]=lista_donaciones.get(i).getCantidad();//.get(i).getcantidad
			p=PersonaDB.getDatos(lista_donaciones.get(i).getIdDonante());
			tupla[2]=p.getNombre()+" "+p.getApellido1()+" "+p.getApellido2();//.get(i).getDonante
			tupla[3]=lista_donaciones.get(i).getEstado();//.get(i).getEstado
			modelo.addRow(tupla);
		}
		tabla_modelo = modelo;
		this.tablaDonaciones.setModel(tabla_modelo);
	}

	/**
	 * Create the panel.
	 */
	public PanelDonaciones(VentanaPrincipal p,PanelInicio pIni) {
		
		ini=pIni;
		padre=p;
		tablaDonaciones.getTableHeader().setReorderingAllowed(false);
		tablaDonaciones.setColumnSelectionAllowed(false);
		tablaDonaciones.setRowSelectionAllowed(true);
		setSize(PanelInicio.tamanoPaneles);
		textField = new JTextField();
		textField.setToolTipText("Búsqueda por fecha, tipo de donante, nombre de donante y estado de donación");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(15);
		
		
		scrollPane = new JScrollPane(tablaDonaciones);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Obtenemos lista de donaciones
				
				//listaBuscar.add(3);
				listaBuscar=padre.getControladorDonaciones().listarDonaciones(textField.getText());
				//

				ini.panel_donaciones.fillTable(listaBuscar);
				ini.setPanelOnTab(ini.panel_donaciones, PanelInicio.DONACIONES);

			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton button_1 = new JButton("A\u00F1adir Donaci\u00F3n");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				ini.aniadir_donacion.fillTable(ddb.getDonantes(""));
				ini.setPanelOnTab(ini.aniadir_donacion,PanelInicio.DONACIONES);

			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_2 = new JButton("A\u00F1adir Donante");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoUsuario nu = ini.nuevo_usuario;
				nu.modotrabajador();
				ini.setPanelOnTab(nu, PanelInicio.PERSONAS);

			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		scrollPane = new JScrollPane(tablaDonaciones);
		
		JButton button_3 = new JButton("Cancelar Donaci\u00F3n");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Esta seguro de que quiere confirmar la donación?", "Confirmacion de seguridad", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
					padre.getControladorDonaciones().cancelarDonacion(listaBuscar.get(tablaDonaciones.getSelectedRow()));
					listaBuscar=padre.getControladorDonaciones().listarDonaciones(textField.getText());
					//

					ini.panel_donaciones.fillTable(listaBuscar);
					ini.setPanelOnTab(ini.panel_donaciones, PanelInicio.DONACIONES);
					ini.panelDonaciones.validate();
					ini.panelDonaciones.repaint();
				}else{
					
					ini.panelDonaciones.validate();
					ini.panelDonaciones.repaint();
				}
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_4 = new JButton("Confirmar Donaci\u00F3n");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "¿Esta seguro de que quiere confirmar la donación?", "Confirmacion de seguridad", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
					
					
					padre.getControladorDonaciones().confirmarDonacion(listaBuscar.get(tablaDonaciones.getSelectedRow()));
					listaBuscar=padre.getControladorDonaciones().listarDonaciones(textField.getText());
					//

					ini.panel_donaciones.fillTable(listaBuscar);
					ini.setPanelOnTab(ini.panel_donaciones, PanelInicio.DONACIONES);
					ini.panelDonaciones.validate();
					ini.panelDonaciones.repaint();
				}else{
					
					ini.panelDonaciones.validate();
					ini.panelDonaciones.repaint();
				}
				
				
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1173, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(149)
							.addComponent(button_1)
							.addGap(18)
							.addComponent(button_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 976, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(button_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 607, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(2)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(184)
							.addComponent(button_4)
							.addGap(18)
							.addComponent(button_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(51)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		setLayout(gl_panel);


	}

}
