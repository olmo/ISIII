import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


class RadioButtonRenderer implements TableCellRenderer {
	  public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
	   
		   

		  if (value == null)
	      return null;
	    return (Component) value;
	  }
	}

	class RadioButtonEditor extends DefaultCellEditor implements ItemListener {
	  private JRadioButton button;

	  public RadioButtonEditor(JCheckBox checkBox) {
	    super(checkBox);

	  }

	  public Component getTableCellEditorComponent(JTable table, Object value,boolean isSelected, int row, int column) {
		  System.out.println(isSelected+"-----"+value);
	    if (value == null)
	      return null;
	    button = (JRadioButton) value;
	    button.addItemListener(this);
	    return (Component) value;
	  }
	  
	  public Object getCellEditorValue() {

	    button.removeItemListener(this);
	   
	    return button;
	  }
	  
	  public void itemStateChanged(ItemEvent e) {
		  System.out.println(3);
		  System.out.println(System.currentTimeMillis());
	    super.fireEditingStopped();

	  }
	}
	

