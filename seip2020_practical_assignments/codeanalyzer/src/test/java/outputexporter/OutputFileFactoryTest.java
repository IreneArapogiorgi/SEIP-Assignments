package outputexporter;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * A class that provides test cases for the
 * choose_export method of the OutputFileFactory class.
 * 
 * @author Irene Arapogiorgi
 */
public class OutputFileFactoryTest {
	private final static String TYPE_JSON = "json";
	private final static String TYPE_CSV = "csv";
	private final static String TYPE_UNKNOWN = "unknown-type";
	
	OutputFileFactory of_factory = new OutputFileFactory();
	OutputFileExporter file_exporter;
	
	/*
	 * A unit test that checks the return type when TYPE_JSON given
	 */
	@Test
	public void testChooseExportJson() {
		file_exporter = of_factory.choose_export(TYPE_JSON);
		assertTrue(file_exporter instanceof OutputFileExporter);
	}
	
	/*
	 * A unit test that checks the return type when TYPE_CSV given
	 */
	@Test
	public void testChooseExportCsv() {
		file_exporter = of_factory.choose_export(TYPE_CSV);
		assertTrue(file_exporter instanceof OutputFileExporter);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); // Initialize it to .none()
	
	/*
	 * A test case for the exception caused when
	 * unknown exporter type is given. Testing
	 * the exception is performed with a @Rule
	 */
	@Test 
	public void testChooseExportUnknown() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown type: " + TYPE_UNKNOWN);
		file_exporter = of_factory.choose_export(TYPE_UNKNOWN);
	}
}
