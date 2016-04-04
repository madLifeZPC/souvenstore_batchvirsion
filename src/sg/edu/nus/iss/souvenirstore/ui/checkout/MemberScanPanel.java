package sg.edu.nus.iss.souvenirstore.ui.checkout;
/***
 * Scanning members card
 * @author Vrinda Gupta
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sg.edu.nus.iss.souvenirstore.controller.CheckoutController;
import sg.edu.nus.iss.souvenirstore.controller.MemberController;
import sg.edu.nus.iss.souvenirstore.ui.Login;
import sg.edu.nus.iss.souvenirstore.ui.main.StorePanel;

public class MemberScanPanel extends JPanel {
	private JTextField textField;
    private CheckoutFrame checkout2frame;
	private CheckoutPanel checkoutpanel;
	
	public MemberScanPanel() {
		setupMemberScanPanel();
	}
	private void setupMemberScanPanel(){
		
		Login login = new Login();
		textField = new JTextField();
		textField.setBounds(168, 137, 130, 26);
        add(textField);
		textField.setColumns(10);
		setLayout(null);
		
		//label for the scan image
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MemberScan.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Scan.jpg")));
		lblNewLabel.setBounds(185, 6, 93, 99);
		add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter Card Number");
		lblNewLabel_1.setForeground(new Color(255, 255, 204));
		lblNewLabel_1.setBounds(168, 117, 130, 16);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Scan");
		btnNewButton.setIcon(new ImageIcon(MemberScanPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/scan.png")));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MemberController.getMemberInstance().getMemberById(textField.getText().toString().toUpperCase())!=null)
				{
				((Window) getRootPane().getParent()).dispose();
				CheckoutController.getCheckoutInstance().setCheckoutMemberID(textField.getText().toString().toUpperCase());
				
				checkout2frame = new CheckoutFrame();
				
				//checkout frame can be called from StorePanel, Checkout Panel or Checkout Panel for Non Member
				StorePanel.checkoutframe.dispose();
				login.initializeWindow(checkout2frame);
				checkout2frame.Setupcheckoutpanel();
				checkout2frame.setSize(853,533);
				checkout2frame.setLocationRelativeTo(null);
				if(CheckoutPanel.checkout1frame != null)
				{
				if(CheckoutPanel.checkout1frame.isVisible())
				{
				CheckoutPanel.checkout1frame.dispose();
				}
				else
				{
					if(CheckoutPanelNonMember.checkout3frame!=null)
					{
				CheckoutPanelNonMember.checkout3frame.dispose();
					}
				}
				}
				
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Unable to find member with that ID","Error!",JOptionPane.ERROR_MESSAGE);
				}
				}
			});
		btnNewButton.setBounds(115, 175, 117, 40);
		add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.setIcon(new ImageIcon(MemberScanPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/close.png")));
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		       
				((Window) getRootPane().getParent()).dispose();
					
				}
			});
		btnClose.setBounds(236, 175, 117, 40);
		add(btnClose);
		 
		
		
	}
	
	}


