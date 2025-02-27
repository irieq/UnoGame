package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import uno.ActionCard.EAction;
import uno.Bot;
import uno.Card;
import uno.Player;
import uno.UnoGame;

/**
 * Represents the  gui also known as graphical user interface for the Uno game.
 * This class allows players to interact with the game through buttons and panels.
 */
public class GameGui extends JFrame implements ActionListener  {
	private JButton draw;
	private JPanel sidepanel;
	private JPanel discardpile;
	private JButton discardpilebutton;
	private UnoGame game;
	private JPanel handpanel;
	private JButton cardbutton;
	private ArrayList<JButton> cardbuttons;
	private JScrollPane scroll;
	private JPanel namepanel;
	private JButton namebutton;

	 /**
     * Constructs a new GameGui instance.
     * Initializes the GUI and sets up the layout.
     * 
     * @param game The UnoGame instance representing the current game state.
     */
	public GameGui(UnoGame game) {
		this.game = game;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,800);
		this.setLayout(new BorderLayout());
		userPanel();
		discardPilePanel();
		drawButton();
		namePanel();
		this.add(handpanel, BorderLayout.SOUTH);
		this.add(discardpile, BorderLayout.CENTER);
		this.add(sidepanel, BorderLayout.WEST);
		this.add(namepanel, BorderLayout.NORTH);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	/**
     * Sets up the "Draw" button on the side panel.
     * This button allows the player to draw a card from the draw pile.
     */
	private void drawButton() {
		this.sidepanel = new JPanel();
		sidepanel.setBackground(Color.gray);
		sidepanel.setLayout(null);
		sidepanel.setPreferredSize(new Dimension(100,1));
		this.draw = new JButton();
		sidepanel.add(draw);
		draw.setText("Draw");
		draw.setSize(100,100);
		draw.addActionListener(this);
	}
	
	/**
     * Sets up the panel displaying the discard pile.
     * This panel shows the top card of the discard pile.
     */
	private void discardPilePanel() {
		this.discardpile = new JPanel();
		this.discardpilebutton = new JButton();
		discardpile.setBackground(Color.white);
		discardpile.setLayout(null);
		discardpilebutton.setBounds(470,300,150,160);
		Card firstcard = game.getTopDiscardCard();
		buttonChanger(firstcard, discardpilebutton);
		discardpilebutton.revalidate();
		discardpilebutton.repaint();
		
		discardpile.add(discardpilebutton);
		
		
		discardpile.setSize(new Dimension(90,100));
		
	}
	
	 /**
     * Sets up the panel displaying player names and hand sizes.
     * This panel shows the names of all players and the number of cards in their hands.
     */
	private void namePanel() {
		this.namepanel = new JPanel();
		namepanel.setBackground(Color.gray);
		namepanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		namepanel.setPreferredSize(new Dimension(1,100));
		for (int i = 0; i < game.getPlayers().size(); i++) {
			this.namebutton = new JButton(game.getPlayers().get(i).getName()+ ":" + game.getPlayers().get(i).getHand().size());
			namebutton.setForeground(Color.BLACK);
            namebutton.setPreferredSize(new Dimension(120,100));
			namepanel.add(namebutton);
		}
		
		
		
	}
	
