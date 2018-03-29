package mmn13.exercise1;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OutputPanel extends JPanel {
	private ArrayList<Shape> shapes;
	
	public OutputPanel() {
		super(new FlowLayout(FlowLayout.LEFT));
		shapes = new ArrayList<Shape>();
	}
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
}