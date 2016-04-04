package sg.edu.nus.iss.souvenirstore.test.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.souvenirstore.controller.MemberController;

/**
 * 
 * @author Vignesh
 *
 */
public class MemberControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddMember() {
		assertEquals(false, MemberController.getMemberInstance().addMember("", ""));
		assertEquals(false, MemberController.getMemberInstance().addMember("Zhao", "G1554980R"));
		assertEquals(true, MemberController.getMemberInstance().addMember("Ram", "G1584854E"));
	}
}
