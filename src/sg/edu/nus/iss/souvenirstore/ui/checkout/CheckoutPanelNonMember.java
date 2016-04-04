package sg.edu.nus.iss.souvenirstore.ui.checkout;
/***
 * Checkout page for non members
 * @author Vrinda Gupta
 * 
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import sg.edu.nus.iss.souvenirstore.controller.CheckoutController;
import sg.edu.nus.iss.souvenirstore.controller.DiscountController;
import sg.edu.nus.iss.souvenirstore.controller.MemberController;
import sg.edu.nus.iss.souvenirstore.ui.Login;
import javax.swing.border.MatteBorder;

public class CheckoutPanelNonMember extends JPanel {
	static MemberScan memberscan1;

	static CheckoutFrame checkout3frame;
	private static JTable table,myTable;
	private JTextField textField;
	private JTextField textField_1;
	private int size;
	private Object[][] data, myData;
	private JScrollPane scrollPane;
	private String[] colNames = {"Barcode","ProductID","Product","Qty","Price"};
	private static double subTotalamt = 0.00, amtPayable = 0.0;
	
	public CheckoutPanelNonMember() {
		setupPanel();
	}
	private void setupPanel(){
		initializeTable();
		initializePanel();
		setSize(853,533);
		Login login = new Login();
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHECKOUT DETAILS");
		lblNewLabel.setBounds(318, 6, 221, 50);
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.setIcon(new ImageIcon(CheckoutPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/close.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Window) getRootPane().getParent()).dispose();
				checkout3frame = new CheckoutFrame();
				login.initializeWindow(checkout3frame);
				checkout3frame.setupFrame();
				checkout3frame.setSize(853,533);
				checkout3frame.setLocationRelativeTo(null); 
				
				
				}
		});
		btnNewButton.setBounds(350, 415, 170, 40);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		add(btnNewButton);
		
		JButton button = new JButton("SCAN");
		button.setIcon(new ImageIcon(CheckoutPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/scan.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberscan1 = new MemberScan();
			    login.initializeWindow(memberscan1);
			    memberscan1.setupProductScanPanel();
			    memberscan1.setSize(426,266);
			    memberscan1.setLocationRelativeTo(null); 
			    memberscan1.addWindowListener(new WindowListener() {
					
					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						initializeTable();
						initializePanel();
					    new Thread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								try
								{
									Thread.sleep(10);
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
								revalidate();
								repaint();
							    validate();
							    System.out.println("TABLE UPDATED");
							}
						});
						revalidate();
					}
					
					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		});
		
		button.setBounds(120, 415, 170, 40);
		button.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		add(button);
		
		
		
		
		JButton btnCheckout = new JButton("CHECKOUT");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckoutController.getCheckoutInstance().getCheckoutItemsList().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "PLEASE ADD ITEMS BEFORE CHECKING OUT!","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				memberscan1 = new MemberScan();
			    login.initializeWindow(memberscan1);
			    memberscan1.setupCheckoutSummary();
			    memberscan1.setSize(676,431);
			    memberscan1.setLocationRelativeTo(null); 
			    memberscan1.addWindowListener(new WindowListener() {
					
					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						((Window) getRootPane().getParent()).dispose();
					}
					
					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				}
			}
		});
		btnCheckout.setBounds(624, 402, 165, 72);
		btnCheckout.setIconTextGap(6);
		btnCheckout.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnCheckout.setIcon(new ImageIcon(CheckoutPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/shopping_cart_accept.png")));
		btnCheckout.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCheckout.setHorizontalAlignment(SwingConstants.LEFT);
		add(btnCheckout);

	}
	
	public void initializePanel()
	{ 
		float perFactor = 0;
		amtPayable = subTotalamt;
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		numberFormat.format(amtPayable);
        myData = new Object[3][2];
		String[] colNames = {"",""};
		myData[0][0] = " Total Amount : ";
		myData[0][1] = subTotalamt;
		myData[1][0] = " Discount  % : ";
		myData[1][1] = DiscountController.getDiscountInstance().getBestNonMemberDiscountPercentage() + "%";
		myData[2][0] = " Amount Payable :";
		if(DiscountController.getDiscountInstance().getBestNonMemberDiscountPercentage()!=0)
		{
			perFactor = (float) DiscountController.getDiscountInstance().getBestNonMemberDiscountPercentage()/100;
			amtPayable = subTotalamt - (subTotalamt*perFactor);
		}
		myData[2][1] = numberFormat.format(amtPayable);
		CheckoutController.getCheckoutInstance().setamtafterDiscountAndLoyalty(amtPayable);
		
		myTable = new JTable(myData,colNames);
		myTable.setShowGrid(false);
		myTable.setBackground(new Color(0, 204, 153));
		myTable.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 204)));
		myTable.setBounds(611, 197, 181, 160);
		myTable.setRowHeight(40);
		myTable.getColumnModel().getColumn(0).setPreferredWidth(120);
		myTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		myTable.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		//myTable.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		add(myTable);
	}
	
	public void initializeTable()
	{
		size = CheckoutController.getCheckoutInstance().getCheckoutItemsList().size();
		data = new Object[size][5];
		for(int i=0;i<size;i++)
		{
			data[i][0] = CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getBarCodeNumber();
			data[i][1] = CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getProductId();
			data[i][2] = CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getProductName();			
			data[i][3] = CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getQuantityPurchased();
			data[i][4] = CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getProduct().getProductPrice()*CheckoutController.getCheckoutInstance().getCheckoutItemsList().get(i).getQuantityPurchased();;	
			}
		calcSubtotal();
		table = new JTable(data,colNames);
		table.setForeground(new Color(255, 245, 238));
		table.setBackground(new Color(102, 205, 170));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane = new JScrollPane(table);
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setBounds(50, 68, 505, 335);
		scrollPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	    add(scrollPane);
	    System.out.println(subTotalamt);
	}
	
	public void calcSubtotal()
	{
		subTotalamt = 0;
		for(int i=0;i<size;i++)
		{
			subTotalamt+= Double.parseDouble(String.valueOf(data[i][4]));
		}
	}
	public static JTable getSummaryTable()
	{
		return myTable;
	}
}

