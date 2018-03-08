package mmn11.exercise2;

import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards {
	private ArrayList<Card> deck;
	private ArrayList<Card> player1Deck;
	private ArrayList<Card> player2Deck;
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
		
		shuffle();
		
		player1Deck = new ArrayList<Card>(NUMBER_OF_CARDS/2);
		player2Deck = new ArrayList<Card>(NUMBER_OF_CARDS/2);
		
		for (int count = 0; count < NUMBER_OF_CARDS; count++) {
			if (count % 2 == 0) {
				player1Deck.add(deck.remove(TOP_CARD));
			}
			else {
				player2Deck.add(deck.remove(TOP_CARD));
			}
		}
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
	
	public boolean isPlayer1DeckEmpty() {
		return player1Deck.isEmpty();
	}
	
	public boolean isPlayer2DeckEmpty() {
		return player2Deck.isEmpty();
	}
	
	public int getPlayer1DeckSize() {
		return player1Deck.size();
	}
	
	public int getPlayer2DeckSize() {
		return player2Deck.size();
	}
	
	public Card player1RemoveCardFromTop() {
		return player1Deck.remove(TOP_CARD);
	}
	
	public Card player2RemoveCardFromTop() {
		return player2Deck.remove(TOP_CARD);
	}
	
	public void player1AddCardToBottom(Card card) {
		player1Deck.add(card);
	}
	
	public void player2AddCardToBottom(Card card) {
		player2Deck.add(card);
	}
	
	public Card player1RevealTopCard() {
		return player1Deck.get(TOP_CARD);
	}
	
	public Card player2RevealTopCard() {
		return player2Deck.get(TOP_CARD);
	}
}
