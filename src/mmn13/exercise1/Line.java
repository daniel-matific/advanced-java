package mmn13.exercise1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

@SuppressWarnings("serial")
public class Line extends Shape {
	
	public Line() {
		timer.start();
	}

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
		size = getSize();
	}
	
	@Override
	public Shape createShape(Color color, boolean isFilled) {
		Line line = new Line();
		line.x = line.y = line.width = line.height = 0;
		line.setPreferredSize(new Dimension(30,30));
		line.color = color;
		return line;
	}
}