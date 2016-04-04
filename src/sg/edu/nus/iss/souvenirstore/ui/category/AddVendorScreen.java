package sg.edu.nus.iss.souvenirstore.ui.category;
/*
 * @Author Rameswari Mohanty
 */
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.awt.event.*;
import javax.swing.*;

import javax.swing.border.LineBorder;

import sg.edu.nus.iss.souvenirstore.controller.CategoryController;
import sg.edu.nus.iss.souvenirstore.controller.VendorController;
import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;
public class AddVendorScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField vendorName;
	private JTextField vendorDetails;
	private String categoryCode;

	/**
	 * Create the application.
	 */
	public AddVendorScreen(String categoryCode) {
		this.categoryCode = categoryCode;		
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
		
		//CREATE MAIN PANEL
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		
		JLabel lblNewLabel = new JLabel("New Vendor Details");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(200, 28, 151, 17);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(130, 11, 49, 55);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/vendor.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(383, 11, 49, 55);
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("PLEASE ENTER NEW CATEGORY INFORMATION");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(130, 358, 312, 14);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBorder(new LineBorder(Color.WHITE, 3));
		panel_1.setBounds(28, 77, 482, 270);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		vendorName = new JTextField();
		vendorName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		vendorName.setForeground(Color.WHITE);
		vendorName.setBackground(Color.DARK_GRAY);
		vendorName.setBounds(179, 44, 207, 47);
		panel_1.add(vendorName);
		vendorName.setColumns(10);
		
		vendorDetails = new JTextField();
		vendorDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		vendorDetails.setForeground(Color.WHITE);
		vendorDetails.setBackground(Color.DARK_GRAY);
		vendorDetails.setBounds(179, 102, 207, 53);
		panel_1.add(vendorDetails);
		vendorDetails.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Vendor Details");
		lblNewLabel_3.setBounds(35, 121, 142, 17);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblDiscountCode = new JLabel("Vendor Name");
		lblDiscountCode.setBounds(35, 47, 116, 17);
		panel_1.add(lblDiscountCode);
		lblDiscountCode.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH,
				Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));
		
		//Creating OK Button
		JButton btnOk = new JButton("OK");
		Image img3 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/ok.png")).getImage();
		btnOk.setIcon(new ImageIcon(img3));
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOk.setBounds(129, 390, 109, 34);
		panel.add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> categories = new ArrayList<>();
				categories.add(categoryCode);
				if(VendorController.getVendorInstance().addVendor(vendorName.getText().toString(), vendorDetails.getText().toString(), categories))
				{
					JOptionPane.showMessageDialog(null, "Vendor Added Successfully","Status", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "VENDOR CANNOT BE ADDED!","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				
				dispose();
			}
		});
		
		//Creating CANCEL Button
		JButton btnCancel = new JButton("Cancel");
		Image img4 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/close.png")).getImage();
		btnCancel.setIcon(new ImageIcon(img4));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCancel.setBounds(321, 390, 121, 34);
		panel.add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
