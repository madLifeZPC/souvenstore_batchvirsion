package sg.edu.nus.iss.souvenirstore.ui.main;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import sg.edu.nus.iss.souvenirstore.ui.Login;

//import StorePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.ComponentOrientation;

/***
 * Home page
 * @author Vrinda Gupta
 * 
 */

public class StoreFrame extends JFrame {
	private StorePanel currentPanel;
	
	
	public StoreFrame(){
		setTitle("Souvenir Store Application");
		ImageIcon imageIcon = new ImageIcon(StoreFrame.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		setIconImage(imageIcon.getImage());
		currentPanel = new StorePanel();
		currentPanel.setBackground(new Color(51, 51, 51));
		setupFrame();
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		System.out.println(screenHeight + " " + screenWidth);
		// set frame width, height and let platform pick screen location
		setSize(screenWidth*2/3 , screenHeight*2/3); 
		setLocationByPlatform(true);
		setLocationRelativeTo(null); 
	}
	public void setupFrame(){
		this.setContentPane(currentPanel);
	}
	
		}
	
	

