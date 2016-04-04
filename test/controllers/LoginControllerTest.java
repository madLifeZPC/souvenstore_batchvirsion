package sg.edu.nus.iss.souvenirstore.test.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.souvenirstore.controller.LoginController;

/**
 * 
 * @author Vignesh
 *
 */
public class LoginControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAuthenticateUser() {
		assertEquals(true, LoginController.getLoginInstance().authenticateUser("Stacy", "Dean56s"));
		assertEquals(false, LoginController.getLoginInstance().authenticateUser("", ""));
		assertEquals(false, LoginController.getLoginInstance().authenticateUser("Stacy", ""));
	}

}
