package sg.edu.nus.iss.souvenirstore.ui.category;
/*
 * Author : Rameswari Mohanty
 */

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import sg.edu.nus.iss.souvenirstore.controller.CategoryController;
import sg.edu.nus.iss.souvenirstore.controller.VendorController;
import sg.edu.nus.iss.souvenirstore.domain.Category;
import sg.edu.nus.iss.souvenirstore.domain.Vendor;

public class VendorListPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTable table;
	private Object[][] data;
	private String categoryCode;
	
	public VendorListPanel(String categoryCode)
	{
		setBackground(Color.WHITE);
		this.categoryCode = categoryCode;
		createVendorListPanel();
	}
	
	public void createVendorListPanel()
	{
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		String[] colNames = {"Vendor Name", "Vendor Description"};
		ArrayList<Vendor> vendorList = VendorController.getVendorInstance().getVendorsListByCategory(categoryCode);
		data = new Object[vendorList.size()][2];
		for(int i = 0; i<vendorList.size();i++)
		{
			data[i][0] = vendorList.get(i).getVendorName();
			data[i][1] = vendorList.get(i).getVendorDescription();
		}
		table = new JTable(data,colNames);
		table.setRowSelectionAllowed(false);
		table.setBackground(new Color(224, 255, 255));
		table.setPreferredScrollableViewportSize(new Dimension(550,200));
	    table.setFillsViewportHeight(true);
	    table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JScrollPane scrollPane = new JScrollPane(table);
	    add(scrollPane);
	}
}
