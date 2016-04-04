package sg.edu.nus.iss.souvenirstore.ui.product;
/*
 * Author : Rameswari Mohanty
 */

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import sg.edu.nus.iss.souvenirstore.controller.CategoryController;
import sg.edu.nus.iss.souvenirstore.controller.ProductController;
import sg.edu.nus.iss.souvenirstore.controller.ValidationController;
import sg.edu.nus.iss.souvenirstore.domain.Category;
import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;

public class AddProductScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField reorderThresholdFiels;
	private JTextField productNameField;
	private JTextField productQuantityField;
	private JTextField productPriceField;
	private JTextField barcodeNumberField;
	private JTextField productDescriptionField;
	private JTextField orderQuantityField;
	private JComboBox<String> categoryCombo;


	/**
	 * Create the application.
	 */
	public AddProductScreen() {
				
		createPanel();
		ImageIcon imageIcon = new ImageIcon(StoreFrame.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/souvenirstore.png")); 
		setIconImage(imageIcon.getImage());
	}


	private void createPanel() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{694, 0};
		gridBagLayout.rowHeights = new int[]{366, 1, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		//CREATE MAIN FRAME PANEL
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setLayout(null);
		GridBagConstraints gbc_mainPanel = new GridBagConstraints();
		gbc_mainPanel.gridheight = 2;
		gbc_mainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_mainPanel.fill = GridBagConstraints.BOTH;
		gbc_mainPanel.gridx = 0;
		gbc_mainPanel.gridy = 0;
		getContentPane().add(mainPanel, gbc_mainPanel);
		
		//CREATE HEADER LABEL
		JLabel newProductDetailsLabel = new JLabel("New Product Details");
		newProductDetailsLabel.setForeground(Color.WHITE);
		newProductDetailsLabel.setBounds(200, 28, 130, 17);
		newProductDetailsLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		newProductDetailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(newProductDetailsLabel);
		
		//ADD HEADER IMAGE LEFT
		JLabel productImageLeft = new JLabel("");
		productImageLeft.setBounds(130, 11, 49, 53);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/product-add.png")).getImage();
		productImageLeft.setIcon(new ImageIcon(img2));
		mainPanel.add(productImageLeft);
		
		//ADD HEADER IMAGE RIGHT
		JLabel productImageRight = new JLabel("");
		productImageRight.setBounds(361, 11, 49, 53);
		productImageRight.setIcon(new ImageIcon(img2));
		mainPanel.add(productImageRight);
		
		JLabel productCategory = new JLabel("Product Category");
		productCategory.setFont(new Font("Times New Roman", Font.BOLD, 11));
		productCategory.setBounds(63, 86, 116, 14);
		mainPanel.add(productCategory);
		
		JLabel productNameLable = new JLabel("Product name");
		productNameLable.setFont(new Font("Times New Roman", Font.BOLD, 11));
		productNameLable.setBounds(63, 123, 142, 14);
		mainPanel.add(productNameLable);
		
		JLabel lblNewLabel_4 = new JLabel("PLEASE ENTER NEW PRODUCT INFORMATION");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(131, 437, 312, 27);
		mainPanel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBorder(new LineBorder(Color.WHITE, 3));
		panel_1.setBounds(28, 71, 482, 355);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		reorderThresholdFiels = new JTextField();
		reorderThresholdFiels.setBounds(179, 271, 168, 32);
		panel_1.add(reorderThresholdFiels);
		reorderThresholdFiels.setColumns(10);
		
		productNameField = new JTextField();
		productNameField.setBounds(179, 53, 168, 29);
		panel_1.add(productNameField);
		productNameField.setColumns(10);
		
		JLabel reorderThtesholdLable = new JLabel("Reorder Threshold");
		reorderThtesholdLable.setBounds(35, 277, 105, 14);
		panel_1.add(reorderThtesholdLable);
		reorderThtesholdLable.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		JLabel barCodeNumberLable = new JLabel("Bar Code Number");
		barCodeNumberLable.setBounds(35, 238, 117, 14);
		panel_1.add(barCodeNumberLable);
		barCodeNumberLable.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		JLabel priceLable = new JLabel("Price");
		priceLable.setBounds(35, 200, 105, 14);
		panel_1.add(priceLable);
		priceLable.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		JLabel quantityLable = new JLabel("Quantity");
		quantityLable.setBounds(35, 155, 142, 17);
		panel_1.add(quantityLable);
		quantityLable.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		productQuantityField = new JTextField();
		productQuantityField.setBounds(179, 153, 46, 20);
		panel_1.add(productQuantityField);
		productQuantityField.setColumns(10);
		
		productPriceField = new JTextField();
		productPriceField.setBounds(179, 197, 117, 29);
		panel_1.add(productPriceField);
		productPriceField.setColumns(10);
		
		barcodeNumberField = new JTextField();
		barcodeNumberField.setBounds(179, 240, 186, 20);
		panel_1.add(barcodeNumberField);
		barcodeNumberField.setColumns(10);
		
		JLabel productDescLable = new JLabel("Product Description");
		productDescLable.setFont(new Font("Times New Roman", Font.BOLD, 11));
		productDescLable.setBounds(35, 102, 105, 14);
		panel_1.add(productDescLable);
		
		productDescriptionField = new JTextField();
		productDescriptionField.setBounds(179, 94, 168, 48);
		panel_1.add(productDescriptionField);
		productDescriptionField.setColumns(10);
		
		JLabel orderQuantityLable = new JLabel("Order Quantity");
		orderQuantityLable.setFont(new Font("Times New Roman", Font.BOLD, 11));
		orderQuantityLable.setBounds(35, 317, 105, 14);
		panel_1.add(orderQuantityLable);
		
		orderQuantityField = new JTextField();
		orderQuantityField.setColumns(10);
		orderQuantityField.setBounds(179, 314, 168, 30);
		panel_1.add(orderQuantityField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(false);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(179, 11, 155, 20);
		ArrayList<Category> catList = CategoryController.getCategoryInstance().getCategoryList();
		for(int i=0;i<catList.size();i++)
		{
			comboBox.addItem(catList.get(i).getCategoryId());
		}
		panel_1.add(comboBox);
		
		//Creating OK Button
		JButton btnOk = new JButton("OK");
		Image img3 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/ok.png")).getImage();
		btnOk.setIcon(new ImageIcon(img3));
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOk.setBounds(130, 487, 109, 34);
		mainPanel.add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ValidationController.getValidationInstance().isInt(productQuantityField.getText().toString()) &&
					ValidationController.getValidationInstance().isDouble(productPriceField.getText().toString()) &&
					ValidationController.getValidationInstance().isInt(reorderThresholdFiels.getText().toString()) &&
					ValidationController.getValidationInstance().isInt(orderQuantityField.getText().toString()) )
					{
					String catCode = String.valueOf(comboBox.getSelectedItem());
					String prodName = productNameField.getText().toString();
					String prodDesc = productDescriptionField.getText().toString();
					int qtyAvailable = Integer.parseInt(productQuantityField.getText().toString());
					double price = Double.parseDouble(productPriceField.getText().toString());
					String barCode = barcodeNumberField.getText().toString();
					int reOrder = Integer.parseInt(reorderThresholdFiels.getText().toString());
					int orderQty = Integer.parseInt(orderQuantityField.getText().toString());
					if(ProductController.getProductInstance().addProduct(catCode, prodName, prodDesc, qtyAvailable, price, barCode, reOrder, orderQty))
					{
						JOptionPane.showMessageDialog(null, "Product added Successfully!","Status",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "UNABLE TO ADD PRODUCT!","ERROR!",JOptionPane.ERROR_MESSAGE);
						
					}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "PLEASE CHECK THE DATA YOU ENTERED!","ERROR!",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		
		//Creating CANCEL Button
		JButton btnCancel = new JButton("Cancel");
		Image img4 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/close.png")).getImage();
		btnCancel.setIcon(new ImageIcon(img4));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCancel.setBounds(322, 487, 121, 34);
		mainPanel.add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
	}

}
