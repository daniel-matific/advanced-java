package mmn11.exercise2;

public class Card {
	private final String face;
	private final String suit;

	public Card(String cardFace, String cardSuit) {
		face = cardFace;
		suit = cardSuit;
	}
	
	public int getCardValue() {
		switch (face) {
		case "Ace": return 14;
		case "Deuce": return 2;
		case "Three": return 3;
		case "Four": return 4;
		case "Five": return 5;
		case "Six": return 6;
		case "Seven": return 7;
		case "Eight": return 8;
		case "Nine": return 9;
		case "Ten": return 10;
		case "Jack": return 11;
		case "Queen": return 12;
		case "King": return 13;
		default: return -1;
		}
	}
	
	public String toString() {
		return face + " of " + suit;
	}
}
