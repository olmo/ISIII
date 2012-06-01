package Visual;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;

import GestionAyudas.Ayuda;
import GestionAyudas.TipoAyuda;
import GestionDonaciones.Donacion;
import GestionPersona.Beneficiario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DatosDonacionesMovil extends JPanel {
	private JTable table;
	private TableModel tabla_modelo;
	VentanaPrincipalMovil padre;
	JScrollPane scrollPane = new JScrollPane();
	ArrayList<Donacion> listaDonaciones = new ArrayList<Donacion>();


	public TableModel getTabla() {
		return tabla_modelo;
	}
	
	public void setTabla(TableModel tabla) {
		this.tabla_modelo = tabla;
		table.setModel((TableModel) tabla_modelo);
	}

	public void fillTable(ArrayList<Donacion> lista_donaciones){//Integer->Donaciones
		scrollPane.setVisible(true);
		listaDonaciones = lista_donaciones;
		DefaultTableModel modelo = new DefaultTableModel();
		Object [] tupla = new Object[3];
		//Relleneamos la cabecera de la tabla.
		modelo.addColumn("Fecha");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Estado");
		for(int i=0;i<lista_donaciones.size();i++){
			tupla[0]= lista_donaciones.get(i).getDate().toString();//.get(i).getfecha
			tupla[1]= lista_donaciones.get(i).getCantidad(); //Cantidad 
			tupla[2]= lista_donaciones.get(i).getEstado(); //Estado
		
			modelo.addRow(tupla);
		}
		tabla_modelo = modelo;
		this.table.setModel(tabla_modelo);
	}
	/**
	 * Create the panel.
	 */
	public DatosDonacionesMovil(VentanaPrincipalMovil mipadre) {
		setLayout(null);
		padre = mipadre;
		
		scrollPane.setBounds(26, 95, 257, 351);
		add(scrollPane);
		
		table = new JTable();
		table.getTableHeader().setReorderingAllowed(false) ;
		setLayout(null);
		scrollPane.setViewportView(table);
		
		listaDonaciones = padre.getControladorMovil().listarDonaciones(padre.getIDsesion());
	//	JOptionPane.showMessageDialog(null,"SIZE "+listaDonaciones.size());
		this.fillTable(listaDonaciones);
		
		JButton volverBoton = new JButton("Volver");
		volverBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelInicioMovil panIni = new PanelInicioMovil(padre,padre.getusuario());
				padre.getContentPane().removeAll();
				padre.getContentPane().validate();
				padre.getContentPane().add(panIni);
				padre.getContentPane().repaint();
			}
		});
		volverBoton.setBounds(98, 469, 112, 43);
		add(volverBoton);

	}
}
