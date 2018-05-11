package mmn13.exercise1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

@SuppressWarnings("serial")
public class Rectangle extends Shape {

	// Draws the rectangle according to the filled state
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setColor(color);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		if(isFilled) {
			g2.fillRect(0, 0, width, height);
		}
		else {
			g2.drawRect(0, 0, width-1, height-1);
		}
		x = getX();
		y = getY();
	}

	// Enables the creation of a rectangle as Shape
	@Override
	public Shape createShape(Color color, boolean isFilled) {
		Rectangle rectangle = new Rectangle();
		rectangle.x = rectangle.y = rectangle.width = rectangle.height = 0;
		rectangle.color = color;
		rectangle.isFilled = isFilled;
		return rectangle;
	}
}
