package mmn12.exercise2;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameOfLife extends JFrame {
	
	private Zone[][] matrix;
	private final boolean LIFE = true;
	private final boolean DEATH = false;
	
    public GameOfLife(int size) {
        super("Game of Life");
        
        matrix = new Zone[size][size];
        for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		matrix[i][j] = new Zone();
        	}
        }
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        visualizeMatrix(getContentPane(), matrix);
        pack();
        setVisible(true);
    }
    
    public void visualizeMatrix(final Container pane, Zone[][] matrix) {
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(10,10));
        for (int i = 0; i < 10; i++) {
        	for (int j = 0; j < 10; j++) {
        		gridPanel.add(matrix[i][j]);
        	}
        }
        pane.add(gridPanel);
    }
    
    public void nextGeneration() {
        for (int i = 0; i < matrix[0].length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		generateNextState(i, j);
        	}
        }
        for (int i = 0; i < matrix[0].length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		matrix[i][j].setCurrentState();
        		matrix[i][j].updateZone();
        	}
        }
    }
    
    public void generateNextState(int row, int column) {
    	int livingNeighbours = 0;
    	if (row > 0 && column > 0 && matrix[row-1][column-1].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (row > 0 && matrix[row-1][column].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (row > 0 && column < matrix[column].length-1 && matrix[row-1][column+1].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (column > 0 && matrix[row][column-1].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (column < matrix[column].length-1 && matrix[row][column+1].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (row < matrix[row].length-1 && column > 0 && matrix[row+1][column-1].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (row < matrix[row].length-1 && matrix[row+1][column].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (row < matrix[row].length-1 && column < matrix[column].length-1 && matrix[row+1][column+1].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	
    	if (matrix[row][column].getCurrentState() == DEATH && livingNeighbours == 3) {
    		matrix[row][column].setNextState(LIFE);
    	}
    	
    	if (matrix[row][column].getCurrentState() == LIFE && (livingNeighbours <= 1 || livingNeighbours >= 4)) {
    		matrix[row][column].setNextState(DEATH);
    	}
    }
}
