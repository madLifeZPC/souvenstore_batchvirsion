package sg.edu.nus.iss.souvenirstore.test.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sg.edu.nus.iss.souvenirstore.domain.Category;
import sg.edu.nus.iss.souvenirstore.service.CategoryService;

/**
 * Test Class for CategoryService.
 * @author Zhao Pengcheng
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryServiceTest {

	private CategoryService categoryService;
	private Category category1;
	private Category category2;
	private Category category3;
	private Category category4;
	
	@Before
	public void setUp() throws Exception {
		categoryService = CategoryService.getCategoryService();
		category1 = new Category("FOO","Food");
		category2 = new Category("BOO","Books");
		category3 = new Category("TOY","Toys");
		category4 = new Category("DRI", "Drinks");
	}

	/**
	 * testAddNewCategory
	 */
	@Test
	public void test001() {
		try 
		{
			assertEquals(true, categoryService.addNewCategory(category1));
			assertEquals(true, categoryService.addNewCategory(category2));
			assertEquals(true, categoryService.addNewCategory(category3));
			assertEquals(true, categoryService.addNewCategory(category4));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * testGetCategoryList
	 */
	@Test
	public void test002() {
		try 
		{
			ArrayList<Category> categories = categoryService.getCategoryList();
			assertEquals(4, categories.size());
			assertEquals(category1, categories.get(0));
			assertEquals(category2, categories.get(1));
			assertEquals(category3, categories.get(2));
			assertEquals(category4, categories.get(3));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * testGenerateNewProductId
	 */
	@Test
	public void test003() {
		String productId = categoryService.generateNewProductId(category1);
		assertEquals("FOO/1", productId);
	}

}
