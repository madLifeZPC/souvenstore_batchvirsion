package sg.edu.nus.iss.souvenirstore.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sg.edu.nus.iss.souvenirstore.dao.DataWriter;

/**
 * Test Class for DataWriter
 * @author Zhao Pengcheng
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataWriterTest {

	private String fileName;
	
	@Before
	public void setUp() throws Exception {
		fileName = "Category";
	}

	/**
	 * testAppend
	 */
	@Test
	public void test001() {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("DRI,Drinks");
		strings.add("BOO,Books");
		assertEquals(true, DataWriter.append(fileName, strings));
	}
	
	/**
	 * testAppendOne
	 */
	@Test
	public void test002() {
		String string = "TOY,Toys";
		assertEquals(true, DataWriter.appendOne(fileName, string));
	}
	
	/**
	 * testReplaceLine
	 */
	@Test
	public void test003() {
		assertEquals(true, DataWriter.replaceLine(fileName, "DRI,Drinks","FOO,Food"));
		assertEquals(false, DataWriter.replaceLine(fileName, "ELE,Electronics","FOO,Food"));
	}

}
