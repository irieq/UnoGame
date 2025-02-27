package uno;

import uno.ActionCard.EAction;
import uno.NumberCard.Number;
import uno.WildCard.WildType;

/**
 * It represents a card in the UNO game.
 * This is an abstract class and should be extended by specific card types
 * like NumberCard, ActionCard, or WildCard.
 */
public abstract class Card {
	
	 /**
     * it gets the color of the card.
     *
     * @return The color of the card.
     */
	public abstract String getColour();
	
	/**
     * It gets the score value of the card.
     *
     * @return The score value of the card.
     */
	public abstract int getScore();
	
	/**
     * if applicable, it gets the value of the card .
     *
     * @return The numerical value of the card.
     */
	public abstract Number getNumber();
	
	/**
     * if applicable, it gets the type of the card .
     *
     * @return The type of the card.
     */
	public abstract WildType getType();
	
	/**
     * If applicable, it gets the action associated with the card.
     *
     * @return The action related with the card.
     */
	public abstract EAction getAction();
	
	 /**
     * It returns a string representation of the card.
     *
     * @return A string representation of the card.
     */
	public abstract String toString();

	

}
