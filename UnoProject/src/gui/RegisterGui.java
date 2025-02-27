package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uno.Player;
import uno.User;

/**
 * Represents the gui also known as graphical user interface for the registration page.
 */
public class RegisterGui extends JFrame implements ActionListener {
	private JFrame registerframe;
	private JLabel registerlabel;
	private JPanel registerpanel;
	private JLabel usernamelabel;
	private JLabel	passwordlabel;
	private JTextField usernametext;
	private JTextField passwordtext;
	private JButton register;

	
	/**
     * Constructs a new RegisterGui object.
     * Initializes the components of the registration page.
     */
	public RegisterGui() {
		this.registerlabel = new JLabel();
		this.registerlabel.setText("Register Page");
		this.registerlabel.setLayout(null);
		this.registerlabel.setHorizontalAlignment(JLabel.CENTER);
		this.registerlabel.setVerticalAlignment(JLabel.TOP);
		
		this.usernamelabel = new JLabel();
		this.usernamelabel.setText("Username");
		this.usernamelabel.setBounds(50, -20,200,200 );
		this.usernamelabel.setFont(new Font("Ariel",Font.PLAIN, 15));
		
		this.usernametext = new JTextField();
		this.usernametext.setBounds(45, 90,150,30);
		
		this.passwordlabel = new JLabel();
		this.passwordlabel.setText("Password");
		this.passwordlabel.setBounds(45, 50,200,200);
		this.passwordlabel.setFont(new Font("Ariel",Font.PLAIN, 15));
		
		this.passwordtext = new JTextField();
		this.passwordtext.setBounds(45, 160,150,30);
		
		
		this.register = new JButton();
		this.register.setBounds(45,220,170,30);
		this.register.setText("Register");
		this.register.addActionListener(this);
		
		this.registerpanel = new JPanel();
		this.registerpanel.setBackground(Color.gray);
		this.registerpanel.setBounds(101, 100, 300, 300);
		this.registerpanel.setLayout(null);
		this.registerpanel.add(usernamelabel);
		this.registerpanel.add(usernametext);
		this.registerpanel.add(passwordlabel);
		this.registerpanel.add(passwordtext);
		this.registerpanel.add(register);
		
		
		this.registerframe = new JFrame();
		this.registerframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.registerframe.setSize(500,500);
		this.registerframe.add(registerpanel);
		this.registerframe.add(registerlabel);
		this.registerframe.setResizable(false);
		this.registerframe.setVisible(true);
	}

	 /**
     * Handles button clicks on the registration page.
     * If the register button is clicked, writes the username and password to a file and opens the login page.
     *
     * @param e The ActionEvent object representing the button click.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == register) {
			String username = usernametext.getText();
			String password = passwordtext.getText();
			try (FileWriter writer = new FileWriter("src/info/userinfo.txt",true)) {
				String input = String.format("%s %s%n", username, password);
				writer.append(input);
				this.registerframe.setVisible(false);
				new LoginGui();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) { 
				e1.printStackTrace();
			}
		}
		
	}
	

}
