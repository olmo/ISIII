package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class BarraProgreso extends JDialog implements Runnable{

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private boolean fin;
	/**
	 * Create the dialog.
	 */
	public BarraProgreso() {
		setBounds(100, 100, 450, 300);
		fin = false;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			scrollPane = new JScrollPane();
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		{
			textArea = new JTextArea();
			
			scrollPane.setViewportView(textArea);
		}
		contentPanel.setLayout(gl_contentPanel);
		this.setFocusableWindowState(true);
		setVisible(true);
	}

	public void actualizaProgreso(String progreso){
		textArea.setText(textArea.getText()+progreso);

	}
	
	public void terminado(){
		fin = true;
		setVisible(false);
	}
	
	public void run(){
		while(!fin){
			try{
				Thread.sleep(1000);
				textArea.paintImmediately(0, 0, 450, 300);
			}catch (Exception e){}
		}
	}
}
