package sg.edu.nus.iss.souvenirstore.ui.category;
/*
 * Author : Rameswari Mohanty
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;

public class CategoryMainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private CategoryListPanel listPanel;
    private AddCategoryScreen addScreen;
	/**
	 * Create the application.
	 */
	public CategoryMainWindow() {

		createPanel();
		ImageIcon imageIcon = new ImageIcon(StoreFrame.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		setIconImage(imageIcon.getImage());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createPanel() {

		//CREATE MAIN FRAME PANEL
		setTitle("Category Details");
	    JPanel mainScreenPanel = new JPanel();
	    mainScreenPanel.setBackground(Color.DARK_GRAY);
	    mainScreenPanel.setBounds(0, 0, 684, 478);
	    getContentPane().add(mainScreenPanel);
	    mainScreenPanel.setLayout(null);
	    
	    //CREATE HEADER LABEL
	    JLabel categoryDetails = new JLabel("CATEGORY DETAILS");
	    categoryDetails.setHorizontalAlignment(SwingConstants.CENTER);
	    categoryDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    categoryDetails.setForeground(Color.WHITE);
	    categoryDetails.setBounds(175, 11, 315, 44);
	    mainScreenPanel.add(categoryDetails);
	    
	    //CREATE PANEL TABLE
	    JPanel categoryTablePanel = new JPanel();
	    categoryTablePanel.setForeground(Color.DARK_GRAY);
	    categoryTablePanel.setBackground(Color.DARK_GRAY);
	    categoryTablePanel.setBounds(31, 76, 628, 282);
	    mainScreenPanel.add(categoryTablePanel);

	    setVisible(true);
	    GridBagLayout gbl_categoryTablePanel = new GridBagLayout();
	    gbl_categoryTablePanel.columnWidths = new int[]{571, 0};
	    gbl_categoryTablePanel.rowHeights = new int[]{176, 0};
	    gbl_categoryTablePanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
	    gbl_categoryTablePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	    categoryTablePanel.setLayout(gbl_categoryTablePanel);
	    
	    listPanel = new CategoryListPanel();
	    GridBagConstraints gbc_listPanel = new GridBagConstraints();
	    gbc_listPanel.anchor = GridBagConstraints.NORTHWEST;
	    gbc_listPanel.gridx = 0;
	    gbc_listPanel.gridy = 0;
	    categoryTablePanel.add(listPanel, gbc_listPanel);
		
		//CREATE ADD CATEGORY BUTTON
		JButton addCategoryButton = new JButton("Add Category");
		addCategoryButton.setForeground(Color.BLACK);
		addCategoryButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		addCategoryButton.setBackground(new Color(255, 215, 0));
		Image img = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/add.png")).getImage();
		addCategoryButton.setIcon(new ImageIcon(img));
		addCategoryButton.setBounds(108, 384, 174, 44);
		mainScreenPanel.add(addCategoryButton);
		
		//ADD CATEGORY BUTTON ACTION
		addCategoryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					addScreen = new AddCategoryScreen();
					addScreen.setLocationByPlatform(true);
					addScreen.pack();
					addScreen.setVisible(true);
					addScreen.setBounds(400, 200, 550, 500);
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
		returnButton.setBounds(427, 384, 122, 44);
		mainScreenPanel.add(returnButton);
		
		//ADD HEADER IMAGE LEFT
		JLabel categoryIconLeft = new JLabel("");
		categoryIconLeft.setBounds(175, 17, 62, 48);
		mainScreenPanel.add(categoryIconLeft);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Category.png")).getImage();
		categoryIconLeft.setIcon(new ImageIcon(img2));
		
		//ADD HEADER IMAGE RIGHT
		JLabel categoryIconRight = new JLabel("");
		categoryIconRight.setBounds(444, 17, 57, 48);
		mainScreenPanel.add(categoryIconRight);
		categoryIconRight.setIcon(new ImageIcon(img2));
 
		
	}
}
