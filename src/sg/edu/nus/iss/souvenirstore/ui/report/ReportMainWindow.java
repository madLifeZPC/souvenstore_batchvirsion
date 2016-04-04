package sg.edu.nus.iss.souvenirstore.ui.report;
/*
 * Author : Rameswari Mohanty
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sg.edu.nus.iss.souvenirstore.ui.category.AddCategoryScreen;
import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;


public class ReportMainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private ProductReportScreen addProductScreen;
	private MemberReportScreen addMemberScreen;
	private TransactionReportScreen addtransactionScreen;
	private CategoryReportScreen addcategoryScreen;

	/**
	 * Create the application.
	 */
	public ReportMainWindow() {

		createPanel();
		ImageIcon imageIcon = new ImageIcon(StoreFrame.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		setIconImage(imageIcon.getImage());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createPanel() {

		//CREATE MAIN FRAME PANEL
		setTitle("Report");//Vrinda
	    JPanel reportMainPanel = new JPanel();
	    reportMainPanel.setBackground(Color.DARK_GRAY);
	    reportMainPanel.setBounds(0, 0, 684, 478);
	    reportMainPanel.setLayout(null);
	    getContentPane().add(reportMainPanel);//Vrinda
	    
	    //CREATE HEADER LABEL
	    JLabel headingDiscountDetails = new JLabel("STORE REPORT GENERATION SYSTEM");
	    headingDiscountDetails.setHorizontalAlignment(SwingConstants.CENTER);
	    headingDiscountDetails.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    headingDiscountDetails.setForeground(Color.WHITE);
	    headingDiscountDetails.setBounds(386, 11, 315, 44);
	    reportMainPanel.add(headingDiscountDetails);
	    
	    //CREATE PANEL FOR BUTTON
	    JPanel buttonsPanel = new JPanel();
	    buttonsPanel.setForeground(Color.DARK_GRAY);
	    buttonsPanel.setBackground(Color.DARK_GRAY);
	    buttonsPanel.setBounds(10, 66, 1074, 292);
	    reportMainPanel.add(buttonsPanel);
	    buttonsPanel.setLayout(null);
	    
	    // ADD CATEGORY IMAGE
	    JLabel categoryImage = new JLabel("");
	    categoryImage.setBounds(21, 0, 205, 196);
	    buttonsPanel.add(categoryImage);
		Image img3 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/category-report.jpg")).getImage();
		categoryImage.setIcon(new ImageIcon(img3));
		
		// ADD PRODUCT IMAGE
		JLabel productImage = new JLabel("");
		productImage.setBounds(257, 0, 243, 197);
		buttonsPanel.add(productImage);
		Image img4 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/product-report.png")).getImage();
		productImage.setIcon(new ImageIcon(img4));
		
		// ADD TRANSACTION IMAGE
		JLabel transactionImage = new JLabel("");
		transactionImage.setBounds(530, 0, 237, 196);
		buttonsPanel.add(transactionImage);
		Image img6 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/transaction-report.jpg")).getImage();
		transactionImage.setIcon(new ImageIcon(img6));
		
		// ADD MEMBER IMAGE
		JLabel memberImage = new JLabel("");
		memberImage.setBounds(814, 0, 243, 196);
		buttonsPanel.add(memberImage);
		Image img5 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/member-report.jpg")).getImage();
		memberImage.setIcon(new ImageIcon(img5));
		
		//CREATING CATEGORY BUTTON
		JButton categoryButton = new JButton(" CATEGORY");
		categoryButton.setBounds(30, 219, 174, 44);
		buttonsPanel.add(categoryButton);
		categoryButton.setForeground(Color.BLACK);
		categoryButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		categoryButton.setBackground(new Color(255, 215, 0));
		Image img = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/report_button.png")).getImage();
		categoryButton.setIcon(new ImageIcon(img));
		
		//CATEGORY BUTTON ACTION
		categoryButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {			
			addcategoryScreen = new CategoryReportScreen();
			addcategoryScreen.setLocationByPlatform(true);
			addcategoryScreen.pack();
			addcategoryScreen.setBounds(400, 200, 550, 500);			
		    }
  	    });
				
		//CREATING PRODUCT BUTTON 		
		JButton productButton = new JButton("  PRODUCT");
		productButton.setForeground(Color.BLACK);
		productButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		productButton.setBackground(new Color(255, 215, 0));
		productButton.setBounds(277, 219, 174, 44);
		productButton.setIcon(new ImageIcon(img));
		buttonsPanel.add(productButton);

		//PRODUCT BUTTON ACTION
		productButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {		
			addProductScreen = new ProductReportScreen();
			addProductScreen.setLocationByPlatform(true);
			addProductScreen.pack();
			addProductScreen.setBounds(400, 200, 550, 500);		
		    }
		});
		
		//CREATING TRANSACTION BUTTON
		JButton transactionButton = new JButton("  TRANSACTION");
		transactionButton.setForeground(Color.BLACK);
		transactionButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		transactionButton.setBackground(new Color(255, 215, 0));
		transactionButton.setBounds(562, 219, 174, 44);
		transactionButton.setIcon(new ImageIcon(img));
		buttonsPanel.add(transactionButton);
		
		//TRANSACTION BUTTON ACTION		
		transactionButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	
			EventQueue.invokeLater(new Runnable() {
				
				@Override
				public void run() {
				  addtransactionScreen = new TransactionReportScreen();
			      addtransactionScreen.setLocationByPlatform(true);
			      addtransactionScreen.pack();
			      addtransactionScreen.setBounds(400, 200, 550, 500);	
				}
			});
		
			}
		});
		
		//CREATING MEMBER BUTTON		
		JButton memberButton = new JButton("  MEMBER");
		memberButton.setForeground(Color.BLACK);
		memberButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		memberButton.setBackground(new Color(255, 215, 0));
		memberButton.setBounds(844, 219, 174, 44);
		memberButton.setIcon(new ImageIcon(img));
		buttonsPanel.add(memberButton);
		setVisible(true);
		
		//MEMBER BUTTON ACTION
		memberButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {					
			addMemberScreen = new MemberReportScreen();
			addMemberScreen.setLocationByPlatform(true);
			addMemberScreen.pack();
			addMemberScreen.setBounds(400, 200, 550, 500);						
			}
		});

		//CREATING RETURN BUTTON 
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Window) getRootPane().getParent()).dispose();
			}
		});
		returnButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		returnButton.setBackground(new Color(255, 215, 0));
		returnButton.setForeground(Color.BLACK);
		Image img1 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/back.png")).getImage();
		returnButton.setIcon(new ImageIcon(img1));
		returnButton.setBounds(449, 376, 122, 44);
		reportMainPanel.add(returnButton);	
	}
}
