package mmn13.exercise1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	
	private OutputPanel outputPanel;
	private ButtonPanel buttonPanel;
	
	public MainPanel() {
		super(new GridLayout(2, 1));
		outputPanel = new OutputPanel();
		buttonPanel = new ButtonPanel();
		add(outputPanel);
		add(buttonPanel);
	}
	
	private class ButtonPanel extends JPanel implements ActionListener {
		
		private JComboBox<String> shapesBox, colorBox;
		private JRadioButton filled, empty;
		private JButton undo, clear, exit, paint;
		
		public ButtonPanel() {
			super(new GridLayout(4, 2));
			
			String[] shapes = { "Choose a Shape...", "Circle", "Line", "Rectangle", "Rounded Rectangle"};
			shapesBox = new JComboBox<String>(shapes);
			shapesBox.setSelectedIndex(0);
			shapesBox.addActionListener(this);
			
			String[] colors = { "Choose a Color...", "Red", "Green", "Blue"};
			colorBox = new JComboBox<String>(colors);
			colorBox.setSelectedIndex(0);
			colorBox.addActionListener(this);
			
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
			undo.addActionListener(this);
			clear.addActionListener(this);
			exit.addActionListener(this);
			paint.addActionListener(this);

	        add(filled);
	        add(empty);
			add(shapesBox);
			add(colorBox);
			add(undo);
			add(paint);
			add(clear);
			add(exit);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == paint) {
				//outputPanel.shapes.add(new Circle());
				//Circle circle = (Circle) outputPanel.shapes.get(outputPanel.shapes.size()-1);
		    	//Circle circle = new Circle();
				//outputPanel.repaint();
		    	outputPanel.add(new Circle());
			}
			if(e.getSource() == clear) {
				//outputPanel.removeAll();
				outputPanel.repaint();
			}
			else if(e.getSource() == exit) {
				System.exit(0);
			}
		}
	}
	
	private class OutputPanel extends JPanel {
		private ArrayList<Shape> shapes;
		
		public OutputPanel() {
			setBorder(new LineBorder(Color.black, 2));
			shapes = new ArrayList<Shape>();
		}
		
	    public void paintComponent(Graphics g)
	    {
	    	super.paintComponents(g);
	    	//Shape shape = shapes.get(shapes.size());
	    	//shape.repaint();
	    }
	}
}
