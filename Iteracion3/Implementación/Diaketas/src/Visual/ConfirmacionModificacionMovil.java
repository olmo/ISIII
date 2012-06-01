package Visual;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmacionModificacionMovil extends JDialog {
	private Boolean confirmacionmodificacion= false;
	private VentanaPrincipalMovil padre;

	/**
	 * Create the dialog.
	 * @param padre 
	 */
	
	public ConfirmacionModificacionMovil(VentanaPrincipalMovil mipadre, final String dni, final String nombre, final String apellido1, final String apellido2, final String fn,
			final int telefono,final String ln, final String dir, final int cp, final String email, final int periocidad) {
		padre = mipadre;
		setTitle("Asociaci\u00F3n Diaketas");
		setBounds(100, 100, 253, 217);
		getContentPane().setLayout(null);
		{
			JLabel mensajeLabel = new JLabel("\u00BFQuiere insertar \r\nlos datos actuales?");
			mensajeLabel.setBounds(0, 42, 237, 15);
			getContentPane().add(mensajeLabel);
			mensajeLabel.setToolTipText("");
			mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			mensajeLabel.setVerticalAlignment(SwingConstants.TOP);
			mensajeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		{
			JButton okButton = new JButton("Aceptar");
			okButton.setBounds(10, 97, 98, 50);
			getContentPane().add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					padre.getControladorMovil().modificarDatosSocio(padre.getIDsesion().intValue(), dni, nombre, apellido1, apellido2, fn,telefono, ln, dir, cp, email,periocidad,padre.getusuario(),padre.getContrasena());					
					dispose();					
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setBounds(129, 97, 98, 50);
			getContentPane().add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();					
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
	}

}
