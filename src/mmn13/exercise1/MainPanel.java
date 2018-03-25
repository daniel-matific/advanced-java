package mmn13.exercise1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements ActionListener {
	
	private OutputPanel outputPanel;
	private ButtonPanel buttonPanel;
	
	public MainPanel() {
		super(new GridLayout(2, 1));
		outputPanel = new OutputPanel();
		buttonPanel = new ButtonPanel();
		buttonPanel.getShapesBox().addActionListener(this);
		buttonPanel.getColorBox().addActionListener(this);
		buttonPanel.getUndo().addActionListener(this);
		buttonPanel.getClear().addActionListener(this);
		buttonPanel.getExit().addActionListener(this);
		buttonPanel.getPaint().addActionListener(this);
		add(outputPanel);
		add(buttonPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonPanel.getUndo()) {
			if(outputPanel.getShapes().size() > 0) {
				Shape lastShape = outputPanel.getShapes().get(outputPanel.getShapes().size()-1);
				outputPanel.getShapes().remove(lastShape);
		    	outputPanel.remove(lastShape);
		    	outputPanel.repaint();
			}
		}
		if(e.getSource() == buttonPanel.getPaint()) {
			Color chosenColor = ((MyColor) buttonPanel.getColorBox().getSelectedItem()).getColor();
			Shape chosenShape = ((Shapes) buttonPanel.getShapesBox().getSelectedItem()).getShape();
			outputPanel.getShapes().add(chosenShape.createShape(chosenColor, buttonPanel.getFilledButton().isSelected()));
	    	outputPanel.add(outputPanel.getShapes().get(outputPanel.getShapes().size()-1));
	    	outputPanel.revalidate();
		}
		if(e.getSource() == buttonPanel.getClear()) {
			outputPanel.removeAll();
			outputPanel.repaint();
		}
		else if(e.getSource() == buttonPanel.getExit()) {
			System.exit(0);
		}
	}
}
