package metricsmanager;

import java.io.IOException;

/**
 * Calculates LOC (lines of code) metric.
 * 
 * @purpose This class is implemented using Bridge design pattern.
 * @author Irene Arapogiorgi
 */
public class LOCMetric extends Metrics {
	
	public LOCMetric(AnalyzerType _type) {
		super(_type);
	}
	
	@Override
	public int calculate() throws IOException {
		return this.type.calculateLOC();
	}
}
