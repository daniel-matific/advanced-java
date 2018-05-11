package mmn13.exercise1;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
	
	private JComboBox<Shape> shapesBox;
	private JComboBox<MyColor> colorBox;
	private JRadioButton filled, empty;
	private JButton undo, clear, exit, paint;
	
	public ButtonPanel() {
		super(new GridLayout(4, 2));
		
		shapesBox = new JComboBox<Shape>();
		shapesBox.addItem(new Circle());
		shapesBox.addItem(new Line());
		shapesBox.addItem(new Rectangle());
		shapesBox.addItem(new RoundedRectangle());
		shapesBox.setSelectedIndex(0);
		
		colorBox = new JComboBox<MyColor>();
		colorBox.addItem(MyColor.Black);
		colorBox.addItem(MyColor.Blue);
		colorBox.addItem(MyColor.Cyan);
		colorBox.addItem(MyColor.DarkGray);
		colorBox.addItem(MyColor.Gray);
		colorBox.addItem(MyColor.Green);
		colorBox.addItem(MyColor.LightGray);
		colorBox.addItem(MyColor.Magenta);
		colorBox.addItem(MyColor.Orange);
		colorBox.addItem(MyColor.Pink);
		colorBox.addItem(MyColor.Red);
		colorBox.addItem(MyColor.White);
		colorBox.addItem(MyColor.Yellow);
		colorBox.setSelectedIndex(0);
		
        filled = new JRadioButton("Filled");
        empty = new JRadioButton("Empty");
        filled.setSelected(true);
 
        ButtonGroup isFilled = new ButtonGroup();
        isFilled.add(filled);
        isFilled.add(empty);
		
		undo = new JButton("Undo");
		clear = new JButton("Clear");
		exit = new JButton("Exit");
		paint = new JButton("Paint");

        add(filled);
        add(empty);
		add(shapesBox);
		add(colorBox);
		add(undo);
		add(paint);
		add(clear);
		add(exit);
	}

	// Returns the menu of shapes
	public JComboBox<Shape> getShapesBox() {
		return shapesBox;
	}

	// Returns the menu of colors
	public JComboBox<MyColor> getColorBox() {
		return colorBox;
	}

	// Returns the filled button
	public JRadioButton getFilledButton() {
		return filled;
	}

	// Returns the undo button
	public JButton getUndo() {
		return undo;
	}

	// Returns the clear button
	public JButton getClear() {
		return clear;
	}

	// Returns the exit button
	public JButton getExit() {
		return exit;
	}

	// Returns the paint button
	public JButton getPaint() {
		return paint;
	}
}
