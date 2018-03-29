package mmn13.exercise1;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Shape extends JPanel {
	protected int x, y, width, height;
	protected Dimension size;
	protected Color color;
	protected boolean isFilled;
	
	public abstract Shape createShape(Color color, boolean isFilled);
	
	public String toString() {
		return getClass().getSimpleName();
	}
	
    protected void animateDraw() throws InterruptedException {
	    width += 1;
	    height += 1;
	    setSize(new Dimension(width, height));
	    setPreferredSize(new Dimension(width, height));
	    Thread.sleep(20);
	    revalidate();
	    repaint();
    }
    
    public void updateSize(Dimension size) {
    	this.size = size;
    }
    
    public void printStuff() {
    	System.out.println(x + "," + y + ";" + size.toString());
    }
}
