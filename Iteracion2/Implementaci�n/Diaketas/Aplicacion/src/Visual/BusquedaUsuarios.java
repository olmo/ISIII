package Visual;

import javax.swing.JPanel;
import java.awt.Choice;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import GestionPersona.Beneficiario;
import GestionPersona.Colaborador;
import GestionPersona.Empresa;
import GestionPersona.Socio;
import GestionPersona.Trabajador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusquedaUsuarios extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private TableModel tabla_modelo;
	private JTextField textField;
	private VentanaPrincipal padre;
	private Choice choice_3;
	
	private String busqueda;
	private String rolbusqueda;
	
	public TableModel getTabla() {
		return tabla_modelo;
	}

	public void setTabla(TableModel tabla) {
		this.tabla_modelo = tabla;
		table.setModel(tabla_modelo);
	}


	/**
	 * Create the panel.
	 */
	public BusquedaUsuarios(VentanaPrincipal p) {
		padre=p;
		setSize(padre.panelUsuarios.getSize());
		
		table = new JTable();
		table.getTableHeader().setReorderingAllowed(false) ;
		//setLayout(null);
		
		choice_3 = new Choice();
		choice_3.setBounds(416, 13, 166, 23);
		padre.panelUsuarios.add(choice_3);
		choice_3.add("todos");
		choice_3.add("trabajador");
		choice_3.add("beneficiario");
		choice_3.add("donante-Socio");
		choice_3.add("donante-Empresa");
		choice_3.add("donante-Colaborador");
		

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 86, 1000, 200);
		padre.panelUsuarios.add(scrollPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(150, 300, 156, 28);
		padre.panelUsuarios.add(btnVolver);
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerDetalles.setBounds(350, 300, 137, 28);
		padre.panelUsuarios.add(btnVerDetalles);
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				DatosUsuario d=new DatosUsuario(padre);

				d.setbusquedaanterior(busqueda, rolbusqueda);
			
				Integer id=new Integer(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				String tipo=table.getModel().getValueAt(table.getSelectedRow(), 5).toString();
				
				if(tipo.equals("trabajador")){
					Trabajador t=padre.getcontrolador().consultarTrabajador(id);
					d.rellenar(t);
					d.modotrabajador();
				}else if(tipo.equals("beneficiario")){
					Beneficiario t=padre.getcontrolador().consultarBeneficiario(id);
					d.rellenar(t);
					d.modobeneficiario();
				}else if(tipo.equals("donante-Socio")){
					Socio s=padre.getcontrolador().consultarSocio(id);
						d.rellenar(s);
						d.modosocio();
				}else if(tipo.equals("donante-Empresa")){
					Empresa s=padre.getcontrolador().consultarEmpresa(id);
					d.rellenar(s);
					d.modoempresa();
				}else if(tipo.equals("donante-Colaborador")){
					Colaborador s=padre.getcontrolador().consultarColaborador(id);
					d.rellenar(s);
					d.modocolaborador();
				}
						
			 
				d.setbusquedaanterior(busqueda, rolbusqueda);
				padre.panelUsuarios.removeAll();
				padre.panelUsuarios.validate();
				padre.panelUsuarios.add(d);
				padre.panelUsuarios.validate();				
				padre.panelUsuarios.repaint();
				
				
			}
		});
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				padre.panelUsuarios.removeAll();
//				padre.panelUsuarios.validate();
//				padre.panelUsuarios.add(new Inicio(padre,padre.getusuario()));
//				padre.panelUsuarios.validate();
//				padre.panelUsuarios.repaint();
				
				PanelPersonas b = new PanelPersonas(padre,padre.getusuario());
				padre.panelUsuarios.removeAll();
				padre.panelUsuarios.validate();
				padre.panelUsuarios.add(b);
				padre.panelUsuarios.repaint();

			}
		});
		
		textField = new JTextField();
		textField.setBounds(10, 11, 295, 23);
		padre.panelUsuarios.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(15);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(315, 10, 95, 25);
		padre.panelUsuarios.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				padre.panelUsuarios.removeAll();
				padre.panelUsuarios.validate();
				
				padre.panelUsuarios.add(new BusquedaUsuarios(padre));
				padre.panelUsuarios.repaint();
//				String aux=choice_3.getSelectedItem();
//				//String aux = "todos";
//				if(aux.equals("todos")){
//					((BusquedaUsuarios) padre.panelUsuarios).setbusqueda(textField.getText(),null);
//					((BusquedaUsuarios) padre.panelUsuarios).setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),null));
//				}else{
//					((BusquedaUsuarios) padre.panelUsuarios).setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),aux));
//					((BusquedaUsuarios) padre.panelUsuarios).setbusqueda(textField.getText(),aux);
//				}

				padre.panelUsuarios.repaint();
//				//BusquedaUsuarios b = new BusquedaUsuarios(padre);
//				String aux=choice_3.getSelectedItem();
//				if(aux.equals("todos")){
//					setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),null));
//					setbusqueda(textField.getText(),null);
//				}else{
//					setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),aux));
//					setbusqueda(textField.getText(),aux);
//				}
//				padre.panelUsuarios.removeAll();
//				padre.panelUsuarios.validate();
//				padre.panelUsuarios.add(b);
//				padre.panelUsuarios.repaint();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		
	}

	public void setbusqueda(String text, String aux) {
		busqueda=text;
		rolbusqueda=aux;
		
	}

	

	
	
	
}
