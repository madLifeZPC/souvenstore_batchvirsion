package sg.edu.nus.iss.souvenirstore.test.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.souvenirstore.dao.FileEraser;

/**
 * Test Class for FileEraser
 * @author Zhao Pengcheng
 *
 */
public class FileEraserTest {

	private String fileName;
	
	@Before
	public void setUp() throws Exception {
		fileName = "Category";
	}

	@Test
	public void testEraseFileContent() {
		assertEquals(true, FileEraser.eraseFileContent(fileName));
	}

}
