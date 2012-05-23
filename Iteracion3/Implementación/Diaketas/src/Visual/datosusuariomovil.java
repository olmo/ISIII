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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 */
	public DatosUsuarioMovil() {
		setLayout(null);
		
		JLabel dniLabel = new JLabel("DNI:");
		dniLabel.setBounds(40, 130, 46, 14);
		add(dniLabel);
		
		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setBounds(40, 170, 46, 14);
		add(nombreLabel);
		
		JLabel apellidosLabel = new JLabel("Apellidos:");
		apellidosLabel.setBounds(40, 210, 46, 14);
		add(apellidosLabel);
		
		JLabel fechNaciLabel = new JLabel("Fecha nacimiento:");
		fechNaciLabel.setBounds(40, 250, 97, 14);
		add(fechNaciLabel);
		
		JLabel teleLabel = new JLabel("Tel\u00E9fono:");
		teleLabel.setBounds(40, 290, 46, 14);
		add(teleLabel);
		
		JLabel lugNaciLabel = new JLabel("Lugar nacimiento:");
		lugNaciLabel.setBounds(40, 330, 97, 14);
		add(lugNaciLabel);
		
		JLabel direLabel = new JLabel("Direcci\u00F3n:");
		direLabel.setBounds(40, 370, 97, 14);
		add(direLabel);
		
		JLabel cpLabel = new JLabel("C\u00F3digo postal:");
		cpLabel.setBounds(40, 410, 97, 14);
		add(cpLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(40, 450, 46, 14);
		add(emailLabel);
		
		JLabel frecLabel = new JLabel("Frecuencia:");
		frecLabel.setBounds(40, 490, 82, 14);
		add(frecLabel);
		
		textField = new JTextField();
		textField.setBounds(147, 127, 163, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 167, 163, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 207, 163, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(147, 247, 163, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(147, 287, 163, 20);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(147, 327, 163, 20);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(147, 367, 163, 20);
		add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(147, 407, 163, 20);
		add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(147, 447, 163, 20);
		add(textField_8);
		
		Choice choice = new Choice();
		choice.setBounds(147, 490, 82, 20);
		add(choice);
		
		JButton logOutBoton = new JButton("Cerrar sesi\u00F3n");
		logOutBoton.setBounds(292, 31, 118, 65);
		add(logOutBoton);
		
		JButton volverBoton = new JButton("Volver");
		volverBoton.setBounds(84, 560, 118, 65);
		add(volverBoton);
		
		JButton guardarBoton = new JButton("Guardar");
		guardarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		guardarBoton.setBounds(255, 560, 118, 65);
		add(guardarBoton);

	}
}
