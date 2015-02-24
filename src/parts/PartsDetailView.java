package parts;

import java.awt.Font;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PartsDetailView extends JFrame
{
	private PartsModel model;
	private BoxLayout partLayout;
	private JButton finishButton;
	private JTextField field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14;
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8;
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
		
		partLayout = new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS);
		this.setLayout(partLayout); 
		
		finishButton = new JButton("Finish");
		finishButton.setFont(bigFont);
		this.add(finishButton);
	}
	
	public void addWindow()
	{	
		mode = 1;
		
		panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.LINE_AXIS));
		
		field1 = new JTextField("Please Enter New Part Information");
		field1.setFont(bigFont);
		field1.setEditable(false);
		panel1.add(field1);
		
		this.add(panel1);
		
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		
		field2 = new JTextField("         Part ID:");
		field2.setFont(bigFont);
		field2.setEditable(false);
		panel2.add(field2);
		
		field3 = new JTextField(model.getID(),10);
		field3.setFont(bigFont);
		field3.setEditable(false);
		panel2.add(field3);
		
		this.add(panel2);
		
		panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.LINE_AXIS));
		
		field4 = new JTextField("    Part Name:");
		field4.setFont(bigFont);
		field4.setEditable(false);
		panel3.add(field4);
		
		field5 = new JTextField("",10);
		field5.setFont(bigFont);
		field5.setEditable(true);
		panel3.add(field5);
		
		this.add(panel3);
		
		panel4 = new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.LINE_AXIS));
		
		field6 = new JTextField("Part Number:");
		field6.setFont(bigFont);
		field6.setEditable(false);
		panel4.add(field6);
		
		field7 = new JTextField("",10);
		field7.setFont(bigFont);
		field7.setEditable(true);
		panel4.add(field7);
		
		this.add(panel4);
		
		panel5 = new JPanel();
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.LINE_AXIS));
		
		field8 = new JTextField(" Part Amount:");
		field8.setFont(bigFont);
		field8.setEditable(false);
		panel5.add(field8);
		
		field9 = new JTextField("",10);
		field9.setFont(bigFont);
		field9.setEditable(true);
		panel5.add(field9);

		unitList.setSelectedIndex(2);
		panel5.add(unitList);
		
		this.add(panel5);

		panel6 = new JPanel();
		panel6.setLayout(new BoxLayout(panel6, BoxLayout.LINE_AXIS));
		
		field10 = new JTextField(" Part Vendor:");
		field10.setFont(bigFont);
		field10.setEditable(false);
		panel6.add(field10);
		
		field11 = new JTextField("",10);
		field11.setFont(bigFont);
		field11.setEditable(true);
		panel6.add(field11);
		
		this.add(panel6);
		
		panel7 = new JPanel();
		panel7.setLayout(new BoxLayout(panel7, BoxLayout.LINE_AXIS));
		
		field12 = new JTextField("Part External #:");
		field12.setFont(bigFont);
		field12.setEditable(false);
		panel7.add(field12);
		
		field13 = new JTextField("",10);
		field13.setFont(bigFont);
		field13.setEditable(true);
		panel7.add(field13);
		
		this.add(panel7);
		
		panel8 = new JPanel();
		panel8.setLayout(new BoxLayout(panel8, BoxLayout.LINE_AXIS));
		
		field14 = new JTextField("Part Location:");
		field14.setFont(bigFont);
		field14.setEditable(false);
		panel8.add(field14);
		
		locationList.setSelectedIndex(3);
		panel8.add(locationList);
		
		this.add(panel8);
		
		this.setVisible(true);
		model.canOpen(0);
	}
	
	public void editWindow(String text)
	{	
		mode = 2;
		this.copy = text;
		
		Scanner scan = new Scanner(text);
		
		panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.LINE_AXIS));
		
		field1 = new JTextField("Please Edit This Part Information");
		field1.setFont(bigFont);
		field1.setEditable(false);
		panel1.add(field1);
		
		this.add(panel1);
		
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		
		field2 = new JTextField("         Part ID:");
		field2.setFont(bigFont);
		field2.setEditable(false);
		panel2.add(field2);
		
		field3 = new JTextField(scan.next(),10);
		field3.setFont(bigFont);
		field3.setEditable(false);
		panel2.add(field3);
		
		this.add(panel2);
		
		panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.LINE_AXIS));
		
		field4 = new JTextField("    Part Name:");
		field4.setFont(bigFont);
		field4.setEditable(false);
		panel3.add(field4);
		
		field5 = new JTextField(scan.next(),10);
		field5.setFont(bigFont);
		field5.setEditable(true);
		panel3.add(field5);
		
		this.add(panel3);
		
		panel4 = new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.LINE_AXIS));
		
		field6 = new JTextField("Part Number:");
		field6.setFont(bigFont);
		field6.setEditable(false);
		panel4.add(field6);
		
		field7 = new JTextField(scan.next(),10);
		field7.setFont(bigFont);
		field7.setEditable(true);
		panel4.add(field7);
		
		this.add(panel4);
		
		panel5 = new JPanel();
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.LINE_AXIS));

		field8 = new JTextField(" Part Amount:");
		field8.setFont(bigFont);
		field8.setEditable(false);
		panel5.add(field8);
		
		field9 = new JTextField(scan.next(),10);
		field9.setFont(bigFont);
		field9.setEditable(true);
		panel5.add(field9);
		
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
		panel5.add(unitList);
		
		this.add(panel5);
		
		panel6 = new JPanel();
		panel6.setLayout(new BoxLayout(panel6, BoxLayout.LINE_AXIS));
		
		field10 = new JTextField(" Part Vendor:");
		field10.setFont(bigFont);
		field10.setEditable(false);
		panel6.add(field10);
		
		field11 = new JTextField(scan.next(),10);
		field11.setFont(bigFont);
		field11.setEditable(true);
		panel6.add(field11);
		
		this.add(panel6);
		
		panel7 = new JPanel();
		panel7.setLayout(new BoxLayout(panel7, BoxLayout.LINE_AXIS));

		field12 = new JTextField("Part External #:");
		field12.setFont(bigFont);
		field12.setEditable(false);
		panel7.add(field12);
		
		field13 = new JTextField(scan.next(),10);
		field13.setFont(bigFont);
		field13.setEditable(true);
		panel7.add(field13);
		
		this.add(panel7);
		
		panel8 = new JPanel();
		panel8.setLayout(new BoxLayout(panel8, BoxLayout.LINE_AXIS));
		
		field14 = new JTextField("Part Location:");
		field14.setFont(bigFont);
		field14.setEditable(false);
		panel8.add(field14);

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
		panel8.add(locationList);
		
		this.add(panel8);
		
		scan.close();
		this.setVisible(true);
		model.canOpen(0);
	}
	
	public int checkInput()
	{
		if(model.checkPart(field5.getText(),field7.getText(),field9.getText(),field13.getText(),mode) == 1)
		{
			return 1;
		}
		if(mode==1)
		{
			model.addPart(field3.getText(),field5.getText(),field7.getText(),field9.getText(),field11.getText(),field13.getText());
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
			String copyexternal = scan.next();
			scan.close();
			int check = model.editPart(field3.getText(),field5.getText(),field7.getText(),field9.getText(),field11.getText(),field13.getText(),copyid,copyname,copynumber,copyamount,copyvendor,copyexternal);
			if(check==0)
			{
				model.addPart(field3.getText(),field5.getText(),field7.getText(),field9.getText(),field11.getText(),field13.getText());
			}
		}
		this.windowCleanUp();
		return 0;
	}
	
	public void windowCleanUp()
	{
		this.setVisible(false);
		this.remove(panel1);
		this.remove(panel2);
		this.remove(panel3);
		this.remove(panel4);
		this.remove(panel5);
		this.remove(panel6);
		this.remove(panel7);
		this.remove(panel8);
		model.canOpen(1);
	}
	
	public void registerListeners(PartsButtonController controller1, PartsWindowController controller2, PartsUnitPartController controller3, PartsLocationController controller4) 
	{
		this.addWindowListener(controller2);
		finishButton.addActionListener(controller1);
		unitList.addActionListener(controller3);
		locationList.addActionListener(controller4);
	}
}
