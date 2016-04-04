package sg.edu.nus.iss.souvenirstore.ui.member;
/*
 * Author : Rameswari Mohanty
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;

public class MemberMainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private MemberListPanel listPanel;
	private AddMemberScreen addScreen;

	/**
	 * Create the application.
	 */
	public MemberMainWindow() {

		createPanel();
		ImageIcon imageIcon = new ImageIcon(StoreFrame.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		setIconImage(imageIcon.getImage());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createPanel() {

		//CREATE MAIN FRAME PANEL
		setTitle("Member Details");
	    JPanel mainPanel = new JPanel();
	    mainPanel.setBackground(Color.DARK_GRAY);
	    mainPanel.setBounds(0, 0, 684, 478);
	    getContentPane().add(mainPanel);
	    mainPanel.setLayout(null);
	    
	    //CREATE HEADER LABEL
	    JLabel memberDetailsLable = new JLabel("MEMBER DETAILS");
	    memberDetailsLable.setHorizontalAlignment(SwingConstants.CENTER);
	    memberDetailsLable.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    memberDetailsLable.setForeground(Color.WHITE);
	    memberDetailsLable.setBounds(175, 11, 315, 44);
	    mainPanel.add(memberDetailsLable);
	    
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
	    
	    listPanel = new MemberListPanel();
		GridBagConstraints gbc_listPanel = new GridBagConstraints();
		gbc_listPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_listPanel.gridy = 0;
		gbc_listPanel.gridx = 0;
		tablePanel.add(listPanel, gbc_listPanel);
		
		//CREATE ADD MEMBER BUTTON
		JButton addMemberButton = new JButton("Add Member");
		addMemberButton.setForeground(Color.BLACK);
		addMemberButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		addMemberButton.setBackground(new Color(255, 215, 0));
		Image img = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/add.png")).getImage();
		addMemberButton.setIcon(new ImageIcon(img));
		addMemberButton.setBounds(108, 384, 174, 44);
		mainPanel.add(addMemberButton);
		
		//ADD MEMBER BUTTON ACTION
		addMemberButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					addScreen = new AddMemberScreen();
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
		mainPanel.add(returnButton);
		
		//ADD HEADER IMAGE LEFT
		JLabel memberImageLeft = new JLabel("");
		memberImageLeft.setBounds(175, 17, 62, 48);
		mainPanel.add(memberImageLeft);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/store.png")).getImage();
		memberImageLeft.setIcon(new ImageIcon(img2));
		
		//ADD HEADER IMAGE RIGHT
		JLabel memberImageRight = new JLabel("");
		memberImageRight.setBounds(444, 17, 57, 48);
		mainPanel.add(memberImageRight);
		memberImageRight.setIcon(new ImageIcon(img2));

	}
}
