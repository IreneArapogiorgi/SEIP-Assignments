package metricsmanager;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import inputreader.InputFileFactory;
import inputreader.InputFileReader;

/**
 * A class that provides test cases for the
 * calculate method of the LOCMetric class.
 * 
 * @author Irene Arapogiorgi
 */
public class LOCMetricTest {
	private static String sourceCodeAnalyzerType = "regex";
	private static String sourceFileLocation = "local";
	private final static String filepath = "src/main/resources/TestClass.java";
	private static int actual_loc;
	
	@BeforeClass
	public static void setUp() throws IOException {
		// Read source file
		InputFileFactory if_factory = new InputFileFactory();
		InputFileReader file_reader = if_factory.read_by_type(sourceFileLocation);
		
		// Calculate metrics
		AnalyzerFactory a_factory = new AnalyzerFactory();
		AnalyzerType type = a_factory.analyze_by_type(sourceCodeAnalyzerType, file_reader, filepath);
		
		Metrics loc = new LOCMetric(type);
		actual_loc = loc.calculate();
	}
	
	/*
	 * A unit test that checks correctness of calculate method
	 */
	@Test
	public void testCalculate() {
		int expected_loc = 21;
		assertEquals(expected_loc, actual_loc);
	}
}
