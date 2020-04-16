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
	
	/**
	 * Checks if a given number n>=2 is a prime number.
	 * @param n the number we check if is prime or not
	 * @return True if n is a prime number, otherwise False
	 * @exception IllegalArgumentException when n < 2 
	 */
	public boolean isPrime(int n) {
		if (n < 2) throw new IllegalArgumentException("Parameter n cannot be smaller than 2.");
		
		int i = 2;
		boolean nonprime = false;
		
        while(i <= n/2) {
            // Condition for non-prime number
            if(n % i == 0) {
            	nonprime = true;
                break;
            }
            ++i;
        }

        if (!nonprime) {
            return true;
        } else {
            return false;
        }
	}
}