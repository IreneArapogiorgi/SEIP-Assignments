package inputreader;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

/**
 * A class that provides test cases for the
 * read file methods of the LocalReader class.
 * 
 * @author Irene Arapogiorgi
 */
public class LocalReaderTest {
	private static List<String> expectedList;
	private static String expectedString;
	private final static String filepath = "src/test/resources/TestClass.java";
	
	LocalReader lr = new LocalReader();
	
	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(filepath).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // Transforms a list into a String (with 'new line' as delimiter) 
	}

	/*
	 * A unit test that checks the correctness of readFileIntoList()
	 */
	@Test
	public void testReadFileIntoListLocal() throws IOException {
		// Read a locally stored file into a List
		List<String> actualList = lr.readFileIntoList(filepath);
		
		String[] expected = expectedList.stream().toArray(String[]::new);
		String[] actual = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expected, actual);
	}

	/*
	 * A unit test that checks the correctness of readFileIntoString()
	 */
	@Test
	public void testReadFileIntoStringLocal() throws IOException {
		// Read a locally stored file into a String
		String actual = lr.readFileIntoString(filepath);
				
		assertEquals(expectedString, actual);
	}
}
