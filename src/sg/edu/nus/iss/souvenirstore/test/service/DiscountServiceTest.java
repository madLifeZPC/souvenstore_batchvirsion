package sg.edu.nus.iss.souvenirstore.test.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sg.edu.nus.iss.souvenirstore.domain.Discount;
import sg.edu.nus.iss.souvenirstore.domain.FirstPurchaseDiscount;
import sg.edu.nus.iss.souvenirstore.domain.PublicDiscount;
import sg.edu.nus.iss.souvenirstore.domain.SubsequentDiscount;
import sg.edu.nus.iss.souvenirstore.service.DiscountService;

/**
 * Test Class for DiscountService.
 * @author Zhao Pengcheng
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DiscountServiceTest {

	private DiscountService discountService;
	private Discount discount1;
	private Discount discount2;
	private Discount discount3;
	private Discount discount4;
	private Discount discount5;
	
	@Before
	public void setUp() throws Exception {
		discountService = DiscountService.getDiscountService();
		discount1 = new FirstPurchaseDiscount("MEMBER_FIRST", "First purchase by member", 20);
		discount2 = new SubsequentDiscount("MEMBER_SUBSEQ", "Subsequent purchase by member", 10);
		discount3 = new PublicDiscount("CENTENARY", "Centenary Celebration in 2016", "2016-01-01", "365", 15);
		discount4 = new PublicDiscount("PRESIDENT_BDAY", "University president's birthday", "2016-04-04", "7", 20);
		discount5 = new PublicDiscount("ORIENTATION_DAY", "Orientation Day", "2016-03-10", "10", 20);
	}

	/**
	 * testAddDiscount
	 */
	@Test
	public void test001() {
		assertEquals(true, discountService.addDiscount(discount1));
		assertEquals(true, discountService.addDiscount(discount2));
		assertEquals(true, discountService.addDiscount(discount3));
		assertEquals(true, discountService.addDiscount(discount4));
		assertEquals(true, discountService.addDiscount(discount5));
	}
	
	/**
	 * testUpdateDiscount
	 */
	@Test
	public void test002() {
		discount1.setPercentage(30);
		try {
			assertEquals(true, discountService.updateDiscount(discount1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * testGetProductList
	 */
	@Test
	public void test003() {
		discount1.setPercentage(30);
		try 
		{
			ArrayList<Discount> discounts =  discountService.getDiscountList();
			assertEquals(5, discounts.size());
			assertEquals(discount1, discounts.get(0));
			assertEquals(discount2, discounts.get(1));
			assertEquals(discount3, discounts.get(2));
			assertEquals(discount4, discounts.get(3));
			assertEquals(discount5, discounts.get(4));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * testGetProductByCode
	 */
	@Test
	public void test004() {	
		discount1.setPercentage(30);
		try {
			assertEquals(discount1, discountService.getDiscountByCode(discount1.getDiscountCode()));
			assertEquals(discount2, discountService.getDiscountByCode(discount2.getDiscountCode()));
			assertEquals(discount3, discountService.getDiscountByCode(discount3.getDiscountCode()));
			assertEquals(discount4, discountService.getDiscountByCode(discount4.getDiscountCode()));
			assertEquals(discount5, discountService.getDiscountByCode(discount5.getDiscountCode()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * testGetFirstPurchaseDiscount
	 */
	@Test
	public void test005() {	
		discount1.setPercentage(30);
		try {
			assertEquals(discount1.getPercentage(), discountService.getFirstPurchaseDiscount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * testGetBestDiscount
	 */
	@Test
	public void test006() {
		try {
			assertEquals(discount5.getPercentage(), discountService.getBestDiscount(Discount.APPLICABLE_TO_ALL));
			assertEquals(discount5.getPercentage(), discountService.getBestDiscount(Discount.APPLICABLE_TO_MEMBER));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * testIsBeyondDuration
	 */
	@Test
	public void test007() {
		assertEquals(false, discountService.isBeyondDuration(discount1));
		assertEquals(false, discountService.isBeyondDuration(discount2));
		assertEquals(false, discountService.isBeyondDuration(discount3));
		assertEquals(true, discountService.isBeyondDuration(discount4));
		assertEquals(false, discountService.isBeyondDuration(discount5));
	}
}
