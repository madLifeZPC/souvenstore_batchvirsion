package sg.edu.nus.iss.souvenirstore.test.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sg.edu.nus.iss.souvenirstore.domain.Product;
import sg.edu.nus.iss.souvenirstore.service.ProductService;

/**
 * Test Class for ProductService.
 * @author Zhao Pengcheng
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest {

	private ProductService productService;
	private Product product1;
	private Product product2;
	private Product product3;
	private Product product4;
	private Product product5;
	private Product product6;
	
	@Before
	public void setUp() throws Exception {
		productService = ProductService.getProductService();
		product1 = new Product("FOO/1", "Chicken", "Chicken legs", 300, 15, "1234", 10, 150);
		product2 = new Product("BOO/1", "Life in Singapore", "Singapore Introduction", 20, 50, "123574", 50, 100);
		product3 = new Product("DRI/1", "Orange", "Orange juice", 10, 5, "135468", 20, 100);
		product4 = new Product("TOY/1", "Teddy", "Teddy bear", 100, 20, "584625", 10, 100);
		product5 = new Product("BOO/2", "NUS", "NUS Introduction", 20, 30, "155461", 10, 100);
		product6 = new Product("BOO/2", "NUS", "NUS Introduction", 15, 30, "155461", 10, 100);
	}

	/**
	 * testAddNewProduct
	 */
	@Test
	public void test001() {
		assertEquals(true, productService.addNewProduct(product1));
		assertEquals(true, productService.addNewProduct(product2));
		assertEquals(true, productService.addNewProduct(product3));
		assertEquals(true, productService.addNewProduct(product4));
		assertEquals(true, productService.addNewProduct(product5));
	}
	
	/**
	 * testGetProductList
	 */
	@Test
	public void test002() {
		try 
		{
			ArrayList<Product> products =  productService.getProductList();
			assertEquals(5, products.size());
			assertEquals(product1, products.get(0));
			assertEquals(product2, products.get(1));
			assertEquals(product3, products.get(2));
			assertEquals(product4, products.get(3));
			assertEquals(product5, products.get(4));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * testGetProductUnderThreshold
	 */
	@Test
	public void test003() {
		try 
		{
			ArrayList<Product> products =  productService.getProductsUnderThreshold();
			assertEquals(2, products.size());
			assertEquals(product2, products.get(0));
			assertEquals(product3, products.get(1));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * testUpdateProduct
	 */
	@Test
	public void test004() {
		try {
			assertEquals(true, productService.updateProduct(product6));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * testGetProductById
	 */
	@Test
	public void test005() {
		try {
			assertEquals(product6, productService.getProductById("BOO/2"));
			assertEquals(null, productService.getProductById("BOO/3"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * testGetProductByBarCode
	 */
	@Test
	public void test006() {
		try {
			assertEquals(product6, productService.getProductByBarcode("155461"));
			assertEquals(null, productService.getProductByBarcode("6548351"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
