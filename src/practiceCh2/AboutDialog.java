package practiceCh2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class AboutDialog extends JDialog
{
	public AboutDialog(JFrame owner)
	{
		super(owner, "about the Software", true);
		add(new JLabel (
				"<html><h1><i>Picture Attachment Software</i></h1><hr>By Said Mohamed</html>"), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		JButton ok = new JButton("Thanks");
		
		ok.addActionListener(new ActionListener()
		        {

					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
					}
					
		        });
		
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		
		pack();
//		this.setVisible(true);
	}

}
