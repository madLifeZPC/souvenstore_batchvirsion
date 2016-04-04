package sg.edu.nus.iss.souvenirstore.ui.report;
/*
 * Author : Rameswari Mohanty
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;

public class ProductReportScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private ProductReportList listPanel;
	
	/**
	 * Create the application.
	 */
	public ProductReportScreen() {

		createPanel();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createPanel() {
		frame = new JFrame("Product Details");
		frame.setBounds(300, 150, 700, 500);
		ImageIcon imageIcon = new ImageIcon(StoreFrame.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		frame.setIconImage(imageIcon.getImage());
		
		//CREATE MAIN FRAME PANEL
	    JPanel mainPanel = new JPanel();
	    mainPanel.setBackground(Color.DARK_GRAY);
	    mainPanel.setBounds(0, 0, 684, 478);
	    frame.getContentPane().add(mainPanel);
	    mainPanel.setLayout(null);
	    
	    //CREATE HEADER LABEL
	    JLabel productDetailsLable = new JLabel("PRODUCT DETAILS  REPORT");
	    productDetailsLable.setHorizontalAlignment(SwingConstants.CENTER);
	    productDetailsLable.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    productDetailsLable.setForeground(Color.WHITE);
	    productDetailsLable.setBounds(175, 11, 315, 44);
	    mainPanel.add(productDetailsLable);
	    
	    //CREATE PANEL TO HOLD TABLE
	    JPanel tablePanel = new JPanel();
	    tablePanel.setForeground(Color.DARK_GRAY);
	    tablePanel.setBackground(Color.DARK_GRAY);
	    tablePanel.setBounds(31, 76, 628, 245);
	    mainPanel.add(tablePanel);
	    GridBagLayout gbl_tablePanel = new GridBagLayout();
	    gbl_tablePanel.columnWidths = new int[] {130};
	    gbl_tablePanel.rowHeights = new int[] {121};
	    gbl_tablePanel.columnWeights = new double[]{1.0};
	    gbl_tablePanel.rowWeights = new double[]{1.0};
	    tablePanel.setLayout(gbl_tablePanel);
	    frame.setVisible(true);
	    
        listPanel = new ProductReportList();
		GridBagConstraints gbc_listPanel = new GridBagConstraints();
		gbc_listPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_listPanel.gridy = 0;
		gbc_listPanel.gridx = 0;
		tablePanel.add(listPanel, gbc_listPanel);
		
		//CREATE RETURN BUTTON
		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		returnButton.setBackground(new Color(255, 215, 0));
		returnButton.setForeground(Color.BLACK);
		Image img1 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/back.png")).getImage();
		returnButton.setIcon(new ImageIcon(img1));
		returnButton.setBounds(288, 384, 122, 44);
		mainPanel.add(returnButton);
		
		//RETURN BUTTON ACTION
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		//ADDING LEFT HEADER IMAGE
		JLabel productImageLeft = new JLabel("");
		productImageLeft.setBounds(175, 17, 46, 48);
		mainPanel.add(productImageLeft);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/product-add.png")).getImage();
		productImageLeft.setIcon(new ImageIcon(img2));
		
		//ADDING RIGHT HEADER IMAGE
		JLabel productImageRight = new JLabel("");
		productImageRight.setBounds(444, 17, 46, 48);
		mainPanel.add(productImageRight);
		productImageRight.setIcon(new ImageIcon(img2));
		
		JLabel lblTotalNoOf = new JLabel("TOTAL NO OF PRODUCT :");
		lblTotalNoOf.setForeground(Color.WHITE);
		lblTotalNoOf.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTotalNoOf.setBounds(168, 337, 210, 36);
		mainPanel.add(lblTotalNoOf);
		
		JLabel labelProductCount = new JLabel("");
		labelProductCount.setText(String.valueOf(listPanel.getProductNumber()));
		labelProductCount.setForeground(Color.WHITE);
		labelProductCount.setFont(new Font("Times New Roman", Font.BOLD, 16));
		labelProductCount.setBounds(388, 342, 46, 26);
		mainPanel.add(labelProductCount);
		
	}
}
