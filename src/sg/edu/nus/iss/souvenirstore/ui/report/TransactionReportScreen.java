package sg.edu.nus.iss.souvenirstore.ui.report;
/*
 * Author : Rameswari Mohanty
 */


import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import sg.edu.nus.iss.souvenirstore.ui.discount.*;
import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;
public class TransactionReportScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private TransactionReportList listPanel;
	private JFormattedTextField startDateField;
	private JFormattedTextField endDateField;
	private JPanel tablePanel;
	/**
	 * Create the application.
	 */
	public TransactionReportScreen() {

		createPanel();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createPanel() {
		frame = new JFrame("Transaction Details");
		frame.setBounds(300, 150, 700, 500);
		ImageIcon imageIcon = new ImageIcon(StoreFrame.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		frame.setIconImage(imageIcon.getImage());
		
		//CREATE MAIN FRAME PANEL
	    JPanel mainPanel = new JPanel();
	    mainPanel.setBackground(Color.DARK_GRAY);
	    mainPanel.setBounds(0, 0, 684, 478);
	    frame.add(mainPanel);
	    mainPanel.setLayout(null);
	    
	    //CREATE HEADER LABEL
	    JLabel transactionDetailsLabel = new JLabel("TRANSACTION DETAILS REPORT");
	    transactionDetailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    transactionDetailsLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    transactionDetailsLabel.setForeground(Color.WHITE);
	    transactionDetailsLabel.setBounds(175, 11, 315, 44);
	    mainPanel.add(transactionDetailsLabel);
		
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
		JLabel transactionImageLeft = new JLabel("");
		transactionImageLeft.setForeground(Color.WHITE);
		transactionImageLeft.setBackground(Color.WHITE);
		transactionImageLeft.setBounds(148, 17, 62, 48);
		mainPanel.add(transactionImageLeft);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/card-transact2.png")).getImage();
		transactionImageLeft.setIcon(new ImageIcon(img2));
		
		//ADDING RIGHT HEADER IMAGE
		JLabel transactionImageRight = new JLabel("");
		transactionImageRight.setBounds(457, 11, 57, 48);
		mainPanel.add(transactionImageRight);
		transactionImageRight.setIcon(new ImageIcon(img2));
		
		//ADDING LABEL ENTER TRANSACTION PERIOD
		JLabel transactionPeriodLabel = new JLabel("ENTER TRANSACTION PERIOD");
		transactionPeriodLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transactionPeriodLabel.setForeground(Color.WHITE);
		transactionPeriodLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		transactionPeriodLabel.setBounds(10, 65, 315, 44);
		mainPanel.add(transactionPeriodLabel);
		
		//ADDING LABEL START DATE
		JLabel startDateLabel = new JLabel("START DATE");
		startDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		startDateLabel.setForeground(Color.WHITE);
		startDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		startDateLabel.setBounds(31, 105, 161, 44);
		mainPanel.add(startDateLabel);
		
		//ADDING LABEL END DATE
		JLabel endDateLabel = new JLabel("END DATE");
		endDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		endDateLabel.setForeground(Color.WHITE);
		endDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		endDateLabel.setBounds(281, 105, 161, 44);
		mainPanel.add(endDateLabel);
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		//ADDING TEXTBOX TO ACCEPT START DATE
		startDateField = new JFormattedTextField(sf);
		startDateField.setBounds(175, 105, 133, 35);
		startDateField.setEditable(false);
		startDateField.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame();
				startDateField.setText(new DatePicker(frame).setPickedDate());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mainPanel.add(startDateField);
		startDateField.setColumns(10);
		
		//ADDING TEXTBOX TO ACCEPT END DATE
		endDateField = new JFormattedTextField(sf);
		endDateField.setColumns(10);
		endDateField.setBounds(412, 105, 142, 35);
		endDateField.setEditable(false);
		endDateField.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
				JFrame frame = new JFrame();
				endDateField.setText(new DatePicker(frame).setPickedDate());
			}
		});
	
		mainPanel.add(endDateField);
		
		
		JButton btnok = new JButton("OK");
		btnok.setBackground(Color.ORANGE);
		btnok.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnok.setBounds(583, 105, 76, 34);
		mainPanel.add(btnok);
		btnok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			    //CREATE PANEL TO HOLD TABLE
				if(startDateField.getText().toString().equals("")||endDateField.getText().toString().equals(""))
				{
					JOptionPane.showMessageDialog(null, "INVALID DATE!","ERROR!",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(tablePanel!=null){ tablePanel.remove(listPanel); mainPanel.remove(tablePanel);   }
					tablePanel = new JPanel();
				    tablePanel.setForeground(Color.DARK_GRAY);
				    tablePanel.setBackground(Color.DARK_GRAY);
				    tablePanel.setBounds(31, 150, 628, 208);
				    mainPanel.add(tablePanel);
				    GridBagLayout gbl_tablePanel = new GridBagLayout();
				    gbl_tablePanel.columnWidths = new int[] {130};
				    gbl_tablePanel.rowHeights = new int[] {121};
				    gbl_tablePanel.columnWeights = new double[]{1.0};
				    gbl_tablePanel.rowWeights = new double[]{1.0};
				    tablePanel.setLayout(gbl_tablePanel);
					listPanel = new TransactionReportList(startDateField.getText().toString(),endDateField.getText().toString());
				    GridBagConstraints gbc_listPanel = new GridBagConstraints();
				    gbc_listPanel.anchor = GridBagConstraints.NORTHWEST;
				    gbc_listPanel.gridy = 0;
				    gbc_listPanel.gridx = 0;
				    tablePanel.add(listPanel, gbc_listPanel);
				    mainPanel.revalidate();
				    mainPanel.repaint();
				    new Thread(new Runnable() {
						@Override
						public void run() {
							
							try
							{
								Thread.sleep(10);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							frame.revalidate();
							frame.repaint();
						    frame.validate();
						    
						}
					});
				    frame.revalidate();
				}

			}
		});

	    frame.setVisible(true);
		
	}
}
