package Visual;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GestionPersona.Familiar;
import java.awt.Color;

public class NuevoFamiliar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private VentanaPrincipal padre;
	private Choice choice_3;
	private JTextField nombre;
	private JTextField apellido1;
	private JTextField apellido2;
	private JTextField ocupacion;
	private JTextField parentesco;
	private int id_beneficiario;
	private JTextField dni;
	/**
	 * Create the panel.
	 */
	public NuevoFamiliar(VentanaPrincipal p,int id_bene) {
		this.id_beneficiario=id_bene;
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
		choice_3.add("todos");
		choice_3.add("beneficiario");
		choice_3.add("trabajador");
		choice_3.add("donante-Socio");
		choice_3.add("donante-Empresa");
		choice_3.add("donante-Colaborador");
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(315, 10, 95, 25);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BusquedaUsuarios b = new BusquedaUsuarios(padre);
				String aux=choice_3.getSelectedItem();
				if(aux.equals("todos"))
					b.setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),null));
				else
					b.setTabla(padre.getcontrolador().BuscarPersonas(textField.getText(),aux));
				padre.getContentPane().removeAll();
				padre.getContentPane().validate();
				padre.getContentPane().add(b);
				padre.getContentPane().repaint();
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
				padre.getContentPane().removeAll();
				padre.getContentPane().validate();
				padre.getContentPane().add(h);
				padre.getContentPane().repaint();
			}
		});
		btnCerrar.setBounds(1032, 36, 119, 23);
		add(btnCerrar);
		
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(267, 130, 110, 23);
		add(nombre);
		
		JLabel label = new JLabel("Nombre:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(203, 130, 54, 17);
		add(label);
		
		JLabel label_1 = new JLabel("Apellidos:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(536, 130, 56, 17);
		add(label_1);
		
		apellido1 = new JTextField();
		apellido1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		apellido1.setColumns(15);
		apellido1.setBounds(602, 126, 110, 23);
		add(apellido1);
		
		apellido2 = new JTextField();
		apellido2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		apellido2.setColumns(15);
		apellido2.setBounds(735, 126, 126, 23);
		add(apellido2);
		
		JLabel lblParentesco = new JLabel("Parentesco:");
		lblParentesco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParentesco.setBounds(191, 168, 73, 17);
		add(lblParentesco);
		
		ocupacion = new JTextField();
		ocupacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ocupacion.setColumns(10);
		ocupacion.setBounds(602, 160, 126, 23);
		add(ocupacion);
		
		JLabel lblOcupacin = new JLabel("Ocupaci\u00F3n:");
		lblOcupacin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOcupacin.setBounds(519, 158, 73, 17);
		add(lblOcupacin);
		
		parentesco = new JTextField();
		parentesco.setFont(new Font("Tahoma", Font.PLAIN, 11));
		parentesco.setColumns(10);
		parentesco.setBounds(267, 164, 126, 23);
		add(parentesco);
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatosUsuario du= new DatosUsuario(padre);
				du.rellenar(padre.getcontrolador().consultarBeneficiario(id_beneficiario));
				padre.getContentPane().removeAll();
				padre.getContentPane().validate();
				padre .getContentPane().add(du);
				padre.repaint();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(435, 565, 156, 28);
		add(button);
		
		JButton button_1 = new JButton("Guardar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id=-1;
				Boolean b=true;
				
				
				if(dni.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Falta DNI");
					b=false;
				}else
				if(nombre.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Falta nombre");
					b=false;
				}else
				if(apellido1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Falta Apellido");
					b=false;
				}
				if(b==true){
					
				String tdni="";
				String tnombre="";
				String tapellido1="";
				String tapellido2="";
				String lugarnac="";
				String domicilio="";
				String email="";
				int telefono=0;
				int cp=0;
				String fnac="1900-01-01";
				tdni=dni.getText();
				tnombre=nombre.getText();
				tapellido1=apellido1.getText();
				tapellido2=apellido2.getText();
				id=padre.getcontrolador().darAltaPersona(tdni,tnombre,tapellido1,tapellido2,fnac,telefono,lugarnac,domicilio,cp,email);
				boolean correcto=false;
				if(id!=-1){	
					DatosFamiliar df=new DatosFamiliar(padre,id);
					try{
					
					padre.getcontrolador().introducirDatosFamiliar(id,id_beneficiario,ocupacion.getText(),parentesco.getText());
					Familiar f=padre.getcontrolador().consultarFamiliar(id);
					df.rellenar(f);		
					correcto=true;
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Error al introducir\n"+e1.getMessage());
						e1.printStackTrace();
						correcto=false;
					}
					
					if(correcto){
						JOptionPane.showMessageDialog(null, "Se ha insertado el usuario correctamente");
						padre.getContentPane().removeAll();
						padre.getContentPane().validate();
						padre.getContentPane().add(df);
						padre.getContentPane().repaint();
					}else
						JOptionPane.showMessageDialog(null, "NO se ha insertado el usuario");
				
				}
				
				}
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(614, 567, 137, 28);
		add(button_1);
		
		dni = new JTextField();
		dni.setBounds(267, 95, 110, 20);
		add(dni);
		dni.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(211, 98, 46, 14);
		add(lblDni);
		
		JLabel label_2 = new JLabel("(*)");
		label_2.setForeground(Color.RED);
		label_2.setBounds(184, 95, 46, 20);
		add(label_2);
		
		JLabel label_3 = new JLabel("(*)");
		label_3.setForeground(Color.RED);
		label_3.setBounds(184, 131, 46, 20);
		add(label_3);
		
		JLabel label_4 = new JLabel("(*)");
		label_4.setForeground(Color.RED);
		label_4.setBounds(519, 127, 46, 20);
		add(label_4);
	}
}
