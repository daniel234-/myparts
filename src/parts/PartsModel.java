package parts;

import java.util.Scanner;

public class PartsModel 
{
	private int width, height;
	private String[][] nameArray = new String[12][4];
	private int status = 1;
	private String text = "";
	private int mode = 0;
	
	public PartsModel()
	{
		this.width = 0;
		this.height = 0;
	}
	
	public String refresh(int n)
	{
		if(nameArray[n][0] == null)
		{
			return " ";
		}
		if(nameArray[n][3] == null)
		{
			text = (nameArray[n][0] + ", " + nameArray[n][1] + ", " + nameArray[n][2]);
			return this.text;
		}
		else
		{
			text = (nameArray[n][0] + ", " + nameArray[n][1] + ", " + nameArray[n][2] + ", " + nameArray[n][3]);
			return this.text;
		}
	}
	
	public void addPart(String name, String number, String amount, String vendor)
	{
		for(int a = 0; a < nameArray.length; a++)
		{
			if(nameArray[a][0] == null)
			{
				nameArray[a][0] = name;
				nameArray[a][1] = number;
				nameArray[a][2] = amount;
				if(vendor.equalsIgnoreCase(""))
				{
					a = nameArray.length;
					continue;
				}
				else
				{
					nameArray[a][3] = vendor;
					a = nameArray.length;
					continue;
				}
			}
			if(nameArray[a][0].equalsIgnoreCase(name))
			{
				a = nameArray.length;
				System.out.println("Similar part name found, add failed.");
			}
		}
	}
	
	public String getPart(int index)
	{
		for(int g = 0; g < nameArray.length; g++)
		{
			if(g == index)
			{
				text = (nameArray[g][0] + " " + nameArray[g][1] + " " + nameArray[g][2] + " " + nameArray[g][3]);
				return text;
			}
		}
		return " ";
	}
	
	public int editPart(String name, String number, String amount, String vendor, String copyname, String copynumber, String copyamount, String copyvendor)
	{
		for(int e = 0; e < nameArray.length; e++)
		{
			if(nameArray[e][0].equalsIgnoreCase(name) && !name.equalsIgnoreCase(copyname))
			{
				System.out.println("Similar part name found, edit failed.");
				return 1;
			}
			if(nameArray[e][0].equalsIgnoreCase(copyname) && nameArray[e][1].equalsIgnoreCase(copynumber) && nameArray[e][2].equalsIgnoreCase(copyamount) && nameArray[e][3].equalsIgnoreCase(copyvendor))
			{
				nameArray[e][0] = name;
				nameArray[e][1] = number;
				nameArray[e][2] = amount;
				nameArray[e][3] = vendor;
				e = nameArray.length;
				return 1;
			}
		}
		return 0;
	}
	
	public void deletePart(String part)
	{
		int found = 0;
		Scanner scan = new Scanner(part);
		text = scan.next();
		scan.close();
		for(int d = 0; d < nameArray.length; d++)
		{
			if(found == 1 && d == nameArray.length - 1)
			{
				nameArray[d][0] = null;
				nameArray[d][1] = null;
				nameArray[d][2] = null;
				nameArray[d][3] = null;
			}
			else if(found == 1 && d < nameArray.length - 1)
			{
				nameArray[d][0] = nameArray[d+1][0];
				nameArray[d][1] = nameArray[d+1][1];
				nameArray[d][2] = nameArray[d+1][2];
				nameArray[d][3] = nameArray[d+1][3];
			}
			else if(nameArray[d][0].equalsIgnoreCase(text))
			{
				found = 1;
				nameArray[d][0] = nameArray[d+1][0];
				nameArray[d][1] = nameArray[d+1][1];
				nameArray[d][2] = nameArray[d+1][2];
				nameArray[d][3] = nameArray[d+1][3];
			}
		}
	}
	
	public int canOpen(int status)
	{
		if(this.status == 1 && status == 2)
		{
			return 1;
		}
		else if (status < 2)
		{
			this.status = status;
			return 0;
		}
		else return 0;
	}
	
	public int checkPart(String name, String number, String amount, int mode)
	{
		if(name.equalsIgnoreCase(""))
		{
			System.out.println("Invalid name.");
			return 1;
		}
		if(name.length() > 20)
		{
			System.out.println("Name too long.");
			return 1;
		}
		if(number.equalsIgnoreCase(""))
		{
			System.out.println("Invalid number.");
			return 1;
		}
		if(amount.equalsIgnoreCase(""))
		{
			System.out.println("Invalid amount.");
			return 1;
		}
		if(this.checkNumber(amount,mode) == 1)
		{
			System.out.println("Amount too low.");
			return 1;
		}
		return 0;
	}
	
	public int checkNumber(String text, int mode)
	{
		this.text = text;
		this.mode = mode;
		try
		{
			int number = Integer.parseInt(this.text);
			if(number < 1 && this.mode == 1)
			{
				return 1;
			}
			if(number < 0)
			{
				return 1;
			}
		}
		catch(NumberFormatException n)
		{
			return 1;
		}
		return 0;
	}

	public int getWidth() 
	{
		return this.width;
	}

	public int getHeight() 
	{
		return this.height;
	}
	
	public void setSize(int length1, int length2) {
		this.width = length1;
		this.height = length2;
	}
}
