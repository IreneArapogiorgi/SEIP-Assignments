package codeanalyzer;

import java.io.IOException;

/**
 * Calculates NOC (number of classes) metric.
 * 
 * @purpose This class is implemented using Bridge design pattern.
 * @author Irene Arapogiorgi
 */
public class NOCMetric extends Metrics {
	
	public NOCMetric(AnalyzerType _type) {
		super(_type);
	}
	
	@Override
	public int calculate() throws IOException {
		return this.type.calculateNOC();
	}
}
