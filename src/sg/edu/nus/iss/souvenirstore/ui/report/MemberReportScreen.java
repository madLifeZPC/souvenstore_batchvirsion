package sg.edu.nus.iss.souvenirstore.ui.report;
/*
 * Author : Rameswari Mohanty
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;

public class MemberReportScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private MemberReportList listPanel;

	/**
	 * Create the application.
	 */
	public MemberReportScreen() {

		createPanel();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createPanel() {
		frame = new JFrame("Member Details");
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
	    JLabel memberDetailsLabel = new JLabel("MEMBER DETAILS REPORT");
	    memberDetailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    memberDetailsLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    memberDetailsLabel.setForeground(Color.WHITE);
	    memberDetailsLabel.setBounds(175, 11, 315, 44);
	    mainPanel.add(memberDetailsLabel);
	    
	    //CREATE PANEL TO HOLD TABLE
	    JPanel tablePanel = new JPanel();
	    tablePanel.setForeground(Color.DARK_GRAY);
	    tablePanel.setBackground(Color.DARK_GRAY);
	    tablePanel.setBounds(31, 76, 628, 248);
	    mainPanel.add(tablePanel);
	    GridBagLayout gbl_tablePanel = new GridBagLayout();
	    gbl_tablePanel.columnWidths = new int[] {130};
	    gbl_tablePanel.rowHeights = new int[] {121};
	    gbl_tablePanel.columnWeights = new double[]{1.0};
	    gbl_tablePanel.rowWeights = new double[]{1.0};
	    tablePanel.setLayout(gbl_tablePanel);
	    frame.setVisible(true);
	    
	    listPanel = new MemberReportList();
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
		returnButton.setBounds(293, 384, 122, 44);
		mainPanel.add(returnButton);
		
		//RETURN BUTTON ACTION
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		//ADDING LEFT HEADER IMAGE
		JLabel memberImageLeft = new JLabel("");
		memberImageLeft.setBounds(175, 17, 62, 48);
		mainPanel.add(memberImageLeft);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/store.png")).getImage();
		memberImageLeft.setIcon(new ImageIcon(img2));
		
		//ADDING RIGHT HEADER IMAGE
		JLabel memberImageRight = new JLabel("");
		memberImageRight.setBounds(444, 17, 57, 48);
		mainPanel.add(memberImageRight);
		memberImageRight.setIcon(new ImageIcon(img2));
		
		JLabel lblTotalNoOf = new JLabel("TOTAL NO OF MEMBERS :");
		lblTotalNoOf.setForeground(Color.WHITE);
		lblTotalNoOf.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTotalNoOf.setBounds(163, 337, 210, 36);
		mainPanel.add(lblTotalNoOf);
		
		JLabel labelMemberCount = new JLabel("");
		labelMemberCount.setText(String.valueOf(listPanel.getMemberNumber()));
		labelMemberCount.setForeground(Color.WHITE);
		labelMemberCount.setFont(new Font("Times New Roman", Font.BOLD, 16));
		labelMemberCount.setBounds(383, 335, 46, 44);
		mainPanel.add(labelMemberCount);
 		
	}
}
