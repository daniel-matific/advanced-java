package mmn13.exercise1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class OutputPanel extends JPanel {
	private ArrayList<Shape> shapes;
	
	public OutputPanel() {
		super(new FlowLayout(FlowLayout.LEFT));
		shapes = new ArrayList<>();
	}

	// Returns the list of shapes drawn
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
}