package Visual;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ConfirmacionCancelarBaja extends JDialog {

	private Boolean confirmacionCancelado=false;
	public ConfirmacionCancelarBaja(VentanaPrincipal p) {
		setTitle("Confirmaci\u00F3n de Seguridad");

		setModal(true);
		setSize(new Dimension(450, 250));
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblestSeguroQue = new JLabel("¿Está seguro de que quiere borrar el solicitante?");
		lblestSeguroQue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblestSeguroQue.setBounds(45, 40, 340, 23);
		getContentPane().add(lblestSeguroQue);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
		
			public void actionPerformed(ActionEvent e) {
				confirmacionCancelado=true;
				dispose();
			}
		});
		btnAceptar.setBounds(92, 143, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmacionCancelado=false;
				dispose();
			}
		});
		btnCancelar.setBounds(239, 143, 89, 23);
		getContentPane().add(btnCancelar);
	}
	
	public void setconfirmacionCancelado(Boolean confirmacionCancelado) {
		this.confirmacionCancelado = confirmacionCancelado;
	}


	public Boolean getconfirmacionCancelado() {
		return confirmacionCancelado;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

