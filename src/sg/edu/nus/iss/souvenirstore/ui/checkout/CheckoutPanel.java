package sg.edu.nus.iss.souvenirstore.ui.checkout;
/***
 * Checkout page for members
 * @author Vrinda Gupta
 * 
 */
import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.omg.CORBA.FREE_MEM;

import sg.edu.nus.iss.souvenirstore.controller.CheckoutController;
import sg.edu.nus.iss.souvenirstore.controller.DiscountController;
import sg.edu.nus.iss.souvenirstore.controller.MemberController;
import sg.edu.nus.iss.souvenirstore.ui.Login;
import sg.edu.nus.iss.souvenirstore.ui.main.StorePanel;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;


public class CheckoutPanel extends JPanel {
	static MemberScan memberscan;
	private static JTable table,myTable;

	private DecimalFormat numberFormat = new DecimalFormat("#.00");
	public static CheckoutFrame checkout1frame;
	private String[] colNames = {"Barcode","ProductID","Product","Qty","Price"};
	private Object[][] data,myData;
	private int size;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1, lblLoyaltyPoint, lblDiscount, lblRemainingPoint, lblNewLabel_2, label,label_1,label_2;
	private static double subTotalamt = 0.00, amtPayable =0.00;
	private JPanel panel;
	
	public CheckoutPanel() {
		if(!CheckoutController.getCheckoutInstance().getCheckoutMemberID().equals(""))
		{setupPanel();}
	}
	private void setupPanel(){
		Login login = new Login();
		setSize(853,533);
		initializeTable();
		initializePanel();
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
				checkout1frame = new CheckoutFrame();
				login.initializeWindow(checkout1frame);
				checkout1frame.setupFrame();
		        checkout1frame.setSize(853,533);
				checkout1frame.setLocationRelativeTo(null); 
			}
		});
		btnNewButton.setBounds(350, 415, 170, 40);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		add(btnNewButton);
		
		JButton button = new JButton("SCAN");
		button.setIcon(new ImageIcon(CheckoutPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/scan.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberscan = new MemberScan();
			    login.initializeWindow(memberscan);
			    memberscan.setupProductScanPanel();
			    memberscan.setSize(426,266);
			    memberscan.setLocationRelativeTo(null);
			    memberscan.addWindowListener(new WindowListener() {
					
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
		//have to check if HTML can be used
		JButton btnNewButton_1 = new JButton("<html>CUSTOMER<br />PROFILE</html>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberscan = new MemberScan();
				login.initializeWindow(memberscan);
			    memberscan.setupCustomerProfile();
			    memberscan.setSize(426,266);
			    memberscan.setLocationRelativeTo(null); 
			}
		});
		btnNewButton_1.setBounds(624, 18, 165, 72);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.setIcon(new ImageIcon(CheckoutPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/store.png")));
		btnNewButton_1.setSelectedIcon(new ImageIcon(CheckoutPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/store.png")));
		add(btnNewButton_1);
		
		
		
		
		JButton btnLoyaltyPoints = new JButton("<html>LOYALTY<br /> POINTS<html>");
		btnLoyaltyPoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberscan = new MemberScan();
				login.initializeWindow(memberscan);
			    memberscan.setupLoyaltyPanel();
			    memberscan.setSize(426,266);
			    memberscan.setLocationRelativeTo(null); 
			    memberscan.addWindowListener(new WindowListener() {
					
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
								initializePanel();
								new Thread(new Runnable() {
									public void run() {
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
		btnLoyaltyPoints.setBounds(624, 104, 165, 72);
		btnLoyaltyPoints.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnLoyaltyPoints.setIcon(new ImageIcon(CheckoutPanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Gift-icon.png")));
		btnLoyaltyPoints.setVerticalAlignment(SwingConstants.TOP);
		btnLoyaltyPoints.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnLoyaltyPoints.setHorizontalAlignment(SwingConstants.LEFT);
		add(btnLoyaltyPoints);
		
		JButton btnCheckout = new JButton("CHECKOUT");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckoutController.getCheckoutInstance().getCheckoutItemsList().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "PLEASE ADD ITEMS BEFORE CHECKING OUT!","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					memberscan = new MemberScan();
				login.initializeWindow(memberscan);
			    memberscan.setupCheckoutSummary();
			    memberscan.setSize(676,431);
			    memberscan.setLocationRelativeTo(null); 
			    memberscan.addWindowListener(new WindowListener() {
					
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
		float perFactor;
		amtPayable = subTotalamt;
		numberFormat.format(amtPayable);
		myData = new Object[5][2];
		int pointsWithMember;
		pointsWithMember = MemberController.getMemberInstance().getMemberById(CheckoutController.getCheckoutInstance().getCheckoutMemberID()).getLoyaltyPoints();
		String[] colNames = {"",""};
		double amtPayable = 0;
		myData[0][0] = " Total Amount : ";
		myData[0][1] = subTotalamt;
		myData[1][0] = " Loyalty points : ";
		int pointRedeeming = 0;
		if(CheckoutController.getCheckoutInstance().getApplyLoyalty())
		{	
			myData[1][1] = CheckoutController.getCheckoutInstance().getMaxRedeemablePoints(subTotalamt);
		}
		else
		{
			myData[1][1] = "N.A";
		}
		
		
		myData[2][0] = " Discount  % : ";
		myData[2][1] = DiscountController.getDiscountInstance().getBestMemberDiscountPercentage(CheckoutController.getCheckoutInstance().getCheckoutMemberID()) + "%";
		
		if(DiscountController.getDiscountInstance().getBestMemberDiscountPercentage(CheckoutController.getCheckoutInstance().getCheckoutMemberID())!=0)
		{
			perFactor = (float)DiscountController.getDiscountInstance().getBestMemberDiscountPercentage(CheckoutController.getCheckoutInstance().getCheckoutMemberID())/100;
            amtPayable = subTotalamt - (subTotalamt*perFactor);
			numberFormat.format(amtPayable);
		}
		
		

		myData[3][0] = "Remaining Points: ";
				if(CheckoutController.getCheckoutInstance().getApplyLoyalty())
				{	
					try
					{
						pointRedeeming = (int)(CheckoutController.getCheckoutInstance().getMaxRedeemablePoints(amtPayable));
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, "NO ITEMS SCANNED!" , "ERROR!", JOptionPane.ERROR_MESSAGE);
						pointRedeeming = 0;
					}
					int remPoints = pointsWithMember - pointRedeeming;
					myData[3][1] = remPoints;
				}
				else
				{
					myData[3][1] = "N.A";
				}
				myData[4][0] = "Amount Payable:";
				if(CheckoutController.getCheckoutInstance().getApplyLoyalty())
				{
				myData[4][1] = numberFormat.format(amtPayable - (CheckoutController.getCheckoutInstance().getAmountforPoints(pointRedeeming)));
				CheckoutController.getCheckoutInstance().setamtafterDiscountAndLoyalty(amtPayable - (CheckoutController.getCheckoutInstance().getAmountforPoints(pointRedeeming)));
				}
				else
				{
					myData[4][1] = numberFormat.format(amtPayable);
					CheckoutController.getCheckoutInstance().setamtafterDiscountAndLoyalty(amtPayable);
					
				}
				
				
				myTable = new JTable(myData,colNames);
				myTable.setShowGrid(false);
				myTable.setBackground(new Color(0, 204, 153));
				myTable.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 204)));
				myTable.setBounds(587, 186, 235, 201);
				myTable.setRowHeight(40);
				myTable.getColumnModel().getColumn(0).setPreferredWidth(100);
				myTable.setFont(new Font("Lucida Grande", Font.BOLD, 12));
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
