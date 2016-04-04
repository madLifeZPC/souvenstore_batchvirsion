package sg.edu.nus.iss.souvenirstore.ui.discount;
/*
 * Author : Rameswari Mohanty
 */

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import sg.edu.nus.iss.souvenirstore.controller.DiscountController;
import sg.edu.nus.iss.souvenirstore.domain.Discount;

public class DiscountListPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Object[][] data;

	public DiscountListPanel() {
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
	                String discountCode = (String)data[table.getSelectedRow()][0];
	                int percentage = (int)data[table.getSelectedRow()][4];
	                EditDiscountScreen editDiscountScreen = new EditDiscountScreen(discountCode,percentage);
	                editDiscountScreen.setLocationByPlatform(true);
	                editDiscountScreen.pack();
	                editDiscountScreen.setVisible(true);
	                editDiscountScreen.setBounds(400, 200, 550, 500);
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
		String[] colNames = {"Discount Code","Disount Description","Start Date","Duration","Discount Percentage","Applicable","Edit"};
		ArrayList<Discount> discountList = DiscountController.getDiscountInstance().getAllDiscounts();
		data = new Object[discountList.size()][7];
		for(int i = 0; i<discountList.size();i++)
		{
			data[i][0] = discountList.get(i).getDiscountCode();
			data[i][1] = discountList.get(i).getDiscountDescription();
			data[i][2] = discountList.get(i).getStartDate();
			data[i][3] = discountList.get(i).getDuration();
			data[i][4] = discountList.get(i).getPercentage();
			data[i][5] = discountList.get(i).getApplicableTo();
			data[i][6] = "Edit";
		}
		table = new JTable(data,colNames);
		table.getColumnModel().getColumn(6).setMaxWidth(100);
		table.getColumnModel().getColumn(6).setMinWidth(100);
		table.getColumnModel().getColumn(6).setCellEditor(new MyButtonEditor());  
		table.getColumnModel().getColumn(6).setCellRenderer(new MyButtonRender());
		table.setRowSelectionAllowed(false);
		table.setBackground(new Color(224, 255, 255));
		table.setPreferredScrollableViewportSize(new Dimension(550,200));
	    table.setFillsViewportHeight(true);
	    table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JScrollPane scrollPane = new JScrollPane(table);
	    add(scrollPane);
	}
	
}
