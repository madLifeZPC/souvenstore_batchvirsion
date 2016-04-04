package sg.edu.nus.iss.souvenirstore.ui.checkout;

import java.awt.Color;
/***
 * Checkout Frame
 * @author Vrinda Gupta
 * 
 */
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;
import sg.edu.nus.iss.souvenirstore.ui.main.StorePanel;

public class CheckoutFrame extends JFrame {
	
	static EnterMemberorNonMember MemberPanel;
	private CheckoutPanel checkoutpanel;
	private CheckoutPanelNonMember checkoutpanelnonmember;
	
	public CheckoutFrame (){
		setTitle("Souvenir Store Application");
		ImageIcon imageIcon = new ImageIcon(StoreFrame.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		setIconImage(imageIcon.getImage());
		MemberPanel = new EnterMemberorNonMember();
		MemberPanel.setBackground(new Color(51, 51, 51));
		checkoutpanel = new CheckoutPanel();
		checkoutpanel.setBackground(new Color(51, 51, 51));
		
		checkoutpanelnonmember = new CheckoutPanelNonMember();
		checkoutpanelnonmember.setBackground(new Color(51, 51, 51));
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		System.out.println(screenHeight*2/3 + " " + screenWidth*2/3);
		// set frame width, height and let platform pick screen location
		setSize(screenWidth*2/3 , screenHeight*2/3); 
		setLocationByPlatform(true);
		setLocationRelativeTo(null); 
	}
	public void setupFrame(){
		this.setContentPane(MemberPanel);
	
	}
	
	public void Setupcheckoutpanel(){
		this.setContentPane(checkoutpanel);
	}
	public void Setupcheckoutpanelnonmember(){
		this.setContentPane(checkoutpanelnonmember);
	}
	
		}


