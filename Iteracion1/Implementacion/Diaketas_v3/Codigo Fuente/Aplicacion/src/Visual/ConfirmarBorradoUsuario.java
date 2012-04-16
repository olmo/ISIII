package Visual;


import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ConfirmarBorradoUsuario extends JDialog {
	private Boolean confirmacionBaja=false;
	private Boolean confirmacionBorrado=false;
	private Boolean decision=false;

	public ConfirmarBorradoUsuario(VentanaPrincipal p) {
		setModal(true);
		setTitle("Confirmaci\u00F3n de Seguridad");
		setSize(new Dimension(450, 250));
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblestSeguroQue = new JLabel("¿Está seguro de que quiere dar de baja al usuario?");
		lblestSeguroQue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblestSeguroQue.setBounds(45, 40, 340, 23);
		getContentPane().add(lblestSeguroQue);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Borrar los datos del usuario de la base de datos");
		chckbxNewCheckBox.setBounds(77, 86, 299, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected())
					setConfirmacionBorrado(true);
				setConfirmacionBaja(true);
				
				dispose();
				
				
				decision=true;
			}
		});
		btnAceptar.setBounds(92, 143, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setConfirmacionBaja(false);
				decision=true;
				dispose();
			}
		});
		btnCancelar.setBounds(239, 143, 89, 23);
		getContentPane().add(btnCancelar);
		
		
	}
	
	public Boolean getConfirmacionBorrado() {
		return confirmacionBorrado;
	}


	public void setConfirmacionBorrado(Boolean confirmacionBorrado) {
		this.confirmacionBorrado = confirmacionBorrado;
	}


	public Boolean getConfirmacionBaja() {
		return confirmacionBaja;
	}
	
	public Boolean getDecision() {
		return decision;
	}


	public void setConfirmacionBaja(Boolean confirmacionBaja) {
		this.confirmacionBaja = confirmacionBaja;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
