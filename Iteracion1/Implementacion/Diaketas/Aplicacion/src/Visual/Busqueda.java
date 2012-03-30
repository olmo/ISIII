package Visual;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Choice;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Busqueda extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private TableModel tabla_modelo;
	
	public TableModel getTabla() {
		return tabla_modelo;
	}

	public void setTabla(TableModel tabla) {
		this.tabla_modelo = tabla;
		table.setModel(tabla_modelo);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	VentanaPrincipal padre;

	/**
	 * Create the panel.
	 */
	public Busqueda(VentanaPrincipal p) {
		padre=p;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.WEST);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_3.add(textField);
		
		
		final Choice choice_2 = new Choice();
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String aux=choice_2.getSelectedItem();
				if(aux.equals("todos"))
					table.setModel(padre.getcontrolador().buscaPersonas(textField.getText(),null));
				else
					table.setModel(padre.getcontrolador().buscaPersonas(textField.getText(),aux));
				System.out.print(textField.getText());
			}
		});
		panel_3.add(btnBuscar);
		
		
		choice_2.add("todos");
		choice_2.add("trabajador");
		choice_2.add("beneficiario");
		choice_2.add("donante");
		panel_3.add(choice_2);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		
		JLabel lblNewLabel_4 = new JLabel("Bienvenido "+padre.getusuario());
		panel_5.add(lblNewLabel_4);
		
		JButton btnCerrar = new JButton("Cerrar Sesion");
		panel_7.add(btnCerrar);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				padre.getContentPane().add(new Inicio(padre,padre.getusuario()));
			}
		});
		panel_1.add(btnVolver);
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				Datos d=new Datos(padre);
				padre.getContentPane().add(d);
				
				TableModel a=padre.getcontrolador().iniciarConsultarPersona(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				d.rellenar(a);
				
			}
		});
		panel_1.add(btnVerDetalles);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		//panel_2.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		panel_2.add(scrollPane, BorderLayout.NORTH);
	}

	

	
	
	
}
