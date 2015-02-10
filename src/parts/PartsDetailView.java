package parts;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class PartsDetailView extends JFrame
{
	private PartsModel model;
	private GridBagLayout partLayout;
	private JButton finishButton;
	private JTextField field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12;
	private GridBagConstraints g = new GridBagConstraints();
	private int mode;
	private String copy;
	private Font bigFont = new Font("Serif", Font.PLAIN, 20);
	private String[] units = {"Linear Feet", "Pieces", "Unknown"};
	private JComboBox unitList = new JComboBox(units);
	private String[] locations = {"Facility 1 Warehouse 1", "Facility 1 Warehouse 2", "Facility 2","Unknown"};
	private JComboBox locationList = new JComboBox(locations);
	
	public PartsDetailView(PartsModel model)
	{
		super("Detail Part View");
		this.model = model;
		
		partLayout = new GridBagLayout();
		this.setLayout(partLayout); 
		
		finishButton = new JButton("Finish");
		finishButton.setFont(bigFont);
		g.fill = GridBagConstraints.NONE;
		g.gridx = 0;
		g.gridy = 7;
		g.gridwidth = 3;
		g.anchor = GridBagConstraints.PAGE_END;
		this.add(finishButton,g);
	}
	
	public void addWindow()
	{	
		mode = 1;
		
		field1 = new JTextField("Please Enter New Part Information");
		field1.setFont(bigFont);
		field1.setEditable(false);
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 3;
		this.add(field1,g);
		
		field2 = new JTextField("         Part ID:");
		field2.setFont(bigFont);
		field2.setEditable(false);
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		this.add(field2,g);
		
		field3 = new JTextField(model.getID(),10);
		field3.setFont(bigFont);
		field3.setEditable(false);
		g.gridx = 1;
		g.gridy = 1;
		g.gridwidth = 1;
		this.add(field3,g);
		
		field4 = new JTextField("    Part Name:");
		field4.setFont(bigFont);
		field4.setEditable(false);
		g.gridx = 0;
		g.gridy = 2;
		g.gridwidth = 1;
		this.add(field4,g);
		
		field5 = new JTextField("",10);
		field5.setFont(bigFont);
		field5.setEditable(true);
		g.gridx = 1;
		g.gridy = 2;
		g.gridwidth = 1;
		this.add(field5,g);
		
		field6 = new JTextField("Part Number:");
		field6.setFont(bigFont);
		field6.setEditable(false);
		g.gridx = 0;
		g.gridy = 3;
		g.gridwidth = 1;
		this.add(field6,g);
		
		field7 = new JTextField("",10);
		field7.setFont(bigFont);
		field7.setEditable(true);
		g.gridx = 1;
		g.gridy = 3;
		g.gridwidth = 1;
		this.add(field7,g);
		
		field8 = new JTextField(" Part Amount:");
		field8.setFont(bigFont);
		field8.setEditable(false);
		g.gridx = 0;
		g.gridy = 4;
		g.gridwidth = 1;
		this.add(field8,g);
		
		field9 = new JTextField("",10);
		field9.setFont(bigFont);
		field9.setEditable(true);
		g.gridx = 1;
		g.gridy = 4;
		g.gridwidth = 1;
		this.add(field9,g);
		
		unitList.setSelectedIndex(2);
		g.gridx = 2;
		g.gridy = 4;
		g.gridwidth = 1;
		this.add(unitList,g);
		
		field10 = new JTextField(" Part Vendor:");
		field10.setFont(bigFont);
		field10.setEditable(false);
		g.gridx = 0;
		g.gridy = 5;
		g.gridwidth = 1;
		this.add(field10,g);
		
		field11 = new JTextField("",10);
		field11.setFont(bigFont);
		field11.setEditable(true);
		g.gridx = 1;
		g.gridy = 5;
		g.gridwidth = 1;
		this.add(field11,g);

		field12 = new JTextField("Part Location:");
		field12.setFont(bigFont);
		field12.setEditable(false);
		g.gridx = 0;
		g.gridy = 6;
		g.gridwidth = 1;
		this.add(field12,g);
		
		locationList.setSelectedIndex(3);
		g.gridx = 1;
		g.gridy = 6;
		g.gridwidth = 1;
		this.add(locationList,g);
		
		this.setVisible(true);
		model.canOpen(0);
	}
	
	public void editWindow(String text)
	{	
		mode = 2;
		this.copy = text;
		
		Scanner scan = new Scanner(text);
		
		field1 = new JTextField("Please Edit This Part Information");
		field1.setFont(bigFont);
		field1.setEditable(false);
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 3;
		this.add(field1,g);
		
		field2 = new JTextField("         Part ID:");
		field2.setFont(bigFont);
		field2.setEditable(false);
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		this.add(field2,g);
		
		field3 = new JTextField(scan.next(),10);
		field3.setFont(bigFont);
		field3.setEditable(false);
		g.gridx = 1;
		g.gridy = 1;
		g.gridwidth = 1;
		this.add(field3,g);
		
		field4 = new JTextField("    Part Name:");
		field4.setFont(bigFont);
		field4.setEditable(false);
		g.gridx = 0;
		g.gridy = 2;
		g.gridwidth = 1;
		this.add(field4,g);
		
		field5 = new JTextField(scan.next(),10);
		field5.setFont(bigFont);
		field5.setEditable(true);
		g.gridx = 1;
		g.gridy = 2;
		g.gridwidth = 1;
		this.add(field5,g);
		
		field6 = new JTextField("Part Number:");
		field6.setFont(bigFont);
		field6.setEditable(false);
		g.gridx = 0;
		g.gridy = 3;
		g.gridwidth = 1;
		this.add(field6,g);
		
		field7 = new JTextField(scan.next(),10);
		field7.setFont(bigFont);
		field7.setEditable(true);
		g.gridx = 1;
		g.gridy = 3;
		g.gridwidth = 1;
		this.add(field7,g);

		field8 = new JTextField(" Part Amount:");
		field8.setFont(bigFont);
		field8.setEditable(false);
		g.gridx = 0;
		g.gridy = 4;
		g.gridwidth = 1;
		this.add(field8,g);
		
		field9 = new JTextField(scan.next(),10);
		field9.setFont(bigFont);
		field9.setEditable(true);
		g.gridx = 1;
		g.gridy = 4;
		g.gridwidth = 1;
		this.add(field9,g);
		
		String unitName = scan.next();
		
		if(unitName.equalsIgnoreCase("Linear"))
		{
			unitList.setSelectedIndex(0);
			scan.next();
		}
		else
		{
			unitList.setSelectedIndex(1);
		}
		g.gridx = 2;
		g.gridy = 4;
		g.gridwidth = 1;
		this.add(unitList,g);
		
		field10 = new JTextField(" Part Vendor:");
		field10.setFont(bigFont);
		field10.setEditable(false);
		g.gridx = 0;
		g.gridy = 5;
		g.gridwidth = 1;
		this.add(field10,g);
		
		field11 = new JTextField(scan.next(),10);
		field11.setFont(bigFont);
		field11.setEditable(true);
		g.gridx = 1;
		g.gridy = 5;
		g.gridwidth = 1;
		this.add(field11,g);
		
		field12 = new JTextField("Part Location:");
		field12.setFont(bigFont);
		field12.setEditable(false);
		g.gridx = 0;
		g.gridy = 6;
		g.gridwidth = 1;
		this.add(field12,g);
		
		scan.next();
		String locationName = scan.next();
		
		if(locationName.equalsIgnoreCase("2"))
		{
			locationList.setSelectedIndex(2);
		}
		else
		{
			scan.next();
			locationName = scan.next();
			if(locationName.equalsIgnoreCase("1"))
			{
				locationList.setSelectedIndex(0);
			}
			else
			{
				locationList.setSelectedIndex(1);
			}
		}
		g.gridx = 1;
		g.gridy = 6;
		g.gridwidth = 1;
		this.add(locationList,g);
		
		scan.close();
		this.setVisible(true);
		model.canOpen(0);
	}
	
	public int checkInput()
	{
		if(model.checkPart(field5.getText(),field7.getText(),field9.getText(),mode) == 1)
		{
			return 1;
		}
		if(mode==1)
		{
			model.addPart(field3.getText(),field5.getText(),field7.getText(),field9.getText(),field11.getText());
		}
		if(mode==2)
		{
			Scanner scan = new Scanner(this.copy);
			String copyid = scan.next();
			String copyname = scan.next();
			String copynumber = scan.next();
			String copyamount = scan.next();
			
			String unitName = scan.next();
			if(unitName.equalsIgnoreCase("Linear"))
			{
				scan.next();
			}
			
			String copyvendor = scan.next();
			scan.close();
			int check = model.editPart(field3.getText(),field5.getText(),field7.getText(),field9.getText(),field11.getText(),copyid,copyname,copynumber,copyamount,copyvendor);
			if(check==0)
			{
				model.addPart(field3.getText(),field5.getText(),field7.getText(),field9.getText(),field11.getText());
			}
		}
		this.windowCleanUp();
		return 0;
	}
	
	public void windowCleanUp()
	{
		this.setVisible(false);
		this.remove(field1);
		this.remove(field2);
		this.remove(field3);
		this.remove(field4);
		this.remove(field5);
		this.remove(field6);
		this.remove(field7);
		this.remove(field8);
		this.remove(field9);
		this.remove(field10);
		this.remove(field11);
		this.remove(field12);
		model.canOpen(1);
	}
	
	public void registerListeners(PartsButtonController controller1, PartsWindowController controller2, PartsListController controller3) 
	{
		this.addWindowListener(controller2);
		finishButton.addActionListener(controller1);
		unitList.addActionListener(controller3);
		locationList.addActionListener(controller3);
	}
}
