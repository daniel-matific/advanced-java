package mmn13.exercise1;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Circle extends Shape {
	public Circle() {
		x = y = 0;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillOval(0, 0, 100, 100);
	}
}

