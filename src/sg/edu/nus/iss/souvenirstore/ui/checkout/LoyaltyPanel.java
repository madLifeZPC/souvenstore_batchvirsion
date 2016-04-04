package sg.edu.nus.iss.souvenirstore.ui.checkout;
/***
 * Loyalty points page
 * @author Vrinda Gupta
 * 
 */
import javax.swing.JPanel;

import sg.edu.nus.iss.souvenirstore.controller.CheckoutController;
import sg.edu.nus.iss.souvenirstore.controller.MemberController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoyaltyPanel extends JPanel {
	public LoyaltyPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Do you want to redeem your loyalty points   ?");
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel.setBounds(56, 84, 346, 23);
		add(lblNewLabel);
		
		JButton btnYes = new JButton("YES");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MemberController.getMemberInstance().getMemberById(CheckoutController.getCheckoutInstance().getCheckoutMemberID()).getLoyaltyPoints() <100)
				{
					JOptionPane.showMessageDialog(null, "THE MEMBER DO NOT HAVE SUFFICIENT LOYALTY POINTS. MINIMUM 100 POINTS REQUIRED FOR REDEMPTION", "Loyalty Points", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					CheckoutController.getCheckoutInstance().setApplyLoyalty(true);
				}
				((Window) getRootPane().getParent()).dispose();
			}
		});
		btnYes.setIcon(new ImageIcon(LoyaltyPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/ok.png")));
		btnYes.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnYes.setBounds(85, 130, 117, 36);
		add(btnYes);
		
		JButton btnNo = new JButton("NO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckoutController.getCheckoutInstance().setApplyLoyalty(false);
				((Window) getRootPane().getParent()).dispose();
			}
		});
		btnNo.setIcon(new ImageIcon(LoyaltyPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/close.png")));
		btnNo.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNo.setBounds(255, 130, 117, 36);
		add(btnNo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoyaltyPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Gift-icon.png")));
		lblNewLabel_1.setBounds(201, 22, 61, 43);
		add(lblNewLabel_1);
	}

}
