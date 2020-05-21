package outputexporter;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * A class that provides test cases for the
 * export method of the CsvExporter class.
 * 
 * @author Irene Arapogiorgi
 */
public class CsvExporterTest {
	private final static String filepath = "src/test/resources/output_metrics";
	
	CsvExporter ce = new CsvExporter();
	
	/*
	 * A unit test that checks the correctness of export()
	 */
	@Test
	public void testExport() {
		// Create metrics content
		Map<String, Integer> metrics = new HashMap<>();
		
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
		
		// Write output file
		ce.export(metrics, filepath);
		
		// Evaluate that file exists
		File outputFile = new File(filepath + ".csv");
		assertTrue(outputFile.exists());
		
		// Delete generated file
		outputFile.delete();
	}
}
