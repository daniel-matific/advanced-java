package mmn15.exercise2;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;

@SuppressWarnings("serial")
public class GameOfLife extends JPanel {
	
	protected Zone[][] matrix;
	private int size;
    private CountDownLatch middleSignal;
    private CountDownLatch doneSignal;
	
	// creates matrix of Zones in the supplied size
    public GameOfLife(int size) {

        this.size = size;
        
        matrix = new Zone[size][size];
        for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		matrix[i][j] = new Zone();
        	}
        }
        
        visualizeMatrix(matrix, size);
    }
    
    // adds the matrix of Zones to the JFrame
    public void visualizeMatrix(Zone[][] matrix, int size) {
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(size, size));
        for (int i = 0; i < size; i++) {
        	for (int j = 0; j < size; j++) {
        		gridPanel.add(matrix[i][j]);
        	}
        }
        add(gridPanel);
    }
    
    // calls a function to compute the next state of each Zone and then updates all Zones
    public void nextGeneration() {
        middleSignal = new CountDownLatch(size*size);
        doneSignal = new CountDownLatch(size*size);
        for (int i = 0; i < matrix[0].length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		new Thread(new GenerateNextState(i, j, this, middleSignal, doneSignal)).start();
        	}
        }
        try {
            doneSignal.await();
        }
        catch (InterruptedException e) {}
    }

}
