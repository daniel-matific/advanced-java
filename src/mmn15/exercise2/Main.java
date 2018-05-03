package mmn15.exercise2;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		Game game = null;
		String size;
		size = JOptionPane.showInputDialog("Please insert the size of the matrix: (Enter an integer only)");
		try {
		game = new Game(Integer.parseInt(size));
		}
		catch(NumberFormatException e) {
        	JOptionPane.showMessageDialog(null, "The inserted size is not an integer!");
        	System.exit(0);
		}
		
    	while(true) {
    		game.getGameOfLife().nextGeneration();
    		try {
				Thread.sleep(200);
    		} catch (InterruptedException e) {}
    	}
	}

}
