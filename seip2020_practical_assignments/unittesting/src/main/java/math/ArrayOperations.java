package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

/**
* ArrayOperations class provides array operations
* that serve as hands-on practice on Unit Testing.
*
* @author  Irene Arapogiorgi
* @version 1.0
* @since   2020-04-16
*/
public class ArrayOperations {
	
	/**
	 * Iterates an array of numbers and returns
	 * a new one that contains only the prime ones.
	 * @param fileio the file containing numbers
	 * @param filepath the location of given file
	 * @param mymath an object of MyMath class
	 * @return an array containing prime numbers
	 */
	int[] findPrimesInFile(FileIO fileio, String filepath, MyMath mymath) {		
		List<Integer> primeNumbers = new ArrayList<>();
		
		int [] numbers = fileio.readFile(filepath);
		
		for (int number : numbers) {
			if (mymath.isPrime(number)) {
				primeNumbers.add(number);
			}
		}
		
		// Convert a List to an array using 
		return primeNumbers.stream().mapToInt(i -> i).toArray();
	}
}