package sg.edu.nus.iss.souvenirstore.controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sg.edu.nus.iss.souvenirstore.domain.Member;
import sg.edu.nus.iss.souvenirstore.service.MemberService;

/**
 * 
 * @author Vignesh
 *
 */
public class MemberController {
	
	private static MemberController memberInstance = new MemberController();
	private MemberController()
	{
		
	}
	
	public static MemberController getMemberInstance()
	{
		return memberInstance;
	}
	

	public boolean addMember(String memID, String memName)
	{
		
		try
		{
			if(memID.equals("") || memName.equals(""))
			{
				return false;
			}
			ArrayList<Member> memList = MemberService.getMemberService().getMemberList();
			for(int i=0;i<memList.size();i++)
			{
				if(memList.get(i).getCustomerId().equals(memID))
				{
					//member ID a;ready exists
					return false;
				}	
			}
			Member newMem = new Member(memID,memName, -1);
			MemberService.getMemberService().addNewMember(newMem);
			return true;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
		
			return false;
		}
	}
	
	public ArrayList<Member> getMembersList()
	{
		try
		{
			return MemberService.getMemberService().getMemberList();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			
			return null;
		}
		
	}
	
	public Member getMemberById(String memId)
	{
		try
		{
		return MemberService.getMemberService().getMemberById(memId);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), e.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
			
			return null;
		}
	}
	
	public boolean setLoyaltyPoints(String memID, int lPoints)
	{
		try
		{
		Member m = new Member();
		m.setCustomerId(memID);
		m.setMemberName(MemberService.getMemberService().getMemberById(memID).getMemberName());
		m.setLoyaltyPoints(lPoints);
		MemberService.getMemberService().updateMember(m);
		return true;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.toString(),"ERROR!",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
