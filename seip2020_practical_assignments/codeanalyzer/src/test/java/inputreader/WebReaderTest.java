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
 * read file methods of the WebReader class.
 * 
 * @author Irene Arapogiorgi
 */
public class WebReaderTest {
	private static List<String> expectedList;
	private static String expectedString;
	private final static String filepath = "src/test/resources/TestClass.java";
	private final static String webpath ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	
	WebReader wr = new WebReader();
	
	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(filepath).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter) 
	}

	/*
	 * A unit test that checks the correctness of readFileIntoList()
	 */
	@Test
	public void testReadFileIntoListWeb() throws IOException {
		// Read a file stored in the web into a List
		List<String> actualList = wr.readFileIntoList(webpath);
		
		String[] expected = expectedList.stream().toArray(String[]::new);
		String[] actual = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expected, actual);
	}

	/*
	 * A unit test that checks the correctness of readFileIntoString()
	 */
	@Test
	public void testReadFileIntoStringWeb() throws IOException {
		// Read a file stored in the web into a String
		String actual = wr.readFileIntoString(webpath);
				
		assertEquals(expectedString, actual);
	}
}
