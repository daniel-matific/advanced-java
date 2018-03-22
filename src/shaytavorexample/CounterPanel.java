package shaytavorexample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CounterPanel extends JPanel{
    private int counter;
    private JLabel lblCount;
    private JButton cmdPress;
	
    public CounterPanel()
    {
	counter = 0;
	lblCount = new JLabel("Pushes: " + counter);
	cmdPress = new JButton("Press");
	cmdPress.addActionListener(new ButtonListener());
		
	add(lblCount);
	add(cmdPress);
    }
	
    private class ButtonListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e)
	{
		counter++;
		lblCount.setText("Pushes: " + counter);
        }
    }    
}
