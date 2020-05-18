package codeanalyzer;

import java.util.Map;

/**
 * @purpose This class is implemented as an interface using Strategy design pattern.
 * @author Irene Arapogiorgi
 */
public interface OutputFileExporter {
	public void export(Map<String, Integer> metrics, String filepath);
}
