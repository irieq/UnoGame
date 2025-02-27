package uno;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bot player in the UNO game.
 * Non-player characters also known as bots are automated players that make decisions based on game rules.
 * This class extends {@link Player} Class. 
 */
public class Bot extends Player {
	
	 /**
     * Constructor for Bot class with the name.
     *
     * @param name The name of the bot player.
     */
	public Bot(String name) {
		super(name);
	}
	
	 /**
     * Makes the bot make a decision.
     * If the bot has a playable card in its hand, it plays the first playable card.
     * If it doesn't have a playable card, it draws a card from the deck.
     *
     * @param game The UNO game instance.
     */

	public void playCard(UnoGame game) {
		boolean playedcard = false;
		Card card2 = null;
		for(Card card : hand) {
			if (game.isPlayable(card)) {
				card2 =card;
				game.addToDiscardPile(card2);
				playedcard = true;
				break;
				
			}
				
		}
		hand.remove(card2);
		if (!playedcard){
			game.drawCard(this);
			
		}
		
	}

}
