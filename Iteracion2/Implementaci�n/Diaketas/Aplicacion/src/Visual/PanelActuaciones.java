package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

import GestionActuacion.Actuacion;

@SuppressWarnings("serial")
public class PanelActuaciones extends JPanel {

	private JTextField textField_2;
	VentanaPrincipal padre;
	PanelInicio ini;
	private DefaultTableModel tabla_modelo;
	JScrollPane scrollPane_2;
	private JTable tablaActuaciones = new JTable();
	
	public void fillTable(ArrayList<Actuacion> lista_actuaciones){//Integer->Donaciones
		scrollPane_2.setVisible(true);
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[3];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("Fecha");
		modelo.addColumn("Tipo de Actuación");
		modelo.addColumn("Trabajador");
		for(int i=0;i<lista_actuaciones.size();i++){
			tupla[0]=lista_actuaciones.get(i).getFecha();//.get(i).getfecha
			tupla[1]=lista_actuaciones.get(i).getTipoActuacion();//.get(i).getTipoActuacion
			tupla[2]=lista_actuaciones.get(i).getIdTrabajador();//.get(i).getTrabajador
			modelo.addRow(tupla);
		}
		tabla_modelo = modelo;
		this.tablaActuaciones.setModel(tabla_modelo);
	}
	/**
	 * Create the panel.
	 */
	public PanelActuaciones(VentanaPrincipal p, PanelInicio pIni) {
		ini=pIni;
		setSize(PanelInicio.tamanoPaneles);

		padre = p;
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(15);
		
		JButton button_9 = new JButton("Buscar");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Obtenemos lista de actuaciones
				ArrayList<Actuacion> listaBuscar = padre.getControladorActuaciones().listarTodasActuaciones(textField_2.getText());
				//
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ini.panel_actuaciones.fillTable(listaBuscar);
				ini.setPanelOnTab(ini.panel_actuaciones, PanelInicio.ACTUACIONES);
			}
		});
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		scrollPane_2 = new JScrollPane(tablaActuaciones);
		scrollPane_2.setVisible(false);
		JButton button_10 = new JButton("Ir a donaci\u00F3n/ayuda");
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_2 = new GroupLayout(this);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 794, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(97))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(690, Short.MAX_VALUE))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(275)
							.addComponent(button_10))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(1)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(41)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		setLayout(gl_panel_2);

	}

}
