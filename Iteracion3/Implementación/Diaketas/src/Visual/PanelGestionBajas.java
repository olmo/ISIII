package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

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

import GestionPersona.Persona;
import GestionPersona.PersonaDB;
import GestionPersona.Socio;

@SuppressWarnings("serial")
public class PanelGestionBajas extends JPanel {

	private JTextField textField_1;
	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane scrollPane;
	private JTable tablaSolicitudes = new JTable();
	private DefaultTableModel tabla_modelo;
	ArrayList<ArrayList<Object>> listaSolicitudes = new ArrayList<ArrayList<Object>>();
	
	
	/**
	 * Create the panel.
	 */	
	public void fillTable(ArrayList<ArrayList<Object>> lista_resultados){//Integer->Donaciones
		scrollPane.setVisible(true);
		listaSolicitudes = lista_resultados;
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[5];
		
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("DNI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Fecha solicitado");
		modelo.addColumn("Borrado de BD");
			
		for(int i=0; i < lista_resultados.size(); i++){
			tupla[0]= ((Persona) lista_resultados.get(i).get(0)).getDni();
			tupla[1]= ((Persona) lista_resultados.get(i).get(0)).getNombre();
			tupla[2]= ((Persona) lista_resultados.get(i).get(0)).getApellido1() +" "+ ((Persona) lista_resultados.get(i).get(0)).getApellido2();
			tupla[3]= lista_resultados.get(i).get(1);
			tupla[4]= ((boolean) lista_resultados.get(i).get(2) ? "Si" : "No");
			modelo.addRow(tupla);
		}
		
		tabla_modelo = modelo;
		this.tablaSolicitudes.setModel(tabla_modelo);
	}
	
	public PanelGestionBajas(VentanaPrincipal p, PanelInicio pIni) {
		ini=pIni;
		padre = p;
		setSize(PanelInicio.tamanoPaneles);
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(15);
		
		JButton button_5 = new JButton("Buscar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obtenemos lista de personas
				listaSolicitudes = padre.getControladorPersonas().listarSolicitudesBajas(textField_1.getText());

				ini.panel_GestionBajas.fillTable(listaSolicitudes);
				ini.setPanelOnTab(ini.panel_GestionBajas, PanelInicio.GESTIONBAJAS);
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JButton btnDarBaja = new JButton("Dar Baja");
		btnDarBaja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfirmacionDarBaja cdb= new ConfirmacionDarBaja(padre);
				cdb.setVisible(true);
				cdb.setAlwaysOnTop(true);

				if(cdb.getConfirmacionBorrado()==true){
					try{
						//padre.getControladorPersonas().borrarDatosFamiliar(getId());
						JOptionPane.showMessageDialog(null, "Se ha dado de baja el usuario\n");
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Error al dar de baja\n"+e1.getMessage());
					}
				}
				//Obtenemos lista de personas
				listaSolicitudes = padre.getControladorPersonas().listarSolicitudesBajas(textField_1.getText());

				ini.panel_GestionBajas.fillTable(listaSolicitudes);
				ini.setPanelOnTab(ini.panel_GestionBajas, PanelInicio.GESTIONBAJAS);	
			}
		});

		
		JButton btnCancelarBaja = new JButton("Cancelar Solicitud Baja");
		btnCancelarBaja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfirmacionCancelarBaja ccb= new ConfirmacionCancelarBaja(padre);
				ccb.setVisible(true);
				ccb.setAlwaysOnTop(true);

				if(ccb.getconfirmacionCancelado()==true){
					try{
						int idSocio = ((Persona)listaSolicitudes.get(tablaSolicitudes.getSelectedRow()).get(0)).getId();
						//padre.getControladorPersonas().borrarDatosFamiliar(getId());
						JOptionPane.showMessageDialog(null, "Se ha cancelado la solicitud de baja\n");
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Error al dar de baja\n"+e1.getMessage());
					}
				}
				
				ini.setPanelOnTab(ini.panel_GestionBajas, PanelInicio.GESTIONBAJAS);
				/*ini.configurar_tipo_ayuda.fillTable(tabd.getList());*/
			}
		});
		
		scrollPane = new JScrollPane(tablaSolicitudes);
		scrollPane.setVisible(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(button_5)
					.addGap(642))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(386)
					.addComponent(btnDarBaja, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(83)
					.addComponent(btnCancelarBaja)
					.addContainerGap(421, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1076, Short.MAX_VALUE)
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
							.addGap(6)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDarBaja)
						.addComponent(btnCancelarBaja))
					.addGap(74))
		);
		
		if(textField_1.getText().isEmpty())
			this.fillTable(padre.getControladorPersonas().listarSolicitudesBajas(""));
		
		setLayout(groupLayout);
		


	}
}

