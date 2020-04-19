package math;

import io.FileIO;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.*;

/**
 * A class that provides test cases for the array
 * operations of the ArrayOperations class.
 * 
 * @author Irene Arapogiorgi
 * @version 1.0
 * @since   2020-04-16
 */
public class ArrayOperationsTest {
	ArrayOperations ao = new ArrayOperations();
	
	/*
	 * A unit test that checks correctness of
	 * findPrimesInFile method using Mocking
	 */
	@Test
	public void testFindPrimesInFile() {
		// Mock the FileIO dependency
		FileIO fileio = mock(FileIO.class);
		
		String filepath = "src/test/resources/integers.txt";
		
		when(fileio.readFile(filepath)).thenReturn(new int[]{2, 3, 4, 5, 6, 7, 8});
		
		// Mock the MyMath dependency
		MyMath mymath = mock(MyMath.class);
		
		when(mymath.isPrime(2)).thenReturn(true);
		when(mymath.isPrime(3)).thenReturn(true);
		when(mymath.isPrime(4)).thenReturn(false);
		when(mymath.isPrime(5)).thenReturn(true);
		when(mymath.isPrime(6)).thenReturn(false);
		when(mymath.isPrime(7)).thenReturn(true);
		when(mymath.isPrime(8)).thenReturn(false);
		
		Assert.assertArrayEquals(new int[]{2, 3, 5, 7}, ao.findPrimesInFile(fileio, filepath, mymath));
	}
}