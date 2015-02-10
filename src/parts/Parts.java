package parts;

//CS 4743 Assignment 1 by Daniel Gardner

import java.awt.Dimension;

import javax.swing.JFrame;

public class Parts 
{
	public static void main(String[] args) 
	{
		Dimension minimumSize = new Dimension(680,480);
		
		PartsModel model = new PartsModel();
		PartsDetailView view2 = new PartsDetailView(model);
		PartsView view1 = new PartsView(model, view2);
		PartsButtonController controller1 = new PartsButtonController(view1, view2, model);
		PartsWindowController controller2 = new PartsWindowController(view2);
		PartsUnitPartController controller3 = new PartsUnitPartController(model);
		PartsLocationController controller4 = new PartsLocationController(model);
		
		view1.registerListeners(controller1);
		view2.registerListeners(controller1,controller2,controller3,controller4);
		
		view1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view1.setSize(680,480);
		view1.setMinimumSize(minimumSize);
		view1.setVisible(true);
		
		view2.setSize(400,320);
		view2.setLocation(680, 100);
		view2.setResizable(false);
		view2.setVisible(false);
	}
}
