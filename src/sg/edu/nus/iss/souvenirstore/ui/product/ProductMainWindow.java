package sg.edu.nus.iss.souvenirstore.ui.product;
/*
 * Author : Rameswari Mohanty
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;

public class ProductMainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private ProductListPanel listPanel;
	private AddProductScreen addScreen;
	private LowStockProduct lowStock;

	/**
	 * Create the application.
	 */
	public ProductMainWindow() {

		createPanel();
		ImageIcon imageIcon = new ImageIcon(StoreFrame.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		setIconImage(imageIcon.getImage());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createPanel() {
		
		//CREATE MAIN FRAME PANEL
		setTitle("Product Details");
	    JPanel mainPanel = new JPanel();
	    mainPanel.setBackground(Color.DARK_GRAY);
	    mainPanel.setBounds(0, 0, 684, 478);
	    getContentPane().add(mainPanel);
	    mainPanel.setLayout(null);
	    
	    //CREATE HEADER LABEL
	    JLabel productDetailsLabel = new JLabel("PRODUCT DETAILS");
	    productDetailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    productDetailsLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    productDetailsLabel.setForeground(Color.WHITE);
	    productDetailsLabel.setBounds(175, 11, 315, 44);
	    mainPanel.add(productDetailsLabel);
	    
	    //CREATE PANEL TABLE 
	    JPanel tablePanel = new JPanel();
	    tablePanel.setForeground(Color.DARK_GRAY);
	    tablePanel.setBackground(Color.DARK_GRAY);
	    tablePanel.setBounds(31, 76, 628, 282);
	    mainPanel.add(tablePanel);
	    GridBagLayout gbl_tablePanel = new GridBagLayout();
	    gbl_tablePanel.columnWidths = new int[] {130};
	    gbl_tablePanel.rowHeights = new int[] {121};
	    gbl_tablePanel.columnWeights = new double[]{1.0};
	    gbl_tablePanel.rowWeights = new double[]{1.0};
	    tablePanel.setLayout(gbl_tablePanel);
	    setVisible(true);
	    
	    listPanel = new ProductListPanel();
		GridBagConstraints gbc_listPanel = new GridBagConstraints();
		gbc_listPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_listPanel.gridy = 0;
		gbc_listPanel.gridx = 0;
		tablePanel.add(listPanel, gbc_listPanel);
		
		//CREATE ADD PRODUCT BUTTON
		JButton addProductButton = new JButton("Add Product");
		addProductButton.setForeground(Color.BLACK);
		addProductButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		addProductButton.setBackground(new Color(255, 215, 0));
		Image img = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/add.png")).getImage();
		addProductButton.setIcon(new ImageIcon(img));
		addProductButton.setBounds(72, 384, 192, 44);
		mainPanel.add(addProductButton);
		
		//ADD DISCOUNT BUTTON ACTION
		addProductButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					addScreen = new AddProductScreen();
					addScreen.setLocationByPlatform(true);
					addScreen.pack();
					addScreen.setVisible(true);
					addScreen.setBounds(400, 100, 550, 600);	
			}
		});

		//CREATE RETURN BUTTON
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
		returnButton.setBounds(524, 384, 122, 44);
		mainPanel.add(returnButton);
		
		//ADD HEADER IMAGE LEFT
		JLabel headerImageLeft = new JLabel("");
		headerImageLeft.setBounds(175, 17, 46, 48);
		mainPanel.add(headerImageLeft);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/product-add.png")).getImage();
		headerImageLeft.setIcon(new ImageIcon(img2));
		
		//ADD HEADER IMAGE RIGHT
		JLabel headerImageRight = new JLabel("");
		headerImageRight.setBounds(444, 17, 46, 48);
		mainPanel.add(headerImageRight);
		headerImageRight.setIcon(new ImageIcon(img2));
		
		//CREATE LOW STOCK PRODUCT BUTTON
		JButton lowStockProductButton = new JButton("Low Stock Product");
		lowStockProductButton.setForeground(Color.BLACK);
		lowStockProductButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lowStockProductButton.setBackground(new Color(255, 215, 0));
		Image img3 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/lowstock.png")).getImage();
		lowStockProductButton.setIcon(new ImageIcon(img3));
		lowStockProductButton.setBounds(289, 384, 201, 44);
		mainPanel.add(lowStockProductButton);
		
		//ADD LOW STOCK PRODUCT BUTTON ACTION
		lowStockProductButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				lowStock = new LowStockProduct();
				lowStock.setLocationByPlatform(true);
				lowStock.pack();
				lowStock.setBounds(300, 150, 700, 500);
				lowStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
			}
		});
	}
}
