package sg.edu.nus.iss.souvenirstore.ui.category;
/*
 * Author : Rameswari Mohanty
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;

public class vendorDetailsScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private String categoryCode;
	private VendorListPanel listPanel;
    private AddVendorScreen addScreen;

	/**
	 * Create the application.
	 */
	public vendorDetailsScreen(String categoryCode) {
		this.categoryCode = categoryCode;
		createPanel();
		ImageIcon imageIcon = new ImageIcon(StoreFrame.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		setIconImage(imageIcon.getImage());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createPanel() {
		setTitle("Category Details");
		setBounds(300, 150, 700, 500);
			    
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.DARK_GRAY);
	    panel.setBounds(0, 0, 684, 478);
	    getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    JLabel lblDiscountDetails = new JLabel("VENDOR DETAILS");
	    lblDiscountDetails.setHorizontalAlignment(SwingConstants.CENTER);
	    lblDiscountDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    lblDiscountDetails.setForeground(Color.WHITE);
	    lblDiscountDetails.setBounds(175, 11, 315, 44);
	    panel.add(lblDiscountDetails);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setForeground(Color.DARK_GRAY);
	    panel_1.setBackground(Color.DARK_GRAY);
	    panel_1.setBounds(31, 76, 628, 282);
	    panel.add(panel_1);
	    GridBagLayout gbl_panel_1 = new GridBagLayout();
	    gbl_panel_1.columnWidths = new int[] {130};
	    gbl_panel_1.rowHeights = new int[] {121};
	    gbl_panel_1.columnWeights = new double[]{1.0};
	    gbl_panel_1.rowWeights = new double[]{1.0};
	    panel_1.setLayout(gbl_panel_1);
	    setVisible(true);
	    
	    listPanel = new VendorListPanel(categoryCode);
		GridBagConstraints gbc_listPanel = new GridBagConstraints();
		gbc_listPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_listPanel.gridy = 0;
		gbc_listPanel.gridx = 0;
	    panel_1.add(listPanel, gbc_listPanel);
		
		//Creating ADD DISCOUNT Button
		JButton btnNewButton = new JButton("Add Vendor");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(255, 215, 0));
		Image img = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/add.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setBounds(108, 384, 174, 44);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					addScreen = new AddVendorScreen(categoryCode);
					addScreen.setLocationByPlatform(true);
					addScreen.pack();
					addScreen.setVisible(true);
					addScreen.setBounds(400, 200, 550, 500);
					
			}
		});

		//Creating RETURN Button
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(255, 215, 0));
		btnNewButton_1.setForeground(Color.BLACK);
		Image img1 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/back.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.setBounds(427, 384, 122, 44);
		panel.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Window) getRootPane().getParent()).dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(175, 17, 62, 48);
		panel.add(lblNewLabel);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Vendor.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(444, 17, 57, 48);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(img2));
	}
}
