package sg.edu.nus.iss.souvenirstore.test.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.souvenirstore.dao.FileCreator;

/**
 * Test Class for FileCreator
 * @author Zhao Pengcheng
 *
 */
public class FileCreatorTest {

	private String fileName;
	@Before
	public void setUp() throws Exception {
		fileName = "test";
	}

	@Test
	public void testCreateDataFile() {
		try {
			assertEquals(true, FileCreator.createDataFile(fileName));
		} catch (Exception e) {
			fail();
		}
	}

}
