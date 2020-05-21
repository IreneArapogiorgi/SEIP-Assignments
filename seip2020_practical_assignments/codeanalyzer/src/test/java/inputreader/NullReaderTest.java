package inputreader;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that provides test cases for the
 * read file methods of the NullReader class.
 * 
 * @author Irene Arapogiorgi
 */
public class NullReaderTest {
	private static List<String> expectedList = new ArrayList<>();
	private static String expectedString = "";
	private final static String filepath = "any-filepath";

	NullReader nr = new NullReader();

	/*
	 * A unit test that checks the correctness of readFileIntoList()
	 */
	@Test
	public void testReadFileIntoListWeb() throws IOException {
		//read a file stored in the web into a List
		List<String> actualList = nr.readFileIntoList(filepath);
		
		String[] expected = expectedList.stream().toArray(String[]::new);
		String[] actual = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expected, actual);
	}

	/*
	 * A unit test that checks the correctness of readFileIntoString()
	 */
	@Test
	public void testReadFileIntoStringWeb() throws IOException {
		//read a file stored in the web into a String
		String actual = nr.readFileIntoString(filepath);
				
		assertEquals(expectedString, actual);
	}
}
