package uno;

/**
 * Represents a user in the UNO game.
 * Each user has a username, password, and game statistics.
 */

public class User {
	private String username;
	private String password;
	private int wins;
	private int loses;
	private int totalplayed;
	private Player userplayer;
	
	
	/**
     * Constructor for a new User object with the specified username, password, wins, losses, and total games played.
     * Initializes the user's player with the same username.
     *
     * @param username    The username of the user.
     * @param password    The password of the user.
     * @param wins        The number of wins of the user.
     * @param loses       The number of losses of the user.
     * @param totalplayed The total number of games played by the user.
     */
	public User(String username, String password, int wins, int loses, int totalplayed) {
		this.username = username;
		this.password = password;
		this.wins = wins;
		this.loses = loses;
		this.totalplayed = totalplayed;
		this.userplayer = new Player(username);
		
	}
	
	/**
     * Gets the player associated with the user.
     *
     * @return The player associated with the user.
     */
	public Player getUserplayer() {
		return userplayer;
	}
	
	 /**
     * Sets the player associated with the user.
     *
     * @param userplayer The player to be associated with the user.
     */
	public void setUserplayer(Player userplayer) {
		this.userplayer = userplayer;
	}
	
	/**
     * Gets the username of the user.
     *
     * @return The username of the user.
     */
	public String getUsername() {
		return username;
	}
	 /**
     * Sets the username of the user.
     *
     * @param username The username to be set for the user.
     */
	public void setUsername(String username) {
		this.username = username;
	}
	 /**
     * Gets the password of the user.
     *
     * @return The password of the user.
     */
	public String getPassword() {
		return password;
	}
	
	/**
     * Sets the password of the user.
     *
     * @param password The password to be set for the user.
     */
	public void setPassword(String password) {
		this.password = password;
	}
	
	 /**
     * Gets the number of wins of the user.
     *
     * @return The number of wins of the user.
     */
	public int getWins() {
		return wins;
	}
	
	/**
     * Sets the number of wins of the user.
     *
     * @param wins The number of wins to be set for the user.
     */
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	/**
     * Gets the number of losses of the user.
     *
     * @return The number of losses of the user.
     */
	public int getLoses() {
		return loses;
	}
	
	/**
     * Sets the number of losses of the user.
     *
     * @param loses The number of losses to be set for the user.
     */
	public void setLoses(int loses) {
		this.loses = loses;
	}
	
	/**
     * Gets the total number of games played by the user.
     *
     * @return The total number of games played by the user.
     */
	public int getTotalplayed() {
		return totalplayed;
	}
	
	/**
     * Sets the total number of games played by the user.
     *
     * @param totalplayed The total number of games played to be set for the user.
     */
	public void setTotalplayed(int totalplayed) {
		this.totalplayed = totalplayed;
	}
	
	

}
