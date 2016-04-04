package sg.edu.nus.iss.souvenirstore.test.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.souvenirstore.controller.VendorController;

public class VendorControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddVendor() {
		ArrayList<String> catID = new ArrayList<>();
		catID.add("CLO");
		assertEquals(false, VendorController.getVendorInstance().addVendor("", "", catID));
		assertEquals(true, VendorController.getVendorInstance().addVendor("sdfsdf", "sdfsdf", catID));
	}
}
