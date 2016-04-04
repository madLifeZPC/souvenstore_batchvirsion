package sg.edu.nus.iss.souvenirstore.test.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.souvenirstore.domain.StoreKeeper;
import sg.edu.nus.iss.souvenirstore.service.StoreKeeperService;

/**
 * Test Class for StoreKeeperService.
 * @author Zhao Pengcheng
 *
 */
public class StoreKeeperServiceTest {

	private StoreKeeperService storeKeeperService;
	private StoreKeeper storeKeeper1;
	private StoreKeeper storeKeeper2;
	
	@Before
	public void setUp() throws Exception {
		storeKeeperService = StoreKeeperService.getStorekeeperService();
		storeKeeper1 = new StoreKeeper("Stacy", "Dean56s");
		storeKeeper2 = new StoreKeeper("Johny", "A12ysd45");
	}

	@Test
	public void testGetStoreKeeperList() {
		try 
		{
			ArrayList<StoreKeeper> storeKeepers = storeKeeperService.getStoreKeeperList();
			assertEquals(2, storeKeepers.size());
			assertEquals(storeKeeper1, storeKeepers.get(0));
			assertEquals(storeKeeper2, storeKeepers.get(1));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
