package uno;

import java.util.ArrayList;


import java.util.List;


/**
 * Represents a player(human and bot mixed) in the UNO game.
 */
public class Player {
	private String name;
	protected ArrayList<Card> hand;
	
	/**
     * Constructor for Player class with the specified name.
     *
     * @param name The name of the player.
     */
	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<Card>();
	}
	
	/**
     * Plays a card from the player's hand.
     *
     * @param card The card to be played.
     */
	public void playCard(Card card) {
		hand.remove(card);

	}
	
	 /**
     * Draws a card and adds it to the player's hand.
     *
     * @param card The card to be drawn.
     */
	public void drawCard(Card card) {
		hand.add(card);
		
	}
	
	 /**
     * Checks if the player has UNO.
     *
     * @return True if the player has one card left, false otherwise.
     */
	public boolean unoble() {
		if (hand.size() == 1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	 /**
     * It gets the name of the player.
     *
     * @return The name of the player.
     */
	public String getName() {
		return name;
	}
	
	 /**
     * It gets the hand of the player.
     *
     * @return The ArrayList containing the cards in the player's hand.
     */
	public ArrayList<Card> getHand() {
		return hand;
	}

	
}
