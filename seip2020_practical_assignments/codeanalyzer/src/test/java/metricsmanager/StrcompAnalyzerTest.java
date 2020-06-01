package metricsmanager;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import inputreader.InputFileFactory;
import inputreader.InputFileReader;

/**
 * A class that provides test cases for
 * methods of the StrcompAnalyzer class.
 * 
 * @author Irene Arapogiorgi
 */
public class StrcompAnalyzerTest {
	private static String sourceFileLocation = "local";
	private final static String filepath = "src/main/resources/TestClass.java";
	
	private static int actual_loc;
	private static int actual_nom;
	private static int actual_noc;
	
	@BeforeClass
	public static void setUp() throws IOException {
		// Read source file
		InputFileFactory if_factory = new InputFileFactory();
		InputFileReader file_reader = if_factory.read_by_type(sourceFileLocation);
		
		StrcompAnalyzer sa = new StrcompAnalyzer(file_reader, filepath);
		
		actual_loc = sa.calculateLOC();
		actual_nom = sa.calculateNOM();
		actual_noc = sa.calculateNOC();
	}
	
	/*
	 * A unit test that checks correctness of calculateLOC method
	 */
	@Test
	public void testCalculateLOC() {
		assertEquals(7, actual_loc);
	}
	
	/*
	 * A unit test that checks correctness of calculateNOM method
	 */
	@Test
	public void testCalculateNOM() {
		assertEquals(3, actual_nom);
	}
	
	/*
	 * A unit test that checks correctness of calculateNOC method
	 */
	@Test
	public void testCalculateNOC() {
		assertEquals(3, actual_noc);
	}
}
