package Visual;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GestionPersona.Familiar;



public class DatosFamiliar extends JPanel {

	
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
	private JTextField parentesco;
	private JTextField ocupacion;
	private JTextField dni;
	private Integer id;

	protected PanelInicio ini;

	/**
	 * Create the panel.
	 */
	
	public void rellenar(Familiar f){
		dni.setText(f.getDni());
		nombre.setText(f.getNombre());
		apellido1.setText(f.getApellido1());
		apellido2.setText(f.getApellido2());
		parentesco.setText(f.getParentesco());
		ocupacion.setText(f.getOcupacion());
		
	
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public DatosFamiliar(VentanaPrincipal p,Integer id,PanelInicio pIni) {
		ini=pIni;
		this.id=id;
		padre=p;
		setSize(PanelInicio.tamanoPaneles);
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
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//BusquedaUsuarios b = ini.busqueda_usuarios;
				String aux=choice_3.getSelectedItem();
				if(aux.equals("todos")){
					ini.busqueda_usuarios.setTabla(padre.getControladorPersonas().BuscarPersonas(textField.getText(),null));
					ini.busqueda_usuarios.setbusqueda(textField.getText(),null);
				}else{
					ini.busqueda_usuarios.setTabla(padre.getControladorPersonas().BuscarPersonas(textField.getText(),aux));
					ini.busqueda_usuarios.setbusqueda(textField.getText(),aux);
				}

				ini.setPanelOnTab(ini.busqueda_usuarios, PanelInicio.PERSONAS);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		
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
		apellido1.setBounds(598, 127, 127, 23);
		add(apellido1);
		
		apellido2 = new JTextField();
		apellido2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		apellido2.setColumns(15);
		apellido2.setBounds(735, 127, 127, 23);
		add(apellido2);
		
		JLabel lblParentesco = new JLabel("Parentesco:");
		lblParentesco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParentesco.setBounds(191, 168, 73, 17);
		add(lblParentesco);
		
			ocupacion = new JTextField();
		ocupacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ocupacion.setColumns(10);
		ocupacion.setBounds(598, 157, 126, 23);
		add(ocupacion);
		
		parentesco = new JTextField();
		parentesco.setFont(new Font("Tahoma", Font.PLAIN, 11));
		parentesco.setColumns(10);
		parentesco.setBounds(267, 165, 110, 23);
		add(parentesco);
		
		JLabel lblOcupacin = new JLabel("Ocupaci\u00F3n:");
		lblOcupacin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOcupacin.setBounds(519, 158, 73, 17);
		add(lblOcupacin);
		
	
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Familiar f=new Familiar();
				f=padre.getControladorPersonas().consultarFamiliar(getId());
				BusquedaFamiliares bf = new BusquedaFamiliares(padre,f.getidBeneficiario(),ini);
				padre.getContentPane().removeAll();
				padre.getContentPane().validate();
				padre.getContentPane().add(bf);
				padre.getContentPane().repaint();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(431, 567, 156, 28);
		add(button);
		
		JButton button_1 = new JButton("Guardar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boolean b=true,correcto=false;
				
				if(dni.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Falta DNI");
					b=false;
				}else
				if(nombre.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Falta nombre");
					b=false;
				}else
				if(apellido1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Falta Apellido1");
					b=false;
				}
				if(b){	
				ConfirmarModificacion cm= new ConfirmarModificacion();
				cm.setVisible(true);
				cm.setAlwaysOnTop(true);
				if(cm.getConfirmacionModificacion()){
					
					try{
						Familiar f;
						f=padre.getControladorPersonas().consultarFamiliar(getId());
						
						padre.getControladorPersonas().modificarDatosFamiliar(f.getId(), dni.getText(), nombre.getText(), apellido1.getText(), apellido2.getText(), f.getfNacimiento(), f.getTelefono(), f.getLugarNacimiento(), f.getDomicilio(), f.getCp(), f.getemail(),f.getidBeneficiario(),parentesco.getText(),ocupacion.getText());
						correcto=true;
								
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Error al modificar\n"+e1.getMessage());

					}
					
					if(correcto)
						JOptionPane.showMessageDialog(null, "Se ha modificado el usuario correctamente");
					else
						JOptionPane.showMessageDialog(null, "NO se ha modificado el usuario correctamente");

				}

			}
				
				
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(735, 567, 137, 28);
		add(button_1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfirmarBorradoFamiliar cbf= new ConfirmarBorradoFamiliar(padre);
				cbf.setVisible(true);
				cbf.setAlwaysOnTop(true);

				
				if(cbf.getConfirmacionBorrado()==true){
			
					try{
						
						padre.getControladorPersonas().borrarDatosFamiliar(getId());
						JOptionPane.showMessageDialog(null, "Se ha dado de baja el usuario\n");
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Error al dar de baja\n"+e1.getMessage());
					}
					
					
					
				}
				
				ini.setPanelOnTab(ini.panel_personas, PanelInicio.PERSONAS);
								
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(602, 568, 119, 28);
		add(btnEliminar);
		
		dni = new JTextField();
		dni.setBounds(267, 96, 110, 20);
		add(dni);
		dni.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(211, 99, 46, 14);
		add(lblDni);
		
		JLabel label_2 = new JLabel("(*)");
		label_2.setForeground(Color.RED);
		label_2.setBounds(178, 96, 46, 20);
		add(label_2);
		
		JLabel label_3 = new JLabel("(*)");
		label_3.setForeground(Color.RED);
		label_3.setBounds(178, 131, 46, 20);
		add(label_3);
		
		JLabel label_4 = new JLabel("(*)");
		label_4.setForeground(Color.RED);
		label_4.setBounds(507, 131, 46, 20);
		add(label_4);
	}

}
