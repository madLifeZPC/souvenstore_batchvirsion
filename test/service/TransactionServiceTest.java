package sg.edu.nus.iss.souvenirstore.test.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sg.edu.nus.iss.souvenirstore.domain.CheckoutItem;
import sg.edu.nus.iss.souvenirstore.domain.Transaction;
import sg.edu.nus.iss.souvenirstore.service.ProductService;
import sg.edu.nus.iss.souvenirstore.service.TransactionService;

/**
 * Test Class for TransactionService.
 * @author Zhao Pengcheng
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionServiceTest {

	private TransactionService transactionService;
	private Transaction transaction1;
	private Transaction transaction2;
	private ArrayList<CheckoutItem> checkoutItems1;
	private ArrayList<CheckoutItem> checkoutItems2;
	
	@Before
	public void setUp() throws Exception {
		transactionService = TransactionService.getTransactionService();
		
		checkoutItems1 = new ArrayList<>();
		checkoutItems1.add(new CheckoutItem(ProductService.getProductService().getProductByBarcode("1234"), 5));
		checkoutItems1.add(new CheckoutItem(ProductService.getProductService().getProductByBarcode("123574"), 3));
		transaction1 = new Transaction(1, checkoutItems1, "G1554980R", "2015-06-13");
		
		checkoutItems2 = new ArrayList<>();
		checkoutItems2.add(new CheckoutItem(ProductService.getProductService().getProductByBarcode("1234"), 5));
		checkoutItems2.add(new CheckoutItem(ProductService.getProductService().getProductByBarcode("123574"), 3));
		transaction2 = new Transaction(2, checkoutItems2, "G1554518Z", "2015-06-18");
	}

	/**
	 * testAddTransaction
	 */
	@Test
	public void test001() {
		assertEquals(true, transactionService.addTransaction(transaction1));
		assertEquals(true, transactionService.addTransaction(transaction2));
	}
	
	/**
	 * testGetTransactionList
	 */
	@Test
	public void test002() {
		try 
		{
			ArrayList<Transaction> transactions =  transactionService.getTransactionList();
			assertEquals(2, transactions.size());
			assertEquals(transaction1, transactions.get(0));
			assertEquals(transaction2, transactions.get(1));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * testGetTransactionsByDate
	 */
	@Test
	public void test003() {
		try 
		{
			ArrayList<Transaction> transactions =  transactionService.getTransactionsByDate("2015-05-12", "2015-06-15");
			assertEquals(1, transactions.size());
			assertEquals(transaction1, transactions.get(0));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * testGenerateTransactionId
	 */
	@Test
	public void test004() {
		assertEquals(3, transactionService.generateTransactionId());
	}

}
