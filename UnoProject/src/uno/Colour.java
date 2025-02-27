package uno;

/**
 * Represents the colors of cards in the UNO game which are 
 * RED, BLUE, YELLLOW, GREEN.
 * 
 */
public enum Colour {
	RED("red"), BLUE("blue"), YELLOW("yellow"), GREEN("green");
	
	private final String colour;
	
	
	/**
     * Constructor for enum Colour.
     *
     * @param colour The string of the color.
     */
	private Colour(String colour) {
		this.colour = colour;
	}

	 /**
     * It gets the string representation of the colour.
     *
     * @return The string representation of the colour.
     */
	public String getColour() {
		return colour;
	}

	
	
}
