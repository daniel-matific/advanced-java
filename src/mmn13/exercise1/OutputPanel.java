package mmn13.exercise1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class OutputPanel extends JPanel {
	private ArrayList<Shape> shapes;
	
	public OutputPanel() {
		super(new FlowLayout(FlowLayout.LEFT));
		setBorder(new LineBorder(Color.black, 2));
		shapes = new ArrayList<Shape>();
	}
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
}