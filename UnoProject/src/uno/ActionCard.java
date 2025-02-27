package uno;

import uno.NumberCard.Number;
import uno.WildCard.WildType;

/**
 * It represents an Action Card in the UNO game.
 * These cards have special actions such as Skip, Reverse, and +2.
 * This class extends {@link Card} Class. 
 */
public class ActionCard extends Card {
	
	/**
     * Enumeration for representing the different types of actions that can be related with Action Cards 
     * which are SKIP: Skip the next player's turn.
     * REVERSE: Reverse the direction of play.
     * PLUS2: Add +2 cards to the next player's hand.
     * NULL: Represents an empty action.
     */
	public enum EAction{
		SKIP("Skip"), REVERSE("Reverse"), PLUS2("+2"), NULL(" ");
		
		public String value;
		
		/**
         * Constructor for EAction(Action) enum.
         *
         * @param value The string representation of the action.
         */
		EAction(String value){
			this.value = value;
		}
		
		/**
         * Gets the string of the action.
         *
         * @return The string of the action.
         */
		
		public String getValue() {
			return value;
			
		}
		
	}
	
	private final EAction action;
	private final Colour colour;
	
	
	/**
     * Constructor for an ActionCard Class with the specified action and color.
     *
     * @param action The type of action related with the card (SKIP, REVERSE, PLUS2).
     * @param colour The color of the card.
     */
	
	public ActionCard(EAction action, Colour colour) {
		super();
		this.action = action;
		this.colour = colour;
	}
	
	 /**
     * Gets the type of action related with the ActionCard.
     *
     * @return The type of action related with the ActionCard.
     */
	@Override
	public EAction getAction() {
		return action;
	}
	
	/**
     * Gets the colour of the ActionCard.
     *
     * @return The colour of the ActionCard.
     */
	@Override
	public String getColour() {
		return colour.getColour();
	}

	 /**
     * Gets the score value of the ActionCard.
     *
     * @return The score value of the ActionCard.
     */
	@Override
	public int getScore() {
		return 20;
	}


	/**
     * Returns a string representation of the ActionCard.
     *
     * @return A string representation of the ActionCard.
     */
	@Override
	public String toString() {
		return "ActionCard [action=" + action + ", colour=" + colour + "]";
	}


	/**
     * Gets the number of the ActionCard which is NULL for all ActionCards since they 
     * don't have any numbers.
     *
     * @return The number of the ActionCard which is always null.
     */
	@Override
	public Number getNumber() {
		return Number.NULL;
	}


	 /**
     * Gets the type of the ActionCard which is always null since it doesn't have a type like
     * wild cards.
     *
     * @return The type of the ActionCard which is always null.
     */
	@Override
	public WildType getType() {
		return WildType.NULL;
	}
	
	
	

	
	
}
