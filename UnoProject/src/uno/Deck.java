package uno;


import java.util.ArrayList;
import java.util.Collections;

import uno.NumberCard.Number;
import uno.WildCard.WildType;
import uno.ActionCard.EAction;


/**
 * It represents the deck of cards which has 108 cards used in the UNO game.
 * It contains a mixture of NumberCards, ActionCards, and WildCards.
 */
public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	/**
     * Constructor for a Deck Class and initializes it by creating the deck 
     * and shuffling all the cards in the deck.
     */
	public Deck() {
		deckMaker();
	}
	
	/**
     * Creates all the cards in the deck by iterating through colours, numbers, and actions.
     * Adds NumberCards for numbers 0 to 9 in each color, ActionCards for skip, reverse, and +2 actions in each color.
     * Adds two copies of each card, except for the NumberCard with number 0 and adds every wild types for 4 times.
     */
	private void deckMaker() {
		for (Colour colour : Colour.values()) {
			for(Number number : Number.values()) {
				if (number.equals(Number.NULL)) {
					continue;
				}
				if (!number.equals(Number.ZERO)) {
					NumberCard card = new NumberCard(colour,number);
					for (int i = 0 ; i < 2 ; i++) {
						deck.add(card);
						
					}
				}
				else {
					NumberCard cardzero = new NumberCard(colour,Number.ZERO);
					deck.add(cardzero);
				}
				
			}
			for(EAction action : EAction.values()) {
				if (action.equals(EAction.NULL)) {
					continue;
				}
				ActionCard card2 = new ActionCard(action,colour);
				for (int i =0 ; i <2 ; i++) {
					deck.add(card2);
				}
				
			}
		}
//		for (WildType wild : WildType.values()){
//			if (wild.equals(WildType.NULL)) {
//				continue;
//			}
//			WildCard card4 = new WildCard(wild);
//			for (int i = 0 ; i < 4 ; i++) {
//				deck.add(card4);
//			}
//		}

		
		deckhuffler();
		
	}
	
	/**
     * Shuffles the deck.
     */
	private void deckhuffler() {
		Collections.shuffle(deck);
	}
	
	/**
     * Removes the top card from the deck.
     */
	public void drawCard() {
		deck.remove(deck.size()-1);
	}

	/**
     * It gets the deck of cards.
     *
     * @return The ArrayList containing the cards in the deck.
     */
	public ArrayList<Card> getDeck() {
		return deck;
	}

}


