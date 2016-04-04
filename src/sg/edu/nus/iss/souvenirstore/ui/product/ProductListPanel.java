package sg.edu.nus.iss.souvenirstore.ui.product;
/*
 * Author : Rameswari Mohanty
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import sg.edu.nus.iss.souvenirstore.controller.CategoryController;
import sg.edu.nus.iss.souvenirstore.controller.ProductController;
import sg.edu.nus.iss.souvenirstore.domain.Category;
import sg.edu.nus.iss.souvenirstore.domain.Product;
public class ProductListPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTable table;

	public ProductListPanel() {
		setBackground(Color.WHITE);
		

		createProductListPanel();
	}
	
	private void createProductListPanel(){
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		String[] colNames = {"Product ID","Product Name","Product Description","Quantity Available","Price","Bar Code Number","Re-Order Quantity","Order Quantity"};
		ArrayList<Product> productList = ProductController.getProductInstance().getProductsList();
		Object[][] data = new Object[productList.size()][8];
		for(int i = 0; i<productList.size();i++)
		{
			data[i][0] = productList.get(i).getProductId();
			data[i][1] = productList.get(i).getProductName();
			data[i][2] = productList.get(i).getProductDescription();
			data[i][3] = productList.get(i).getQuantityAvailable();
			data[i][4] = productList.get(i).getProductPrice();
			data[i][5] = productList.get(i).getBarCodeNumber();
			data[i][6] = productList.get(i).getReorderQuantity();
			data[i][7] = productList.get(i).getOrderQuantity();
		}
		table = new JTable(data,colNames);
		table.setBackground(new Color(224, 255, 255));
		table.setPreferredScrollableViewportSize(new Dimension(550,200));
	    table.setFillsViewportHeight(true);
	    table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JScrollPane scrollPane = new JScrollPane(table);
	    add(scrollPane);

	}
	
}
