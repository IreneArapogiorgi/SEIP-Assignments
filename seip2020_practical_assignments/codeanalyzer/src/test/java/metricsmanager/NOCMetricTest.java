package metricsmanager;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import inputreader.InputFileFactory;
import inputreader.InputFileReader;

/**
 * A class that provides test cases for the
 * calculate method of the NOCMetric class.
 * 
 * @author Irene Arapogiorgi
 */
public class NOCMetricTest {
	private static String sourceCodeAnalyzerType = "regex";
	private static String sourceFileLocation = "local";
	private final static String filepath = "src/main/resources/TestClass.java";
	private static int actual_noc;
	
	@BeforeClass
	public static void setUp() throws IOException {
		// Read source file
		InputFileFactory if_factory = new InputFileFactory();
		InputFileReader file_reader = if_factory.read_by_type(sourceFileLocation);
		
		// Calculate metrics
		AnalyzerFactory a_factory = new AnalyzerFactory();
		AnalyzerType type = a_factory.analyze_by_type(sourceCodeAnalyzerType, file_reader, filepath);
		
		Metrics noc = new NOCMetric(type);
		actual_noc = noc.calculate();
	}
	
	/*
	 * A unit test that checks correctness of calculate method
	 */
	@Test
	public void testCalculate() {
		int expected_noc = 3;
		assertEquals(expected_noc, actual_noc);
	}
}
