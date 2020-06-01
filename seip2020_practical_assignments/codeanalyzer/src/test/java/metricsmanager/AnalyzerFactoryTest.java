package metricsmanager;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;

import inputreader.InputFileFactory;
import inputreader.InputFileReader;

/**
 * A class that provides test cases for the
 * analyze_by_type method of the AnalyzerFactory class.
 * 
 * @author Irene Arapogiorgi
 */
public class AnalyzerFactoryTest {
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TYPE_UNKNOWN = "unknown-type";
	
	private static InputFileReader file_reader;
	private static String sourceFileLocation = "local";
	private final static String filepath = "src/main/resources/TestClass.java";
	
	AnalyzerFactory a_factory = new AnalyzerFactory();
	AnalyzerType type;
	
	@BeforeClass
	public static void setUp() {
		// Read source file
		InputFileFactory if_factory = new InputFileFactory();
		file_reader = if_factory.read_by_type(sourceFileLocation);
	}
	
	/*
	 * A unit test that checks the return type when TYPE_REGEX given
	 */
	@Test
	public void testAnalyzeByRegexType() {
		type = a_factory.analyze_by_type(TYPE_REGEX, file_reader, filepath);
		Assert.assertTrue(type instanceof AnalyzerType);
	}
	
	/*
	 * A unit test that checks the return type when TYPE_STRCOMP given
	 */
	@Test
	public void testAnalyzeByStrcompType() {
		type = a_factory.analyze_by_type(TYPE_STRCOMP, file_reader, filepath);
		Assert.assertTrue(type instanceof AnalyzerType);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); // Initialize it to .none()
	
	/*
	 * A test case for the exception caused when
	 * unknown analyzer type is given. Testing
	 * the exception is performed with a @Rule
	 */
	@Test 
	public void testChooseExportUnknown() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown type: " + TYPE_UNKNOWN);
		type = a_factory.analyze_by_type(TYPE_UNKNOWN, file_reader, filepath);
	}
}
