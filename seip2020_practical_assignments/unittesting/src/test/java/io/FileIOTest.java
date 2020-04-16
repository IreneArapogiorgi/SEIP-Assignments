package io;

import org.junit.Test;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

/**
 * A class that provides test cases for
 * the readFile method of the FileIO class.
 * 
 * @author Irene Arapogiorgi
 * @version 1.0
 * @since   2020-04-16
 */
public class FileIOTest {
	
	FileIO fileio = new FileIO();
	int[] expected = {2, 4, 6, 8, 10};
	
	/*
	 * A unit test that checks correctness of readFile method
	 */
    @Test
    public void testReadFileOutput() {
    	int[] actual = fileio.readFile("src/test/resources/integers.txt");
    	Assert.assertArrayEquals(expected, actual);
    }
    
	/*
	 * A unit test that checks the readFile method with
	 * input file containing Integers and non-Integer values.
	 */
	@Test 
	public void testReadFileContainsInvalidEntries() {
    	int[] actual = fileio.readFile("src/test/resources/nonintegers.txt");
    	Assert.assertArrayEquals(expected, actual);
	}
    
    @Rule
	public ExpectedException thrown = ExpectedException.none(); // Initialize it to .none()
    
    /*
	 * A test case for the exception caused when
	 * given file does not exist. Testing the
	 * exception is performed with a @Rule
	 */
	@Test 
	public void testReadFileShouldThrowExceptionWhenFileNotExist() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		fileio.readFile("src/test/resources/nonexistingfile.txt");
	}
	
    /*
	 * A test case for the exception caused when
	 * given file is empty. Testing the
	 * exception is performed with a @Rule
	 */
	@Test 
	public void testReadFileShouldThrowExceptionOnEmptyFile() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		fileio.readFile("src/test/resources/emptyfile.txt");
	}
}