package mmn11.exercise1;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		BulPgia bulPgia = new BulPgia();
		boolean gameOver = false;
		final int YES = 0;
		while (!gameOver) {
			try {
				gameOver = bulPgia.guess(JOptionPane.showInputDialog("Please enter a four digit number without digit repititions:"));;
			}
			catch (Exception cancelOrX){
				System.exit(0);
			}
			if (gameOver) {
				if (JOptionPane.showConfirmDialog(null,"Do you want to play another round?") == YES) {
					bulPgia = new BulPgia();
					gameOver = false;	
				}
			}
		}
	}

}
