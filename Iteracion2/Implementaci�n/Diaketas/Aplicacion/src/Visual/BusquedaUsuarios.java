package Visual;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import GestionPersona.Beneficiario;
import GestionPersona.Colaborador;
import GestionPersona.Empresa;
import GestionPersona.Socio;
import GestionPersona.Trabajador;

public class BusquedaUsuarios extends JPanel {
	private static final long serialVersionUID = 1L;
	private TableModel tabla_modelo;
	private JTextField textField;
	private VentanaPrincipal padre;
	private PanelInicio ini;
	
	private String busqueda;
	private String rolbusqueda;
	private JTable table;
	private Choice choice_3;
	
	public TableModel getTabla() {
		return tabla_modelo;
	}

	public void setTabla(TableModel tabla) {
		this.tabla_modelo = tabla;
		table.setModel((TableModel) tabla_modelo);
	}


	/**
	 * Create the panel.
	 */
	public BusquedaUsuarios(VentanaPrincipal p, PanelInicio pIni) {
		ini=pIni;
		padre=p;
		setSize( new Dimension(1100, 650));
		setLayout(null);
		table = new JTable();
		table.getTableHeader().setReorderingAllowed(false) ;
		setLayout(null);
		
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
		scrollPane.setBounds(36, 86, 1028, 411);
		add(scrollPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(450, 538, 156, 28);
		add(btnVolver);
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerDetalles.setBounds(616, 538, 137, 28);
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
					ini.panelUsuarios.repaint();
					
					
				
			}
		});
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ini.panelUsuarios.removeAll();
				ini.panelUsuarios.validate();
				ini.panelUsuarios.add(new PanelPersonas(padre,ini));
				ini.panelUsuarios.repaint();

			}
		});
		
		textField = new JTextField();
		textField.setBounds(10, 11, 295, 23);
		add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(15);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(315, 10, 95, 25);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				BusquedaUsuarios b = new BusquedaUsuarios(padre,ini);
//				String aux=choice_3.getSelectedItem();
//				if(aux.equals("todos")){
//					setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),null));
//					setbusqueda(textField.getText(),null);
//				}else{
//					setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),aux));
//					setbusqueda(textField.getText(),aux);
//				}
//				ini.panelUsuarios.removeAll();
//				ini.panelUsuarios.validate();
//				ini.panelUsuarios.add(b);
//				//padre.getContentPane().removeAll();
//				//padre.getContentPane().validate();
//				//padre.getContentPane().add(b);
//				ini.panelUsuarios.repaint();
				BusquedaUsuarios b = new BusquedaUsuarios(padre,ini);
				String aux=choice_3.getSelectedItem();
				if(aux.equals("todos")){
					b.setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),null));
					b.setbusqueda(textField.getText(),null);
				}else{
					b.setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),aux));
					b.setbusqueda(textField.getText(),aux);
				}
				
				ini.panelUsuarios.removeAll();
				ini.panelUsuarios.validate();
				ini.panelUsuarios.add(b);
				ini.panelUsuarios.repaint();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
	}

	public void setbusqueda(String text, String aux) {
		busqueda=text;
		rolbusqueda=aux;
		
	}

	

	
	
	
}
