package outputexporter;

/**
 * Chooses export type for output file.
 * The output type can be CSV or JSON.
 * 
 * @purpose This class is implemented using Factory design pattern.
 * @author Irene Arapogiorgi
 */
public class OutputFileFactory {
	public OutputFileExporter choose_export(String type) {
		if (type.equals("json")) {
			return new JsonExporter();
		} else if (type.equals("csv")) {
			return new CsvExporter();
		} else {
			throw new IllegalArgumentException("Unknown type: " + type);
		}
	}
}
