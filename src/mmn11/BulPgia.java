package mmn11;

import java.util.Random;

public class BulPgia {
	private String numberToGuess;
	
	public BulPgia() {
		numberToGuess = "";
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
	
	public static boolean isUnique(String number) {
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
}
