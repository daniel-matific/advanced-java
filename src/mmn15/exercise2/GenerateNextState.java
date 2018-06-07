package mmn15.exercise2;

import java.util.concurrent.CountDownLatch;

public class GenerateNextState implements Runnable {

private GameOfLife gameOfLife;
private int row, column;
private final boolean LIFE = true;
private final boolean DEATH = false;
private CountDownLatch middleSignal;
private CountDownLatch doneSignal;

	// constructs the runnable next state generator
	public GenerateNextState(int row, int column, GameOfLife gameOfLife, CountDownLatch middleSignal, CountDownLatch doneSignal) {
		this.row = row;
		this.column = column;
		this.gameOfLife = gameOfLife;
		this.middleSignal = middleSignal;
		this.doneSignal = doneSignal;
	}

	// all threads of panels generate next state and then all of them update the panels
	@Override
	public void run() {

		synchronized(gameOfLife) {
			generateNextState(row, column);
			middleSignal.countDown();
		}

		try {
			middleSignal.await();
		}
		catch (InterruptedException e) {}

		synchronized(gameOfLife) {
			gameOfLife.matrix[row][column].setCurrentState();
			gameOfLife.matrix[row][column].updateZone();
			doneSignal.countDown();
		}

	}
	
    
    // computes the next state for a given Zone position
    private void generateNextState(int row, int column) {
    	int livingNeighbours = 0;
    	if (row > 0 && column > 0 && gameOfLife.matrix[row-1][column-1].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (row > 0 && gameOfLife.matrix[row-1][column].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (row > 0 && column < gameOfLife.matrix[column].length-1 && gameOfLife.matrix[row-1][column+1].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (column > 0 && gameOfLife.matrix[row][column-1].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (column < gameOfLife.matrix[column].length-1 && gameOfLife.matrix[row][column+1].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (row < gameOfLife.matrix[row].length-1 && column > 0 && gameOfLife.matrix[row+1][column-1].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (row < gameOfLife.matrix[row].length-1 && gameOfLife.matrix[row+1][column].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	if (row < gameOfLife.matrix[row].length-1 && column < gameOfLife.matrix[column].length-1 && gameOfLife.matrix[row+1][column+1].getCurrentState() == LIFE) {
    		livingNeighbours++;
    	}
    	
    	if (gameOfLife.matrix[row][column].getCurrentState() == DEATH && livingNeighbours == 3) {
    		gameOfLife.matrix[row][column].setNextState(LIFE);
    	}
    	
    	if (gameOfLife.matrix[row][column].getCurrentState() == LIFE && (livingNeighbours <= 1 || livingNeighbours >= 4)) {
    		gameOfLife.matrix[row][column].setNextState(DEATH);
    	}
    }
}
