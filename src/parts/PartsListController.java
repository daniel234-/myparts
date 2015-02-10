package parts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class PartsListController implements ActionListener
{
	private PartsModel model;
	
	public PartsListController(PartsModel model)
	{
		this.model = model;
	}
	
	public void actionPerformed(ActionEvent a)
	{
        JComboBox cb = (JComboBox)a.getSource();
        String partName = (String)cb.getSelectedItem();
        if(partName.equalsIgnoreCase("Linear Feet") || partName.equalsIgnoreCase("Pieces"))
        {
        	model.setUnitPart(partName);
        	System.out.println(partName);
        }
        else
        {
        	model.setLocation(partName);
        	System.out.println(partName);
        }
	}
}
