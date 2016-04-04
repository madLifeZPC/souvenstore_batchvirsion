package sg.edu.nus.iss.souvenirstore.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.souvenirstore.dao.DataReader;

/**
 * Test Class for DataReader
 * @author Zhao Pengcheng
 *
 */
public class DataReaderTest {

	private String fileName;
	
	@Before
	public void setUp() throws Exception {
		fileName = "Category";
	}

	@Test
	public void testRead() {
		
		ArrayList<String> strings = DataReader.read(fileName);
		assertEquals(3,strings.size());
		assertEquals("CLO,Clothing", strings.get(0));
		assertEquals("ELE,Electronics", strings.get(1));
		assertEquals("FOO,Food", strings.get(2));
	}

	@Test
	public void testReadLastLine() {
		assertEquals("FOO,Food", DataReader.readLastLine(fileName));
	}
}
