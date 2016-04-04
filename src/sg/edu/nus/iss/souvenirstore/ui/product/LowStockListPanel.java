package sg.edu.nus.iss.souvenirstore.ui.product;

/**
 * author: Vignesh
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
public class LowStockListPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTable table;

	public LowStockListPanel() {
		setBackground(Color.WHITE);
		createProductListPanel();
	}
	
	private void createProductListPanel(){
		int size=0;
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		String[] colNames = {"Product ID","Product Name","Product Description","Quantity Available","Price","Bar Code Number","Re-Order Quantity","Order Quantity"};
		ArrayList<Product> productList = ProductController.getProductInstance().getProductsList();
		ArrayList<Product> lowstockList = new ArrayList<>();
		for(Product product:productList)
		{
			if(product.getQuantityAvailable()<=product.getReorderQuantity())
			{
				size+=1;
			}
		}
		
		Object[][] data = new Object[size][8];
		for(int i = 0; i<productList.size();i++)
		{
			if(productList.get(i).getQuantityAvailable()<=productList.get(i).getReorderQuantity())
			{
				lowstockList.add(productList.get(i));
			}
		}
		for(int j=0;j<size;j++)
		{
			data[j][0] = lowstockList.get(j).getProductId();
			data[j][1] = lowstockList.get(j).getProductName();
			data[j][2] = lowstockList.get(j).getProductDescription();
			data[j][3] = lowstockList.get(j).getQuantityAvailable();
			data[j][4] = lowstockList.get(j).getProductPrice();
			data[j][5] = lowstockList.get(j).getBarCodeNumber();
			data[j][6] = lowstockList.get(j).getReorderQuantity();
			data[j][7] = lowstockList.get(j).getOrderQuantity();
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
