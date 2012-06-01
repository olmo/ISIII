package Visual;

import javax.swing.JOptionPane;
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
	private JTextField apellido1Field;
	private JTextField fnField;
	private JTextField telField;
	private JTextField lnField;
	private JTextField dirField;
	private JTextField cpField;
	private JTextField emailField;
	private Choice frecChoice;

	PanelInicioMovil ini;
	VentanaPrincipalMovil padre;
	private JTextField apellido2Field;

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
		
		JLabel apellido1Label = new JLabel("Primer apellido:");
		apellido1Label.setBounds(40, 149, 97, 14);
		add(apellido1Label);
		
		JLabel fechNaciLabel = new JLabel("Fecha nacimiento:");
		fechNaciLabel.setBounds(40, 210, 97, 14);
		add(fechNaciLabel);
		
		JLabel teleLabel = new JLabel("Tel\u00E9fono:");
		teleLabel.setBounds(40, 241, 46, 14);
		add(teleLabel);
		
		JLabel lugNaciLabel = new JLabel("Lugar nacimiento:");
		lugNaciLabel.setBounds(40, 272, 97, 14);
		add(lugNaciLabel);
		
		JLabel direLabel = new JLabel("Direcci\u00F3n:");
		direLabel.setBounds(40, 305, 97, 14);
		add(direLabel);
		
		JLabel cpLabel = new JLabel("C\u00F3digo postal:");
		cpLabel.setBounds(40, 336, 97, 14);
		add(cpLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(40, 367, 46, 14);
		add(emailLabel);
		
		JLabel frecLabel = new JLabel("Frecuencia:");
		frecLabel.setBounds(40, 392, 82, 14);
		add(frecLabel);
		
		dniField = new JTextField();
		dniField.setBounds(147, 86, 163, 20);
		add(dniField);
		dniField.setColumns(10);
		
		nombreField = new JTextField();
		nombreField.setColumns(10);
		nombreField.setBounds(147, 116, 163, 20);
		add(nombreField);
		
		apellido1Field = new JTextField();
		apellido1Field.setColumns(10);
		apellido1Field.setBounds(147, 146, 163, 20);
		add(apellido1Field);
		
		fnField = new JTextField();
		fnField.setColumns(10);
		fnField.setBounds(147, 207, 163, 20);
		add(fnField);
		
		telField = new JTextField();
		telField.setColumns(10);
		telField.setBounds(147, 238, 163, 20);
		add(telField);
		
		lnField = new JTextField();
		lnField.setColumns(10);
		lnField.setBounds(147, 269, 163, 20);
		add(lnField);
		
		dirField = new JTextField();
		dirField.setColumns(10);
		dirField.setBounds(147, 302, 163, 20);
		add(dirField);
		
		cpField = new JTextField();
		cpField.setColumns(10);
		cpField.setBounds(147, 333, 163, 20);
		add(cpField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(147, 364, 163, 20);
		add(emailField);
		frecChoice = new Choice();
		frecChoice.setBounds(147, 390, 82, 20);
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
				
				ConfirmacionModificacionMovil dialoconfirmacion;
				dialoconfirmacion = new ConfirmacionModificacionMovil(padre,dniField.getText(), nombreField.getText(),apellido1Field.getText(), apellido2Field.getText(), fnField.getText(), Integer.parseInt(telField.getText()),lnField.getText(), 
						dirField.getText(), Integer.parseInt(cpField.getText()), emailField.getText(), Integer.parseInt(frecChoice.getSelectedItem()));
				dialoconfirmacion.setVisible(true);
				dialoconfirmacion.setAlwaysOnTop(true);
				/*int opcion = JOptionPane.showConfirmDialog(null,"¿Desea guardar la información actual?", "¿Desea guardar la información actual?", JOptionPane.YES_NO_OPTION);
				if(opcion == 0){
					padre.getControladorMovil().modificarDatosSocio(padre.getIDsesion().intValue(), dniField.getText(), nombreField.getText(), 
					apellido1Field.getText(), apellido2Field.getText(), fnField.getText(), Integer.parseInt(telField.getText()), lnField.getText(), 
					dirField.getText(), Integer.parseInt(cpField.getText()), emailField.getText(), Integer.parseInt(frecChoice.getSelectedItem()), padre.getusuario(),padre.getContrasena());
				}*/
			}
		});
		guardarBoton.setBounds(192, 430, 118, 65);
		add(guardarBoton);
		
		apellido2Field = new JTextField();
		apellido2Field.setColumns(10);
		apellido2Field.setBounds(147, 176, 163, 20);
		add(apellido2Field);
		
		JLabel apellido2Label = new JLabel("Segundo apellido:");
		apellido2Label.setBounds(40, 179, 97, 14);
		add(apellido2Label);

	}
	
	public void rellenaVista(Socio s){
		Integer peri=0;
		dniField.setText(s.getDni());
		nombreField.setText(s.getNombre());
		apellido1Field.setText(s.getApellido1());
		apellido2Field.setText(s.getApellido2());
		fnField.setText(s.getfNacimiento());
		telField.setText(s.getTelefono().toString());
		lnField.setText(s.getLugarNacimiento());
		dirField.setText(s.getDomicilio());
		cpField.setText(s.getCp().toString());
		emailField.setText(s.getemail());
		peri = s.getPeriocidad();
		frecChoice.add(peri.toString());
		frecChoice.add("1");
		frecChoice.add("2");
		frecChoice.add("3");
		frecChoice.add("6");
		frecChoice.add("12");
	}
}
