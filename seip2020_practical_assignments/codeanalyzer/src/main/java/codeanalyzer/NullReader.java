package codeanalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages null output if source file's type is neither <b>local</b> nor <b>web</b>.
 * 
 * @purpose This class is implemented using Null design pattern.
 * @author Irene Arapogiorgi
 */
public class NullReader implements InputFileReader {
	
	/**
	 * Prints error message when null type of source file
	 * @param filepath the url of the file
	 * @return an empty list
	 */
	public List<String> readFileIntoList(String filepath) {
		System.err.println("Operation aborted due to unknown file source.");
		return new ArrayList<>(); // returns empty list
	}
	
	/**
	 * Prints error message when null type of source file
	 * @param filepath the url of the file
	 * @return an empty String
	 */
	public String readFileIntoString(String filepath) {
		System.err.println("Operation aborted due to unknown file source.");
		String empty = "";
		return empty; // returns empty string
	}
}
