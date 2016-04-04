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

import sg.edu.nus.iss.souvenirstore.controller.CategoryController;
import sg.edu.nus.iss.souvenirstore.controller.VendorController;
import sg.edu.nus.iss.souvenirstore.domain.Category;
public class CategoryReportList extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTable tableCategory;
	private int categoryNumber;

	public CategoryReportList() {
		setBackground(Color.WHITE);
		

		createDiscountListPanel();
	}
	
	private void createDiscountListPanel(){
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		String[] colNames = {"Category Code", "Category Name" , "Vendor Info"};
		ArrayList<Category> categoryList = CategoryController.getCategoryInstance().getCategoryList();
		categoryNumber = categoryList.size();
		Object[][] data = new Object[categoryList.size()][3];
		for(int i = 0; i<categoryList.size();i++)
		{
			data[i][0] = categoryList.get(i).getCategoryId();
			data[i][1] = categoryList.get(i).getCategoryName();
			data[i][2] = VendorController.getVendorInstance().getVendorsListByCategory(data[i][0].toString()).size();
		}
		tableCategory = new JTable(data,colNames);
		tableCategory.setBackground(new Color(224, 255, 255));
		tableCategory.setPreferredScrollableViewportSize(new Dimension(550,200));
	    tableCategory.setFillsViewportHeight(true);
	    tableCategory.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JScrollPane scrollPane = new JScrollPane(tableCategory);
	    add(scrollPane);
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}
	
	
}
