package metricsmanager;

import inputreader.InputFileReader;

/**
 * Calculates metrics based on source code analyzer type.
 * 
 * The current functionality supports two types of source code
 * analysis namely regex (with the use of regular expressions)
 * and strcomp (with the use of string comparison).
 * 
 * @purpose This class is implemented using Factory design pattern.
 * @author Irene Arapogiorgi
 */
public class MetricsFactory {
	public AnalyzerType analyze_by_type(String type, InputFileReader file_reader, String filepath) {
		if (type.equals("regex")) {
			return new RegexAnalyzer(file_reader, filepath);
		} else if (type.equals("strcomp")) {
			return new StrcompAnalyzer(file_reader, filepath);
		} else {
			throw new IllegalArgumentException("Unknown type: " + type);
		}
	}
}
