package mmn13.exercise1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

@SuppressWarnings("serial")
public class Line extends Shape {

	// Draws a line
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setColor(color);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.drawLine(0, 0, width, height);
		x = getX();
		y = getY();
	}

	// Enables the creation of a line as Shape
	@Override
	public Shape createShape(Color color, boolean isFilled) {
		Line line = new Line();
		line.x = line.y = line.width = line.height = 0;
		line.color = color;
		return line;
	}
}