package mmn11.exercise1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BulPgia bulPgia = new BulPgia();
		boolean gameOver = false;
		Scanner scanner = new Scanner(System.in);
		while (!gameOver) {
			System.out.println("Please enter a four digit number without digit repititions:");
			gameOver = bulPgia.guess(scanner.nextLine());
			if (gameOver) {
				System.out.println("Do you want to play another round? (y/n)");
				String answer = scanner.nextLine();
				if(answer.equals("y")) {
					bulPgia = new BulPgia();
					gameOver = false;	
				}
			}
		}
		scanner.close();
	}

}
