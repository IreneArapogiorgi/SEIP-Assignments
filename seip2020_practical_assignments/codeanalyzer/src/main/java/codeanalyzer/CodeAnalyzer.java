package codeanalyzer;

import java.io.IOException;
import java.util.Map;

import inputreader.InputFileFactory;
import inputreader.InputFileReader;
import metricsmanager.AnalyzerType;
import metricsmanager.LOCMetric;
import metricsmanager.Metrics;
import metricsmanager.MetricsFactory;
import metricsmanager.MetricsManagement;
import metricsmanager.NOCMetric;
import metricsmanager.NOMMetric;
import outputexporter.OutputFileExporter;
import outputexporter.OutputFileFactory;

/**
 * Analyzes the contents of a Java source code file,
 * calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc = number of classes,
 * and exports a file containing them.
 * 
 * @purpose This class is implemented using Facade design pattern.
 * @author Irene Arapogiorgi
 */
public class CodeAnalyzer {
	public void analyze_code(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation,
							 String outputFilePath, String outputFileType) throws IOException {
		// Read source file
		InputFileFactory if_factory = new InputFileFactory();
		InputFileReader file_reader = if_factory.read_by_type(sourceFileLocation);
		
		// Calculate metrics
		MetricsFactory m_factory = new MetricsFactory();
		AnalyzerType type = m_factory.analyze_by_type(sourceCodeAnalyzerType, file_reader, filepath);
		
		MetricsManagement m_mngt = new MetricsManagement();
		Metrics loc = new LOCMetric(type);
		Metrics nom = new NOMMetric(type);
		Metrics noc = new NOCMetric(type);
		
		Map<String, Integer> metrics = m_mngt.calculate_metrics(loc, nom, noc);
		
		// Export output file
		OutputFileFactory of_factory = new OutputFileFactory();
		OutputFileExporter file_exporter = of_factory.choose_export(outputFileType);
		file_exporter.export(metrics, outputFilePath);
	}
}
