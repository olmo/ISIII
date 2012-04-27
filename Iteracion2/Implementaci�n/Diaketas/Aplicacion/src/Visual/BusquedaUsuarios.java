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
	private PanelInicio ini;
	
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
	public BusquedaUsuarios(VentanaPrincipal p, PanelInicio pIni) {
		ini=pIni;
		padre=p;
		setSize(PanelInicio.tamanoPaneles);
		
		table = new JTable();
		table.getTableHeader().setReorderingAllowed(false) ;
		//setLayout(null);
		
		choice_3 = new Choice();
		choice_3.setBounds(416, 13, 166, 23);
		add(choice_3);
		choice_3.add("todos");
		choice_3.add("trabajador");
		choice_3.add("beneficiario");
		choice_3.add("donante-Socio");
		choice_3.add("donante-Empresa");
		choice_3.add("donante-Colaborador");
		

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 86, 1000, 200);
		add(scrollPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(150, 300, 156, 28);
		add(btnVolver);
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerDetalles.setBounds(350, 300, 137, 28);
		add(btnVerDetalles);
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				DatosUsuario d=new DatosUsuario(padre,ini);

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
				ini.panelUsuarios.removeAll();
				ini.panelUsuarios.validate();
				ini.panelUsuarios.add(d);
				ini.panelUsuarios.validate();				
				ini.panelUsuarios.repaint();
				
				
			}
		});
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ini.panelUsuarios.removeAll();
//				ini.panelUsuarios.validate();
//				ini.panelUsuarios.add(new Inicio(padre,ini.getusuario()));
//				ini.panelUsuarios.validate();
//				ini.panelUsuarios.repaint();
				
				PanelPersonas b = new PanelPersonas(padre,ini);
				ini.panelUsuarios.removeAll();
				ini.panelUsuarios.validate();
				ini.panelUsuarios.add(b);
				ini.panelUsuarios.repaint();

			}
		});
		
		textField = new JTextField();
		textField.setBounds(10, 11, 295, 23);
		ini.panelUsuarios.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(15);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(315, 10, 95, 25);
		ini.panelUsuarios.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ini.panelUsuarios.removeAll();
				ini.panelUsuarios.validate();
				
				ini.panelUsuarios.add(new BusquedaUsuarios(padre,ini));
				ini.panelUsuarios.repaint();
//				String aux=choice_3.getSelectedItem();
//				//String aux = "todos";
//				if(aux.equals("todos")){
//					((BusquedaUsuarios) ini.panelUsuarios).setbusqueda(textField.getText(),null);
//					((BusquedaUsuarios) ini.panelUsuarios).setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),null));
//				}else{
//					((BusquedaUsuarios) ini.panelUsuarios).setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),aux));
//					((BusquedaUsuarios) ini.panelUsuarios).setbusqueda(textField.getText(),aux);
//				}

				ini.panelUsuarios.repaint();
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
