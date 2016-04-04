package sg.edu.nus.iss.souvenirstore.ui.main;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JComponent;

import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import sg.edu.nus.iss.souvenirstore.controller.CheckoutController;
import sg.edu.nus.iss.souvenirstore.ui.Login;
import sg.edu.nus.iss.souvenirstore.ui.category.CategoryMainWindow;
import sg.edu.nus.iss.souvenirstore.ui.checkout.CheckoutFrame;
import sg.edu.nus.iss.souvenirstore.ui.discount.DiscountMainWindow;
import sg.edu.nus.iss.souvenirstore.ui.main.*;
import sg.edu.nus.iss.souvenirstore.ui.member.MemberMainWindow;
import sg.edu.nus.iss.souvenirstore.ui.product.ProductMainWindow;
import sg.edu.nus.iss.souvenirstore.ui.report.ReportMainWindow;

import java.awt.Component;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
/***
 * Home page
 * @author Vrinda Gupta
 * 
 */





public class StorePanel extends JPanel {
	public static CheckoutFrame checkoutframe;
	public Login login;
	ProductMainWindow productmainwindow;
	JTextArea txtrWelcomeToThe ;
	MemberMainWindow membermainwindow;
	DiscountMainWindow discountmainwindow;
	CategoryMainWindow categorymainwindow;
	ReportMainWindow reportmainwindow;
	
