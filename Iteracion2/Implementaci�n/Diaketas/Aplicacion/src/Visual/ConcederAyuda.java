package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import GestionActuacion.TipoActuacion;
import GestionAyudas.Ayuda;
import GestionAyudas.TipoAyuda;
import GestionAyudas.TipoAyudaDB;
import GestionPersona.Beneficiario;
import GestionPersona.BeneficiarioDB;
import GestionPersona.TrabajadorDB;

public class ConcederAyuda extends JPanel {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal padre;
	private JTextField textField;
	private JTextField textField_1;
	PanelInicio ini;
	private JScrollPane scrollPane;
	private JTable tablaAyudas = new JTable();
	private DefaultTableModel tabla_modelo;
	BeneficiarioDB bdb = new BeneficiarioDB();
	TipoAyudaDB tabd = new TipoAyudaDB();
	ArrayList<Beneficiario> listaBeneficiarios;
	ArrayList<TipoAyuda> tiposAyudas;
	JTextArea textArea;
	JComboBox comboBox;
	TrabajadorDB tbd = new TrabajadorDB();
	
	public void fillTable(ArrayList<Beneficiario> lista_beneficiarios){//Integer->Donaciones
		scrollPane.setVisible(true);
		
		DefaultTableModel modelo = new DefaultTableModel();
		listaBeneficiarios = lista_beneficiarios;
		Object [] tupla = new Object[2];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("DNI");
		modelo.addColumn("Nombre");

		for(int i=0;i<lista_beneficiarios.size();i++){
			tupla[0]=lista_beneficiarios.get(i).getDni();
			tupla[1]=lista_beneficiarios.get(i).getNombre();

			modelo.addRow(tupla);
		}
		tabla_modelo = modelo;
		this.tablaAyudas.setModel(tabla_modelo);
		tiposAyudas = tabd.getList();
	}
	
	public ConcederAyuda(VentanaPrincipal p, PanelInicio pIni) {
		ini=pIni;
		this.padre = p;
		setSize(PanelInicio.tamanoPaneles);
		textField = new JTextField();
		textField.setColumns(10);
		
		tiposAyudas = tabd.getList();
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.conceder_ayuda.fillTable(bdb.getBeneficiarios(textField.getText()));
				ini.setPanelOnTab(ini.conceder_ayuda, PanelInicio.AYUDAS);
			}
		});
		
		scrollPane = new JScrollPane(tablaAyudas);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Desea cancelar la ayuda?", "Confirmacion", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
					ini.setPanelOnTab(ini.panel_ayudas, PanelInicio.AYUDAS);
//					ini.panelAyudas.removeAll();
//					
//					ini.panelAyudas.add(new PanelAyudas(padre, ini));
//					ini.panelAyudas.validate();
//					
//					ini.panelAyudas.repaint();
				}
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textArea = new JTextArea();
		
		comboBox = new JComboBox();
		
		for(int i=0; i<tiposAyudas.size(); i++){
			comboBox.addItem((Object)tiposAyudas.get(i).getNombre());
		}
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Desea conceder la ayuda?", "Confirmacion", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
					
					int id_obj = padre.getControladorAyudas().concederAyuda(listaBeneficiarios.get(tablaAyudas.getSelectedRow()), textArea.getText(), tiposAyudas.get(comboBox.getSelectedIndex()), Float.valueOf(textField_1.getText()));
					
					ArrayList<Ayuda> listaAyudas = padre.getControladorAyudas().listarAyudasConcedidas("");
					
					if(id_obj != -1){
						padre.getControladorActuaciones().anotarActuacion(id_obj, tbd.getTrabajador(padre.getusuario()), TipoActuacion.conceder_ayuda);
					}else{
						JOptionPane.showMessageDialog(null, "No se pudo conceder la ayuda" );
					}
					ini.panel_ayudas.fillTable(listaAyudas);
					
					ini.setPanelOnTab(ini.panel_ayudas, PanelInicio.AYUDAS);
//					ini.panelAyudas.removeAll();
//					
//					ini.panelAyudas.add(new PanelAyudas(padre, ini));
//					ini.panelAyudas.validate();
//					//Codigo de modificacion del tipo de ayuda
//					ini.panelAyudas.repaint();
				}
			}
		});
		
		
	
		
		
		
		JButton btnAadirTipoDe = new JButton("A\u00F1adir Tipo de Ayuda");
		btnAadirTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.setPanelOnTab(ini.anadir_tipo_ayuda, PanelInicio.AYUDAS);
//				ini.panelAyudas.removeAll();
//				
//				ini.panelAyudas.add(new AnadirTipoAyuda(padre,ini));
//				ini.panelAyudas.validate();
//				
//				ini.panelAyudas.repaint();
			}
		});
		
		JLabel lblCantidadEconomica = new JLabel("Cantidad economica");
		
		
		
		JLabel label = new JLabel("\u20AC");
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(226)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnGuardar)
									.addGap(97))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAadirTipoDe)
									.addContainerGap())))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCantidadEconomica)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label))
						.addComponent(lblObservaciones)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAadirTipoDe))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCantidadEconomica)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
							.addGap(62)
							.addComponent(lblObservaciones)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textArea)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnGuardar))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		

	}
}
