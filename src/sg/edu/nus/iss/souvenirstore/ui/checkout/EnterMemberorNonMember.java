package sg.edu.nus.iss.souvenirstore.ui.checkout;
/***
 * Member or Non member Page
 * @author Vrinda Gupta
 * 
 */
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridBagLayout;
import javax.swing.JLayeredPane;
import java.awt.Label;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

import sg.edu.nus.iss.souvenirstore.controller.CheckoutController;
import sg.edu.nus.iss.souvenirstore.ui.Login;
import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;
import sg.edu.nus.iss.souvenirstore.ui.main.StorePanel;

import javax.swing.JSplitPane;
import java.awt.Component;

public class EnterMemberorNonMember extends JPanel {
	
	private MemberScan memberscan;
	private CheckoutFrame checkoutframe;
	
	
	
	

	public EnterMemberorNonMember() {
		setLayout(null);
		
		Login login = new Login();
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(51, 86, 1, 1);
		add(layeredPane);
		
		JButton btnNewButton = new JButton("Member");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CheckoutController.getCheckoutInstance().resetCheckout();
				memberscan = new MemberScan();
					login.initializeWindow(memberscan);
					memberscan.setupMemberScanPanel();
					memberscan.setSize(426,266);
					memberscan.setLocationRelativeTo(null); 
				}
			});
		btnNewButton.setRolloverSelectedIcon(new ImageIcon(EnterMemberorNonMember.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Members_c copy.png")));
		btnNewButton.setRolloverIcon(new ImageIcon(EnterMemberorNonMember.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Member_c.png")));
		btnNewButton.setAutoscrolls(true);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setIcon(new ImageIcon(EnterMemberorNonMember.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Members_c copy.png")));
		btnNewButton.setBounds(301, 115, 283, 142);
		add(btnNewButton);
		
		JButton btnNonMember = new JButton("Non Member");
		btnNonMember.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				CheckoutController.getCheckoutInstance().resetCheckout();
				checkoutframe = new CheckoutFrame();
				StorePanel.checkoutframe.dispose();
				login.initializeWindow(checkoutframe);
				checkoutframe.Setupcheckoutpanelnonmember();
				checkoutframe.setSize(853,533);
				checkoutframe.setLocationRelativeTo(null);
				if(CheckoutPanel.checkout1frame!=null)
				{
				if(CheckoutPanel.checkout1frame.isVisible())
				{
				CheckoutPanel.checkout1frame.dispose();
				}
				else
				{
				CheckoutPanelNonMember.checkout3frame.dispose();
				}
				}
				
				}
			});
		btnNonMember.setRolloverSelectedIcon(new ImageIcon(EnterMemberorNonMember.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/not member copy.png")));
		btnNonMember.setRolloverIcon(new ImageIcon(EnterMemberorNonMember.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/not member copy.png")));
		btnNonMember.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 17));
		btnNonMember.setIcon(new ImageIcon(EnterMemberorNonMember.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/not member.png")));
		btnNonMember.setBounds(301, 292, 283, 142);
		add(btnNonMember);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setIcon(new ImageIcon(EnterMemberorNonMember.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/back.png")));
		btnReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				((Window) getRootPane().getParent()).dispose();
					
				}
			});
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn.setBounds(640, 437, 114, 36);
		add(btnReturn);
	}
	
}
