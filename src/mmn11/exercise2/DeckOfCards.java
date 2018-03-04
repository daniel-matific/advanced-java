package mmn11.exercise2;

import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards {
	private ArrayList<Card> deck;
	private static final int NUMBER_OF_CARDS = 52, TOP_CARD = 0;
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	public DeckOfCards() {
		String[] faces = {"Ace","Deuce","Three","Four","Five","Six","Seven","Eight","Nine",
							"Ten","Jack","Queen","King"};
		String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
		
		deck = new ArrayList<Card>(NUMBER_OF_CARDS);
		
		for (int count = 0; count < NUMBER_OF_CARDS; count++) {
			deck.add(count, new Card(faces[count % 13], suits[count / 13]));
		}
		
		//shuffle();
	}
	
	public void shuffle() {
		int first = 0, second;
		Card temp;
		for (Card card : deck) {
			second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			
			temp = card;
			deck.set(first, deck.get(second));
			deck.set(second, temp);
			
			first++;
		}
	}
	
	public boolean isDeckEmpty() {
		return deck.isEmpty();
	}
	
	public int getDeckSize() {
		return deck.size();
	}
	
	public Card removeCardFromTop() {
		return deck.remove(TOP_CARD);
	}
	
	public void addCardToBottom(Card card) {
		deck.add(card);
	}
	
	public Card revealTopCard() {
		return deck.get(TOP_CARD);
	}
}
