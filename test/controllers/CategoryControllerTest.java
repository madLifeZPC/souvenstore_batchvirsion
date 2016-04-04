package sg.edu.nus.iss.souvenirstore.test.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import sg.edu.nus.iss.souvenirstore.controller.CategoryController;
import sg.edu.nus.iss.souvenirstore.domain.Category;

/**
 * 
 * @author Vignesh
 *
 */
public class CategoryControllerTest {

	@Test
	public void testAddCategory()
	{
		assertEquals(false, CategoryController.getCategoryInstance().addCategory("", ""));
		assertEquals(false, CategoryController.getCategoryInstance().addCategory(null, null));
		assertEquals(false, CategoryController.getCategoryInstance().addCategory("CLO", null));
		assertEquals(false, CategoryController.getCategoryInstance().addCategory(null,"Clothes"));
		assertEquals(true, CategoryController.getCategoryInstance().addCategory("CLO","Clothes"));
		assertEquals(false, CategoryController.getCategoryInstance().addCategory("CLO","Clothes"));
	}

}
