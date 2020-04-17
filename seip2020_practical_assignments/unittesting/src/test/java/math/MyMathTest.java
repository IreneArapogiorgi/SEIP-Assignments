package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * A class that provides test cases for the 
 * factorial operation of MyMath class.
 * 
 * @author Irene Arapogiorgi
 * @version 1.0
 * @since   2020-04-17
 */
public class MyMathTest {
	
	MyMath mm = new MyMath();
	
	/*
	 * A unit test that checks correctness of isPrime
	 * method when input value n is a prime number.
	 */
    @Test
    public void testIsPrimeTrueOutput() {
    	Assert.assertTrue(mm.isPrime(5));
    }
    
	/*
	 * A unit test that checks correctness of isPrime
	 * method when input value n is a non-prime number.
	 */
    @Test
    public void testIsPrimeFalseOutput() {
    	Assert.assertFalse(mm.isPrime(4));
    }
	
    @Rule
	public ExpectedException thrown = ExpectedException.none(); // Initialize it to .none()
    
    /*
	 * A test case for the exception caused when
	 * parameter n is negative in factorial method.
	 * Testing the exception is performed with a @Rule
	 */
	@Test 
	public void testFactorialShouldThrowExceptionOnNegativeInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Parameter n cannot be negative.");
		mm.factorial(-2);
	}
	
	/*
	 * A test case for the exception caused when
	 * parameter n is larger than 20 in factorial method.
	 * Testing the exception is performed with a @Rule
	 */
	@Test
	public void testFactorialShouldThrowExceptionOnBigInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Parameter n cannot be larger than 20.");
		mm.factorial(25);
	}
	
	/*
	 * A test case for the exception caused when
	 * parameter n is smaller than 2 in isPrime method.
	 * Testing the exception is performed with a @Rule
	 */
	@Test
	public void testIsPrimeShouldThrowExceptionOnInputSmallerThanTwo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Parameter n cannot be smaller than 2.");
		mm.isPrime(1);
	}
}