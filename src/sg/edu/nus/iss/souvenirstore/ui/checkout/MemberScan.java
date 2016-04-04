package sg.edu.nus.iss.souvenirstore.ui.checkout;

// frame for scanning member card, scanning product , Customer Profile, Loyalty points and Checkout Summary
/***
 *  
 * @author Vrinda Gupta
 * 
 */

import java.awt.Color;
/***
 * Home page
 * @author Vrinda Gupta
 * 
 */
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.DebugGraphics;
import javax.swing.SwingConstants;

import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;
import sg.edu.nus.iss.souvenirstore.ui.main.StorePanel;

import javax.swing.JTextField;
import javax.swing.JButton;

public class MemberScan extends JFrame {
	
	private MemberScanPanel memberscanpanel;
	private ProductScanPanel productscanpanel;
	private CustomerProfile customerprofile;
	private LoyaltyPanel loyaltypanel;
	private FinalCheckOutSummary finalcheckoutsummary;
	
	public MemberScan() {
		ImageIcon imageIcon = new ImageIcon(StoreFrame.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		setIconImage(imageIcon.getImage());
		setBackground(new Color(51, 51, 51));
		memberscanpanel = new MemberScanPanel();
		memberscanpanel.setBackground(new Color(51, 51, 51));
		productscanpanel = new ProductScanPanel();
		productscanpanel.setBackground(new Color(51, 51, 51));
		customerprofile = new CustomerProfile();
		customerprofile.setBackground(new Color(51, 51, 51));
		loyaltypanel = new LoyaltyPanel();
		loyaltypanel.setBackground(new Color(51, 51, 51));
		finalcheckoutsummary = new FinalCheckOutSummary();
		finalcheckoutsummary.setBackground(new Color(51, 51, 51));
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		System.out.println(screenHeight/3 + " " + screenWidth/3);
		setSize(screenWidth/3 , screenHeight/3); 
		setLocationByPlatform(true);
		setLocationRelativeTo(null);
		
	}
	public void setupMemberScanPanel(){
		setTitle("Scan Members Card");
		this.setContentPane(memberscanpanel);
	}
	public void setupProductScanPanel(){
		setTitle("Scan Product Code");
		this.setContentPane(productscanpanel);
	}
	public void setupCustomerProfile(){
		setTitle("Customer Profile");
		this.setContentPane(customerprofile);
	}
	public void setupLoyaltyPanel(){
		setTitle("Loyalty Window");
		this.setContentPane(loyaltypanel);
	}
	public void setupCheckoutSummary(){
		setTitle("Checkout Summary");
		this.setContentPane(finalcheckoutsummary);
		
	}
		
		
		
	
}
	
