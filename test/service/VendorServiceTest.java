package sg.edu.nus.iss.souvenirstore.test.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sg.edu.nus.iss.souvenirstore.domain.Vendor;
import sg.edu.nus.iss.souvenirstore.service.VendorService;

/**
 * Test Class for VendorService.
 * @author Zhao Pengcheng
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendorServiceTest {

	private VendorService vendorService;
	private Vendor vendor1;
	private Vendor vendor2;
	
	@Before
	public void setUp() throws Exception {
		vendorService = VendorService.getVendorService();
		vendor1 = new Vendor("Nancy's Gifts","Best of the best gifts from Nancy's");
		vendor2 = new Vendor("Office Souvenirs","One and the only Office Souvenirs");
	}

	/**
	 * testAddVendor
	 */
	@Test
	public void test001() {
		assertEquals(true, vendorService.addVendor("TOY", vendor1));
		assertEquals(true, vendorService.addVendor("TOY", vendor2));
	}
	
	/**
	 * testGetVendorList
	 */
	@Test
	public void test002() {
		try
		{
			ArrayList<Vendor> vendors = vendorService.getVendorList("TOY");
			assertEquals(2, vendors.size());
			assertEquals(vendor1, vendors.get(0));
			assertEquals(vendor2, vendors.get(1));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
