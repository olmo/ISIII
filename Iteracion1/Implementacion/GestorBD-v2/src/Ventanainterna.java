import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;

import java.sql.*;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;


public class Ventanainterna extends JInternalFrame {
	
	

	GestorDatos gd;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Ventanainterna(GestorConexion gc) {
		
		
		


		
		gd=new GestorDatos(gc);
				
		try {
			setSelected(true);
			setIcon(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		

		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setDividerLocation(110);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		JButton btnMostrarTabla = new JButton("Mostrar tabla");
		btnMostrarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(gd.consultardatos());
		}
		});
		panel_2.add(btnMostrarTabla);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		
		JLabel lblDni = new JLabel("Dni");
		panel_3.add(lblDni);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Nombre");
		panel_3.add(label_1);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFechaNacyyyyddmm = new JLabel("Fecha nac.(YYYY/DD/MM)");
		panel_3.add(lblFechaNacyyyyddmm);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("Insertar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gd.insertardatos(textField.getText(), textField_1.getText(), textField_2.getText());
			}
		});
		panel_3.add(button);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.CENTER);
		
		JLabel lblDni_1 = new JLabel("dni");
		panel_4.add(lblDni_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_4.add(textField_3);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textField_3.getText().equals("")){
					table.setModel(gd.buscardni(textField_3.getText()));

				}
			}
		});
		
		panel_4.add(btnBuscar);
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Resultados:");
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		table = new JTable();
		//panel_1.add(table, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.SOUTH);
		
		final JLabel seleccion = new JLabel();
		panel_5.add(seleccion);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccion.setText("se ha seleccionado: "+table.getModel().getValueAt(table.getSelectedRow(), 0));
			}
		});
		panel_5.add(btnSeleccionar);
		

	}
	
	


}
