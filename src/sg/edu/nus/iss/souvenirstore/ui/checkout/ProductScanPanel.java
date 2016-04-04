package sg.edu.nus.iss.souvenirstore.ui.checkout;
/***
 * Product Scan page
 * @author Vrinda Gupta
 * 
 */
import javax.swing.JPanel;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import sg.edu.nus.iss.souvenirstore.controller.CheckoutController;
import sg.edu.nus.iss.souvenirstore.controller.ProductController;
import sg.edu.nus.iss.souvenirstore.domain.Product;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class ProductScanPanel extends JPanel {
	private JTextField textField;
	private int count = 0;
	
	public ProductScanPanel() {
		setLayout(null);
		//Adding the scan picture
		JLabel label = new JLabel("");
		label.setBounds(175, 5, 99, 93);
		label.setIcon(new ImageIcon(ProductScanPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Scan.jpg")));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
		
		//scan button
		JButton btnScan = new JButton("SCAN");
		btnScan.setIcon(new ImageIcon(ProductScanPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/scan.png")));
		btnScan.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		btnScan.setBounds(100, 172, 112, 36);
		add(btnScan);
		
		//text field
		textField = new JTextField(10);
		textField.setBounds(162, 144, 130, 26);
		add(textField);
		
		btnScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String barcode = textField.getText().toString();
				Product p = ProductController.getProductInstance().getProductbyBarcode(barcode);
				if(p!=null)
				{
					if(ProductController.getProductInstance().getProductbyBarcode(barcode).getQuantityAvailable()<=0)
					{
						JOptionPane.showMessageDialog(null, "UNABLE TO ADD PRODUCT. THE PRODUCT IS OUT OF STOCK","ERROR!",JOptionPane.ERROR_MESSAGE);
						
					}
					else
					{
					if(CheckoutController.getCheckoutInstance().addCheckoutProduct(p))
					{
						((Window) getRootPane().getParent()).dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "UNABLE TO ADD PRODUCT","ERROR!",JOptionPane.ERROR_MESSAGE);
					}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "UNABLE TO FIND PRODUCT","ERROR!",JOptionPane.ERROR_MESSAGE);
				}
	         
			}
		});
	
		
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.setIcon(new ImageIcon(ProductScanPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/close.png")));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Window) getRootPane().getParent()).dispose();
			}
		});
		btnClose.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		btnClose.setBounds(261, 173, 112, 36);
		add(btnClose);
		
		JLabel lblNewLabel = new JLabel("Enter Product Code");
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setBounds(162, 116, 143, 16);
		add(lblNewLabel);
	}
}
