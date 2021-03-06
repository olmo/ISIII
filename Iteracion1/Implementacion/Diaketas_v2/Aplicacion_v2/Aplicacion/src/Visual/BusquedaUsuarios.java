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
	
	public TableModel getTabla() {
		return tabla_modelo;
	}

	public void setTabla(TableModel tabla) {
		this.tabla_modelo = tabla;
		table.setModel(tabla_modelo);
	}

//	public JTextField getTextField() {
//		return textField;
//	}
//
//	public void setTextField(JTextField textField) {
//		this.textField = textField;
//	}



	/**
	 * Create the panel.
	 */
	public BusquedaUsuarios(VentanaPrincipal p) {
		padre=p;
		setSize(1200, 700);
		table = new JTable();
		//table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(null);
		
		choice_3 = new Choice();
		choice_3.setBounds(416, 13, 166, 23);
		add(choice_3);
		choice_3.add("todos");
		choice_3.add("trabajador");
		choice_3.add("beneficiario");
		choice_3.add("donante");
		
		//panel_2.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 86, 1200, 524);
		add(scrollPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(456, 638, 156, 28);
		add(btnVolver);
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerDetalles.setBounds(622, 638, 137, 28);
		add(btnVerDetalles);
		btnVerDetalles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				DatosUsuario d=new DatosUsuario(padre);

				
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
				}else if(tipo.equals("donante")){
					//No hay forma de saber el tipo de donante
				}
				
				setVisible(false);
				padre.getContentPane().add(d);
				
			}
		});
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				padre.getContentPane().add(new Inicio(padre,padre.getusuario()));
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
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
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
				setVisible(false);
				padre.getContentPane().add(h);
			}
		});
		btnCerrar.setBounds(1032, 36, 119, 23);
		add(btnCerrar);
		
		
	}

	

	
	
	
}
