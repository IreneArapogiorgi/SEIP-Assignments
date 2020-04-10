package math;

/**
 * MyMath class provides more arithmetic operations
 * that serve as hands-on practice on Unit Testing.
 * 
 * @author Irene Arapogiorgi
 * @version 1.0
 * @since   2020-04-10
 */
public class MyMath {
	
	/**
	 * Calculates the factorial of a given parameter n.
	 * @param n the number for which we seek the factorial
	 * @return the factorial of number n
	 * @exception IllegalArgumentException when n < 0 or n > 20 
	 */
	public int factorial(int n) {
		if (n < 0) throw new IllegalArgumentException("Parameter n cannot be negative.");
		if (n > 20) throw new IllegalArgumentException("Parameter n cannot be larger than 20.");
		
		int result = 1;
        
		for (int factor = 2; factor <= n; factor++) {
            result *= factor;
        }
		
        return result;
	}
}