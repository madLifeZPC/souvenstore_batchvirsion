package sg.edu.nus.iss.souvenirstore.service;

import java.util.ArrayList;

import sg.edu.nus.iss.souvenirstore.dao.DaoConstant;
import sg.edu.nus.iss.souvenirstore.dao.DataReader;
import sg.edu.nus.iss.souvenirstore.dao.DataWriter;
import sg.edu.nus.iss.souvenirstore.domain.Member;
import sg.edu.nus.iss.souvenirstore.exception.service.WrongItemFormatException;

/**
 * MemberService provides data operation interfaces on Members.dat.
 * @author Zhao Pengcheng
 *
 */
public class MemberService {
	
	private static MemberService memberService;
	
	private MemberService()
	{
		
	}
	
	public static MemberService getMemberService()
	{
		if( memberService == null )
		{
			memberService = new MemberService();
		}
		return memberService;
	}
	

	/**
	 * Get Member List
	 * @return
	 * @throws WrongItemFormatException
	 */
	public ArrayList<Member> getMemberList() throws WrongItemFormatException
	{
		ArrayList<Member> memberList = new ArrayList<>();
		
		ArrayList<String> fileContent = DataReader.read(Member.class.getSimpleName()+DaoConstant.NAME_SUFFIX);
		
		for( String item : fileContent )
		{
			String[] itemValues = item.split(DaoConstant.ITEM_SPLITER);
			if( itemValues.length!=3 )
			{
				throw new WrongItemFormatException("The format of one Member item is wrong");
			}
			Member member = new Member(itemValues[0], itemValues[1],Integer.parseInt(itemValues[2]));
			
			memberList.add(member);
		}
		
		return memberList;
	}
	
	/**
	 * Get a specific member by memberId, if the member does not exist, return null
	 * @param memberId
	 * @return
	 * @throws WrongItemFormatException
	 */
	public Member getMemberById( String memberId ) throws WrongItemFormatException
	{
		Member result = null;
		ArrayList<Member> memberList = getMemberList();
		for( Member member : memberList )
		{
			if( member.getCustomerId().equals(memberId))
			{
				result = member;
				break;
			}
		}
		return result;
	}
	
	/**
	 * transform member object to String
	 * @param member
	 * @return
	 */
	public String memberToString( Member member )
	{
		StringBuilder memberBuilder = new StringBuilder();
		memberBuilder.append(member.getMemberName());
		memberBuilder.append(DaoConstant.ITEM_SPLITER);
		memberBuilder.append(member.getCustomerId());
		memberBuilder.append(DaoConstant.ITEM_SPLITER);
		memberBuilder.append(String.valueOf(member.getLoyaltyPoints()));
		return memberBuilder.toString();
	}
	
	/**
	 * Add new Member
	 * @param member
	 * @return
	 */
	public boolean addNewMember( Member member ) 
	{
		return DataWriter.appendOne(Member.class.getSimpleName()+DaoConstant.NAME_SUFFIX, 
				memberToString(member));
	}
	
	/**
	 * Update the information of member into file
	 * @param newMember
	 * @return
	 * @throws WrongItemFormatException
	 */
	public boolean updateMember( Member newMember ) throws WrongItemFormatException
	{
		Member oldMember = getMemberById(newMember.getCustomerId());
		if( oldMember == null ) return false;
		return DataWriter.replaceLine(Member.class.getSimpleName()+DaoConstant.NAME_SUFFIX, 
				memberToString(oldMember), memberToString(newMember));
	}

}
