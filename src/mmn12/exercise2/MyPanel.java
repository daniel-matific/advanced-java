package mmn12.exercise2;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {
	
	private Graphics g;
	private final boolean LIFE = true;
	private final boolean DEATH = false;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public void buildMatrix(Zone[][] matrix) {
		paintComponent(g);
		for (int i = 0; i < matrix[i].length-1; i++) {
			for (int j = 0; j < matrix[i].length-1; j++) {
				if (matrix[i][j].getCurrentState() == LIFE) {
					g.fillRect(j*10, i*10, 10, 10);
				}
			}
		}
		paintComponent(g);
	}
}
