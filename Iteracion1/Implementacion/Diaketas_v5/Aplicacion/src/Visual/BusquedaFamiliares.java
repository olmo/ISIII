package Visual;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//import javax.swing.table.TableModel;
import javax.swing.table.TableModel;

import GestionPersona.Familiar;

public class BusquedaFamiliares extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private TableModel tabla_modelo;
	private JTextField textField;
	private VentanaPrincipal padre;
	private Choice choice_3;
	
	private int id_beneficiario;
	/**
	 * Create the panel.
	 */
	public TableModel getTabla() {
		return tabla_modelo;
	}

	public void setTabla(TableModel tabla) {
		this.tabla_modelo = tabla;
		table.setModel(tabla_modelo);
	}
	
	public BusquedaFamiliares(VentanaPrincipal p,Integer id) {
		padre=p;
		id_beneficiario=id;
		setSize(1200, 700);
		setLayout(null);
		
		table = new JTable();
		setTabla(padre.getcontrolador().listarFamiliares(id));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 86, 1200, 524);
		add(scrollPane);
		table.getTableHeader().setReorderingAllowed(false) ;
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(456, 638, 156, 28);
		add(btnVolver);
		
		choice_3 = new Choice();
		choice_3.setBounds(416, 13, 166, 23);
		add(choice_3);
		choice_3.add("todos");
		choice_3.add("beneficiario");
		choice_3.add("trabajador");
		choice_3.add("donante-Socio");
		choice_3.add("donante-Empresa");
		choice_3.add("donante-Colaborador");
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerDetalles.setBounds(622, 638, 137, 28);
		add(btnVerDetalles);
		btnVerDetalles.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Integer id=new Integer(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				Familiar f=padre.getcontrolador().consultarFamiliar(id);
				DatosFamiliar df=new DatosFamiliar(padre,id);
				df.rellenar(f);
				
				

				padre.getContentPane().removeAll();
				padre.getContentPane().validate();
				padre.getContentPane().add(df);
				padre.getContentPane().repaint();
			}
		});
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosUsuario du = new DatosUsuario(padre);
				du.rellenar(padre.getcontrolador().consultarBeneficiario(id_beneficiario));
				du.modobeneficiario();
				padre.getContentPane().removeAll();
				padre.getContentPane().validate();
				padre .getContentPane().add(du);
				padre.getContentPane().repaint();
				
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
				padre.getContentPane().removeAll();
				BusquedaUsuarios b = new BusquedaUsuarios(padre);
				String aux=choice_3.getSelectedItem();
				if(aux.equals("todos"))
					b.setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),null));
				else
					b.setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),aux));
				padre.getContentPane().add(b);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Bienvenido "+padre.getusuario());
		lblNewLabel_4.setBounds(1022, 9, 110, 14);
		add(lblNewLabel_4);
		
		JButton btnCerrar = new JButton("Cerrar Sesion");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home h= new Home(padre);
				padre.getContentPane().removeAll();
				padre.getContentPane().add(h);
			}
		});
		btnCerrar.setBounds(1032, 36, 119, 23);
		add(btnCerrar);
		
		
	}

}
