package Visual;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.table.TableModel;


import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Datos extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField dni;
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField textField_4;

	private VentanaPrincipal padre;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	Choice choice = new Choice();
	
	/**
	 * Create the panel.
	 */
	public Datos(VentanaPrincipal p) {
		this.padre=p;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblNewLabel_4 = new JLabel("Bienvenido "+padre.getusuario());
		panel_5.add(lblNewLabel_4);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JButton btnCerrar = new JButton("Cerrar Sesion");
		panel_6.add(btnCerrar);
		
		final Choice choice_2 = new Choice();
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(textField);
		textField.setColumns(20);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Busqueda b = new Busqueda(padre);
				String aux=choice_2.getSelectedItem();
				if(aux.equals("todos"))
					b.setTabla(padre.getcontrolador().buscaPersonas(textField.getText(),null));
				else
					b.setTabla(padre.getcontrolador().buscaPersonas(textField.getText(),aux));
				padre.getContentPane().add(b);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(btnNewButton);
		
		
		choice_2.add("todos");
		choice_2.add("trabajador");
		choice_2.add("beneficiario");
		choice_2.add("donante");
		panel_3.add(choice_2);
		
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_7.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_11.add(panel_15, BorderLayout.WEST);
		panel_15.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_15.add(lblDni);
		
		dni = new JTextField();
		dni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_15.add(dni);
		dni.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_10.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_12.add(panel_9, BorderLayout.NORTH);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_9.add(panel_14, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_14.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_14.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_14.add(lblApellidos);
		
		apellidos = new JTextField();
		apellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_14.add(apellidos);
		apellidos.setColumns(15);
		
		JPanel panel_17 = new JPanel();
		panel_12.add(panel_17, BorderLayout.CENTER);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_17.add(panel_18, BorderLayout.NORTH);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_19 = new JPanel();
		panel_18.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_19.add(lblDireccion);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_19.add(textField_4);
		textField_4.setColumns(35);
		
		JPanel panel_20 = new JPanel();
		panel_17.add(panel_20, BorderLayout.CENTER);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_21 = new JPanel();
		panel_20.add(panel_21, BorderLayout.NORTH);
		panel_21.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_23 = new JPanel();
		panel_21.add(panel_23, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Telefono:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_23.add(lblNewLabel);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_23.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("e-mail:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_23.add(lblNewLabel_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_23.add(textField_6);
		textField_6.setColumns(20);
		
		JPanel panel_24 = new JPanel();
		panel_20.add(panel_24, BorderLayout.CENTER);
		panel_24.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_28 = new JPanel();
		panel_24.add(panel_28, BorderLayout.NORTH);
		panel_28.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_26 = new JPanel();
		panel_28.add(panel_26, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Rol :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_26.add(lblNewLabel_2);
		
		
		panel_26.add(choice);
		
		JLabel lblNewLabel_3 = new JLabel("Frecuencia:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_26.add(lblNewLabel_3);
		
		Choice choice_1 = new Choice();
		choice_1.setSize(10, 50);
		panel_26.add(choice_1);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_26.add(lblCantidad);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_26.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_24.add(panel_4, BorderLayout.CENTER);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				padre.getContentPane().add(new Busqueda(padre));
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Dar de baja");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConfirmarBorrado cb=new ConfirmarBorrado();
				cb.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Guardar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnNewButton_3);
		
		choice.add("todos");
		choice.add("trabajador");
		choice.add("beneficiario");
		choice.add("donante");
		
	}
	
	
	
	public void rellenar(TableModel t){
		
		dni.setText(t.getValueAt(0,0).toString());//dni
		nombre.setText(t.getValueAt(0,1).toString());//nombre
		apellidos.setText(t.getValueAt(0,2).toString()+" "+t.getValueAt(0, 3));//apellidos


		textField_4.setText(t.getValueAt(0,7).toString()); 
		
		textField_5.setText(t.getValueAt(0,5).toString());
		
		textField_6.setText("@gmail.com");
		
		textField_4.setText(t.getValueAt(0,7).toString());
		
		choice.select(t.getValueAt(0,11).toString());
		
	}
	

}
