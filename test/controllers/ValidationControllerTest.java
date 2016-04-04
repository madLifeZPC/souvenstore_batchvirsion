package sg.edu.nus.iss.souvenirstore.test.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.souvenirstore.controller.ValidationController;

public class ValidationControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsInt() {
		assertEquals(false, ValidationController.getValidationInstance().isInt(""));
		assertEquals(false, ValidationController.getValidationInstance().isInt("sdfdsf"));
		assertEquals(true, ValidationController.getValidationInstance().isInt("10"));
	}

	@Test
	public void testIsDouble() {
		assertEquals(false, ValidationController.getValidationInstance().isDouble(""));
		assertEquals(false, ValidationController.getValidationInstance().isDouble("sdfdsf"));
		assertEquals(true, ValidationController.getValidationInstance().isDouble("10"));
		assertEquals(true, ValidationController.getValidationInstance().isDouble("10.0"));
	}
	
	@Test
	public void testValidateCatCode() {
		assertEquals(false, ValidationController.getValidationInstance().validateCatCode(""));
		assertEquals(false, ValidationController.getValidationInstance().validateCatCode("123"));
		assertEquals(true, ValidationController.getValidationInstance().validateCatCode("CLO"));
	}
	
	@Test
	public void testValidateDiscountPercentage() {
		assertEquals(false, ValidationController.getValidationInstance().validateDiscountPercentage(""));
		assertEquals(false, ValidationController.getValidationInstance().validateDiscountPercentage("sfdsf"));
		assertEquals(false, ValidationController.getValidationInstance().validateDiscountPercentage("180"));
		assertEquals(true, ValidationController.getValidationInstance().validateDiscountPercentage("20"));
	}
	
	@Test
	public void testValidateDiscountDate() {
		assertEquals(false, ValidationController.getValidationInstance().validateDiscountDate(""));
		assertEquals(false, ValidationController.getValidationInstance().validateDiscountDate("sfsdf"));
		assertEquals(false, ValidationController.getValidationInstance().validateDiscountDate("2013-10-12"));
		assertEquals(true, ValidationController.getValidationInstance().validateDiscountDate("2016-04-02"));
	}
	
	@Test
	public void testValidateDiscountDuration() {
		assertEquals(false, ValidationController.getValidationInstance().validateDiscountDuration(""));
		assertEquals(false, ValidationController.getValidationInstance().validateDiscountDuration("sdfsdf"));
		assertEquals(true, ValidationController.getValidationInstance().validateDiscountDuration("ALWAYS"));
		assertEquals(true, ValidationController.getValidationInstance().validateDiscountDuration("15"));
	}
	
}
