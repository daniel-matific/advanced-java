package shaytavorexample;

import javax.swing.*;

@SuppressWarnings("serial")
public class HelloPanel extends JPanel
{
	private JLabel lblHello;
	private JButton cmdOK, cmdCancel;
	public HelloPanel()
	{
		lblHello = new JLabel("Hello");
		cmdOK = new JButton("OK");
		cmdCancel = new JButton("Cancel");
		add(lblHello);
		add(cmdOK);
		add(cmdCancel);
	}

}