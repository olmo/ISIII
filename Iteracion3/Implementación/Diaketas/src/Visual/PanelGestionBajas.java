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

import GestionAyudas.Ayuda;
import GestionAyudas.AyudaDB;
import GestionAyudas.TipoAyuda;
import GestionAyudas.TipoAyudaDB;
import GestionPersona.Beneficiario;
import GestionPersona.BeneficiarioDB;

@SuppressWarnings("serial")
public class PanelGestionBajas extends JPanel {

	private JTextField textField_1;
	VentanaPrincipal padre;
	PanelInicio ini;
	JScrollPane scrollPane;
	private JTable tablaAyudas = new JTable();
	private DefaultTableModel tabla_modelo;
	//AyudaDB adb = new AyudaDB();
	//BeneficiarioDB bdb = new BeneficiarioDB();
	//TipoAyudaDB tabd = new TipoAyudaDB();
	//ArrayList<Ayuda> listaAyudas = new ArrayList<Ayuda>();
	/**
	 * Create the panel.
	 */
	
	//Hashtable<Integer, TipoAyuda> tiposAyudas = new Hashtable<Integer, TipoAyuda>();
	//Hashtable<Integer, Beneficiario> beneficiarios = new Hashtable<Integer, Beneficiario>();
	
	public void fillTable(ArrayList<Ayuda> lista_ayudas){//Integer->Donaciones
		scrollPane.setVisible(true);
		//listaAyudas = lista_ayudas;
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[5];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("DNI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Fecha solicitado");
		modelo.addColumn("Borrado de BD");
		
		/*
		//tiposAyudas.clear();
		//beneficiarios.clear();
		
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
		*/
		tabla_modelo = modelo;
		this.tablaAyudas.setModel(tabla_modelo);
	}
	public PanelGestionBajas(VentanaPrincipal p, PanelInicio pIni) {

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
				/*
				listaAyudas = padre.getControladorAyudas().listarAyudasConcedidas(textField_1.getText());//textField_1.getText());
				//

				ini.panel_ayudas.fillTable(listaAyudas);*/
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
				
				ini.setPanelOnTab(ini.panel_GestionBajas, PanelInicio.GESTIONBAJAS);
				/*ini.configurar_tipo_ayuda.fillTable(tabd.getList());*/
	
			}
		});

		
		JButton btnCancelarBaja = new JButton("Cancelar Baja");
		btnCancelarBaja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfirmacionCancelarBaja ccb= new ConfirmacionCancelarBaja(padre);
				ccb.setVisible(true);
				ccb.setAlwaysOnTop(true);

				if(ccb.getconfirmacionCancelado()==true){
					try{
						//padre.getControladorPersonas().borrarDatosFamiliar(getId());
						//JOptionPane.showMessageDialog(null, "Se ha dado de baja el usuario\n");
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Error al dar de baja\n"+e1.getMessage());
					}
				}
				
				ini.setPanelOnTab(ini.panel_GestionBajas, PanelInicio.GESTIONBAJAS);
				/*ini.configurar_tipo_ayuda.fillTable(tabd.getList());*/
			}
		});
		
		scrollPane = new JScrollPane(tablaAyudas);
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
			this.fillTable(padre.getControladorAyudas().listarAyudasConcedidas(""));
		
		setLayout(groupLayout);
		


	}
}

