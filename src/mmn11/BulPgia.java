package mmn11;

import java.util.Random;

public class BulPgia {
	private String numberToGuess;
	private String guessHistory;
	private int numberOfGuesses;
	
	public BulPgia() {
		numberToGuess = "";
		guessHistory = "";
		numberOfGuesses = 0;
		Random randomGenerator = new Random();
		Integer randomNumber;
		while (numberToGuess.length() < 4) {
			randomNumber = randomGenerator.nextInt(10);
			if(isUnique(numberToGuess+randomNumber.toString())) {
				numberToGuess += randomNumber.toString();
			}
		}
	}
	
	public String getNumberToGuess() {
		return numberToGuess;
	}
	
	public int getNumberOfGuesses() {
		return numberOfGuesses;
	}
	
	public boolean guess(String number) {
		
		return true;
	}
	
	private boolean isValid(String number) {
		if(!isFourDigits(number)) {
			System.out.println("The number you guess must be four digits, please re-enter a four digit number.");
			return false;
		}
		if(!isDigitsOnly(number)) {
			System.out.println("The number you guess must contain digits only, please re-enter a digit only number.");
			return false;
		}
		if(!isUnique(number)) {
			System.out.println("The number you guess must contain unique digits, please re-enter a number with unique digits.");
			return false;
		}
		return true;
	}
	
	private boolean isUnique(String number) {
		boolean[] taken = new boolean[10];
		for(int i = 0; i < number.length(); i++) {
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
		for(int i = 0; i < number.length(); i++) {
			if(number.charAt(i) < 48 || number.charAt(i) > 57) {
				return false;
			}
		}
		return true;
	}
}
