package Visual;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class Pestanias extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pestanias frame = new Pestanias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pestanias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label = new JLabel("Bienvenido <dynamic>");
		
		JButton button_3 = new JButton("Cerrar Sesi\u00F3n");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(1041, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
					.addContainerGap())
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 1174, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 590, Short.MAX_VALUE)
					.addContainerGap())
		);
		
//		//////////// Tab Personas
//		JButton btnNuevoUsuarioPersonas = new JButton("Nuevo Usuario");
//		btnNuevoUsuarioPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnNuevoUsuarioPersonas.setBounds(693, 13, 145, 23);
//		
//		JTextField textFieldPersonas = new JTextField();
//		textFieldPersonas.setBounds(10, 11, 295, 23);
//		textFieldPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		textFieldPersonas.setColumns(15);
//		
//		JPanel panel_3 = new JPanel();
//		panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
//		tabbedPane.addTab("Personas", null, panel_3, null);
//		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
//		gl_panel_3.setHorizontalGroup(
//			gl_panel_3.createParallelGroup(Alignment.LEADING)
//				.addGap(0, 1159, Short.MAX_VALUE)
//				.addGroup(gl_panel_3.createSequentialGroup()
//				.addContainerGap()
//				.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
//					.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
//						.addComponent(textFieldPersonas, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
//						.addGap(10)
//						.addComponent(btnNuevoUsuarioPersonas, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
//						.addGap(149)
//		))));
//		gl_panel_3.setVerticalGroup(
//			gl_panel_3.createParallelGroup(Alignment.LEADING)
//				.addGap(0, 559, Short.MAX_VALUE)
//		);
//		panel_3.setLayout(gl_panel_3);
//		
//		
//		panel_3.setSize(1000, 600);
//		//panel_3.setLayout(null);
//		
//
////		
////		choice_busqueda = new Choice();
////		choice_busqueda.setBounds(416, 13, 166, 23);
////		add(choice_busqueda);
////		choice_busqueda.add("todos");
////		choice_busqueda.add("beneficiario");
////		choice_busqueda.add("trabajador");
////		choice_busqueda.add("donante-Socio");
////		choice_busqueda.add("donante-Empresa");
////		choice_busqueda.add("donante-Colaborador");
////		
//		
//		JButton btnNewButton = new JButton("Buscar");
//		btnNewButton.setBounds(315, 10, 95, 25);
//		getContentPane().add(btnNewButton);
//		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		
////		gl_panel.setHorizontalGroup(
////				gl_panel.createParallelGroup(Alignment.LEADING)
////					.addGroup(gl_panel.createSequentialGroup()
////						.addContainerGap()
////						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
////							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
////								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
////								.addGap(10)
////								.addComponent(button, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
////								.addGap(149)
////								.addComponent(button_1)
////								.addGap(18)
////								.addComponent(button_2))
////							.addGroup(gl_panel.createSequentialGroup()
////								.addGap(2)
////								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 976, GroupLayout.PREFERRED_SIZE)
////								.addPreferredGap(ComponentPlacement.UNRELATED)
////								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
////									.addComponent(button_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
////									.addComponent(button_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
////						.addContainerGap())
////			);
////			gl_panel.setVerticalGroup(
////				gl_panel.createParallelGroup(Alignment.LEADING)
////					.addGroup(gl_panel.createSequentialGroup()
////						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
////							.addGroup(gl_panel.createSequentialGroup()
////								.addContainerGap()
////								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
////									.addGroup(gl_panel.createSequentialGroup()
////										.addGap(2)
////										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
////									.addGroup(gl_panel.createSequentialGroup()
////										.addGap(1)
////										.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
////							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
////								.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
////								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
////						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
////							.addGroup(gl_panel.createSequentialGroup()
////								.addGap(184)
////								.addComponent(button_5)
////								.addGap(18)
////								.addComponent(button_4))
////							.addGroup(gl_panel.createSequentialGroup()
////								.addGap(51)
////								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)))
////						.addContainerGap(44, Short.MAX_VALUE))
////			);
////			panel.setLayout(gl_panel);

		// Fin Tab Personas
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Donaciones", null, panel, null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(15);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_1 = new JButton("A\u00F1adir Donaci\u00F3n");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_2 = new JButton("A\u00F1adir Donante");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_4 = new JButton("Cancelar Donaci\u00F3n");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_5 = new JButton("Confirmar Donaci\u00F3n");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(149)
							.addComponent(button_1)
							.addGap(18)
							.addComponent(button_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 976, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(button_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(2)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(184)
							.addComponent(button_5)
							.addGap(18)
							.addComponent(button_4))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(51)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Ayudas", null, panel_1, null);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(15);
		
		JButton button_6 = new JButton("Buscar");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_7 = new JButton("Configurar Tipos de Ayuda");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		
		JButton button_9 = new JButton("Editar Ayuda");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_10 = new JButton("Conceder Ayuda");
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(235)
							.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 976, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_9, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
								.addComponent(button_10, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(2)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(1)
									.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
						.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(184)
							.addComponent(button_10)
							.addGap(18)
							.addComponent(button_9))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(51)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Actuaciones", null, panel_2, null);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(15);
		
		JButton button_11 = new JButton("Buscar");
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane_2 = new JScrollPane((Component) null);
		
		JButton button_13 = new JButton("Ir a donaci\u00F3n/ayuda");
		button_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 794, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
							.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(97))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(2)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(1)
							.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(249)
							.addComponent(button_13))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(51)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
