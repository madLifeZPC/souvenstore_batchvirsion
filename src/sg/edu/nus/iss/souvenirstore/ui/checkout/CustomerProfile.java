package sg.edu.nus.iss.souvenirstore.ui.checkout;
/***
 * Customer profile page
 * @author Vrinda Gupta
 * 
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JTextField;

import sg.edu.nus.iss.souvenirstore.controller.CheckoutController;
import sg.edu.nus.iss.souvenirstore.controller.MemberController;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerProfile extends JPanel {
	public CustomerProfile() {

		if(!CheckoutController.getCheckoutInstance().getCheckoutMemberID().equals(""))
		{
			initializecustProfile();
		}
		
	}
	
	public void initializecustProfile()
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER PROFILE");
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel.setBounds(159, 17, 157, 19);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID :");
		lblNewLabel_1.setForeground(new Color(255, 255, 204));
		lblNewLabel_1.setBounds(49, 60, 91, 16);
		add(lblNewLabel_1);
		
		
		
		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(new Color(255, 255, 204));
		lblName.setBounds(49, 100, 91, 16);
		add(lblName);
		
		JLabel lblLoyaltyPoints = new JLabel("Loyalty Points :");
		lblLoyaltyPoints.setForeground(new Color(255, 255, 204));
		lblLoyaltyPoints.setBounds(49, 140, 104, 16);
		add(lblLoyaltyPoints);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Window) getRootPane().getParent()).dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(CustomerProfile.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/ok.png")));
		btnNewButton.setBounds(169, 187, 117, 36);
		add(btnNewButton);
		String memID = CheckoutController.getCheckoutInstance().getCheckoutMemberID();
		JLabel lblNewLabel_2 = new JLabel(memID);
		lblNewLabel_2.setForeground(new Color(255, 255, 204));
		lblNewLabel_2.setBounds(159, 60, 61, 16);
		add(lblNewLabel_2);
		
		JLabel label = new JLabel(MemberController.getMemberInstance().getMemberById(memID).getMemberName());
		label.setForeground(new Color(255, 255, 204));
		label.setBounds(159, 100, 61, 16);
		add(label);
		
		JLabel label_1 = new JLabel(String.valueOf((MemberController.getMemberInstance().getMemberById(memID).getLoyaltyPoints())));
		label_1.setForeground(new Color(255, 255, 204));
		label_1.setBounds(159, 140, 61, 16);
		add(label_1);
	}
}
