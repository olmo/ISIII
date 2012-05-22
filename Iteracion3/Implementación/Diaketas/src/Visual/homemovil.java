package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;


public class homemovil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuarioText;
	private JPasswordField passText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homemovil frame = new homemovil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public homemovil() {
		setTitle("Asociaci\u00F3n diaketas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logoDiaketas = new JLabel("");
		logoDiaketas.setIcon(new ImageIcon(homemovil.class.getResource("/img/imagen.jpg")));
		logoDiaketas.setBounds(118, 69, 191, 144);
		contentPane.add(logoDiaketas);
		
		JLabel usuarioLabel = new JLabel("Usuario:");
		usuarioLabel.setBounds(60, 285, 46, 14);
		contentPane.add(usuarioLabel);
		
		JLabel passLabel = new JLabel("Contrase\u00F1a:");
		passLabel.setBounds(60, 328, 67, 14);
		contentPane.add(passLabel);
		
		usuarioText = new JTextField();
		usuarioText.setBounds(137, 282, 141, 20);
		contentPane.add(usuarioText);
		usuarioText.setColumns(10);
		
		passText = new JPasswordField();
		passText.setBounds(137, 325, 141, 20);
		contentPane.add(passText);
		passText.setColumns(10);
		
		JButton entrarBoton = new JButton("Entrar");
		entrarBoton.setBounds(137, 379, 141, 68);
		contentPane.add(entrarBoton);
		
		JLabel lblNewLabel = new JLabel("Asociaci\u00F3n Diaketas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 21, 200, 37);
		contentPane.add(lblNewLabel);
		
		JLabel incorrectaLabel = new JLabel("Nombre de usuario o contrase\u00F1a incorrecto");
		incorrectaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		incorrectaLabel.setForeground(Color.RED);
		incorrectaLabel.setBounds(77, 242, 289, 14);
		contentPane.add(incorrectaLabel);
	}
}
