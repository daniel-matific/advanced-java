package mmn12.exercise2;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameOfLife {
	
	private Zone[][] matrix;
	private JFrame window;
	private MyPanel square;
	private final boolean LIFE = true;
	private final boolean DEATH = false;
	
	public GameOfLife(int size) {
		matrix = new Zone[size][size];
		
		for (int i = 0; i < size-1; i++) {
			for (int j = 0; j < size-1; j++) {
				matrix[i][j] = new Zone();
			}
		}
		
		window = new JFrame("Game of Life");
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		window.setVisible(true);
		square = new MyPanel();
		window.add(square);
		
		square.buildMatrix(matrix);
	}
	
	/*public void buildMatrix() {
		for (int i = 0; i < matrix[i].length-1; i++) {
			for (int j = 0; j < matrix[i].length-1; j++) {
				if (matrix[i][j].getCurrentState() == LIFE) {
					square.paintComponent().fillRect(j*10, i*10, 10, 10);
				}
			}
		}
		square.paintComponents
	}*/
}
