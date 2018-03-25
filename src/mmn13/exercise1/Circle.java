package mmn13.exercise1;

import java.awt.Graphics;

@SuppressWarnings("serial")
public class Circle extends Shape {
	
	public Circle() {}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		if(isFilled) {
			g.fillOval(0, 0, width, height);
		}
		else {
			g.drawOval(0, 0, width, height);
		}
		x = getX();
		y = getY();
		size = getSize();
	}
}