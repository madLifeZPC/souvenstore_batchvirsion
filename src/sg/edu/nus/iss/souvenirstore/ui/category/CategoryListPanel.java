package sg.edu.nus.iss.souvenirstore.ui.category;

/*
 * Author : Rameswari Mohanty
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import sg.edu.nus.iss.souvenirstore.controller.CategoryController;
import sg.edu.nus.iss.souvenirstore.domain.Category;
public class CategoryListPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Object[][] data;

	public CategoryListPanel() {
		setBackground(Color.WHITE);
		createDiscountListPanel();
	}
	
	private class MyButtonEditor extends DefaultCellEditor{

		/**
		 * serialVersionUID
		 */
		private static final long serialVersionUID = 1L;
		
		private JPanel panel;  
	    private JButton button;  
	  
	    public MyButtonEditor()  
	    {  
	        super(new JTextField());  
	        this.setClickCountToStart(1);  
	        this.initButton();  
	        this.initPanel();  
	        this.panel.add(this.button);  
	    }
	    
	    private void initButton()  
	    {  
	        this.button = new JButton();
	        this.button.setBounds(0, 0, 100, 15);  
	  
	        this.button.addActionListener(new ActionListener()  
	        {  
	            public void actionPerformed(ActionEvent e)  
	            {  
	                MyButtonEditor.this.fireEditingCanceled();  
	                String categoryCode = (String)data[table.getSelectedRow()][0];
	                vendorDetailsScreen vendorScreen = new vendorDetailsScreen(categoryCode);
	                vendorScreen.pack();
	                vendorScreen.setBounds(400, 200, 650, 500);
	            } 
	        });    
	    }
	    
	    private void initPanel()  
	    {  
	        this.panel = new JPanel();
	        this.panel.setLayout(null);
	    }
	    @Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)  
	    {
	        this.button.setText(value == null ? "" : String.valueOf(value));  
	        return this.panel;
	    }  

	    @Override
	    public Object getCellEditorValue()  
	    {  
	        return this.button.getText();  
	    }
	}
	
	private class MyButtonRender implements TableCellRenderer{
		
		 private JPanel panel;
		 private JButton button;

	    public MyButtonRender()
	    {
	        this.initButton();
	        this.initPanel();
	        this.panel.add(this.button);
	    }

	    private void initButton()
	    {
	        this.button = new JButton();
	        this.button.setBounds(0, 0, 100, 15);
	    }

	    private void initPanel()
	    {
	        this.panel = new JPanel();
	        this.panel.setLayout(null);
	    }

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
	            int column)
	    {
	    	this.button.setText(value == null ? "" : String.valueOf(value));
	        return this.panel;
	    }
	}
	
	private void createDiscountListPanel(){

		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		String[] colNames = {"Category Code", "Category Name" , "Vendor Info"};
		ArrayList<Category> categoryList = CategoryController.getCategoryInstance().getCategoryList();
		data = new Object[categoryList.size()][3];
		for(int i = 0; i<categoryList.size();i++)
		{
			data[i][0] = categoryList.get(i).getCategoryId();
			data[i][1] = categoryList.get(i).getCategoryName();
			data[i][2] = "Vendors";
		}
		table = new JTable(data,colNames);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(2).setCellEditor(new MyButtonEditor());  
		table.getColumnModel().getColumn(2).setCellRenderer(new MyButtonRender());
		table.setRowSelectionAllowed(false);
		table.setBackground(new Color(224, 255, 255));
		table.setPreferredScrollableViewportSize(new Dimension(550,200));
	    table.setFillsViewportHeight(true);
	    table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JScrollPane scrollPane = new JScrollPane(table);
	    add(scrollPane);
	}
}
