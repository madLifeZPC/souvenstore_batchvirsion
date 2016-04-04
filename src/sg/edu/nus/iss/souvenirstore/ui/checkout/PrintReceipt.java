package sg.edu.nus.iss.souvenirstore.ui.checkout;
/**
 * Print transaction receipt
 * Author : Vrinda
 */

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;

import sg.edu.nus.iss.souvenirstore.controller.CheckoutController;
import sg.edu.nus.iss.souvenirstore.controller.TransactionController;
import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;


public class PrintReceipt extends JFrame {

	private static final long serialVersionUID = 1L;
private JTable prodTable,summaryTable;
private Object[][] prodData;
private String[] colNames = {"Barcode","ProductID","Product","Qty","Price"};



	/**
	 * Create the application.
	 */
	public PrintReceipt() {

		createPanel();
		ImageIcon imageIcon = new ImageIcon(StoreFrame.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		setIconImage(imageIcon.getImage());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createPanel() {
		
			    
	    JPanel panel = new JPanel();
	    setTitle("RECEIPT");
	    panel.setBackground(Color.DARK_GRAY);
	    panel.setBounds(0, 0, 853,533);
	    getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    JLabel lblDiscountDetails = new JLabel("RECEIPT");
	    lblDiscountDetails.setBounds(270, 30, 315, 44);
	    lblDiscountDetails.setHorizontalAlignment(SwingConstants.CENTER);
	    lblDiscountDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    lblDiscountDetails.setForeground(new Color(255, 255, 204));
	    panel.add(lblDiscountDetails);
	    setVisible(true);
		

		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.setBounds(362, 432, 122, 44);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Window) getRootPane().getParent()).dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(255, 215, 0));
		btnNewButton_1.setForeground(Color.BLACK);
		Image img1 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/close.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		panel.add(btnNewButton_1);
		
		JLabel lblDate = new JLabel("DATE :");
		lblDate.setBounds(45, 83, 61, 14);
		lblDate.setForeground(new Color(255, 255, 204));
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(lblDate);
		
		JLabel lblReceiptDate = new JLabel("");
		lblReceiptDate.setBounds(104, 83, 136, 14);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		lblReceiptDate.setText(sf.format(new Date()));
		lblReceiptDate.setForeground(new Color(255, 255, 204));
		panel.add(lblReceiptDate);
		
		JLabel lblUniversity = new JLabel("UNIVERSITY SOUVENIR STORE ");
		lblUniversity.setBounds(308, 18, 255, 22);
		lblUniversity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUniversity.setForeground(new Color(255, 255, 204));
		panel.add(lblUniversity);
		
		JLabel lblTransacrionId = new JLabel("TRANSACTION ID:");
		lblTransacrionId.setBounds(589, 83, 146, 14);
		lblTransacrionId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTransacrionId.setForeground(new Color(255, 255, 204));
		panel.add(lblTransacrionId);
		
		JLabel lblTransactionId = new JLabel("");
		lblTransactionId.setBounds(719, 83, 46, 14);
		lblTransactionId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTransactionId.setForeground(new Color(255, 255, 204));
		lblTransactionId.setText(String.valueOf(TransactionController.getTransanctionInstance().getNextTransactionID()-1));
		panel.add(lblTransactionId);
		
		
		panel.add(buildProductTable());
		panel.add(buildSummaryTable());
		
		JLabel lblNewLabel = new JLabel("***************** CUSTOMER COPY****************");
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setBounds(270, 376, 364, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PLEASE VISIT US AGAIN");
		lblNewLabel_1.setForeground(new Color(255, 255, 204));
		lblNewLabel_1.setBounds(352, 404, 233, 16);
		panel.add(lblNewLabel_1);
		
		
	}
	
	public Component buildProductTable()
	{
		int size;
		size = CheckoutController.getCheckoutInstance().getCheckoutItemsList().size();
		prodData = new Object[size][5];
		for(int i=0;i<size;i++)
		{
			prodData[i][0] = CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getBarCodeNumber();
			prodData[i][1] = CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getProductId();
			prodData[i][2] = CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getProductName();			
			prodData[i][3] = CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getQuantityPurchased();
			prodData[i][4] = CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getProductPrice()*CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getQuantityPurchased();;	
		}
		prodTable = new JTable(prodData,colNames);
		JScrollPane scrollPane = new JScrollPane(prodTable);
		scrollPane.setForeground(new Color(255, 245, 238));
		scrollPane.setBackground(new Color(102, 205, 170));
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setBounds(45,129,400,235);
		return scrollPane;
	   
	}
	
	public Component buildSummaryTable()
	{
		if(CheckoutController.getCheckoutInstance().getApplyLoyalty() || !CheckoutController.getCheckoutInstance().getCheckoutMemberID().equals(""))
		{
			summaryTable = CheckoutPanel.getSummaryTable();
			summaryTable.setBounds(500, 150, 235, 201);
			return(summaryTable);
		}
		else
		{
			summaryTable = CheckoutPanelNonMember.getSummaryTable();
			summaryTable.setBounds(500, 150, 235, 201);
			return(summaryTable);
			
		}
	}
}
