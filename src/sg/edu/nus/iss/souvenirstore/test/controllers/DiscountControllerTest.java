package sg.edu.nus.iss.souvenirstore.test.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.souvenirstore.controller.DiscountController;
import sg.edu.nus.iss.souvenirstore.domain.Discount;
import sg.edu.nus.iss.souvenirstore.domain.FirstPurchaseDiscount;
import sg.edu.nus.iss.souvenirstore.domain.SubsequentDiscount;

/**
 * 
 * @author Vignesh
 *
 */
public class DiscountControllerTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testGetAllDiscounts() {
		FirstPurchaseDiscount firstPurchaseDiscount = new FirstPurchaseDiscount(Discount.FIRST_PURCHASE_CODE, "First purchase by member", 20);
		SubsequentDiscount subsequentDiscount = new SubsequentDiscount(Discount.SUBSEQUENT_PURCHASE_CODE, "Subsequent purchase by member", 10);
		ArrayList<Discount> discounts = DiscountController.getDiscountInstance().getAllDiscounts();
		assertEquals(5, discounts.size());
		assertEquals(firstPurchaseDiscount, discounts.get(0));
		assertEquals(subsequentDiscount, discounts.get(1));
	}

	@Test
	public void testAddNewNonMemberDiscount() {
		assertEquals(false, DiscountController.getDiscountInstance().addNewNonMemberDiscount("", "", "", "", 0));
		assertEquals(true, DiscountController.getDiscountInstance().addNewNonMemberDiscount("Spring festival", "Discount for Chinese new year", "2016-02-01", "10", 5));
	}
	
	@Test
	public void testGetBestMemberDiscountPercentage() {
		assertEquals(20, DiscountController.getDiscountInstance().getBestMemberDiscountPercentage("MEMBER1"));
		assertEquals(15, DiscountController.getDiscountInstance().getBestMemberDiscountPercentage("G1554980R"));
	}
	
	@Test
	public void testGetBestNonMemberDiscountPercentage() {
		assertEquals(15, DiscountController.getDiscountInstance().getBestNonMemberDiscountPercentage());
	}
}
