import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.TableModel;


public class MainFrame extends JFrame {

	JPanel panelFrame;
	ArrayList <Person> duhast = new ArrayList<Person>();
	MainFrame()
	{
		setTitle("Person crud");
		setSize(980, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		panelFrame = new MainPanel();
		setContentPane(panelFrame);
		
	}
	
	
}
