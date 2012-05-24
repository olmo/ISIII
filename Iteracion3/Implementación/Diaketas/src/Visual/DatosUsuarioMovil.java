package Visual;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DatosUsuarioMovil extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2268770203627124208L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	PanelInicioMovil ini;
	VentanaPrincipalMovil padre;

	/**
	 * Create the panel.
	 */
	public DatosUsuarioMovil(VentanaPrincipalMovil mipadre) {
		setLayout(null);
		padre = mipadre;
		
		JLabel dniLabel = new JLabel("DNI:");
		dniLabel.setBounds(40, 89, 46, 14);
		add(dniLabel);
		
		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setBounds(40, 119, 46, 14);
		add(nombreLabel);
		
		JLabel apellidosLabel = new JLabel("Apellidos:");
		apellidosLabel.setBounds(40, 149, 46, 14);
		add(apellidosLabel);
		
		JLabel fechNaciLabel = new JLabel("Fecha nacimiento:");
		fechNaciLabel.setBounds(40, 179, 97, 14);
		add(fechNaciLabel);
		
		JLabel teleLabel = new JLabel("Tel\u00E9fono:");
		teleLabel.setBounds(40, 209, 46, 14);
		add(teleLabel);
		
		JLabel lugNaciLabel = new JLabel("Lugar nacimiento:");
		lugNaciLabel.setBounds(40, 239, 97, 14);
		add(lugNaciLabel);
		
		JLabel direLabel = new JLabel("Direcci\u00F3n:");
		direLabel.setBounds(40, 269, 97, 14);
		add(direLabel);
		
		JLabel cpLabel = new JLabel("C\u00F3digo postal:");
		cpLabel.setBounds(40, 299, 97, 14);
		add(cpLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(40, 329, 46, 14);
		add(emailLabel);
		
		JLabel frecLabel = new JLabel("Frecuencia:");
		frecLabel.setBounds(40, 362, 82, 14);
		add(frecLabel);
		
		textField = new JTextField();
		textField.setBounds(147, 86, 163, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 116, 163, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 146, 163, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(147, 176, 163, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(147, 206, 163, 20);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(147, 236, 163, 20);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(147, 266, 163, 20);
		add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(147, 296, 163, 20);
		add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(147, 326, 163, 20);
		add(textField_8);
		
		Choice choice = new Choice();
		choice.setBounds(147, 356, 82, 20);
		add(choice);
		
		JButton volverBoton = new JButton("Volver");
		volverBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelInicioMovil panIni = new PanelInicioMovil(padre,padre.getusuario());
				padre.getContentPane().removeAll();
				padre.getContentPane().validate();
				padre.getContentPane().add(panIni);
				padre.getContentPane().repaint();
			}
		});
		volverBoton.setBounds(40, 430, 118, 65);
		add(volverBoton);
		
		JButton guardarBoton = new JButton("Guardar");
		guardarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		guardarBoton.setBounds(192, 430, 118, 65);
		add(guardarBoton);

	}
}
