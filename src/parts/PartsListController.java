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
        String unitName = (String)cb.getSelectedItem();
        model.setUnitPart(unitName);
	}
}
