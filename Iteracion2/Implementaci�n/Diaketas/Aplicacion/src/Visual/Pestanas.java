package Visual;

import java.awt.Component;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Pestanas extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private VentanaPrincipal padre;
	
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public Pestanas(VentanaPrincipal p, String usuario) {
		setSize(1200, 700);
		this.padre = p;
		padre.setusuario(usuario);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 64, 1180, 636);
		
		
		padre.panelUsuarios = new Inicio(p, usuario);
		
		
		padre.panelDonaciones = new JPanel();
		padre.panelDonaciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(15);
		
		JButton button = new JButton("Buscar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_1 = new JButton("A\u00F1adir Donaci\u00F3n");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_2 = new JButton("A\u00F1adir Donante");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		
		JButton button_3 = new JButton("Cancelar Donaci\u00F3n");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_4 = new JButton("Confirmar Donaci\u00F3n");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(padre.panelDonaciones);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1173, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
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
								.addComponent(button_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(button_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 607, Short.MAX_VALUE)
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
							.addComponent(button_4)
							.addGap(18)
							.addComponent(button_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(51)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		padre.panelDonaciones.setLayout(gl_panel);
		
		padre.panelAyudas = new JPanel();
		padre.panelAyudas.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(15);
		
		JButton button_5 = new JButton("Buscar");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_6 = new JButton("Configurar Tipos de Ayuda");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		
		JButton button_7 = new JButton("Editar Ayuda");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_8 = new JButton("Conceder Ayuda");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(padre.panelAyudas);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1173, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(235)
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 976, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(button_8, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 607, Short.MAX_VALUE)
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
									.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(184)
							.addComponent(button_8)
							.addGap(18)
							.addComponent(button_7))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(51)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		padre.panelAyudas.setLayout(gl_panel_1);
		
		padre.panelActuaciones = new JPanel();
		padre.panelActuaciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(15);
		
		JButton button_9 = new JButton("Buscar");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane_2 = new JScrollPane((Component) null);
		
		JButton button_10 = new JButton("Ir a donaci\u00F3n/ayuda");
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_2 = new GroupLayout(padre.panelActuaciones);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1173, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 794, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
							.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(97))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 607, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(2)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(1)
							.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(249)
							.addComponent(button_10))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(51)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		padre.panelActuaciones.setLayout(gl_panel_2);
		//setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane, inicio, panel, textField, button, button_1, button_2, scrollPane, button_3, button_4, panel_1, textField_1, button_5, button_6, scrollPane_1, button_7, button_8, panel_2, textField_2, button_9, scrollPane_2, button_10, btnCerrarSesion, label}));
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(1064, 30, 126, 23);
		add(btnCerrarSesion);
		
		JLabel label = new JLabel("Bienvenido "+padre.getusuario());
		label.setBounds(1080, 11, 110, 14);
		add(label);
		
		tabbedPane.addTab("Personas", null, padre.panelUsuarios, null);
		tabbedPane.addTab("Donaciones", null, padre.panelDonaciones, null);

		tabbedPane.addTab("Ayudas", null, padre.panelAyudas, null);
		tabbedPane.addTab("Actuaciones", null, padre.panelActuaciones, null);
		
		add(tabbedPane);
		
	}
}
