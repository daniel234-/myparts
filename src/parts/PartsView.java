package parts;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class PartsView extends JFrame
{
	private PartsModel model;
	private PartsDetailView view;
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	private GridBagLayout partLayout;
	private DefaultListModel listModel;
	private JList partsList;
	
	public PartsView(PartsModel model, PartsDetailView view)
	{
		super("Parts System");
		this.model = model;
		this.view = view;
		
		partLayout = new GridBagLayout();
		GridBagConstraints g = new GridBagConstraints();
		this.setLayout(partLayout);
		Font bigFont = new Font("Serif", Font.PLAIN, 20); 
		
		listModel = new DefaultListModel();
		partsList = new JList(listModel);
		partsList.setFont(bigFont);
        partsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        partsList.setVisibleRowCount(10);
		g.fill = GridBagConstraints.BOTH;
		g.gridx = 0;
		g.gridy = 0;
		g.weighty = 0.95;
		g.gridwidth = 3;
		this.add(partsList,g);
		
		addButton = new JButton("Add Part");
		addButton.setFont(bigFont);
		g.fill = GridBagConstraints.NONE;
		g.gridx = 0;
		g.gridy = 1;
		g.weightx = 0.5;
		g.weighty = 0.05;
		g.anchor = GridBagConstraints.LAST_LINE_START;
		this.add(addButton,g);
		
		editButton = new JButton("Edit Part");
		editButton.setFont(bigFont);
		g.fill = GridBagConstraints.NONE;
		g.gridx = 1;
		g.gridy = 1;
		g.weightx = 0.5;
		g.weighty = 0.05;
		g.anchor = GridBagConstraints.PAGE_END;
		this.add(editButton,g);
		
		deleteButton = new JButton("Delete Part");
		deleteButton.setFont(bigFont);
		g.fill = GridBagConstraints.NONE;
		g.gridx = 2;
		g.gridy = 1;
		g.weightx = 0.5;
		g.weighty = 0.05;
		g.anchor = GridBagConstraints.LAST_LINE_END;
		this.add(deleteButton,g);
	}
	
	public void registerListeners(PartsButtonController controller1)
	{
		addButton.addActionListener(controller1);
		editButton.addActionListener(controller1);
		deleteButton.addActionListener(controller1);
	}
	
	public void windowTrigger(String event)
	{
		if(model.canOpen(2) == 1)
		{
			if(event.equalsIgnoreCase("Add"))
			{
				view.addWindow();
			}
			if(event.equalsIgnoreCase("Edit"))
			{
				String text = model.getPart(partsList.getSelectedIndex());
				if(text.equalsIgnoreCase("N/A"))
				{
					System.out.println("No element was selected. Add a part first.");
				}
				else
				{
					view.editWindow(text);
				}
			}
		}
	}

	public void refreshList() 
	{
		listModel.clear();
		for(int n = 0; n < 12; n++)
		{
			String text = model.refresh(n);
			if(text.equalsIgnoreCase(" "))
			{
				n = 12;
			}
			else
			{
				listModel.addElement(model.refresh(n));
			}
		}
	}

	public JList getPartsList() 
	{
		return this.partsList;
	}
}
