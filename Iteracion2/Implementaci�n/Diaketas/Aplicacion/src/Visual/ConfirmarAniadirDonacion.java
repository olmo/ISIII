package Visual;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmarAniadirDonacion extends JDialog {
	
	private Boolean confirmacionModificacion=false;
	public ConfirmarAniadirDonacion() {
		setTitle("Confirmaci\u00F3n de Seguridad");
		setModal(true);
		setSize(PanelInicio.tamanoPaneles);
		setResizable(false);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		
		JLabel lblestSeguroQue = new JLabel("Está seguro de que quiere guardar los datos modificados?");
		lblestSeguroQue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblestSeguroQue.setBounds(10, 21, 340, 23);
		getContentPane().add(lblestSeguroQue);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmacionModificacion=true;
				dispose();
			}
		});
		btnAceptar.setBounds(46, 55, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmacionModificacion=false;
				dispose();
			}
		});
		btnCancelar.setBounds(206, 55, 89, 23);
		getContentPane().add(btnCancelar);
	}

	public void setConfirmacionModificacion(Boolean confirmacionModificacion) {
		this.confirmacionModificacion = confirmacionModificacion;
	}


	public Boolean getConfirmacionModificacion() {
		return confirmacionModificacion;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
