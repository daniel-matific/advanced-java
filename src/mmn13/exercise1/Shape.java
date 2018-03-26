package mmn13.exercise1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public abstract class Shape extends JPanel implements ActionListener {
	protected int x, y, width, height;
	protected Dimension size;
	protected Color color;
	protected boolean isFilled;
	protected final Timer timer = new Timer(50, this);;
	
	public abstract Shape createShape(Color color, boolean isFilled);
	
	public String toString() {
		return getClass().getSimpleName();
	}
	
    protected void animateDraw() {
        if (width < getPreferredSize().getWidth()-1) {
        	width += 1;
            height += 1;
        }
        if (height < getPreferredSize().getHeight()-1) {
        	width += 1;
            height += 1;
        }
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		animateDraw();
		repaint();
	}
}
