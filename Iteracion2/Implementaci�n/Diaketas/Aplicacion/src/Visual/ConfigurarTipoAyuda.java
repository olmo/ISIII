package Visual;

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
import javax.swing.table.DefaultTableModel;

import GestionAyudas.TipoAyuda;
import GestionAyudas.TipoAyudaDB;

public class ConfigurarTipoAyuda extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal padre;
	private JTable table;
	PanelInicio ini;
	private JScrollPane scrollPane;
	private JTable tablaAyudas = new JTable();
	private DefaultTableModel tabla_modelo;
	ArrayList<TipoAyuda> listaTiposAyudas;
	TipoAyudaDB tabd = new TipoAyudaDB();
	
	public void fillTable(ArrayList<TipoAyuda> lista_tipos_ayudas){//Integer->Donaciones
		scrollPane.setVisible(true);
		listaTiposAyudas = lista_tipos_ayudas;
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[2];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("Nombre");
		modelo.addColumn("Observaciones");

		for(int i=0;i<lista_tipos_ayudas.size();i++){
			tupla[0]=lista_tipos_ayudas.get(i).getNombre();
			tupla[1]=lista_tipos_ayudas.get(i).getObservaciones();

			modelo.addRow(tupla);
		}
		tabla_modelo = modelo;
		this.tablaAyudas.setModel(tabla_modelo);
	}
	
	public ConfigurarTipoAyuda(VentanaPrincipal p,PanelInicio pIni) {
		ini=pIni;
		this.padre = p;
		setSize(PanelInicio.tamanoPaneles);
		
		scrollPane = new JScrollPane(tablaAyudas);
		
		JButton btnAadirTipoDe = new JButton("A\u00F1adir Tipo de Ayuda");
		btnAadirTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.setPanelOnTab(ini.anadir_tipo_ayuda, PanelInicio.AYUDAS);
			}
		});
		
		JButton btnEditarTipoDe = new JButton("Editar Tipo de Ayuda");
		btnEditarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					TipoAyuda taSeleccionada = listaTiposAyudas.get(tablaAyudas.getSelectedRow());
					ini.editar_tipo_ayuda.setParametros(taSeleccionada);
					ini.setPanelOnTab(ini.editar_tipo_ayuda, PanelInicio.AYUDAS);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Ningun tipo de ayuda seleccionada");
				}
				
			}
		});
		
		JButton btnBorrarTipoDe = new JButton("Borrar Tipo de Ayuda");
		btnBorrarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Seguro que quiere eliminar?", "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
					TipoAyuda taSeleccionada = listaTiposAyudas.get(tablaAyudas.getSelectedRow());
					if(padre.getControladorAyudas().borrarTipoAyuda(taSeleccionada))
						JOptionPane.showMessageDialog(null, "Tipo de ayuda borrada");
						ini.configurar_tipo_ayuda.fillTable(tabd.getList());
						ini.setPanelOnTab(ini.configurar_tipo_ayuda, PanelInicio.AYUDAS);
				}else{
					//Continuar en la misma ventana
				}
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.setPanelOnTab(ini.panel_ayudas, PanelInicio.AYUDAS);

			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 554, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAadirTipoDe)
								.addComponent(btnEditarTipoDe)
								.addComponent(btnBorrarTipoDe)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(319)
							.addComponent(btnVolver)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(btnAadirTipoDe)
							.addGap(28)
							.addComponent(btnEditarTipoDe)
							.addGap(33)
							.addComponent(btnBorrarTipoDe)))
					.addGap(18)
					.addComponent(btnVolver)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		setLayout(groupLayout);
	}

}
