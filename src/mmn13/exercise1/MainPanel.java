package mmn13.exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements ActionListener, MouseListener {
	
	private OutputPanel outputPanel;
	private JScrollPane scrollable;
	private ButtonPanel buttonPanel;
	volatile private boolean isRunning = false;
	volatile private boolean mouseDown = false;
	
	public MainPanel() {
		super(new GridLayout(2, 1));
		outputPanel = new OutputPanel();
		scrollable = new JScrollPane(outputPanel);
		buttonPanel = new ButtonPanel();
		buttonPanel.getShapesBox().addActionListener(this);
		buttonPanel.getColorBox().addActionListener(this);
		buttonPanel.getUndo().addActionListener(this);
		buttonPanel.getClear().addActionListener(this);
		buttonPanel.getExit().addActionListener(this);
		buttonPanel.getPaint().addActionListener(this);
		buttonPanel.getPaint().addMouseListener(this);
		add(scrollable);
		add(buttonPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonPanel.getUndo()) { // Remove last shape if exists and repaint
			if(outputPanel.getShapes().size() > 0) {
				Shape lastShape = outputPanel.getShapes().get(outputPanel.getShapes().size()-1);
				outputPanel.getShapes().remove(lastShape);
		    	outputPanel.remove(lastShape);
		    	outputPanel.revalidate();
		    	outputPanel.repaint();
			}
		}
		if(e.getSource() == buttonPanel.getClear()) { // Remove all shapes and repaint
			outputPanel.getShapes().removeAll(outputPanel.getShapes());
			outputPanel.removeAll();
			outputPanel.revalidate();
	    	outputPanel.repaint();
		}
		else if(e.getSource() == buttonPanel.getExit()) { // Exit program
			System.exit(0);
		}
	}

	// On clicking and dragging of the paint button, according to the shape and color choices, shape is animated
	public void mousePressed(MouseEvent e) {
	    if (e.getSource() == buttonPanel.getPaint()) {
			Color chosenColor = ((MyColor) buttonPanel.getColorBox().getSelectedItem()).getColor();
			Shape chosenShape =  (Shape) buttonPanel.getShapesBox().getSelectedItem();
			Shape newShape = chosenShape.createShape(chosenColor, buttonPanel.getFilledButton().isSelected());
			outputPanel.getShapes().add(newShape);
	    	outputPanel.add(outputPanel.getShapes().get(outputPanel.getShapes().size()-1));
	    	outputPanel.revalidate();
	    	outputPanel.repaint();
	        mouseDown = true;
	        startDraw();
	    }
	}

	// On releasing the mouse click of the paint button the animation stops
	public void mouseReleased(MouseEvent e) {
	    if (e.getSource() == buttonPanel.getPaint()) {
	        mouseDown = false;
	        outputPanel.getShapes().get(outputPanel.getShapes().size()-1).updateSize(outputPanel.getShapes().get(outputPanel.getShapes().size()-1).getSize());
	    }
	}

	// checkAndMark dictates the animation state
	private synchronized boolean checkAndMark() {
	    if (isRunning) {
	    	return false;
	    }
	    isRunning = true;
	    return true;
	}

	// startDraw animates the shape draw as long as paint button is clicked and dragged
	private void startDraw() {
	    if (checkAndMark()) {
	        new Thread() {
	            public void run() {
	                do {
	                	try {
							outputPanel.getShapes().get(outputPanel.getShapes().size()-1).animateDraw();
						} catch (InterruptedException e) {}
	                } while (mouseDown);
	                isRunning = false;
	            }
	        }.start();
	    }
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
