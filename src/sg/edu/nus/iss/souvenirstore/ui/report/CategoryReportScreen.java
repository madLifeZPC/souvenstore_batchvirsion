package sg.edu.nus.iss.souvenirstore.ui.report;
/*
 * Author : Rameswari Mohanty
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;

public class CategoryReportScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private CategoryReportList listPanel;
 
	/**
	 * Create the application.
	 */
	public CategoryReportScreen() {

		createPanel();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createPanel() {
		frame = new JFrame("Category Details");
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
	    JLabel categoryDetailsLabel = new JLabel("CATEGORY DETAILS");
	    categoryDetailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    categoryDetailsLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    categoryDetailsLabel.setForeground(Color.WHITE);
	    categoryDetailsLabel.setBounds(175, 11, 315, 44);
	    mainPanel.add(categoryDetailsLabel);
	    
	    //CREATE PANEL TO HOLD TABLE
	    JPanel tablePanel = new JPanel();
	    tablePanel.setForeground(Color.DARK_GRAY);
	    tablePanel.setBackground(Color.DARK_GRAY);
	    tablePanel.setBounds(31, 76, 628, 246);
	    mainPanel.add(tablePanel);
	    GridBagLayout gbl_tablePanel = new GridBagLayout();
	    gbl_tablePanel.columnWidths = new int[] {130};
	    gbl_tablePanel.rowHeights = new int[] {121};
	    gbl_tablePanel.columnWeights = new double[]{1.0};
	    gbl_tablePanel.rowWeights = new double[]{1.0};
	    tablePanel.setLayout(gbl_tablePanel);
	    frame.setVisible(true);
	    
	    listPanel = new CategoryReportList();
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
		returnButton.setBounds(289, 387, 122, 44);
		mainPanel.add(returnButton);
		
		//RETURN BUTTON ACTION
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		//ADDING LEFT HEADER IMAGE
		JLabel categoryImageLeft = new JLabel("");
		categoryImageLeft.setBounds(175, 17, 62, 48);
		mainPanel.add(categoryImageLeft);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Category.png")).getImage();
		categoryImageLeft.setIcon(new ImageIcon(img2));
		
		//ADDING RIGHT HEADER IMAGE
		JLabel categoryImageRight = new JLabel("");
		categoryImageRight.setBounds(444, 17, 57, 48);
		mainPanel.add(categoryImageRight);
		categoryImageRight.setIcon(new ImageIcon(img2));
		
		JLabel lblTotalCategory = new JLabel("TOTAL NO OF CATEGORY :");
		lblTotalCategory.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTotalCategory.setForeground(Color.WHITE);
		lblTotalCategory.setBounds(171, 333, 210, 43);
		mainPanel.add(lblTotalCategory);
		
		JLabel labelCategoryCount = new JLabel("");
		labelCategoryCount.setText(String.valueOf(listPanel.getCategoryNumber()));
		labelCategoryCount.setFont(new Font("Times New Roman", Font.BOLD, 16));
		labelCategoryCount.setForeground(Color.WHITE);
		labelCategoryCount.setBounds(391, 333, 46, 43);
		mainPanel.add(labelCategoryCount);
 
	}
}
