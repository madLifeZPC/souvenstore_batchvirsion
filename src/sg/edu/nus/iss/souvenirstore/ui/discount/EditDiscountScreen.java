package sg.edu.nus.iss.souvenirstore.ui.discount;
/*
 * Author : Rameswari Mohanty
 */

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import java.awt.event.*;
import javax.swing.*;

import javax.swing.border.LineBorder;

import sg.edu.nus.iss.souvenirstore.controller.DiscountController;
import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;
public class EditDiscountScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField discountCode;
	private JTextField discountPercentage;
	private String discountId;
	private int percentage;

	/**
	 * Create the application.
	 */
	public EditDiscountScreen(String discountId,int percentage) {
		this.discountId = discountId;	
		this.percentage = percentage;
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
		
		JLabel lblNewLabel = new JLabel("Edit Discount Details");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(200, 28, 130, 17);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(130, 11, 49, 43);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Gift-icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(361, 11, 49, 43);
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		panel.add(lblNewLabel_2);
		
		JLabel lblDiscountCode = new JLabel("Discount Code");
		lblDiscountCode.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblDiscountCode.setBounds(63, 86, 116, 14);
		panel.add(lblDiscountCode);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBorder(new LineBorder(Color.WHITE, 3));
		panel_1.setBounds(28, 61, 425, 154);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		discountCode = new JTextField();
		discountCode.setBounds(179, 22, 168, 20);
		discountCode.setText(discountId);
		discountCode.setEditable(false);
		panel_1.add(discountCode);
		discountCode.setColumns(10);
		
		discountPercentage = new JTextField();
		discountPercentage.setText(String.valueOf(percentage));
		discountPercentage.setBounds(179, 78, 86, 30);
		panel_1.add(discountPercentage);
		discountPercentage.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Discount Percentage");
		lblNewLabel_3.setBounds(31, 86, 142, 14);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH,
				Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));
		
		ButtonGroup group = new ButtonGroup();

		//Creating OK Button
		JButton btnOk = new JButton("SAVE");
		Image img3 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/ok.png")).getImage();
		btnOk.setIcon(new ImageIcon(img3));
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOk.setBounds(130, 247, 109, 34);
		panel.add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DiscountController.getDiscountInstance().updateDiscount(discountCode.getText().toString(), Integer.parseInt(discountPercentage.getText().toString())))
				{
					JOptionPane.showMessageDialog(null, "Discount Saved Successfully","Status", JOptionPane.INFORMATION_MESSAGE);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "DISCOUNT CANNOT BE SAVED!","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				dispose();
			}
		});
		
		//Creating CANCEL Button
		JButton btnCancel = new JButton("Cancel");
		Image img4 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/close.png")).getImage();
		btnCancel.setIcon(new ImageIcon(img4));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCancel.setBounds(289, 247, 121, 34);
		panel.add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});	
	}
}
