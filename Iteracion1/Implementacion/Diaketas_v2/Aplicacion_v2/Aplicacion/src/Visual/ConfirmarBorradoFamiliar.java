package Visual;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ConfirmarBorradoFamiliar extends JDialog {
	//private VentanaPrincipal padre;
	
	public ConfirmarBorradoFamiliar(VentanaPrincipal p) {
		setTitle("Confirmaci\u00F3n de Seguridad");
		//padre=p;
		setModal(true);
		setSize(new Dimension(450, 250));
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblestSeguroQue = new JLabel("¿Está seguro de que quiere dar de baja al familiar?");
		lblestSeguroQue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblestSeguroQue.setBounds(45, 40, 340, 23);
		getContentPane().add(lblestSeguroQue);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(92, 143, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(239, 143, 89, 23);
		getContentPane().add(btnCancelar);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Borrar los datos del usuario de la base de datos");
		chckbxNewCheckBox.setBounds(77, 86, 299, 23);
		getContentPane().add(chckbxNewCheckBox);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
