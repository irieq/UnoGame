package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import uno.Bot;
import uno.Player;
import uno.UnoGame;
import uno.User;

/**
 * Represents the gui also known as graphical user interface for the main menu where users can start a new game.
 */
public class MainMenuGui extends JFrame implements ActionListener {
	private JButton newgamebutton;
	private JFrame playerask;
	private JTextField playeramount;
	private JButton ok;
	private ArrayList<Player> players = new ArrayList<Player>();
	private UnoGame game;
	private Player botplayer;
	private User user;

	/**
     * Constructs a new MainMenuGui object.
     * Initializes the components of the main menu.
     *
     * @param user The User object representing the current user.
     */
	public MainMenuGui(User user) {
		this.user = user;
		
		this.newgamebutton = new JButton("New Game");
		this.newgamebutton.addActionListener(this);
		
		this.ok = new JButton("Start the game");
		ok.setBounds(50, 200,170,30);
		ok.addActionListener(this);

		this.playeramount = new JTextField();	
		this.playeramount.setBounds(45, 160,150,30);
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout( new GridBagLayout());
		this.add(newgamebutton, new GridBagConstraints());
		this.setResizable(false);
		this.setVisible(true);
	}

	/**
     * Handles button clicks for the main menu.
     * If the new game button is clicked, prompts the user to enter the number of players.
     * If the start game button is clicked, starts a new game with the specified number of players.
     *
     * @param e The ActionEvent object representing the button click.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == newgamebutton) {
			this.playerask = new JFrame();
			playerask.setSize(500,500);
			playerask.setLayout(null);
			playerask.add(playeramount);
			playerask.add(ok);
			playerask.setVisible(true);
			this.setVisible(false);
			
			
		}
		else if (e.getSource() == ok) {
			String player = playeramount.getText();
			int playerss = Integer.parseInt(player);
			players.add(user.getUserplayer());
			
			for(int i = 1 ; i < playerss; i++) {
				botplayer = new Bot("Bot"+i);
				players.add(botplayer);
			}
			
			game = new UnoGame(players, true, 0);
			new GameGui(game);
			playerask.setVisible(false);
			
			
		}
		
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
     * @param players The list of players to set.
     */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
     * Gets the current UnoGame object.
     *
     * @return The UnoGame object.
     */
	public UnoGame getGame() {
		return game;
	}

	/**
     * Sets the current UnoGame object.
     *
     * @param game The UnoGame object to set.
     */

	public void setGame(UnoGame game) {
		this.game = game;
	}

	 /**
     * Gets the bot player.
     *
     * @return The bot player.
     */
	public Player getBotplayer() {
		return botplayer;
	}

	/**
     * Sets the bot player.
     *
     * @param botplayer The bot player to set.
     */
	public void setBotplayer(Player botplayer) {
		this.botplayer = botplayer;
	}
	

}
