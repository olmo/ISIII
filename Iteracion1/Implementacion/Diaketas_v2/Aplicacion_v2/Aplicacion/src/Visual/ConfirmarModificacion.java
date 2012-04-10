package Visual;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmarModificacion extends JDialog {
	
	
	public ConfirmarModificacion() {
		setTitle("Confirmaci\u00F3n de Seguridad");
		setSize(new Dimension(420, 150));
		setResizable(false);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		
		JLabel lblestSeguroQue = new JLabel("\u00BFEst\u00E1 seguro que quiere guardar los datos modificados?");
		lblestSeguroQue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblestSeguroQue.setBounds(10, 21, 340, 23);
		getContentPane().add(lblestSeguroQue);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(46, 55, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(206, 55, 89, 23);
		getContentPane().add(btnCancelar);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