	 /**
     * Sets up the panel displaying the user's hand of cards.
     * This panel shows the cards in the user's hand and allows the user to interact with them.
     */	
	private void userPanel() {
        this.handpanel = new JPanel();
        handpanel.setBackground(Color.gray);
        handpanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        this.scroll = new JScrollPane(handpanel,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.cardbuttons = new ArrayList <JButton> ();
        for (int i = 0 ; i < game.getPlayers().get(0).getHand().size(); i++) {
            Card card = game.getPlayers().get(0).getHand().get(i);
            this.cardbutton = new JButton();
            buttonChanger(card, cardbutton);

            cardbutton.setPreferredSize(new Dimension(90,100));
            cardbutton.addActionListener(this);
            cardbuttons.add(i, cardbutton);
            handpanel.add(cardbutton);
        }
        handpanel.setAlignmentY(BOTTOM_ALIGNMENT);
        handpanel.setSize(new Dimension(400,100));
    }

	
	
	/**
     * Plays the card at the specified index from the user's hand.
     * Removes the card from the hand, updates the discard pile,.
     * @param i The index of the card to be played.
     */
	private void playCard(int i) {
		handpanel.remove(cardbuttons.get(i));
		handpanel.revalidate();
		handpanel.repaint();
		discardpilebutton.revalidate();
		discardpilebutton.repaint();
		Card card = game.getPlayers().get(0).getHand().get(i);
		game.getPlayers().get(0).playCard(card);
		cardbuttons.remove(i);
		game.addToDiscardPile(card);
		buttonChanger(card, discardpilebutton);
		
		discardpilebutton.revalidate();
		discardpilebutton.setPreferredSize(new Dimension(150,160));
		
	}
	
	/**
     * Updates the appearance of a button to represent a card.
     * Changes the text and color of the button based on the card's properties.
     * @param card The card to be represented by the button.
     * @param button The button to be updated.
     */
	private void buttonChanger(Card card, JButton button) {
		if (card.getClass().getSimpleName().equals("NumberCard")) {
			button.setText(card.getNumber().getValue());	
			
		}
		else if (card.getClass().getSimpleName().equals("ActionCard")) {
			button.setText(card.getAction().getValue());
			
		}
		
		else if (card.getClass().getSimpleName().equals("WildCard")) {
			button.setText(card.getType().getEType());
			button.setForeground(Color.white);
			
		}
		if (card.getColour().equals("red")) {
			button.setBackground(Color.red);
		}
		else if (card.getColour().equals("blue")) {
			button.setBackground(Color.blue);
		}
		else if (card.getColour().equals("yellow")) {
			button.setBackground(Color.yellow);
		}
		else if (card.getColour().equals("black")) {
			button.setBackground(Color.black);
		}
		else if (card.getColour().equals("green")) {
			button.setBackground(Color.green);
		}
		button.setOpaque(true);
		button.setBorderPainted(false);
	}
	
	/**
     * Draws a card from the draw pile and adds it to the user's hand panel.
     * Updates the GUI.
     */
	private void guidrawCard() {
		Card card = game.getTopDrawPileCard();
		this.cardbutton = new JButton();
        cardbutton.setPreferredSize(new Dimension(90,100));
        cardbutton.addActionListener(this);
        handpanel.add(cardbutton);
        cardbuttons.add(cardbutton);
        buttonChanger(card, cardbutton);

        game.drawCard(game.getPlayers().get(0));
        handpanel.revalidate();
        handpanel.repaint();
	}
	
	/**
     * Updates the appearance of the discard pile button to represent the top card of the discard pile.
     * @param card The top card of the discard pile.
     */
	private void updateDiscardPileButton(Card card) {
	    SwingUtilities.invokeLater(() -> {
	        discardpile.remove(discardpilebutton); 
	        discardpilebutton = new JButton();
	        discardpilebutton.setBounds(470, 300, 150, 160);
	        buttonChanger(card, discardpilebutton);
	        discardpile.add(discardpilebutton); 
	        discardpile.revalidate();
	        discardpile.repaint();
	    });
	}
	
	/**
     * Updates the text of the name button for the specified player index to reflect their hand size.
     * @param playerIndex The index of the player whose name button should be updated.
     */
	private void updateNameButtonText(int playerIndex) {
	    SwingUtilities.invokeLater(() -> {
	        Player player = game.getPlayers().get(playerIndex);
	        namebutton = (JButton) namepanel.getComponent(playerIndex);
	        namebutton.setText(player.getName() + ":" + player.getHand().size());
	        namepanel.revalidate();
	        namepanel.repaint();
	    });
	}
	
	/**
     * Implements the game loop logic, including handling card effects and bot turns.
     */
	private void gameLoop() {
		if (game.getCurrentplayer()== 0 && game.getTopDiscardCard().getAction().equals(EAction.PLUS2)) {
			game.cardEffects(game.getTopDiscardCard());
			guidrawCard();

		}
		else if (game.getTopDiscardCard().getAction().equals(EAction.SKIP) ) {
			game.cardEffects(game.getTopDiscardCard());

		}
		else if  ( game.getCurrentplayer()!= 0 && game.getTopDiscardCard().getAction().equals(EAction.PLUS2)) {
			game.cardEffects(game.getTopDiscardCard());

		}
		
		
		
		if ((game.getCurrentplayer() != 0)) {
			for( int i = game.getCurrentplayer() ; i<game.getPlayers().size(); i++) {
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
				}
				((Bot) game.getPlayers().get(i)).playCard(game);
				Card card = game.getTopDiscardCard();
				updateDiscardPileButton(card); 
				
				updateNameButtonText(i);
			

			}
			game.setCurrentplayer(0);
		}
		
		
	}
	
	/**
     * Handles button click events.
     * If cardbutton is pressed, user plays the card and it puts the card on the discard pile and continues with the game loop.
     * If the draw is pressed, user draws the card from the draw pile.
     * @param e The ActionEvent representing the button click event.
     * 
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i< cardbuttons.size(); i++) {
			if(e.getSource() == cardbuttons.get(i)) {
				if (game.getCurrentplayer() ==  0) {
					if( game.isPlayable(game.getPlayers().get(0).getHand().get(i))) {
						MultiThreading thread = new MultiThreading();
						thread.start();
						handpanel.revalidate();
						int index = i;
						playCard(index);
						game.played();
						updateNameButtonText(0);
						MultiThreading thread2 = new MultiThreading();
						thread2.start();
						

	
					}
				}
			}
		}
		if(e.getSource() == draw) {
			guidrawCard();
			
			
		}
			
		
	}
	
	/**
     * Represents a thread for executing the game loop.
     * This class allows the game loop to run concurrently with the GUI.
     */
	class MultiThreading extends Thread{
		public void run() {
			gameLoop(); 
		}
	}


}


