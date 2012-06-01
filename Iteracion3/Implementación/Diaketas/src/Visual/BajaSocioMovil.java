package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaSocioMovil extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Boolean baja;
	private int borrado;
	private VentanaPrincipalMovil padre;
	/**
	 * Create the dialog.
	 * @param menuMovil 
	 */
	public BajaSocioMovil(VentanaPrincipalMovil mipadre) {
		baja = false;
		borrado = 0;
		padre = mipadre;
		setBounds(100, 100, 431, 249);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		final JCheckBox borradoCheck = new JCheckBox("\u00BFDesea borrar su informaci\u00F3n de la base de datos?");
		borradoCheck.setBounds(53, 79, 275, 23);
		contentPanel.add(borradoCheck);
		
		{
			JButton aceptarBoton = new JButton("Aceptar");
			aceptarBoton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				//BORRAR SOCIO
					baja = true;
					if(borradoCheck.isSelected()){
						padre.getControladorMovil().solicitarBaja(padre.getIDsesion(), 1);
					}else{
						padre.getControladorMovil().solicitarBaja(padre.getIDsesion(),0);
					}
					dispose();
				}
			});
			aceptarBoton.setBounds(53, 164, 120, 36);
			contentPanel.add(aceptarBoton);
			aceptarBoton.setActionCommand("OK");
			getRootPane().setDefaultButton(aceptarBoton);
		}
		{
			JButton cancelarBoton = new JButton("Cancelar");
			cancelarBoton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//NOHACE NADA
					JOptionPane.showMessageDialog(null,"CANCELAR BAJA ");
					dispose();
				}
			});
			cancelarBoton.setBounds(261, 164, 120, 36);
			contentPanel.add(cancelarBoton);
			cancelarBoton.setActionCommand("Cancel");
		}
		
		JLabel mensajeBajaLabel = new JLabel("\u00BFEst\u00E1 seguro que desea confirmar la baja de la asociaci\u00F3n?");
		mensajeBajaLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mensajeBajaLabel.setBounds(53, 22, 346, 50);
		contentPanel.add(mensajeBajaLabel);
		
	}
	
	public Boolean getBaja(){
		return baja;
	}
	
	public int getBorrado(){
		return borrado;
	}
}
