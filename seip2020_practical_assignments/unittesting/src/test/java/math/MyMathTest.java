package math;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * A class that provides test cases for the 
 * factorial operation of MyMath class.
 * 
 * @author Irene Arapogiorgi
 * @version 1.0
 * @since   2020-04-10
 */
public class MyMathTest {
	
	MyMath mm = new MyMath();
	
    @Rule
	public ExpectedException thrown = ExpectedException.none(); // Initialize it to .none()
    
    /*
	 * A test case for the exception caused when
	 * parameter n is negative. Testing the
	 * exception is performed with a @Rule
	 */
	@Test 
	public void testFactorialShouldThrowExceptionOnNegativeInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Parameter n cannot be negative.");
		mm.factorial(-2);
	}
	
	/*
	 * A test case for the exception caused when
	 * parameter n is larger than 20. Testing
	 * the exception is performed with a @Rule
	 */
	@Test
	public void testFactorialShouldThrowExceptionOnBigInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Parameter n cannot be larger than 20.");
		mm.factorial(25);
	}
}