package demo;

import java.io.IOException;

import codeanalyzer.*;

/**
 * Accepts arguments for analyzing
 * the contents of a Java source code
 * file and calculating related metrics
 * 
 * @author Irene Arapogiorgi
 */
public class DemoClient {

	public static void main(String[] args) throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";
		
		if(args.length == 5) {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}
		
		CodeAnalyzer analyzer = new CodeAnalyzer();
		analyzer.analyze_code(filepath, sourceCodeAnalyzerType, sourceFileLocation, outputFilePath, outputFileType);
	}
}
