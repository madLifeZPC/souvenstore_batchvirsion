package sg.edu.nus.iss.souvenirstore.test.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sg.edu.nus.iss.souvenirstore.domain.Member;
import sg.edu.nus.iss.souvenirstore.domain.Product;
import sg.edu.nus.iss.souvenirstore.service.MemberService;

/**
 * Test Class for MemberService.
 * @author Zhao Pengcheng
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberServiceTest {

	private MemberService memberService;
	private Member member1;
	private Member member2;
	
	@Before
	public void setUp() throws Exception {
		memberService = MemberService.getMemberService();
		member1 = new Member("Zhao", "G1554980R");
		member2 = new Member("Vignesh", "G1554518Z");
	}

	/**
	 * testAddNewMember
	 */
	@Test
	public void test001() {
		assertEquals(true, memberService.addNewMember(member1));
		assertEquals(true, memberService.addNewMember(member2));
	}
	
	/**
	 * testUpdateMember
	 */
	@Test
	public void test002() {
		member1.setLoyaltyPoints(20);
		member2.setLoyaltyPoints(50);
		try {
			assertEquals(true, memberService.updateMember(member1));
			assertEquals(true, memberService.updateMember(member2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * testGetMemberList
	 */
	@Test
	public void test003() {
		member1.setLoyaltyPoints(20);
		member2.setLoyaltyPoints(50);
		try 
		{
			ArrayList<Member> members =  memberService.getMemberList();
			assertEquals(2, members.size());
			assertEquals(member1, members.get(0));
			assertEquals(member2, members.get(1));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * testGetMemberById
	 */
	@Test
	public void test004() {
		member1.setLoyaltyPoints(20);
		member2.setLoyaltyPoints(50);
		try {
			assertEquals(member1, memberService.getMemberById("G1554980R"));
			assertEquals(member2, memberService.getMemberById("G1554518Z"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
