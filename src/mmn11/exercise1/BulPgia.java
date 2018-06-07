package mmn11.exercise1;

import javax.swing.*;
import java.util.Random;

public class BulPgia {
	private String[] numberToGuess;
	private String guessHistory;
	private int numberOfGuesses;
	
	public BulPgia() {
		numberToGuess = generateRandomFourDigitNumberWithUniqueDigits();
		guessHistory = "";
		numberOfGuesses = 0;
	}
	
	// generates a random four digit numbers without digit repetitions
	private String[] generateRandomFourDigitNumberWithUniqueDigits() {
		Random randomGenerator = new Random();
		Integer randomNumber;
		String numberBuilder = "";
		while (numberBuilder.length() < 4) {
			randomNumber = randomGenerator.nextInt(10);
			if (isUnique(numberBuilder+randomNumber.toString())) {
				numberBuilder += randomNumber.toString();
			}
		}
		return numberBuilder.split("|");
	}
	
	// verifies the input guess is valid and then processes it and sends the result as output
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
	
	// runs validation on a given number, first checking length, then checking digits only, then checking for no repetitions
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
	
	// checks if the input length is 4
	private boolean isFourDigits(String number) {
		return number.length() == 4;
	}
	
	// checks if the input is digits only
	private boolean isDigitsOnly(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (!Character.isDigit(number.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	// checks if the input has no repetitions
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
}
