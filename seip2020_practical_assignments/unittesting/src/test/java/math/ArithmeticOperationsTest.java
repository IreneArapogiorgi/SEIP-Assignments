package math;

import org.junit.Test;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

/**
 * A class that provides test cases for the simple
 * math operations of the ArithmeticOperations class.
 * 
 * @author Irene Arapogiorgi
 * @version 1.0
 * @since   2020-04-10
 */
public class ArithmeticOperationsTest {
	
	private static final double DELTA = 1e-15;
	ArithmeticOperations operation = new ArithmeticOperations();
	
	/*
	 * A unit test that checks correctness of division operation
	 */
    @Test
    public void testDivisionResult() {
    	Assert.assertEquals(10.0, operation.divide(20.0, 2.0), DELTA);
    }
    
    /*
	 * A unit test that checks an invalid zero denominator
	 * input that causes an ArithmeticException
	 */
    @Test (expected = ArithmeticException.class)
    public void testDivisionShouldCauseAnException() {
    	operation.divide(8.0, 0.0);
    }
    
    /*
	 * A unit test that checks correctness of multiplication operation
	 */
    @Test
    public void testMultiplicationResult() {
    	Assert.assertEquals(6, operation.multiply(2, 3), DELTA);
    }
    
    /*
	 * A unit test that checks the multiplication operation
	 * with input value x equal to zero.
	 */
    @Test
    public void testMultiplicationResultWhenXZero() {
    	Assert.assertEquals(0, operation.multiply(0, 3), DELTA);
    }
    
    /*
	 * A unit test that checks the multiplication operation
	 * with input value y equal to zero.
	 */
    @Test
    public void testMultiplicationResultWhenYZero() {
    	Assert.assertEquals(0, operation.multiply(2, 0), DELTA);
    }
    
    /*
	 * A unit test that checks the multiplication operation
	 * with both input values equal to zero.
	 */
    @Test
    public void testMultiplicationResultWhenBothZero() {
    	Assert.assertEquals(0, operation.multiply(0, 0), DELTA);
    }
    
    @Rule
	public ExpectedException thrown = ExpectedException.none(); // Initialize it to .none()
    
    /*
	 * A test case for the exception caused when
	 * both input values are negative. Testing
	 * the exception is performed with a @Rule
	 */
	@Test 
	public void testMultiplyShouldThrowExceptionOnNegativeInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		operation.multiply(-2, -3);
	}
	
	/*
	 * A test case for the exception caused when
	 * the input value y is negative. Testing
	 * the exception is performed with a @Rule
	 */
	@Test 
	public void testMultiplyShouldThrowExceptionOnNegativeInputY() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		operation.multiply(2, -3);
	}
	
	/*
	 * A test case for the exception caused when
	 * the input value x is negative. Testing
	 * the exception is performed with a @Rule
	 */
	@Test 
	public void testMultiplyShouldThrowExceptionOnNegativeInputX() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		operation.multiply(-2, 3);
	}
	
	/*
	 * A test case for the exception caused when the
	 * product does not fit in an Integer variable.
	 * Testing the exception is performed with a @Rule
	 */
	@Test
	public void testMultiplyShouldThrowExceptionWhenProductDoesNotFit() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable.");
		operation.multiply(Integer.MAX_VALUE, 2);
	}
}