/**
  * Said Mohamed
 * Fri 4/03/14 0244
 * FileChooserPractice.java
 * this class will allow you to choose a file that has
 * picture 
 */
package practiceCh2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
/**
 * This class allows the user to view images.
 * @author Said Mohamed.
 * @version 4/29/2014
 *
 */
@SuppressWarnings("serial")
public class FileChooserPractice extends JFrame implements ActionListener
{
	
	//constants
	private static final int APPLET_WIDTH = 400;
	private static final int APPLET_HEIGHT = APPLET_WIDTH * 2;
	
	// a separate class call AboutDialog.
	private AboutDialog myDialog;
	
	// instance fields.
	private JLabel myLabel;
	private JFileChooser myFileChooser;
	private JTextArea myLog;
	private JMenuItem existItem;     
	private JMenuItem openItem;
	private JMenu aboutMenu;
	private JMenuItem mySaveAs;
	
	
	public FileChooserPractice()
	{
		this.setTitle("Attach picture");
		this.setSize(APPLET_WIDTH, APPLET_HEIGHT);
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	
	public void start()
	{
		// using lable to display the image.
		myLabel = new JLabel();
		add(myLabel);
		
		// set up fileChooser.
		myFileChooser = new JFileChooser();
		myFileChooser.setAcceptAllFileFilterUsed(true);
		
		// set up menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		menu.setMnemonic('f');
		
		openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(this);
		
		mySaveAs = new JMenuItem("SaveAs...");
		menu.addSeparator();
		menu.add(mySaveAs);
		mySaveAs.setEnabled(false);
		mySaveAs.addActionListener(this);
		
		existItem = new JMenuItem("Exist");
		menu.addSeparator();
		menu.add(existItem);
		existItem.addActionListener(this);
		
		aboutMenu = new JMenu("About");
		aboutMenu.addActionListener(new ActionListener()  // this does not work yet, am trying to make a pop up for 
		                                                  // the user extra infor about the software.
		{

			@Override
			public void actionPerformed(ActionEvent event)
			{
				System.out.print("i am listening");
				myDialog = new AboutDialog(FileChooserPractice.this);
				myDialog.setVisible(true);

			}
			
		});
		menuBar.add(aboutMenu);
		
	}

	@Override
	public void actionPerformed(ActionEvent theEvent)
	{
		// if the file selected, set it to be label
		if (theEvent.getSource() == openItem)
		{
			// show fileChooser file
			int result = myFileChooser.showOpenDialog(FileChooserPractice.this);
			
			if (result == JFileChooser.APPROVE_OPTION)
			{
				String name = myFileChooser.getSelectedFile().getPath();
				myLabel.setIcon(new ImageIcon(name));
				
				this.pack(); 
				this.setLocationRelativeTo(null);
				
				mySaveAs.setEnabled(true);
			}
			
		}
		else if (theEvent.getSource() == mySaveAs) // this is not complete yet but is visible on the gui.
		{
			int result = myFileChooser.showSaveDialog(FileChooserPractice.this);
			
			if (result == JFileChooser.APPROVE_OPTION)
			{
				 File file = myFileChooser.getCurrentDirectory();
				myLog.append("Saving..." + file.getName() + "\n");
			}
			else 
			{
				myLog.append("Command canceling..." + "\n");
			}
			
			myLog.setCaretPosition(myLog.getDocument().getLength());
		}
		else //if (theEvent.getSource() == existItem)
		{
			System.exit(0);
		}
	}
	

}


