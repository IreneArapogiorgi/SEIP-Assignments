package metricsmanager;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.assertEquals;

import inputreader.InputFileFactory;
import inputreader.InputFileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A class that provides test cases for the
 * calculate_metrics method of the MetricsManagement class.
 * 
 * @author Irene Arapogiorgi
 */
public class MetricsManagementTest {
	private static Map<String, Integer> actual;
	private static String sourceCodeAnalyzerType = "regex";
	private static String sourceFileLocation = "local";
	private final static String filepath = "src/main/resources/TestClass.java";
	
	@BeforeClass
	public static void setUp() throws IOException {
		// Read source file
		InputFileFactory if_factory = new InputFileFactory();
		InputFileReader file_reader = if_factory.read_by_type(sourceFileLocation);
		
		// Calculate metrics
		AnalyzerFactory a_factory = new AnalyzerFactory();
		AnalyzerType type = a_factory.analyze_by_type(sourceCodeAnalyzerType, file_reader, filepath);
		
		Metrics loc = new LOCMetric(type);
		Metrics nom = new NOMMetric(type);
		Metrics noc = new NOCMetric(type);
		
		MetricsManagement m_mngt = new MetricsManagement();
		actual = m_mngt.calculate_metrics(loc, nom, noc);
	}
	
	/*
	 * A unit test that checks the metrics list creation
	 */
	@Test
	public void testCalculateMetrics() {		
		// Create expected metrics content
		Map<String, Integer> expected = new HashMap<>();
		
		expected.put("loc",21);
		expected.put("nom",3);
		expected.put("noc",3);
		
		assertEquals(expected, actual);
	}
}
