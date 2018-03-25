package mmn13.exercise1;

import java.awt.Graphics;

@SuppressWarnings("serial")
public class Line extends Shape {
	
	public Line() {}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.drawLine(0, 0, width, height);
		x = getX();
		y = getY();
		size = getSize();
	}
}