	public StorePanel() {
		setForeground(SystemColor.menu);
		setupPanel();
	}
	private void setupPanel(){
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setSize(853,533);
		// adding a panel for right hand text area
		
		Login login = new Login();
		JPanel panel = new JPanel();
		panel.setBounds(373, 86, 388, 330);
		panel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(255, 175, 175)));
		panel.setBackground(new Color(255, 255, 255,0));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/border7.png")));
		lblNewLabel_1.setBounds(0, 6, 382, 324);
		panel.add(lblNewLabel_1);
	    txtrWelcomeToThe = new JTextArea();
	    add(txtrWelcomeToThe);
		setupTextArea("\n\n\tWelcome\n\t  to the \n            University Souvenir Store");
		
		// button for Members
		JButton btnMembers = new JButton("");
		btnMembers.setBackground(Color.DARK_GRAY);
		btnMembers.setForeground(new Color(0, 0, 0));
		
		//Mouselistener for enter and exit
		btnMembers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setupTextArea("\n\n\tMEMBERS\n\tTo add or \n                    view Members \n                   Click the Button");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setupTextArea("\n\n\tWelcome\n\t  to the \n            University Souvenir Store");
			}
		});
		//Action Listener for Members
		btnMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			membermainwindow = new MemberMainWindow();
			login.initializeWindow(membermainwindow);
			membermainwindow.setSize(653,500);
			membermainwindow.setLocationRelativeTo(null);
			}
			});
		
		btnMembers.setToolTipText("MEMBERS");
		btnMembers.setSelected(true);
		btnMembers.setRolloverIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Member_c.png")));
		btnMembers.setRolloverSelectedIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Member_c.png")));
		btnMembers.setMargin(new Insets(0, 10, 0, 1));
		btnMembers.setPreferredSize(new Dimension(82, 29));
		btnMembers.setRolloverEnabled(true);
		btnMembers.setSelectedIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Member_b.png")));
		btnMembers.setIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Member_b.png")));
		btnMembers.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		btnMembers.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(255, 175, 175)));
		btnMembers.setBounds(172, 86, 114, 85);
		add(btnMembers);
		
		// button for Discount
		JButton btnDiscount = new JButton("");
		btnDiscount.setBackground(Color.DARK_GRAY);
		btnDiscount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setupTextArea("\n\n\tDISCOUNT\n\tTo add or\n                   view Discounts  \n                   Click the Button");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setupTextArea("\n\n\tWelcome\n\t  to the \n            University Souvenir Store");
			}
		});
		btnDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discountmainwindow = new DiscountMainWindow();
				login.initializeWindow(discountmainwindow);
				discountmainwindow.setSize(700,500);
				discountmainwindow.setLocationRelativeTo(null);
			}
		});
		btnDiscount.setToolTipText("DISCOUNT");
		btnDiscount.setSelected(true);
		btnDiscount.setRolloverIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/discount_c.png")));
		btnDiscount.setRolloverSelectedIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/discount_c.png")));
		btnDiscount.setMargin(new Insets(7, 6, 10, 1));
		btnDiscount.setPreferredSize(new Dimension(82, 29));
		btnDiscount.setRolloverEnabled(true);
		btnDiscount.setSelectedIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/discount_b.png")));
		btnDiscount.setIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/discount_b.png")));
		btnDiscount.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		btnDiscount.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(255, 175, 175)));
		btnDiscount.setBounds(26, 209, 114, 85);
		add(btnDiscount);
		
		// button for Reports
		JButton btnReports = new JButton("");
		btnReports.setBackground(Color.DARK_GRAY);
		btnReports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setupTextArea("\n\n\tREPORTS\n\tTo View\n                  Different Reports \n                   Click the Button");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setupTextArea("\n\n\tWelcome\n\t  to the \n            University Souvenir Store");
			}
		});
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportmainwindow = new ReportMainWindow();
				login.initializeWindow(reportmainwindow );
				reportmainwindow .setSize(1083,500);
				reportmainwindow .setLocationRelativeTo(null);
			}
		});
		btnReports.setToolTipText("GENERATE REPORTS");
		btnReports.setSelected(true);
		btnReports.setRolloverIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/report_c.png")));
		btnReports.setRolloverSelectedIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/report_c.png")));
		btnReports.setMargin(new Insets(0, 5, 3, 0));
		btnReports.setPreferredSize(new Dimension(82, 29));
		btnReports.setRolloverEnabled(true);
		btnReports.setSelectedIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/report_b.png")));
		btnReports.setIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/report_b.png")));
		btnReports.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		btnReports.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(255, 175, 175)));
        btnReports.setBounds(172, 209, 114, 85);
		add(btnReports);
		
		// button for Category
		JButton btnCategoryvendors = new JButton("");
		btnCategoryvendors.setBackground(Color.DARK_GRAY);
		btnCategoryvendors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setupTextArea("\n\n\tCATEGORY\n\tTo add or\n                   view Categories \n                   Click the Button");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setupTextArea("\n\n\tWelcome\n\t  to the \n            University Souvenir Store");
			}
		});
		btnCategoryvendors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				categorymainwindow = new CategoryMainWindow();
				login.initializeWindow(categorymainwindow );
				categorymainwindow .setSize(653,500);
				categorymainwindow .setLocationRelativeTo(null);
			}
		});
		btnCategoryvendors.setToolTipText("CATEGORIES");
		btnCategoryvendors.setSelected(true);
		btnCategoryvendors.setRolloverIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/category_c.png")));
		btnCategoryvendors.setRolloverSelectedIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/category_c.png")));
		btnCategoryvendors.setMargin(new Insets(0, 10, 6, 1));
		btnCategoryvendors.setPreferredSize(new Dimension(82, 29));
		btnCategoryvendors.setRolloverEnabled(true);
		btnCategoryvendors.setSelectedIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/category_b.png")));
		btnCategoryvendors.setIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/category_b.png")));
		btnCategoryvendors.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
	    btnCategoryvendors.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(255, 175, 175)));
		btnCategoryvendors.setBounds(26, 331, 114, 85);
		add(btnCategoryvendors);
		
		// button for Products
		JButton btnProducts = new JButton("");
		btnProducts.setBackground(Color.DARK_GRAY);
		btnProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setupTextArea("\n\tPRODUCTS\n\tTo add or\n                 view Products and\n                low stock Products\n                   Click the Button");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setupTextArea("\n\n\tWelcome\n\t  to the \n            University Souvenir Store");
			}
		});
		btnProducts.setToolTipText("PRODUCTS");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productmainwindow = new ProductMainWindow();
				login.initializeWindow(productmainwindow);
				productmainwindow.setSize(700,500);
				productmainwindow.setLocationRelativeTo(null);
				
			}
		});
		btnProducts.setSelected(true);
		btnProducts.setRolloverIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Products_c.png")));
		btnProducts.setRolloverSelectedIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Products_c.png")));
		btnProducts.setMargin(new Insets(0, 7, 6, 1));
		btnProducts.setPreferredSize(new Dimension(82, 29));
		btnProducts.setRolloverEnabled(true);
		btnProducts.setSelectedIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Products_b.png")));
		btnProducts.setIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/Products_b.png")));
		btnProducts.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		
		btnProducts.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(255, 175, 175)));
		
		btnProducts.setBounds(172, 331, 114, 85);
		add(btnProducts);
		
		//label for heading
		JLabel lblNewLabel = new JLabel("University Souvenir Store");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(292, 23, 309, 27);
		add(lblNewLabel);
		
		
		// button for Checkout
		JButton btnC = new JButton("");
		btnC.setBackground(Color.DARK_GRAY);
		btnC.setToolTipText("CHECKOUT");
		
		btnC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				    if(CheckoutController.getCheckoutInstance().resetCheckout())
				    {
				    checkoutframe = new CheckoutFrame();
					login.initializeWindow(checkoutframe);
					checkoutframe.setupFrame();
					
					checkoutframe.setSize(853,533);
					checkoutframe.setLocationRelativeTo(null); 
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null, "UNEXPECTED ERROR!","ERROR!",JOptionPane.ERROR_MESSAGE);
				    }
					
				}
			});
	
	
	
		
		btnC.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				setupTextArea("\n\n\tCHECKOUT\n\tTo make a\n\ttransaction \n                   Click the Button");
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setupTextArea("\n\n\tWelcome\n\t  to the \n            University Souvenir Store");
			}
				
		});

		btnC.setSelected(true);
		
		
		btnC.setRolloverIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/checkout_c.png")));
		btnC.setRolloverSelectedIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/checkout_c.png")));
		btnC.setMargin(new Insets(0, 7, 0, 1));
		btnC.setPreferredSize(new Dimension(82, 29));
		btnC.setRolloverEnabled(true);
		btnC.setSelectedIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/checkout_b.png")));
		btnC.setIcon(new ImageIcon(StorePanel.class.getResource("/sg/edu/nus/iss/souvenirstore/ui/icons/checkout_b.png")));
		btnC.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		btnC.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(255, 175, 175)));
        btnC.setBounds(26, 86, 114, 85);
		add(btnC);
		
		
}

	private void setupTextArea(String str){
		
		txtrWelcomeToThe.setEditable(false);
		txtrWelcomeToThe.setEnabled(false);
		txtrWelcomeToThe.setWrapStyleWord(true);
		txtrWelcomeToThe.setLineWrap(true);
		txtrWelcomeToThe.setSize(new Dimension(6, 6));
		txtrWelcomeToThe.setLocation(new Point(5, 31));
		txtrWelcomeToThe.setMargin(new Insets(52, 0, 0, 0));
		txtrWelcomeToThe.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		txtrWelcomeToThe.setText(str);
		txtrWelcomeToThe.setCaretColor(Color.WHITE);
		txtrWelcomeToThe.setForeground(Color.GRAY);
		txtrWelcomeToThe.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0))); 
		txtrWelcomeToThe.setDisabledTextColor(Color.WHITE);
		txtrWelcomeToThe.setBackground(Color.DARK_GRAY);
		txtrWelcomeToThe.setBounds(373, 86, 388, 330);
		
		}
}

		
	
	

