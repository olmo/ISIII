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

import GestionAyudas.TipoAyuda;
import GestionAyudas.TipoAyudaDB;
import GestionPersona.Beneficiario;
import GestionPersona.BeneficiarioDB;

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
	
	public void fillTable(ArrayList<Beneficiario> lista_beneficiarios){//Integer->Donaciones
		scrollPane.setVisible(true);
		
		DefaultTableModel modelo = new DefaultTableModel();
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
	}
	
	public ConcederAyuda(VentanaPrincipal p, PanelInicio pIni) {
		ini=pIni;
		this.padre = p;
		setSize(PanelInicio.tamanoPaneles);
		textField = new JTextField();
		textField.setColumns(10);
		
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
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Desea conceder la ayuda?", "Confirmacion", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
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
		
		JComboBox comboBox = new JComboBox();
		
		ArrayList<TipoAyuda> tiposAyudas = tabd.getList();
		
		for(int i=0; i<tiposAyudas.size(); i++){
			comboBox.addItem((Object)tiposAyudas.get(i));
		}
		
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		
		JTextArea textArea = new JTextArea();
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
