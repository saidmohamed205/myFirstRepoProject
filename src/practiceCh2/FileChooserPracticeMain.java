package practiceCh2;

import java.awt.EventQueue;

public class FileChooserPracticeMain 
{

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				FileChooserPractice gui = new FileChooserPractice();
				gui.start();
			}
			
		});
	}

}
