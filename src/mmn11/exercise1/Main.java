package mmn11.exercise1;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		BulPgia bulPgia = new BulPgia();
		boolean gameOver = false;
		while (!gameOver) {
			gameOver = bulPgia.guess(JOptionPane.showInputDialog("Please enter a four digit number without digit repititions:"));;
			if (gameOver) {
				String answer = JOptionPane.showInputDialog("Do you want to play another round? (y/n)");
				if (answer.equals("y")) {
					bulPgia = new BulPgia();
					gameOver = false;	
				}
			}
		}
	}

}
