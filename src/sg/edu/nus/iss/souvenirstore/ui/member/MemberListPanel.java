package sg.edu.nus.iss.souvenirstore.ui.member;
/*
 * Author : Rameswari Mohanty
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import sg.edu.nus.iss.souvenirstore.controller.MemberController;
import sg.edu.nus.iss.souvenirstore.domain.Member;
public class MemberListPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTable table;

	public MemberListPanel() {
		setBackground(Color.WHITE);
		

		createDiscountListPanel();
	}
	
	private void createDiscountListPanel(){
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		String[] colNames = {"MEMBER ID", "MEMBER NAME", "LOYALTY POINTS"};
		ArrayList<Member> memberList = MemberController.getMemberInstance().getMembersList();
		Object[][] data = new Object[memberList.size()][3];
		
		for(int i=0;i<memberList.size();i++)
		{
			data[i][0] = memberList.get(i).getCustomerId();
			data[i][1] = memberList.get(i).getMemberName();
			data[i][2] = memberList.get(i).getLoyaltyPoints();
		}
		table = new JTable(data,colNames);
		table.setBackground(new Color(224, 255, 255));
		table.setPreferredScrollableViewportSize(new Dimension(550,200));
	    table.setFillsViewportHeight(true);
	    table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JScrollPane scrollPane = new JScrollPane(table);
	    add(scrollPane);

	}
	
}
