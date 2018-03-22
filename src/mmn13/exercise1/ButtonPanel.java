package mmn13.exercise1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel implements ActionListener {
	
	public ButtonPanel() {
		super(new GridLayout(3, 2));
		//setSize(500, 250);
		
		String[] colors = { "Choose a Color...", "Red", "Green", "Blue"};
		JComboBox<String> colorBox = new JComboBox<String>(colors);
		colorBox.setSelectedIndex(0);
		colorBox.addActionListener(this);
		
		String[] isFilled = { "Filled", "Empty"};
		JComboBox<String> isFilledBox = new JComboBox<String>(isFilled);
		isFilledBox.setSelectedIndex(0);
		isFilledBox.addActionListener(this);
		
		JButton undo = new JButton("Undo"), clear = new JButton("Clear"), exit = new JButton("Exit"), paint = new JButton("Paint");
		undo.addActionListener(this);
		clear.addActionListener(this);
		exit.addActionListener(this);
		paint.addActionListener(this);

		add(colorBox);
		add(isFilledBox);
		add(undo);
		add(clear);
		add(exit);
		add(paint);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
