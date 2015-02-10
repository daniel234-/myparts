package test.parts;

import static org.junit.Assert.*;

import org.junit.Test;

import parts.PartsModel;

import java.util.Scanner;

public class PartsTest {

	@Test
	public void testGetPart() // Successful get part
	{	
		//fail("Not yet implemented");
		PartsModel model = new PartsModel();
		model.addPart("1","name","123","1","vendor","123");
		String text = model.getPart(0);
		Scanner scan = new Scanner(text);
		String result = scan.next();
		scan.close();
		assertTrue(result.equalsIgnoreCase("name"));
	}

	@Test
	public void testEditPart() // Successful part change
	{	
		//fail("Not yet implemented");
		PartsModel model = new PartsModel();
		model.addPart("1","name","123","1","vendor","123");
		int result = model.editPart("1","n@me", "1234", "2", "vendor","123","1","name","123","1","vendor","123");
		assertTrue(result==1);
	}
	
	@Test
	public void testAddCopyPart() // Unsuccessful add part with existing part name
	{	
		//fail("Not yet implemented");
		PartsModel model = new PartsModel();
		model.addPart("1","name","123","1","vendor","123");
		model.addPart("1","name","123","-1","vendor","123");
		String text = model.refresh(1);
		System.out.println(text);
		assertTrue(text.equalsIgnoreCase(" "));
	}
	
	@Test
	public void testInvalidNumber() // Successful detection of incorrect amount
	{	
		//fail("Not yet implemented");
		PartsModel model = new PartsModel();
		int result = model.checkNumber("1001011A", 1);
		assertFalse(result==0);
	}
}
