package sg.edu.nus.iss.souvenirstore.ui;
/***
 * Login Page
 * @author Vrinda Gupta
 * 
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sg.edu.nus.iss.souvenirstore.controller.LoginController;
import sg.edu.nus.iss.souvenirstore.ui.checkout.CheckoutFrame;
import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;
import sg.edu.nus.iss.souvenirstore.ui.main.StorePanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private StoreFrame storeframe;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public Login() {
		getContentPane().setBackground(new Color(51, 51, 51));
		setTitle("Souvenir Store Login");
		ImageIcon imageIcon = new ImageIcon(Login.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		setIconImage(imageIcon.getImage());
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/3 , screenHeight/3); 
		setLocationByPlatform(true);
		setLocationRelativeTo(null); 
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 246, 426, -246);
		getContentPane().add(panel);
		
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel.setBounds(68, 106, 78, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 204));
		lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblPassword.setBounds(68, 141, 78, 23);
		getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(158, 105, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 140, 130, 26);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userName = textField.getText().toString();
				String passWord = new String(passwordField.getPassword());
				if(LoginController.getLoginInstance().authenticateUser(userName, passWord))
				{
					storeframe = new StoreFrame();
					initializeWindow(storeframe );
					setVisible(false);
					storeframe.setupFrame();
					storeframe .setSize(853,533);
					storeframe .setLocationRelativeTo(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "INVALID USERNAME/PASSWORD COMBINATION", "ERROR!",JOptionPane.ERROR_MESSAGE);
				}
				
 
				
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnNewButton.setBounds(181, 177, 91, 29);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/login.jpg")));
		lblNewLabel_1.setBounds(181, 15, 89, 78);
		getContentPane().add(lblNewLabel_1);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			Login login = new Login(); 
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setVisible(true);
		} 
		}
		);
		}
	//making it public so that all the other classes can use it
	public void initializeWindow(JFrame window) {
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
		}
	