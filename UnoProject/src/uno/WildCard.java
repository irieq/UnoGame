package uno;

import uno.ActionCard.EAction;
import uno.NumberCard.Number;



/**
 * It represents a Wild Card in the UNO game.
 * This cards can change the color of the game and may have special effects like draw four.
 * This class has Wild and +4 types for Wild Card.
 * This class extends {@link Card} Class. 
 */

public class WildCard extends Card {
	
	
	/**
     * This enumeration represents the types of Wild Cards which are,
     * WILD: A regular Wild Card which changes only colour.
     * WILD4: A Wild Card with a +4 effect and changes colour.
     * NULL: Represents an empty wild type.
     */
	public enum WildType{
		WILD("Wild"), WILD4("+4"), NULL(" ");
		
		public String type;
		
		/**
         * Constructor for enum WildType .
         *
         * @param type The string representation of the WildType.
         */
		WildType(String type) {
			this.type = type;
		}
		
		/**
         * Get the string of the WildType.
         *
         * @return The string of the WildType.
         */
		
		public String getEType() {
			return type;
		}
		
	}

	private String color = "black";
	private final WildType type;
	
	/**
     * Constructor for WildCard class with the specified type.
     *
     * @param type The type of WildCard (WILD, WILD4, NULL).
     */
	public WildCard(WildType type) {
		super();
		this.type = type;
	}
	
	 /**
     * Getting the type of the WildCard.
     *
     * @return The type of the WildCard.
     */
	public WildType getType() {
		return type;
	}

	/**
     * Gets the colour of the WildCard.
     *
     * @return The colour of the WildCard.
     */
	@Override
	public String getColour() {
		return color;
	}

	 /**
	 * Gets the score value of the WildCard.
	 *
	 * @return The score value of the WildCard.
	 */
	@Override
	public int getScore() {
		return 50;
	}

	/**
     * Returns a string representation of the WildCard.
     *
     * @return A string representation of the WildCard.
     */
	@Override
	public String toString() {
		return "WildCard [color=" + color + ", type=" + type + "]";
	}

	/**
     * Gets the number of the WildCard which is always null also known as none for Wild Cards because 
     * it doesn't have a number.
     *
     * @return The number of the WildCard (null).
     */
	@Override
	public Number getNumber() {
		return Number.NULL;
	}
	
	 /**
     * Gets the action associated with the WildCard which is always null also known as none for Wild Cards
     * because it is not similar to Action Card.
     * 
     *
     * @return The action associated with the WildCard (Always NULL).
     */
	@Override
	public EAction getAction() {
		// TODO Auto-generated method stub
		return EAction.NULL;
	}
	
	/**
     * Sets the color of the WildCard.
     *
     * @param colour The color to set for the WildCard.
     */
	public void setColor(String colour) {
		this.color = colour;
	}
	
	
}
