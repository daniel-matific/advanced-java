package mmn11.exercise2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		DeckOfCards player1Deck = new DeckOfCards(), player2Deck = new DeckOfCards();
		ArrayList<Card> pile = new ArrayList<Card>();
		final int TOP_CARD = 0;

		while (!player1Deck.isDeckEmpty() && !player2Deck.isDeckEmpty()) {
			Card cardOfPlayer1 = player1Deck.revealTopCard(), cardOfPlayer2 = player2Deck.revealTopCard();
			JOptionPane.showMessageDialog(null, "Player 1 shows: " + cardOfPlayer1.toString() + " and Player 2 shows: " + cardOfPlayer2.toString() + "!");
			if (cardOfPlayer1.getCardValue() > cardOfPlayer2.getCardValue()) {
				JOptionPane.showMessageDialog(null, "Player 1 wins the round!");
				player1Deck.addCardToBottom(player1Deck.removeCardFromTop());
				player1Deck.addCardToBottom(player2Deck.removeCardFromTop());
				while (!pile.isEmpty()) {
					player1Deck.addCardToBottom(pile.remove(TOP_CARD));
				}
			}
			else if (cardOfPlayer1.getCardValue() < cardOfPlayer2.getCardValue()) {
				JOptionPane.showMessageDialog(null, "Player 2 wins the round!");
				player2Deck.addCardToBottom(player2Deck.removeCardFromTop());
				player2Deck.addCardToBottom(player1Deck.removeCardFromTop());
				while (!pile.isEmpty()) {
					player2Deck.addCardToBottom(pile.remove(TOP_CARD));
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "This is a tie! - adding three extra cards!");
				for (int i = 0; i < 3 && !player1Deck.isDeckEmpty(); i++) {
					pile.add(player1Deck.removeCardFromTop());
				}
				for (int i = 0; i < 3 && !player2Deck.isDeckEmpty(); i++) {
					pile.add(player2Deck.removeCardFromTop());
				}
			}
		}

		if (player2Deck.isDeckEmpty()) {
			if (player1Deck.isDeckEmpty()) {
				JOptionPane.showMessageDialog(null, "Game ends in a tie ! - both players out of cards at the same time!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Player 2 is out of cards!");
				JOptionPane.showMessageDialog(null, "Player 1 wins the game!");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Player 1 is out of cards!");
			JOptionPane.showMessageDialog(null, "Player 2 wins the game!");
		}
	}
}
