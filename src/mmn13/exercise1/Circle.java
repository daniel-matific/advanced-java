package mmn13.exercise1;

import java.awt.*;

@SuppressWarnings("serial")
public class Circle extends Shape {

	// Draws the circle according to the filled state
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setColor(color);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		if(isFilled) {
			g2.fillOval(0, 0, width, height);
		}
		else {
			g2.drawOval(0, 0, width-1, height-1);
		}
		x = getX();
		y = getY();
	}

	// Enables the creation of a circle as Shape
	@Override
	public Shape createShape(Color color, boolean isFilled) {
		Circle circle = new Circle();
		circle.x = circle.y = circle.width = circle.height = 0;
		circle.color = color;
		circle.isFilled = isFilled;
		return circle;
	}
}