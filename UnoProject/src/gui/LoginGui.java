package gui;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uno.User;

/**
 * Represents the gui also known as graphical user interface for the login page.
 */
public class LoginGui extends JFrame implements ActionListener{
	private JFrame loginframe;
	private JLabel loginlabel;
	private JPanel loginpanel;
	private JLabel usernamelabel;
	private JLabel	passwordlabel;
	private JLabel donthaveacc;
	private JTextField usernametext;
	private JTextField passwordtext;
	private JButton register;
	private JButton login;
	private User user;
	
	/**
     * Constructs a new LoginGui object.
     * Initializes the components of the login page.
     */
	public LoginGui(){
		this.loginlabel = new JLabel();
		this.loginlabel.setText("Login Page"); 
		this.loginlabel.setLayout(null);
		this.loginlabel.setHorizontalAlignment(JLabel.CENTER);
		this.loginlabel.setVerticalAlignment(JLabel.TOP);
		
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
		
		this.donthaveacc = new JLabel();
		this.donthaveacc.setText("Don't have account? Click.");
		this.donthaveacc.setBounds(50, 130,200,200);
		this.donthaveacc.setFont(new Font("Ariel",Font.PLAIN, 12));
		
		this.register = new JButton();
		this.register.setBounds(45,220,170,30);
		this.register.addActionListener(this);
		
		this.login = new JButton();
		this.login.setBounds(45,190,170,30);
		this.login.addActionListener(this);
		
		this.loginpanel = new JPanel();
		this.loginpanel.setBackground(Color.gray);
		this.loginpanel.setBounds(101, 100, 300, 300);
		this.loginpanel.setLayout(null);
		this.loginpanel.add(usernamelabel);
		this.loginpanel.add(usernametext);
		this.loginpanel.add(passwordlabel);
		this.loginpanel.add(passwordtext);
		this.loginpanel.add(donthaveacc);
		this.loginpanel.add(register);
		this.loginpanel.add(login);
		
		
		this.loginframe = new JFrame();
		this.loginframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.loginframe.setSize(500,500);
		this.loginframe.add(loginpanel);
		this.loginframe.add(loginlabel);
		this.loginframe.setResizable(false);
		this.loginframe.setVisible(true);

		
	}

	 /**
     * Handles button clicks on the login page.
     * If the register button is clicked, opens the register page.
     * If the login button is clicked, verifies the user and opens the main menu if successful.
     *
     * @param e The ActionEvent object representing the button click.
     */
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == register) {
			new RegisterGui();
			this.loginframe.setVisible(false);
		}
		
		else if(e.getSource() == login) {
			String usernametxt = usernametext.getText();
			String passwordtxt = passwordtext.getText();
			System.out.println(usernametxt);
			System.out.println(passwordtxt);
			try (Scanner reader = new Scanner(Paths.get("src/info/userinfo.txt"))) {
				while(reader.hasNext()) {
					String line = reader.nextLine();
					String[] linewithoutblanks = line.split(" ");
					String username = linewithoutblanks[0];
					String password = linewithoutblanks[1];
					if (usernametxt.equals(username) && passwordtxt.equals(password)) {
						user = new User(username, password, 0 ,0, 0);
						new MainMenuGui(user);
						this.loginframe.setVisible(false);

					}
				
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}


	public User getUser() {
		return user;
	}

}
