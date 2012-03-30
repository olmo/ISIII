package Visual;


import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class NuevoUsuario extends JPanel {
	private static final long serialVersionUID = 1L;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;

		private VentanaPrincipal padre;
		private JTextField textField_5;
		private JTextField textField_6;
		private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public NuevoUsuario(VentanaPrincipal p) {

			padre=p;
			setLayout(new BorderLayout(0, 0));
			
			JPanel panel = new JPanel();
			add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_3 = new JPanel();
			panel.add(panel_3, BorderLayout.CENTER);
			panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			final Choice choice_2 = new Choice();
			
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel_3.add(textField);
			textField.setColumns(20);
			
			JButton btnNewButton = new JButton("Buscar");
			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
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
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel_15.add(textField_1);
			textField_1.setColumns(10);
			
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
			
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel_14.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel_14.add(lblApellidos);
			
			textField_3 = new JTextField();
			textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel_14.add(textField_3);
			textField_3.setColumns(15);
			
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
			
			Choice choice = new Choice();
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
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					padre.getContentPane().add(new Inicio(padre,padre.getusuario()));
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel_4.add(btnNewButton_1);
			
			JButton btnNewButton_3 = new JButton("Guardar");
			btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel_4.add(btnNewButton_3);

		}

}
