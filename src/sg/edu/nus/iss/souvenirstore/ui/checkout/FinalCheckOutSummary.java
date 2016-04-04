package sg.edu.nus.iss.souvenirstore.ui.checkout;
/**
* Checkout Summary
* @author VRINDA
*
*/
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;

import sg.edu.nus.iss.souvenirstore.controller.CheckoutController;
import sg.edu.nus.iss.souvenirstore.controller.TransactionController;
import sg.edu.nus.iss.souvenirstore.controller.ValidationController;
import sg.edu.nus.iss.souvenirstore.ui.Login;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FinalCheckOutSummary extends JPanel {
	private JTextField textField;
	private JButton commitTransaction_1;
	private JButton cancelTransaction_1;
	private double changeReturned;
	private DecimalFormat numberFormat = new DecimalFormat("#.00");
	private PrintReceipt printreceipt;
	public FinalCheckOutSummary() {
		Login login = new Login();
		StringBuilder builder= new StringBuilder();
		setBackground(Color.DARK_GRAY);
		setBounds(new Rectangle(0, 0, 676, 431));
		setLayout(null);
		
		JLabel lblCheckoutSummary = new JLabel("CHECKOUT SUMMARY");
		lblCheckoutSummary.setForeground(new Color(255, 255, 204));
		lblCheckoutSummary.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblCheckoutSummary.setBounds(253, 19, 165, 23);
		add(lblCheckoutSummary);
		
		JLabel lblNewLabel = new JLabel("TOTAL BILLED AMOUNT : ");
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setBounds(70, 86, 165, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");

		lblNewLabel_1.setForeground(new Color(255, 255, 204));
		lblNewLabel_1.setText(numberFormat.format(CheckoutController.getCheckoutInstance().getamtafterDiscountAndLoyalty()));
		
		lblNewLabel_1.setBounds(259, 89, 61, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AMOUNT PAID : ");
		lblNewLabel_2.setForeground(new Color(255, 255, 204));
		lblNewLabel_2.setBounds(70, 138, 154, 23);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(253, 136, 96, 25);
		add(textField);
		textField.setColumns(10);
		
		   JButton cancelTransaction = new JButton("Cancel and Exit");
		    cancelTransaction_1 = new JButton("CANCEL");
		    cancelTransaction_1.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
			    		
		    			
			    		if(CheckoutPanel.memberscan != null && CheckoutPanel.memberscan.isVisible())
			    		{
			    		CheckoutPanel.memberscan.setVisible(false);
			    		}
			    		else if(CheckoutPanelNonMember.memberscan1 != null && CheckoutPanelNonMember.memberscan1.isVisible())
			    		{
			    			CheckoutPanelNonMember.memberscan1.setVisible(false);	
			    		}
			    	}
			    });
		    cancelTransaction_1.setIcon(new ImageIcon(FinalCheckOutSummary.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/close.png")));
		    cancelTransaction_1.setBounds(470, 159, 118, 36);
		    add(cancelTransaction_1);
		    
		    
		  
		    
		    
		    
		    
		    
			
			
		JButton commitTransaction = new JButton("Commit Transaction");
		commitTransaction_1 = new JButton("OK");
		commitTransaction_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textField.getText().toString().equals("") && 
						ValidationController.getValidationInstance().isDouble(textField.getText().toString()))
				{
					if(Double.parseDouble(textField.getText().toString())<CheckoutController.getCheckoutInstance().getamtafterDiscountAndLoyalty())
					{
						JOptionPane.showMessageDialog(null, "Amount given is less than amount payable","ERROR!",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						if(CheckoutController.getCheckoutInstance().getCheckoutMemberID().equals(""))
						{
							//non member checkout
							if(TransactionController.getTransanctionInstance().commitNonMemberTransaction(CheckoutController.getCheckoutInstance().getCheckoutItemsList()))
							{		    
							for(int i = 0; i<CheckoutController.getCheckoutInstance().getCheckoutItemsList().size();i++)
							{
								if(CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getQuantityAvailable()<CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getReorderQuantity())
								{
									builder.append("\n"+CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getProductId()+"-"+CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getProductName());
								}
							}
							if(!builder.toString().equals(""))
							{
								builder.append("\nare low on stock");
								JOptionPane.showMessageDialog(null, builder.toString(),"LOW STOCK",JOptionPane.ERROR_MESSAGE);
							}
							
							JLabel lblNewLabel_3 = new JLabel("TRANSACTION ID :");
						    lblNewLabel_3.setForeground(new Color(255, 255, 204));
						    lblNewLabel_3.setBounds(70, 235, 124, 25);
						    add(lblNewLabel_3);
						    
						    JButton btnNewButton = new JButton("CLOSE");
						    btnNewButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									CheckoutController.getCheckoutInstance().setApplyLoyalty(false);
									((Window) getRootPane().getParent()).dispose();
									
								}
							});
						    Image img1 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/close.png")).getImage();
						    btnNewButton.setIcon(new ImageIcon(img1));
						    btnNewButton.setBounds(280, 315, 124, 36);
						    add(btnNewButton);
						    
						    
						    JLabel lblNewLabel_4 = new JLabel("TRANSACTION SUCCESSFUL !!");
						    lblNewLabel_4.setIcon(new ImageIcon(FinalCheckOutSummary.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Thumbsup.png")));
						    lblNewLabel_4.setForeground(new Color(255, 255, 204));
						    lblNewLabel_4.setBounds(207, 260, 231, 51);
						    add(lblNewLabel_4);
						    
						    // print receipt
						    JButton btnNewButton_1 = new JButton("PRINT RECEIPT");
						    btnNewButton_1.addActionListener(new ActionListener() {
						    	public void actionPerformed(ActionEvent e) {
						    		printreceipt = new PrintReceipt();
									login.initializeWindow(printreceipt);
									printreceipt.setSize(853,533);
									printreceipt.setLocationRelativeTo(null);
						    	}
						    });
						    btnNewButton_1.setBounds(470, 268, 154, 36);
						    add(btnNewButton_1);
						    
						    JLabel lblNewLabel_5 = new JLabel("RETURN CHANGE :\t");
						    lblNewLabel_5.setForeground(new Color(255, 255, 204));
						    lblNewLabel_5.setBounds(70, 190, 124, 22);
						    add(lblNewLabel_5);
						    
						    JLabel lblNewLabel_6 = new JLabel("");
						    lblNewLabel_6.setForeground(new Color(255, 255, 204));
						    lblNewLabel_6.setBounds(253, 192, 61, 19);
						    changeReturned = Double.parseDouble(textField.getText().toString()) - CheckoutController.getCheckoutInstance().getamtafterDiscountAndLoyalty();
						    lblNewLabel_6.setText(String.valueOf(numberFormat.format(changeReturned)));
						    add(lblNewLabel_6);
						    
						    JLabel lblNewLabel_7 = new JLabel("");
						    lblNewLabel_7.setForeground(new Color(255, 255, 204));
						    lblNewLabel_7.setBounds(253, 236, 61, 23);
						    lblNewLabel_7.setText(String.valueOf(TransactionController.getTransanctionInstance().getNextTransactionID()-1));
						    add(lblNewLabel_7);
							
							
							
						 

							remove(commitTransaction_1);
							remove(cancelTransaction_1);
						    ((Window) getRootPane().getParent()).revalidate();
						    ((Window) getRootPane().getParent()).repaint();
							
							}
							else
							{
								JOptionPane.showMessageDialog(null, "TRANSACTION UNSUCCESSFUL!","ERROR!",JOptionPane.ERROR_MESSAGE);
								((Window) getRootPane().getParent()).dispose();
							}
						}
						else
						{
							//member checkout
							if(TransactionController.getTransanctionInstance().commitMemberTransaction(CheckoutController.getCheckoutInstance().getCheckoutItemsList(), CheckoutController.getCheckoutInstance().getCheckoutMemberID()))
									{
								for(int i = 0; i<CheckoutController.getCheckoutInstance().getCheckoutItemsList().size();i++)
								{
									if(CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getQuantityAvailable()<CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getReorderQuantity())
									{
										builder.append("\n"+CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getProductId()+"-"+CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getProductName());
									}
								}
								if(!builder.toString().equals(""))
								{
									builder.append("\nare low on stock");
									JOptionPane.showMessageDialog(null, builder.toString(),"LOW STOCK",JOptionPane.ERROR_MESSAGE);
								}
								JLabel lblNewLabel_3 = new JLabel("TRANSACTION ID :");
							    lblNewLabel_3.setForeground(new Color(255, 255, 204));
							    lblNewLabel_3.setBounds(70, 235, 124, 25);
							    add(lblNewLabel_3);
							    
							    JButton btnNewButton = new JButton("CLOSE");
							    btnNewButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										CheckoutController.getCheckoutInstance().setApplyLoyalty(false);
										((Window) getRootPane().getParent()).dispose();
									}
								});
							    Image img1 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/close.png")).getImage();
							    btnNewButton.setIcon(new ImageIcon(img1));
							    btnNewButton.setBounds(280, 315, 124, 36);
							    add(btnNewButton);
							    
							    JLabel lblNewLabel_4 = new JLabel("TRANSACTION SUCCESSFUL !!");
							    lblNewLabel_4.setIcon(new ImageIcon(FinalCheckOutSummary.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Thumbsup.png")));
							    lblNewLabel_4.setForeground(new Color(255, 255, 204));
							    lblNewLabel_4.setBounds(207, 260, 231, 51);
							    add(lblNewLabel_4);
							    
							 // printreceipt
							    JButton btnNewButton_1 = new JButton("PRINT RECEIPT");
							    btnNewButton_1.addActionListener(new ActionListener() {
							    	public void actionPerformed(ActionEvent e) {
							    		printreceipt = new PrintReceipt();
										login.initializeWindow(printreceipt);
										printreceipt.setSize(853,533);
										printreceipt.setLocationRelativeTo(null);
							    	}
							    });
							    btnNewButton_1.setBounds(470, 268, 154, 36);
							    add(btnNewButton_1);
								
								
							    
							    JLabel lblNewLabel_5 = new JLabel("RETURN CHANGE :\t");
							    lblNewLabel_5.setForeground(new Color(255, 255, 204));
							    lblNewLabel_5.setBounds(70, 190, 124, 22);
							    add(lblNewLabel_5);
							    
							    JLabel lblNewLabel_6 = new JLabel("");
							    lblNewLabel_6.setForeground(new Color(255, 255, 204));
							    lblNewLabel_6.setBounds(253, 192, 61, 19);
							    changeReturned = Double.parseDouble(textField.getText().toString()) - CheckoutController.getCheckoutInstance().getamtafterDiscountAndLoyalty();
							    lblNewLabel_6.setText(String.valueOf(numberFormat.format(changeReturned)));
							    add(lblNewLabel_6);
							    
							    JLabel lblNewLabel_7 = new JLabel("");
							    lblNewLabel_7.setForeground(new Color(255, 255, 204));
							    lblNewLabel_7.setBounds(253, 236, 61, 23);
							    lblNewLabel_7.setText(String.valueOf(TransactionController.getTransanctionInstance().getNextTransactionID()-1));
							    add(lblNewLabel_7);

							    remove(commitTransaction_1);
								remove(cancelTransaction_1);
							    
							    ((Window) getRootPane().getParent()).revalidate();

							    ((Window) getRootPane().getParent()).repaint();

									}
							else
							{
								JOptionPane.showMessageDialog(null, "TRANSACTION UNSUCCESSFUL!","ERROR!",JOptionPane.ERROR_MESSAGE);
								((Window) getRootPane().getParent()).dispose();
							}
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "CHECK THE DATA ENTERED!","ERROR!",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
	    commitTransaction_1.setIcon(new ImageIcon(FinalCheckOutSummary.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/ok.png")));
	    commitTransaction_1.setBounds(470, 111, 118, 36);
	    add(commitTransaction_1);
	    
	
	    
	   
	    
	 
	}
}
