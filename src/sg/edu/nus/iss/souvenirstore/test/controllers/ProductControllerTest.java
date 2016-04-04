package sg.edu.nus.iss.souvenirstore.test.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.souvenirstore.controller.ProductController;

public class ProductControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddProduct() {
		assertEquals(false, ProductController.getProductInstance().addProduct("", "", "", 10, 10.0, "", 15, 50));
		assertEquals(false, ProductController.getProductInstance().addProduct("FOO", "Food", "Food", -10, 10.0, "12345", 15, 50));
		assertEquals(false, ProductController.getProductInstance().addProduct("FOO", "Food", "Food", 10, -10.0, "12345", 15, 50));
		assertEquals(false, ProductController.getProductInstance().addProduct("FOO", "Food", "Food", 10, 10.0, "12345", -15, 50));
		assertEquals(false, ProductController.getProductInstance().addProduct("FOO", "Food", "Food", 10, 10.0, "12345", 15, -50));
		assertEquals(true, ProductController.getProductInstance().addProduct("FOO", "Food", "Food", 10, 10.0, "12345", 15, 50));
	}

}
