package Visual;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;

public class datosusuariomovil extends JFrame {

	private JPanel contentPane;
	private JTextField dniText;
	private JTextField nombreText;
	private JTextField apellidosText;
	private JTextField fechNacText;
	private JTextField telefonoText;
	private JTextField lugNaciText;
	private JTextField direcText;
	private JTextField cpText;
	private JTextField emailText;

	

	/**
	 * Create the frame.
	 */
	public datosusuariomovil() {
		setTitle("Asociaci\u00F3n Diaketas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logoutBoton = new JButton("Cerrar sesi\u00F3n");
		logoutBoton.setBounds(333, 23, 127, 66);
		contentPane.add(logoutBoton);
		
		JLabel dniLabel = new JLabel("DNI:");
		dniLabel.setBounds(46, 140, 46, 14);
		contentPane.add(dniLabel);
		
		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setBounds(46, 180, 94, 14);
		contentPane.add(nombreLabel);
		
		JLabel apellidosLabel = new JLabel("Apellidos:");
		apellidosLabel.setBounds(46, 220, 94, 14);
		contentPane.add(apellidosLabel);
		
		JLabel fechNaciLabel = new JLabel("Fecha nacimiento:");
		fechNaciLabel.setBounds(46, 260, 116, 14);
		contentPane.add(fechNaciLabel);
		
		JLabel telefonoLabel = new JLabel("Tel\u00E9fono:");
		telefonoLabel.setBounds(46, 300, 80, 14);
		contentPane.add(telefonoLabel);
		
		JLabel lugNaciLabel = new JLabel("Lugar nacimiento:");
		lugNaciLabel.setBounds(46, 340, 116, 14);
		contentPane.add(lugNaciLabel);
		
		JLabel direLabel = new JLabel("Direcci\u00F3n:");
		direLabel.setBounds(46, 380, 94, 14);
		contentPane.add(direLabel);
		
		JLabel cpLabel = new JLabel("C\u00F3digo postal:");
		cpLabel.setBounds(46, 420, 105, 14);
		contentPane.add(cpLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(46, 460, 46, 14);
		contentPane.add(emailLabel);
		
		JLabel frecLabel = new JLabel("Frecuencia:");
		frecLabel.setBounds(46, 500, 94, 14);
		contentPane.add(frecLabel);
		
		dniText = new JTextField();
		dniText.setBounds(187, 137, 149, 20);
		contentPane.add(dniText);
		dniText.setColumns(10);
		
		nombreText = new JTextField();
		nombreText.setColumns(10);
		nombreText.setBounds(187, 177, 149, 20);
		contentPane.add(nombreText);
		
		apellidosText = new JTextField();
		apellidosText.setColumns(10);
		apellidosText.setBounds(187, 217, 149, 20);
		contentPane.add(apellidosText);
		
		fechNacText = new JTextField();
		fechNacText.setColumns(10);
		fechNacText.setBounds(187, 257, 149, 20);
		contentPane.add(fechNacText);
		
		telefonoText = new JTextField();
		telefonoText.setColumns(10);
		telefonoText.setBounds(187, 297, 149, 20);
		contentPane.add(telefonoText);
		
		lugNaciText = new JTextField();
		lugNaciText.setColumns(10);
		lugNaciText.setBounds(187, 337, 149, 20);
		contentPane.add(lugNaciText);
		
		direcText = new JTextField();
		direcText.setColumns(10);
		direcText.setBounds(187, 377, 149, 20);
		contentPane.add(direcText);
		
		cpText = new JTextField();
		cpText.setColumns(10);
		cpText.setBounds(187, 417, 149, 20);
		contentPane.add(cpText);
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(187, 457, 149, 20);
		contentPane.add(emailText);
		
		JComboBox frecComBox = new JComboBox();
		frecComBox.setBounds(187, 497, 105, 20);
		contentPane.add(frecComBox);
		
		JLabel bienvenidaLabel = new JLabel("Bienvenid@");
		bienvenidaLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bienvenidaLabel.setBounds(46, 33, 116, 40);
		contentPane.add(bienvenidaLabel);
		
		JLabel usuarioLabel = new JLabel("<<usuario>>");
		usuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usuarioLabel.setBounds(154, 33, 116, 40);
		contentPane.add(usuarioLabel);
	}
}
