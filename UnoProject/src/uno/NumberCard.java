package uno;

import uno.ActionCard.EAction;
import uno.WildCard.WildType;

/**
 * It represents a Number Card in the UNO game.
 * These cards have numerical values and are related with a colour.
 * This class extends {@link Card} Class. 
 */
public class NumberCard extends Card {
	
	/**
     * Enumeration representing the different numerical values of Number Cards.
     * Each value corresponds to a number from 0 to 9.
     */
	public enum Number{
		ZERO(0),
		ONE(1),
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		NULL(-1);
		
		public int value;
		
		 /**
         * Constructor for enum Number.
         *
         * @param value The values related with the card.
         */
		Number(int value){
			this.value = value;
		}
		
		 /**
         * Gets the string of the numerical value.
         *
         * @return The string of the numerical value.
         */
		public String getValue() {
			return Integer.toString(value);
			
		}
		
		
	}
	
	private final Colour colour;
	private final Number number;
	
	/**
     * Constructor for a NumberCard Class with the specified color and number.
     *
     * @param colour The color of the card.
     * @param number The value of the card.
     */
	public NumberCard(Colour colour, Number number) {
		super();
		this.colour = colour;
		this.number = number;
		
	}

	 /**
     * It gets the color of the NumberCard.
     *
     * @return The color of the NumberCard.
     */
	@Override
	public String getColour() {
		return colour.getColour();
	}
	
	/**
     * It gets the numerical value of the NumberCard.
     *
     * @return The numerical value of the NumberCard.
     */
	public Number getNumber() {
		return number;
	}
	
	/**
     * It gets the score value of the NumberCard which is equal to its numerical value.
     *
     * @return The score value of the NumberCard.
     */
	@Override
	public int getScore() {
		return number.value;
	}

	/**
     * It returns a string representation of the NumberCard.
     *
     * @return A string representation of the NumberCard.
     */
	@Override
	public String toString() {
		return "" + number + colour.getColour() ;
	}

	/**
     * It gets the type of the NumberCard which is always null for number cards 
     * since they don't have a wild card type.
     *
     * @return The type of the NumberCard which is always null.
     */
	@Override
	public WildType getType() {
		return WildType.NULL;
	}

	/**
     * Gets the action associated with the NumberCard which is always null for number cards
     * since they don't have actions.
     *
     * @return The action associated with the NumberCard which is null.
     */
	@Override
	public EAction getAction() {
		return EAction.NULL;
	}
	
	
	
}
