package sg.edu.nus.iss.souvenirstore.ui.discount;
/*
 * Author : Rameswari
 */
import java.awt.*;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import sg.edu.nus.iss.souvenirstore.controller.DiscountController;
import sg.edu.nus.iss.souvenirstore.controller.ValidationController;
import sg.edu.nus.iss.souvenirstore.ui.main.StoreFrame;
public class AddDiscountScreen extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField discountCode;
	private JTextField discountDescription;
	private JTextField discountPercent;
	private JTextField startDate;
	private JTextField discountPeriod;
	private JFormattedTextField formattedDate;
	

	/**
	 * Create the application.
	 */
	public AddDiscountScreen() {
				
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
		
		JLabel lblNewLabel = new JLabel("New Discount Details");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(200, 28, 130, 17);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(130, 11, 49, 43);
		Image img2 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Gift-icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(361, 11, 49, 43);
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		panel.add(lblNewLabel_2);
		
		JLabel lblDiscountCode = new JLabel("Discount Code");
		lblDiscountCode.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblDiscountCode.setBounds(63, 86, 116, 14);
		panel.add(lblDiscountCode);
		
		JLabel lblNewLabel_3 = new JLabel("Discount Description");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_3.setBounds(63, 123, 142, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PLEASE ENTER NEW DISCOUNT INFORMATION");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(130, 358, 312, 14);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBorder(new LineBorder(Color.WHITE, 3));
		panel_1.setBounds(28, 61, 482, 286);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		discountCode = new JTextField();
		discountCode.setBounds(179, 22, 168, 20);
		panel_1.add(discountCode);
		discountCode.setColumns(10);
		
		discountDescription = new JTextField();
		discountDescription.setBounds(179, 53, 168, 53);
		panel_1.add(discountDescription);
		discountDescription.setColumns(10);
		
		JLabel Period = new JLabel("Period");
		Period.setBounds(35, 205, 46, 14);
		panel_1.add(Period);
		Period.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		JLabel StartDate = new JLabel("Start Date");
		StartDate.setBounds(35, 169, 105, 14);
		panel_1.add(StartDate);
		StartDate.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		JLabel Discount = new JLabel("Discount Percentage");
		Discount.setBounds(35, 127, 142, 17);
		panel_1.add(Discount);
		Discount.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		discountPercent = new JTextField();
		discountPercent.setBounds(179, 125, 46, 20);
		panel_1.add(discountPercent);
		discountPercent.setColumns(10);
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		formattedDate = new JFormattedTextField(sf);
		formattedDate.setBounds(179, 166, 117, 20);
		formattedDate.setEditable(false);
		panel_1.add(formattedDate);
		formattedDate.setColumns(10);
		
		
		 //create button and there object
		 JButton btnNewButton = new JButton("Pick Date");
		 btnNewButton.setBackground(Color.ORANGE);
		 
		 //perform action listener
		 btnNewButton.addActionListener(new ActionListener() 
		 { 
		 //performed action
		 public void actionPerformed(ActionEvent arg0) 
		 {
		 //create frame new object  f
		 final JFrame f = new JFrame();
		 //set text which is collected by date picker i.e. set date 
		 formattedDate.setText(new DatePicker(f).setPickedDate());
		 }
		 });
		 //set button bound
		 btnNewButton.setBounds(316, 165, 94, 23);
		 //add button in contentPane
		 panel_1.add(btnNewButton);
		 
			
		 discountPeriod = new JTextField();
		 discountPeriod.setBounds(179, 197, 73, 20);
		 panel_1.add(discountPeriod);
		 discountPeriod.setEditable(false);
		 discountPeriod.setColumns(10);
		 discountPeriod.setText("ALWAYS");
		
		 formattedDate.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				if(!formattedDate.getText().toString().equals(""))
				{
				discountPeriod.setText("");
				discountPeriod.setEditable(true);
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
			
				
			}
		});

	
		//Creating OK Button
		JButton btnOk = new JButton("OK");
		Image img3 = new ImageIcon(this.getClass().getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/ok.png")).getImage();
		btnOk.setIcon(new ImageIcon(img3));
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOk.setBounds(129, 390, 109, 34);
		panel.add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ValidationController.getValidationInstance().validateDiscountPercentage(discountPercent.getText().toString()) &&
						
						ValidationController.getValidationInstance().validateDiscountDuration(discountPeriod.getText().toString()))
				{
					
					if(DiscountController.getDiscountInstance().addNewNonMemberDiscount(discountCode.getText().toString().toUpperCase(), discountDescription.getText().toString(), formattedDate.getText().toString(), discountPeriod.getText().toString(), Integer.parseInt(discountPercent.getText().toString())))
					{
						JOptionPane.showMessageDialog(null, "Discount For All Customers Added Successfully","Status",JOptionPane.INFORMATION_MESSAGE);
					}
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "PLEASE CHECK THE DATA YOU ENTERED","ERROR",JOptionPane.ERROR_MESSAGE);
					
				}
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
