package mmn15.exercise2;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		GameOfLife gameOfLife = null;
		String size;
		size = JOptionPane.showInputDialog("Please insert the size of the matrix: (Enter an integer only)");
		try {
		gameOfLife = new GameOfLife(Integer.parseInt(size));
		}
		catch(NumberFormatException e) {
        	JOptionPane.showMessageDialog(null, "The inserted size is not an integer!");
        	System.exit(0);
		}
		
    	while(true) {
    		gameOfLife.nextGeneration();
    		Thread.sleep(200);
    	}
	}

}
