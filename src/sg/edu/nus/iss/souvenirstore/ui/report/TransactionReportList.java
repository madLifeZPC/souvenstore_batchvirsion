package sg.edu.nus.iss.souvenirstore.ui.report;
/*
 * Author : Rameswari Mohanty
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import sg.edu.nus.iss.souvenirstore.controller.ProductController;
import sg.edu.nus.iss.souvenirstore.controller.TransactionController;
import sg.edu.nus.iss.souvenirstore.domain.CheckoutItem;
import sg.edu.nus.iss.souvenirstore.domain.Product;
import sg.edu.nus.iss.souvenirstore.domain.Transaction;
public class TransactionReportList extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTable table;
	private String startDate, endDate;
	public TransactionReportList(String startdate, String enddate) {
		this.startDate = startdate;
		this.endDate = enddate;
		setBackground(Color.WHITE);
		createDiscountListPanel();
	}
	private void createDiscountListPanel(){
		int size = 0;
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		String[] colNames = {"Transaction ID","ProductID","ProductName","ProductDescription","Quantity","Transaction Date"};
		ArrayList<Transaction> transList = TransactionController.getTransanctionInstance().getTransactionsbyDaterange(startDate,endDate);
		if(transList!=null)
		{
			for (Transaction transaction : transList) {
				size+=transaction.getCheckoutItems().size();
		}
		}
		
		Object[][] data = new Object[size][6];
		int k = 0;
		for(int i = 0; i<transList.size();i++)
		{
			for(int j=0;j<transList.get(i).getCheckoutItems().size();j++)
			{
				data[k][0] = transList.get(i).getTransactionId();
				String productId = transList.get(i).getCheckoutItems().get(j).getProduct().getProductId();
				data[k][1] = productId;
				Product productItem = ProductController.getProductInstance().getProductbyId(productId);
				data[k][2] = productItem.getProductName();
				data[k][3] = productItem.getProductDescription();
				data[k][4] = transList.get(i).getCheckoutItems().get(j).getQuantityPurchased();
				data[k][5] = transList.get(i).getDate();
				k++;
			}
		}
		table = new JTable(data,colNames);
		table.setBackground(new Color(224, 255, 255));
		table.setPreferredScrollableViewportSize(new Dimension(590,150));
	    table.setFillsViewportHeight(true);
	    table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JScrollPane scrollPane = new JScrollPane(table);
	    add(scrollPane);

	}
	
}
