package outputexporter;

import org.junit.Test;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that provides test cases for the
 * export method of the JsonExporter class.
 * 
 * @author Irene Arapogiorgi
 */
public class JsonExporterTest {
	private final static String filepath = "any-filepath";
	
	JsonExporter mockedExporter = mock(JsonExporter.class);
	
	/*
	 * A unit test that checks the export method's call
	 */
	@Test
	public void testExport() {
		// Create an empty metrics content
		Map<String, Integer> metrics = new HashMap<>();
		
		// Demo of how a mocked object can call a real method (partial mocking)
		doCallRealMethod().when(mockedExporter).export(metrics, filepath);
		mockedExporter.export(metrics, filepath);
		
		// Verify that the method was executed/called
		verify(mockedExporter).export(metrics, filepath);
	}
}
