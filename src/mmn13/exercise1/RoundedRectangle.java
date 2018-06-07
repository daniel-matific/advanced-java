package mmn13.exercise1;

import java.awt.*;

@SuppressWarnings("serial")
public class RoundedRectangle extends Shape {

	// Draws the rounded rectangle according to the filled state
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setColor(color);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(isFilled) {
			g2.fillRoundRect(0, 0, width, height, 10, 10);
		}
		else {
			g2.drawRoundRect(0, 0, width-1, height-1, 10, 10);
		}
		x = getX();
		y = getY();
	}

	// Enables the creation of a rounded rectangle as Shape
	@Override
	public Shape createShape(Color color, boolean isFilled) {
		RoundedRectangle roundedRectangle = new RoundedRectangle();
		roundedRectangle.x = roundedRectangle.y = roundedRectangle.width = roundedRectangle.height = 0;
		roundedRectangle.color = color;
		roundedRectangle.isFilled = isFilled;
		return roundedRectangle;
	}
}
