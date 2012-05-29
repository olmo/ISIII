package Visual;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Choice;
import javax.swing.JButton;

import GestionPersona.Socio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DatosUsuarioMovil extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2268770203627124208L;
	private JTextField dniField;
	private JTextField nombreField;
	private JTextField apellidosField;
	private JTextField fnField;
	private JTextField telField;
	private JTextField lnField;
	private JTextField dirField;
	private JTextField cpField;
	private JTextField emailField;
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
		
		dniField = new JTextField();
		dniField.setBounds(147, 86, 163, 20);
		add(dniField);
		dniField.setColumns(10);
		
		nombreField = new JTextField();
		nombreField.setColumns(10);
		nombreField.setBounds(147, 116, 163, 20);
		add(nombreField);
		
		apellidosField = new JTextField();
		apellidosField.setColumns(10);
		apellidosField.setBounds(147, 146, 163, 20);
		add(apellidosField);
		
		fnField = new JTextField();
		fnField.setColumns(10);
		fnField.setBounds(147, 176, 163, 20);
		add(fnField);
		
		telField = new JTextField();
		telField.setColumns(10);
		telField.setBounds(147, 206, 163, 20);
		add(telField);
		
		lnField = new JTextField();
		lnField.setColumns(10);
		lnField.setBounds(147, 236, 163, 20);
		add(lnField);
		
		dirField = new JTextField();
		dirField.setColumns(10);
		dirField.setBounds(147, 266, 163, 20);
		add(dirField);
		
		cpField = new JTextField();
		cpField.setColumns(10);
		cpField.setBounds(147, 296, 163, 20);
		add(cpField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(147, 326, 163, 20);
		add(emailField);
		
		Choice frecChoice = new Choice();
		frecChoice.setBounds(147, 356, 82, 20);
		add(frecChoice);
		
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
	
	public void rellenaVista(Socio s){
		dniField.setText(s.getDni());
		nombreField.setText(s.getNombre());
		apellidosField.setText(s.getApellido1()+" "+s.getApellido2());
		fnField.setText(s.getfNacimiento());
		telField.setText(s.getTelefono().toString());
		lnField.setText(s.getLugarNacimiento());
		dirField.setText(s.getDomicilio());
		cpField.setText(s.getCp().toString());
		emailField.setText(s.getemail());
	}
}
