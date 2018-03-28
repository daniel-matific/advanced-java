package mmn11.exercise2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		DeckOfCards game = new DeckOfCards();
		ArrayList<Card> pile = new ArrayList<Card>();
		final int TOP_CARD = 0;
		String roundDetails;

		// checks if both players still have cards in deck
		while (!game.isPlayer1DeckEmpty() && !game.isPlayer2DeckEmpty()) {
			Card cardOfPlayer1 = game.player1RevealTopCard(), cardOfPlayer2 = game.player2RevealTopCard(); // both players reveal the top of their deck
			roundDetails = "Player 1 shows: " + cardOfPlayer1.toString() + " and Player 2 shows: " + cardOfPlayer2.toString() + "!\n";
			if (cardOfPlayer1.getCardValue() > cardOfPlayer2.getCardValue()) { // player 1 wins the round, all revealed cards and pile(if exists) goes to player 1
				JOptionPane.showMessageDialog(null, roundDetails + "Player 1 wins the round!");
				game.player1AddCardToBottom(game.player1RemoveCardFromTop());
				game.player1AddCardToBottom(game.player2RemoveCardFromTop());
				while (!pile.isEmpty()) {
					game.player1AddCardToBottom(pile.remove(TOP_CARD));
				}
			}
			else if (cardOfPlayer1.getCardValue() < cardOfPlayer2.getCardValue()) { // player 2 wins the round, all revealed cards and pile(if exists) goes to player 2
				JOptionPane.showMessageDialog(null, roundDetails + "Player 2 wins the round!");
				game.player2AddCardToBottom(game.player2RemoveCardFromTop());
				game.player2AddCardToBottom(game.player1RemoveCardFromTop());
				while (!pile.isEmpty()) {
					game.player2AddCardToBottom(pile.remove(TOP_CARD));
				}
			}
			else { // there's a tie, players put 3 cards in the pile
				JOptionPane.showMessageDialog(null, roundDetails + "This is a tie! - adding three extra cards!");
				for (int i = 0; i < 3 && !game.isPlayer1DeckEmpty(); i++) {
					pile.add(game.player1RemoveCardFromTop());
				}
				for (int i = 0; i < 3 && !game.isPlayer2DeckEmpty(); i++) {
					pile.add(game.player2RemoveCardFromTop());
				}
			}
		}

		if (game.isPlayer2DeckEmpty()) {
			if (game.isPlayer1DeckEmpty()) {
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
