package parts;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PartsWindowController implements WindowListener
{
	private PartsDetailView view;
	
	public PartsWindowController(PartsDetailView view) 
	{
		this.view = view;
	}

	public void windowActivated(WindowEvent arg0) 
	{
		//do nothing
	}

	public void windowClosed(WindowEvent arg0) 
	{
		view.windowCleanUp();
	}

	public void windowClosing(WindowEvent arg0) 
	{
		view.windowCleanUp();
	}

	public void windowDeactivated(WindowEvent arg0) 
	{
		//do nothing
	}

	public void windowDeiconified(WindowEvent arg0) 
	{
		//do nothing
	}

	public void windowIconified(WindowEvent arg0) 
	{
		//do nothing
	}

	public void windowOpened(WindowEvent arg0) 
	{
		//do nothing
	}
}
