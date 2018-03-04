package mmn11.exercise2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		DeckOfCards player1Deck = new DeckOfCards(), player2Deck = new DeckOfCards();
		ArrayList<Card> pile = new ArrayList<Card>();
		final int TOP_CARD = 0, MIN_DECK_SIZE_FOR_PILE = 3;

		while (!player1Deck.isDeckEmpty() && !player2Deck.isDeckEmpty()) {
			Card cardOfPlayer1 = player1Deck.dealCard(), cardOfPlayer2 = player2Deck.dealCard();
			System.out.println("Player 1 shows: " + cardOfPlayer1.toString() + " and Player 2 shows: " + cardOfPlayer2.toString() + "!");
			if (cardOfPlayer1.getCardValue() > cardOfPlayer2.getCardValue()) {
				System.out.println("Player 1 wins the round!");
				player1Deck.addCardToBottom(player1Deck.removeCardFromTop());
				player1Deck.addCardToBottom(player2Deck.removeCardFromTop());
				while (!pile.isEmpty()) {
					player1Deck.addCardToBottom(pile.remove(TOP_CARD));
				}
			}
			else if (cardOfPlayer1.getCardValue() < cardOfPlayer2.getCardValue()) {
				System.out.println("Player 2 wins the round!");
				player2Deck.addCardToBottom(player2Deck.removeCardFromTop());
				player2Deck.addCardToBottom(player1Deck.removeCardFromTop());
				while (!pile.isEmpty()) {
					player2Deck.addCardToBottom(pile.remove(TOP_CARD));
				}
			}
			else {
				System.out.println("This is a tie! - adding three extra cards!");
				if (player1Deck.getDeckSize() > MIN_DECK_SIZE_FOR_PILE && player2Deck.getDeckSize() > MIN_DECK_SIZE_FOR_PILE) {
					for (int i = 0; i < 3; i++) {
						pile.add(player1Deck.removeCardFromTop());
						pile.add(player2Deck.removeCardFromTop());
					}
				}
				else {
					break;
				}
			}
		}
		
		if (player1Deck.getDeckSize() >= 4 && player2Deck.getDeckSize() < 4) {
			System.out.println("Player 2 is out of cards!");
			System.out.println("Player 1 wins the game!");
		}
		else if (player1Deck.getDeckSize() < 4 && player2Deck.getDeckSize() >= 4) {
			System.out.println("Player 1 is out of cards!");
			System.out.println("Player 2 wins the game!");
		}
		else {
			System.out.println("Game ends in a tie ! - both players out of cards at the same time!");
		}
	}
}
