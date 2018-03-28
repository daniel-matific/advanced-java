package mmn13.exercise1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements ActionListener, MouseListener {
	
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
		buttonPanel.getPaint().addMouseListener(this);
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
		    	outputPanel.revalidate();
		    	outputPanel.repaint();
			}
		}
		if(e.getSource() == buttonPanel.getPaint()) {
			Color chosenColor = ((MyColor) buttonPanel.getColorBox().getSelectedItem()).getColor();
			Shape chosenShape =  (Shape) buttonPanel.getShapesBox().getSelectedItem();
			Shape newShape = chosenShape.createShape(chosenColor, buttonPanel.getFilledButton().isSelected());
			outputPanel.getShapes().add(newShape);
	    	outputPanel.add(outputPanel.getShapes().get(outputPanel.getShapes().size()-1));
	    	outputPanel.revalidate();
	    	outputPanel.repaint();
		}
		if(e.getSource() == buttonPanel.getClear()) {
			outputPanel.getShapes().removeAll(outputPanel.getShapes());
			outputPanel.removeAll();
			outputPanel.revalidate();
	    	outputPanel.repaint();
		}
		else if(e.getSource() == buttonPanel.getExit()) {
			System.exit(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == buttonPanel.getPaint()) {
			outputPanel.getShapes().get(outputPanel.getShapes().size()-1);
	    	/*outputPanel.revalidate();
	    	outputPanel.repaint();*/
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
