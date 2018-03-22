package shaytavorexample;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class LayoutPanel extends JPanel
{
	private JButton[] buttons;
	public LayoutPanel()
	{
		
		// Border Layout:
		/*buttons = new JButton[5];
		for(int i = 0 ; i < buttons.length; i++)
			buttons[i] = new JButton("No." + i);
		setLayout(new BorderLayout());
		add(buttons[0], BorderLayout.NORTH);
		add(buttons[1], BorderLayout.SOUTH);
		add(buttons[2], BorderLayout.WEST);
		add(buttons[3], BorderLayout.EAST);
		add(buttons[4], BorderLayout.CENTER);*/
		
		
		// Grid Layout:
		buttons = new JButton[5];
		for(int i = 0 ; i < buttons.length; i++)
			buttons[i] = new JButton("No." + i);
		setLayout(new GridLayout(2, 3));
		add(buttons[0]);
		add(buttons[1]);
		add(buttons[2]);
		add(buttons[3]);
		add(buttons[4]);
		
	}
	
}