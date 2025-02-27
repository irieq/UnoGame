package uno;

import java.util.ArrayList;
import uno.NumberCard.Number;
import java.util.Collections;

import uno.ActionCard.EAction;
import uno.Player;
import uno.WildCard.WildType;

/**
 * Represents a game of UNO.
 * It manages the deck, players, and game logic.
 */
public class UnoGame {
	private Deck drawpile = new Deck();
	private ArrayList<Card> discardpile = new ArrayList<Card>();
	private ArrayList<Player> players = new ArrayList<Player>();
	private boolean isclockwise = true;
	private int currentplayer = 0;
	
	 /**
     * Constructor for UnoGame Class with the players, direction, and starting player.
     *
     * @param players       The list of players participating in the game.
     * @param isclockwise   The direction of play (clockwise or counterclockwise).
     * @param currentplayer The index of the current player.
     */
	public UnoGame( ArrayList<Player> players, boolean isclockwise,int currentplayer) {
		super();
		this.players = players;
		this.isclockwise = isclockwise;
		this.currentplayer = currentplayer;
		gameInitialization();
	}
	
	 /**
     * It initializes the game by clearing the discard pile, dealing cards to players,
     * adding the top card from the draw pile to the discard pile, and setting the direction to clockwise.
     */
	private void gameInitialization() {
		discardpile.clear();
		dealCards();
		addToDiscardPile(getTopDrawPileCard());
		drawpile.drawCard();
		isclockwise = true;
		
	}
	
	 /**
     * Deals 7 cards to each player cause of the game rule.
     */
	private void dealCards() {
		for (int i = 0; i < 7; i++) {
			for (Player player : players) {
				player.getHand().add(getTopDrawPileCard());
				drawpile.drawCard();
			}
		}
	}
	
	 /**
     * Draws a card from the draw pile and adds it to the player's hand.
     *
     * @param player The player who draws the card.
     */
	public void drawCard(Player player) {
		drawpile.drawCard();
		player.drawCard(getTopDrawPileCard());
	}
	
	 /**
     * Moves the game to the next player's turn.
     */
	public void played() {
		currentplayer ++;
	}
	
	/**
     * Checks if a card is playable.
     *
     * @param card The card to be checked for playability.
     * @return True if the card is playable, false otherwise.
     */
	public boolean isPlayable(Card card) { 
		
		if (card.getColour().equals(getTopDiscardCard().getColour())){
			return true;
		}
		else if (card.getColour().equals("black")){
			return true;
		}
		else if (card.getNumber().equals(getTopDiscardCard().getNumber()) && !card.getNumber().equals(Number.NULL)){
			return true;
		}
		else if (card.getAction().equals(getTopDiscardCard().getAction()) && !card.getAction().equals(EAction.NULL)) {
			return true;
		}
		
		else if (card.getType().equals(getTopDiscardCard().getType()) && !card.getType().equals(WildType.NULL)) {
			return true;
		}
	
		return false;

		
	}
	
	/**
     * Applies the effects of an action card.
     *
     * @param card The action card to apply effects.
     */
	public void cardEffects(Card card){
		if (card.getAction().equals(ActionCard.EAction.PLUS2)) {
			for(int i = 0 ; i < 2; i++) {
				drawCard(players.get(currentplayer));
			}
		}
		
		else if (card.getAction().equals(ActionCard.EAction.SKIP)) {
			currentplayer += 1;
		}
		
		else if (card.getAction().equals(ActionCard.EAction.REVERSE)) {
			
			Collections.reverse(players);
			currentplayer = players.size() - currentplayer + 1;
			if(isclockwise) {
				isclockwise = false;
			}
			else {
				isclockwise = true;
			}
		}
		
	}
	
	 /**
     * It applies the effects of a wild card.
     *
     * @param card   The wild card to apply effects.
     * @param colour The colour chosen for the wild card.
     */
	public void cardEffects(WildCard card, Colour colour) {		
		if (card.getType().equals(WildCard.WildType.WILD4)) {
			card.setColor(colour.getColour());
			for(int i = 0 ; i < 4; i++) {
				drawCard(players.get(currentplayer));
			}
			
		}
		else if (card.getType().equals(WildCard.WildType.WILD)) {
			card.setColor(colour.getColour());
			
		}
	}
	

    /**
     * It gets the top card from the discard pile.
     *
     * @return The top card from the discard pile.
     */
	public Card getTopDiscardCard() {
		if (discardpile.size()-1 >= 0) {
			return discardpile.get(discardpile.size()-1);

		}
		else {
			return null;
		}
		
	}
	
	 /**
     * Adds a card to the discard pile.
     *
     * @param card The card to be added to the discard pile.
     */
	public void addToDiscardPile(Card card) {
		discardpile.add(card);
	}

	 /**
     * It gets the top card from the draw pile.
     *
     * @return The top card from the draw pile.
     */
	public Card getTopDrawPileCard() {
		if (drawpile.getDeck().size()-1 >= 0) {
			return drawpile.getDeck().get(drawpile.getDeck().size()-1);
		}
		else {
			return null;
		}
		
	}

	/**
     * Gets the draw pile.
     *
     * @return The draw pile.
     */
	public Deck getDrawpile() {
		return drawpile;
	}

	/**
     * Sets the draw pile.
     *
     * @param drawpile The draw pile to be set.
     */
	public void setDrawpile(Deck drawpile) {
		this.drawpile = drawpile;
	}

	 /**
     * Gets the discard pile.
     *
     * @return The discard pile.
     */
	public ArrayList<Card> getDiscardpile() {
		return discardpile;
	}

	 /**
     * Sets the discard pile.
     *
     * @param discardpile The discard pile to be set.
     */
	public void setDiscardpile(ArrayList<Card> discardpile) {
		this.discardpile = discardpile;
	}

	 /**
     * Gets the list of players.
     *
     * @return The list of players.
     */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	 /**
     * Sets the list of players.
     *
     * @param players The list of players to be set.
     */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	 /**
     * Checks if the game is in clockwise direction.
     *
     * @return True if the game is in clockwise direction, false otherwise.
     */
	public boolean isIsclockwise() {
		return isclockwise;
	}

	/**
     * Sets the direction of play.
     *
     * @param isclockwise True to set the direction to clockwise, false for counterclockwise.
     */
	public void setIsclockwise(boolean isclockwise) {
		this.isclockwise = isclockwise;
	}

	/**
     * Gets the index of the current player.
     *
     * @return The index of the current player.
     */
	public int getCurrentplayer() {
		return currentplayer;
	}

	/**
     * Sets the index of the current player.
     *
     * @param currentplayer The index of the current player to be set.
     */
	public void setCurrentplayer(int currentplayer) {
		this.currentplayer = currentplayer;
	}
	
}

