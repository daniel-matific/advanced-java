package mmn11.exercise1;

import java.util.Random;

import javax.swing.JOptionPane;

public class BulPgia {
	private String[] numberToGuess;
	private String guessHistory;
	private int numberOfGuesses;
	
	public BulPgia() {
		guessHistory = "";
		numberOfGuesses = 0;
		
		Random randomGenerator = new Random();
		Integer randomNumber;
		String numberBuilder = "";
		while (numberBuilder.length() < 4) {
			randomNumber = randomGenerator.nextInt(10);
			if (isUnique(numberBuilder+randomNumber.toString())) {
				numberBuilder += randomNumber.toString();
			}
		}
		numberToGuess = numberBuilder.split("|");
	}
	
	public boolean guess(String number) {
		if (!isValid(number)) {
			return false;
		}
		numberOfGuesses++; // I assume only valid guesses count
		String[] splitNumber = number.split("|");
		int bul = 0;
		int pgia = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (splitNumber[i].equals(numberToGuess[j])) {
					if (i == j) {
						bul++;
					}
					else {
						pgia++;
					}
					break;
				}
			}
		}
		guessHistory += "Guess: " + number + " >>> " + bul + " bul and " + pgia + " pgia.\n";
		JOptionPane.showMessageDialog(null, guessHistory);
		if (bul == 4) {
			JOptionPane.showMessageDialog(null, ">>> BUL PGIA <<<\nTotal number of guesses until success: " + numberOfGuesses);
			return true;
		}
		return false;
	}
	
	private boolean isValid(String number) {
		if (!isFourDigits(number)) {
			JOptionPane.showMessageDialog(null, "The number you guess must be four digits, please re-enter a four digit number.");
			return false;
		}
		if (!isDigitsOnly(number)) {
			JOptionPane.showMessageDialog(null, "The number you guess must contain digits only, please re-enter a digit only number.");
			return false;
		}
		if (!isUnique(number)) {
			JOptionPane.showMessageDialog(null, "The number you guess can't have repeating digits, please re-enter a number without repetitions.");
			return false;
		}
		return true;
	}
	
	private boolean isUnique(String number) {
		boolean[] taken = new boolean[10];
		for (int i = 0; i < number.length(); i++) {
			int index = Character.getNumericValue(number.charAt(i));
			
			if (taken[index]) {
				return false;
			}
			taken[index] = true;
		}
		return true;
	}
	
	private boolean isFourDigits(String number) {
		return number.length() == 4;
	}
	
	private boolean isDigitsOnly(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) < 48 || number.charAt(i) > 57) {
				return false;
			}
		}
		return true;
	}
}
