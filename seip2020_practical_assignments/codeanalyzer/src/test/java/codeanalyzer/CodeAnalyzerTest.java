package codeanalyzer;

import org.junit.Test;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;

/**
 * A class that provides test cases for the
 * analyze_code method of the CodeAnalyzer class.
 * 
 * @author Irene Arapogiorgi
 */
public class CodeAnalyzerTest {
	CodeAnalyzer mockedExporter = mock(CodeAnalyzer.class);
	
	/*
	 * A unit test that checks the analyze_code method's call
	 */
	@Test
	public void testAnalyzeCode() throws IOException {
		// Create content for analyze_code method
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";
		
		// Demo of how a mocked object can call a real method (partial mocking)
		doCallRealMethod().when(mockedExporter).analyze_code(filepath, sourceCodeAnalyzerType, sourceFileLocation, outputFilePath, outputFileType);
		mockedExporter.analyze_code(filepath, sourceCodeAnalyzerType, sourceFileLocation, outputFilePath, outputFileType);
		
		// Verify that the method was executed/called
		verify(mockedExporter).analyze_code(filepath, sourceCodeAnalyzerType, sourceFileLocation, outputFilePath, outputFileType);
	}
}
