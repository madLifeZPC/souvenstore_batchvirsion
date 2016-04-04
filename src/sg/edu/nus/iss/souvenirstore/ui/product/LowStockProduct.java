package sg.edu.nus.iss.souvenirstore.ui.product;
/*
 * Author : Rameswari Mohanty
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;

public class LowStockProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private LowStockListPanel listPanel;

	/**
	 * Create the application.
	 */
	public LowStockProduct() {

		createPanel();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createPanel() {
		frame = new JFrame("Low Stock Detail");
		ImageIcon imageIcon = new ImageIcon(LowStockProduct.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		frame.setIconImage(imageIcon.getImage());
		frame.setBounds(300, 150, 700, 500);

		//CREATE MAIN FRAME PANEL
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.DARK_GRAY);
	    panel.setBounds(0, 0, 684, 478);
	    frame.getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    //CREATE HEADER LABEL
	    JLabel lblDiscountDetails = new JLabel("LOW STOCK PRODUCT DETAILS");
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
	    frame.setVisible(true);
	    
	    listPanel = new LowStockListPanel();
		GridBagConstraints gbc_listPanel = new GridBagConstraints();
		gbc_listPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_listPanel.gridy = 0;
		gbc_listPanel.gridx = 0;
		panel_1.add(listPanel, gbc_listPanel);
		
		//CREATE PLACE ORDER BUTTON
		JButton btnNewButton = new JButton("Place Order");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(255, 215, 0));
		Image img = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/add.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setBounds(206, 384, 192, 44);
		panel.add(btnNewButton);
	
		//ADD HEADER IMAGE LEFT
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(175, 17, 46, 48);
		panel.add(lblNewLabel);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/lowstock.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		
		//ADD HEADER IMAGE RIGHT
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(444, 17, 46, 48);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		
		//CREATE RETURN BUTTON
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(new Color(255, 215, 0));
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cancelButton.setBounds(458, 384, 132, 44);
		panel.add(cancelButton);
		Image img4 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/close.png")).getImage();
		cancelButton.setIcon(new ImageIcon(img4));
		
		//ADD CANCEL BUTTON ACTION
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}
