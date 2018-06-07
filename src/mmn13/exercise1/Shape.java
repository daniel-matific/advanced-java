package mmn13.exercise1;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public abstract class Shape extends JPanel {

	protected int x, y, width, height;
	protected Dimension size;
	protected Color color;
	protected boolean isFilled;

	// Enables the creation of children as Shape
	public abstract Shape createShape(Color color, boolean isFilled);

	// Returns class(shape) name
	public String toString() {
		return getClass().getSimpleName();
	}

	// Animates the drawing of the shape
    protected void animateDraw() throws InterruptedException {
	    width += 1;
	    height += 1;
	    setSize(new Dimension(width, height));
	    setPreferredSize(new Dimension(width, height));
	    Thread.sleep(20);
	    revalidate();
	    repaint();
    }

    // Sets the size
    public void updateSize(Dimension size) {
		this.size = size;
    }

}
