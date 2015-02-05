package parts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

public class PartsButtonController implements ActionListener
{
	private PartsModel model;
	private PartsView view;
	private PartsDetailView view2;
	private JList list;
	
	public PartsButtonController(PartsView view, PartsDetailView view2, PartsModel model)
	{
		this.model = model;
		this.view = view;
		this.view2 = view2;
	}

	public void actionPerformed(ActionEvent e) 
	{
		String command = e.getActionCommand();
		if(command.equalsIgnoreCase("Add Part"))
		{
			view.windowTrigger("Add");
		}
		if(command.equalsIgnoreCase("Edit Part"))
		{
			view.windowTrigger("Edit");
		}
		if(command.equalsIgnoreCase("Delete Part"))
		{
			list = view.getPartsList();
			String text = model.getPart(list.getSelectedIndex());
			model.deletePart(text);
			view.refreshList();
		}
		if(command.equalsIgnoreCase("Finish"))
		{
			view2.checkInput();
			view.refreshList();
		}
	}
}
