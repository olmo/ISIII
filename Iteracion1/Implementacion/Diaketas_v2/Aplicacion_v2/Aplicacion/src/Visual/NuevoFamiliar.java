package Visual;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NuevoFamiliar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private VentanaPrincipal padre;
	private Choice choice_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	/**
	 * Create the panel.
	 */
	public NuevoFamiliar(VentanaPrincipal p) {
		padre=p;
		setSize(1200, 700);
		setLayout(null);
		textField = new JTextField();
		textField.setBounds(10, 11, 295, 23);
		add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(15);
		
		choice_3 = new Choice();
		choice_3.setBounds(416, 13, 166, 23);
		add(choice_3);
		choice_3.add("todos");
		choice_3.add("trabajador");
		choice_3.add("beneficiario");
		choice_3.add("donante");
		
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
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(267, 130, 110, 23);
		add(textField_1);
		
		JLabel label = new JLabel("Nombre:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(203, 130, 54, 17);
		add(label);
		
		JLabel label_1 = new JLabel("Apellidos:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(536, 130, 56, 17);
		add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(15);
		textField_2.setBounds(598, 127, 97, 23);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(15);
		textField_3.setBounds(705, 127, 97, 23);
		add(textField_3);
		
		JLabel lblParentesco = new JLabel("Parentesco:");
		lblParentesco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParentesco.setBounds(191, 168, 73, 17);
		add(lblParentesco);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(267, 165, 110, 23);
		add(textField_4);
		
		JLabel lblOcupacin = new JLabel("Ocupaci\u00F3n:");
		lblOcupacin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOcupacin.setBounds(519, 158, 73, 17);
		add(lblOcupacin);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(596, 157, 126, 23);
		add(textField_5);
		
		JButton button = new JButton("Volver");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(435, 565, 156, 28);
		add(button);
		
		JButton button_1 = new JButton("Guardar");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(614, 567, 137, 28);
		add(button_1);
	}
}
