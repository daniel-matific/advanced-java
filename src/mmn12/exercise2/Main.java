package mmn12.exercise2;

import javax.swing.*;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		GameOfLife gameOfLife = new GameOfLife(10);
		final int YES = 0;
		
    	while(JOptionPane.showConfirmDialog(null, "Do you want to move to the next generation?") == YES) {
    		gameOfLife.nextGeneration();
    	}
    	System.exit(0);
	}

}
